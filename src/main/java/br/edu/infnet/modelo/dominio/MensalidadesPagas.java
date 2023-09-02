package br.edu.infnet.modelo.dominio;

import java.util.Arrays;

public class MensalidadesPagas {
    /*
     * Feature 03 Criação de um atributo do tipo vetor.
     **/
    private Boolean[] vetorMensalidadesPagas;

    public MensalidadesPagas(int numMeses) {
        this.vetorMensalidadesPagas = new Boolean[numMeses];
        Arrays.fill(vetorMensalidadesPagas, false);
    }

    public Boolean[] getVetorMensalidadesPagas() {
        return vetorMensalidadesPagas;
    }

    public void setVetorMensalidadesPagas(Boolean[] vetorMensalidadesPagas) {
        this.vetorMensalidadesPagas = vetorMensalidadesPagas;
    }

    @Override
    public String toString() {
        return "MensalidadesPagas{" +
                "vetorMensalidadesPagas=" + Arrays.toString(vetorMensalidadesPagas) +
                '}';
    }
}
