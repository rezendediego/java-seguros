package br.edu.infnet.teste;

import br.edu.infnet.modelo.dominio.Segurado;
import br.edu.infnet.modelo.dominio.SeguroResidencial;
import br.edu.infnet.modelo.dominio_enum.TipoImovel;
import br.edu.infnet.modelo.dominio_enum.TipoSeguro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SeguroResidencialTeste {
    public static String validadorSeguroResidencial(SeguroResidencial seguroResidencial, Segurado segurado ){
        try{
            assertNotNull(seguroResidencial.getIdSeguro());
            assertEquals(seguroResidencial.getNomeSegurado(),segurado.getNome());
            assertEquals(seguroResidencial.getTipoSeguro(), TipoSeguro.SEGURO_RESIDENCIAL);
        }catch(AssertionError assertionError){
            System.out.println(">>>AssertionError: Revise a proposta de Contrato: " + assertionError.getMessage());
        }

        return seguroResidencial.toString();
    }
    public static void main(String[] args){
        System.out.println("### Teste de Criacao de Seguro Residencial ###");

        //Teste Seguro Residencial Casa
        System.out.println("### Teste Seguro Residencial Casa  ###");
        Segurado seguradoLucasPerriTeste_01 = new Segurado("Lucas Perri",25,"20770001");
        SeguroResidencial seguroResidencial_01 = new SeguroResidencial(
                seguradoLucasPerriTeste_01.getNome(),
                true,
                LocalDateTime.now().plusMonths(1),
                TipoImovel.CASA,
                450,
                new BigDecimal("1000000.00"));

        System.out.println(validadorSeguroResidencial(seguroResidencial_01,seguradoLucasPerriTeste_01));
        System.out.println("-----------------------------------------------------------");

        //Teste Seguro Residencial Apartamento
        System.out.println("### Teste Seguro Residencial Apartamento  ###");
        Segurado seguradoAdryelsonTeste_02 = new Segurado("Adryelson",25,"20770001");
        SeguroResidencial seguroResidencial_02 = new SeguroResidencial(
                seguradoAdryelsonTeste_02.getNome(),
                true,
                LocalDateTime.now().plusMonths(2),
                TipoImovel.APARTAMENTO,
                200,
                new BigDecimal("800000.00"));

        System.out.println(validadorSeguroResidencial(seguroResidencial_02,seguradoAdryelsonTeste_02));
        System.out.println("-----------------------------------------------------------");


        //Teste Seguro Residencial Casa Condominio
        System.out.println("### Teste Seguro Residencial Casa Condominio ###");
        Segurado seguradoCuestaTeste_03 = new Segurado("Cuesta",34,"20770001");
        SeguroResidencial seguroResidencial_03 = new SeguroResidencial(
                seguradoCuestaTeste_03.getNome(),
                true,
                LocalDateTime.now(),
                TipoImovel.CASA_CONDOMINIO,
                600,
                new BigDecimal("1300000.00"));

        System.out.println(validadorSeguroResidencial(seguroResidencial_03,seguradoCuestaTeste_03));
        System.out.println("-----------------------------------------------------------");

    }
}
