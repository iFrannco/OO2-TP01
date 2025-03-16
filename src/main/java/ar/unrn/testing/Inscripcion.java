package ar.unrn.testing;

import java.time.LocalDate;

class Inscripcion {
    private Participante participante;
    private Concurso concurso;
    private LocalDate fecha;

    public Inscripcion(Participante participante, Concurso concurso, LocalDate fecha) {
        this.participante = participante;
        this.concurso = concurso;
        this.fecha = fecha;
    }

    public boolean perteneceA(Participante participante) {
        return this.participante.equals(participante);
    }
}
