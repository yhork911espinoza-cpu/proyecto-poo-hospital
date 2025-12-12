import java.sql.*;
import java.time.LocalDate;

public class Tratamiento {
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Doctor doctor;

    public Tratamiento(String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Doctor doctor) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.doctor = doctor;
    }

    public String getDescripcion() { return descripcion; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public Doctor getDoctor() { return doctor; }

    // Guardar tratamiento en la BD usando DNI del paciente
    public void guardarTratamientoBD(String pacienteDNI) {
        String sql = "INSERT INTO Tratamiento (descripcion, fechaInicio, fechaFin, doctorDNI, pacienteDNI) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionSQL.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, this.descripcion);
            ps.setString(2, this.fechaInicio.toString());
            ps.setString(3, this.fechaFin.toString());
            ps.setInt(4, this.doctor.getDni()); // DNI del doctor
            ps.setString(5, pacienteDNI); // DNI del paciente

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Tratamiento agregado correctamente a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar tratamiento: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return descripcion + " (" + fechaInicio + " - " + fechaFin + ") | Dr. " + doctor.getNombre();
    }
}
