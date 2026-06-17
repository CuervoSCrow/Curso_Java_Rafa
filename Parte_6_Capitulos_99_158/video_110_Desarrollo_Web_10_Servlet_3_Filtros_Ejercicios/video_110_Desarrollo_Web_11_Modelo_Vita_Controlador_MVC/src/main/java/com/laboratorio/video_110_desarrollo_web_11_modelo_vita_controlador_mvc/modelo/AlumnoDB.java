
package com.laboratorio.video_110_desarrollo_web_11_modelo_vita_controlador_mvc.modelo;

import java.util.List;

public class AlumnoDB {
    public List<Alumno> obtenerAlumnos(){
        return List.of(
                new Alumno("Pedro","Perez",12),
                new Alumno("Olga","Castillo",11),
                new Alumno("Jorge","Martinez",12),
                new Alumno("Maria","hernandez",13) 
        );
    }
}
