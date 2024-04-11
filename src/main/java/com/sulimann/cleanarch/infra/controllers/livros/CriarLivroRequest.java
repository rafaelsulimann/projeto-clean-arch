package com.sulimann.cleanarch.infra.controllers.livros;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.usecases.livro.criar.ICriarLivroRequest;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CriarLivroRequest implements ICriarLivroRequest{

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  private String titulo;

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @Size(max = 500, message = ErrorMessage.RESUMO_MAXIMO_500)
  private String resumo;

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  private String sumario;

  @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @DecimalMin(value = "20", message = ErrorMessage.PRECO_MINIMO_20)
  private BigDecimal preco;

  @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @Min(value = 100, message = ErrorMessage.PAGINA_MINIMA_100)
  private Integer numeroPaginas;

  @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
  private Long isbn;

  @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @Future(message = ErrorMessage.PUBLICACAO_NO_FUTURO)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate dataPublicacao;

  @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
  private Long categoria;

  @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
  private Long autor;

}
