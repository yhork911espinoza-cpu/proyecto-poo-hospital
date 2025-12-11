// ==================== Tratamiento.java ====================
import java.time.LocalDate;
import java.util.List;

public class Tratamiento {
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Doctor doctor;
    private List<Medicamento> medicamentos;

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
    public List<Medicamento> getMedicamentos() { return medicamentos; }

    @Override
    public String toString() {
        return descripcion + " (" + fechaInicio + " - " + fechaFin + ") | Dr. " + doctor.getNombre();
    }
}