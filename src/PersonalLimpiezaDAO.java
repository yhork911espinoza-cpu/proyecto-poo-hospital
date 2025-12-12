import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonalLimpiezaDAO {
    // ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public boolean agregarPersonalLimpieza(PersonalLimpieza pl) {
        String sql = "INSERT INTO PersonalLimpieza "
                + "(nombre, primerApellido, segundoApellido, dni, contraseña, direccion, "
                + "telefono, email, fechaNacimiento, genero, areaAsignada, turno) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionSQL.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pl.getNombre());
            ps.setString(2, pl.getPrimerApellido());
            ps.setString(3, pl.getSegundoApellido());
            ps.setInt(4, pl.getDni());
            ps.setString(5, pl.getContraseña());
            ps.setString(6, pl.getDireccion());
            ps.setString(7, pl.getTelefono());
            ps.setString(8, pl.getEmail());
            ps.setDate(9, java.sql.Date.valueOf(pl.getFechaNacimiento()));
            ps.setString(10, pl.getGenero());
            ps.setString(11, pl.getAreaAsignada());
            ps.setString(12, pl.getTurno());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar personal de limpieza: " + e.getMessage());
            return false;
        }
    }

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public PersonalLimpieza buscarPersonalLimpieza(int dni) {
        String sql = "SELECT * FROM PersonalLimpieza WHERE dni = ?";

        try (Connection conn = ConexionSQL.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new PersonalLimpieza(
                        rs.getString("areaAsignada"), // 1
                        rs.getString("nombre"), // 2
                        rs.getString("primerApellido"), // 3
                        rs.getString("segundoApellido"), // 4
                        rs.getString("contraseña"), // 5
                        rs.getInt("dni"), // 6
                        rs.getString("direccion"), // 7
                        rs.getString("telefono"), // 8
                        rs.getString("email"), // 9
                        rs.getDate("fechaNacimiento").toLocalDate(), // 10
                        rs.getString("genero"), // 11
                        rs.getString("turno") // 12
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar personal limpieza: " + e.getMessage());
        }

        return null;
    }

    // ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public int contarPersonalLimpieza() {
        String sql = "SELECT COUNT(*) FROM PersonalLimpieza";

        try (Connection conn = ConexionSQL.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al contar personal de limpieza: " + e.getMessage());
        }

        return 0;
    }

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public ArrayList<PersonalLimpieza> obtenerTodosPersonalLimpieza() {
        ArrayList<PersonalLimpieza> lista = new ArrayList<>();
        String sql = "SELECT TOP (1000) * FROM PersonalLimpieza";

        try (Connection conn = ConexionSQL.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PersonalLimpieza pl = new PersonalLimpieza(
                        rs.getString("areaAsignada"),
                        rs.getString("nombre"),
                        rs.getString("primerApellido"),
                        rs.getString("segundoApellido"),
                        rs.getString("contraseña"),
                        rs.getInt("dni"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getDate("fechaNacimiento") != null ? rs.getDate("fechaNacimiento").toLocalDate() : null,
                        rs.getString("genero"),
                        rs.getString("turno"));
                lista.add(pl);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener personal de limpieza: " + e.getMessage());
        }

        return lista;
    }

}
