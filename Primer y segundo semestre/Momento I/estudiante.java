public class estudiante {
    //Atributos 
    private int id; 
    private String nombre;
    private String apellido; 
    private int edad; 
    private String facultad;

    //Metodos 
    public void matricularCursos(String curso){
        System.out.println("curso: " + curso + "Matriculado!!.");
    }

    public String verificarCreditos(int creditos){
        String cad = "";
        if(creditos < 10 ){
            cad = "No puede matricular menos de 10 creditos";
        }else{
            cad = "Sus creditos cumplen con lo requerido";
        }
        return cad;
    }
}