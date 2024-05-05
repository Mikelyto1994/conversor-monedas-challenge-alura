import com.aluracurso.conversormonedas.calcular.buscarMoneda;
import com.aluracurso.conversormonedas.calcular.calcularMoneda;
import com.aluracurso.conversormonedas.modelo.Moneda;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static <string> void main(String[] args) {

        Scanner entradaDato=new Scanner(System.in);

        while(true){
            mostrarMensajes();
            try {

                int opcion=Integer.valueOf(entradaDato.next());
                if(opcion == 11){
                    break;
                }
                String abreviaturaMoneda;
                buscarMoneda buscarmoneda=new buscarMoneda();
                calcularMoneda calcularmoneda = new calcularMoneda();
                Moneda monedaBuscada;
                switch (opcion) {
                    case 1:
                        abreviaturaMoneda = "PEN";
                        monedaBuscada = buscarmoneda.buscar(abreviaturaMoneda);
                        calcularmoneda.calcularDolaresAMonedas(monedaBuscada.getValor(), abreviaturaMoneda, "Dolar ===> moneda peruana");
                        break;
                    case 2:
                        abreviaturaMoneda = "PEN";
                        monedaBuscada = buscarmoneda.buscar(abreviaturaMoneda);
                        calcularmoneda.calcularMonedasADolares(monedaBuscada.getValor(), abreviaturaMoneda, "moneda peruana ====> Dolar");
                        break;
                    case 3:
                        abreviaturaMoneda = "ARS";
                        monedaBuscada = buscarmoneda.buscar(abreviaturaMoneda);
                        calcularmoneda.calcularDolaresAMonedas(monedaBuscada.getValor(), abreviaturaMoneda, "Dolar ===> peso argentino");
                        break;
                    case 4:
                        abreviaturaMoneda = "ARS";
                        monedaBuscada = buscarmoneda.buscar(abreviaturaMoneda);
                        calcularmoneda.calcularMonedasADolares(monedaBuscada.getValor(), abreviaturaMoneda, "Peso argentino ====> Dolar");
                        break;
                    case 5:
                        abreviaturaMoneda = "BRL";
                        monedaBuscada = buscarmoneda.buscar(abreviaturaMoneda);
                        calcularmoneda.calcularDolaresAMonedas(monedaBuscada.getValor(), abreviaturaMoneda, "Dolar ===> real brasileño");
                        break;
                    case 6:
                        abreviaturaMoneda = "BRL";
                        monedaBuscada = buscarmoneda.buscar(abreviaturaMoneda);
                        calcularmoneda.calcularMonedasADolares(monedaBuscada.getValor(), abreviaturaMoneda, "Real brasileño ====> Dolar");
                        break;
                    case 7:
                        abreviaturaMoneda = "COP";
                        monedaBuscada = buscarmoneda.buscar(abreviaturaMoneda);
                        calcularmoneda.calcularDolaresAMonedas(monedaBuscada.getValor(), abreviaturaMoneda, "Dolar ===> peso colombiano");
                        break;
                    case 8:
                        abreviaturaMoneda = "COP";
                        monedaBuscada = buscarmoneda.buscar(abreviaturaMoneda);
                        calcularmoneda.calcularMonedasADolares(monedaBuscada.getValor(), abreviaturaMoneda, "Peso colombiano ====> Dolar");
                        break;
                    case 9:
                        abreviaturaMoneda = "MXN";
                        monedaBuscada = buscarmoneda.buscar(abreviaturaMoneda);
                        calcularmoneda.calcularDolaresAMonedas(monedaBuscada.getValor(), abreviaturaMoneda, "Dolar ===> peso mexicano");
                        break;
                    case 10:
                        abreviaturaMoneda = "MXN";
                        monedaBuscada = buscarmoneda.buscar(abreviaturaMoneda);
                        calcularmoneda.calcularMonedasADolares(monedaBuscada.getValor(), abreviaturaMoneda, "Peso mexicano ====> Dolar");
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                        break;
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("*******************************************************************\n");

        }

    }

    public static void mostrarMensajes(){
        System.out.println("********Eliga  ua Opcion de moneda a convertir*******");
        System.out.println(""" 
                               1). Dolar ===> moneda peruana
                               2). moneda peruana ====> dolar
                               3). Dolar ===> peso argentino
                               4). Peso argentino ====> dolar
                               5). Dolar ===> real brasileño
                               6). real brasileño ====> dolar
                               7). Dolar ===> peso colombiano
                               8). peso colombiano ====> dolar
                               9). Dolar ===> peso mexicano
                               10). peso mexicano ====> dolar
                               11). salir 
                               """);
        System.out.println("******************************************************");
    }

}
