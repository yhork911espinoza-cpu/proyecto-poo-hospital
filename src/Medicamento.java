public class Medicamento {

    private String nombre;
    private String dosis; 
    private String frecuencia; 
    private int duracionDias; 
    private String instrucciones; 

    public Medicamento(String nombre, String dosis, String frecuencia, int duracionDias, String instrucciones) {
        this.nombre = nombre;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.duracionDias = duracionDias;
        this.instrucciones = instrucciones;
    }

    public void mostrarMedicamento() {
        System.out.println("Medicamento: " + nombre);
        System.out.println("Dosis: " + dosis);
        System.out.println("Frecuencia: " + frecuencia);
        System.out.println("Duración: " + duracionDias + " días");
        System.out.println("Instrucciones: " + instrucciones);
        System.out.println("----------------------------------------");
    }

    // Getters
    public String getNombre() { return nombre; }
}
