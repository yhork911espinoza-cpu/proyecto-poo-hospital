import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartamentoDAO {
    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public boolean agregarDepartamento(Departamento d) {
        String sql = "INSERT INTO Departamentos (nombreDepartamento, ubicacion) VALUES (?, ?)";

        try (Connection conn = ConexionSQL.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.getNombreDepartamento());
            ps.setString(2, d.getUbicacion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar departamento: " + e.getMessage());
            return false;
        }
    }

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public Departamento buscarDepartamento(String nombreDepartamento) {
        String sql = "SELECT * FROM Departamentos WHERE nombreDepartamento = ?";

        try (Connection conn = ConexionSQL.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombreDepartamento);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String ubicacion = rs.getString("ubicacion");

                // Constructor SIN id
                return new Departamento(nombreDepartamento, ubicacion);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar departamento: " + e.getMessage());
        }

        return null;
    }

    // ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public int contarDepartamentos() {
        String sql = "SELECT COUNT(*) FROM Departamentos";

        try (Connection conn = ConexionSQL.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al contar departamentos: " + e.getMessage());
        }

        return 0;
    }
    //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    public ArrayList<Departamento> obtenerTodosDepartamentos() {
        ArrayList<Departamento> lista = new ArrayList<>();
        String sql = "SELECT TOP (1000) * FROM Departamentos"; // coincide con tu tabla

        try (Connection conn = ConexionSQL.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Departamento depa = new Departamento(
                        rs.getString("nombreDepartamento"),
                        rs.getString("ubicacion")
                );

                lista.add(depa);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener departamentos: " + e.getMessage());
        }

        return lista;
    }
}
