import java.util.Stack;

public class ValidacionLlaves {
    public static void main(String[] args) {
        // Crear una pila con la secuencia de llaves
        String[] cadenas = {"{", "[", "(", ")", "]", "}"};

        int resultado = verificarCierre(cadenas);
        if (resultado == 0) {
            System.out.println("Las llaves están completas y correctamente cerradas.");
        } else {
            System.out.println("Las llaves NO están completas o tienen cierre incorrecto. Código de error: " + resultado);
        }
    }

    public static int verificarCierre(String[] cadenas) {
        Stack<String> pila = new Stack<>();

        for (String llave : cadenas) {
            if (esLlaveDeApertura(llave)) {
                pila.push(llave);
            } else {
                // Es llave de cierre, verificar si hay una apertura correspondiente
                if (pila.isEmpty() || !coincideLlave(pila.pop(), llave)) {
                    return 1; // Error: cierre sin apertura o cierre incorrecto
                }
            }
        }

        // Si la pila está vacía, todas las llaves están balanceadas
        return pila.isEmpty() ? 0 : 1; // 0 si está completo, 1 si falta cerrar alguna
    }

    public static boolean esLlaveDeApertura(String llave) {
        return llave.equals("{") || llave.equals("[") || llave.equals("(");
    }

    public static boolean coincideLlave(String apertura, String cierre) {
        return (apertura.equals("{") && cierre.equals("}")) ||
               (apertura.equals("[") && cierre.equals("]")) ||
               (apertura.equals("(") && cierre.equals(")"));
    }
}