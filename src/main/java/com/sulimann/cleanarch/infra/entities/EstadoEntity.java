package com.sulimann.cleanarch.infra.entities;

import com.sulimann.cleanarch.core.constants.TableName;
import com.sulimann.cleanarch.core.domain.entities.IEstado;
import com.sulimann.cleanarch.core.domain.entities.IPais;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = TableName.ESTADO)
@Getter
public class EstadoEntity implements IEstado{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @ManyToOne
  @JoinColumn(name = "pais_id")
  private PaisEntity pais;

  /**
  * @deprecated
  * Não utilizar! Criado por obrigação do hibernate
  */
  @Deprecated
  public EstadoEntity(){
  }

  public EstadoEntity(String nome, PaisEntity pais) {
    this.nome = nome;
    this.pais = pais;
  }

  @Override
  public boolean pertenceAoPais(IPais pais) {
    return this.pais.equals(pais);
  }

}
