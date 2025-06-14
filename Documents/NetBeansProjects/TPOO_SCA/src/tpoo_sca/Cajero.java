/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpoo_sca;
import java.util.Scanner;
/**
 *
 * @author GuilleDc
 */

public class Cajero {
    private Cliente cliente;           // Cliente autenticado
    private Scanner scanner;           // Para leer entrada del usuario

    // Constructor del cajero
    public Cajero() {
        scanner = new Scanner(System.in);
    }
    // Método para simular insettar tarjeta
    public void insertarTarjeta(Cliente cliente) 
    {
        this.cliente = cliente;
        Tarjeta tarjeta = cliente.getTarjeta();
        int intentos = 0;

        System.out.println("\n Bienvenido, " + cliente.getNombre());

    // Permitir hasta 3 intentos mientras no esté bloqueada
    while (intentos < 3 && !tarjeta.estaBloqueada()) {
        System.out.print("Ingrese su PIN: ");
        String pinIngresado = scanner.nextLine();

        if (tarjeta.verificarPIN(pinIngresado)) {
            mostrarMenu(); // PIN correcto: se muestra menú
            return;
        } else {
            intentos++;
        }
    }

    // Si sale del bucle, se agotaron los intentos, se bloqueó tarjeta
    System.out.println("Acceso denegado. Por favor comuníquese con su banco.");
    }

    // Menú principal del cajero
    private void mostrarMenu() 
    {
        int opcion;
        do {
            System.out.println("\n--- Menu Cajero BCP ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Cambiar PIN");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    retirarDinero();
                    break;
                case 3:
                    depositarDinero();
                    break;
                case 4:
                    cambiarPIN();
                    break;
                case 5:
                    System.out.println("Sesión finalizada. Retire su tarjeta.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    // Opción 1: consultar saldo
    private void consultarSaldo() {
        double saldo = cliente.getCuenta().getSaldo();
        System.out.println("Su saldo actual es: S/ " + saldo);
    }

    // Opción 2: retirar dinero
    private void retirarDinero() {
        System.out.print("Ingrese el monto a retirar: S/ ");
        double monto = scanner.nextDouble();
        cliente.getCuenta().retirar(monto);
    }

    // Opción 3: depositar dinero
    private void depositarDinero() {
        System.out.print("Ingrese el monto a depositar: S/ ");
        double monto = scanner.nextDouble();
        cliente.getCuenta().depositar(monto);
    }

    // Opción 4: cambiar PIN
    private void cambiarPIN() {
        scanner.nextLine(); // Limpia el buffer del scanner
        System.out.print("Ingrese el nuevo PIN: ");
        String nuevoPIN = scanner.nextLine();
        // Reemplazamos el PIN directamente (simple por ahora)
        cliente.getTarjeta().cambiarPIN(nuevoPIN);
        System.out.println("PIN actualizado correctamente.");
    }
    
}
