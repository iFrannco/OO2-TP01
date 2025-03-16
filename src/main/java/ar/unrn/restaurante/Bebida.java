package ar.unrn.restaurante;

public class Bebida {
    private String nombre;
    private float precio;


    public Bebida(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public float obtenerPrecio() {
        return this.precio;
    }
}
