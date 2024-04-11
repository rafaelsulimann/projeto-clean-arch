package com.sulimann.cleanarch.infra.entities;

import com.sulimann.cleanarch.core.constants.TableName;
import com.sulimann.cleanarch.core.domain.entities.ICategoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = TableName.CATEGORIA)
@Getter
public class CategoriaEntity implements ICategoria{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  /**
  * @deprecated
  * Não utilizar! Criado por obrigação do hibernate
  */
  @Deprecated
  public CategoriaEntity(){
  }

  public CategoriaEntity(String nome) {
    this.nome = nome;
  }

}
