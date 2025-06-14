/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpoo_sca;

/**
 *
 * @author GuilleDc
 */
public class Cliente {
    private String nombre;          // Nombre del cliente
    private Tarjeta tarjeta;        // Tarjeta asociada al cliente
    private Cuenta cuenta;          // Cuenta bancaria del cliente

    // Constructor
    public Cliente(String nombre, Tarjeta tarjeta, Cuenta cuenta) {
        this.nombre = nombre;
        this.tarjeta = tarjeta;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
        
}
