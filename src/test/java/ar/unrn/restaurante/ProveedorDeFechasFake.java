package ar.unrn.restaurante;

import java.time.LocalDate;

public class ProveedorDeFechasFake implements ProveedorDeFechas {
    @Override
    public LocalDate obtenerFecha() {
        return LocalDate.of(2025, 1, 1);
    }
}
