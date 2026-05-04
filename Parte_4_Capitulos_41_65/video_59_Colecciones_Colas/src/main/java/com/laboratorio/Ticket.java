package com.laboratorio;

public class Ticket implements Comparable<Ticket> {
    private String color;
    private int orden;

    public Ticket(String color, int orden) {
        this.color = color;
        this.orden = orden;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int compareTo(Ticket o) {
        int t1,t2;
        if(this.color.equalsIgnoreCase("ROJO")){
            t1=1;
        }else{
            if(this.color.equalsIgnoreCase("AMARILLO")){
                t1=2;
            }else{
                if(this.color.equalsIgnoreCase("AZUL")){
                    t1=3;
                }else{
                    t1=4;
                }
            }
        }
        if(o.getColor().equalsIgnoreCase("ROJO")){
            t2=1;
        }else{
            if(o.getColor().equalsIgnoreCase("AMARILLO")){
                t2=2;
            }else{
                if(o.getColor().equalsIgnoreCase("AZUL")){
                    t2=3;
                }else{
                    t2=4;
                }
            }
        }

        if(t1<t2){
            return -1;
        }
        if(t1>t2){
            return 1;
        }
        if(this.orden<o.getOrden()){
            return -1;
        }
        if(this.orden>o.getOrden()){
            return 1;
        }
        return 0;
    }

    public void escribir(){
        System.out.println(color+" ("+orden+")");
    }
}
