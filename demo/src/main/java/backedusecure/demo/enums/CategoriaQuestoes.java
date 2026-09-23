package backedusecure.demo.enums;

public enum CategoriaQuestoes {
    MULTIPLA_ESCOLHA("multiple"),
    VERDADEIRO_FALSO("boolean");

    private final String valorApi;

    CategoriaQuestoes(String valorApi) {
        this.valorApi = valorApi;
    }

    // O "Tradutor": Pega a string da API e devolve o Enum correto
    public static CategoriaQuestoes fromString(String texto) {
        for (CategoriaQuestoes tipo : CategoriaQuestoes.values()) {
            if (tipo.valorApi.equalsIgnoreCase(texto)) {
                return tipo;
            }
        }
        // Fallback de segurança caso a API mande algo novo
        throw new IllegalArgumentException("Tipo de questão desconhecido: " + texto);
    }
}