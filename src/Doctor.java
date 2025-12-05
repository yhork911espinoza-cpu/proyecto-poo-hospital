// ==================== Doctor.java ====================
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Usuario {
    private String especialidad;
    private String numeroLicencia;
    private List<CitaMedica> citas;
    private List<Paciente> pacientesAsignados;
    private Departamento departamento;

    public Doctor(String nombre, String primerApellido, String segundoApellido, 
                  String contraseña, int dni, String direccion, String telefono, 
                  String email, LocalDate fechaNacimiento, String genero, 
                  String especialidad, String numeroLicencia) {
        super(nombre, primerApellido, segundoApellido, contraseña, dni, direccion, 
              telefono, email, fechaNacimiento, genero);
        this.especialidad = especialidad;
        this.numeroLicencia = numeroLicencia;
        this.citas = new ArrayList<>();
        this.pacientesAsignados = new ArrayList<>();
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    
    public String getNumeroLicencia() { return numeroLicencia; }
    public void setNumeroLicencia(String numeroLicencia) { this.numeroLicencia = numeroLicencia; }
    
    public List<CitaMedica> getCitas() { return citas; }
    public List<Paciente> getPacientesAsignados() { return pacientesAsignados; }
    
    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }

    public void agregarCita(CitaMedica cita) {
        citas.add(cita);
    }

    public void agregarPaciente(Paciente paciente) {
        if (!pacientesAsignados.contains(paciente)) {
            pacientesAsignados.add(paciente);
        }
    }

    @Override
    public void mostrarDatos() {
        System.out.println("\n=== DATOS DEL DOCTOR ===");
        System.out.println("Nombre: Dr. " + nombre + " " + primerApellido + " " + segundoApellido);
        System.out.println("DNI: " + dni);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Licencia: " + numeroLicencia);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Pacientes asignados: " + pacientesAsignados.size());
    }

    public void mostrarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No tienes citas programadas.");
            return;
        }
        System.out.println("\n=== MIS CITAS ===");
        for (int i = 0; i < citas.size(); i++) {
            System.out.println((i + 1) + ". " + citas.get(i));
        }
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
