package com.sulimann.cleanarch.infra.controllers.livros;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.usecases.livro.criar.ICriarLivroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = Path.LIVRO)
public class CriarLivroController {

  private final CriarLivroUseCase service;

  public CriarLivroController(CriarLivroUseCase service) {
    this.service = service;
  }

  @PostMapping
  @Transactional
  public ResponseEntity<Object> criarLivro(@RequestBody @Valid CriarLivroRequest request){
    Resultado<ICriarLivroResponse, ErroResponse> resultado = this.service.execute(request);
    return resultado.isErro()
            ? ResponseEntity.status(resultado.getErro().getStatus()).body(resultado.getErro())
            : ResponseEntity.status(HttpStatus.CREATED).body(resultado.getSucesso());
  }

}
