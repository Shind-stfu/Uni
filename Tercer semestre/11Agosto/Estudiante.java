import java.util.ArrayList;

// Clase que representa a un estudiante
public class Estudiante {
    // Atributos de la clase
    private int id;                // Identificador único del estudiante
    private String nombre;         // Nombre del estudiante
    private String apellido;       // Apellido del estudiante
    private String facultad;       // Facultad a la que pertenece
    private ArrayList<String> cursos; // Lista de cursos matriculados por el estudiante

    // Constructor
    public Estudiante(int id, String nombre, String apellido, String facultad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facultad = facultad;
        this.cursos = new ArrayList<>(); // Inicializamos la lista vacía
    }

    // Getter para el ID
    public int getId() {
        return id;
    }

    // Getter para la facultad
    public String getFacultad() {
        return facultad;
    }

    // Getter para los cursos
    public ArrayList<String> getCursos() {
        return cursos;
    }

    // Método matricularCursos
    // Este método recibe un ID y un arreglo de cursos.
    // Los cursos se guardan en la lista interna del estudiante.
    public void matricularCursos(int id, String[] cursos) {
        if (this.id == id) { // Solo se matriculan si el ID coincide
            for (String curso : cursos) {
                this.cursos.add(curso); // Agregamos cada curso a la lista
            }
            System.out.println("ID: " + id + " Cursos matriculados: " + this.cursos);
        } else {
            System.out.println("El ID no coincide con el estudiante.");
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Estudiante { id: " + id +
               ", Nombre: " + nombre +
               ", Apellido: " + apellido +
               ", Facultad: " + facultad +
               ", Cursos: " + cursos + " }";
    }
}
