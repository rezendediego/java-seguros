package br.edu.infnet.teste;

import br.edu.infnet.modelo.dominio.Mensalidade;
import br.edu.infnet.modelo.dominio.Segurado;
import br.edu.infnet.modelo.dominio.SeguroResidencial;
import br.edu.infnet.modelo.dominio_enum.TipoImovel;


import java.math.BigDecimal;
import java.time.LocalDateTime;


public class FeatureDoisSeguroResidencialTeste {

    public static void main(String[] args){
        System.out.println("### Teste FEATURE 02 - Implementacao do metodo abstrato calcularMensalidade(valorBase) de Seguro Residencial ### \n");

        //Hardcoded ValorBase do Seguro Residencial
        BigDecimal valorBaseMensalidadeSeguroResidencial = new BigDecimal("4000.00");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Atual Valor BAse Mensalidade: "+valorBaseMensalidadeSeguroResidencial);
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");

        //Teste Seguro Residencial Casa
        System.out.println("### Teste Mensalidade 01 Seguro Residencial Casa  ###");
        Segurado seguradoLucasPerriTeste_01 = new Segurado("Lucas Perri",25,"20770001");
        SeguroResidencial seguroResidencial_01 = new SeguroResidencial(
                seguradoLucasPerriTeste_01.getNome(),
                true,
                LocalDateTime.now().plusMonths(1),
                TipoImovel.CASA,
                450,
                new BigDecimal("1000000.00"));

        Mensalidade mensalidadeSeguradoLucasPerriTeste_01 = seguroResidencial_01.calcularMensalidade(valorBaseMensalidadeSeguroResidencial);
        System.out.println("FEATURE_02: O valor da mensalidade 01 de Seguro Residencial será: " + mensalidadeSeguradoLucasPerriTeste_01.getValorMensalidade());
        System.out.println("-----------------------------------------------------------");


        //Teste Seguro Residencial Apartamento
        System.out.println("### Teste Mensalidade 02 Seguro Residencial Apartamento  ###");
        Segurado seguradoAdryelsonTeste_02 = new Segurado("Adryelson",25,"20770001");
        SeguroResidencial seguroResidencial_02 = new SeguroResidencial(
                seguradoAdryelsonTeste_02.getNome(),
                true,
                LocalDateTime.now().plusMonths(2),
                TipoImovel.APARTAMENTO,
                200,
                new BigDecimal("800000.00"));

        Mensalidade mensalidadeSeguradoAdryelsonTeste_02 = seguroResidencial_02.calcularMensalidade(valorBaseMensalidadeSeguroResidencial);
        System.out.println("FEATURE_02: O valor da mensalidade 02 de Seguro Residencial será: " + mensalidadeSeguradoAdryelsonTeste_02.getValorMensalidade());
        System.out.println("-----------------------------------------------------------");



        //Teste Seguro Residencial Casa Condominio
        System.out.println("### Teste Mensalidade 03 Seguro Residencial  Casa Condominio ###");
        Segurado seguradoCuestaTeste_03 = new Segurado("Cuesta",34,"20770001");
        SeguroResidencial seguroResidencial_03 = new SeguroResidencial(
                seguradoCuestaTeste_03.getNome(),
                true,
                LocalDateTime.now(),
                TipoImovel.CASA_CONDOMINIO,
                600,
                new BigDecimal("1300000.00"));

        Mensalidade mensalidadeSeguradoCuestaTeste_03 = seguroResidencial_03.calcularMensalidade(valorBaseMensalidadeSeguroResidencial);
        System.out.println("FEATURE_02: O valor da mensalidade 03 de Seguro Residencial será: " + mensalidadeSeguradoCuestaTeste_03.getValorMensalidade());



    }
}
