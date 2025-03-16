package ar.unrn.restaurante;

import java.time.LocalDate;
import java.util.Map;

public class Pedido {
    private Map<ItemMenu, Integer> productos;
    private Tarjeta tarjeta;
    private int porcentajePropina;
    private float costoTotal;
    private LocalDate fecha;

    public Pedido(Map<ItemMenu, Integer> productos, Tarjeta tarjeta, int porcentajePropina) {
        this.productos = productos;
        this.tarjeta = tarjeta;
        this.porcentajePropina = porcentajePropina;
        this.fecha = LocalDate.now();

        this.calcularCostoTotal();
    }

    private void calcularCostoTotal() {
        float costoBebidas = 0;
        float costoComidas = 0;
        float costoTotal = 0;

        // recorrer el map y multiplicar el valor del item por la cantidad

//        if (this.tarjeta.getEntidadEmisora().equals("VISA")) {
//            // restarle el 3% a las bebidas
//        } else if (this.tarjeta.getEntidadEmisora().equals("MASTERCARD")) {
//            // restarle 2% a las comidas.
//        } else if (this.tarjeta.getEntidadEmisora().equals("Comarca Plus")) {
//            // restarle 2% a el total
//        }

        // restar el porcentaje de propina al total

    }

}
