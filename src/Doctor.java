import java.time.LocalDate;
import java.util.List;

public class Doctor extends Usuario{
    private String especialidad;
    private String numeroLicencia;
    private int añosExperiencia;
    private Departamento departamento;
    private List<Horario> horariosDisponibles;
    private List<Paciente> pacientesAsignados;

    public Doctor(String nombre, String primerApellido, String segundoApellido, String direccion, String telefono, String email, LocalDate fechaNacimiento, String genero) {
        super(nombre, primerApellido, segundoApellido, direccion, telefono, email, fechaNacimiento, genero);
    }

    
}
