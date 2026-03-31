package  misClases;

public class Animal{
    public String tipo;
    public String nombre;
    public int edad;

    public Animal(String tipo,
                  String nombre,
                  int edad) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.edad = edad;
    }
    public void comer(){
        System.out.println(nombre+" de "+edad+" años, esta comiendo.");
    }
    public  void caminar(){
        System.out.println(nombre+" de "+edad+" años, esta caminando.");
    }
    public void dormir(){
        System.out.println(nombre+" de "+edad+" años,esta durmiendo.");
    }
}