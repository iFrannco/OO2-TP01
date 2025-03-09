package ar.unrn.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConcursoTest {
    @Test
    public void inscribirParticipanteUsandoRangoDeFechas() {
        // Set up
        var miConcurso = new Concurso("rifa", LocalDate.of(2025, 3, 1), LocalDate.of(2025, 3, 9));
        var participante = new Participante(1, "lucas");
        var inscripcion = new Inscripcion(participante, miConcurso, LocalDate.of(2025, 3, 5));

        // Excercise
        miConcurso.agregarInscripcion(inscripcion);

        // Verify
        assertTrue(miConcurso.existeParticipante(participante));
    }

    @Test
    public void inscribirParticipanteEnElPrimerDia() {
        // Set up
        var miConcurso = new Concurso("otra rifa", LocalDate.of(2025, 3, 1), LocalDate.of(2025, 3, 9));
        var participante = new Participante(2, "matias");
        var inscripcion = new Inscripcion(participante, miConcurso, LocalDate.of(2025, 3, 1));

        // Excercise
        miConcurso.agregarInscripcion(inscripcion);

        // Verify
        assertTrue(miConcurso.existeParticipante(participante));
    }

    @Test
    public void inscribirParticipanteFueraDeFecha() {
        // Set up
        var miConcurso = new Concurso("bingo", LocalDate.of(2025, 3, 1), LocalDate.of(2025, 3, 9));
        var participante = new Participante(2, "emilio");
        var inscripcion = new Inscripcion(participante, miConcurso, LocalDate.of(2025, 5, 1));

        // Excercise
        miConcurso.agregarInscripcion(inscripcion);

        // Verify
        assertFalse(miConcurso.existeParticipante(participante));
    }
}
