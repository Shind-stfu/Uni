import java.util.*;

public class Mini-Proyecto {
    // Estructuras para gestionar las tareas: pila, cola y un registro de trazabilidad
    private Stack<Tarea> pilaPrioridadAlta; // Tareas con prioridad 3 (alta)
    private Queue<Tarea> colaEspera;        // Tareas con prioridad baja o media
    private Map<String, String> registroTrazabilidad; // Registro de tareas procesadas

    // Constructor
    public GestorTareas() {
        pilaPrioridadAlta = new Stack<>();
        colaEspera = new LinkedList<>();
        registroTrazabilidad = new HashMap<>();
    }

    // Método para agregar una tarea a la gestión
    public void agregarTarea(Tarea tarea) {
        if (tarea.prioridad == 3) {
            // Si la tarea es de alta prioridad, la agregamos a la pila
            pilaPrioridadAlta.push(tarea);
        } else {
            // Para prioridad baja o media, la colocamos en la cola
            colaEspera.offer(tarea);
        }
    }

    // Método para procesar la siguiente tarea en orden de prioridad
    public Tarea procesarSiguienteTarea() {
        Tarea tareaAProcesar = null;

        // Primero, revisamos si hay tareas en la pila de prioridad alta
        if (!pilaPrioridadAlta.isEmpty()) {
            tareaAProcesar = pilaPrioridadAlta.pop();
        } else if (!colaEspera.isEmpty()) {
            // Si no hay en la pila, tomamos de la cola de espera
            tareaAProcesar = colaEspera.poll();
        }

        // Si encontramos una tarea, la marcamos como completada en el registro
        if (tareaAProcesar != null) {
            long tiempoProcesamiento = System.currentTimeMillis() - tareaAProcesar.tiempoLlegada;
            registroTrazabilidad.put(tareaAProcesar.id, "Completada, Tiempo de procesamiento: " + tiempoProcesamiento + " ms");
        }

        return tareaAProcesar;
    }

    // Método para consultar el estado de una tarea por su ID
    public String consultarEstadoTarea(String idTarea) {
        // Ver si la tarea ya fue registrada como completada
        if (registroTrazabilidad.containsKey(idTarea)) {
            return "Tarea completada";
        }

        // Ver si la tarea todavía está pendiente en la pila o en la cola
        for (Tarea tarea : pilaPrioridadAlta) {
            if (tarea.id.equals(idTarea)) {
                return "Pendiente en prioridad alta";
            }
        }

        for (Tarea tarea : colaEspera) {
            if (tarea.id.equals(idTarea)) {
                return "Pendiente en cola de espera";
            }
        }

        // Si no la encontramos en ninguno, es que no existe
        return "ID de tarea no encontrado";
    }

    // Clase interna para representar una tarea
    public static class Tarea {
        String id;
        String descripcion;
        int prioridad; // 1 (baja), 2 (media), 3 (alta)
        long tiempoLlegada; // Marca de tiempo cuando se crea la tarea

        public Tarea(String id, String descripcion, int prioridad, long tiempoLlegada) {
            this.id = id;
            this.descripcion = descripcion;
            this.prioridad = prioridad;
            this.tiempoLlegada = tiempoLlegada;
        }

        @Override
        public String toString() {
            return "Tarea{id='" + id + "', descripcion='" + descripcion + "', prioridad=" + prioridad + "}";
        }
    }

    // Método main para probar cómo funciona el gestor
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();

        // Creamos algunas tareas para experimentar
        Tarea tareaAlta = new Tarea("T1", "Reparar servidor crítico", 3, System.currentTimeMillis());
        Tarea tareaMediana = new Tarea("T2", "Enviar reporte semanal", 2, System.currentTimeMillis());
        Tarea tareaBaja = new Tarea("T3", "Actualizar documentación", 1, System.currentTimeMillis());

        // Las agregamos al gestor
        gestor.agregarTarea(tareaAlta);
        gestor.agregarTarea(tareaMediana);
        gestor.agregarTarea(tareaBaja);

        // Procesamos tareas una por una
        System.out.println("Procesando: " + gestor.procesarSiguienteTarea());
        System.out.println("Procesando: " + gestor.procesarSiguienteTarea());

        // Consultamos el estado de las tareas
        System.out.println("Estado de T1: " + gestor.consultarEstadoTarea("T1"));
        System.out.println("Estado de T2: " + gestor.consultarEstadoTarea("T2"));
        System.out.println("Estado de T3: " + gestor.consultarEstadoTarea("T3"));
    }
}