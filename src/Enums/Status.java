package Enums;

public enum Status {

    FINALIZADO("Finalizado"),
    FINALIZADA("Finalizada"),
    EM_ANDAMENTO("Em Andamento"),
    NAO_INICIADO("Não Iniciado"),
    NAO_INICIADA("Não Iniciada");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
