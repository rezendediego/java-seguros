package br.edu.infnet.repositorio;

import br.edu.infnet.modelo.dominio.ContratoFirmado;

import java.util.HashSet;

public class ContratoFirmadoRepository {
    /*
     * Feature 03 Criação de um atributo do tipo Set.
     **/
    private static HashSet<ContratoFirmado> contratoFirmadoSet;


    public static void inicializarContratoFirmadoRepository() {

        contratoFirmadoSet = new HashSet<ContratoFirmado>();
    }

    public static Boolean salvar(ContratoFirmado contratoFirmado) {
        contratoFirmadoSet.add(contratoFirmado);
        return contratoFirmadoSet.contains(contratoFirmado);
    }

    public static HashSet<ContratoFirmado> getAllContratosFirmados(){
        return contratoFirmadoSet;
    }

    public static Boolean existeContratoSalvo(ContratoFirmado contratoFirmado){
        return contratoFirmadoSet.contains(contratoFirmado);
    }

}
