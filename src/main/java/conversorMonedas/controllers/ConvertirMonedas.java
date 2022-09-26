package conversorMonedas.controllers;


import conversorMonedas.models.Moneda;
import java.io.*;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

public class ConvertirMonedas {

    public static Moneda convertir(Moneda moneda1, Moneda moneda2) throws IOException, JSONException {

        if(moneda1.getTipoMoneda() == moneda2.getTipoMoneda()){
            return moneda1;
        }

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to="+moneda2.getTipoMoneda()+"&from="+moneda1.getTipoMoneda()+"&amount="+moneda1.getValor())
                .addHeader("apikey", "lF9T2fUW86u4h27QevibJVxWpML2awdO")
                .method("GET", null)
            .build();
        Response response = client.newCall(request).execute();
        JSONObject valor = new JSONObject(response.body().string());
        moneda2.setValor(valor.getDouble("result"));

        return moneda2;

    }

}
