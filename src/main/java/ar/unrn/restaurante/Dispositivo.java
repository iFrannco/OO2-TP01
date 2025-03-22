package ar.unrn.restaurante;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class Dispositivo {
    private Map<Comida, Integer> comidas;
    private Map<Bebida, Integer> bebidas;
    private Tarjeta tarjeta;
    private Propina propina;
    private Exportador exportador;

    public Dispositivo(Map<Bebida, Integer> bebidas, Map<Comida, Integer> comidas, Tarjeta tarjeta, Propina propina, Exportador exportador) {
        // Validar que no esten vacios los maps
        this.bebidas = bebidas;
        this.comidas = comidas;
        this.tarjeta = tarjeta;
        this.propina = propina;
        this.exportador = exportador;
    }

    public float calcularCostoTotal() throws IOException {
        float totalBebidas = 0f;
        float totalComidas = 0f;

        // No le pregunto el tipo que es y en base a eso tomo una accion u otra
        // sino que simplemente a todas las bebidas y comidas, les sumo su valor.
        for (var b : bebidas.entrySet()) {
            totalBebidas += b.getKey().obtenerPrecio() * b.getValue();
        }
        for (var c : comidas.entrySet()) {
            totalComidas += c.getKey().obtenerPrecio() * c.getValue();
        }
        float totalConDescuento = this.tarjeta.aplicarDescuento(totalBebidas, totalComidas);
        float totalConPropina = (this.propina.porcentaje() * totalConDescuento) + totalConDescuento;

        this.exportador.exportar(LocalDate.now(), totalConPropina);
        return totalConPropina;
    }
}
