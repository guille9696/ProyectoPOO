/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 * @author GuilleDc
 */
import java.util.Scanner;

public class CajeroLogin {
    // Datos de usuario + saldo actual
    static final String USUARIO = "user";
    static final String PASSWORD = "1234";
    static double saldo = 1000.0;

public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Login
        boolean accesoPermitido = false;
        int intentos = 3;

        while (intentos > 0 && !accesoPermitido) {
            System.out.print("Ingrese usuario: ");
            String userInput = scanner.nextLine();

            System.out.print("Ingrese contraseña: ");
            String passwordInput = scanner.nextLine();

            if (userInput.equals(USUARIO) && passwordInput.equals(PASSWORD)) {
                accesoPermitido = true;
                System.out.println("\n¡Acceso permitido!\n");
            } else {
                intentos--;
                System.out.println("Credenciales incorrectas. Intentos restantes: " + intentos);
            }
        }

        if (!accesoPermitido) {
            System.out.println("Acceso denegado. Demasiados intentos.");
            return;
        }

        // Menú del cajero
        int opcion;
        do {
            System.out.println("=== MENÚ CAJERO AUTOMÁTICO ===");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            //Opciones de mi cajero
            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: S/ " + saldo);
                    break;
                case 2:
                    System.out.print("Ingrese monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito exitoso.");
                    } else {
                        System.out.println("Monto inválido.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    if (retiro > 0 && retiro <= saldo) {
                        saldo -= retiro;
                        System.out.println("Retiro exitoso.");
                    } else {
                        System.out.println("Fondos insuficientes o monto inválido.");
                    }
                    break;
                case 4:
                    System.out.println("Gracias por usar el cajero. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

            System.out.println(); // Espacio entre operaciones

        } while (opcion != 4);

        scanner.close();
    }
}
    

