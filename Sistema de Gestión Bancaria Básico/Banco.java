import java.util.ArrayList;
import java.io.*;


public class Banco {

    // Lista donde se guardan todas las cuentas del sistema
    private ArrayList<Cuenta> cuentas;

    // Nombre del archivo donde se guardan las cuentas
    private static final String ARCHIVO_DATOS = "cuentas.txt";

    // Constructor: inicializa la lista de cuentas vacía
    public Banco() {
        cuentas = new ArrayList<>();
    }

    // Crear una nueva cuenta en el sistema
    // Devuelve false si ya existe una cuenta con ese número
    public boolean crearCuenta(String numeroCuenta, String titular, double saldoInicial) {
        if (buscarCuentaPorNumero(numeroCuenta) != null) {
            return false; // No se crea porque ya existe una
        }
        Cuenta nuevaCuenta = new Cuenta(numeroCuenta, titular, saldoInicial);
        cuentas.add(nuevaCuenta);
        return true;
    }

    // Buscar una cuenta por su número recorriendo la lista (búsqueda lineal)
    public Cuenta buscarCuentaPorNumero(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    // Consultar saldo de una cuenta dado su número
    public Double consultarSaldo(String numeroCuenta) {
        Cuenta cuenta = buscarCuentaPorNumero(numeroCuenta);
        return cuenta != null ? cuenta.getSaldo() : null;
    }

    // Depositar dinero en una cuenta si existe
    public boolean depositar(String numeroCuenta, double monto) {
        Cuenta cuenta = buscarCuentaPorNumero(numeroCuenta);
        if (cuenta != null) {
            return cuenta.depositar(monto);
        }
        return false;
    }

    // Retirar dinero de una cuenta si existe
    public boolean retirar(String numeroCuenta, double monto) {
        Cuenta cuenta = buscarCuentaPorNumero(numeroCuenta);
        if (cuenta != null) {
            return cuenta.retirar(monto);
        }
        return false;
    }

    // Transferir dinero entre dos cuentas
    public boolean transferir(String cuentaOrigen, String cuentaDestino, double monto) {
        Cuenta origen = buscarCuentaPorNumero(cuentaOrigen);
        Cuenta destino = buscarCuentaPorNumero(cuentaDestino);

        // Verifico que existan ambas cuentas y el monto sea válido
        if (origen != null && destino != null && monto > 0) {
            if (origen.retirar(monto)) {   // Si el retiro sí se pudo hacer
                destino.depositar(monto); // Se deposita en la otra cuenta
                return true;
            }
        }
        return false;
    }

    // Muestra todas las cuentas registradas en consola
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

    // Retorna cuántas cuentas están registradas actualmente
    public int getCantidadCuentas() {
        return cuentas.size();
    }

    // ALGORITMOS DE ORDENAMIENTO 

  
    public void ordenarPorSaldoMergeSort() {
        if (cuentas.size() <= 1) return; // Nada que ordenar
        cuentas = mergeSort(cuentas);
    }

    // Implementación recursiva de Merge Sort
    private ArrayList<Cuenta> mergeSort(ArrayList<Cuenta> lista) {
        if (lista.size() <= 1) {
            return lista;
        }

        // Dividir la lista en dos
        int medio = lista.size() / 2;
        ArrayList<Cuenta> izquierda = new ArrayList<>(lista.subList(0, medio));
        ArrayList<Cuenta> derecha = new ArrayList<>(lista.subList(medio, lista.size()));

        // Ordenar cada mitad por separado
        izquierda = mergeSort(izquierda);
        derecha = mergeSort(derecha);

        // Combinar ambas mitades ordenadas
        return merge(izquierda, derecha);
    }

    // Combinar dos listas ya ordenadas (merge)
    private ArrayList<Cuenta> merge(ArrayList<Cuenta> izq, ArrayList<Cuenta> der) {
        ArrayList<Cuenta> resultado = new ArrayList<>();
        int i = 0, j = 0;

        // Mezclar elementos uno por uno según el saldo
        while (i < izq.size() && j < der.size()) {
            if (izq.get(i).getSaldo() >= der.get(j).getSaldo()) {
                resultado.add(izq.get(i));
                i++;
            } else {
                resultado.add(der.get(j));
                j++;
            }
        }

        // Agregar los elementos que queden en cualquiera de las dos listas
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

    
    //Ordenar por saldo usando Quick Sort
    //También ordena de mayor a menor
     
    public void ordenarPorSaldoQuickSort() {
        if (cuentas.size() <= 1) return;
        quickSort(0, cuentas.size() - 1);
    }

    // Implementación de Quick Sort
    private void quickSort(int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particionar(inicio, fin);
            quickSort(inicio, indicePivote - 1);
            quickSort(indicePivote + 1, fin);
        }
    }

    // Divide la lista según el pivote
    private int particionar(int inicio, int fin) {
        double pivote = cuentas.get(fin).getSaldo();
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            // Ubicar primero los saldos mayores
            if (cuentas.get(j).getSaldo() >= pivote) {
                i++;
                // Intercambiar cuentas
                Cuenta temp = cuentas.get(i);
                cuentas.set(i, cuentas.get(j));
                cuentas.set(j, temp);
            }
        }

        // Colocar el pivote en su posición definitiva
        Cuenta temp = cuentas.get(i + 1);
        cuentas.set(i + 1, cuentas.get(fin));
        cuentas.set(fin, temp);

        return i + 1;
    }

    // BÚSQUEDA BINARIA 


     //Buscar una cuenta por saldo usando búsqueda binaria
     //Nota: la lista debe estar ordenada por saldo antes de usar este método
     
    public Cuenta busquedaBinariaPorSaldo(double saldoBuscado) {
        int inicio = 0;
        int fin = cuentas.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            double saldoMedio = cuentas.get(medio).getSaldo();

            // Comparo con tolerancia porque los doubles a veces son imprecisos
            if (Math.abs(saldoMedio - saldoBuscado) < 0.01) {
                return cuentas.get(medio);
            } else if (saldoMedio > saldoBuscado) {
                inicio = medio + 1; // Como está de mayor a menor, avanzo hacia abajo
            } else {
                fin = medio - 1;
            }
        }
        return null;
    }

    // GUARDAR Y CARGAR ARCHIVOS 

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

    
    //Carga las cuentas desde un archivo previo si existe
    
    public boolean cargarDesdeArchivo() {
        File archivo = new File(ARCHIVO_DATOS);
        if (!archivo.exists()) {
            return false; // No hay datos guardados
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(ARCHIVO_DATOS))) {
            cuentas.clear(); // Limpio las cuentas actuales
            String linea;

            // Leer línea por línea el archivo
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
