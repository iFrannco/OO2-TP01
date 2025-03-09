package ar.unrn.testing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Inscripcion> inscriptos;

    public Concurso(String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.inscriptos = new ArrayList<Inscripcion>();
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        if (inscripcion.obtenerFecha().isBefore(this.fechaFin) && inscripcion.obtenerFecha().isAfter(this.fechaInicio)) {
            inscriptos.add(inscripcion);
        } else if (inscripcion.obtenerFecha().equals(this.fechaInicio)) {
            inscripcion.obtenerParticipante().sumarPuntos(10);
            inscriptos.add(inscripcion);
        }

    }

    public boolean existeParticipante(Participante participante) {
        return this.inscriptos.stream().anyMatch(i -> i.obtenerParticipante().equals(participante));
    }
}
