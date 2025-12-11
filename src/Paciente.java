
// ==================== Paciente.java ====================
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario {
    private List<String> alergias;
    private List<CitaMedica> citas;
    private HistorialMedico historialMedico;

    public Paciente(String nombre, String primerApellido, String segundoApellido,
            String contraseña, int dni, String direccion, String telefono,
            String email, LocalDate fechaNacimiento, String genero,
            List<String> alergias) {
        super(nombre, primerApellido, segundoApellido, contraseña, dni, direccion,
                telefono, email, fechaNacimiento, genero);
        this.alergias = alergias != null ? alergias : new ArrayList<>();
        this.citas = new ArrayList<>();
        this.historialMedico = new HistorialMedico();
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public List<CitaMedica> getCitas() {
        return citas;
    }

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    public void agregarCita(CitaMedica cita) {
        citas.add(cita);
    }

    public void agregarAlergia(String alergia) {
        if (!alergias.contains(alergia)) {
            alergias.add(alergia);
        }
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
        System.out.println("Alergias: " + (alergias.isEmpty() ? "Ninguna" : String.join(", ", alergias)));
    }

    public void mostrarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No tienes citas registradas.");
            return;
        }
        System.out.println("\n=== MIS CITAS ===");
        for (int i = 0; i < citas.size(); i++) {
            System.out.println((i + 1) + ". " + citas.get(i));
        }
    }

    // ================================
    // ACTUALIZAR NOMBRE
    // ================================
    public boolean actualizarNombre(int dni, String nuevoNombre) {
        String sql = "UPDATE Pacientes SET nombre = ? WHERE dni = ?";

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
        String sql = "UPDATE Pacientes SET primerApellido = ? WHERE dni = ?";

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
        String sql = "UPDATE Pacientes SET segundoApellido = ? WHERE dni = ?";

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

    // ================================
    // ACTUALIZAR TELÉFONO
    // ================================
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

    // ================================
    // ACTUALIZAR EMAIL
    // ================================
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

    // ================================
    // ACTUALIZAR CONTRASEÑA
    // ================================
    public boolean actualizarContrasena(int dni, String nuevaContrasena) {
        String sql = "UPDATE Pacientes SET contraseña = ? WHERE dni = ?";

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
        String sql = "DELETE FROM Pacientes WHERE dni = ?";

        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar paciente: " + e.getMessage());
            return false;
        }
    }

}
