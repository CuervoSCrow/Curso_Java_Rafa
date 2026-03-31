import java.util.Scanner;

public class Areas{
    static char menuOpciones(){
        char opcion;
        Scanner teclado = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("****************");
        System.out.println("Menu de Opciones");
        System.out.println("****************");
        System.out.println("(1) Calcular el area de un circulo.");
        System.out.println("(2) Calcular el area de un triangulo.");
        System.out.println("(3) Calcular el area de un cuadrado.");
        System.out.println("(4) Fin del Programa.");
        System.out.println("");
        System.out.println("Indique su opción: ");

        opcion=teclado.next().charAt(0);

        return opcion;
    }
    static double obtenerDato(String nombreDato){
        double dato;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese "+nombreDato+": ");
        try{
            dato = teclado.nextDouble();
        }catch(Exception e){
            System.out.println("Error !! El valor debe ser numerico.");
            return 0;
        }
        return dato;
    }

    static double areaCirculo(double radio){
        double area;
        area = (radio * radio) * Math.PI;
        return area;
    }
    static double areaTriangulo(double base,double altura){
        double area;
        area=(base*altura)/2;
        return area;
    }
    static double areaCuadrado(double lado){
        double area;
        area=lado*lado;
        return area;
    }
    static void mostrarResultado(double area){
        System.out.println("");
        System.out.println("*********");
        System.out.println("Resultado");
        System.out.println("*********");
        System.out.println("El Area Calculada es: "+area);

    }
    static void errorCero(){
        System.out.println("Error debe ser mayor a 0");
    }
    public static void main (String args[]){
        char opcion;
        double radio, base, altura, lado,area;

        do{
            opcion = menuOpciones();
            switch (opcion){
                case '1':
                    radio=obtenerDato("La longitud del radio del circulo");
                    if(radio!=0){
                        area=areaCirculo(radio);
                        mostrarResultado(area);
                    }else{
                        errorCero();
                    }
                    break;
                case '2':
                    base = obtenerDato("La longitud de la base del triangulo");
                    if(base!=0) {
                        altura = obtenerDato("La longitud de la altura del triangulo");
                        if(altura!=0) {
                            area = areaTriangulo(base, altura);
                            mostrarResultado(area);
                        }
                        else{
                            errorCero();
                        }
                    }
                    else {
                        errorCero();
                    }
                    break;
                case '3':
                    lado = obtenerDato("La longitud del lado del cuadrado: ");
                    if(lado!=0) {
                        area = areaCuadrado(lado);
                        mostrarResultado(area);
                    }else {
                        errorCero();
                    }
                    break;
                case '4': break;
                default:
                    System.out.println("Error.. Opcion Inexistente");
                    break;
            }
        }while(opcion != '4');
    }
}