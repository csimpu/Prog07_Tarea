/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.damel.servicio;

import com.damel.modelos.CuentaBancaria;

/**
 * Programación DAM Modalidad Virtual
 *
 * Curso 2024/2025
 *
 * @author Borja Piñero
 */
public class Banco {

    private CuentaBancaria[] cuentas;
    private int contador;

    public Banco() {
        cuentas = new CuentaBancaria[100];
        contador = 0;
    }

    public boolean abrirCuenta(CuentaBancaria cuenta) {
        if (contador < cuentas.length) {
            cuentas[contador] = cuenta;
            contador++;
            return true;
        }
        return false;
    }

    public String[] listadoCuentas() {
        String[] listado = new String[contador];
        for (int i = 0; i < contador; i++) {
            listado[i] = cuentas[i].getIban()
                    + "\n" + cuentas[i].getTitular().getNombre() + " " + cuentas[i].getTitular().getApellidos()
                    + "\n" + cuentas[i].getSaldo() + " €";
        }
        return listado;
    }

    public String informacionCuenta(String iban) {
        for (int i = 0; i < contador; i++) {
            if (cuentas[i].getIban().equals(iban)) {
                return cuentas[i].devolverInfoString();
            }
        }
        return "Cuenta no encontrada";
    }

    public boolean ingresoCuenta(String iban, double cantidad) {
        for (int i = 0; i < contador; i++) {
            if (cuentas[i].getIban().equals(iban)) {
                cuentas[i].ingresar(cantidad);
                return true;
            }
        }
        return false;
    }

    public boolean retiradaCuenta(String iban, double cantidad) {
        for (int i = 0; i < contador; i++) {
            if (cuentas[i].getIban().equals(iban)) {
                return cuentas[i].retirar(cantidad);
            }
        }
        return false;
    }

    public double obtenerSaldo(String iban) {
        for (int i = 0; i < contador; i++) {
            if (cuentas[i].getIban().equals(iban)) {
                return cuentas[i].getSaldo();
            }
        }
        return -1;
    }

}
