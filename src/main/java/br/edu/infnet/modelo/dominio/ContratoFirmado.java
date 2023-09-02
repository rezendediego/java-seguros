package br.edu.infnet.modelo.dominio;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ContratoFirmado {
    private UUID idContratoFirmado;
    private LocalDateTime dataContratoFirmado;
    private Segurado segurado;
    private List<Seguro> listaSeguros;

    /*
     * Feature 03 Criação de um atributo do tipo Vetor.
     **/
    private Boolean[] mensalidadesPagas;

    public ContratoFirmado(LocalDateTime dataContratoFirmado, Segurado segurado, List<Seguro> listaSeguros,Boolean[] mensalidadesPagas) {
        this.idContratoFirmado = UUID.randomUUID();
        this.dataContratoFirmado = dataContratoFirmado;
        this.segurado = segurado;
        this.listaSeguros = listaSeguros;
        this.mensalidadesPagas = mensalidadesPagas;
    }

    public UUID getIdContratoFirmado() {
        return idContratoFirmado;
    }

    public LocalDateTime getDataContratoFirmado() {
        return dataContratoFirmado;
    }

    public Segurado getSegurado() {
        return segurado;
    }

    public List<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    public Boolean[] getMensalidadesPagas() {
        return mensalidadesPagas;
    }

    public void setMensalidadesPagas(Boolean[] mensalidadesPagas) {
        this.mensalidadesPagas = mensalidadesPagas;
    }

    @Override
    public String toString() {
        return "ContratoFirmado{" +
                "idContratoFirmado=" + idContratoFirmado +
                ", dataContratoFirmado=" + dataContratoFirmado +
                ", segurado=" + segurado +
                ", listaSeguros=" + listaSeguros +
                ", mensalidadesPagas=" + Arrays.toString(mensalidadesPagas) +
                '}';
    }
}