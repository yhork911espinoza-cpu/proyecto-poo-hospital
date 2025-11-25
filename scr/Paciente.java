import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Paciente extends Usuario {

    private String numeroHistoriaClinica;
    private String grupoSanguineo;
    private List<String> alergias;
    private String seguroMedico;

    private EstadoPaciente estadoPaciente;
    private Doctor doctorAsignado;

    public Paciente(
        String idUsuario, String nombre, String apellido, String direccion, String telefono, String email,
        Date fechaNacimiento, String genero,
        String numeroHistoriaClinica, String grupoSanguineo, String seguroMedico
    ) {
        super(idUsuario, nombre, apellido, direccion, telefono, email, fechaNacimiento, genero);
        this.numeroHistoriaClinica = numeroHistoriaClinica;
        this.grupoSanguineo = grupoSanguineo;
        this.seguroMedico = seguroMedico;
        this.alergias = new ArrayList<>();
        this.estadoPaciente = EstadoPaciente.ACTIVO;
    }

    public Cita solicitarCita(Doctor doctor, Date fecha) {
        System.out.println("PACIENTE: Solicitando cita con Dr/a. " + doctor.getNombre() + " para el " + fecha.toString());
        return new Cita(this, doctor, fecha);
    }

    public List<ExpedienteMedico> verHistorial() {
        System.out.println("PACIENTE: Accediendo a historial clínico de " + this.getNombre());
        return new ArrayList<>();
    }

    public void agregarAlergia(String alergia) {
        this.alergias.add(alergia);
        System.out.println("PACIENTE: Alergia a " + alergia + " registrada.");
    }

    public EstadoPaciente getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(EstadoPaciente estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
        System.out.println("PACIENTE: Estado actualizado a: " + estadoPaciente.getDescripcion());
    }

    public void setDoctorAsignado(Doctor doctorAsignado) {
        this.doctorAsignado = doctorAsignado;
    }

    public void actualizarSeguro(String seguro) {
        this.seguroMedico = seguro;
        System.out.println("PACIENTE: Seguro médico actualizado a: " + seguro);
    }
}
