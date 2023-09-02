package br.edu.infnet.teste;

import br.edu.infnet.modelo.dominio.Segurado;


import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SeguradoTeste {
    public static void main(String[] args){
        Segurado[] segurados = new Segurado[3];
        Scanner seguradoScanner = new Scanner(System.in);

        System.out.println("\n### Teste da Classe Segurado ###");
        System.out.println(">>> Cadastre 3 Segurados inserindo: \n 1°) Nome:String \n 2°) Idade:Integer \n 3°) Cep:String(8 numeros & sem Separadores):");

        for(int i =0; i<3; i++){
            System.out.printf(">>> Insira os dados do Segurado \n>>> " );
            String nomeTemp = seguradoScanner.nextLine();
            Integer idadeTemp = seguradoScanner.nextInt();
            seguradoScanner.nextLine();//Consumindo newline
            String cepTemp = seguradoScanner.nextLine();
            segurados[i] = new Segurado(nomeTemp,idadeTemp,cepTemp);
            try{
                assertNotNull(segurados[i].getId());
                assertEquals(nomeTemp,segurados[i].getNome());
                assertEquals(idadeTemp,segurados[i].getIdade());
                assertEquals(cepTemp,segurados[i].getCep());
            }catch(AssertionError assertionError) {
                System.out.println("ASSERTION ERROR: Dados invalidos foram inseridos na criação do Segurado " + (i + 1) + ": " + assertionError.getMessage());
            }
            System.out.println("Segurado " + (i+1) + ": " + segurados[i].toString());

        }
        seguradoScanner.close();
    }
}
