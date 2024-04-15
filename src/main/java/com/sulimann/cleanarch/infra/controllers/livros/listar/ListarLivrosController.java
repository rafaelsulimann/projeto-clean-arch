package com.sulimann.cleanarch.infra.controllers.livros.listar;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.usecases.livro.listar.IListarLivrosResponse;
import com.sulimann.cleanarch.core.utils.page.IPage;
import com.sulimann.cleanarch.infra.adapters.paginacao.PageableWrapper;

@RestController
@RequestMapping(value = Path.LIVRO)
public class ListarLivrosController {

  private final ListarLivrosUseCase service;

  public ListarLivrosController(ListarLivrosUseCase service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<IPage<IListarLivrosResponse>> listarLivros(ListarLivrosSpec spec, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
    return ResponseEntity.status(HttpStatus.OK).body(this.service.execute(spec, new PageableWrapper(pageable)));
  }


}
