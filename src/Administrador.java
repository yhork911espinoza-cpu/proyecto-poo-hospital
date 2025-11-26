
import java.time.LocalDate;


public class Administrador extends Usuario{
    private String areaGestion;
    private int nivelAcceso;

    public Administrador(String nombre, String primerApellido, String segundoApellido, String direccion, String telefono, String email, LocalDate fechaNacimiento, String genero) {
        super(nombre, primerApellido, segundoApellido, direccion, telefono, email, fechaNacimiento, genero);
    }

    
}
