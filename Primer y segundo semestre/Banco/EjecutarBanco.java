public class EjecutarBanco {
    public static void main(String[] args) {
        
        Cuenta objCuenta = new Cuenta( 1000235,2345);

        Cliente objCliente = new Cliente( 1117234567, "Izquierdo");

        System.out.println(objCuenta);

        System.out.println(objCliente);

        Banco objBanco = new Banco(id:1, nombre: "Mi primer Ahorro", objCuenta);

        
    }
}