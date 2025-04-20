package ar.unrn.concurso;

import ar.unrn.restaurante.ProveedorDeFechasFake;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {
    @Test
    public void inscribirParticipanteEnFechaIntermedia() throws IOException {
        // Set up
        var registrador = new RegistradorFake();
        var proveedorFechas = new ProveedorDeFechasFake();
        var miConcurso = new Concurso(1, "rifa", LocalDate.of(2024, 1, 1), LocalDate.of(2025, 12, 1), registrador, proveedorFechas);
        var participante = new Participante(1, "lucas");

        // Excercise
        miConcurso.inscribirParticipante(participante);

        // Verify
        assertEquals(0, participante.obtenerPuntos());
        assertTrue(miConcurso.existeParticipante(participante));
        assertEquals(1, miConcurso.cantidadDeParticipantes());
        assertEquals("01/01/2025, 1, 1", registrador.getDatos());
    }

    @Test
    public void inscribirParticipanteEnElPrimerDia() throws IOException {
        // Set up
        var registrador = new RegistradorFake();
        var proveedorFechas = new ProveedorDeFechasFake();
        var miConcurso = new Concurso(2, "otra rifa", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 9), registrador, proveedorFechas);
        var participante = new Participante(2, "matias");

        // Excercise
        miConcurso.inscribirParticipante(participante);

        // Verify
        assertTrue(miConcurso.existeParticipante(participante));
        assertEquals(10, participante.obtenerPuntos());
        assertEquals("01/01/2025, 2, 2", registrador.getDatos());
    }

    @Test
    public void inscribirParticipanteFueraDeFecha() {
        // Set up
        var registrador = new RegistradorFake();
        var proveedorFechas = new ProveedorDeFechasFake();
        var miConcurso = new Concurso(3, "bingo", LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 9), registrador, proveedorFechas);
        var participante = new Participante(3, "mariano");

        // Excercise
        Exception exception = assertThrows(RuntimeException.class, () -> {
            miConcurso.inscribirParticipante(participante);
        });

        // Verify
        assertFalse(miConcurso.existeParticipante(participante));
        assertEquals(0, miConcurso.cantidadDeParticipantes());
        assertFalse(miConcurso.existeParticipante(participante));
        assertEquals("No se pudo inscribir al participante, fecha fuera de rango", exception.getMessage());
    }

    @Test
    public void concursoConFechasInvertidas() throws IOException {
        // Set up
        var registrador = new RegistradorFake();
        var proveedorFechas = new ProveedorDeFechasFake();

        // Excercise/Verify
        assertThrows(RuntimeException.class, () -> {
            var miConcurso = new Concurso(4, "mega bingo", LocalDate.of(2026, 1, 1), LocalDate.of(2025, 1, 1), registrador, proveedorFechas);
        });

    }
}
