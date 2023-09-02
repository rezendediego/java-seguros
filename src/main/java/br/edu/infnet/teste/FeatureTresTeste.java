package br.edu.infnet.teste;

import br.edu.infnet.modelo.dominio.*;
import br.edu.infnet.modelo.dominio_enum.*;
import br.edu.infnet.repositorio.ContratoFirmadoRepository;
import br.edu.infnet.servico.FirmarContratoService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Criação de um atributo do tipo vetor.(MensalidadesPagas possui um vetor de Boolean para armazenar status pagamento )
* o Criação de um atributo do tipo Set.(ContratoFirmadoRepository, contratos firmados sao unicos e armazenados em um Hashset)
* o Criação do relacionamento entre a classe principal e a mãe com List.(PropostaContrato possui uma Lista de Seguro)
* */
public class FeatureTresTeste {
    public static void main(String[] args){
        FirmarContratoService firmarContratoService = new FirmarContratoService();


        //Criacao Segurado 01 = Jose Silva
        Segurado segurado_01_JoseSilva = new Segurado("José Silva", 70,"25510180");
        //Criacao de Lista de Doencas Preexistentes para Seguro Saude
        List<DoencasPreexistentes> doencasPreexistentesJoseSilva = new ArrayList<>();
        doencasPreexistentesJoseSilva.add(DoencasPreexistentes.CARDIOVASCULARES);
        doencasPreexistentesJoseSilva.add(DoencasPreexistentes.MUSCULOESQUELETICOS);
        doencasPreexistentesJoseSilva.add(DoencasPreexistentes.IMUNOLOGICOS);
        doencasPreexistentesJoseSilva.add(DoencasPreexistentes.ENDOCRINOS);
        doencasPreexistentesJoseSilva.add(DoencasPreexistentes.RESPIRATORIOS);

        //Criacao de Seguro Saude para Jose Silva
        Seguro seguroSaudeJoseSilva = new SeguroSaude(
                segurado_01_JoseSilva.getNome(),
                true,
                LocalDateTime.now(),
                segurado_01_JoseSilva.getIdade(),
                Sexo.MASCULINO,
                ModalidadeSeguroSaude.REEMBOLSO,
                PeriodoCarencia.TRIMESTRAL,
                doencasPreexistentesJoseSilva);

        //Criacao de Seguro VIda para Jose Silva
        Seguro seguroVidaJoseSilva =  new SeguroVida(
                segurado_01_JoseSilva.getNome(),
                true,
                LocalDateTime.now(),
                segurado_01_JoseSilva.getIdade(),
                Sexo.MASCULINO,
                Arrays.asList("Jose Silva Filho", "Maria das Dores Silva"),
                new BigDecimal("480000"));

        //Criacao de Lista de Seguros de JOse Silva
        List<Seguro> listaSeguroJoseSilva = new ArrayList<>();
        listaSeguroJoseSilva.add(seguroSaudeJoseSilva);
        listaSeguroJoseSilva.add(seguroVidaJoseSilva);

        //Consolidacao de proposta de contrato para o Segurado Jose Silva
        PropostaContrato propostaContrato_01_JoseSilva = new PropostaContrato(
                LocalDateTime.now(),
                segurado_01_JoseSilva,
                TempoContrato.ANUAL,
                listaSeguroJoseSilva);


        //Firmar Contrato José Silva
        ContratoFirmado contratoFirmado_01_JoseSilva = firmarContratoService.firmarContrato(propostaContrato_01_JoseSilva);

        System.out.println("### TESTING FEATURE 03 - TIPO VETOR ###");
        System.out.println(">>>: IMPRIMINDO Atributo Mensalidades Pagas (tipo Vetor): " + Arrays.toString(contratoFirmado_01_JoseSilva.getMensalidadesPagas()));
        System.out.println(">>>: CONFIGURANDO primeira mensalidade paga ...");
        Boolean[] mensalidadesPagasJoseSilva= new Boolean[12];
        Arrays.fill(mensalidadesPagasJoseSilva,false);
        mensalidadesPagasJoseSilva[0] = true;
        contratoFirmado_01_JoseSilva.setMensalidadesPagas(mensalidadesPagasJoseSilva);

        System.out.println(">>>: IMPRIMINDO ATUALIZAÇÃO Atributo Mensalidades Pagas (tipo Vetor): " + Arrays.toString(contratoFirmado_01_JoseSilva.getMensalidadesPagas()));

        System.out.println("--------------------------------------------------------------------");

        System.out.println("### TESTING FEATURE 03 - TIPO SET ###");
        System.out.println(">>>: REPOSITORY RELATORIO Contrato firmado Anteriormente foi salvo no HashSet: " + ContratoFirmadoRepository.existeContratoSalvo(contratoFirmado_01_JoseSilva));
        System.out.println(">>>: REPOSITORY RELATORIO Todos os Contratos firmados salvos no HashSet:\n" + ContratoFirmadoRepository.getAllContratosFirmados());

        System.out.println("--------------------------------------------------------------------");
        System.out.println("### TESTING FEATURE 03 - CRIAÇÃO DO RELACIONAMENTO ENTRE A CLASSE PRINCIPAL E A MÃE COM LIST ###");
        System.out.println(">>>: CLASSE PRINCIPAL PropostaContrato possui um atributo List<Seguro> que relaciona PropostaContrato com a Classe Seguro que é a CLASSE MAE ABSTRATA: ");
        System.out.println(">>>: CLASSE PRINCIPAL PropostaContrato completa:\n" + propostaContrato_01_JoseSilva.toString() );
        System.out.println("\n \n>>>: CLASSE PRINCIPAL PropostaContrato atributo List<Seguro>:\n" + propostaContrato_01_JoseSilva.getListaSeguro());

    }
}
