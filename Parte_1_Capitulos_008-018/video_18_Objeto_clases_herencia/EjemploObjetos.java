import misClases.Animal;

public class EjemploObjetos{
    public static void main(String args[]){
        Animal obj1,obj2;
//        Creación de los objetos
        obj1 = new Animal("Perro","Rintintin",4);
        obj2 = new Animal("Gato","Capitan",5);

//        Ejecucción de los metodos
        obj1.comer();
        obj2.caminar();
    }
}