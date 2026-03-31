import java.util.Scanner;
public class Calculadora{
    public static void main(String args[]){
        int operando1, operando2, resultado;
        char operacion;
        Scanner teclado = new Scanner(System.in);

        if(args.length!=2){
            System.out.println("Error. Se requieren 2 argumentos");
            return;
        }
        try{
            operando1 = Integer.parseInt(args[0]);
        }catch(Exception e){
            System.out.println("Error. El primer argumento debe ser un numero.");
            return;
        }
        try{
            operando2 = Integer.parseInt(args[1]);
        }catch(Exception e){
            System.out.println("Error. El segundo argumento debe ser un numero.");
            return;
        }
        do{
            System.out.println("Menu de Opciones:");
            System.out.println("******************");
            System.out.println("");
            System.out.println("(1) Suma.");
            System.out.println("(2) Resta.");
            System.out.println("(3) Multiplicación.");
            System.out.println("(4) División.");
            System.out.println("(5) Salir del programa.");
            System.out.println("Seleccione su opción: ");
            operacion = teclado.next().charAt(0);
            switch(operacion){
                case'1':
                    resultado=operando1+operando2;
                    System.out.println("El resultado de la suma es: "+resultado);
                break;
                case'2':
                    resultado=operando1-operando2;
                    System.out.println("El resultado de la resta es: "+resultado);
                    break;
                case'3':
                    resultado=operando1*operando2;
                    System.out.println("El resultado de la multiplicación es: "+resultado);
                    break;
                case'4':
                    resultado=operando1/operando2;
                    System.out.println("El resultado de la división es: "+resultado);
                    break;
                case'5':
                    System.out.println("Cerrando el programa...........");
                    break;
                default:
                    System.out.println("Error. Operación inexistente.");
            }

        }while(operacion != '5');
    }
}