import java.time.LocalDate;
import java.util.List;

public class Enfermera extends Usuario{
    private String departamento;
    private String turno;
    private List<String> certificaciones;

    public Enfermera(String nombre, String primerApellido, String segundoApellido,String contraseña,int DNI, String direccion, String telefono, String email, LocalDate fechaNacimiento, String genero) {
        super(nombre, primerApellido, segundoApellido, contraseña,DNI , direccion, telefono, email, fechaNacimiento, genero);
    }
    
}
