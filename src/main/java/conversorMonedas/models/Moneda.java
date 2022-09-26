package conversorMonedas.models;

public class Moneda {

    private TipoMoneda tipoMoneda;
    private Double valor;

    public Moneda(TipoMoneda tipoMoneda, Double valor) {
        this.tipoMoneda = tipoMoneda;
        this.valor = valor;
    }

    public TipoMoneda getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(TipoMoneda tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
