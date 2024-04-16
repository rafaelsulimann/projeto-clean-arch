package com.sulimann.cleanarch.core.usecases.pais.criar;

import com.sulimann.cleanarch.core.domain.entities.IPais;

public interface ICriarPaisMapper<PaisEntity extends IPais> {

  PaisEntity toEntity(ICriarPaisRequest request);
  ICriarPaisResponse toResponse(PaisEntity entity);

}
