/**
 * Clase Cuenta
 * Representa una cuenta bancaria con número, titular y saldo.
 * Proporciona métodos básicos para depositar, retirar y consultar información.
 */
public class Cuenta {
    // Atributos de la cuenta
    private String numeroCuenta;
    private String titular;
    private double saldo;

    // Constructor
    public Cuenta(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial >= 0 ? saldoInicial : 0;
    }

    // Métodos getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Método para depositar dinero
    public boolean depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            return true;
        }
        return false;
    }

    // Método para retirar dinero
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    // Método toString para mostrar información de la cuenta
    @Override
    public String toString() {
        return String.format("Cuenta: %s | Titular: %s | Saldo: $%.2f", 
                             numeroCuenta, titular, saldo);
    }

    // Método para obtener información en formato CSV (para guardar en archivo)
    public String toCSV() {
        return numeroCuenta + "," + titular + "," + saldo;
    }

    // Método estático para crear cuenta desde formato CSV
    public static Cuenta fromCSV(String csv) {
        String[] datos = csv.split(",");
        if (datos.length == 3) {
            return new Cuenta(datos[0], datos[1], Double.parseDouble(datos[2]));
        }
        return null;
    }
}