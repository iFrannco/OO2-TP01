package ar.unrn.restaurante;

import java.io.IOException;
import java.time.LocalDate;

public interface Exportador {
    void exportar(LocalDate fecha, float montoTotal) throws IOException;
}
