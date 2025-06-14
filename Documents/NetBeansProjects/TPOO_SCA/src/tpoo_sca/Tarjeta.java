/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpoo_sca;

/**
 *
 * @author GuilleDc
 */
public class Tarjeta {
    private String numeroTarjeta;   // Número único de la tarjeta
    private String pin;             // PIN asociado a la tarjeta
    private boolean bloqueada;      // Estado de la tarjeta si se bloquea por intentos fallidos
    private int intentosFallidos;   // Contador de intentos fallidos de PIN

    // Constructor: se inicializa con número de tarjeta y PIN
    public Tarjeta(String numeroTarjeta, String pin) {
        this.numeroTarjeta = numeroTarjeta;
        this.pin = pin;
        this.bloqueada = false;
        this.intentosFallidos = 0;
    }
    
    // Verifica si el PIN ingresado es correcto
    public boolean verificarPIN(String pinIngresado) 
    {
        if (bloqueada) 
        {
            System.out.println("Tarjeta bloqueada por múltiples intentos fallidos.");
            return false;
        }

        if (this.pin.equals(pinIngresado)) 
        {
            intentosFallidos = 0; // Reinicia los intentos si el PIN es correcto
            return true;
        } else 
        {
            intentosFallidos++; // Aumenta el contador de fallos
            System.out.println("PIN incorrecto. Intento " + intentosFallidos + " de 3.");
            if (intentosFallidos >= 3) 
            {
                bloqueada = true; // Bloquea la tarjeta si falla 3 veces
                System.out.println("Tarjeta bloqueada por seguridad.");
            }
            return false;
        }
    }

    public String getNumeroTarjeta() 
    {
        return numeroTarjeta;
    }

    public boolean estaBloqueada() 
    {
        return bloqueada;
    }
    
    // Metodo para cambiar PIN clave
    public void cambiarPIN(String nuevoPIN) 
    {
    this.pin = nuevoPIN;
    }
}
