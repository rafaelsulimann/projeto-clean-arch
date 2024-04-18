package com.sulimann.cleanarch.core.constants;

public final class ErrorMessage {

    //VALIDAÇÕES
    public static final String CAMPO_OBRIGATORIO = "Campo obrigatório";
    public static final String PRECO_MINIMO_20 = "O preço mínimo do livro deve ser 20";
    public static final String PAGINA_MINIMA_100 = "O livro deve ter no mínimo 100 páginas";
    public static final String PUBLICACAO_NO_FUTURO = "A data de publicação do livro deve ser no futuro";
    public static final String RESUMO_MAXIMO_500 = "O resumo do livro deve contêr no máximo 500 caracteres";
    public static final String EMAIL_INVALIDO = "Email inválido";
    public static final String DESCRICAO_MAXIMA_400 = "A descrição deve contêr no máximo 400 caracteres";

    // DEFAULT ERRO 500
    public static final String ERRO_INTERNO = "Erro interno. Operação não realizada!";

    //RECURSOS NÃO ENCONTRADOS
    public static final String CATEGORIA_NAO_ENCONTRADA = "Categoria não encontrada";
    public static final String AUTOR_NAO_ENCONTRADO = "Autor não encontrado";
    public static final String LIVRO_NAO_ENCONTRADO = "Livro não encontrado";
    public static final String PAIS_NAO_ENCONTRADO = "País não encontrado";

    //RECURSOS DUPLICADO
    public static final String TITULO_DUPLICADO = "Título já existente";
    public static final String ISBN_DUPLICADO = "Isbn já existente";
    public static final String EMAIL_DUPLICADO = "Email já existente";
    public static final String NOME_DUPLICADO = "Nome já existente";
    public static final String CATEGORIA_DUPLICADA = "Categoria já existente";
    public static final String ESTADO_DUPLICADO = "Estado já existente";
    public static final String PAIS_DUPLICADO = "País já existente";

    private ErrorMessage() {
        throw new AssertionError("Não é permitido instanciar esta classe.");
    }

}
