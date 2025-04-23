/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.objetos;

/**
 *
 * @author borja
 */
public class CuentaAhorro extends CuentaBancaria {

    private double interesAnual;

    public CuentaAhorro(String iban, Persona titular, double saldo, double interesAnual) {
        super(iban, titular, saldo);
        this.interesAnual = interesAnual;
    }

    public double getInteresAnual() {
        return interesAnual;
    }

    @Override
    public String devolverInfoString() {
        return "Cuenta Ahorro\nIBAN: " + iban
                + "\nTitular: " + titular.getNombre() + " " + titular.getApellidos()
                + "\nSaldo: " + saldo + " Eur"
                + "\nTipo de interes anual: " + interesAnual + "%";
    }

}
