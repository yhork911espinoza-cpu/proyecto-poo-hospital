
import java.time.LocalDate;

public class GuardiaSeguridad extends PersonalHospital {
    private String areaAsignada;
    private boolean armado;

    public GuardiaSeguridad(String areaAsignada, boolean armado, String nombre,
            String primerApellido, String segundoApellido, String contraseña, int dni,
            String direccion, String telefono, String email, LocalDate fechaNacimiento,
            String genero, String turno) {// --------------------------------------------------------
        super(nombre, primerApellido, segundoApellido, contraseña, dni, direccion, telefono, email, fechaNacimiento,
                genero, turno);
        this.areaAsignada = areaAsignada;
        this.armado = armado;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("\n=== DATOS DEL PACIENTE ===");
        System.out.println("Nombre: " + nombre + " " + primerApellido + " " + segundoApellido);
        System.out.println("DNI: " + dni);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("Género: " + genero);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
    }

    public String getAreaAsignada() {
        return areaAsignada;
    }

    public boolean isArmado() {
        return armado;
    }

}
