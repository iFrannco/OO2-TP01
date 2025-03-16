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
        if (fechaInicio.isAfter(fechaFin)) {
            throw new RuntimeException("La fecha de inicio tiene que ser anterior a la fecha de fin");
        }
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.inscriptos = new ArrayList<Inscripcion>();
    }

    public void inscribirParticipante(Participante participante) {
        var inscripcion = new Inscripcion(participante, this, LocalDate.now());

        if (LocalDate.now().isBefore(this.fechaFin.plusDays(1)) && LocalDate.now().isAfter(this.fechaInicio.plusDays(-1))) {
            if (LocalDate.now().equals(this.fechaInicio)) {
                participante.sumarPuntos(10);
            }
            inscriptos.add(inscripcion);
        } else {
            throw new RuntimeException("No se pudo inscribir al participante, fecha fuera de rango");
        }
    }

    public boolean existeParticipante(Participante participante) {
        return this.inscriptos.stream().anyMatch(i -> i.perteneceA(participante));
    }

    public int cantidadDeParticipantes() {
        return inscriptos.size();
    }
}
