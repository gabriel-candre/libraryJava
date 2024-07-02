package Enums;

public enum Disponibilidade {

    DISPONIVEL("Disponível"),
    INDISPONIVEL("Indisponível"),
    ALUGADO("Alugado");

    private String descricao;

    Disponibilidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
