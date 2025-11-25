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

    public Paciente(List<String> alergias, String grupoSanguineo, String numeroHistoriaClinica, 
                    String seguroMedico, String direccion, String email, LocalDate fechaNacimiento, 
                    String genero, String nombre, String primerApellido, String segundoApellido,
                    String telefono) {//----------------------------------------------------------  
        super(direccion, email, fechaNacimiento, genero, nombre, primerApellido, segundoApellido, telefono);
        this.alergias = alergias;
        this.grupoSanguineo = grupoSanguineo;
        this.numeroHistoriaClinica = numeroHistoriaClinica;
        this.seguroMedico = seguroMedico;
    }
    
}
