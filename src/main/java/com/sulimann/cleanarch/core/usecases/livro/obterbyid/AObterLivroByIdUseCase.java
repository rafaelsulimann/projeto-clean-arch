package com.sulimann.cleanarch.core.usecases.livro.obterbyid;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.constants.HttpStatus;
import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.domain.entities.ILivro;
import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;

public class AObterLivroByIdUseCase<LivroEntity extends ILivro>{

  private final IObterLivroByIdRepository<LivroEntity> repository;
  private final IObterLivroByIdMapper<LivroEntity> mapper;

  protected AObterLivroByIdUseCase(IObterLivroByIdRepository<LivroEntity> repository, IObterLivroByIdMapper<LivroEntity> mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public Resultado<IObterLivroByIdResponse, ErroResponse> execute(Long id){
    Optional<LivroEntity> livro = this.repository.findById(id);
    if(!livro.isPresent()){
      return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), HttpStatus.NOT_FOUND, ErrorMessage.LIVRO_NAO_ENCONTRADO, Path.LIVRO));
    }

    return Resultado.sucesso(this.mapper.toResponse(livro.get()));
  }

}
