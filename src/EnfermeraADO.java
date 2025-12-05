import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnfermeraADO {
    // ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public boolean agregarEnfermera(Enfermera enf) {
        String sql = "INSERT INTO Enfermeras "
                + "(nombre, primerApellido, segundoApellido, dni, contraseña, "
                + "direccion, telefono, email, fechaNacimiento, genero, turno) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;

            ps.setString(1, enf.getNombre());
            ps.setString(2, enf.getPrimerApellido());
            ps.setString(3, enf.getSegundoApellido());
            ps.setInt(4, enf.getDni());
            ps.setString(5, enf.getContraseña());
            ps.setString(6, enf.getDireccion());
            ps.setString(7, enf.getTelefono());
            ps.setString(8, enf.getEmail());
            ps.setDate(9, enf.getFechaNacimiento() != null ? java.sql.Date.valueOf(enf.getFechaNacimiento()) : null);
            ps.setString(10, enf.getGenero());
            ps.setString(11, enf.getTurno());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public Enfermera buscarEnfermera(int dni) {
        String sql = "SELECT * FROM Enfermeras WHERE dni = ?";

        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return null;

            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Enfermera enf = new Enfermera(
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

                return enf;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public int contarEnfermeras() {
        String sql = "SELECT COUNT(*) AS total FROM Enfermeras";

        try (Connection con = ConexionSQL.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null) return 0;

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
