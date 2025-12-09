import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CocineroDAO {

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public boolean agregarCocinero(Cocinero cocinero) {
        String sql = "INSERT INTO Cocineros "
                + "(nombre, primerApellido, segundoApellido, dni, contraseña, direccion, "
                + "telefono, email, fechaNacimiento, genero, turno, especialidad) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionSQL.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cocinero.getNombre());
            ps.setString(2, cocinero.getPrimerApellido());
            ps.setString(3, cocinero.getSegundoApellido());
            ps.setInt(4, cocinero.getDni());
            ps.setString(5, cocinero.getContraseña());
            ps.setString(6, cocinero.getDireccion());
            ps.setString(7, cocinero.getTelefono());
            ps.setString(8, cocinero.getEmail());
            ps.setDate(9, java.sql.Date.valueOf(cocinero.getFechaNacimiento()));
            ps.setString(10, cocinero.getGenero());
            ps.setString(11, cocinero.getTurno());
            ps.setString(12, cocinero.getEspecialidad());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar cocinero: " + e.getMessage());
            return false;
        }
    }

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public Cocinero buscarCocinero(int dni) {
        String sql = "SELECT * FROM Cocineros WHERE dni = ?";

        try (Connection conn = ConexionSQL.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Cocinero(
                        rs.getString("nombre"),
                        rs.getString("primerApellido"),
                        rs.getString("segundoApellido"),
                        rs.getString("contraseña"),
                        rs.getInt("dni"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getDate("fechaNacimiento").toLocalDate(),
                        rs.getString("genero"),
                        rs.getString("turno"),
                        rs.getString("especialidad"));
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar cocinero: " + e.getMessage());
        }

        return null;
    }

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public int contarCocineros() {
        String sql = "SELECT COUNT(*) FROM Cocineros";

        try (Connection conn = ConexionSQL.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1); // La primera columna del COUNT(*)
            }

        } catch (SQLException e) {
            System.out.println("Error al contar cocineros: " + e.getMessage());
        }

        return 0; // Si algo falla, devuelve 0
    }
}
