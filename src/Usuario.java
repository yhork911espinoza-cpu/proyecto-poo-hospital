import java.time.LocalDate;

public abstract class Usuario {

    public static int getContadorIds() {
        return contadorIds;
    }

    public static void setContadorIds(int contadorIds) {
        Usuario.contadorIds = contadorIds;
    }
    protected int idUsuario; /// pensando en eso
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String contraseña;
    private int DNI;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento; //Poner la fecha de creacion del Hospital
    private String genero;

    //Contructor de usuarios
    private static int contadorIds = 1;  // Se usa para generar IDs automáticos

    public Usuario (String nombre, String primerApellido, String segundoApellido, String contraseña ,int DNI , String direccion, String telefono, String email, LocalDate fechaNacimiento, String genero){

        this.idUsuario = contadorIds++;

        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.contraseña = contraseña;
        this.DNI = DNI;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }
    //*----------------------------------------------------------------------------------------------------------------------------------------------------------------------- */

    //Metodos de usuario

    //Get y Set de los atributos

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    
    
}
