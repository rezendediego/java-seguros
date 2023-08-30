package br.edu.infnet.modelo.teste;

import br.edu.infnet.modelo.dominio.Mensalidade;
import br.edu.infnet.modelo.dominio.Segurado;
import br.edu.infnet.modelo.dominio.SeguroSaude;
import br.edu.infnet.modelo.dominio_enum.DoencasPreexistentes;
import br.edu.infnet.modelo.dominio_enum.ModalidadeSeguroSaude;
import br.edu.infnet.modelo.dominio_enum.PeriodoCarencia;
import br.edu.infnet.modelo.dominio_enum.Sexo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FeatureDoisSeguroSaudeTeste {
    public static void main(String[] args){
        System.out.println("### Teste FEATURE 02 - Implementacao do metodo abstrato calcularMensalidade(valorBase) de Seguro Saude ### \n");

        //Hardcoded ValorBase do Seguro Residencial
        BigDecimal valorBaseMensalidadeSeguroSaude = new BigDecimal("1500.00");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Atual Valor BAse Mensalidade: "+valorBaseMensalidadeSeguroSaude);
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");


        System.out.println("### Teste de Criacao de Seguro Saude ###");
        System.out.println("### Teste Instancia 01 ###");
        Segurado seguradoJorgeSampaoliTeste_01 = new Segurado("Jorge Sampaoli",63,"24808052");
        List<DoencasPreexistentes> doencasPreexistentesJorgeSampaoli = new ArrayList<>();
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


        Mensalidade mensalidadeseguradoJorgeSampaoliTeste_01 = seguroSaude_01.calcularMensalidade(valorBaseMensalidadeSeguroSaude);
        System.out.println("FEATURE_02: O valor da mensalidade 01 de Seguro Saude será: " + mensalidadeseguradoJorgeSampaoliTeste_01.getValorMensalidade());
        System.out.println("-----------------------------------------------------------");



        System.out.println("### Teste Instancia 02 ###");
        Segurado seguradoGabrielBarbosaTeste_02 = new Segurado("Gabriel Barbosa",26,"24808052");
        List<DoencasPreexistentes> doencasPreexistentesGabrielBarbosa = new ArrayList<>();
        doencasPreexistentesGabrielBarbosa.add(DoencasPreexistentes.NEUROLOGICOS);
        doencasPreexistentesGabrielBarbosa.add(DoencasPreexistentes.GASTROINTESTINAIS);
        doencasPreexistentesGabrielBarbosa.add(DoencasPreexistentes.PSIQUIATRICOS);


        SeguroSaude seguroSaude_02 = new SeguroSaude(seguradoGabrielBarbosaTeste_02.getNome(),
                false,
                LocalDateTime.now().plusMonths(3),
                Optional.of(LocalDateTime.now().plusMonths(15)),
                seguradoGabrielBarbosaTeste_02.getIdade(),
                Sexo.MASCULINO,
                ModalidadeSeguroSaude.COPAGAMENTO,
                PeriodoCarencia.SEMESTRAL,
                doencasPreexistentesGabrielBarbosa);


        Mensalidade mensalidadeSeguradoGabrielBarbosaTeste_02 = seguroSaude_02.calcularMensalidade(valorBaseMensalidadeSeguroSaude);
        System.out.println("FEATURE_02: O valor da mensalidade 02 de Seguro Saude será: " + mensalidadeSeguradoGabrielBarbosaTeste_02.getValorMensalidade());
        System.out.println("-----------------------------------------------------------");



        System.out.println("### Teste Instancia 03 ###");
        Segurado seguradoMariaDasDoresTeste_03 = new Segurado("Maria das Dores",70,"24808052");
        List<DoencasPreexistentes> doencasPreexistentesMariaDasDores = new ArrayList<>();
        doencasPreexistentesMariaDasDores.add(DoencasPreexistentes.NEUROLOGICOS);
        doencasPreexistentesMariaDasDores.add(DoencasPreexistentes.GASTROINTESTINAIS);
        doencasPreexistentesMariaDasDores.add(DoencasPreexistentes.PSIQUIATRICOS);
        doencasPreexistentesMariaDasDores.add(DoencasPreexistentes.GENETICOS);
        doencasPreexistentesMariaDasDores.add(DoencasPreexistentes.INFECCIOSOS);

        SeguroSaude seguroSaude_03 = new SeguroSaude(seguradoMariaDasDoresTeste_03.getNome(),
                false,
                LocalDateTime.now().plusMonths(3),
                Optional.of(LocalDateTime.now().plusMonths(15)),
                seguradoMariaDasDoresTeste_03.getIdade(),
                Sexo.FEMININO,
                ModalidadeSeguroSaude.REEMBOLSO,
                PeriodoCarencia.ANUAL,
                doencasPreexistentesMariaDasDores);


        Mensalidade mensalidadeSeguradoMariaDasDoresTeste_03 = seguroSaude_03.calcularMensalidade(valorBaseMensalidadeSeguroSaude);
        System.out.println("FEATURE_02: O valor da mensalidade 03 de Seguro Saude será: " + mensalidadeSeguradoMariaDasDoresTeste_03.getValorMensalidade());
        System.out.println("-----------------------------------------------------------");


    }

}
