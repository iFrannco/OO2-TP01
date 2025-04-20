package ar.unrn.concurso;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegistradorEnArchivo implements Registrador {
    private String path;

    public RegistradorEnArchivo(String path) {
        this.path = path;
    }

    @Override
    public void registrar(LocalDate fecha, int idConcurso, int idParticipante) throws IOException {
        String datos = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", " + idConcurso + ", " + idParticipante;
        File file = new File(this.path);
        FileWriter fr = new FileWriter(file, true);
        fr.write(datos + System.lineSeparator());
        fr.close();
    }
}
