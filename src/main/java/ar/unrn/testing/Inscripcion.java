package ar.unrn.testing;

import java.time.LocalDate;

public class Inscripcion {
    private Participante participante;
    private Concurso concurso;
    private LocalDate fecha;

    public Inscripcion(Participante participante, Concurso concurso, LocalDate fecha) {
        this.participante = participante;
        this.concurso = concurso;
        this.fecha = fecha;
    }

    public LocalDate obtenerFecha() {
        return this.fecha;
    }

    public Participante obtenerParticipante() {
        return this.participante;
    }
}
