package com.sulimann.cleanarch.core.usecases.estado.criar;

import java.util.Optional;

import com.sulimann.cleanarch.core.domain.entities.IPais;

public interface ICriarEstadoPaisRepository<PaisEntity extends IPais> {

  Optional<PaisEntity> findById(Long paisId);

}
