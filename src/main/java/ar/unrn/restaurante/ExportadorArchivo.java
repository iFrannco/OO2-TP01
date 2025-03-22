package ar.unrn.restaurante;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExportadorArchivo implements Exportador {
    private String path;

    public ExportadorArchivo(String path) {
        this.path = path;
    }

    @Override
    public void exportar(LocalDate fecha, float montoTotal) throws IOException {
        String datos = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " || " + montoTotal;
        File file = new File(this.path);
        FileWriter fr = new FileWriter(file, true);
        fr.write(datos + System.lineSeparator());
        fr.close();
    }
}
