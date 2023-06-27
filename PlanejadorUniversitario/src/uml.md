# uml: sequence diagram

Here I will embed PlantUML markup to generate a sequence diagram.

I can include as many plantuml segments as I want in my Markdown, and the diagrams can be of any type supported by PlantUML.

```plantuml
@startuml PlanejadorUniversitário
    class Aluno{
        - Int RA 
        - Double CP
        - Double CR
        - Curso curso
        - Int anoDeIngresso
        - Int creditosPermitidos
        - Int creditosSemestrais
        - ArrayList arvoreDoCurso
        - ArrayList gradeSemestral

        + Gets/sets...()
        + Int calculaCreditosSemestrais()
        + Void adicionarDisciplina()
        + Void removerDisciplina()

    }
    class AlunoGraduacao{
        - ArrayList disciplinasMatriculadas
        - ArrayList disciplinasConcluidas

        + Gets/sets...()
        + Void adicionarDisciplina()
        + Void removerDisciplina()
        + Void concluirDisciplina()

    }
    class Atividade{
        - String nome
        - Double peso
        - Double nota

        + Gets/sets...()



    }
    class Curso{
        -  Int codigo
        - ArrayList arvoreIntegralizacao
        - Int creditosPermitidos
        - Int creditosObrigatorios
        - Int creditosEletivos
        - String turno
        - Int semestres

         + Gets/sets...()


    }
    class Disciplina{
         -  String nome
        -  Int creditos
        -  String codigo
        - Professor professor
        - ArrayList atividades   
        - Int numeroFaltas
        - Double media

         + Gets/sets...()
         + Void recalculaMedia()




    }
    class Endereco{
        - String rua
        - Integer numero
        - String bairro
        - String cidade
        - String estado
        - String pais

        + Gets/sets...()
        + String toString()


    }
    class Genero <<enum>>{
        + MASCULINO
        + FEMININO
        + NAO_BINARIO

    }
    class Instituto{
        -  String nome
        -  String sigla
        - Endereco endereco
        - ArrayList disciplinasOferecidas

         + Gets/sets...()

    }
    class Pessoa{
        - String nome
        - LocalDate dataNascimento
        - String rg
        - String cpf
        - String email
        - String telefone
        - Genero genero
        - Endereco endereco

        + Gets/sets...()


    }
    class Professor{
        - ArrayList avaliacoesDeDesempenho
        - Double nota
        - ArrayList disciplinasMinistradas
    
        + Gets/sets...()
         + Void recalculaNota()
         + Boolean addDisciplina()
         + Boolean removeDisciplina()
         + Boolean avaliarProfessor()


    }
 
    Curso --> Aluno
    Pessoa --> Professor
    Professor --> Disciplina
    Atividade --> Disciplina
    Genero --> Pessoa
   AlunoGraduacao --> Aluno
   Instituto --> Disciplina
   Aluno --> Pessoa
   
@enduml
```
