package ar.unrn.restaurante;

public class TarjetaViedma implements Tarjeta {
    private float porcentajeDescuento = 0.03F;

    @Override
    public float aplicarDescuento(float bebidas, float comidas) {
        return bebidas + comidas;
    }
}
