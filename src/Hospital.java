
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
    }

    //Get y set
    public String getNombreHospital() {
        return nombreHospital;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getEmail() {
        return email;
    }
    public int getCapacidadCamas() {
        return capacidadCamas;
    }
    

    
}
