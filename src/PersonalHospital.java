
import java.time.LocalDate;

public abstract  class PersonalHospital  extends Usuario{
    protected String turno;

    public PersonalHospital(String nombre, String primerApellido, String segundoApellido, String contraseña, int dni, String direccion, String telefono, String email, LocalDate fechaNacimiento, String genero, String turno) {
        super(nombre, primerApellido, segundoApellido, contraseña, dni, direccion, telefono, email, fechaNacimiento, genero);
        this.turno = turno;
    }

    @Override
    public abstract void mostrarDatos();

    public String getTurno() {
        return turno;
    }


}
