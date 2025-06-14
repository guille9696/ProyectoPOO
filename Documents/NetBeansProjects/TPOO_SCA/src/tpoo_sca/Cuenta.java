/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpoo_sca;

/**
 *
 * @author GuilleDc
 */
public class Cuenta 
{
    private String numeroCuenta;
    private double saldo;
    private String tipoCuenta; // Ahorros, Corriente

    public Cuenta(String numeroCuenta, double saldo, String tipoCuenta) 
    {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }
    public double getSaldo() 
    {
        return saldo;
    }

    public void depositar(double monto) 
    {
        if (monto > 0) 
        {
            saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
        } else 
        {
            System.out.println("Monto inválido para depósito.");
        }
    }

    public boolean retirar(double monto) 
    {
        if (monto > 0 && monto <= saldo) 
        {
            saldo -= monto;
            System.out.println("Retiro exitoso. Saldo restante: " + saldo);
            return true;
        } else 
        {
            System.out.println("Saldo insuficiente o monto inválido.");
            return false;
        }
    }

    public String getNumeroCuenta() 
    {
        return numeroCuenta;
    }

    public String getTipoCuenta() 
    {
        return tipoCuenta;
    }
    
}
