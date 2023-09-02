package br.edu.infnet.servico;

import br.edu.infnet.modelo.dominio.ContratoFirmado;
import br.edu.infnet.modelo.dominio.MensalidadesPagas;
import br.edu.infnet.modelo.dominio.PropostaContrato;
import br.edu.infnet.modelo.dominio.Segurado;
import br.edu.infnet.modelo.dominio_enum.TempoContrato;
import br.edu.infnet.repositorio.ContratoFirmadoRepository;

import java.time.LocalDateTime;
import java.util.Arrays;

import static br.edu.infnet.repositorio.ContratoFirmadoRepository.inicializarContratoFirmadoRepository;

public class FirmarContratoService {

    private ContratoFirmado contratoFirmado;


    public ContratoFirmado firmarContrato(PropostaContrato propostaContrato){
        ContratoFirmadoRepository.inicializarContratoFirmadoRepository();
        this.contratoFirmado = new ContratoFirmado(
                        LocalDateTime.now(),
                        propostaContrato.getSegurado(),
                        propostaContrato.getListaSeguro(),
                        inicializaVetorMensalidadesPagas(verificaTempoContrato(propostaContrato)));
        if(salvarContratoFirmado(this.contratoFirmado)){
            return this.contratoFirmado;
        }else return null;
    }


    private int verificaTempoContrato(PropostaContrato propostaContrato){
        if(propostaContrato.getTempoContrato().equals(TempoContrato.TRIMESTRAL)){
            return 3;
        } else if(propostaContrato.getTempoContrato().equals(TempoContrato.SEMESTRAL)){
            return 6;
        } else return 12;
    }

    private Boolean[] inicializaVetorMensalidadesPagas(int tempoContrato){
        MensalidadesPagas mensalidadesPagas = new MensalidadesPagas(tempoContrato);
        return mensalidadesPagas.getVetorMensalidadesPagas();
    }

    private Boolean salvarContratoFirmado(ContratoFirmado contratoFirmado){
        return ContratoFirmadoRepository.salvar(contratoFirmado);
    }
}
