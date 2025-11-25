import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Doctor extends Usuario {

    private String especialidad;
    private String numeroLicencia;
    private int aniosExperiencia;

    private Departamento departamento;
    private List<Horario> horariosDisponibles;
    private List<Paciente> pacientesAsignados;

    public Doctor(
        String idUsuario, String nombre, String apellido, String direccion, String telefono, String email,
        Date fechaNacimiento, String genero,
        String especialidad, String numeroLicencia, int aniosExperiencia
    ) {
        super(idUsuario, nombre, apellido, direccion, telefono, email, fechaNacimiento, genero);
        this.especialidad = especialidad;
        this.numeroLicencia = numeroLicencia;
        this.aniosExperiencia = aniosExperiencia;
        this.horariosDisponibles = new ArrayList<>();
        this.pacientesAsignados = new ArrayList<>();
    }

    public Diagnostico diagnosticar(Paciente paciente) {
        System.out.println("DOCTOR: Realizando diagnóstico para " + paciente.getNombre());
        return new Diagnostico();
    }

    public Prescripcion recetarMedicamentos(Paciente paciente) {
        System.out.println("DOCTOR: Creando nueva prescripción para " + paciente.getNombre());
        return new Prescripcion();
    }

    public Examen solicitarExamen(Paciente paciente, String tipo) {
        System.out.println("DOCTOR: Solicitando examen de tipo " + tipo + " para " + paciente.getNombre());
        return new Examen();
    }

    public List<Cita> verAgenda() {
        System.out.println("DOCTOR: Mostrando citas programadas.");
        return new ArrayList<>();
    }

    public void agregarHorario(Horario horario) {
        this.horariosDisponibles.add(horario);
        System.out.println("DOCTOR: Horario de " + horario.getDiaSemana() + " agregado.");
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
        System.out.println("DOCTOR: Asignado al departamento de " + departamento.getNombreDepartamento());
    }
}
