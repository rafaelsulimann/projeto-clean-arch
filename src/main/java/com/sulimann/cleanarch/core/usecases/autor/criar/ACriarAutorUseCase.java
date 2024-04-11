package com.sulimann.cleanarch.core.usecases.autor.criar;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.constants.HttpStatus;
import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.domain.entities.IAutor;
import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;

import jakarta.transaction.Transactional;

public abstract class ACriarAutorUseCase<AutorEntity extends IAutor> {

  private final ICriarAutorMapper<AutorEntity> mapper;
  private final ICriarAutorRepository<AutorEntity> repository;

  protected ACriarAutorUseCase(ICriarAutorMapper<AutorEntity> mapper, ICriarAutorRepository<AutorEntity> repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  @Transactional
  public Resultado<ICriarAutorResponse, ErroResponse> execute(ICriarAutorRequest request){
    boolean jaExisteAutorComMesmoEmail = this.repository.existsByEmail(request.getEmail());
    if(jaExisteAutorComMesmoEmail){
      return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), HttpStatus.UNPROCESSABLE_ENTITY, ErrorMessage.EMAIL_DUPLICADO, Path.AUTOR));
    }

    AutorEntity entity = this.mapper.toEntity(request);
    entity = this.repository.salvar(entity);
    return Resultado.sucesso(this.mapper.toResponse(entity));
  }

}
