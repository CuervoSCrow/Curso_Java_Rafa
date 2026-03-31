package misClases;

import misClases.Animal;

public class Gato extends Animal{
    public String color;

    public Gato(String nombre, int edad,String color) {
        super("Gato",nombre,edad);
        this.color = color;
    }

    public void cazar(){
        System.out.println(nombre+" de "+edad+" años, esta cazando");
    }
}