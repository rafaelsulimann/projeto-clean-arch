package com.sulimann.cleanarch.core.usecases.estado.criar;

import com.sulimann.cleanarch.core.domain.entities.IEstado;
import com.sulimann.cleanarch.core.domain.entities.IPais;

public interface ICriarEstadoMapper<EstadoEntity extends IEstado, PaisEntity extends IPais> {

  EstadoEntity toEntity(ICriarEstadoRequest request, PaisEntity pais);
  ICriarEstadoResponse toResponse(EstadoEntity estado);

}
