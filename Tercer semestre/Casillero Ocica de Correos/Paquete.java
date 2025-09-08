// Esta clase guarda la información de cada paquete
public class Paquete {
    private String codigo;
    private String destinatario;
    private String fechaIngreso;
    private String tamano; // pequeño, mediano o grande

    public Paquete(String codigo, String destinatario, String fechaIngreso, String tamano) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.fechaIngreso = fechaIngreso;
        this.tamano = tamano.toLowerCase();
    }

    // Estos métodos son para consultar los datos del paquete
    public String getCodigo() { return codigo; }
    public String getDestinatario() { return destinatario; }
    public String getFechaIngreso() { return fechaIngreso; }
    public String getTamano() { return tamano; }

    // Esto muestra el paquete como un texto cuando lo imprimimos
    @Override
    public String toString() {
        return "Paquete{" +
                "codigo='" + codigo + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                ", tamano='" + tamano + '\'' +
                '}';
    }
}
