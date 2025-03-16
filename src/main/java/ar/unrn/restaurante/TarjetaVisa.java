package ar.unrn.restaurante;

public class TarjetaVisa implements Tarjeta {

    private float porcentajeDescuento = 0.03F;

    @Override
    public float aplicarDescuento(float bebidas, float comidas) {
        return (bebidas - (porcentajeDescuento * bebidas)) + comidas;
    }
}
