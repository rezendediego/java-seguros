package br.edu.infnet.teste;

import br.edu.infnet.modelo.dominio.Segurado;
import br.edu.infnet.modelo.dominio.SeguroVida;
import br.edu.infnet.modelo.dominio_enum.Sexo;
import br.edu.infnet.modelo.dominio_enum.TipoSeguro;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SeguroVidaTeste {
    public static String validadorSeguroVida(SeguroVida seguroVida, Segurado segurado ){
        try{
            assertNotNull(seguroVida.getIdSeguro());
            assertEquals(seguroVida.getNomeSegurado(),segurado.getNome());
            assertEquals(seguroVida.getTipoSeguro(), TipoSeguro.SEGURO_VIDA);
        }catch(AssertionError assertionError){
            System.out.println(">>>AssertionError: Revise a proposta de Contrato: " + assertionError.getMessage());
        }

        return seguroVida.toString();
    }
    public static void main(String[] args){
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

        System.out.println(validadorSeguroVida(seguroVida_01,seguradoMarlonFreitasTeste_01));
        System.out.println("-----------------------------------------------------------");



        System.out.println("### Teste Instancia 02 ###");
        Segurado seguradoJandersonTeste_02 = new Segurado("Janderson Costa",24,"20770001");
        List<String> beneficiariosJanderson = Arrays.asList("Luiz Henrique", "Carlos Eduardo");
        SeguroVida seguroVida_02 = new SeguroVida(seguradoJandersonTeste_02.getNome(),
                true,
                LocalDateTime.now(),
                seguradoJandersonTeste_02.getIdade(),
                Sexo.MASCULINO,
                beneficiariosJanderson,
                new BigDecimal("150000.00"));

        System.out.println(validadorSeguroVida(seguroVida_02,seguradoJandersonTeste_02));
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

        System.out.println(validadorSeguroVida(seguroVida_03,seguradoDiegoCostaTeste_03));
        System.out.println("-----------------------------------------------------------");

    }
}
