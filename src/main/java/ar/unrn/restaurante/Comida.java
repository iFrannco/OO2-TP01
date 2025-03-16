package ar.unrn.restaurante;

public class Comida {
    private String nombre;
    private float precio;

    public Comida(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public float obtenerPrecio() {
        return this.precio;
    }
}
