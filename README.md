#### Projeto Individual Disciplina Tecnologia Java e Orientação a Objetos [23E3_2] - Pós-Graduação Engenharia de Software com Java | Instituto Infnet ####

**Aluno: Diego Henrique Cornelio de Rezende**

-------------------------------------------------------------------
#### ORGANIZAÇÃO DAS SOLUÇÕES - PROJETO JAVA SEGUROS

> Nota Informativa
> - O branch main possui as instruções seguidas por soluções descritas em UML. 
> 
> - A implementação de cada solução está no seu próprio branch
 
**Instruções Iniciais:**

Crie um projeto que organize as regras de negócio em seis classes da seguinte maneira:

- Uma classe mãe abstrata : Classe *Seguro*

- Três classes filhas : Subclasses de Seguro -> SeguroResidencial, SeguroSaude, SeguroVida

- Uma classe concreta sem mãe : Classe Segurado

- Uma classe principal que tenha dois relacionamentos: Classe PropostaContrato
  
  - 1:1 com a classe concreta : PropostaContrato tem um único Segurado
  - 1:n com a classe mãe : PropostaContrato tem um ou mais Seguro

![Instruções Iniciais Java Seguros](/imagens/diagramaInicial.png)


**Branch "feature-01"**

- Todas as classes precisam ter pelo menos três atributos e todos os tipos de dados precisam ser utilizados em pelo menos uma ocorrência.
- As classes de teste precisam ter pelo menos três instâncias dos objetos.
- Todas as classes de domínio precisam ter o toString implementado.
- A classe de associação (“Segurado”) precisa ter um construtor que receba todos os atributos como parâmetro.

![Instruções Feature 01 Java Seguros](/imagens/diagramaFeature_01.png)




**Branch "feature-02"**

- É necessário criar um método abstrato na classe mãe. 
>     public abstract class Seguro {
>  
>     //Atributos...
>   
>      public abstract Mensalidade calcularMensalidade(BigDecimal valorBase);
>   
>     //Getters, toString()...
> 
>     }


- Cada filha precisa implementar diferentemente o método abstrato.

  ![Instruções Feature 02 Java Seguros](/imagens/diagramaFeature_02.png)


**Branch "feature-03"**

- Criação de um atributo do tipo Vetor.
- Criação de um atributo do tipo Set.
- Criação do relacionamento entre a classe principal e a mãe com List.

Diagrama UML da Feature 03
![Instruções Feature 03 Java Seguros](/imagens/diagramaFeature_03.png)

Feature 03.1: Criar um atributo tipo Vetor
![Instruções Feature 03.01 Java Seguros](/imagens/Feature-03_1_Vetor_dentro_MensalidadesPagas.png)

Feature 03.2: Criar um atributo do tipo Set
![Instruções Feature 03.02 Java Seguros](/imagens/Feature-03_2_Set_dentro_ContratoFirmadoRepository.png)

Feature 03.3: Criar relacionamento entre a classe principal e a mãe com List
![Instruções Feature 03.03 Java Seguros](/imagens/Feature-03_3_List_de_Seguro_dentro_PropostaContrato.png)


**Branch "feature-04"**

- Criação de classes de exceptions para tratar regras de negócio.
- Cada classe de negócio deve usar uma classe de exception.
- Fazer a leitura de um arquivo texto com o layout definido pelo aluno.
- Um arquivo texto deve ser gerado com um layout diferente da entrada.