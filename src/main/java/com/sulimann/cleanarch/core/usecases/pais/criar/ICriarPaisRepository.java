package com.sulimann.cleanarch.core.usecases.pais.criar;

import com.sulimann.cleanarch.core.domain.entities.IPais;

public interface ICriarPaisRepository<PaisEntity extends IPais> {

  PaisEntity salvar(PaisEntity entity);

  boolean existsByNome(String nome);

}
