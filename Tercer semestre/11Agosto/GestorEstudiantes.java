import java.util.ArrayList;
import java.util.HashMap;

// Clase que gestiona una lista de estudiantes
public class GestorEstudiantes {
    private ArrayList<Estudiante> estudiantes; // Lista de estudiantes registrados

    // Constructor
    public GestorEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    // Método para agregar un estudiante a la lista
    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    // Método que cuenta cuántos estudiantes hay en cada facultad
    public void contarPorFacultad() {
        HashMap<String, Integer> conteo = new HashMap<>();

        // Recorremos todos los estudiantes
        for (Estudiante e : estudiantes) {
            String fac = e.getFacultad();
            conteo.put(fac, conteo.getOrDefault(fac, 0) + 1);
        }

        // Mostramos el resultado
        System.out.println("Cantidad de estudiantes por facultad:");
        for (String facultad : conteo.keySet()) {
            System.out.println(facultad + ": " + conteo.get(facultad));
        }
    }
     // Método que cuenta cuántos estudiantes hay en cada curso
    public void contarPorCurso() {
        HashMap<String, Integer> conteo = new HashMap<>();

        // Recorremos cada estudiante y sus cursos
        for (Estudiante e : estudiantes) {
            for (String curso : e.getCursos()) {
                conteo.put(curso, conteo.getOrDefault(curso, 0) + 1);
            }
        }

        // Mostramos el resultado
        System.out.println("Cantidad de estudiantes por curso:");
        for (String curso : conteo.keySet()) {
            System.out.println(curso + ": " + conteo.get(curso));
        }
    }
}