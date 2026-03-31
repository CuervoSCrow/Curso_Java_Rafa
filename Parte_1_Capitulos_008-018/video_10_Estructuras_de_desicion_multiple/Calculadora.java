public class Calculadora{
    public static void main(String args[]){
        int operando1, operando2, resultado;
        String operacion;

        if(args.length != 3){
            System.out.println("Error. La operación requiere de 3 elementos.");
            System.out.println("Uso: Calculadora numero1 operacion numero2");
            return;
        }
        try {
            operando1 = Integer.parseInt(args[0]);
        }catch(Exception e){
            System.out.println("Error: El primer argumento debe ser un numero");
            return;
        }
        operacion = args[1];
        try {
            operando2 = Integer.parseInt(args[2]);
        }catch(Exception e){
            System.out.println("Error: El segundo argumento debe ser un numero");
            return;
        }

        switch (operacion){
           case  "+":
                resultado=operando1+operando2;
                System.out.println("El resultado de la suma es: "+resultado);
                break;
            case "-":
                resultado=operando1-operando2;
                System.out.println("El resultado de la resta es: "+resultado);
                break;
            case "x":
            case "X":
                resultado=operando1*operando2;
                System.out.println("El resultado de la multiplicación es: "+resultado);
                break;
            case "/":
                resultado=operando1/operando2;
                System.out.println("El resultado de la division es: "+resultado);
                break;
            default:
                System.out.println("Error. Operacion desconocida");
                break;
        }
    }
}