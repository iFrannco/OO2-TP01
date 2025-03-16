package ar.unrn.testing;

import java.util.Objects;

public class Participante {
    private int id;
    private String nombre;
    private int puntos;

    public Participante(int id, String nombre) {
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
