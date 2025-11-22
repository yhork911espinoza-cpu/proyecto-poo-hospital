import java.util.List;

public class Doctor extends Usuario{
    private String especialidad;
    private String numeroLicencia;
    private int añosExperiencia;
    private Departamento departamento;
    private List<Horario> horariosDisponibles;
    private List<Paciente> pacientesAsignados;
}
