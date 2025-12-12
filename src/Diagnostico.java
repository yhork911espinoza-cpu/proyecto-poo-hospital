import java.sql.*;
import java.time.LocalDate;

public class Diagnostico {
    private String descripcion;
    private LocalDate fecha;
    private Doctor doctor;

    public Diagnostico(String descripcion, LocalDate fecha, Doctor doctor) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.doctor = doctor;
    }

    public String getDescripcion() { return descripcion; }
    public LocalDate getFecha() { return fecha; }
    public Doctor getDoctor() { return doctor; }

    // Guardar diagnóstico en la BD usando DNI del paciente
    public void guardarDiagnosticoBD(String pacienteDNI) {
        String sql = "INSERT INTO Diagnostico (descripcion, fecha, doctorDNI, pacienteDNI) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexionSQL.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, this.descripcion);
            ps.setString(2, this.fecha.toString());
            ps.setInt(3, this.doctor.getDni()); // DNI del doctor
            ps.setString(4, pacienteDNI); // DNI del paciente

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Diagnóstico agregado correctamente a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar diagnóstico: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return fecha + " - " + descripcion + " (Dr. " + doctor.getNombre() + ")";
    }
}
