import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Farmacia {

    private String nombre;
    private String direccion;
    private String telefono;

    private ArrayList<Medicamento> medicamentos;

    public Farmacia(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.medicamentos = new ArrayList<>();
    }
    public Farmacia(){
        
    }

    public String getNombre() {
        return nombre;
    }

    // ============================
    // MÉTODOS DE MEDICAMENTOS
    // ============================

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
        System.out.println("Medicamento agregado: " + medicamento.getNombre());
    }

    public Medicamento buscarPorNombre(String nombre) {
        for (Medicamento m : medicamentos) {
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                return m;
            }
        }
        return null;
    }

    public boolean eliminarMedicamento(String nombre) {
        Medicamento encontrado = buscarPorNombre(nombre);
        if (encontrado != null) {
            medicamentos.remove(encontrado);
            System.out.println("Medicamento eliminado: " + nombre);
            return true;
        }
        System.out.println("No existe el medicamento: " + nombre);
        return false;
    }

    public void mostrarTodos() {
        if (medicamentos.isEmpty()) {
            System.out.println("No hay medicamentos registrados.");
            return;
        }

        System.out.println("=== LISTA DE MEDICAMENTOS ===");
        for (Medicamento m : medicamentos) {
            m.mostrarMedicamento();
        }
    }

    public int contarMedicamentos() {
        return medicamentos.size();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public boolean agregarFarmacia(Farmacia farmacia) {
        String sql = "INSERT INTO Farmacia (nombre, direccion, telefono) VALUES (?, ?, ?)";

        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, farmacia.getNombre());
            ps.setString(2, farmacia.getDireccion());
            ps.setString(3, farmacia.getTelefono());

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar farmacia: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Farmacia> obtenerTodasFarmacias() {

        ArrayList<Farmacia> lista = new ArrayList<>();
        String sql = "SELECT nombre, direccion, telefono FROM Farmacia";

        try (Connection con = ConexionSQL.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");

                lista.add(new Farmacia(nombre, direccion, telefono));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener farmacias: " + e.getMessage());
        }

        return lista;
    }

}
