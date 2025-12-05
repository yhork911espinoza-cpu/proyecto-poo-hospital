// ==================== Paciente.java ====================
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario {
    private List<String> alergias;
    private List<CitaMedica> citas;
    private HistorialMedico historialMedico;

    public Paciente(String nombre, String primerApellido, String segundoApellido, 
                    String contraseña, int dni, String direccion, String telefono, 
                    String email, LocalDate fechaNacimiento, String genero, 
                    List<String> alergias) {
        super(nombre, primerApellido, segundoApellido, contraseña, dni, direccion, 
              telefono, email, fechaNacimiento, genero);
        this.alergias = alergias != null ? alergias : new ArrayList<>();
        this.citas = new ArrayList<>();
        this.historialMedico = new HistorialMedico();
    }

    public List<String> getAlergias() { return alergias; }
    public void setAlergias(List<String> alergias) { this.alergias = alergias; }
    
    public List<CitaMedica> getCitas() { return citas; }
    public HistorialMedico getHistorialMedico() { return historialMedico; }

    public void agregarCita(CitaMedica cita) {
        citas.add(cita);
    }

    public void agregarAlergia(String alergia) {
        if (!alergias.contains(alergia)) {
            alergias.add(alergia);
        }
    }

    @Override
    public void mostrarDatos() {
        System.out.println("\n=== DATOS DEL PACIENTE ===");
        System.out.println("Nombre: " + nombre + " " + primerApellido + " " + segundoApellido);
        System.out.println("DNI: " + dni);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("Género: " + genero);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Alergias: " + (alergias.isEmpty() ? "Ninguna" : String.join(", ", alergias)));
    }

    public void mostrarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No tienes citas registradas.");
            return;
        }
        System.out.println("\n=== MIS CITAS ===");
        for (int i = 0; i < citas.size(); i++) {
            System.out.println((i + 1) + ". " + citas.get(i));
        }
    }
    
}
