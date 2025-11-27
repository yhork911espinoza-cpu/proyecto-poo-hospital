// ==================== Hospital.java ====================
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nombreHospital;
    private String direccion;
    private String telefono;
    private String email;
    private int capacidadCamas;
    private List<Paciente> pacientes;
    private List<Doctor> doctores;
    private List<Enfermera> enfermeras;
    private List<Administrador> administradores;
    private List<Departamento> departamentos;

    public Hospital(String nombreHospital, String direccion, String telefono, 
                   String email, int capacidadCamas) {
        this.nombreHospital = nombreHospital;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.capacidadCamas = capacidadCamas;
        this.pacientes = new ArrayList<>();
        this.doctores = new ArrayList<>();
        this.enfermeras = new ArrayList<>();
        this.administradores = new ArrayList<>();
        this.departamentos = new ArrayList<>();
    }

    public String getNombreHospital() { return nombreHospital; }
    
    // Métodos para agregar usuarios
    public void agregarPaciente(Paciente paciente) { pacientes.add(paciente); }
    public void agregarDoctor(Doctor doctor) { doctores.add(doctor); }
    public void agregarEnfermera(Enfermera enfermera) { enfermeras.add(enfermera); }
    public void agregarAdministrador(Administrador admin) { administradores.add(admin); }
    public void agregarDepartamento(Departamento depto) { departamentos.add(depto); }

    // Métodos de búsqueda
    public Paciente buscarPaciente(int dni) {
        for (Paciente p : pacientes) {
            if (p.getDni() == dni) return p;
        }
        return null;
    }

    public Doctor buscarDoctor(int dni) {
        for (Doctor d : doctores) {
            if (d.getDni() == dni) return d;
        }
        return null;
    }

    public Enfermera buscarEnfermera(int dni) {
        for (Enfermera e : enfermeras) {
            if (e.getDni() == dni) return e;
        }
        return null;
    }

    public Administrador buscarAdministrador(int dni) {
        for (Administrador a : administradores) {
            if (a.getDni() == dni) return a;
        }
        return null;
    }

    public List<Doctor> getDoctores() { return doctores; }
    public List<Departamento> getDepartamentos() { return departamentos; }
}