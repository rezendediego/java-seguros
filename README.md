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
- Cada filha precisa implementar diferentemente o método abstrato.



**Branch "feature-03"**

- Criação de um atributo do tipo vetor.
- Criação de um atributo do tipo Set.
- Criação do relacionamento entre a classe principal e a mãe com List.


**Branch "feature-04"**

- Criação de classes de exceptions para tratar regras de negócio.
- Cada classe de negócio deve usar uma classe de exception.
- Fazer a leitura de um arquivo texto com o layout definido pelo aluno.
- Um arquivo texto deve ser gerado com um layout diferente da entrada.