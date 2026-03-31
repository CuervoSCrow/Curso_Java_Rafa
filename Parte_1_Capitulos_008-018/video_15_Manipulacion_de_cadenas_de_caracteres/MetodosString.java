public class MetodosString{
    public static void main(String[] args){
        String s="Laboratorio de rafa";
//        Longitu de la cadena
        System.out.println("***********************");
        System.out.println("Cadena: "+s);
        System.out.println("***********************");
        System.out.println("Longitud de la cadena. ");
        System.out.println("String lenght "+s.length());
//        Caracter de una posición
        System.out.println("Caracter de la posición 3");
        System.out.println("charAt(3)= "+s.charAt(3));
        //        Caracteres de una posición
        System.out.println("Subcadena a partir de una posición");
        System.out.println("Substring(12)= "+s.substring(12));
//        Subcadena entre 2 posiciones
        System.out.println("Subcadena entre 2 posiciones");
        System.out.println("Substring(2,6): "+s.substring(2,6));

        String s1 ="Laboratorio ";
        String s2 ="de Rafa";
        System.out.println("********************************");
        System.out.println("Cadena s1 = "+s1);
        System.out.println("Cadena s2 = "+s2);
        System.out.println("********************************");
//        Concatenar dos cadenas
        System.out.println("Concatenar s1.concat(s2): "+s1.concat(s2));
        System.out.println("Concatenar s1+s2: "+s1+s2);
//        Posicion de la primera ocurrencia de una subcadena
        System.out.println("Indice de Rafa s.indexOf(\"Rafa\"): "+s.indexOf("Rafa"));

        boolean out;

//        Resultado de varios   comparaciones
        out="Java".equals("java");
        System.out.println("Comprobando la igualdad \"Java\".equals(\"java\"): "+out);
        out="Java".equals("Java");
        System.out.println("Comprobando la igualdad \"Java\".equals(\"Java\"): "+out);
        out="Java".equalsIgnoreCase("jaVA");
        System.out.println("Comprobando la igualdad \"Java\".equalsIgnoreCase(\"jaVA\"): "+out);

        int res;

//        Coparación Lexográfica
//        si s1>s2 entonces res>0 ,si s1<s2     entonces res<0, si s1=s2 entonces res=0
        res=s1.compareTo(s2);
        System.out.println("Si s1 = s2: "+res);
//        Conversiones de mayusculas y minusculas
        System.out.println("Cambiando a minusculas: "+s.toLowerCase());
        System.out.println("Cambiando a mayusculas: "+s.toUpperCase());

        String s3 = " con espacios ";
        System.out.println("La cadena 3 contine espacios: ["+s3+"]");

//        Quitando espacios en blanco
        System.out.println("Quitando espacion en blanco s3.trim(): ["+s3.trim()+"]");

//        Remplazando un caracter por otro:
        System.out.println("Remplazando un caracter por otro: ");
        System.out.println("s.replace('a','@'):  "+s.replace('a','@'));
    }
}