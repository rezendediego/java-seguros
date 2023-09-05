package br.edu.infnet.utilitarios.validacao;

public class ValidadorDisponibilidadeSeguroResidencial {
    private Boolean disponibilidade;

    public ValidadorDisponibilidadeSeguroResidencial(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
