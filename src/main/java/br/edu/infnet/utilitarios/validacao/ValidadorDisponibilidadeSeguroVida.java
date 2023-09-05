package br.edu.infnet.utilitarios.validacao;

public class ValidadorDisponibilidadeSeguroVida {

    private Boolean disponibilidade;

    public ValidadorDisponibilidadeSeguroVida(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
