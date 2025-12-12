
// ==================== Administrador.java ====================
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    // Actualizar nombre
    public boolean actualizarNombre(int dni, String nombre) {
        String sql = "UPDATE Administradores SET nombre = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar nombre: " + e.getMessage());
            return false;
        }
    }

    // Actualizar primer apellido
    public boolean actualizarPrimerApellido(int dni, String primerApellido) {
        String sql = "UPDATE Administradores SET primerApellido = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, primerApellido);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar primer apellido: " + e.getMessage());
            return false;
        }
    }

    // Actualizar segundo apellido
    public boolean actualizarSegundoApellido(int dni, String segundoApellido) {
        String sql = "UPDATE Administradores SET segundoApellido = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, segundoApellido);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar segundo apellido: " + e.getMessage());
            return false;
        }
    }

    // Actualizar contraseña
    public boolean actualizarContrasena(int dni, String contrasena) {
        String sql = "UPDATE Administradores SET contraseña = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, contrasena);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar contraseña: " + e.getMessage());
            return false;
        }
    }

    // Actualizar dirección
    public boolean actualizarDireccion(int dni, String direccion) {
        String sql = "UPDATE Administradores SET direccion = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, direccion);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar dirección: " + e.getMessage());
            return false;
        }
    }

    // Actualizar teléfono
    public boolean actualizarTelefono(int dni, String telefono) {
        String sql = "UPDATE Administradores SET telefono = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, telefono);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar teléfono: " + e.getMessage());
            return false;
        }
    }

    // Actualizar email
    public boolean actualizarEmail(int dni, String email) {
        String sql = "UPDATE Administradores SET email = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar email: " + e.getMessage());
            return false;
        }
    }

    // Actualizar rol
    public boolean actualizarRol(int dni, String rol) {
        String sql = "UPDATE Administradores SET rol = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, rol);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar rol: " + e.getMessage());
            return false;
        }
    }
}
