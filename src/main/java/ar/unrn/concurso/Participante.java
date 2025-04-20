package ar.unrn.concurso;

import java.util.Objects;

public class Participante {
    private int id;
    private String nombre;
    private int puntos;

    public Participante(int id, String nombre) {
        if (nombre.equals("")) {
            throw new RuntimeException("El nombre no puede estar vacio");
        }
        this.id = id;
        this.nombre = nombre;
        this.puntos = 0;
    }

    public void sumarPuntos(int puntos) {
        this.puntos = this.puntos + puntos;
    }

    public int obtenerPuntos() {
        return this.puntos;
    }

    public int obtenerId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
