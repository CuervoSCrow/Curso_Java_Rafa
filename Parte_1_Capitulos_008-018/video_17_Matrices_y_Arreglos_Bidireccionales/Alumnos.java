import java.util.Scanner;

public class Alumnos{

//    Mostrar en pantalla el listado de alumnos

    static void mostrarListado(String nombres[],int notas[][]){
        int i;
        System.out.println("");
        System.out.println("");
        System.out.println("*****************************************");
        System.out.println("Listado de alumnos (nombre & definitiva)");
        System.out.println("*****************************************");
        for(i=0;i<nombres.length;i++){
            System.out.println(i+1+"- "+nombres[i] + " obtuvo "+notas[i][3]);
        }
        System.out.println("");
    }

//    Devuelve el nombre de un alumno
    static String leerNombre(int pos){
        String nombre;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre del alumno "+pos+": ");
        nombre = teclado.nextLine();


        return nombre.trim();
    }
//    Devuelve la nota del trimestre "nTrim" de un alumno "nombre" o -1 en caso de error
    static int leerNota(String nombre,int nTrim){
        int nota;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese la nota del trimestre "+nTrim+" del alumno "+nombre+": ");
        try{
            nota=teclado.nextInt();
        }catch(Exception e){
            System.out.println("Error. La nota debe ser un numero.");
            return -1;
        }
        if((nota<1) || (nota>10)){
            System.out.println("La nota debe ser un numero entre 1 y 10");
            return -1;
        }
        return nota;
    }
//    Calcular el promedio de un alumno
    static int calcularPromedio(int n1,int n2, int n3){
        double temp;
        int definitiva;
        temp= n1+n2+n3;
        temp=temp/3;
        definitiva=(int)Math.round(temp);
        return  definitiva;
    }
    public static void main(String args[]){
        Scanner teclado = new Scanner(System.in);
        int nAlumnos,i,j;
        String nombres[];
        int notas[][];
        double acumGen=0,promedio;

//    Captura el numero de alumnos
        System.out.println("Indique el numero de alumnos del seccion: ");
        try{
            nAlumnos = teclado.nextInt();
        }catch(Exception e){
            System.out.println("Error. El valor debe ser un numero.");
            return;
        }
//        Iniicalización de los arreglos
        nombres=new String[nAlumnos];
        notas= new int[nAlumnos][4];

//        Capturar los datos de los alumnos
        for(i=0;i<nAlumnos;i++) {
//            Leer el nombre de los alumnos
            do {
                nombres[i] = leerNombre(i + 1);
                if (nombres[i].length() == 0) {
                    System.out.println("Error. El nombre no puede estar vacio");
                }
            } while (nombres[i].length() == 0);

//        Leer las notas del alumno i
            for(j=0;j<3;j++){
                do{
                    notas[i][j] = leerNota(nombres[i],j+1);
                }while(notas[i][j]==-1);
            }
            //        Calcular la definitiva del alumno
            notas[i][3]=calcularPromedio(notas[i][0],notas[i][1],notas[i][2]);

            //        Acumular las notas para calcular el promedio
            acumGen += notas[i][3];
        }
//        Calcular el promedio de notas de la seccion
        promedio = acumGen / nAlumnos;

//        Mostrar listado de los alumnos
        mostrarListado(nombres,notas);

//        Mostrar el promedio
        System.out.println("El promedio de la seccion es: "+promedio);


    }



}
