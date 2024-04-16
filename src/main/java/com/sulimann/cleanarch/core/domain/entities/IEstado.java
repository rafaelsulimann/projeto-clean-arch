package com.sulimann.cleanarch.core.domain.entities;

public interface IEstado {
  Long getId();
  String getNome();
  IPais getPais();

  boolean pertenceAoPais(IPais pais);
}
