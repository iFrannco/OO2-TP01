package ar.unrn.concurso;

import ar.unrn.restaurante.ProveedorDeFechas;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private int id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Inscripcion> inscriptos;
    private Registrador registrador;
    private ProveedorDeFechas proveedorFechas;

    public Concurso(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, Registrador registrador, ProveedorDeFechas proveedorFechas) {
        if (fechaInicio.isAfter(fechaFin)) {
            throw new RuntimeException("La fecha de inicio tiene que ser anterior a la fecha de fin");
        }
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.inscriptos = new ArrayList<>();
        this.registrador = registrador;
        this.proveedorFechas = proveedorFechas;
    }

    public void inscribirParticipante(Participante participante) throws IOException {
        LocalDate fechaDeHoy = this.proveedorFechas.obtenerFecha();
        var inscripcion = new Inscripcion(participante, this, fechaDeHoy);
        
        if (fechaDeHoy.isBefore(this.fechaFin.plusDays(1)) && fechaDeHoy.isAfter(this.fechaInicio.plusDays(-1))) {
            if (fechaDeHoy.equals(this.fechaInicio)) {
                participante.sumarPuntos(10);
            }
            inscriptos.add(inscripcion);

            registrador.registrar(fechaDeHoy, this.id, participante.obtenerId());

        } else {
            throw new RuntimeException("No se pudo inscribir al participante, fecha fuera de rango");
        }
    }

    public boolean existeParticipante(Participante participante) {
        return this.inscriptos.stream().anyMatch(i -> i.perteneceA(participante));
    }

    public int cantidadDeParticipantes() {
        return inscriptos.size();
    }
}
