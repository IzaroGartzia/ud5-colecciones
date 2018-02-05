package com.izaro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // CREAR LA LISTA
        List<Titular> titulares = new ArrayList<>();
        List<CuentaBancaria> cuentas = new ArrayList<>();

        int opcion;

        do {

            System.out.println(
                    "1. Titular\n" +
                            "   11. Nuevo titular\n" +
                            "2. Cuenta bancaria\n" +
                            "   21. Nueva cuenta\n" +
                            "   22. Nuevo apunte\n" +
                            "   23. Borrar cuenta\n" +
                            "3. Consultas\n" +
                            "   31. Dado un titular, saldo de todas sus cuentas\n" +
                            "   32. Dada una cuenta, titulares asociados\n" +
                            "4. Salir\n");

            System.out.println("Opción: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 11:

                    titulares.add(new Titular("Izaro", "Garcia", "53982363Y", "2018/01/03"));
                    break;

                case 21:

                    cuentas.add(new CuentaBancaria("01"));
                    break;

                case 22:
                    // NUEVO APUNTE

                    // MOSTRAR LAS CUENTAS
                    int i = 0;

                    for (CuentaBancaria c : cuentas) {
                        System.out.println(i + " " + c);
                        i++;
                    }

                    // ELEGIR LA CUENTA
                    System.out.println("Elige cuenta: ");
                    int indice = Integer.parseInt(br.readLine());


                    // PEDIR LA CANTIDAD
                    System.out.println("Cantidad: ");
                    double cantidad = Double.parseDouble(br.readLine());

                    // CREAR EL APUNTE
                    cuentas.get(indice).nuevoApunte(cantidad);

                    break;

                case 23:
                    // BORRAR LA CUENTA

                    // DATOS DE PRUEBA

                    // PASO 1
                    Titular t = new Titular("Izaro", "Garcia", "53982363Y", "2018/01/03");

                    // PASO 2
                    titulares.add(t);

                    // PASO 3
                    CuentaBancaria c = new CuentaBancaria("01");

                    // PASO 4
                    cuentas.add(c);

                    // PASO 5
                    c.nuevoApunte(100);
                    c.nuevoApunte(200);

                    // PASO 6: LA IDA
                    t.getCuentas().add(c);

                    // PASO 7: LA VUELTA
                    c.getTitulares().add(t);

                    for (Apunte apunte : c.getApuntes()) {
                        apunte.setCuentaBancaria(null);
                    }
                    break;

                // LAS LLAVES SON PARA QUE SE PUEDAN REPETIR LAS VARIABLES
                case 31: {
                    // DADO UN TITULAR, SALDO DE LAS CUENTAS

                    // DATOS DE PRUEBA
                    Titular ti = new Titular("Izaro", "Garcia", "53982363Y", "2018/01/03");

                    // PASO 2
                    titulares.add(ti);

                    // PASO 3
                    CuentaBancaria cu = new CuentaBancaria("01");

                    // PASO 4
                    cuentas.add(cu);

                    // PASO 5
                    cu.nuevoApunte(100);
                    cu.nuevoApunte(200);

                    // PASO 6: LA IDA
                    ti.getCuentas().add(cu);

                    // PASO 7: LA VUELTA
                    cu.getTitulares().add(ti);

                    // RECORRESR LAS CUENTAS DEL TITULAR
                    for (CuentaBancaria cuenta : ti.getCuentas()) {
                        System.out.println(cuenta.calcularSaldo());
                    }
                    break;
                }
                case 32:
                    break;

                case 4:
                    System.out.println("Has salido del programa.");
                    break;

                default:
                    System.out.println("Te has equivocado...");

            }
        } while (opcion != 4);
    }
}
