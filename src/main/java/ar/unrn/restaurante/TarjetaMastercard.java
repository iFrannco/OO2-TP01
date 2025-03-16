package ar.unrn.restaurante;

public class TarjetaMastercard implements Tarjeta {
    private float porcentajeDescuento = 0.02F;

    @Override
    public float aplicarDescuento(float bebidas, float comidas) {
        return (comidas - (porcentajeDescuento * comidas)) + bebidas;
    }
}
