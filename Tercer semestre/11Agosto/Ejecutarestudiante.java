// Clase principal para probar el sistema
public class Ejecutarestudiante {
    public static void main(String[] args) {
        // Creamos algunos estudiantes
        Estudiante e1 = new Estudiante(1, "Juan", "Pérez", "Ingeniería");
        Estudiante e2 = new Estudiante(2, "María", "López", "Ciencias");
        Estudiante e3 = new Estudiante(3, "Carlos", "Gómez", "Ingeniería");

        // Matriculamos cursos
        e1.matricularCursos(1, new String[]{"Matemáticas", "Programación"});
        e2.matricularCursos(2, new String[]{"Química", "Biología"});
        e3.matricularCursos(3, new String[]{"Programación", "Bases de Datos"});

        // Creamos el gestor de estudiantes y agregamos los que ya tenemos
        GestorEstudiantes gestor = new GestorEstudiantes();
        gestor.agregarEstudiante(e1);
        gestor.agregarEstudiante(e2);
        gestor.agregarEstudiante(e3);

        // Contamos estudiantes por facultad
        gestor.contarPorFacultad();

        // Contamos estudiantes por curso
        gestor.contarPorCurso();

        //mostrar datos completos de cada estudiante
        System.out.println("\n--- Lista completa de estudiantes ---");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
    }
}
