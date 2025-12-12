import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private String nombreHospital;
    private String direccion;
    private String telefono;
    private String email;
    private int capacidadCamas;

    private ArrayList<Farmacia> farmacias;

    // Listas (solo para manejo en memoria si deseas)
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

        this.farmacias = new ArrayList<>();

        this.pacientes = new ArrayList<>();
        this.doctores = new ArrayList<>();
        this.enfermeras = new ArrayList<>();
        this.administradores = new ArrayList<>();
        this.personalLimpieza = new ArrayList<>();
        this.guardiasSeguridad = new ArrayList<>();
        this.cocineros = new ArrayList<>();
        this.departamentos = new ArrayList<>();
    }

    // ============================================================
    // MÉTODOS PARA AGREGAR (LLAMAN A LA BD - DAO)
    // ============================================================

    public boolean agregarPaciente(Paciente paciente) {
        return new PacienteDAO().agregarPaciente(paciente);
    }

    public boolean agregarDoctor(Doctor doctor) {
        return new DoctorDAO().agregarDoctor(doctor);
    }

    public boolean agregarEnfermera(Enfermera enfermera) {
        return new EnfermeraDAO().agregarEnfermera(enfermera);
    }

    public boolean agregarAdministrador(Administrador admin) {
        return new AdministradorDAO().agregarAdministrador(admin);
    }

    public boolean agregarPersonalLimpieza(PersonalLimpieza pl) {
        return new PersonalLimpiezaDAO().agregarPersonalLimpieza(pl);
    }

    public boolean agregarGuardiaSeguridad(GuardiaSeguridad guardia) {
        return new GuardiaSeguridadDAO().agregarGuardiaSeguridad(guardia);
    }

    public boolean agregarCocinero(Cocinero cocinero) {
        return new CocineroDAO().agregarCocinero(cocinero);
    }

    public boolean agregarDepartamento(Departamento dep) {
        return new DepartamentoDAO().agregarDepartamento(dep);
    }

    // ============================================================
    // FARMACIA - CORREGIDO
    // ============================================================

    public boolean agregarFarmacia(Farmacia farmacia) {
    return farmacia.agregarFarmacia(farmacia);
}

public ArrayList<Farmacia> getFarmacias() {
    Farmacia farm = new Farmacia();
    return farm.obtenerTodasFarmacias();
}
    // ============================================================
    // BÚSQUEDA
    // ============================================================

    public Paciente buscarPaciente(int dni) {
        return new PacienteDAO().buscarPaciente(dni);
    }

    public Doctor buscarDoctor(int dni) {
        return new DoctorDAO().buscarDoctor(dni);
    }

    public Enfermera buscarEnfermera(int dni) {
        return new EnfermeraDAO().buscarEnfermera(dni);
    }

    public Administrador buscarAdministrador(int dni) {
        return new AdministradorDAO().buscarAdministrador(dni);
    }

    public PersonalLimpieza buscarPersonalLimpieza(int dni) {
        return new PersonalLimpiezaDAO().buscarPersonalLimpieza(dni);
    }

    public GuardiaSeguridad buscarGuardiaSeguridad(int dni) {
        return new GuardiaSeguridadDAO().buscarGuardiaSeguridad(dni);
    }

    public Cocinero buscarCocinero(int dni) {
        return new CocineroDAO().buscarCocinero(dni);
    }

    // ============================================================
    // MOSTRAR LISTAS COMPLETAS
    // ============================================================

    public void mostrarPacientesTotal() {
        ArrayList<Paciente> lista = new PacienteDAO().obtenerTodosPacientes();

        if (lista.isEmpty()) {
            System.out.println("No hay pacientes registrados");
            return;
        }

        System.out.println("=== LISTA DE PACIENTES ===");
        for (Paciente p : lista) {
            p.mostrarDatos();
            System.out.println("-------------------------");
        }
    }

    public void mostrarDoctoresTotal() {
        ArrayList<Doctor> lista = new DoctorDAO().obtenerTodosDoctores();

        if (lista.isEmpty()) {
            System.out.println("No hay doctores registrados");
            return;
        }

        System.out.println("=== LISTA DE DOCTORES ===");
        for (Doctor d : lista) {
            d.mostrarDatos();
            System.out.println("-------------------------");
        }
    }

    public void mostrarEnfermerasTotal() {
        ArrayList<Enfermera> lista = new EnfermeraDAO().obtenerTodasEnfermeras();

        if (lista.isEmpty()) {
            System.out.println("No hay enfermeras registradas");
            return;
        }

        System.out.println("=== LISTA DE ENFERMERAS ===");
        for (Enfermera e : lista) {
            e.mostrarDatos();
            System.out.println("-------------------------");
        }
    }

    public void mostrarAdministradoresTotal() {
        ArrayList<Administrador> lista = new AdministradorDAO().obtenerTodosAdministradores();

        if (lista.isEmpty()) {
            System.out.println("No hay administradores registrados");
            return;
        }

        System.out.println("=== LISTA DE ADMINISTRADORES ===");
        for (Administrador a : lista) {
            a.mostrarDatos();
            System.out.println("-------------------------");
        }
    }

    public void mostrarCocinerosTotal() {
        ArrayList<Cocinero> lista = new CocineroDAO().obtenerTodosCocineros();

        if (lista.isEmpty()) {
            System.out.println("No hay cocineros registrados");
            return;
        }

        System.out.println("=== LISTA DE COCINEROS ===");
        for (Cocinero c : lista) {
            System.out.println("- " + c.getNombre() + " " + c.getPrimerApellido() + " " + c.getSegundoApellido()
                    + " | Turno: " + c.getTurno() + " | Especialidad: " + c.getEspecialidad());
        }
    }

    public void mostrarGuardiasSeguridadTotal() {
        ArrayList<GuardiaSeguridad> lista = new GuardiaSeguridadDAO().obtenerTodosGuardias();

        if (lista.isEmpty()) {
            System.out.println("No hay guardias registrados");
            return;
        }

        System.out.println("=== LISTA DE GUARDIAS DE SEGURIDAD ===");
        for (GuardiaSeguridad g : lista) {
            System.out.println("- " + g.getNombre() + " " + g.getPrimerApellido() + " " + g.getSegundoApellido()
                    + " | Turno: " + g.getTurno()
                    + " | Área: " + g.getAreaAsignada()
                    + " | Armado: " + (g.isArmado() ? "Sí" : "No"));
        }
    }

    public void mostrarPersonalLimpiezaTotal() {
        ArrayList<PersonalLimpieza> lista = new PersonalLimpiezaDAO().obtenerTodosPersonalLimpieza();

        if (lista.isEmpty()) {
            System.out.println("No hay personal de limpieza registrado");
            return;
        }

        System.out.println("=== LISTA PERSONAL DE LIMPIEZA ===");
        for (PersonalLimpieza pl : lista) {
            System.out.println("- " + pl.getNombre() + " " + pl.getPrimerApellido() + " " + pl.getSegundoApellido()
                    + " | Turno: " + pl.getTurno()
                    + " | Área: " + pl.getAreaAsignada());
        }
    }

    public void mostrarDepartamentosTotal() {
        ArrayList<Departamento> lista = new DepartamentoDAO().obtenerTodosDepartamentos();

        if (lista.isEmpty()) {
            System.out.println("No hay departamentos registrados");
            return;
        }

        System.out.println("=== LISTA DE DEPARTAMENTOS ===");
        for (Departamento d : lista) {
            System.out.println("- " + d.getNombreDepartamento() + " | Ubicación: " + d.getUbicacion());
        }
    }

    // ============================================================
    // GETTERS
    // ============================================================

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

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCapacidadCamas() {
        return capacidadCamas;
    }

    public void setCapacidadCamas(int capacidadCamas) {
        this.capacidadCamas = capacidadCamas;
    }

    public void setFarmacias(ArrayList<Farmacia> farmacias) {
        this.farmacias = farmacias;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void setDoctores(List<Doctor> doctores) {
        this.doctores = doctores;
    }

    public List<Enfermera> getEnfermeras() {
        return enfermeras;
    }

    public void setEnfermeras(List<Enfermera> enfermeras) {
        this.enfermeras = enfermeras;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    public List<PersonalLimpieza> getPersonalLimpieza() {
        return personalLimpieza;
    }

    public void setPersonalLimpieza(List<PersonalLimpieza> personalLimpieza) {
        this.personalLimpieza = personalLimpieza;
    }

    public List<GuardiaSeguridad> getGuardiasSeguridad() {
        return guardiasSeguridad;
    }

    public void setGuardiasSeguridad(List<GuardiaSeguridad> guardiasSeguridad) {
        this.guardiasSeguridad = guardiasSeguridad;
    }

    public List<Cocinero> getCocineros() {
        return cocineros;
    }

    public void setCocineros(List<Cocinero> cocineros) {
        this.cocineros = cocineros;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
}
