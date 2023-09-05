package br.edu.infnet.teste;

import br.edu.infnet.excecao.SeguradoInadimplenteException;
import br.edu.infnet.excecao.SeguradoMenorIdadeException;
import br.edu.infnet.excecao.SeguroNaoDisponivelException;
import br.edu.infnet.modelo.dominio.*;
import br.edu.infnet.modelo.dominio_enum.*;
import br.edu.infnet.utilitarios.validacao.ValidadorDisponibilidadeSeguroResidencial;
import br.edu.infnet.utilitarios.validacao.ValidadorDisponibilidadeSeguroSaude;
import br.edu.infnet.utilitarios.validacao.ValidadorDisponibilidadeSeguroVida;
import br.edu.infnet.utilitarios.validacao.ValidadorPermissaoSeguradoFirmarContrato;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FeatureQuatroExceptionTeste {
    /*
    * SeguradoMenorIdadeException
    * SeguradoInadimplenteException
    * SeguroNaoDisponivelException
    * */
    public static void main(String[] args){
        //#######################################################################
        //SeguradoMenorIdadeException ###########################################
        //Segurado Maior Idade
        Segurado segurado_sem_Exception = new Segurado("Diego Rezende",40,"20770001");

        //Segurado Menor Idade
        Segurado segurado_com_Exception = new Segurado("Bruno Henrique",5,"24808052");

        System.out.println("#####################################");
        System.out.println("### SeguradoMenorIdadeException ###");
        System.out.println("### SeguradoMenorIdadeException = Falso ###");
        try{
            if(segurado_sem_Exception.permissaoParaContratarSeguro()){
                System.out.println("O Segurado: " +
                        segurado_sem_Exception.getNome() +
                        " com idade: " +
                        segurado_sem_Exception.getIdade() +
                        " pode contratar um seguro na Java Seguros");
            }
        }catch(SeguradoMenorIdadeException seguradoMenorIdadeException){
            System.out.println(">>>: " + seguradoMenorIdadeException.getMessage());
        }


        System.out.println("### SeguradoMenorIdadeException = Verdadeiro ###");
        try{
            if(segurado_com_Exception.permissaoParaContratarSeguro()){
                System.out.println("O Segurado: " +
                        segurado_com_Exception.getNome() +
                        " com idade: " +
                        segurado_com_Exception.getIdade() +
                        " pode contratar um seguro na Java Seguros");
            }
        }catch(SeguradoMenorIdadeException seguradoMenorIdadeException){
            System.out.println(">>>: " + seguradoMenorIdadeException.getMessage());
        }

        //#######################################################################
        //SeguradoInadimplenteException #########################################
        Segurado segurado_01_JoseSilva = new Segurado("José Silva", 70,"25510180");
        Segurado segurado_02_DiegoRezende = new Segurado("Diego Rezende",40,"20770001");
        Segurado segurado_03_MariaSantos = new Segurado("Maria Santos",18,"69000001");

        // Proposta Teste segurado 01 ------------------------------------------------------------------------
        List<String> beneficiariosJose = Arrays.asList("Maria das Dores Silva", "Joaozinho das Dores Silva");
        Seguro seguroVidaJoseSilva = new SeguroVida(segurado_01_JoseSilva.getNome(),
                true,
                LocalDateTime.now(),
                segurado_01_JoseSilva.getIdade(),
                Sexo.MASCULINO,
                beneficiariosJose,
                new BigDecimal("150000.00"));

        PropostaContrato propostaContrato_01 = new PropostaContrato(
                seguroVidaJoseSilva.getInicio(),
                segurado_01_JoseSilva,
                TempoContrato.SEMESTRAL,
                Arrays.asList(seguroVidaJoseSilva));


        // Proposta Teste segurado 02 ---------------------------------------------------------------------
        List<String> beneficiariosDiego = Arrays.asList("Maria das Dores Silva", "Joaozinho das Dores Silva");
        Seguro seguroVidaDiegoRezende = new SeguroVida(segurado_02_DiegoRezende.getNome(),
                true,
                LocalDateTime.now(),
                segurado_02_DiegoRezende.getIdade(),
                Sexo.MASCULINO,
                beneficiariosDiego,
                new BigDecimal("150000.00"));

        PropostaContrato propostaContrato_02 = new PropostaContrato(
                seguroVidaDiegoRezende.getInicio(),
                segurado_02_DiegoRezende,
                TempoContrato.SEMESTRAL,
                Arrays.asList(seguroVidaDiegoRezende));


        // Proposta Teste segurado 03 ---------------------------------------------------------------------
        List<String> beneficiariosMaria = Arrays.asList("Maria das Dores Silva", "Joaozinho das Dores Silva");
        Seguro seguroVidaMaria = new SeguroVida(segurado_03_MariaSantos.getNome(),
                true,
                LocalDateTime.now(),
                segurado_03_MariaSantos.getIdade(),
                Sexo.MASCULINO,
                beneficiariosMaria,
                new BigDecimal("150000.00"));

        PropostaContrato propostaContrato_03 = new PropostaContrato(
                seguroVidaMaria.getInicio(),
                segurado_03_MariaSantos,
                TempoContrato.SEMESTRAL,
                Arrays.asList(seguroVidaMaria));



        //Adicionando segurado Diego e Maria como inadimplentes
        ValidadorPermissaoSeguradoFirmarContrato validadorPermissaoSeguradoFirmarContrato = new ValidadorPermissaoSeguradoFirmarContrato();
        validadorPermissaoSeguradoFirmarContrato.setMapaSeguradosInadimplentes(segurado_01_JoseSilva.getId(),false);
        validadorPermissaoSeguradoFirmarContrato.setMapaSeguradosInadimplentes(segurado_02_DiegoRezende.getId(),true);
        validadorPermissaoSeguradoFirmarContrato.setMapaSeguradosInadimplentes(segurado_03_MariaSantos.getId(),true);

        System.out.println("------------");
        System.out.println("#####################################");
        System.out.println("### SeguradoInadimplenteException ###");
        System.out.println("### SeguradoInadimplenteException = MAPA DE INADIMPLENTES ###");
        System.out.println(validadorPermissaoSeguradoFirmarContrato.getMapaSeguradosInadimplentes());

        System.out.println("### SeguradoInadimplenteException = Verdadeiro ###");
        System.out.println(segurado_02_DiegoRezende);
        try{
            if(propostaContrato_02.seguradoEstaInadimplente(validadorPermissaoSeguradoFirmarContrato)){
                System.out.println("O segurado: " + segurado_02_DiegoRezende.getNome() + " esta autorizado a firmar um contrato de seguro");
            }
        }catch(SeguradoInadimplenteException seguradoInadimplenteException){
            System.out.println(">>>: " + seguradoInadimplenteException.getMessage());
        }

        System.out.println(segurado_03_MariaSantos);
        try{
            if(propostaContrato_03.seguradoEstaInadimplente(validadorPermissaoSeguradoFirmarContrato)){
                System.out.println("O segurado: " + segurado_03_MariaSantos.getNome() + " esta autorizado a firmar um contrato de seguro");
            }
        }catch(SeguradoInadimplenteException seguradoInadimplenteException){
            System.out.println(">>>: " + seguradoInadimplenteException.getMessage());
        }


        System.out.println("\n ### SeguradoInadimplenteException = falso ###");
        System.out.println(segurado_01_JoseSilva);
        try{
            if(propostaContrato_01.seguradoEstaInadimplente(validadorPermissaoSeguradoFirmarContrato)){
                System.out.println("O segurado: " + segurado_01_JoseSilva.getNome() + " esta autorizado a firmar um contrato de seguro");
            }
        }catch(SeguradoInadimplenteException seguradoInadimplenteException){
            System.out.println(">>>: " + seguradoInadimplenteException.getMessage());
        }


        //#######################################################################
        //SeguroNaoDisponivelException ##########################################


        List<String> beneficiariosJoseNaoDisponivelException = Arrays.asList("Maria das Dores Silva", "Joaozinho das Dores Silva");
        SeguroVida seguroVida_01_JoseSilva = new SeguroVida(segurado_01_JoseSilva.getNome(),
                true,
                LocalDateTime.now(),
                segurado_01_JoseSilva.getIdade(),
                Sexo.MASCULINO,
                beneficiariosJoseNaoDisponivelException,
                new BigDecimal("150000.00"));

        //--------------------------------


        SeguroResidencial seguroResidencial_02_Diego = new SeguroResidencial(
                segurado_02_DiegoRezende.getNome(),
                true,
                LocalDateTime.now().plusMonths(2),
                TipoImovel.APARTAMENTO,
                200,
                new BigDecimal("800000.00"));




        //--------------------------------

        List<DoencasPreexistentes> doencasPreexistentesMariaSantos = new ArrayList<>();
        doencasPreexistentesMariaSantos.add(DoencasPreexistentes.NEUROLOGICOS);
        doencasPreexistentesMariaSantos.add(DoencasPreexistentes.GASTROINTESTINAIS);
        doencasPreexistentesMariaSantos.add(DoencasPreexistentes.PSIQUIATRICOS);

        SeguroSaude seguroSaude_03_MariaSantos = new SeguroSaude(segurado_03_MariaSantos.getNome(),
                false,
                LocalDateTime.now().plusMonths(3),
                Optional.of(LocalDateTime.now().plusMonths(15)),
                segurado_03_MariaSantos.getIdade(),
                Sexo.FEMININO,
                ModalidadeSeguroSaude.REEMBOLSO,
                PeriodoCarencia.ANUAL,
                doencasPreexistentesMariaSantos);



        System.out.println("------------");
        System.out.println("#####################################");
        System.out.println("### SeguroNaoDisponivelException ###");
        System.out.println("### SeguroNaoDisponivelException = VERDADEIRO ###");

        //Validador configurado para indisponível em todos para teste

        ValidadorDisponibilidadeSeguroSaude validadorDisponibilidadeSeguroSaude = new ValidadorDisponibilidadeSeguroSaude(false);
        ValidadorDisponibilidadeSeguroVida validadorDisponibilidadeSeguroVida = new ValidadorDisponibilidadeSeguroVida(false);
        ValidadorDisponibilidadeSeguroResidencial validadorDisponibilidadeSeguroResidencial = new ValidadorDisponibilidadeSeguroResidencial(false);

        try{
            System.out.println("Modalidade Seguro Saude: -" + validadorDisponibilidadeSeguroSaude.getDisponibilidade());
            if(seguroSaude_03_MariaSantos.modSaudeEstaDisponivel(validadorDisponibilidadeSeguroSaude)){
                System.out.println("A modalidade Seguro Saude está disponível ");
            }
        }catch(SeguroNaoDisponivelException seguroNaoDisponivelException){
            System.out.println(">>>: " + seguroNaoDisponivelException.getMessage());
        }



        try{
            System.out.println("Modalidade Seguro Vida: " + validadorDisponibilidadeSeguroVida.getDisponibilidade());
            if(seguroVida_01_JoseSilva.modVidaEstaDisponivel(validadorDisponibilidadeSeguroVida)){
                System.out.println("A modalidade Seguro Saude está disponível ");
            }
        }catch(SeguroNaoDisponivelException seguroNaoDisponivelException){
            System.out.println(">>>: " + seguroNaoDisponivelException.getMessage());
        }



        try{
            System.out.println("Modalidade Seguro Residencial: " + validadorDisponibilidadeSeguroResidencial.getDisponibilidade());
            if(seguroResidencial_02_Diego.modResidencialEstaDisponivel(validadorDisponibilidadeSeguroResidencial)){
                System.out.println("A modalidade Seguro Saude está disponível ");
            }
        }catch(SeguroNaoDisponivelException seguroNaoDisponivelException){
            System.out.println(">>>: " + seguroNaoDisponivelException.getMessage());
        }


    }
}
