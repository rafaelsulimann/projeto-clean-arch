package com.sulimann.cleanarch.core.constants;

public final class HttpStatus {

  public static final Integer NOT_FOUND = 404;
  public static final Integer UNPROCESSABLE_ENTITY = 422;

  private HttpStatus() {
      throw new AssertionError("Não é permitido instanciar esta classe.");
  }

}
