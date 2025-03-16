package ar.unrn.restaurante;

public class TarjetaComarcaPlus implements Tarjeta {
    private float porcentajeDescuento = 0.02F;

    @Override
    public float aplicarDescuento(float bebidas, float comidas) {
        return (bebidas + comidas) - ((bebidas + comidas) * porcentajeDescuento);
    }
}
