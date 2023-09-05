package br.edu.infnet.utilitarios.validacao;

import java.util.HashMap;
import java.util.UUID;

public class ValidadorPermissaoSeguradoFirmarContrato {
    private HashMap<UUID,Boolean> mapaSeguradosInadimplentes;

    public ValidadorPermissaoSeguradoFirmarContrato() {
        this.mapaSeguradosInadimplentes = new HashMap<UUID,Boolean>();
    }

    public HashMap<UUID, Boolean> getMapaSeguradosInadimplentes() {
        return mapaSeguradosInadimplentes;
    }

    public  Boolean getSeguradoInadimplentePorId(UUID idSegurado) {
        return this.mapaSeguradosInadimplentes.get(idSegurado);
    }

    public void setMapaSeguradosInadimplentes(UUID idSegurado, Boolean estaInadimplente) {
        this.mapaSeguradosInadimplentes.put(idSegurado,estaInadimplente);
    }
}
