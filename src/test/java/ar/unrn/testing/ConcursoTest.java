package ar.unrn.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {
    @Test
    public void inscribirParticipanteEnFechaIntermedia() {
        // Set up
        var miConcurso = new Concurso("rifa", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 1));
        var participante = new Participante(1, "lucas");

        // Excercise
        miConcurso.inscribirParticipante(participante);

        // Verify
        assertTrue(miConcurso.existeParticipante(participante));
        assertEquals(1, miConcurso.cantidadDeParticipantes());
    }

    @Test
    public void inscribirParticipanteEnElPrimerDia() {
        // Set up
        var miConcurso = new Concurso("otra rifa", LocalDate.now(), LocalDate.of(2025, 12, 9));
        var participante = new Participante(2, "matias");

        // Excercise
        miConcurso.inscribirParticipante(participante);

        // Verify
        assertTrue(miConcurso.existeParticipante(participante));
        assertEquals(10, participante.obtenerPuntos());
    }

    @Test
    public void inscribirParticipanteFueraDeFecha() {
        // Set up
        var miConcurso = new Concurso("bingo", LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 9));
        var participante = new Participante(2, "emilio");

        // Excercise
        assertThrows(RuntimeException.class, () -> {
            miConcurso.inscribirParticipante(participante);
        });

        // Verify
        assertFalse(miConcurso.existeParticipante(participante));
        assertEquals(0, miConcurso.cantidadDeParticipantes());
        assertFalse(miConcurso.existeParticipante(participante));
    }
}
