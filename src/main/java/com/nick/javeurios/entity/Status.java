package com.nick.javeurios.entity;

public enum Status {
    DISPONIVEL("Disponível"),
    BAIXADO("Baixado"),
    CAUTELADO("Cautelado");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status fromDescricao(String descricao) {
        for (Status status : Status.values()) {
            if (status.descricao.equalsIgnoreCase(descricao)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status desconhecido: " + descricao);
    }
}
