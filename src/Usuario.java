import java.time.LocalDate;

public abstract class Usuario {
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected String contraseña;
    protected int dni;
    protected String direccion;
    protected String telefono;
    protected String email;
    protected LocalDate fechaNacimiento;
    protected String genero;

    public Usuario(String nombre, String primerApellido, String segundoApellido, 
                   String contraseña, int dni, String direccion, String telefono, 
                   String email, LocalDate fechaNacimiento, String genero) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.contraseña = contraseña;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getPrimerApellido() { return primerApellido; }
    public void setPrimerApellido(String primerApellido) { this.primerApellido = primerApellido; }
    
    public String getSegundoApellido() { return segundoApellido; }
    public void setSegundoApellido(String segundoApellido) { this.segundoApellido = segundoApellido; }
    
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    
    public int getDni() { return dni; }
    public void setDni(int dni) { this.dni = dni; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    //******  METODOS USUARIO */

    public abstract void mostrarDatos();
    
    public boolean validarCredenciales(int dni, String contraseña) {
        return this.dni == dni && this.contraseña.equals(contraseña);
    }
}
