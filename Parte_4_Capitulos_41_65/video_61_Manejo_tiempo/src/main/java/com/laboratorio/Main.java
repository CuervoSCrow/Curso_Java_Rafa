package com.laboratorio;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {

    public static void calcularEdad(int dia,int mes, int anno){
        LocalDate fechaNacimiento = LocalDate.of(anno,mes,dia);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        System.out.println("La persona tiene: " + periodo.getYears() + " años, "+
                periodo.getMonths() + " meses, " + periodo.getDays() + " dias.");

//        Mostrar la fecha de nacimiento con el formato dd//mm//yyyy
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNacimientoStr = fechaNacimiento.format(formato);
        System.out.println("La fecha de nacimiento es: " + fechaNacimientoStr);
    }
    public static void horaPais(String zonaHoraria){
        ZoneId zoneId = ZoneId.of(zonaHoraria);
        ZonedDateTime fechaHoraPais = ZonedDateTime.now(zoneId);
        System.out.println("Fecha y hora en la zona horaria indicada: "+fechaHoraPais);
    }
//    De API nueva a API antigua
    public static void conversionAFechaAntigua(){
        ZoneId zonaHorario = ZoneId.systemDefault();
        LocalDateTime fechaNueva= LocalDateTime.now(zonaHorario);

        Date fechaAntigua = Date.from(fechaNueva.atZone(zonaHorario).toInstant());
        System.out.println("Fecha antigua: " + fechaAntigua);
    }
    public static void conversionAFechaNueva(){
        Date fechaAntigua = new Date();
        ZoneId zonaHorario = ZoneId.systemDefault();
        Instant instant = fechaAntigua.toInstant();
        LocalDateTime fechaNueva = instant.atZone(zonaHorario).toLocalDateTime();

        System.out.println("Fecha nueva: " + fechaNueva);
    }
    public static void main(String[] args) {
        calcularEdad(18,11,1983);
        horaPais("Asia/Tokyo");
        conversionAFechaAntigua();
        conversionAFechaNueva();

    }
}