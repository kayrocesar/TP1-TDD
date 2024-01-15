# Trabalho TP1 de Técnicas de programação em plataformas emergentes (TPPE) do professor Andre Lanna
## Integrantes

| Aluno                 | Matrícula | Parte Implementada     | 
|-----------------------|-----------|------------------------|
|Adne Moretti Moreira|200013181|Gestão de transações, Pedidos e Compras|
|Gabriel Moretti de Souza|200018205|Gestão de transações, Pedidos e Compras|
|João Henrique Marques Calzavara|200067923|Consulta de estoque|
|Kayro Cesar Silva Machado|170107426|Cadastro de Produtos|
|Luan Vasco Cavalcante | 190111836 | Alerta de estoque baixo|
|Lucas Gabriel Sousa Camargo Paiva|190112123|Rastreamento de estoque|
## Para rodar os testes


### Passo 1: Instalar o JDK 17

##### Atualize o repositório APT:

```
sudo apt update
```

##### Instale o JDK 17:

 ```
sudo apt install openjdk-17-jdk
 ```
##### Configure as variáveis de ambiente:
Abra o arquivo .bashrc ou .zshrc no seu editor de texto  e adicione as seguintes linhas no final do arquivo (substitua <caminho-do-jdk-17> pelo caminho real do seu JDK 17):

```
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$PATH:$JAVA_HOME/bin
```

### Passo 2: Instalar o Maven
Instale o Maven:

```
sudo apt install maven
```
### Passo 3: Clonar o projeto

```
git clone git@github.com:kayrocesar/TP1-TDD.git
```
### Passo 4: Executar os testes
Entre na pasta do projeto:
```
cd TP1-TDD/
```
Rode os testes:
```
mvn test
```
Alternativa: instalar a uma IDE de sua preferencia [IntelliJ](https://www.jetbrains.com/pt-br/idea/) ou [Eclipse](https://eclipseide.org/) e rodar os testes por elas.

## Testes implementados
![testes](https://raw.githubusercontent.com/kayrocesar/TP1-TDD/master/assets/testes.png)

## Como foi feito?
&emsp;&emsp; Para início nos reunimos por discord para discutir como separaríamos as tarefas, e analisamos o contexto do trabalho, decidimos dividir da maneira que mostramos na tabela acima, decidimos pelo uso da linguagem de programação JAVA, por ter sido a linguagem que o professor utilizou em sala e no decorrer do projeto foram utilizadas as seguintes técnicas:

### TDD
&emsp;&emsp;O Desenvolvimento Orientado por Testes (TDD) é uma abordagem de desenvolvimento de software em que o código é escrito em ciclos curtos e repetitivos. O processo é geralmente composto pelas seguintes etapas:

- Escrever um Teste:

  - Antes de implementar qualquer funcionalidade, escreva um teste automatizado que defina o comportamento desejado.

- Executar o Teste:

  - Execute o teste recém-criado e observe-o falhar, pois a funcionalidade ainda não foi implementada.

- Implementar a Funcionalidade:

  - Escreva o código mínimo necessário para fazer o teste passar.

- Refatorar o Código:

  - Aprimore o código sem alterar seu comportamento, garantindo que permaneça legível e eficiente.

- Repetir o Ciclo:

  - Repita o processo para cada nova funcionalidade ou melhoria, garantindo que cada parte do código seja suportada por testes.

**Falsificação (Fake It):**

- O que é:

  - Consiste em implementar a funcionalidade mínima necessária para fazer o teste passar, mesmo que a implementação seja simplificada ou temporária.

- Como Utilizar:

  - Crie uma implementação rápida e rudimentar para satisfazer o teste.
  - Esta abordagem permite progredir rapidamente, validando o comportamento esperado antes de se preocupar com a implementação completa e refinada.

**Duplicação (Duplicate It):**

- O que é:

  - Refere-se a duplicar código para satisfazer o teste antes de realizar a refatoração.

- Como Utilizar:

  - Se a implementação de uma funcionalidade similar já existe, copie e cole o código relevante para fazer o novo teste passar.
  - Posteriormente, durante a etapa de refatoração, elimine a duplicação e crie uma solução mais geral.

**Triangulação (Triangulate):**

- O que é:

  - Consiste em adicionar mais testes específicos para tornar a implementação mais robusta e precisa.

- Como Utilizar:

  - Se, inicialmente, a implementação é suficiente apenas para passar no teste específico, adicione mais testes para garantir que a solução seja mais geral.
  - Isso ajuda a evitar falsas generalizações, garantindo que a implementação funcione para uma variedade de casos.

&emsp;&emsp;Em resumo, TDD é uma prática de desenvolvimento em que os testes automatizados são escritos antes da implementação do código. Falsificação, duplicação e triangulação são estratégias específicas dentro do TDD para orientar o desenvolvimento de código de forma incremental e segura.

### Testes parametrizados

&emsp;&emsp; Para essa parte usamos os testes parametrizados do JUnit 5 em nosso projeto, e abaixo uma breve explicação do que são os testes parametrizados:

- Testes parametrizados são testes que aceitam parâmetros como entrada. Esses parâmetros podem ser valores simples, como números ou strings, ou podem ser objetos complexos, como classes ou estruturas de dados.
- Os testes parametrizados são úteis para aumentar a cobertura de testes e reduzir a redundância. Ao usar testes parametrizados, você pode testar um método ou classe com diferentes entradas, sem ter que escrever testes duplicados.
  - Por exemplo, imagine que você deseja testar um método que calcula o imposto sobre vendas. Você pode escrever um teste parametrizado que passe diferentes valores de preço e estado como entrada para o método. Isso garantirá que o método calcule o imposto corretamente para todos os casos possíveis.

- Abaixo alguns dos benefícios dos testes parametrizados:

  - Aumento da cobertura de testes: Os testes parametrizados permitem que você teste um método ou classe com diferentes entradas, sem ter que escrever testes duplicados. Isso ajuda a garantir que seu código esteja bem testado.
  - Redução da redundância: Os testes parametrizados podem reduzir a redundância no código de teste. Ao usar testes parametrizados, você pode escrever um único teste que cubra vários casos possíveis.
  - Facilidade de manutenção: Os testes parametrizados podem tornar o código de teste mais fácil de manter. Se você precisar alterar o comportamento de um método ou classe, você só precisará alterar o código de teste uma vez.

