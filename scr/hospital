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
    private List<Farmacia> farmacias;
    private List<Departamento> departamentos;

    public Hospital(String nombreHospital, String direccion, String telefono, String email, int capacidadCamas) {
        this.nombreHospital = nombreHospital;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.capacidadCamas = capacidadCamas;
        this.doctores = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.farmacias = new ArrayList<>();
        this.departamentos = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
        System.out.println("HOSPITAL: Paciente " + paciente.getNombre() + " agregado.");
    }

    public void agregarDoctor(Doctor doctor) {
        this.doctores.add(doctor);
        System.out.println("HOSPITAL: Doctor " + doctor.getNombre() + " agregado.");
    }

    public Paciente buscarPaciente(String idPaciente) {
        for (Paciente p : pacientes) {
            if (p.getIdUsuario().equals(idPaciente)) {
                return p;
            }
        }
        System.out.println("HOSPITAL: Paciente no encontrado.");
        return null;
    }

    public Report generarReporteOcupacion() {
        System.out.println("HOSPITAL: Generando reporte de ocupación de camas...");
        return new Report();
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

    public List<Doctor> getDoctores() {
        return doctores;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Farmacia> getFarmacias() {
        return farmacias;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
}
