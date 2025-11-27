import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Paciente extends Usuario{
    private String numeroHistoriaClinica;
    private String grupoSanguineo;
    private List<String> alergias;
    private String seguroMedico;
    private EstadoPaciente estadoPaciente;
    private Doctor doctorAsignado;

    //Constructor/s de paciente
    public Paciente(String nombre, String primerApellido, String segundoApellido, String contraseña, int DNI, String direccion, String telefono, String email, LocalDate fechaNacimiento, String genero, //de la clase heredada usuario
                    List<String> alergias) {
        super(nombre, primerApellido, segundoApellido, contraseña,DNI, direccion, telefono, email, fechaNacimiento, genero);
        this.alergias = alergias;
        this.numeroHistoriaClinica = "HC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    //-------------------------------------------------------------------
    //-----------------  Metodos  ---------------------------------------
    //MNostrar datos del paciente
    public void mostrarDatos(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellidos: " + getPrimerApellido() + " " + getSegundoApellido());
        System.out.println("Número de Historia Clinica: " + getNumeroHistoriaClinica());
        System.out.println("DNI: " + getDNI());
        System.out.println("etc..."); //falta poner más datos o como llenarlos
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
