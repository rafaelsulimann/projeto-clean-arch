package com.sulimann.cleanarch.infra.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.sulimann.cleanarch.core.constants.TableName;
import com.sulimann.cleanarch.core.domain.entities.ILivro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = TableName.LIVRO)
@Getter
public class LivroEntity implements ILivro{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String resumo;
  private String sumario;
  private BigDecimal preco;
  private Integer numeroPaginas;
  private Long isbn;
  private LocalDate dataPublicacao;

  @ManyToOne
  @JoinColumn(name = "categoria_id")
  private CategoriaEntity categoria;

  @ManyToOne
  @JoinColumn(name = "autor_id")
  private AutorEntity autor;

  public LivroEntity(){
  }

  public LivroEntity(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, Long isbn,
      LocalDate dataPublicacao, CategoriaEntity categoria, AutorEntity autor) {
    this.titulo = titulo;
    this.resumo = resumo;
    this.sumario = sumario;
    this.preco = preco;
    this.numeroPaginas = numeroPaginas;
    this.isbn = isbn;
    this.dataPublicacao = dataPublicacao;
    this.categoria = categoria;
    this.autor = autor;
  }

}
