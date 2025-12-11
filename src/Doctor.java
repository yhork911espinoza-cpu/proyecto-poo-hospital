
// ==================== Doctor.java ====================
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Usuario {
    private String especialidad;
    private String numeroLicencia;
    private List<CitaMedica> citas;
    private List<Paciente> pacientesAsignados;
    private Departamento departamento;

    public Doctor(String nombre, String primerApellido, String segundoApellido,
            String contraseña, int dni, String direccion, String telefono,
            String email, LocalDate fechaNacimiento, String genero,
            String especialidad, String numeroLicencia) {
        super(nombre, primerApellido, segundoApellido, contraseña, dni, direccion,
                telefono, email, fechaNacimiento, genero);
        this.especialidad = especialidad;
        this.numeroLicencia = numeroLicencia;
        this.citas = new ArrayList<>();
        this.pacientesAsignados = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public List<CitaMedica> getCitas() {
        return citas;
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

    public void agregarCita(CitaMedica cita) {
        citas.add(cita);
    }

    public void agregarPaciente(Paciente paciente) {
        if (!pacientesAsignados.contains(paciente)) {
            pacientesAsignados.add(paciente);
        }
    }

    @Override
    public void mostrarDatos() {
        System.out.println("\n=== DATOS DEL DOCTOR ===");
        System.out.println("Nombre: Dr. " + nombre + " " + primerApellido + " " + segundoApellido);
        System.out.println("DNI: " + dni);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Licencia: " + numeroLicencia);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Pacientes asignados: " + pacientesAsignados.size());
    }

    public void mostrarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No tienes citas programadas.");
            return;
        }
        System.out.println("\n=== MIS CITAS ===");
        for (int i = 0; i < citas.size(); i++) {
            System.out.println((i + 1) + ". " + citas.get(i));
        }
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

    // actualizar datos:

    // ================================
    // ACTUALIZAR NOMBRE
    // ================================
    public boolean actualizarNombre(int dni, String nuevoNombre) {
        String sql = "UPDATE Doctores SET nombre = ? WHERE dni = ?";

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
        String sql = "UPDATE Doctores SET primerApellido = ? WHERE dni = ?";

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
        String sql = "UPDATE Doctores SET segundoApellido = ? WHERE dni = ?";

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
        String sql = "UPDATE Doctores SET direccion = ? WHERE dni = ?";

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
        String sql = "UPDATE Doctores SET telefono = ? WHERE dni = ?";

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
        String sql = "UPDATE Doctores SET email = ? WHERE dni = ?";

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
    // ACTUALIZAR ESPECIALIDAD
    // ================================
    public boolean actualizarEspecialidad(int dni, String nuevaEspecialidad) {
        String sql = "UPDATE Doctores SET especialidad = ? WHERE dni = ?";

        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;

            ps.setString(1, nuevaEspecialidad);
            ps.setInt(2, dni);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================================
    // ACTUALIZAR LICENCIA
    // ================================
    public boolean actualizarNumeroLicencia(int dni, String nuevaLicencia) {
        String sql = "UPDATE Doctores SET numeroLicencia = ? WHERE dni = ?";

        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null)
                return false;

            ps.setString(1, nuevaLicencia);
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
        String sql = "UPDATE Doctores SET contraseña = ? WHERE dni = ?";

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

    // ELIMINAR DOCTOR
    public boolean eliminarPorDni(int dni) {
        String sql = "DELETE FROM Doctores WHERE dni = ?";

        try (Connection conn = ConexionSQL.getConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, dni);
            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar doctor: " + e.getMessage());
            return false;
        }
    }
}
