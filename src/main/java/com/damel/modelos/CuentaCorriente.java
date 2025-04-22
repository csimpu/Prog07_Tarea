/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.modelos;

/**
 *
 * @author borja
 */
public abstract class CuentaCorriente extends CuentaBancaria{
    protected String entidadesAutorizadas;
    
    public CuentaCorriente(String iban, Persona titular, double saldo, String entidadesAutorizadas){
        super(iban, titular, saldo);
        this.entidadesAutorizadas = entidadesAutorizadas;
    }

    public String getEntidadesAutorizadas() {
        return entidadesAutorizadas;
    }
       
}
