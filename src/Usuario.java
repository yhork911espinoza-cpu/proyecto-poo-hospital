import java.time.LocalDate;
import java.util.UUID;

public abstract class Usuario {
    private String idUsuario;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento; //Poner la fecha de creacion del Hospital
    private String genero;

    //Contructor de usuarios
    public Usuario(String direccion, String email, LocalDate fechaNacimiento, String genero, String nombre, String primerApellido, String segundoApellido, String telefono) {
        this.direccion = direccion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.idUsuario = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
    }

    //Metodos de usuario
    
}
