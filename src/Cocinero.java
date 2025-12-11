
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Cocinero  extends PersonalHospital{
    private String especialidad;

    public Cocinero(String nombre, String primerApellido, String segundoApellido, String contraseña,
         int dni, String direccion, String telefono, String email, LocalDate fechaNacimiento, 
         String genero, String turno, String especialidad) {
        super(nombre, primerApellido, segundoApellido, contraseña, dni, direccion, telefono, email, fechaNacimiento, genero, turno);
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("\n=== DATOS DEL PACIENTE ===");
        System.out.println("Nombre: " + nombre + " " + primerApellido + " " + segundoApellido);
        System.out.println("DNI: " + dni);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("Género: " + genero);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Turno: " + turno);
    }

    public String getEspecialidad() {
        return especialidad;
    }
    
    // ================================
// ACTUALIZAR NOMBRE
// ================================
public boolean actualizarNombre(int dni, String nuevoNombre) {
    String sql = "UPDATE Cocineros SET nombre = ? WHERE dni = ?";
    try (Connection con = ConexionSQL.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        if (con == null) return false;
        ps.setString(1, nuevoNombre);
        ps.setInt(2, dni);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

// ================================
// ACTUALIZAR PRIMER APELLIDO
// ================================
public boolean actualizarPrimerApellido(int dni, String nuevoApellido) {
    String sql = "UPDATE Cocineros SET primerApellido = ? WHERE dni = ?";
    try (Connection con = ConexionSQL.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        if (con == null) return false;
        ps.setString(1, nuevoApellido);
        ps.setInt(2, dni);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

// ================================
// ACTUALIZAR SEGUNDO APELLIDO
// ================================
public boolean actualizarSegundoApellido(int dni, String nuevoApellido) {
    String sql = "UPDATE Cocineros SET segundoApellido = ? WHERE dni = ?";
    try (Connection con = ConexionSQL.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        if (con == null) return false;
        ps.setString(1, nuevoApellido);
        ps.setInt(2, dni);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

// ================================
// ACTUALIZAR DIRECCIÓN
// ================================
public boolean actualizarDireccion(int dni, String nuevaDireccion) {
    String sql = "UPDATE Cocineros SET direccion = ? WHERE dni = ?";
    try (Connection con = ConexionSQL.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        if (con == null) return false;
        ps.setString(1, nuevaDireccion);
        ps.setInt(2, dni);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

// ================================
// ACTUALIZAR TELÉFONO
// ================================
public boolean actualizarTelefono(int dni, String nuevoTelefono) {
    String sql = "UPDATE Cocineros SET telefono = ? WHERE dni = ?";
    try (Connection con = ConexionSQL.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        if (con == null) return false;
        ps.setString(1, nuevoTelefono);
        ps.setInt(2, dni);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

// ================================
// ACTUALIZAR EMAIL
// ================================
public boolean actualizarEmail(int dni, String nuevoEmail) {
    String sql = "UPDATE Cocineros SET email = ? WHERE dni = ?";
    try (Connection con = ConexionSQL.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        if (con == null) return false;
        ps.setString(1, nuevoEmail);
        ps.setInt(2, dni);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

// ================================
// ACTUALIZAR TURNO
// ================================
public boolean actualizarTurno(int dni, String nuevoTurno) {
    String sql = "UPDATE Cocineros SET turno = ? WHERE dni = ?";
    try (Connection con = ConexionSQL.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        if (con == null) return false;
        ps.setString(1, nuevoTurno);
        ps.setInt(2, dni);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

// ================================
// ACTUALIZAR ESPECIALIDAD
// ================================
public boolean actualizarEspecialidad(int dni, String nuevaEspecialidad) {
    String sql = "UPDATE Cocineros SET especialidad = ? WHERE dni = ?";
    try (Connection con = ConexionSQL.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        if (con == null) return false;
        ps.setString(1, nuevaEspecialidad);
        ps.setInt(2, dni);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

// ================================
// ACTUALIZAR CONTRASEÑA
// ================================
public boolean actualizarContrasena(int dni, String nuevaContrasena) {
    String sql = "UPDATE Cocineros SET contraseña = ? WHERE dni = ?";
    try (Connection con = ConexionSQL.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        if (con == null) return false;
        ps.setString(1, nuevaContrasena);
        ps.setInt(2, dni);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

// ================================
// ELIMINAR POR DNI
// ================================
public boolean eliminarPorDni(int dni) {
    String sql = "DELETE FROM Cocineros WHERE dni = ?";
    try (Connection con = ConexionSQL.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, dni);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error al eliminar cocinero: " + e.getMessage());
        return false;
    }
}

    
}
