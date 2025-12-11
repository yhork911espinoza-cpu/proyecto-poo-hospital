import java.util.ArrayList;

public class Farmacia {

    private ArrayList<Medicamento> medicamentos;

    public Farmacia() {
        medicamentos = new ArrayList<>();
    }

    // Registrar medicamento
    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
        System.out.println("Medicamento agregado: " + medicamento.getNombre());
    }

    // Buscar medicamento por nombre
    public Medicamento buscarPorNombre(String nombre) {
        for (Medicamento m : medicamentos) {
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                return m;
            }
        }
        return null;
    }

    // Eliminar medicamento por nombre
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

    // Mostrar todos los medicamentos
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

    // Contar medicamentos
    public int contarMedicamentos() {
        return medicamentos.size();
    }
}
