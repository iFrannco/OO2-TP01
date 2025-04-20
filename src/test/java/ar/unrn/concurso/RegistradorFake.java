package ar.unrn.concurso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegistradorFake implements Registrador {
    private String datos;

    @Override
    public void registrar(LocalDate fecha, int idConcurso, int idParticipante) {
        this.datos = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", " + idConcurso + ", " + idParticipante;
    }

    public String getDatos() {
        return this.datos;
    }
}
