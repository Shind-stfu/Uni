public class Libro {
    // Atributos
    private String titulo;
    private String autor;
    private double precio;

    // Constructor
    public Libro(String titulo, String autor, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    // Método para calcular el precio total (en este caso, solo devuelve el precio)
    public double getPrecio() {
        return precio;
    }

    // Método para mostrar información del libro
    public void mostrarInfo() {
        System.out.println("Título: " + titulo + ", Autor: " + autor + ", Precio: $" + precio);
    }
}

public class ManipulacionLibros {
    public static void main(String[] args) {
        // Crear un arreglo de Libros con al menos 5 elementos
        Libro[] libros = new Libro[5];

        // Inicializar los libros con valores de ejemplo
        libros[0] = new Libro("El Principito", "Antoine de Saint-Exupéry", 15.50);
        libros[1] = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 20.00);
        libros[2] = new Libro("Don Quijote", "Miguel de Cervantes", 18.75);
        libros[3] = new Libro("La sombra del viento", "Carlos Ruiz Zafón", 22.30);
        libros[4] = new Libro("1984", "George Orwell", 12.40);

        // Implementar método para calcular el precio total de todos los libros
        double precioTotal = 0;
        for (int i = 0; i < libros.length; i++) {
            precioTotal += libros[i].getPrecio();
        }

        // Mostrar la información de cada libro y el precio total
        for (int i = 0; i < libros.length; i++) {
            System.out.print("Libro " + (i + 1) + ": ");
            libros[i].mostrarInfo();
        }
        System.out.println("Precio total de todos los libros: $" + precioTotal);
    }
}