// ==================== Administrador.java ====================
import java.time.LocalDate;

public class Administrador extends Usuario {
    private String rolAdministrador;

    public Administrador(String nombre, String primerApellido, String segundoApellido, 
                        String contraseña, int dni, String direccion, String telefono, 
                        String email, LocalDate fechaNacimiento, String genero, 
                        String rolAdministrador) {
        super(nombre, primerApellido, segundoApellido, contraseña, dni, direccion, 
              telefono, email, fechaNacimiento, genero);
        this.rolAdministrador = rolAdministrador;
    }

    public String getRolAdministrador() { 
        return rolAdministrador; 
    }
    public void setRol(String rolAdministrador) { 
        this.rolAdministrador = rolAdministrador; 
    }

    @Override
    public void mostrarDatos() {
        System.out.println("\n=== DATOS DEL ADMINISTRADOR ===");
        System.out.println("Nombre: " + nombre + " " + primerApellido + " " + segundoApellido);
        System.out.println("DNI: " + dni);
        System.out.println("Rol: " + rolAdministrador);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
    }
}
