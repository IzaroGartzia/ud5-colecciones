package com.izaro;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {

    private String codigoCuenta;

    private List<Apunte> apuntes = new ArrayList<>();

    public List<Titular> getTitulares() {
        return titulares;
    }

    private List<Titular> titulares = new ArrayList<>();

    public double calcularSaldo() {

        double total = 0.0;

        for (Apunte a : apuntes) {
            total += a.getCantidad();
        }

        return total;
    }

    public void nuevoApunte(double cantidad) {

        // CREAR EL OBJETO
        Apunte a = new Apunte(cantidad, "hoy");

        // CONECTARLO
        apuntes.add(a); // LA IDA
        a.setCuentaBancaria(this);  // LA VUELTA
    }


    // CONSTRUCTORES
    public CuentaBancaria(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public CuentaBancaria() {
    }

    // GETTERS Y SETTERS
    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    // To String
    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "codigoCuenta='" + codigoCuenta + '\'' +
                '}';
    }

    // PARA ENCAPSULAR PARA DAR ACCESO A LOS OBJETOS
    public List<Apunte> getApuntes() {
        return apuntes;
    }
}
