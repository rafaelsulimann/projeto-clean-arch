package com.sulimann.cleanarch.core.usecases.estado.criar;

public interface ICriarEstadoResponse {
  Long getId();
  String getNome();
  ICriarEstadoPaisResponse getPais();
}
