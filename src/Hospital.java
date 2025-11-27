
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nombreHospital;
    private String direccion;
    private String telefono;
    private String email;
    private int capacidadCamas;
    private List<Doctor> doctores;
    private List<Paciente> pacientes;
    private List<Enfermera> enfermeras;
    private List<Administrador> administradores;
    private List<Farmacia> farmacias;
    private List<Departamento> departamentos;


    //Contructor
    public Hospital(String nombreHospital, String direccion, String telefono, String email, int capacidadCamas) {
        this.nombreHospital = nombreHospital;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.capacidadCamas = capacidadCamas;
        this.doctores = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.enfermeras = new ArrayList<>();
        this.administradores = new ArrayList<>();
        this.farmacias = new ArrayList<>();
        this.departamentos = new ArrayList<>();
    }

    //Metodo agregar paciente
    public void agregarPaciente(Paciente paciente){
        pacientes.add(paciente);
        System.out.println("Paciente registrado.");
    }

    public Paciente buscarPaciente(int idPaciente){
        return pacientes.get(idPaciente);
    }

    //Get y set

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

    public List<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(List<Doctor> doctores) {
        this.doctores = doctores;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Enfermera> getEnfermeras() {
        return enfermeras;
    }

    public void setEnfermeras(List<Enfermera> enfermeras) {
        this.enfermeras = enfermeras;
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    public List<Farmacia> getFarmacias() {
        return farmacias;
    }

    public void setFarmacias(List<Farmacia> farmacias) {
        this.farmacias = farmacias;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
    

    
}
