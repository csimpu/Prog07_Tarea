/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.modelos;

/**
 *
 * @author borja
 */
public class CuentaCorrientePersonal extends CuentaCorriente {
    
    private double comisionMantenimiento;
    
    public CuentaCorrientePersonal(String iban, Persona titular, double saldo, String entidadesAutorizadas, double comisionMantenimiento) {
        super(iban, titular, saldo, entidadesAutorizadas);
        this.comisionMantenimiento = comisionMantenimiento;
    }
    
    public double getComisionMantenimiento(){
        return comisionMantenimiento;
    }
    
    @Override
    public String devolverInfoString(){
        return "Cuenta Corriente Personal\nIBAN: " + iban
                +"\nTitular: " + titular.getNombre() + " " + titular.getApellidos()
                +"\nSaldo: " + saldo + " €"
                +"\nComision de Mantenimiento: " + comisionMantenimiento + " €"
                +"\nEntidades Autorizadas: " + entidadesAutorizadas;
    }
    
}
