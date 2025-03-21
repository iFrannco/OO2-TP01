package ar.unrn.restaurante;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestauranteTest {
    @Test
    public void pagoConTarjetaVisa() {
        // set up
        Tarjeta tarjeta = new TarjetaVisa();
        Bebida bebida1 = new Bebida("coca-cola", 5000f);
        Bebida bebida2 = new Bebida("fernet", 5000f);
        Comida comida1 = new Comida("pizza", 8000f);

        Map<Bebida, Integer> bebidas = new HashMap<>();
        Map<Comida, Integer> comidas = new HashMap<>();

        bebidas.put(bebida1, 1);
        bebidas.put(bebida2, 1);
        comidas.put(comida1, 1);

        Dispositivo dispositivo = new Dispositivo(bebidas, comidas, tarjeta, Propina.BAJO);

        // excecute
        float total = dispositivo.calcularCostoTotal();

        // verify
        assertEquals(18054f, total);
    }

    @Test
    public void pagoConTarjetaMastercard() {
        // set up
        Tarjeta tarjeta = new TarjetaMastercard();
        Bebida bebida1 = new Bebida("coca-cola", 5000f);
        Bebida bebida2 = new Bebida("fernet", 5000f);
        Comida comida1 = new Comida("pizza", 10000f);

        Map<Bebida, Integer> bebidas = new HashMap<>();
        Map<Comida, Integer> comidas = new HashMap<>();

        bebidas.put(bebida1, 1);
        bebidas.put(bebida2, 1);
        comidas.put(comida1, 1);

        Dispositivo dispositivo = new Dispositivo(bebidas, comidas, tarjeta, Propina.BAJO);

        // excecute
        float total = dispositivo.calcularCostoTotal();

        // verify
        assertEquals(20196f, total);
    }

    @Test
    public void pagoConTarjetaComarcaPlus() {
        // set up
        Tarjeta tarjeta = new TarjetaComarcaPlus();
        Bebida bebida1 = new Bebida("coca-cola", 5000f);
        Bebida bebida2 = new Bebida("fernet", 5000f);
        Comida comida1 = new Comida("pizza", 10000f);

        Map<Bebida, Integer> bebidas = new HashMap<>();
        Map<Comida, Integer> comidas = new HashMap<>();

        bebidas.put(bebida1, 1);
        bebidas.put(bebida2, 1);
        comidas.put(comida1, 1);

        Dispositivo dispositivo = new Dispositivo(bebidas, comidas, tarjeta, Propina.BAJO);

        // excecute
        float total = dispositivo.calcularCostoTotal();

        // verify
        assertEquals(19992f, total);
    }

    @Test
    public void pagoConTarjetaViedma() {
        // set up
        Tarjeta tarjeta = new TarjetaViedma();
        Bebida bebida1 = new Bebida("coca-cola", 4000f);
        Bebida bebida2 = new Bebida("fernet", 8000f);
        Comida comida1 = new Comida("pizza", 7500f);

        Map<Bebida, Integer> bebidas = new HashMap<>();
        Map<Comida, Integer> comidas = new HashMap<>();

        bebidas.put(bebida1, 1);
        bebidas.put(bebida2, 1);
        comidas.put(comida1, 1);

        Dispositivo dispositivo = new Dispositivo(bebidas, comidas, tarjeta, Propina.BAJO);

        // excecute
        float total = dispositivo.calcularCostoTotal();

        // verify
        assertEquals(19890f, total);
    }
}
