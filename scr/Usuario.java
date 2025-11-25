import java.util.Date;

public abstract class Usuario {
    private String idUsuario; 
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private Date fechaNacimiento;
    private String genero;

    public Usuario(String idUsuario, String nombre, String apellido, String direccion, String telefono, String email, Date fechaNacimiento, String genero) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public void iniciarSesion() {
        System.out.println("LOG: " + this.nombre + " ha iniciado sesión.");
    }

    public void cerrarSesion() {
        System.out.println("LOG: " + this.nombre + " ha cerrado sesión.");
    }

    public void actualizarPerfil() {
        System.out.println("PERFIL: " + this.nombre + " perfil actualizado.");
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
