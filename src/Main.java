
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Paciente registrarPaciente(Scanner lector) {
        System.out.print("Nombre Completo: ");
        String nombre = lector.nextLine();
        System.out.print("Primer Apellido: ");
        String apellido1 = lector.nextLine();
        System.out.print("Segundo apellido: ");
        String apellido2 = lector.nextLine();
        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(lector.nextLine());
        System.out.print("Dirección: ");
        String direccion = lector.nextLine();
        System.out.print("Teléfono: ");
        String telefono = lector.nextLine();
        System.out.print("Correo: ");
        String email = lector.nextLine();
        System.out.print("Género: ");
        String grupoSanguineo = lector.nextLine();
        System.out.println("¿Tienes alergías?");
        List<String> alergias = new ArrayList<>();
        Paciente nuevoPaciente = new Paciente();
        return nuevoPaciente;
    }

    //--------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        Hospital hospital1 = new Hospital(
                "Hospital San Martín",
                "Av. Los Próceres 145, Arequipa",
                "054-789456",
                "contacto@sanmartin.pe",
                250
        );

        String separacion = "===========================================================================";

        boolean comprobarMenuPrincipal = true;

        // ----------------------- INICIO DEL HOSPITAL --------------------------
        do {
            System.out.println(separacion);
            System.out.println(hospital1.getNombreHospital());
            System.out.println("1.- Iniciar sesión");
            System.out.println("2.- Registrarse (solo pacientes)");
            System.out.println("3.- Salir\n");
            System.out.print("Ingrese una opción: ");

            try { //por si hay errores al poner el entero
                int opcion = lector.nextInt();
                lector.nextLine();

                switch (opcion) {

                    case 1:
                        System.out.println("=== INICIAR SESIÓN ===");
                        break;

                    case 2:
                        System.out.println("=== REGISTRO DE PACIENTE ===");
                        break;

                    case 3:
                        System.out.println("Saliendo del sistema del hospital...");
                        comprobarMenuPrincipal = false;
                        break;

                    default:
                        System.out.println("Ingrese una opción válida (1 - 3)");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero válido.");
                lector.nextLine(); // limpiar entrada inválida
            }

            System.out.println(separacion);

        } while (comprobarMenuPrincipal);
        // ----------------------- FINAL DEL HOSPITAL -----------------------------
    }
}
