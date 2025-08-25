public class ArregloDeVehiculos {
    // Clase Vehiculo con atributos y método para mostrar información
    static class Vehiculo {
        private String marca;
        private int year;

        public Vehiculo(String marca, int year) {
            this.marca = marca;
            this.year = year;
        }

        public void mostrarInfo() {
            System.out.println("Marca: " + marca + ", Año: " + year);
        }
    }

    public static void main(String[] args) {
        // Crear un arreglo de Vehiculo con 3 elementos
        Vehiculo[] vehiculos = new Vehiculo[3];

        // Inicializar los elementos del arreglo
        vehiculos[0] = new Vehiculo("Toyota", 2018);
        vehiculos[1] = new Vehiculo("Honda", 2020);
        vehiculos[2] = new Vehiculo("Ford", 2015);

        // Iterar y mostrar la información de cada vehículo
        for (int i = 0; i < vehiculos.length; i++) {
            System.out.print("Vehículo " + (i + 1) + ": ");
            vehiculos[i].mostrarInfo();
        }
    }
}