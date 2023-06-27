package modelos;
import java.time.LocalDate;

public class Validacao {
    private Validacao(){}

    //Validação de CPF//
    public static boolean validaCPF(String cpf){
        String allNum;
        //Coloca um caractere vazio no lugar de todos os caracteres não-numéricos//
        allNum = cpf.replaceAll("[^0-9]","");

        int length = allNum.length();
        
        //Verifica o número de dígitos//
        if(length != 11)
            return false;
            
        //Verifica se todos os dígitos são iguais//
        char aux = allNum.charAt(0); char check = 0;
        for(int i = 1;i < length;i++){
            if(allNum.charAt(i) != aux)
                check = 1;				
        }
        if(check == 0)
            return false;

        //Cálculo dos dígitos verificadores//
        int checker, charToint, soma = 0;
        
        //Calcula o primeiro dígito verificador//
        for(int i = 0,j = 10;i < length-2; i++,j--){
            charToint = Character.getNumericValue(allNum.charAt(i));
            soma += charToint * j; 
        }

        if(soma % 11 == 0 || soma % 11 == 1){
            checker = 0;
        }else{
            checker = 11 - (soma % 11);
        }

        if(checker != Character.getNumericValue(allNum.charAt(9)))
            return false;
        
        soma = 0; checker = -1;

        //Calcula o segundo dígito verificador//
        for(int i = 1,j = 10;i < length-1; i++,j--){
            charToint = Character.getNumericValue(allNum.charAt(i));
            soma += charToint * j; 
        }
        
        if(soma % 11 == 0 || soma % 11 == 1){
            checker = 0;
        }else{
            checker = 11 - (soma % 11);
        }
        
        if(checker != Character.getNumericValue(allNum.charAt(10)))
            return false;
        
        //Se todas as verificações passarem retorna true//
        return true;
    }
    
    //Verificação de RG//
    public static boolean validaRG(String rg){
        //Coloca um caractere vazio no lugar de todos os caracteres não-numéricos//
        String allNum;
        allNum = rg.replaceAll("[^0-9xX]","");

        int length = allNum.length();
        
        //Verifica o numero de dígitos//
        if(length != 9)
            return false;
        
        //Verifica se todos os dígitos são iguais//
        char aux = allNum.charAt(0); char check = 0;
        for(int i = 1;i < length;i++){
            if(allNum.charAt(i) != aux)
                check = 1;				
        }
        if(check == 0)
            return false;

        //Calcula o dígito verificador//
        int ver = allNum.charAt(0)*2 + allNum.charAt(1)*3 + allNum.charAt(2)*4 + allNum.charAt(3)*5 + allNum.charAt(4)*6 + allNum.charAt(5)*7 + allNum.charAt(6)*8 + allNum.charAt(7)*9;
        ver = ver % 11;
        
        if(ver == 0){
            ver = 0;
        }if(ver == 1){
            ver = 10;
        }else{
            ver = 11 - ver;
        }

        //Compara o dígito verificador calculado com o dado//
        if(ver == 10){
            if(allNum.charAt(8) != 'x')
                return false;
        }else{
            if(Character.getNumericValue(allNum.charAt(8)) != ver)
                return false;
        }

        return true;
    }
    
    public static boolean validaEmail(String email){
        //Checa se o email dado tem a quantidade de caracteres padrão//
        if(email.length() != 22)
            return false;
        //Checa se o primeiro caractere é uma letra//
        if(!email.substring(0,0).matches("[a-zA-Z]"))
            return false;
        //Checa se a substring na sequência é um RA//
        if(!email.substring(1,6).matches("[0-9]"))
            return false;
        //Checa o formato do email universitário//    
        if(!email.substring(7,21).equals("@dac.unicamp.br"))
            return false;
        //Se todas as verificações passam, retorna true//
        return true;
    }

    public static String validaData(String data){
        //Coloca um caractere vazio no lugar de todos os caracteres não-numéricos//
        String allNum;
        allNum = data.replaceAll("[^0-9]","");
        
        //Separa o ano//
        int ano = Integer.parseInt(allNum.substring(4,7));
        
        //Checa se o ano é válido//
        if(ano >= 2023 || ano < 1900)
            return "Data Inválida!";
        
        //Separa o mes//
        int mes = Integer.parseInt(allNum.substring(2,3));
        
        //Checa se o mes é válido//
        if(mes > 12)
            return "Data inválida!";
        
        //Separa o dia//
        int dia = Integer.parseInt(allNum.substring(0,1));

        //Caso dos meses com 31 dias//
        if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
            if(dia > 31)
                return "Data inválida!";
        
        //Caso dos meses com 30 dias//
        if(mes == 4 || mes == 6 || mes == 9 || mes == 11)
            if(dia > 30)
                return "Data inválida!";
        
        //Caso do mes de Fevereiro// 
        if(mes == 2)
            if(LocalDate.of(ano,1,1).isLeapYear())//Checa se o ano é bissexto//
                if(dia > 29)
                    return "Data inválida!";
            
            if(!LocalDate.of(ano,1,1).isLeapYear())
                if(dia > 28)
                    return "Data inválida!";
        
        //Formata a data de maneira que ela sirva de parâmetro para a classe LocalDate//
        String dataFormatada = ano + "-" + mes + "-" + ano;
                    
        //Retorna uma data já formatada de acordo com o padrão da classe LocalDate//
        return dataFormatada;
    }
}
