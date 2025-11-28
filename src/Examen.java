// ==================== Examen.java ====================
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

    @Override
    public String toString() {
        return tipoExamen + " - " + fecha + " | Resultado: " + resultados;
    }
}