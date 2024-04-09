package com.sulimann.cleanarch.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sulimann.cleanarch.infra.entities.AutorEntity;

public interface AutorRepository extends JpaRepository<AutorEntity, Long>{

}
