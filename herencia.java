// Cambiamos el nombre de la clase pública a herencia
public class herencia {
    // Atributos para almacenar los totales de precios y los totales específicos de bodega y cabina
    private double totalPrecios;
    private double totalBodega;
    private double totalCabina;
    private Equipaje[] equipaje; // Arreglo de objetos Equipaje

    // Constructor que recibe un arreglo de equipajes
    public herencia(Equipaje[] equipaje) {
        this.equipaje = equipaje; // Inicializa el arreglo de equipajes
    }

    // Método que calcula los totales de los precios
    public void calcularTotales() {
        for (Equipaje e : equipaje) { // Itera sobre cada equipaje
            if (e != null) { // Verifica que el equipaje no sea nulo
                double precio = e.calcularPrecio(); // Calcula el precio del equipaje
                totalPrecios += precio; // Acumula el precio total

                // Verifica el tipo de equipaje y acumula en los totales correspondientes
                if (e instanceof Bodega) {
                    totalBodega += precio; // Acumula el precio si es Bodega
                } else if (e instanceof Cabina) {
                    totalCabina += precio; // Acumula el precio si es Cabina
                }
            }
        }
    }

    // Método que muestra los totales de precios
    public void mostrarTotales() {
        calcularTotales(); // Calcula los totales antes de mostrar
        System.out.println("Total Equipaje: " + totalPrecios);
        System.out.println("Total Bodega: " + totalBodega);
        System.out.println("Total Cabina: " + totalCabina);
    }

    // Método principal para probar el código
    public static void main(String[] args) {
        Equipaje[] equipajes = {
            new Bodega(1500.0),
            new Cabina(1200.0),
            new Bodega(1000.0, 5.0),
            new Cabina(800.0, 3.0)
        };

        herencia precioTotal = new herencia(equipajes); // Creación de la instancia de la clase
        precioTotal.mostrarTotales(); // Llamada al método para mostrar totales
    }
}

// Clase base para el equipaje
class Equipaje {
    // Constantes que representan valores predeterminados de peso, tamaño y precio base
    protected static final double PESO = 10.0;
    protected static final double TAMANO = 4.5;
    protected static final double PRECIO_BASE = 1000.0;

    // Atributos que describen las características del equipaje
    protected double peso;
    protected double tamano;
    protected double precioBase;

    // Constructores para inicializar el equipaje
    public Equipaje() {
        this(PESO, TAMANO, PRECIO_BASE); // Constructor por defecto
    }

    public Equipaje(double precioBase) {
        this(PESO, TAMANO, precioBase); // Constructor que permite especificar solo el precio base
    }

    public Equipaje(double peso, double tamano) {
        this(peso, tamano, PRECIO_BASE); // Constructor que permite especificar peso y tamaño
    }

    public Equipaje(double peso, double tamano, double precioBase) {
        this.peso = peso; // Inicializa peso
        this.tamano = tamano; // Inicializa tamaño
        this.precioBase = precioBase; // Inicializa precio base
    }

    // Método que debe ser implementado en las subclases para calcular el precio
    public double calcularPrecio() {
        return 0.0; // Precio por defecto para la clase base
    }
}

// Clase para el equipaje de bodega, que extiende de Equipaje
class Bodega extends Equipaje {
    // Constante que representa la capacidad de cálculo
    private static final double CAPACIDAD = 8.0;

    // Constructores
    public Bodega() {
        super(); // Llama al constructor por defecto de Equipaje
    }

    public Bodega(double precioBase) {
        super(precioBase); // Llama al constructor de Equipaje con precio base
    }

    public Bodega(double peso, double tamano) {
        super(peso, tamano); // Llama al constructor de Equipaje con peso y tamaño
    }

    // Método que calcula el precio del equipaje de bodega
    @Override
    public double calcularPrecio() {
        return precioBase + (peso * tamano * CAPACIDAD); // Cálculo del precio para Bodega
    }
}

// Clase para el equipaje de cabina, que también extiende de Equipaje
class Cabina extends Equipaje {
    // Constante que representa el tiempo para el cálculo
    private static final int TIEMPO = 2;

    // Constructores
    public Cabina() {
        super(); // Llama al constructor por defecto de Equipaje
    }

    public Cabina(double precioBase) {
        super(precioBase); // Llama al constructor de Equipaje con precio base
    }

    public Cabina(double peso, double tamano) {
        super(peso, tamano); // Llama al constructor de Equipaje con peso y tamaño
    }

    // Método que calcula el precio del equipaje de cabina
    @Override
    public double calcularPrecio() {
        return precioBase + (peso * tamano * TIEMPO); // Cálculo del precio para Cabina
    }
}