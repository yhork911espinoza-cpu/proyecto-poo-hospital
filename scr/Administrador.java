class Inventario {}
class Report {}
class Solicitud {}

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Administrador extends Usuario {
    private String areaGestion;
    private int nivelAcceso;

    public Administrador(
        String idUsuario, String nombre, String apellido, String direccion, String telefono, String email, Date fechaNacimiento, String genero,
        String areaGestion, int nivelAcceso
    ) {
        super(idUsuario, nombre, apellido, direccion, telefono, email, fechaNacimiento, genero);
        this.areaGestion = areaGestion;
        this.nivelAcceso = nivelAcceso;
    }

    public List<Usuario> gestionarEmpleados() {
        System.out.println("ADMIN: Gestión de empleados iniciada.");
        return new ArrayList<>();
    }

    public Report generarReportes() {
        System.out.println("ADMIN: Generando reporte...");
        return new Report();
    }

    public Inventario gestionarInventario() {
        System.out.println("ADMIN: Accediendo a inventario.");
        return new Inventario();
    }

    public void aprobarSolicitudes(Solicitud solicitud) {
        System.out.println("ADMIN: Revisando solicitud.");
    }

    public void gestionarPresupuesto() {
        System.out.println("ADMIN: Gestionando presupuesto.");
    }

    public void asignarRecursos() {
        System.out.println("ADMIN: Asignando recursos.");
    }

    @Override
    public void iniciarSesion() {
        super.iniciarSesion();
        System.out.println("ADMIN: Acceso al sistema de gestión concedido (Nivel " + this.nivelAcceso + ").");
    }

    public String getAreaGestion() {
        return areaGestion;
    }

    public void setAreaGestion(String areaGestion) {
        this.areaGestion = areaGestion;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }
}
