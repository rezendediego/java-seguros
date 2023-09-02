package br.edu.infnet.teste;

import br.edu.infnet.modelo.dominio.Segurado;
import br.edu.infnet.modelo.dominio.SeguroSaude;
import br.edu.infnet.modelo.dominio_enum.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SeguroSaudeTeste {
    public static String validadorSeguroSaude(SeguroSaude seguroSaude, Segurado segurado ){
        try{
            assertNotNull(seguroSaude.getIdSeguro());
            assertEquals(seguroSaude.getNomeSegurado(),segurado.getNome());
            assertEquals(seguroSaude.getTipoSeguro(), TipoSeguro.SEGURO_SAUDE);
        }catch(AssertionError assertionError){
            System.out.println(">>>AssertionError: Revise a proposta de Contrato: " + assertionError.getMessage());
        }

        return seguroSaude.toString();
    }
    public static void main(String[] args){
        System.out.println("### Teste de Criacao de Seguro Saude ###");
        System.out.println("### Teste Instancia 01 ###");
        Segurado seguradoJorgeSampaoliTeste_01 = new Segurado("Jorge Sampaoli",63,"24808052");
        List<DoencasPreexistentes> doencasPreexistentesJorgeSampaoli = new ArrayList<>();
        doencasPreexistentesJorgeSampaoli.add(DoencasPreexistentes.CARDIOVASCULARES);
        doencasPreexistentesJorgeSampaoli.add(DoencasPreexistentes.GASTROINTESTINAIS);
        doencasPreexistentesJorgeSampaoli.add(DoencasPreexistentes.PSIQUIATRICOS);

        SeguroSaude seguroSaude_01 = new SeguroSaude(seguradoJorgeSampaoliTeste_01.getNome(),
                false,
                LocalDateTime.now().plusMonths(3),
                Optional.of(LocalDateTime.now().plusMonths(15)),
                seguradoJorgeSampaoliTeste_01.getIdade(),
                Sexo.MASCULINO,
                ModalidadeSeguroSaude.REEMBOLSO,
                PeriodoCarencia.TRIMESTRAL,
                doencasPreexistentesJorgeSampaoli);


        System.out.println(validadorSeguroSaude(seguroSaude_01,seguradoJorgeSampaoliTeste_01));
        System.out.println("-----------------------------------------------------------");



        System.out.println("### Teste Instancia 02 ###");
        Segurado seguradoGabrielBarbosaTeste_02 = new Segurado("Gabriel Barbosa",26,"24808052");
        List<DoencasPreexistentes> doencasPreexistentesGabrielBarbosa = new ArrayList<>();
        doencasPreexistentesGabrielBarbosa.add(DoencasPreexistentes.NEUROLOGICOS);
        doencasPreexistentesGabrielBarbosa.add(DoencasPreexistentes.GASTROINTESTINAIS);
        doencasPreexistentesGabrielBarbosa.add(DoencasPreexistentes.PSIQUIATRICOS);
        doencasPreexistentesGabrielBarbosa.add(DoencasPreexistentes.IMUNOLOGICOS);

        SeguroSaude seguroSaude_02 = new SeguroSaude(seguradoGabrielBarbosaTeste_02.getNome(),
                false,
                LocalDateTime.now().plusMonths(3),
                Optional.of(LocalDateTime.now().plusMonths(15)),
                seguradoGabrielBarbosaTeste_02.getIdade(),
                Sexo.MASCULINO,
                ModalidadeSeguroSaude.COPAGAMENTO,
                PeriodoCarencia.SEMESTRAL,
                doencasPreexistentesGabrielBarbosa);


        System.out.println(validadorSeguroSaude(seguroSaude_02,seguradoGabrielBarbosaTeste_02));
        System.out.println("-----------------------------------------------------------");



        System.out.println("### Teste Instancia 03 ###");
        Segurado seguradoArthurAntunesTeste_03 = new Segurado("Arthur Antunes Zico",70,"24808052");
        List<DoencasPreexistentes> doencasPreexistentesArthurAntunes = new ArrayList<>();
        doencasPreexistentesArthurAntunes.add(DoencasPreexistentes.NEUROLOGICOS);
        doencasPreexistentesArthurAntunes.add(DoencasPreexistentes.GASTROINTESTINAIS);
        doencasPreexistentesArthurAntunes.add(DoencasPreexistentes.PSIQUIATRICOS);

        SeguroSaude seguroSaude_03 = new SeguroSaude(seguradoArthurAntunesTeste_03.getNome(),
                false,
                LocalDateTime.now().plusMonths(3),
                Optional.of(LocalDateTime.now().plusMonths(15)),
                seguradoArthurAntunesTeste_03.getIdade(),
                Sexo.MASCULINO,
                ModalidadeSeguroSaude.REEMBOLSO,
                PeriodoCarencia.ANUAL,
                doencasPreexistentesArthurAntunes);


        System.out.println(validadorSeguroSaude(seguroSaude_03,seguradoArthurAntunesTeste_03));
        System.out.println("-----------------------------------------------------------");


    }
}
