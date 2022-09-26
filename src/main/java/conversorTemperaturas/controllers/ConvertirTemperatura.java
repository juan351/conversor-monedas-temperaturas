package conversorTemperaturas.controllers;

import conversorTemperaturas.models.Temperatura;
import conversorTemperaturas.models.TipoTemperatura;

public class ConvertirTemperatura {
    private Temperatura temperatura1;
    private Temperatura temperatura2;

    public static Temperatura convertir(Temperatura temperatura1, Temperatura temperatura2){
        if (temperatura1.getTipo() == temperatura2.getTipo()) return temperatura1;
        Temperatura temperaturaK = convertirAKelvin(temperatura1);
        if(temperatura2.getTipo() == TipoTemperatura.C){
            return convertirACelsius(temperaturaK);
        }else if(temperatura2.getTipo() == TipoTemperatura.F){
            return convertirAFahrenheit(temperaturaK);
        }

        return temperaturaK;

    }

    private static Temperatura convertirACelsius(Temperatura temperatura) {

        temperatura.setTipo(TipoTemperatura.C);
        temperatura.setValor(temperatura.getValor() - 273.15);
        return temperatura;
    }

    private static Temperatura convertirAFahrenheit(Temperatura temperatura){
        temperatura.setTipo(TipoTemperatura.F);
        temperatura.setValor((temperatura.getValor() - 273.15) * 9/5 + 32);
        return temperatura;
    }

    private static Temperatura convertirAKelvin(Temperatura temperatura){
        if(temperatura.getTipo() == TipoTemperatura.C){
            temperatura.setTipo(TipoTemperatura.K);
            temperatura.setValor(temperatura.getValor() + 273.15);
        }else if(temperatura.getTipo() == TipoTemperatura.F){
            temperatura.setTipo(TipoTemperatura.K);
            temperatura.setValor((temperatura.getValor() - 32) * 5/9 + 273.15);
        }

        return temperatura;
    }

}
