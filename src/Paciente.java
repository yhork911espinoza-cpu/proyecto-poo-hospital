import java.time.LocalDate;
import java.util.List;

public class Paciente extends Usuario{
    private String numeroHistoriaClinica;
    private String grupoSanguineo;
    private List<String> alergias;
    private String seguroMedico;
    private EstadoPaciente estadoPaciente;
    private Doctor doctorAsignado;

    //Constructor/s de paciente
    
    public Paciente(String nombre, String primerApellido, String segundoApellido, String direccion, String telefono, String email, LocalDate fechaNacimiento, String genero, //de la clase heredada usuario
                    String numeroHistoriaClinica, String grupoSanguineo, List<String> alergias, String seguroMedico, EstadoPaciente estadoPaciente, Doctor doctorAsignado) {
        super(nombre, primerApellido, segundoApellido, direccion, telefono, email, fechaNacimiento, genero);
        this.numeroHistoriaClinica = numeroHistoriaClinica;
        this.grupoSanguineo = grupoSanguineo;
        this.alergias = alergias;
        this.seguroMedico = seguroMedico;
        this.estadoPaciente = estadoPaciente;
        this.doctorAsignado = doctorAsignado;
    }

    //get y set de paciente

    public String getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }

    public void setNumeroHistoriaClinica(String numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public String getSeguroMedico() {
        return seguroMedico;
    }

    public void setSeguroMedico(String seguroMedico) {
        this.seguroMedico = seguroMedico;
    }

    public EstadoPaciente getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(EstadoPaciente estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
    }

    public Doctor getDoctorAsignado() {
        return doctorAsignado;
    }

    public void setDoctorAsignado(Doctor doctorAsignado) {
        this.doctorAsignado = doctorAsignado;
    }

    
}
