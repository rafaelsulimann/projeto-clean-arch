package com.sulimann.cleanarch.infra.controllers.livros.obterbyid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.usecases.livro.obterbyid.IObterLivroByIdResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;

@RestController
@RequestMapping(value = Path.LIVRO)
public class ObterLivroByIdController {

  private final ObterLivroByIdUseCase service;

  public ObterLivroByIdController(ObterLivroByIdUseCase service) {
    this.service = service;
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Object> obterLivroById(@PathVariable Long id){
    Resultado<IObterLivroByIdResponse, ErroResponse> resultado = this.service.execute(id);
    return resultado.isErro()
            ? ResponseEntity.status(resultado.getErro().getStatus()).body(resultado.getErro())
            : ResponseEntity.status(HttpStatus.OK).body(resultado.getSucesso());

  }
}
