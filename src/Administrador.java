// ==================== Administrador.java ====================
import java.time.LocalDate;

public class Administrador extends Usuario {
    private String rol;

    public Administrador(String nombre, String primerApellido, String segundoApellido, 
                        String contraseña, int dni, String direccion, String telefono, 
                        String email, LocalDate fechaNacimiento, String genero, 
                        String rol) {
        super(nombre, primerApellido, segundoApellido, contraseña, dni, direccion, 
              telefono, email, fechaNacimiento, genero);
        this.rol = rol;
    }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    @Override
    public void mostrarDatos() {
        System.out.println("\n=== DATOS DEL ADMINISTRADOR ===");
        System.out.println("Nombre: " + nombre + " " + primerApellido + " " + segundoApellido);
        System.out.println("DNI: " + dni);
        System.out.println("Rol: " + rol);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
    }
}
