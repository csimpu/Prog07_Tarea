/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.damel.principal;

import com.damel.modelos.*;
import com.damel.servicio.Banco;
import java.util.Scanner;

/**
 *
 * @author borja
 */
public class Principal {

    private static Banco banco = new Banco();
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();

            try {
                opcion = Integer.parseInt(entrada.nextLine());
                switch (opcion) {
                    case 1 ->
                        nuevaCuenta();
                    case 2 ->
                        listarCuentas();
                    case 3 ->
                        informacionCuenta();
                    case 4 ->
                        ingresarSaldo();
                    case 5 ->
                        retirarSaldo();
                    case 6 ->
                        consultarSaldo();
                    case 7 ->
                        System.out.println("Gracias por usar el servicio. Cerrando...");
                    case 0 ->
                        mostrarAyuda();
                    default ->
                        System.out.println("Opcion no valida: Introduzca un numero del 0 al 7");
                }
            } catch (NumberFormatException eNFE) {
                System.err.println("Error: Debes introducir un numero valido.");
                opcion = 0;
            }
        } while (opcion != 7);

        entrada.close();
    }

    private static void mostrarMenu() {
        System.out.println("*************************************");
        System.out.println("*         Gestor de cuentas         *");
        System.out.println("*************************************");
        System.out.println("[1] - Abrir una cuenta");
        System.out.println("[2] - Listar cuentas disponibles");
        System.out.println("[3] - Obtener datos de una cuenta");
        System.out.println("[4] - Realizar un ingreso");
        System.out.println("[5] - Realizar una retirada");
        System.out.println("[6] - Consultar el saldo");
        System.out.println("[7] - Salir               [0] - Ayuda");
        System.out.println("*************************************");
        System.out.print("Introduce una opcion: ");
    }

    private static void nuevaCuenta() {
        System.out.println("*************************************");
        System.out.println("*           Nueva cuenta            *");
        System.out.println("*************************************");
    }

    private static void listarCuentas() {
        System.out.println("*************************************");
        System.out.println("*        Listado de cuentas         *");
        System.out.println("*************************************");

        String[] listado = banco.listadoCuentas();
        if (listado.length == 0) {
            System.out.println("No hay cuentas en el sistema");
        } else {
            //bucle for-each
            for (String cuenta : listado) {
                System.out.println(cuenta);
            }
        }
    }

    private static void informacionCuenta() {
        System.out.println("*************************************");
        System.out.println("*      Informacion de cuentas       *");
        System.out.println("*************************************");
        System.out.println("Introduce el IBAN de la cuenta:");
        String iban = entrada.nextLine();
        String datos = banco.informacionCuenta(iban);
        if (datos == null) {
            System.out.println("Error: cuenta no encontrada.");
            System.out.println("Verifica el IBAN");
        } else {
            System.out.println(datos);
        }
    }

    private static void ingresarSaldo() {

        boolean entradaValida = false;
        double ingreso = 0;

        System.out.println("*************************************");
        System.out.println("*         Realizar ingreso          *");
        System.out.println("*************************************");
        System.out.println("Introduce el IBAN de la cuenta:");
        String iban = entrada.nextLine();

        while (!entradaValida) {
            System.out.print("Introduce la cantidad: ");
            try {
                ingreso = Double.parseDouble(entrada.nextLine());
                entradaValida = true;
            } catch (NumberFormatException eNFE) {
                System.err.println("Error: Debes introducir un numero");
            }
        }
        if (banco.ingresoCuenta(iban, ingreso)) {
            System.out.println("Ingreso correcto");
        } else {
            System.out.println("Ingreso no realizado");
        }
    }

    private static void retirarSaldo() {

        boolean entradaValida = false;
        double retirada = 0;

        System.out.println("*************************************");
        System.out.println("*         Realizar retirada         *");
        System.out.println("*************************************");
        System.out.println("Introduce el IBAN de la cuenta:");
        String iban = entrada.nextLine();

        while (!entradaValida) {
            try {
                retirada = Double.parseDouble(entrada.nextLine());
                entradaValida = true;
            } catch (NumberFormatException eNFE) {
                System.err.println("Error: Debes introducir un numero");
            }
        }
        if (banco.retiradaCuenta(iban, retirada)) {
            System.out.println("Retirada de efectivo realizada");

        } else {
            System.out.println("No se ha realizado la retirada");
        }
    }

    private static void consultarSaldo() {
        System.out.println("*************************************");
        System.out.println("*         Consulta de saldo         *");
        System.out.println("*************************************");
        System.out.println("Introduce el IBAN de la cuenta:");
        String iban = entrada.nextLine();
        double saldo = banco.obtenerSaldo(iban);
        if (saldo == -1) {
            System.out.println("No existe la cuenta");
        } else {
            System.out.println("Tiene un saldo de " + saldo + " €");
        }
    }

    private static void mostrarAyuda() {
        System.out.println("*************************************");
        System.out.println("*               Ayuda               *");
        System.out.println("*************************************");
        System.out.println("[1] - Anade una nueva cuenta");
        System.out.println("[2] - Lista las cuentas del banco");
        System.out.println("[3] - Muestra información de la");
        System.out.println("      cuenta seleccionada");
        System.out.println("[4] - Permite realizar un ingreso en");
        System.out.println("      la cuenta seleccionada");
        System.out.println("[5] - Permite realizar una retirada");
        System.out.println("      de saldo en la cuenta elegida");
        System.out.println("[6] - Permite consultar el saldo de ");
        System.out.println("      la cuenta seleccionada");
        System.out.println("*************************************");
    }
}
