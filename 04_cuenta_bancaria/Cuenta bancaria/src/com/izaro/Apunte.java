package com.izaro;

public class Apunte {

    private double cantidad;
    private String fecha;

    // ASOCIACIÓN
    private CuentaBancaria cuentaBancaria;

    // CONSTRUCTOR
    public Apunte(double cantidad, String fecha) {
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Apunte() {
    }

    // To String

    @Override
    public String toString() {
        return "Apunte{" +
                "cantidad=" + cantidad +
                ", fecha='" + fecha + '\'' +
                '}';
    }

    // GETTERS Y SETTERS
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // ASOCIACIÓNES
    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
}
