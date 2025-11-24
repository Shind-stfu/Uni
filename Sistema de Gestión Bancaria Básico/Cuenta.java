//Clase Cuenta
//Representa una cuenta bancaria con su número, el nombre del titular y el saldo.
 
public class Cuenta {

    // Número único de la cuenta
    private String numeroCuenta;

    // Nombre del dueño de la cuenta
    private String titular;

    // Dinero disponible en la cuenta
    private double saldo;

    // Constructor para crear una nueva cuenta.
    // Recibe número, titular y saldo inicial.
    // Si el saldo inicial es negativo, lo dejo en 0 para evitar inconsistencias.
    public Cuenta(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial >= 0 ? saldoInicial : 0;
    }

    // Getters para obtener los datos de la cuenta cuando se necesiten.
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Método para depositar dinero.
    // Solo permite montos positivos.
    public boolean depositar(double monto) {
        if (monto > 0) {
            saldo += monto;  // Sumo el dinero al saldo actual
            return true;
        }
        return false; // Si el monto no es válido, no hace nada
    }

    // Método para retirar dinero.
    // Verifica que el monto sea positivo y que haya suficiente saldo.
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;  // Resto el dinero del saldo actual
            return true;
        }
        return false; // No se puede retirar más de lo que hay
    }

    // Representación en texto de la cuenta.
    // Útil para mostrarla en pantalla cuando el usuario consulta la info.
    @Override
    public String toString() {
        return String.format(
            "Cuenta: %s | Titular: %s | Saldo: $%.2f",
            numeroCuenta, titular, saldo
        );
    }

    // Convierte los datos de la cuenta en una línea separada por comas (CSV).
    // Esto sirve para guardar la info en archivos de texto.
    public String toCSV() {
        return numeroCuenta + "," + titular + "," + saldo;
    }

    // Crea una cuenta nueva leyendo una línea en formato CSV.
    // Básicamente hace el proceso inverso de toCSV().
    public static Cuenta fromCSV(String csv) {
        String[] datos = csv.split(",");

        // Si la línea tiene exactamente 3 datos, se crea la cuenta.
        if (datos.length == 3) {
            return new Cuenta(
                datos[0],
                datos[1],
                Double.parseDouble(datos[2])
            );
        }

        // Si el formato está mal, devolvemos null para indicar error.
        return null;
    }
}
