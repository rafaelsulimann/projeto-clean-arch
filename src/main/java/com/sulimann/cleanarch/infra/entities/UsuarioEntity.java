package com.sulimann.cleanarch.infra.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.cleanarch.core.constants.TableName;
import com.sulimann.cleanarch.domain.entities.IUsuario;
import com.sulimann.cleanarch.domain.enums.TipoUsuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = TableName.USUARIO)
@Getter
public class UsuarioEntity implements IUsuario{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String email;
  private String documento;

  @Enumerated(EnumType.STRING)
  private TipoUsuario tipo;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  private LocalDateTime dataCriacao;

  /**
  * @deprecated
  * Não utilizar! Criado por obrigação do hibernate
  */
  @Deprecated
  public UsuarioEntity(){
  }

  public UsuarioEntity(String nome, String email, String documento, TipoUsuario tipo, LocalDateTime dataCriacao) {
    this.nome = nome;
    this.email = email;
    this.documento = documento;
    this.tipo = tipo;
    this.dataCriacao = dataCriacao;
  }

}
