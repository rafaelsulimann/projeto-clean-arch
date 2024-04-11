package com.sulimann.cleanarch.core.constants;

public final class TableName {

    public static final String AUTOR = "tb_autores";
    public static final String CATEGORIA = "tb_categorias";
    public static final String LIVRO = "tb_livros";

    private TableName() {
        throw new AssertionError("Não é permitido instanciar esta classe.");
    }

}
