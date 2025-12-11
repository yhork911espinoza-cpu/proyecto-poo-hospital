
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class PersonalLimpieza extends PersonalHospital {
    private String areaAsignada;

    public PersonalLimpieza(String areaAsignada, String nombre, String primerApellido,
            String segundoApellido, String contraseña, int dni, String direccion,
            String telefono, String email, LocalDate fechaNacimiento, String genero,
            String turno) {
        super(nombre, primerApellido, segundoApellido, contraseña, dni, direccion, telefono, email, fechaNacimiento,
                genero, turno);
        this.areaAsignada = areaAsignada;
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

    // ================================
    // ACTUALIZAR NOMBRE
    // ================================
    public boolean actualizarNombre(int dni, String nuevoNombre) {
        String sql = "UPDATE PersonalLimpieza SET nombre = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;
            ps.setString(1, nuevoNombre);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================================
    // ACTUALIZAR PRIMER APELLIDO
    // ================================
    public boolean actualizarPrimerApellido(int dni, String nuevoApellido) {
        String sql = "UPDATE PersonalLimpieza SET primerApellido = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;
            ps.setString(1, nuevoApellido);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================================
    // ACTUALIZAR SEGUNDO APELLIDO
    // ================================
    public boolean actualizarSegundoApellido(int dni, String nuevoApellido) {
        String sql = "UPDATE PersonalLimpieza SET segundoApellido = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;
            ps.setString(1, nuevoApellido);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================================
    // ACTUALIZAR DIRECCIÓN
    // ================================
    public boolean actualizarDireccion(int dni, String nuevaDireccion) {
        String sql = "UPDATE PersonalLimpieza SET direccion = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;
            ps.setString(1, nuevaDireccion);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================================
    // ACTUALIZAR TELÉFONO
    // ================================
    public boolean actualizarTelefono(int dni, String nuevoTelefono) {
        String sql = "UPDATE PersonalLimpieza SET telefono = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;
            ps.setString(1, nuevoTelefono);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================================
    // ACTUALIZAR EMAIL
    // ================================
    public boolean actualizarEmail(int dni, String nuevoEmail) {
        String sql = "UPDATE PersonalLimpieza SET email = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;
            ps.setString(1, nuevoEmail);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================================
    // ACTUALIZAR ÁREA ASIGNADA
    // ================================
    public boolean actualizarAreaAsignada(int dni, String nuevaArea) {
        String sql = "UPDATE PersonalLimpieza SET areaAsignada = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;
            ps.setString(1, nuevaArea);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================================
    // ACTUALIZAR TURNO
    // ================================
    public boolean actualizarTurno(int dni, String nuevoTurno) {
        String sql = "UPDATE PersonalLimpieza SET turno = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;
            ps.setString(1, nuevoTurno);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================================
    // ACTUALIZAR CONTRASEÑA
    // ================================
    public boolean actualizarContrasena(int dni, String nuevaContrasena) {
        String sql = "UPDATE PersonalLimpieza SET contraseña = ? WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;
            ps.setString(1, nuevaContrasena);
            ps.setInt(2, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================================
    // ELIMINAR POR DNI
    // ================================
    public boolean eliminarPorDni(int dni) {
        String sql = "DELETE FROM PersonalLimpieza WHERE dni = ?";
        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar personal de limpieza: " + e.getMessage());
            return false;
        }
    }

}
