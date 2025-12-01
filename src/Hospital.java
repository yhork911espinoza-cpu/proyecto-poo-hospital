
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

    public String getNombreHospital() {
        return nombreHospital;
    }

    // Métodos para agregar usuarios
    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void agregarDoctor(Doctor doctor) {
        doctores.add(doctor);
    }

    public void agregarEnfermera(Enfermera enfermera) {
        enfermeras.add(enfermera);
    }

    public void agregarAdministrador(Administrador admin) {
        administradores.add(admin);
    }

    public void agregarDepartamento(Departamento depto) {
        departamentos.add(depto);
    }

    // Métodos de búsqueda
    public Paciente buscarPaciente(int dni) {
        for (Paciente p : pacientes) {
            if (p.getDni() == dni)
                return p;
        }
        return null;
    }

    public Doctor buscarDoctor(int dni) {
        for (Doctor d : doctores) {
            if (d.getDni() == dni)
                return d;
        }
        return null;
    }

    public Enfermera buscarEnfermera(int dni) {
        for (Enfermera e : enfermeras) {
            if (e.getDni() == dni)
                return e;
        }
        return null;
    }

    public Administrador buscarAdministrador(int dni) {
        for (Administrador a : administradores) {
            if (a.getDni() == dni)
                return a;
        }
        return null;
    }

    // Metodos para mostrar usuarios total xd
    public void mostrarPacientesTotal() {
        if(pacientes.isEmpty()){
            System.out.println("No hay pacientes registrados");
        } else {
            for (int i = 0; i < pacientes.size(); i++) {
            Paciente pacien = pacientes.get(i);
            System.out.println((i + 1) + ". " + pacien.getNombre() + " " + pacien.getPrimerApellido() + " "
                    + pacien.getSegundoApellido());
        }
        }
    }

    public void mostrarDoctoresTotal() {
        if( doctores.isEmpty()){
            System.out.println("No hay doctores registrados");
        } else{
            for (int i = 0; i < doctores.size(); i++) {
            Doctor doc = doctores.get(i);
            System.out.println((i + 1) + ". " + doc.getNombre() + " " + doc.getPrimerApellido() + " "
                    + doc.getSegundoApellido());
        }
        }
    }

    public void mostrarEnfermerasTotal() {
        if(enfermeras.isEmpty()){
            System.out.println("No hay enfermeras registrados");
        } else {
            for (int i = 0; i < enfermeras.size(); i++) {
            Enfermera enfer = enfermeras.get(i);
            System.out.println((i + 1) + ". " + enfer.getNombre() + " " + enfer.getPrimerApellido() + " "
                    + enfer.getSegundoApellido());
        }
        }
    }

    public void mostrarAdministradoresTotal() {
        if(administradores.isEmpty()){
            System.out.println("No hay Administradores registrados");
        } else {
            for (int i = 0; i < administradores.size(); i++) {
            Administrador admin = administradores.get(i);
            System.out.println((i + 1) + ". " + admin.getNombre() + " " + admin.getPrimerApellido() + " "
                    + admin.getSegundoApellido());
        }
        }
    }

    public void mostrarDepartamentosTotal() {
        if (departamentos.isEmpty()) {
            System.out.println("No hay Departamentos");
        } else {
            for (int i = 0; i < departamentos.size(); i++) {
                Departamento depa = departamentos.get(i);
                System.out.println((i + 1) + ". " + depa.getNombreDepartamento());
            }
        }
    }

    // GETTERS
    public List<Doctor> getDoctores() {
        return doctores;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
}