import java.util.*;

public class MiniProyecto {
    // Estructuras para gestionar las tareas: pila, cola y un registro de trazabilidad
    private Stack<Tarea> pilaPrioridadAlta; // Tareas con prioridad 3 (alta)
    private Queue<Tarea> colaEspera;        // Tareas con prioridad baja o media
    private Map<String, String> registroTrazabilidad; // Registro de tareas procesadas

    // Constructor
    public MiniProyecto() {
        pilaPrioridadAlta = new Stack<>();
        colaEspera = new LinkedList<>();
        registroTrazabilidad = new HashMap<>();
    }

    // Método para agregar una tarea a la gestión
    public void agregarTarea(Tarea tarea) {
        if (tarea.prioridad == 3) {
            pilaPrioridadAlta.push(tarea);
        } else {
            colaEspera.offer(tarea);
        }
    }

    // Método para procesar la siguiente tarea en orden de prioridad
    public Tarea procesarSiguienteTarea() {
        Tarea tareaAProcesar = null;

        if (!pilaPrioridadAlta.isEmpty()) {
            tareaAProcesar = pilaPrioridadAlta.pop();
        } else if (!colaEspera.isEmpty()) {
            tareaAProcesar = colaEspera.poll();
        }

        if (tareaAProcesar != null) {
            long tiempoProcesamiento = System.currentTimeMillis() - tareaAProcesar.tiempoLlegada;
            registroTrazabilidad.put(tareaAProcesar.id, "Completada, Tiempo de procesamiento: " + tiempoProcesamiento + " ms");
        }

        return tareaAProcesar;
    }

    // Método para consultar el estado de una tarea por su ID
    public String consultarEstadoTarea(String idTarea) {
        if (registroTrazabilidad.containsKey(idTarea)) {
            return "Tarea completada";
        }

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

        return "ID de tarea no encontrado";
    }

    // Método para eliminar una tarea por su ID
    public boolean eliminarTarea(String idTarea) {
        // Buscar en la pila
        Iterator<Tarea> iterPila = pilaPrioridadAlta.iterator();
        while (iterPila.hasNext()) {
            Tarea tarea = iterPila.next();
            if (tarea.id.equals(idTarea)) {
                iterPila.remove();
                registroTrazabilidad.remove(idTarea);
                return true;
            }
        }

        // Buscar en la cola
        Iterator<Tarea> iterCola = colaEspera.iterator();
        while (iterCola.hasNext()) {
            Tarea tarea = iterCola.next();
            if (tarea.id.equals(idTarea)) {
                iterCola.remove();
                registroTrazabilidad.remove(idTarea);
                return true;
            }
        }

        // Si no está en pila ni cola, intentar eliminar del registro (por si acaso)
        if (registroTrazabilidad.containsKey(idTarea)) {
            registroTrazabilidad.remove(idTarea);
            return true;
        }

        return false;
    }

    // Clase interna para representar una tarea
    public static class Tarea {
        String id;
        String descripcion;
        int prioridad; // 1 (baja), 2 (media), 3 (alta)
        long tiempoLlegada;

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

    // Método main para probar el gestor de tareas
    public static void main(String[] args) {
        MiniProyecto gestor = new MiniProyecto();

        // Crear tareas
        Tarea tareaAlta = new Tarea("T1", "Reparar servidor crítico", 3, System.currentTimeMillis());
        Tarea tareaMedia = new Tarea("T2", "Enviar reporte semanal", 2, System.currentTimeMillis());
        Tarea tareaBaja = new Tarea("T3", "Actualizar documentación", 1, System.currentTimeMillis());

        // Agregar tareas
        gestor.agregarTarea(tareaAlta);
        gestor.agregarTarea(tareaMedia);
        gestor.agregarTarea(tareaBaja);

        // Procesar tareas
        System.out.println("Procesando: " + gestor.procesarSiguienteTarea());
        System.out.println("Procesando: " + gestor.procesarSiguienteTarea());

        // Consultar estados
        System.out.println("Estado de T1: " + gestor.consultarEstadoTarea("T1"));
        System.out.println("Estado de T2: " + gestor.consultarEstadoTarea("T2"));
        System.out.println("Estado de T3: " + gestor.consultarEstadoTarea("T3"));

        // Eliminar tarea
        System.out.println("Eliminando T3: " + gestor.eliminarTarea("T1"));
        System.out.println("Estado de T3 después de eliminarla: " + gestor.consultarEstadoTarea("T1"));
         System.out.println("Eliminando T3: " + gestor.eliminarTarea("T2"));
        System.out.println("Estado de T3 después de eliminarla: " + gestor.consultarEstadoTarea("T2"));
       System.out.println("Eliminando T3: " + gestor.eliminarTarea("T3"));
        System.out.println("Estado de T3 después de eliminarla: " + gestor.consultarEstadoTarea("T3"));
   
    }
}
