import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String idDepartamento;
    private String nombreDepartamento;
    private Doctor jefeDepartamento;
    private List<Usuario> personal;
    private String ubicacion;
    private double presupuesto;

    public Departamento(String idDepartamento, String nombreDepartamento, String ubicacion, double presupuesto) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.ubicacion = ubicacion;
        this.presupuesto = presupuesto;
        this.personal = new ArrayList<>();
    }

    public void agregarPersonal(Usuario usuario) {
        this.personal.add(usuario);
        System.out.println("DEPARTAMENTO: " + usuario.getNombre() + " agregado a " + this.nombreDepartamento);
    }

    public Report generarReporteDepartamento() {
        System.out.println("DEPARTAMENTO: Generando reporte de rendimiento para " + this.nombreDepartamento);
        return new Report();
    }

    public void removerPersonal(String idUsuario) {
        System.out.println("DEPARTAMENTO: Buscando personal con ID " + idUsuario + " para remover.");
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Doctor getJefeDepartamento() {
        return jefeDepartamento;
    }

    public void setJefeDepartamento(Doctor jefeDepartamento) {
        this.jefeDepartamento = jefeDepartamento;
    }

    public List<Usuario> getPersonal() {
        return personal;
    }

    public void setPersonal(List<Usuario> personal) {
        this.personal = personal;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
}
