# Resumo do projeto

## Objetivo:
<p align = "justify">
Como o próprio nome sugere, o objetivo do projeto foi criar um planejador universitário baseado em sistemas como o GDE da Unicamp, que visam facilitar a vida do usuário (estudante universitário) e ajudar na organização de sua vida acadêmica. A visão inicial que tivemos, foi de uma boa oportunidade de aplicar os conceitos de programação orientada a objetos, utilizando um sistema familiar a todo aluno e de forma a nos ater à um sistema de cadastro, otimizando a aplicação dos conceitos vistos em sala no decorrer do semestre, tanto aproveitando  e adaptando métodos e objetos criados no desenvolver dos Labs da disciplina, quanto criando métodos e objetos novos que se mostraram necessários para o bom fluxo do projeto.
</p>

---

## Funcionamento:
<p align = "justify">
Como antes dito, o planejador universitário tem seu funcionamento dedicado ao estudante e por isso conta primeiramente com uma tela de cadastro do aluno, onde o mesmo deverá inserir suas informações pessoais. Após o cadastro, o usuário é redirecionado para a tela de matrículas, onde poderá ver suas disciplinas matriculadas (que disponibilizará as faltas até o momento), verificar suas disciplinas concluídas e adicionar disciplinas à sua grade. Para tanto, o sistema conta com um banco de dados de professores, disciplinas, institutos e cursos.
</p>

---

## Orientação a objetos:
<p align = "justify">
Vários conceitos importantes de orientação a objetos foram utilizados no decorrer do projeto, os principais deles foram:
</p>

1. Relacionamentos entre classes: 
<p align = "justify"> Onde temos alguns tipos de relação como a associação, onde classes estão relacionadas mas tem sua existência independente uma da outra (Instituto e Aluno); a agregação, em que as classes não precisam umas das outras para existir mas têm referência direta para a outra (Aluno e Disciplina); e a composição onde uma classe depende da outra para existir (relação entre Endereço com Pessoa e Instituto, por exemplo).</p>

2. Classes Abstratas: 
<p align = "justify">Através das classes Professor e Aluno herdando a classe mãe abstrata Pessoa.

3. Interface Gráfica e Arquivos:
<p align = "justify">O sistema é controlado por uma interface gráfica, com uma tela de cadastro que é capaz de gravar em arquivo as informações imputadas, seguindo para uma tela de interação capaz de desenvolver as principais funções do planejador puxando informações de uma base de dados programada em forma de uma classe estática.

4. Tratamento de exceções:
<p align = "justify">Tratamos as exceções para todos os casos que os dados básicos das classes fossem inseridos pelos usuário de maneira incorreta, isto é, em um formato diferente do tipo declarado para o mesmo assim como a data com o formato válido para o tipo LocalDate ou até mesmo para uma quantidade de creditos permitidos que tenha sido inserida diferente do formato int (caso o usuário tenha digitado errado). Além disso, realizamos a tratativa das exceções para abertura de arquivos que podem não existir e também para acesso de indíces em que a memória não foi reservada para a estrutura de dados.

</p>

---

## Conclusão
<p align = "justify">Por fim, temos um projeto que coloca em prática a esmagadora maioria dos conceitos vistos no decorrer do semestre e abre porta para a adição de inúmeras funcionalidades de vasta utilidade, como a manipulação das atividades de cada disciplina através da interface gráfica, a ampliação da classe aluno para duas classes filhas: Aluno de graduação e Aluno de Pós, a ampliação da base de dados para abranger todos os cursos e disciplinas, a otimização da interface gráfica, etc.</p> 
