package com.sulimann.cleanarch.infra.controllers.estado.criar;

import org.springframework.stereotype.Service;

import com.sulimann.cleanarch.core.usecases.estado.criar.ACriarEstadoUseCase;
import com.sulimann.cleanarch.infra.entities.EstadoEntity;
import com.sulimann.cleanarch.infra.entities.PaisEntity;

@Service
public class CriarEstadoUseCase extends ACriarEstadoUseCase<EstadoEntity, PaisEntity>{

  protected CriarEstadoUseCase(CriarEstadoRepository repository,
      CriarEstadoMapper mapper, CriarEstadoPaisRepository paisRepository) {
    super(repository, mapper, paisRepository);
  }

}
