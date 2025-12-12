import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorDAO {

    // ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public boolean agregarDoctor(Doctor doctor) {
        String sql = "INSERT INTO Doctores "
                + "(nombre, primerApellido, segundoApellido, dni, contraseña, direccion, telefono, email, fechaNacimiento, genero, especialidad, numeroLicencia) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;

            ps.setString(1, doctor.getNombre());
            ps.setString(2, doctor.getPrimerApellido());
            ps.setString(3, doctor.getSegundoApellido());
            ps.setInt(4, doctor.getDni());
            ps.setString(5, doctor.getContraseña());
            ps.setString(6, doctor.getDireccion());
            ps.setString(7, doctor.getTelefono());
            ps.setString(8, doctor.getEmail());
            ps.setDate(9,
                    doctor.getFechaNacimiento() != null ? java.sql.Date.valueOf(doctor.getFechaNacimiento()) : null);
            ps.setString(10, doctor.getGenero());
            ps.setString(11, doctor.getEspecialidad());
            ps.setString(12, doctor.getNumeroLicencia());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public Doctor buscarDoctor(int dni) {
        String sql = "SELECT * FROM Doctores WHERE dni = ?";

        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return null;

            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Doctor doctor = new Doctor(
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
                        rs.getString("especialidad"),
                        rs.getString("numeroLicencia"));

                return doctor;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public int contarDoctores() {
        String sql = "SELECT COUNT(*) AS total FROM Doctores";

        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return 0;

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public ArrayList<Doctor> obtenerTodosDoctores() {
        ArrayList<Doctor> lista = new ArrayList<>();
        String sql = "SELECT TOP (1000) * FROM Doctores"; // coincide con tu consulta

        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Doctor doctor = new Doctor(
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
                        rs.getString("especialidad"),
                        rs.getString("numeroLicencia"));

                lista.add(doctor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
