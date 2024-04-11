package com.sulimann.cleanarch.core.usecases.livro.criar;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;
import com.sulimann.cleanarch.domain.entities.IAutor;
import com.sulimann.cleanarch.domain.entities.ICategoria;
import com.sulimann.cleanarch.domain.entities.ILivro;

import jakarta.transaction.Transactional;

public abstract class ACriarLivroUseCase<LivroEntity extends ILivro, CategoriaEntity extends ICategoria, AutorEntity extends IAutor> {

  private final ICriarLivroCategoriaRepository<CategoriaEntity> criarLivroCategoriaRepository;
  private final ICriarLivroAutorRepository<AutorEntity> criarLivroAutorRepository;
  private final ICriarLivroRepository<LivroEntity> repository;
  private final ICriarLivroMapper<LivroEntity, CategoriaEntity, AutorEntity> mapper;

  protected ACriarLivroUseCase(ICriarLivroCategoriaRepository<CategoriaEntity> criarLivroCategoriaRepository,
      ICriarLivroAutorRepository<AutorEntity> criarLivroAutorRepository, ICriarLivroRepository<LivroEntity> repository,
      ICriarLivroMapper<LivroEntity, CategoriaEntity, AutorEntity> mapper) {
    this.criarLivroCategoriaRepository = criarLivroCategoriaRepository;
    this.criarLivroAutorRepository = criarLivroAutorRepository;
    this.repository = repository;
    this.mapper = mapper;
  }

  @Transactional
  public Resultado<ICriarLivroResponse, ErroResponse> execute(ICriarLivroRequest request){
    Optional<CategoriaEntity> opCategoria = this.criarLivroCategoriaRepository.findById(request.getCategoria());
    if(!opCategoria.isPresent()){
      return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), 404, ErrorMessage.CATEGORIA_NAO_ENCONTRADA, Path.LIVRO));
    }

    Optional<AutorEntity> opAutor = this.criarLivroAutorRepository.findById(request.getAutor());
    if(!opAutor.isPresent()){
      return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), 404, ErrorMessage.AUTOR_NAO_ENCONTRADO, Path.LIVRO));
    }

    boolean jaExisteLivroComMesmoTitulo = this.repository.existsByTitulo(request.getTitulo());
    if(jaExisteLivroComMesmoTitulo){
      return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), 422, ErrorMessage.TITULO_DUPLICADO, Path.LIVRO));
    }

    boolean jaExisteLivroComMesmoIsbn = this.repository.existsByIsbn(request.getIsbn());
    if(jaExisteLivroComMesmoIsbn){
      return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), 422, ErrorMessage.ISBN_DUPLICADO, Path.LIVRO));
    }

    LivroEntity livro = this.mapper.toEntity(request, opCategoria.get(), opAutor.get());
    livro = this.repository.salvar(livro);
    return Resultado.sucesso(this.mapper.toResponse(livro));
  }

}
