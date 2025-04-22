/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.damel.modelos;

/**
 * Programación DAM Modalidad Virtual
 *
 * Curso 2024/2025
 *
 * @author Borja Piñero
 */

// Creo la clase abstracta CuentaBancaria
public abstract class CuentaBancaria implements Imprimible {
    
    protected String iban;
    protected double saldo;
    protected Persona titular;
    
    //Creo el constructor de CuentaBancaria
    public CuentaBancaria (String iban, Persona titular, double saldo){
        
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;
        
    }
    
    // Creo el metodo para ingresar dinero
    public void ingresar(double cantidad){
        saldo += cantidad;
    }
    
    // Creo el metodo para retirar dinero
    public boolean retirar(double cantidad){
        if (saldo>=cantidad){
            saldo -= cantidad;
            return true;
        } else {
            return false;
        }
    }
    
    // Getters del objeto CuentaBancaria
    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public Persona getTitular() {
        return titular;
    }
    
    @Override
    public abstract String devolverInfoString();
    
    

}
