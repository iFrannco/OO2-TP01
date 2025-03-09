package ar.unrn.testing;

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

    public int obtenerId() {
        return this.id;
    }


    @Override
    public boolean equals(Object obj) {
        Participante participante = (Participante) obj;
        return this.id == participante.obtenerId();
    }
}
