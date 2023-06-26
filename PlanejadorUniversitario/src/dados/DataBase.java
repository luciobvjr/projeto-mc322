package dados;

import modelos.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataBase {
    //Criação de variáveis estáticas para acesso de dados na main sem necessidade de instanciação//
    private static ArrayList<Instituto> institutos = new ArrayList<Instituto>();
    
    private static ArrayList<Professor> professores = new ArrayList<Professor>();

    private static ArrayList<Curso> cursos = new ArrayList<Curso>();
    
    //Método estático que define a base de dados//
    public static void create(){
        //Instanciação de Institutos//
        Endereco endereco1 = new Endereco("Saturnino de Brito", 573, "Cidade Universitária", "Campinas", "São Paulo", "Brasil");
        Instituto IC = new Instituto("Instituto da Computação", "IC", endereco1);
        institutos.add(IC);
        
        Endereco endereco2 = new Endereco("Rua Sérgio Buarque de Holanda", 651, "Cidade Universitária", "Campinas", "São Paulo", "Brasil");
        Instituto IMECC = new Instituto("Instituto de Matemática, Estatística e Computação Científica", "IMECC", endereco2);
        institutos.add(IMECC);
        
        Endereco endereco3 = new Endereco("Rua Sérgio Buarque de Holanda", 777, "Cidade Universitária", "Campinas", "São Paulo", "Brasil");
        Instituto IFGW = new Instituto("Instituto de Física Gleb Watagin", "IFGW", endereco3);
        institutos.add(IFGW);
        
        Endereco endereco4 = new Endereco("Av. Albert Einstein", 400, "Cidade Universitária", "Campinas", "São Paulo", "Brasil");
        Instituto FEEC = new Instituto("Faculdade de Engenharia ELétrica e de Computação", "FEEC", endereco4);
        institutos.add(FEEC);

        Endereco endereco5 = new Endereco("Rua Josué de Castro", 0, "Cidade Universitária", "Campinas", "São Paulo", "Brasil");
        Instituto IQ = new Instituto("Instituto de Química", "IQ", endereco5);
        institutos.add(IQ);
        
        //Instanciação de Professores//
        Professor marcos = new Professor("Marcos Raimundo", LocalDate.parse("1988-10-10") , "30.720.505-8", "737.884.110-23", "mrai@unicamp.br", "+55 (19) 3521-0322", Genero.MASCULINO, IC.getEndereco());
        professores.add(marcos);
        
        Professor ketty = new Professor("Ketty Abaroa de Rezende", LocalDate.parse("1963-05-08"), "23.758.534-0", "336.724.600-01", "ketty@ime.unicamp.br", "+55 19 3521-6046", Genero.FEMININO,IMECC.getEndereco());
        professores.add(ketty);
        
        Professor carola = new Professor("Carola Dobrigkeit Chinellato", LocalDate.parse("1950-03-22"), "32.551.729-0", "597.116.640-97", "", "(19) 33215529", Genero.FEMININO, IFGW.getEndereco());
        professores.add(carola);
        
        Professor lyra = new Professor("Christiano Lyra Filho", LocalDate.parse("1956-03-31"), "48.185.948-2", "408.004.440-27", "chrlyra@unicamp.br", "(19) 35213775", Genero.MASCULINO, FEEC.getEndereco());
        professores.add(lyra);
        
        Professor pablo = new Professor("Pablo Sebastián Fernández", LocalDate.parse("1980-07-20"), "37.711.303-7", "566.741.480-59", "pablosf@unicamp.br", "(19) 35213005", Genero.MASCULINO, IQ.getEndereco());
        professores.add(pablo);
        
        //Instanciação de disciplinas//
        ArrayList<Disciplina> disciplinasCB = new ArrayList<Disciplina>(); //Disciplinas do ciclo basico das engenharias//
        ArrayList<Disciplina> disciplinasIC = new ArrayList<Disciplina>();//
        ArrayList<Disciplina> disciplinasIQ = new ArrayList<Disciplina>();//Disciplinas específicas de cada instituto//
        ArrayList<Disciplina> disciplinasFEEC = new ArrayList<Disciplina>();//
        
        //Disciplinas do IMECC//
        Disciplina MA111 = new Disciplina("Cálculo I", 6, "M111", ketty);
        ketty.getDisciplinasMinistradas().add(MA111);//Adiciona a disciplina à lista de disciplinas do professor//
        disciplinasCB.add(MA111);
        IMECC.getDisciplinasOferecidas().add(MA111);//Adiciona a disciplina a lista de disciplinas oferecidas pelo instituto//

        Disciplina MA211 = new Disciplina("Cálculo II", 6, "MA211", ketty);
        ketty.getDisciplinasMinistradas().add(MA211);
        disciplinasCB.add(MA211);
        IMECC.getDisciplinasOferecidas().add(MA211);

        Disciplina MA311 = new Disciplina("Cálculo III", 6, "MA311", ketty);
        ketty.getDisciplinasMinistradas().add(MA311);
        disciplinasCB.add(MA311);
        IMECC.getDisciplinasOferecidas().add(MA311);

        Disciplina MA141 = new Disciplina("Geometria Analítica e Vetores", 4, "MA141", ketty);
        ketty.getDisciplinasMinistradas().add(MA141);
        disciplinasCB.add(MA141);
        IMECC.getDisciplinasOferecidas().add(MA141);

        Disciplina MA327 = new Disciplina("Álgebra Linear", 4, "MA327", ketty);
        ketty.getDisciplinasMinistradas().add(MA327);
        disciplinasCB.add(MA327);
        IMECC.getDisciplinasOferecidas().add(MA327);
        
        //Disciplinas do IFGW//
        Disciplina F128 = new Disciplina("Física Geral I", 4, "F128", carola);
        carola.addDisciplina(F128);
        disciplinasCB.add(F128);
        IFGW.getDisciplinasOferecidas().add(F128);
        
        Disciplina F228 = new Disciplina("Física Geral II", 4, "F228",carola);
        carola.addDisciplina(F228);
        disciplinasCB.add(F228);
        IFGW.getDisciplinasOferecidas().add(F228);

        Disciplina F328 = new Disciplina("Física Geral III", 4, "F328", carola);
        carola.addDisciplina(F328);
        disciplinasCB.add(F328);
        IFGW.getDisciplinasOferecidas().add(F328);

        Disciplina F428 = new Disciplina("Física Geral IV", 4, "F428", carola);
        carola.addDisciplina(F428);
        disciplinasCB.add(F428);
        IFGW.getDisciplinasOferecidas().add(F428);
        
        //Disciplinas do IC//
        Disciplina MC102 = new Disciplina("Algoritmos e Programação de Computadores", 6, "MC102", marcos);
        marcos.getDisciplinasMinistradas().add(MC102);
        disciplinasIC.add(MC102);
        IC.getDisciplinasOferecidas().add(MC102);

        Disciplina MC202 = new Disciplina("Estruturas de dados", 6, "MC202", marcos);
        marcos.getDisciplinasMinistradas().add(MC202);
        disciplinasIC.add(MC202);
        IC.getDisciplinasOferecidas().add(MC202);

        Disciplina MC322 = new Disciplina("Programação Orientada a objetos", 4, "MC322", marcos);
        marcos.getDisciplinasMinistradas().add(MC322);
        disciplinasIC.add(MC322);
        IC.getDisciplinasOferecidas().add(MC322);

        //Disciplinas da FEEC//
        Disciplina EA513 = new Disciplina("Circuitos Elétricos", 4, "EA513", lyra);
        lyra.addDisciplina(EA513);
        disciplinasFEEC.add(EA513);
        FEEC.getDisciplinasOferecidas().add(EA513);

        Disciplina EA772 = new Disciplina("Circuitos Lógicos", 4, "EA772", lyra);
        lyra.addDisciplina(EA772);
        disciplinasFEEC.add(EA772);
        FEEC.getDisciplinasOferecidas().add(EA772);

        Disciplina EE532 = new Disciplina("Eletrônica Aplicada I", 4, "EE532", lyra);
        lyra.addDisciplina(EE532);
        disciplinasFEEC.add(EE532);
        FEEC.getDisciplinasOferecidas().add(EE532);

        //Disciplinas do IQ//
        Disciplina QG108 = new Disciplina("Química Geral Teórica", 4, "QG108", pablo);
        pablo.addDisciplina(QG108);
        disciplinasIQ.add(QG108);
        IQ.getDisciplinasOferecidas().add(QG108);

        Disciplina QG109 = new Disciplina("Química Geral Experimental", 4, "QG109", pablo);
        pablo.addDisciplina(QG109);
        disciplinasIQ.add(QG109);
        IQ.getDisciplinasOferecidas().add(QG109);

        Disciplina QO321 = new Disciplina("Química Orgânica I", 4, "QO321", pablo);
        pablo.addDisciplina(QO321);
        disciplinasIQ.add(QO321);
        IQ.getDisciplinasOferecidas().add(QO321);

        //Instanciação de cursos//
        Curso engComp = new Curso(34,new ArrayList<Disciplina>(), 30, 70, 20, "Diurno", 10);
        for(int i = 0; i < disciplinasCB.size(); i++)//Adiciona as matérias do Ciclo Básico das engenharias//
            engComp.getArvoreIntegralizacao().add(disciplinasCB.get(i));
        for(int i = 0; i < disciplinasIC.size(); i++)//Adiciona matérias específicas//
            engComp.getArvoreIntegralizacao().add(disciplinasIC.get(i));
        for(int i = 0; i < disciplinasFEEC.size(); i++)//Adiciona matérias de fora do instituto//
            engComp.getArvoreIntegralizacao().add(disciplinasFEEC.get(i));
        cursos.add(engComp);

        Curso engEletrica = new Curso(11, new ArrayList<Disciplina>(), 30, 62, 20, "Diurno", 10);
        for(int i = 0; i < disciplinasCB.size(); i++)
            engEletrica.getArvoreIntegralizacao().add(disciplinasCB.get(i));
        for(int i = 0; i < disciplinasFEEC.size(); i++)
            engEletrica.getArvoreIntegralizacao().add(disciplinasFEEC.get(i));  
        engEletrica.getArvoreIntegralizacao().add(MC102);
        cursos.add(engEletrica);

        Curso engQuimica = new Curso(9, new ArrayList<Disciplina>(), 22, 60, 20, "Noturno", 10);
        for(int i = 0; i < disciplinasCB.size(); i++)
            engQuimica.getArvoreIntegralizacao().add(disciplinasCB.get(i));
        for(int i = 0; i < disciplinasIQ.size(); i++)
            engQuimica.getArvoreIntegralizacao().add(disciplinasIQ.get(i));
        engQuimica.getArvoreIntegralizacao().add(MC102);
        cursos.add(engQuimica);
    }

    //Getters estaticos para o acesso dos dados diretamente na main//
    public static ArrayList<Professor> getProfessor(){
        return professores;
    }

    public static ArrayList<Instituto> getInstitutos(){
        return institutos;
    }

    public static ArrayList<Curso> getCursos(){
        return cursos;
    }
}
