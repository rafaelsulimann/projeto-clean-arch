package com.sulimann.cleanarch.core.usecases.pais.criar;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.constants.HttpStatus;
import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.domain.entities.IPais;
import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;

public abstract class ACriarPaisUseCase<PaisEntity extends IPais> {

  private final ICriarPaisRepository<PaisEntity> repository;
  private final ICriarPaisMapper<PaisEntity> mapper;

  protected ACriarPaisUseCase(ICriarPaisRepository<PaisEntity> repository, ICriarPaisMapper<PaisEntity> mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public Resultado<ICriarPaisResponse, ErroResponse> execute(ICriarPaisRequest request){
    boolean jaExistePaisComMesmoNome = this.repository.existsByNome(request.getNome());
    if(jaExistePaisComMesmoNome){
      Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), HttpStatus.UNPROCESSABLE_ENTITY, ErrorMessage.NOME_DUPLICADO, Path.PAIS));
    }
    PaisEntity entity = this.mapper.toEntity(request);
    entity = this.repository.salvar(entity);
    return Resultado.sucesso(this.mapper.toResponse(entity));
  }

}
