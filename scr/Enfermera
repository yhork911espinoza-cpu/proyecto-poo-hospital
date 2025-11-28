// ==================== Enfermera.java ====================
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Enfermera extends Usuario {
    private String turno;
    private List<Paciente> pacientesAsignados;
    private Departamento departamento;

    public Enfermera(String nombre, String primerApellido, String segundoApellido, 
                     String contraseña, int dni, String direccion, String telefono, 
                     String email, LocalDate fechaNacimiento, String genero, 
                     String turno) {
        super(nombre, primerApellido, segundoApellido, contraseña, dni, direccion, 
              telefono, email, fechaNacimiento, genero);
        this.turno = turno;
        this.pacientesAsignados = new ArrayList<>();
    }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
    
    public List<Paciente> getPacientesAsignados() { return pacientesAsignados; }
    
    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }

    public void agregarPaciente(Paciente paciente) {
        if (!pacientesAsignados.contains(paciente)) {
            pacientesAsignados.add(paciente);
        }
    }

    @Override
    public void mostrarDatos() {
        System.out.println("\n=== DATOS DE LA ENFERMERA ===");
        System.out.println("Nombre: " + nombre + " " + primerApellido + " " + segundoApellido);
        System.out.println("DNI: " + dni);
        System.out.println("Turno: " + turno);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Pacientes asignados: " + pacientesAsignados.size());
    }

    public void mostrarPacientes() {
        if (pacientesAsignados.isEmpty()) {
            System.out.println("No tienes pacientes asignados.");
            return;
        }
        System.out.println("\n=== MIS PACIENTES ===");
        for (int i = 0; i < pacientesAsignados.size(); i++) {
            Paciente p = pacientesAsignados.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " " + 
                             p.getPrimerApellido() + " - DNI: " + p.getDni());
        }
    }
}
