
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

    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    // Métodos para agregar usuarios
    public boolean agregarPaciente(Paciente paciente) {
        PacienteDAO pacientADO = new PacienteDAO();
        return pacientADO.agregarPaciente(paciente);
    }

    public boolean agregarDoctor(Doctor doctor) {
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

    public boolean agregarPersonalLimpieza(PersonalLimpieza perLimpieza) {
        PersonalLimpiezaDAO personalLimmpiezaDAO = new PersonalLimpiezaDAO();
        return personalLimmpiezaDAO.agregarPersonalLimpieza(perLimpieza);
    }

    public boolean agregarguardiaSeguridad(GuardiaSeguridad guardiaSeguridad) {
        GuardiaSeguridadDAO guardiaDao = new GuardiaSeguridadDAO();
        return guardiaDao.agregarGuardiaSeguridad(guardiaSeguridad);
    }

    public boolean agregarCocinero(Cocinero cocinero) {
        CocineroDAO cocineroDAO = new CocineroDAO();
        return cocineroDAO.agregarCocinero(cocinero);
    }

    public boolean agregarDepartamento(Departamento depto) {
        DepartamentoDAO depaDAO = new DepartamentoDAO();
        return depaDAO.agregarDepartamento(depto);
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
        PersonalLimpiezaDAO personalLimpiezaDao = new PersonalLimpiezaDAO();
        return personalLimpiezaDao.buscarPersonalLimpieza(dni);
    }

    public GuardiaSeguridad buscarGuardiaSeguridad(int dni) {
        GuardiaSeguridadDAO guardiaDao = new GuardiaSeguridadDAO();
        return guardiaDao.buscarGuardiaSeguridad(dni);
    }

    public Cocinero buscarCocinero(int dni) {
        CocineroDAO cocinerodao = new CocineroDAO();
        return cocinerodao.buscarCocinero(dni);
    }
    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

    // Metodos para mostrar usuarios total xd
    public void mostrarPacientesTotal() {
        PacienteDAO pacienteDAO = new PacienteDAO();
        ArrayList<Paciente> pacientes = pacienteDAO.obtenerTodosPacientes();

        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados");
        } else {
            System.out.println("=== LISTA DE PACIENTES ===");
            for (Paciente p : pacientes) {
                p.mostrarDatos();
                System.out.println("-------------------------");
            }
        }
    }

    public void mostrarDoctoresTotal() {
        DoctorDAO doctorDAO = new DoctorDAO();
        ArrayList<Doctor> doctores = doctorDAO.obtenerTodosDoctores();

        if (doctores.isEmpty()) {
            System.out.println("No hay doctores registrados");
        } else {
            System.out.println("=== LISTA DE DOCTORES ===");
            for (Doctor d : doctores) {
                d.mostrarDatos();
                System.out.println("-------------------------");
            }
        }
    }

    public void mostrarEnfermerasTotal() {
        EnfermeraDAO enfermeraDAO = new EnfermeraDAO();
        ArrayList<Enfermera> enfermeras = enfermeraDAO.obtenerTodasEnfermeras();

        if (enfermeras.isEmpty()) {
            System.out.println("No hay enfermeras registradas");
        } else {
            System.out.println("=== LISTA DE ENFERMERAS ===");
            for (Enfermera enfer : enfermeras) {
                enfer.mostrarDatos();
                System.out.println("-------------------------");
            }
        }
    }

    public void mostrarAdministradoresTotal() {
        AdministradorDAO adminDAO = new AdministradorDAO();
        ArrayList<Administrador> administradores = adminDAO.obtenerTodosAdministradores();

        if (administradores.isEmpty()) {
            System.out.println("No hay administradores registrados");
        } else {
            System.out.println("=== LISTA DE ADMINISTRADORES ===");
            for (Administrador admin : administradores) {
                admin.mostrarDatos();
                System.out.println("-------------------------");
            }
        }
    }

    public void mostrarCocinerosTotal() {
        CocineroDAO cocineroDAO = new CocineroDAO();
        ArrayList<Cocinero> cocineros = cocineroDAO.obtenerTodosCocineros();

        if (cocineros.isEmpty()) {
            System.out.println("No hay cocineros registrados");
        } else {
            System.out.println("=== LISTA DE COCINEROS ===");
            for (Cocinero c : cocineros) {
                System.out.println("- " + c.getNombre() + " " + c.getPrimerApellido() + " " + c.getSegundoApellido()
                        + " | Turno: " + c.getTurno() + " | Especialidad: " + c.getEspecialidad());
            }
        }
    }

    public void mostrarGuardiasSeguridadTotal() {
        GuardiaSeguridadDAO dao = new GuardiaSeguridadDAO();
        ArrayList<GuardiaSeguridad> guardias = dao.obtenerTodosGuardias();

        if (guardias.isEmpty()) {
            System.out.println("No hay guardias de seguridad registrados");
        } else {
            System.out.println("=== LISTA DE GUARDIAS DE SEGURIDAD ===");
            for (GuardiaSeguridad g : guardias) {
                System.out.println("- " + g.getNombre() + " " + g.getPrimerApellido() + " " + g.getSegundoApellido()
                        + " | Turno: " + g.getTurno()
                        + " | Área: " + g.getAreaAsignada()
                        + " | Armado: " + (g.isArmado() ? "Sí" : "No"));
            }
        }
    }

    public void mostrarPersonalLimpiezaTotal() {
        PersonalLimpiezaDAO dao = new PersonalLimpiezaDAO();
        ArrayList<PersonalLimpieza> personal = dao.obtenerTodosPersonalLimpieza();

        if (personal.isEmpty()) {
            System.out.println("No hay personal de limpieza registrado");
        } else {
            System.out.println("=== LISTA DE PERSONAL DE LIMPIEZA ===");
            for (PersonalLimpieza pl : personal) {
                System.out.println("- " + pl.getNombre() + " " + pl.getPrimerApellido() + " " + pl.getSegundoApellido()
                        + " | Turno: " + pl.getTurno()
                        + " | Área: " + pl.getAreaAsignada());
            }
        }
    }

    public void mostrarDepartamentosTotal() {
        DepartamentoDAO depaDAO = new DepartamentoDAO();
        ArrayList<Departamento> departamentos = depaDAO.obtenerTodosDepartamentos();

        if (departamentos.isEmpty()) {
            System.out.println("No hay departamentos registrados");
        } else {
            System.out.println("=== LISTA DE DEPARTAMENTOS ===");
            for (Departamento depa : departamentos) {
                System.out.println("- " + depa.getNombreDepartamento() + " | Ubicación: " + depa.getUbicacion());
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