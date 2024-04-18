package com.sulimann.cleanarch.core.usecases.categoria.criar;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.constants.HttpStatus;
import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.domain.entities.ICategoria;
import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;
import com.sulimann.cleanarch.core.utils.validation.FluentValidation;

import jakarta.transaction.Transactional;

public abstract class ACriarCategoriaUseCase<CategoriaEntity extends ICategoria> {

  private final ICriarCategoriaMapper<CategoriaEntity> mapper;
  private final ICriarCategoriaRespository<CategoriaEntity> repository;

  protected ACriarCategoriaUseCase(ICriarCategoriaMapper<CategoriaEntity> mapper, ICriarCategoriaRespository<CategoriaEntity> repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  @Transactional
  public Resultado<ICriarCategoriaResponse, ErroResponse> execute(ICriarCategoriaRequest request){
    return FluentValidation.of(request)
            .ifIsTrue(categoriaJaExistente(request.getNome())).thenReturn(this::erroCategoriaJaExistente)
            .finallyExecute(this::criarCategoria);
  }

  private boolean categoriaJaExistente(String nome) {
    return this.repository.existsByNome(nome);
  }

  private Resultado<ICriarCategoriaResponse, ErroResponse> erroCategoriaJaExistente(){
    return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), HttpStatus.UNPROCESSABLE_ENTITY, ErrorMessage.CATEGORIA_DUPLICADA, Path.CATEGORIA));
  }

  private Resultado<ICriarCategoriaResponse, ErroResponse> criarCategoria(ICriarCategoriaRequest request){
    CategoriaEntity entity = this.mapper.toEntity(request);
    entity = this.repository.salvar(entity);
    return Resultado.sucesso(this.mapper.toResponse(entity));
  }
}
