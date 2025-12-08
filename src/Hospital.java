
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
    private List<PersonalLimpieza> personalLimpieza;
    private List<GuardiaSeguridad> guardiasSeguridad;
    private List<Cocinero> cocineros;
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
        this.personalLimpieza = new ArrayList<>();
        this.guardiasSeguridad = new ArrayList<>();
        this.cocineros = new ArrayList<>();
        this.departamentos = new ArrayList<>();
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    // Métodos para agregar usuarios
    public boolean agregarPaciente(Paciente paciente) {
        PacienteDAO pacientADO = new PacienteDAO();
        return pacientADO.agregarPaciente(paciente);
    }

    public boolean  agregarDoctor(Doctor doctor) {
        DoctorDAO doctorADO = new DoctorDAO();
        return doctorADO.agregarDoctor(doctor);
    }

    public boolean agregarEnfermera(Enfermera enfermera) {
        EnfermeraDAO enfermeraADO = new EnfermeraDAO();
        return enfermeraADO.agregarEnfermera(enfermera);
    }

    public boolean agregarAdministrador(Administrador admin) {
        AdministradorDAO dao = new AdministradorDAO();
        return dao.agregarAdministrador(admin);
    }
    public void agregarPersonalLimpieza(PersonalLimpieza perLimpieza){
        personalLimpieza.add(perLimpieza);
    }

    public void agregarguardiaSeguridad(GuardiaSeguridad guardiaSeguridad){
        guardiasSeguridad.add(guardiaSeguridad);
    }
    public void agregarCocinero(Cocinero cocinero){
        cocineros.add(cocinero);
    }

    public void agregarDepartamento(Departamento depto) {
        departamentos.add(depto);
    }

    // ===================================================================================
    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    // Métodos de búsqueda
    public Paciente buscarPaciente(int dni) {
        PacienteDAO pacienteADO = new PacienteDAO();
        return pacienteADO.buscarPaciente(dni);
    }

    public Doctor buscarDoctor(int dni) {
        DoctorDAO doctorADO = new DoctorDAO();
        return doctorADO.buscarDoctor(dni);
    }

    public Enfermera buscarEnfermera(int dni) {
        EnfermeraDAO enfermeraADO = new EnfermeraDAO();
        return enfermeraADO.buscarEnfermera(dni);
    }

    public Administrador buscarAdministrador(int dni) {
    AdministradorDAO dao = new AdministradorDAO();
    return dao.buscarAdministrador(dni);
}

    public PersonalLimpieza buscarPersonalLimpieza(int dni) {
        for (PersonalLimpieza L : personalLimpieza) {
            if (L.getDni() == dni)
                return L;
        }
        return null;
    }

    public GuardiaSeguridad buscarGuardiaSeguridad(int dni) {
        for (GuardiaSeguridad G : guardiasSeguridad) {
            if (G.getDni() == dni)
                return G;
        }
        return null;
    }

    public Cocinero buscarCocinero(int dni) {
        for (Cocinero c : cocineros) {
            if (c.getDni() == dni)
                return c;
        }
        return null;
    }
    //|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

    // Metodos para mostrar usuarios total xd
    public void mostrarPacientesTotal() {
        if (pacientes.isEmpty()) {
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
        if (doctores.isEmpty()) {
            System.out.println("No hay doctores registrados");
        } else {
            for (int i = 0; i < doctores.size(); i++) {
                Doctor doc = doctores.get(i);
                System.out.println((i + 1) + ". " + doc.getNombre() + " " + doc.getPrimerApellido() + " "
                        + doc.getSegundoApellido());
            }
        }
    }

    public void mostrarEnfermerasTotal() {
        if (enfermeras.isEmpty()) {
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
        if (administradores.isEmpty()) {
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

    // TOAL de USUARIOS


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