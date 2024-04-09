package com.sulimann.cleanarch.infra.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.cleanarch.core.constants.TableName;
import com.sulimann.cleanarch.domain.entities.IAutor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = TableName.AUTOR)
@Getter
public class AutorEntity implements IAutor{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String email;
  private String descricao;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  private LocalDateTime dataCriacao;

  /**
  * @deprecated
  * Não utilizar! Criado por obrigação do hibernate
  */
  @Deprecated
  public AutorEntity(){
  }

  public AutorEntity(String nome, String email, String descricao, LocalDateTime dataCriacao) {
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
    this.dataCriacao = dataCriacao;
  }

}
