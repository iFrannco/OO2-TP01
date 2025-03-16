package ar.unrn.restaurante;

public enum Propina {
    BAJO(0.02F),
    MEDIO(0.03F),
    ALTO(0.05F);

    private final float porcentajeDelTotal;

    Propina(float porcentajeDelTotal) {
        this.porcentajeDelTotal = porcentajeDelTotal;
    }

    public float porcentaje() {
        return porcentajeDelTotal;
    }
}
