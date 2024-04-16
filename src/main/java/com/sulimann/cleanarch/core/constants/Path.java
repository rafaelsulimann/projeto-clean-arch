package com.sulimann.cleanarch.core.constants;

public final class Path {

    public static final String AUTOR = "/autores";
    public static final String CATEGORIA = "/categorias";
    public static final String LIVRO = "/livros";
    public static final String PAIS = "/paises";

    private Path() {
        throw new AssertionError("Não é permitido instanciar esta classe.");
    }

}
