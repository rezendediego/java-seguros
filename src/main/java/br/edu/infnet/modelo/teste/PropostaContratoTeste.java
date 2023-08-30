package br.edu.infnet.modelo.teste;

import br.edu.infnet.modelo.dominio.*;
import br.edu.infnet.modelo.dominio_enum.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PropostaContratoTeste {

    public static String validadorProposta(PropostaContrato propostaContrato, Seguro seguro){
        try{
            assertNotNull(propostaContrato.getIdContrato());
            assertEquals(seguro.getNomeSegurado(),propostaContrato.getSegurado().getNome());
            assertEquals(propostaContrato.getSeguro().getTipoSeguro(), seguro.getTipoSeguro());
        }catch(AssertionError assertionError){
            System.out.println(">>>AssertionError: Revise a proposta de Contrato: " + assertionError.getMessage());
        }

        return propostaContrato.toString();
    }
    public static void main(String[] args){
        System.out.println("### Teste de Criacao de Proposta de Contratos ###");

        //Teste Contrato de Seguro de Vida
        System.out.println("### Teste Contrato de Seguro de Vida  ###");
        Segurado seguradoJoseTeste_01 = new Segurado("José Silva",71,"25510180");
        List<String> beneficiariosJose = Arrays.asList("Maria das Dores Silva", "Joaozinho das Dores Silva");
        Seguro seguroVidaJoseSilva = new SeguroVida(seguradoJoseTeste_01.getNome(),
                true,
                LocalDateTime.now(),
                seguradoJoseTeste_01.getIdade(),
                Sexo.MASCULINO,
                beneficiariosJose,
                new BigDecimal("150000.00"));

        PropostaContrato propostaContrato_01 = new PropostaContrato(
                seguroVidaJoseSilva.getInicio(),
                seguradoJoseTeste_01,
                seguroVidaJoseSilva);

        System.out.println(validadorProposta(propostaContrato_01, seguroVidaJoseSilva));
        System.out.println("-----------------------------------------------------------");





        //Teste Contrato de Seguro de Saude
        System.out.println("### Teste Contrato de Seguro de Saude  ###");
        Segurado seguradoMariaTeste_02 = new Segurado("Maria Santos",39,"22780290");
        List<DoencasPreexistentes> doencasPreexistentesMariaSantos = new ArrayList<>();
        doencasPreexistentesMariaSantos.add(DoencasPreexistentes.CARDIOVASCULARES);
        doencasPreexistentesMariaSantos.add(DoencasPreexistentes.ENDOCRINOS);
        doencasPreexistentesMariaSantos.add(DoencasPreexistentes.PSIQUIATRICOS);

        Seguro seguroSaudeMariaSantos = new SeguroSaude(seguradoMariaTeste_02.getNome(),
                false,
                LocalDateTime.now().plusMonths(3),
                Optional.of(LocalDateTime.now().plusMonths(15)),
                seguradoMariaTeste_02.getIdade(),
                Sexo.FEMININO,
                ModalidadeSeguroSaude.REEMBOLSO,
                PeriodoCarencia.TRIMESTRAL,
                doencasPreexistentesMariaSantos);

        PropostaContrato propostaContrato_02 = new PropostaContrato(
               seguroSaudeMariaSantos.getInicio(),
                seguradoMariaTeste_02,
                seguroSaudeMariaSantos);

        System.out.println(validadorProposta(propostaContrato_02, seguroSaudeMariaSantos));
        System.out.println("-----------------------------------------------------------");



        //Teste Contrato de Seguro Residencial
        System.out.println("### Teste Contrato de Seguro Residencial  ###");
        Segurado seguradoTiquinhoSoaresTeste_03 = new Segurado("Tiquinho Soares",32,"20770001");

        Seguro seguroResidencialTiquinhoSoares = new SeguroResidencial(
                seguradoTiquinhoSoaresTeste_03.getNome(),
                true,
                LocalDateTime.now().plusMonths(6),
                TipoImovel.CASA_CONDOMINIO,
                600,
                new BigDecimal("1500000.00"));

        PropostaContrato propostaContrato_03 = new PropostaContrato(
                seguroResidencialTiquinhoSoares.getInicio(),
                seguradoTiquinhoSoaresTeste_03,
                seguroResidencialTiquinhoSoares);

        System.out.println(validadorProposta(propostaContrato_03, seguroResidencialTiquinhoSoares));
        System.out.println("-----------------------------------------------------------");
    }
}
