// ==================== Departamento.java ====================
import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombre;
    private String ubicacion;
    private List<Doctor> doctores;
    private List<Enfermera> enfermeras;

    public Departamento(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.doctores = new ArrayList<>();
        this.enfermeras = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public List<Doctor> getDoctores() { return doctores; }
    public List<Enfermera> getEnfermeras() { return enfermeras; }

    public void agregarDoctor(Doctor doctor) {
        doctores.add(doctor);
        doctor.setDepartamento(this);
    }

    public void agregarEnfermera(Enfermera enfermera) {
        enfermeras.add(enfermera);
        enfermera.setDepartamento(this);
    }
}
