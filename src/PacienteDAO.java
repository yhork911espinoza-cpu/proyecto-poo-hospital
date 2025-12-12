import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteDAO {

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public boolean agregarPaciente(Paciente paciente) {
        String sqlPaciente = "INSERT INTO Pacientes "
                + "(nombre, primerApellido, segundoApellido, dni, contraseña, direccion, telefono, email, fechaNacimiento, genero) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String sqlAlergia = "INSERT INTO Alergias (dniPaciente, alergia) VALUES (?, ?)";

        try (Connection con = ConexionSQL.getConexion()) {

            if (con == null)
                return false;

            // Insertar paciente
            PreparedStatement ps = con.prepareStatement(sqlPaciente);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getPrimerApellido());
            ps.setString(3, paciente.getSegundoApellido());
            ps.setInt(4, paciente.getDni());
            ps.setString(5, paciente.getContraseña());
            ps.setString(6, paciente.getDireccion());
            ps.setString(7, paciente.getTelefono());
            ps.setString(8, paciente.getEmail());
            ps.setDate(9, paciente.getFechaNacimiento() != null ? java.sql.Date.valueOf(paciente.getFechaNacimiento())
                    : null);
            ps.setString(10, paciente.getGenero());

            int filas = ps.executeUpdate();
            if (filas == 0)
                return false;

            // Insertar alergias
            if (paciente.getAlergias() != null) {
                PreparedStatement psA = con.prepareStatement(sqlAlergia);
                for (String alergia : paciente.getAlergias()) {
                    psA.setInt(1, paciente.getDni());
                    psA.setString(2, alergia);
                    psA.executeUpdate();
                }
            }

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public Paciente buscarPaciente(int dni) {
        String sqlPaciente = "SELECT * FROM Pacientes WHERE dni = ?";
        String sqlAlergias = "SELECT alergia FROM Alergias WHERE dniPaciente = ?";

        try (Connection con = ConexionSQL.getConexion()) {

            if (con == null)
                return null;

            // Buscar datos del paciente
            PreparedStatement ps = con.prepareStatement(sqlPaciente);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (!rs.next())
                return null;

            // Crear objeto Paciente
            Paciente paciente = new Paciente(
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
                    new ArrayList<>());

            // Cargar alergias
            PreparedStatement psA = con.prepareStatement(sqlAlergias);
            psA.setInt(1, dni);
            ResultSet rsA = psA.executeQuery();

            while (rsA.next()) {
                paciente.agregarAlergia(rsA.getString("alergia"));
            }

            return paciente;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public int contarPacientes() {
        String sql = "SELECT COUNT(*) AS total FROM Pacientes";

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

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    //                                 ACTUALIZAR DATOS
    public boolean actualizarDireccion(int dni, String nuevaDireccion) {
        String sql = "UPDATE Pacientes SET direccion = ? WHERE dni = ?";

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

    public boolean actualizarTelefono(int dni, String nuevoTelefono) {
        String sql = "UPDATE Pacientes SET telefono = ? WHERE dni = ?";

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

    public boolean actualizarEmail(int dni, String nuevoEmail) {
        String sql = "UPDATE Pacientes SET email = ? WHERE dni = ?";

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

    public boolean agregarAlergia(int dni, String alergia) {
        String sql = "INSERT INTO Alergias (dniPaciente, alergia) VALUES (?, ?)";

        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;

            ps.setInt(1, dni);
            ps.setString(2, alergia);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public ArrayList<Paciente> obtenerTodosPacientes() {
    ArrayList<Paciente> lista = new ArrayList<>();
    String sqlPaciente = "SELECT * FROM Pacientes";
    String sqlAlergias = "SELECT alergia FROM Alergias WHERE dniPaciente = ?";

    try (Connection con = ConexionSQL.getConexion();
         PreparedStatement ps = con.prepareStatement(sqlPaciente);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            int dni = rs.getInt("dni");

            Paciente paciente = new Paciente(
                    rs.getString("nombre"),
                    rs.getString("primerApellido"),
                    rs.getString("segundoApellido"),
                    rs.getString("contraseña"),
                    dni,
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getDate("fechaNacimiento") != null ? rs.getDate("fechaNacimiento").toLocalDate() : null,
                    rs.getString("genero"),
                    new ArrayList<>()
            );

            // Cargar alergias
            try (PreparedStatement psA = con.prepareStatement(sqlAlergias)) {
                psA.setInt(1, dni);
                ResultSet rsA = psA.executeQuery();
                while (rsA.next()) {
                    paciente.agregarAlergia(rsA.getString("alergia"));
                }
            }

            lista.add(paciente);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

}
