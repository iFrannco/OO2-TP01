package ar.unrn.testing;

import java.io.IOException;
import java.time.LocalDate;

public interface Registrador {
    void registrar(LocalDate fecha, int idConcurso, int idParticipante) throws IOException;
}
