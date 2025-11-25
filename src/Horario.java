<<<<<<< HEAD
public class Horario {
    
=======
import java.time.LocalTime;

public class Horario {
    
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private boolean disponible;

    public Horario(String diaSemana, String horaInicioStr, String horaFinStr, boolean disponible) {
        this.diaSemana = diaSemana;
        this.horaInicio = LocalTime.parse(horaInicioStr);
        this.horaFin = LocalTime.parse(horaFinStr);
        this.disponible = disponible;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void marcarOcupado() {
        this.disponible = false;
        System.out.println("HORARIO: Marcado como ocupado para el " + diaSemana + " de " + horaInicio);
    }

    public String getDiaSemana() {
        return diaSemana;
    }
>>>>>>> f2e858b555db88979d7dd4ba2c2008bd35fd4750
}
