import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuardiaSeguridadDAO {

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public boolean agregarGuardiaSeguridad(GuardiaSeguridad guardia) {
        String sql = "INSERT INTO GuardiasSeguridad "
                + "(nombre, primerApellido, segundoApellido, dni, contraseña, direccion, telefono, "
                + "email, fechaNacimiento, genero, areaAsignada, armado, turno) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionSQL.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, guardia.getNombre());
            ps.setString(2, guardia.getPrimerApellido());
            ps.setString(3, guardia.getSegundoApellido());
            ps.setInt(4, guardia.getDni());
            ps.setString(5, guardia.getContraseña());
            ps.setString(6, guardia.getDireccion());
            ps.setString(7, guardia.getTelefono());
            ps.setString(8, guardia.getEmail());
            ps.setDate(9, java.sql.Date.valueOf(guardia.getFechaNacimiento()));
            ps.setString(10, guardia.getGenero());
            ps.setString(11, guardia.getAreaAsignada());
            ps.setBoolean(12, guardia.isArmado());
            ps.setString(13, guardia.getTurno());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar guardia de seguridad: " + e.getMessage());
            return false;
        }
    }

    // ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public GuardiaSeguridad buscarGuardiaSeguridad(int dni) {
        String sql = "SELECT * FROM GuardiasSeguridad WHERE dni = ?";

        try (Connection conn = ConexionSQL.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new GuardiaSeguridad(
                        rs.getString("areaAsignada"), // 1
                        rs.getBoolean("armado"), // 2
                        rs.getString("nombre"), // 3
                        rs.getString("primerApellido"), // 4
                        rs.getString("segundoApellido"), // 5
                        rs.getString("contraseña"), // 6
                        rs.getInt("dni"), // 7
                        rs.getString("direccion"), // 8
                        rs.getString("telefono"), // 9
                        rs.getString("email"), // 10
                        rs.getDate("fechaNacimiento").toLocalDate(), // 11
                        rs.getString("genero"), // 12
                        rs.getString("turno") // 13
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar guardia de seguridad: " + e.getMessage());
        }

        return null;
    }

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public int contarGuardiaSeguridad() {
        String sql = "SELECT COUNT(*) FROM GuardiasSeguridad";

        try (Connection conn = ConexionSQL.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1); // COUNT(*)
            }

        } catch (SQLException e) {
            System.out.println("Error al contar guardias de seguridad: " + e.getMessage());
        }

        return 0; // Si ocurre un error, retorna 0
    }
}
