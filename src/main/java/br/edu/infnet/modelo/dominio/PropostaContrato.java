package br.edu.infnet.modelo.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

public class PropostaContrato {
    private UUID idContrato;
    private LocalDateTime dataPropostaContrato;
    private final Segurado segurado;
    private Seguro seguro;

    public PropostaContrato(LocalDateTime dataPropostaContrato, Segurado segurado, Seguro seguro) {
        this.idContrato = UUID.randomUUID();
        this.dataPropostaContrato = dataPropostaContrato;
        this.segurado = segurado;
        this.seguro = seguro;
    }

    public UUID getIdContrato() {
        return idContrato;
    }

    public LocalDateTime getDataPropostaContrato() {
        return dataPropostaContrato;
    }

    public Segurado getSegurado() {
        return segurado;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    @Override
    public String toString() {
        return "PropostaContrato{" + "\n" +
                "idContrato=" + idContrato + "\n" +
                ", dataPropostaContrato=" + dataPropostaContrato + "\n" +
                ", segurado=" + segurado + "\n" +
                ", seguro=" + seguro +
                '}';
    }
}
