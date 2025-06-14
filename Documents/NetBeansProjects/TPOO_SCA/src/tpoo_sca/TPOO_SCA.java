/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tpoo_sca;

/**
 *
 * @author GuilleDc
 */
public class TPOO_SCA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creamos una cuenta con S/ 1500 de saldo
        Cuenta cuenta = new Cuenta("001-123456", 1500.0, "Ahorros");
        // Creamos una tarjeta asociada a la cuenta con PIN "1234"
        Tarjeta tarjeta = new Tarjeta("4567-8910-1112-1314", "1234");
        // Creamos un cliente con nombre, tarjeta y cuenta
        Cliente cliente = new Cliente("Juan Perez", tarjeta, cuenta);
        // Iniciamos el cajero
        Cajero cajero = new Cajero();
        // Simulamos la inserción de la tarjeta
        cajero.insertarTarjeta(cliente);
    }
    
}
