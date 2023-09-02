package br.edu.infnet.teste;

import br.edu.infnet.modelo.dominio.Mensalidade;
import br.edu.infnet.modelo.dominio.Segurado;
import br.edu.infnet.modelo.dominio.SeguroVida;
import br.edu.infnet.modelo.dominio_enum.Sexo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FeatureDoisSeguroVidaTeste {
    public static void main(String[] args){
        System.out.println("### Teste FEATURE 02 - Implementacao do metodo abstrato calcularMensalidade(valorBase) de Seguro Vida ### \n");

        //Hardcoded ValorBase do Seguro Residencial
        BigDecimal valorBaseMensalidadeSeguroResidencial = new BigDecimal("2800.00");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Atual Valor BAse Mensalidade: "+valorBaseMensalidadeSeguroResidencial);
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");



        System.out.println("### Teste de Criacao de Seguro Vida ###");
        System.out.println("### Teste Instancia 01 ###");
        Segurado seguradoMarlonFreitasTeste_01 = new Segurado("Marlon Freitas",28,"20770001");
        List<String> beneficiariosMarlonFreitas = Arrays.asList("Tche Tche", "Gabriel Pires");
        SeguroVida seguroVida_01 = new SeguroVida(seguradoMarlonFreitasTeste_01.getNome(),
                true,
                LocalDateTime.now(),
                seguradoMarlonFreitasTeste_01.getIdade(),
                Sexo.MASCULINO,
                beneficiariosMarlonFreitas,
                new BigDecimal("150000.00"));

        Mensalidade mensalidadeSeguradoMarlonFreitasTeste_01 = seguroVida_01.calcularMensalidade(valorBaseMensalidadeSeguroResidencial);
        System.out.println("FEATURE_02: O valor da mensalidade 01 de Seguro Vida será: " + mensalidadeSeguradoMarlonFreitasTeste_01.getValorMensalidade());
        System.out.println("-----------------------------------------------------------");



        System.out.println("### Teste Instancia 02 ###");
        Segurado seguradoMariaDasDoresTeste_02 = new Segurado("Maria das Dores",24,"20770001");
        List<String> beneficiariosJanderson = Arrays.asList("Luiz Henrique", "Carlos Eduardo");
        SeguroVida seguroVida_02 = new SeguroVida(seguradoMariaDasDoresTeste_02.getNome(),
                true,
                LocalDateTime.now(),
                seguradoMariaDasDoresTeste_02.getIdade(),
                Sexo.FEMININO,
                beneficiariosJanderson,
                new BigDecimal("150000.00"));


        Mensalidade mensalidadeSeguradoJandersonTeste_02 = seguroVida_02.calcularMensalidade(valorBaseMensalidadeSeguroResidencial);
        System.out.println("FEATURE_02: O valor da mensalidade 01 de Seguro Vida será: " + mensalidadeSeguradoJandersonTeste_02.getValorMensalidade());
        System.out.println("-----------------------------------------------------------");


        System.out.println("### Teste Instancia 03 ###");
        Segurado seguradoDiegoCostaTeste_03 = new Segurado("Diego Costa",34,"20770001");
        List<String> beneficiariosDiegoCosta = Arrays.asList("Bruno Lage", "John Textor");
        SeguroVida seguroVida_03 = new SeguroVida(seguradoDiegoCostaTeste_03.getNome(),
                true,
                LocalDateTime.now(),
                seguradoDiegoCostaTeste_03.getIdade(),
                Sexo.MASCULINO,
                beneficiariosDiegoCosta,
                new BigDecimal("150000.00"));


        Mensalidade mensalidadeSeguradoDiegoCostaTeste_03 = seguroVida_03.calcularMensalidade(valorBaseMensalidadeSeguroResidencial);
        System.out.println("FEATURE_02: O valor da mensalidade 01 de Seguro Vida será: " + mensalidadeSeguradoDiegoCostaTeste_03.getValorMensalidade());
        System.out.println("-----------------------------------------------------------");

    }

}

