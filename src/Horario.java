import java.time.LocalTime;

public class Horario {

    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private boolean disponible;

    // Constructor
    public Horario(String diaSemana, LocalTime horaInicio, LocalTime horaFin, boolean disponible) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponible = disponible;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void marcarOcupado() {
        this.disponible = false;
    }

    // --- Getters y Setters ---
    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
