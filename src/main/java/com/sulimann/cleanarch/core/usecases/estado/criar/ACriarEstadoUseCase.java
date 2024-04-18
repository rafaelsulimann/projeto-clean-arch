package com.sulimann.cleanarch.core.usecases.estado.criar;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.Optional;

import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.constants.HttpStatus;
import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.domain.entities.IEstado;
import com.sulimann.cleanarch.core.domain.entities.IPais;
import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;
import com.sulimann.cleanarch.core.utils.validation.FluentValidation;

import jakarta.transaction.Transactional;

public abstract class ACriarEstadoUseCase<EstadoEntity extends IEstado, PaisEntity extends IPais> {

  private final ICriarEstadoRepository<EstadoEntity> repository;
  private final ICriarEstadoMapper<EstadoEntity, PaisEntity> mapper;
  private final ICriarEstadoPaisRepository<PaisEntity> paisRepository;

  protected ACriarEstadoUseCase(ICriarEstadoRepository<EstadoEntity> repository, ICriarEstadoMapper<EstadoEntity, PaisEntity> mapper, ICriarEstadoPaisRepository<PaisEntity> paisRepository) {
    this.repository = repository;
    this.mapper = mapper;
    this.paisRepository = paisRepository;
  }

  @Transactional
  public Resultado<ICriarEstadoResponse, ErroResponse> execute(ICriarEstadoRequest request){
    return FluentValidation.of(request)
            .ifIsTrue(estadoJaExistente(request.getNome())).thenReturn(this::erroEstadoJaExistente)
            .ifNotPresent("pais", getPais(request.getPaisId())).thenReturn(this::erroPaisNaoEncontrado)
            .finallyExecute(this::criarEstado);
  }

  private boolean estadoJaExistente(String nome) {
    return this.repository.existsByNome(nome);
  }

  private Optional<PaisEntity> getPais(Long paisId) {
    return this.paisRepository.findById(paisId);
  }

  private Resultado<ICriarEstadoResponse, ErroResponse> erroPaisNaoEncontrado(){
    return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), HttpStatus.NOT_FOUND, ErrorMessage.PAIS_NAO_ENCONTRADO, Path.ESTADO));
  }

  private Resultado<ICriarEstadoResponse, ErroResponse> erroEstadoJaExistente(){
    return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), HttpStatus.UNPROCESSABLE_ENTITY, ErrorMessage.ESTADO_DUPLICADO, Path.ESTADO));
  }

  @SuppressWarnings("unchecked")
  private Resultado<ICriarEstadoResponse, ErroResponse> criarEstado(ICriarEstadoRequest request, Map<String, Object> entities){
    EstadoEntity estado = this.mapper.toEntity(request, (PaisEntity) entities.get("pais"));
    estado = this.repository.salvar(estado);
    return Resultado.sucesso(this.mapper.toResponse(estado));
  }

}
