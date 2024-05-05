package com.aluracurso.conversormonedas.calcular;

import java.util.Scanner;

public class calcularMoneda {
    private double conversionMoneda;
    private double cantidadAConvertir;
    private Scanner entradaDato;

    public calcularMoneda() {
        entradaDato = new Scanner(System.in);
    }

    public double getConversionMoneda() {
        return conversionMoneda;
    }

    public void calcularDolaresAMonedas(double valorMoneda, String abreviatura, String opcionSeleccionada) {
        cantidadAConvertir = ingresoCantidadAConvertir(opcionSeleccionada);
        conversionMoneda = valorMoneda * cantidadAConvertir;
        System.out.println("El valor de " + cantidadAConvertir + " [USD], corresponde a el valor de " + conversionMoneda + "[" + abreviatura + "]");
    }

    public void calcularMonedasADolares(double valorMoneda, String abreviatura, String opcionSeleccionada) {
        cantidadAConvertir = ingresoCantidadAConvertir(opcionSeleccionada);
        conversionMoneda = cantidadAConvertir / valorMoneda;
        System.out.println("El valor de " + cantidadAConvertir + "[" + abreviatura + "], corresponde a el valor de " + conversionMoneda + "[USD] \n");
    }

    public double ingresoCantidadAConvertir(String opcionSeleccionada) {
        while (true) {
            try {
                System.out.println("Ingrese el valor que desea convertir: (Considerando que estás convirtiendo " + opcionSeleccionada + ")");
                String input = entradaDato.next();
                cantidadAConvertir = Double.parseDouble(input);
                break; // Salir del bucle si se ingresó un número válido
            } catch (NumberFormatException n) {
                System.out.println("Colocar número y no texto. Por favor, inténtelo de nuevo.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
        return cantidadAConvertir;
    }
}
