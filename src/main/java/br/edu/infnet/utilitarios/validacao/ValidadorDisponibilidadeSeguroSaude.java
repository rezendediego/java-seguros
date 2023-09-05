package br.edu.infnet.utilitarios.validacao;

public class ValidadorDisponibilidadeSeguroSaude {
    private Boolean disponibilidade;

    public ValidadorDisponibilidadeSeguroSaude(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
