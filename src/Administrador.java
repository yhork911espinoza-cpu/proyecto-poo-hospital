
import java.time.LocalDate;


public class Administrador extends Usuario{
    private String areaGestion;
    private int nivelAcceso;

    public Administrador(String nombre, String primerApellido, String segundoApellido, String contraseña, int DNI, String direccion, String telefono, String email, LocalDate fechaNacimiento, String genero) {
        super(nombre, primerApellido, segundoApellido, contraseña, DNI , direccion, telefono, email, fechaNacimiento, genero);
    }

    
}
