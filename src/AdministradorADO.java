import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorADO {

    //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public boolean agregarAdministrador(Administrador admin) {
        String sql = "INSERT INTO Administradores "
                   + "(nombre, primerApellido, segundoApellido, dni, contraseña, direccion, telefono, email, fechaNacimiento, genero, rol) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionSQL.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null) return false;

            ps.setString(1, admin.getNombre());
            ps.setString(2, admin.getPrimerApellido());
            ps.setString(3, admin.getSegundoApellido());
            ps.setInt(4, admin.getDni());
            ps.setString(5, admin.getContraseña());
            ps.setString(6, admin.getDireccion());
            ps.setString(7, admin.getTelefono());
            ps.setString(8, admin.getEmail());
            ps.setDate(9, admin.getFechaNacimiento() != null ? java.sql.Date.valueOf(admin.getFechaNacimiento()) : null);
            ps.setString(10, admin.getGenero());
            ps.setString(11, admin.getRol());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public Administrador buscarAdministrador(int dni) {
        String sql = "SELECT * FROM Administradores WHERE dni = ?";

        try (Connection con = ConexionSQL.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null) return null;

            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery(); //Es un objeto que contiene todas las filas y columnas que devolvió tu SELECT.

            if (rs.next()) {
                Administrador admin = new Administrador(
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
                        rs.getString("rol")
                    );
                    return admin;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null; // Si no encuentra nada o hay error
        }

    //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public int contarAdministradores() {
        String sql = "SELECT COUNT(*) AS total FROM Administradores";

        try (Connection con = ConexionSQL.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null) return 0;

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total"); // Obtiene el resultado del COUNT(*)
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0; // Retorna 0 si hay error o no hay registros
    }
    //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
}
