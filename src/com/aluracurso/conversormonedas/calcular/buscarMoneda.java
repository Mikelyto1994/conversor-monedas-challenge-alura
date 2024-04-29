package com.aluracurso.conversormonedas.calcular;

import com.aluracurso.conversormonedas.modelo.Moneda;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class buscarMoneda {
    Moneda moneda = null;
    public Moneda buscar(String  abreviatura){

        try {
            String direccion = "https://v6.exchangerate-api.com/v6/f6d8a6131df6be3b92001248/latest/USD";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpClient client = HttpClient.newHttpClient();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);

            // Obtener el JSON interno con la clave "conversion_rates
            // utilize json simple - jar, para sacar el json interno "
            JSONObject jsonInterno = (JSONObject) jsonObject.get("conversion_rates");

            for (Object key : jsonInterno.keySet()) {
                String clave = (String) key;
                if (clave.contains(abreviatura)) {
                    Object valor = jsonInterno.get(key);
                    double doubleValor = ((Number) valor).doubleValue();
                    moneda = new Moneda(clave, doubleValor);
                }
            }

        }catch (ParseException p){
            System.out.println("Asurgido un error : "+p.getMessage());
        }catch (InterruptedException i){
            System.out.println("Asurgido un error : "+i.getMessage());
        }
        catch (Exception e){
            System.out.println("Asurgido un error : "+e.getMessage());
        }
        return moneda;
    }
}
