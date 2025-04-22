/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.modelos;

/**
 *
 * @author borja
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {
    private double interesDescubierto;
    private double maxDescubierto;
    private double comisionDescubierto;
    
    public CuentaCorrienteEmpresa(String iban, Persona titular, double saldo, String entidadesAutorizadas, double interesDEscubierto, double maxDescubierto, double comisionDescubierto){
        super(iban, titular, saldo, entidadesAutorizadas);
        this.interesDescubierto = interesDescubierto;
        this.maxDescubierto = maxDescubierto;
        this.comisionDescubierto = comisionDescubierto;
    }

    public double getInteresDescubierto() {
        return interesDescubierto;
    }

    public double getMaxDescubierto() {
        return maxDescubierto;
    }

    public double getComisionDescubierto() {
        return comisionDescubierto;
    }
    
    @Override
    public String devolverInfoString(){
        return "Cuenta Corriente Personal\nIBAN: " + iban
                +"\nTitular: " + titular.getNombre() + " " + titular.getApellidos()
                +"\nSaldo: " + saldo + " €"
                +"\nMaximo descubierto: " + maxDescubierto + " €"
                +"\nInterés por descubierto: " + interesDescubierto + "%"
                +"\nComision por descubieto: " + comisionDescubierto + " €"
                +"\nEntidades Autorizadas: " + entidadesAutorizadas;
    }
    
}
