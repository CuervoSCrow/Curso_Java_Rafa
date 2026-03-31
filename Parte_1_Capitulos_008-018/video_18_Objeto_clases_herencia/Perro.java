package misClases;

import misClases.Animal;

public class Perro extends Animal{
    public String raza;

    public Perro(String nombre,int edad,String raza) {
        super("Perro",nombre,edad);
        this.raza = raza;
    }

    public void moverCola(){
        System.out.println(nombre +" de "+edad+
                " años, esta moviendo la cola");
    }
}