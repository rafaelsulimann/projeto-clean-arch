package com.sulimann.cleanarch.core.usecases.livro.criar;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.Optional;

import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.constants.HttpStatus;
import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.domain.entities.IAutor;
import com.sulimann.cleanarch.core.domain.entities.ICategoria;
import com.sulimann.cleanarch.core.domain.entities.ILivro;
import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;
import com.sulimann.cleanarch.core.utils.validation.FluentValidation;

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
    return FluentValidation.of(request)
            .ifNotPresent("categoria", getCategoria(request.getCategoria())).thenReturn(this::erroCategoriaNaoEncontrada)
            .ifNotPresent("autor", getAutor(request.getAutor())).thenReturn(this::erroAutorNaoEncontrado)
            .ifIsTrue(tituloJaExistente(request.getTitulo())).thenReturn(this::erroTituloJaExistente)
            .ifIsTrue(isbnJaExistente(request.getIsbn())).thenReturn(this::erroIsbnJaExistente)
            .finallyExecute(this::criarLivro);
  }

  private Resultado<ICriarLivroResponse, ErroResponse> erroIsbnJaExistente() {
    return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), HttpStatus.UNPROCESSABLE_ENTITY, ErrorMessage.ISBN_DUPLICADO, Path.LIVRO));
  }

  private boolean isbnJaExistente(Long isbn) {
    return this.repository.existsByIsbn(isbn);
  }

  private Resultado<ICriarLivroResponse, ErroResponse> erroTituloJaExistente() {
    return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), HttpStatus.UNPROCESSABLE_ENTITY, ErrorMessage.TITULO_DUPLICADO, Path.LIVRO));
  }

  private boolean tituloJaExistente(String titulo) {
    return this.repository.existsByTitulo(titulo);
  }

  private Resultado<ICriarLivroResponse, ErroResponse> erroAutorNaoEncontrado() {
    return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), HttpStatus.NOT_FOUND, ErrorMessage.AUTOR_NAO_ENCONTRADO, Path.LIVRO));
  }

  private Optional<AutorEntity> getAutor(Long autorId) {
    return this.criarLivroAutorRepository.findById(autorId);
  }

  private Resultado<ICriarLivroResponse, ErroResponse> erroCategoriaNaoEncontrada() {
    return Resultado.erro(new ErroResponse(LocalDateTime.now(ZoneId.of("UTC")), HttpStatus.NOT_FOUND, ErrorMessage.CATEGORIA_NAO_ENCONTRADA, Path.LIVRO));
  }

  private Optional<CategoriaEntity> getCategoria(Long categoriaId) {
    return this.criarLivroCategoriaRepository.findById(categoriaId);
  }

  @SuppressWarnings("unchecked")
  private Resultado<ICriarLivroResponse, ErroResponse> criarLivro(ICriarLivroRequest request ,Map<String, Object> entities) {
    LivroEntity livro = this.mapper.toEntity(request, (CategoriaEntity) entities.get("categoria"), (AutorEntity) entities.get("autor"));
    livro = this.repository.salvar(livro);
    return Resultado.sucesso(this.mapper.toResponse(livro));
  }

}
