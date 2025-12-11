
// ==================== Enfermera.java ====================
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Enfermera extends Usuario {
    private String turno;
    private List<Paciente> pacientesAsignados;
    private Departamento departamento;

    public Enfermera(String nombre, String primerApellido, String segundoApellido,
            String contraseña, int dni, String direccion, String telefono,
            String email, LocalDate fechaNacimiento, String genero,
            String turno) {
        super(nombre, primerApellido, segundoApellido, contraseña, dni, direccion,
                telefono, email, fechaNacimiento, genero);
        this.turno = turno;
        this.pacientesAsignados = new ArrayList<>();
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public List<Paciente> getPacientesAsignados() {
        return pacientesAsignados;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void agregarPaciente(Paciente paciente) {
        if (!pacientesAsignados.contains(paciente)) {
            pacientesAsignados.add(paciente);
        }
    }

    @Override
    public void mostrarDatos() {
        System.out.println("\n=== DATOS DE LA ENFERMERA ===");
        System.out.println("Nombre: " + nombre + " " + primerApellido + " " + segundoApellido);
        System.out.println("DNI: " + dni);
        System.out.println("Turno: " + turno);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Pacientes asignados: " + pacientesAsignados.size());
    }

    public void mostrarPacientes() {
        if (pacientesAsignados.isEmpty()) {
            System.out.println("No tienes pacientes asignados.");
            return;
        }
        System.out.println("\n=== MIS PACIENTES ===");
        for (int i = 0; i < pacientesAsignados.size(); i++) {
            Paciente p = pacientesAsignados.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " " +
                    p.getPrimerApellido() + " - DNI: " + p.getDni());
        }
    }

    // ================================
    // ACTUALIZAR NOMBRE
    // ================================
    public boolean actualizarNombre(int dni, String nuevoNombre) {
        String sql = "UPDATE Enfermeras SET nombre = ? WHERE dni = ?";

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
        String sql = "UPDATE Enfermeras SET primerApellido = ? WHERE dni = ?";

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
        String sql = "UPDATE Enfermeras SET segundoApellido = ? WHERE dni = ?";

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
        String sql = "UPDATE Enfermeras SET direccion = ? WHERE dni = ?";

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
        String sql = "UPDATE Enfermeras SET telefono = ? WHERE dni = ?";

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
        String sql = "UPDATE Enfermeras SET email = ? WHERE dni = ?";

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
    // ACTUALIZAR TURNO
    // ================================
    public boolean actualizarTurno(int dni, String nuevoTurno) {
        String sql = "UPDATE Enfermeras SET turno = ? WHERE dni = ?";

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
        String sql = "UPDATE Enfermeras SET contraseña = ? WHERE dni = ?";

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
        String sql = "DELETE FROM Enfermeras WHERE dni = ?";

        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar enfermera: " + e.getMessage());
            return false;
        }
    }
}
