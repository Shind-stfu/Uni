public class Cliente {
    
    private int Cedula;
    private String nombre;

    public Cliente(int Cedula, String nombre){
        this.Cedula = Cedula;
        this.nombre = nombre;
    }

    public String toString(){
        return "Cliente { Cedula: " + Cedula + " nombre: " + nombre + " }";
    }
}
