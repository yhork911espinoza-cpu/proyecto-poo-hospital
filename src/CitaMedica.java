// ==================== CitaMedica.java ====================
import java.time.LocalDateTime;

public class CitaMedica {
    private Paciente paciente;
    private Doctor doctor;
    private LocalDateTime fechaHora;
    private String motivo;
    private String estado;
    private String consultorio;

    public CitaMedica(LocalDateTime fechaHora, String motivo, Paciente paciente, 
                     Doctor doctor, String consultorio) {
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.paciente = paciente;
        this.doctor = doctor;
        this.consultorio = consultorio;
        this.estado = "Programada";
    }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public Paciente getPaciente() { return paciente; }
    public Doctor getDoctor() { return doctor; }
    
    public String getConsultorio() { return consultorio; }
    public void setConsultorio(String consultorio) { this.consultorio = consultorio; }

    @Override
    public String toString() {
        return "Cita: " + fechaHora + " | Motivo: " + motivo + 
               " | Doctor: Dr. " + doctor.getNombre() + " " + doctor.getPrimerApellido() +
               " | Consultorio: " + consultorio + " | Estado: " + estado;
    }
}
