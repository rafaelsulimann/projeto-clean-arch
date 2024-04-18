package com.sulimann.cleanarch.core.usecases.pais.criar;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.constants.HttpStatus;
import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.domain.entities.IPais;
import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;
import com.sulimann.cleanarch.core.utils.validation.FluentValidation;

import jakarta.transaction.Transactional;

public abstract class ACriarPaisUseCase<PaisEntity extends IPais> {

  private final ICriarPaisRepository<PaisEntity> repository;
  private final ICriarPaisMapper<PaisEntity> mapper;

  protected ACriarPaisUseCase(ICriarPaisRepository<PaisEntity> repository, ICriarPaisMapper<PaisEntity> mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Transactional
  public Resultado<ICriarPaisResponse, ErroResponse> execute(ICriarPaisRequest request){
    return FluentValidation.of(request)
            .ifIsTrue(paisJaExistente(request.getNome())).thenReturn(this::erroPaisJaExistente)
            .finallyExecute(this::criarPais);
  }

  private Resultado<ICriarPaisResponse, ErroResponse> criarPais(ICriarPaisRequest request) {
    PaisEntity entity = this.mapper.toEntity(request);
    entity = this.repository.salvar(entity);
    return Resultado.sucesso(this.mapper.toResponse(entity));
  }

  private Resultado<ICriarPaisResponse, ErroResponse> erroPaisJaExistente() {
    return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), HttpStatus.UNPROCESSABLE_ENTITY, ErrorMessage.PAIS_DUPLICADO, Path.PAIS));
  }

  private boolean paisJaExistente(String nome) {
    return this.repository.existsByNome(nome);
  }

}
