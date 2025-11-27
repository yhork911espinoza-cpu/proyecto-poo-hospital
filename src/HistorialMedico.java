// ==================== HistorialMedico.java ====================
import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {
    private List<Diagnostico> diagnosticos;
    private List<Tratamiento> tratamientos;
    private List<Examen> examenes;

    public HistorialMedico() {
        this.diagnosticos = new ArrayList<>();
        this.tratamientos = new ArrayList<>();
        this.examenes = new ArrayList<>();
    }

    public void agregarDiagnostico(Diagnostico diagnostico) {
        diagnosticos.add(diagnostico);
    }

    public void agregarTratamiento(Tratamiento tratamiento) {
        tratamientos.add(tratamiento);
    }

    public void agregarExamen(Examen examen) {
        examenes.add(examen);
    }

    public void mostrarHistorial() {
        System.out.println("\n=== HISTORIAL MÉDICO ===");
        
        System.out.println("\nDiagnósticos:");
        if (diagnosticos.isEmpty()) {
            System.out.println("  No hay diagnósticos registrados.");
        } else {
            for (Diagnostico d : diagnosticos) {
                System.out.println("  - " + d);
            }
        }

        System.out.println("\nTratamientos:");
        if (tratamientos.isEmpty()) {
            System.out.println("  No hay tratamientos registrados.");
        } else {
            for (Tratamiento t : tratamientos) {
                System.out.println("  - " + t);
            }
        }

        System.out.println("\nExámenes:");
        if (examenes.isEmpty()) {
            System.out.println("  No hay exámenes registrados.");
        } else {
            for (Examen e : examenes) {
                System.out.println("  - " + e);
            }
        }
    }
}