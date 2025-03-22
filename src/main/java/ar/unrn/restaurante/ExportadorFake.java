package ar.unrn.restaurante;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExportadorFake implements Exportador {
    private String datos;

    @Override
    public void exportar(LocalDate fecha, float montoTotal) {
        this.datos = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " || " + montoTotal;
    }

    public String getDatos() {
        return this.datos;
    }
}
