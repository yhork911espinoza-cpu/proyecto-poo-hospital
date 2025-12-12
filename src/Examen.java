import java.sql.*;
import java.time.LocalDate;

public class Examen {
    private String tipoExamen;
    private LocalDate fecha;
    private String resultados;
    private Doctor doctor;

    public Examen(String tipoExamen, LocalDate fecha, String resultados, Doctor doctor) {
        this.tipoExamen = tipoExamen;
        this.fecha = fecha;
        this.resultados = resultados;
        this.doctor = doctor;
    }

    public String getTipoExamen() { return tipoExamen; }
    public LocalDate getFecha() { return fecha; }
    public String getResultados() { return resultados; }
    public Doctor getDoctor() { return doctor; }

    // Guardar examen en la BD usando DNI del paciente
    public void guardarExamenBD(String pacienteDNI) {
        String sql = "INSERT INTO Examen (tipoExamen, fecha, resultados, doctorDNI, pacienteDNI) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionSQL.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, this.tipoExamen);
            ps.setString(2, this.fecha.toString());
            ps.setString(3, this.resultados);
            ps.setInt(4, this.doctor.getDni()); // DNI del doctor
            ps.setString(5, pacienteDNI); // DNI del paciente

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Examen agregado correctamente a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar examen: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return tipoExamen + " - " + fecha + " | Resultado: " + resultados + " | Dr. " + doctor.getNombre();
    }
}
