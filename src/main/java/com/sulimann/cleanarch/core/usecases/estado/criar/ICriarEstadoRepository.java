package com.sulimann.cleanarch.core.usecases.estado.criar;

import com.sulimann.cleanarch.core.domain.entities.IEstado;

public interface ICriarEstadoRepository<EstadoEntity extends IEstado> {

  EstadoEntity salvar(EstadoEntity estado);
  boolean existsByNome(String nome);

}
