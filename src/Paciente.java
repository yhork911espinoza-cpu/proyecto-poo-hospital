import java.util.Date;
import java.util.List;

public class Paciente extends Usuario{
    private String numeroHistoriaClinica;
    private String grupoSanguineo;
    private List<String> alergias;
    private Date fechaNacimiento;
    private String seguroMedico;
    private EstadoPaciente estadoPaciente;
    private Doctor doctorAsignado;
}
