import java.util.ArrayList;
import java.io.*;

/**
 * Clase Banco
 * Gestiona un conjunto de cuentas bancarias.
 * Incluye operaciones CRUD, transferencias, ordenamiento y persistencia.
 */
public class Banco {
    private ArrayList<Cuenta> cuentas;
    private static final String ARCHIVO_DATOS = "cuentas.txt";

    // Constructor
    public Banco() {
        cuentas = new ArrayList<>();
    }

    // Crear nueva cuenta
    public boolean crearCuenta(String numeroCuenta, String titular, double saldoInicial) {
        // Verificar que no exista el número de cuenta
        if (buscarCuentaPorNumero(numeroCuenta) != null) {
            return false; // Ya existe
        }
        Cuenta nuevaCuenta = new Cuenta(numeroCuenta, titular, saldoInicial);
        cuentas.add(nuevaCuenta);
        return true;
    }

    // Buscar cuenta por número (búsqueda lineal)
    public Cuenta buscarCuentaPorNumero(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    // Consultar saldo de una cuenta
    public Double consultarSaldo(String numeroCuenta) {
        Cuenta cuenta = buscarCuentaPorNumero(numeroCuenta);
        return cuenta != null ? cuenta.getSaldo() : null;
    }

    // Depositar en una cuenta
    public boolean depositar(String numeroCuenta, double monto) {
        Cuenta cuenta = buscarCuentaPorNumero(numeroCuenta);
        if (cuenta != null) {
            return cuenta.depositar(monto);
        }
        return false;
    }

    // Retirar de una cuenta
    public boolean retirar(String numeroCuenta, double monto) {
        Cuenta cuenta = buscarCuentaPorNumero(numeroCuenta);
        if (cuenta != null) {
            return cuenta.retirar(monto);
        }
        return false;
    }

    // Transferir entre cuentas
    public boolean transferir(String cuentaOrigen, String cuentaDestino, double monto) {
        Cuenta origen = buscarCuentaPorNumero(cuentaOrigen);
        Cuenta destino = buscarCuentaPorNumero(cuentaDestino);
        
        if (origen != null && destino != null && monto > 0) {
            if (origen.retirar(monto)) {
                destino.depositar(monto);
                return true;
            }
        }
        return false;
    }

    // Mostrar todas las cuentas
    public void mostrarCuentas() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
            return;
        }
        System.out.println("\n=== LISTA DE CUENTAS ===");
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }

    // Obtener número de cuentas
    public int getCantidadCuentas() {
        return cuentas.size();
    }

    // ========== ALGORITMOS DE ORDENAMIENTO ==========

    /**
     * Merge Sort - Ordena las cuentas por saldo de mayor a menor
     */
    public void ordenarPorSaldoMergeSort() {
        if (cuentas.size() <= 1) return;
        cuentas = mergeSort(cuentas);
    }

    private ArrayList<Cuenta> mergeSort(ArrayList<Cuenta> lista) {
        if (lista.size() <= 1) {
            return lista;
        }

        // Dividir la lista en dos mitades
        int medio = lista.size() / 2;
        ArrayList<Cuenta> izquierda = new ArrayList<>(lista.subList(0, medio));
        ArrayList<Cuenta> derecha = new ArrayList<>(lista.subList(medio, lista.size()));

        // Ordenar recursivamente
        izquierda = mergeSort(izquierda);
        derecha = mergeSort(derecha);

        // Combinar las listas ordenadas
        return merge(izquierda, derecha);
    }

    private ArrayList<Cuenta> merge(ArrayList<Cuenta> izq, ArrayList<Cuenta> der) {
        ArrayList<Cuenta> resultado = new ArrayList<>();
        int i = 0, j = 0;

        // Combinar ordenadamente (de mayor a menor saldo)
        while (i < izq.size() && j < der.size()) {
            if (izq.get(i).getSaldo() >= der.get(j).getSaldo()) {
                resultado.add(izq.get(i));
                i++;
            } else {
                resultado.add(der.get(j));
                j++;
            }
        }

        // Agregar elementos restantes
        while (i < izq.size()) {
            resultado.add(izq.get(i));
            i++;
        }
        while (j < der.size()) {
            resultado.add(der.get(j));
            j++;
        }

        return resultado;
    }

    /**
     * Quick Sort - Alternativa para ordenar por saldo
     */
    public void ordenarPorSaldoQuickSort() {
        if (cuentas.size() <= 1) return;
        quickSort(0, cuentas.size() - 1);
    }

    private void quickSort(int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particionar(inicio, fin);
            quickSort(inicio, indicePivote - 1);
            quickSort(indicePivote + 1, fin);
        }
    }

    private int particionar(int inicio, int fin) {
        double pivote = cuentas.get(fin).getSaldo();
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            // Ordenar de mayor a menor
            if (cuentas.get(j).getSaldo() >= pivote) {
                i++;
                // Intercambiar elementos
                Cuenta temp = cuentas.get(i);
                cuentas.set(i, cuentas.get(j));
                cuentas.set(j, temp);
            }
        }

        // Colocar pivote en su posición correcta
        Cuenta temp = cuentas.get(i + 1);
        cuentas.set(i + 1, cuentas.get(fin));
        cuentas.set(fin, temp);

        return i + 1;
    }

    // ========== BÚSQUEDA BINARIA ==========

    /**
     * Búsqueda binaria por saldo
     * Precondición: La lista debe estar ordenada por saldo
     */
    public Cuenta busquedaBinariaPorSaldo(double saldoBuscado) {
        int inicio = 0;
        int fin = cuentas.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            double saldoMedio = cuentas.get(medio).getSaldo();

            if (Math.abs(saldoMedio - saldoBuscado) < 0.01) { // Comparación con tolerancia
                return cuentas.get(medio);
            } else if (saldoMedio > saldoBuscado) {
                inicio = medio + 1; // Ordenado de mayor a menor
            } else {
                fin = medio - 1;
            }
        }
        return null; // No encontrado
    }

    // ========== PERSISTENCIA DE DATOS ==========

    /**
     * Guardar cuentas en archivo de texto
     */
    public boolean guardarEnArchivo() {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(ARCHIVO_DATOS))) {
            for (Cuenta cuenta : cuentas) {
                escritor.println(cuenta.toCSV());
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    /**
     * Cargar cuentas desde archivo de texto
     */
    public boolean cargarDesdeArchivo() {
        File archivo = new File(ARCHIVO_DATOS);
        if (!archivo.exists()) {
            return false; // No hay archivo previo
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(ARCHIVO_DATOS))) {
            cuentas.clear();
            String linea;
            while ((linea = lector.readLine()) != null) {
                Cuenta cuenta = Cuenta.fromCSV(linea);
                if (cuenta != null) {
                    cuentas.add(cuenta);
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error al cargar: " + e.getMessage());
            return false;
        }
    }
}