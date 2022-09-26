package conversorTemperaturas.models;

public class Temperatura {
    private TipoTemperatura tipo;
    private Double valor;

    public Temperatura(TipoTemperatura tipo, Double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoTemperatura getTipo() {
        return tipo;
    }

    public void setTipo(TipoTemperatura tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
