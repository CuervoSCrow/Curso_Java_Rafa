import misClases.Perro;
import misClases.Gato;

public class EjemploHerencia{
    public static void main(String args[]){
        Perro objeto1;
        Gato objeto2;

//        Instanciar los objetos
        objeto1 = new Perro("Rintintin",4,"Galo");
        objeto2 = new Gato("Capitán",5,"Gris");

//        Ejecutar funciones de la clase padre
        objeto1.comer();
        objeto2.caminar();

//        Ejectura funciones propias de la clase
        objeto1.moverCola();
        objeto2.cazar();
    }
}