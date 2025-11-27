
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Paciente registrarPaciente(Scanner lector) {
        System.out.print("Nombres: ");
        String nombre = lector.nextLine();
        System.out.print("Primer apellido: ");
        String apellido1 = lector.nextLine();
        System.out.print("Segundo apellido: ");
        String apellido2 = lector.nextLine();

        LocalDate fechaNacimiento = null; // *** Caso de fecha de nacimiento */
        while (true) {
            try {
                System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                String fechaStr = lector.nextLine();

                fechaNacimiento = LocalDate.parse(fechaStr); // intenta convertir

                break; // si llega aquí, es una fecha correcta
            } catch (Exception e) {
                System.out.println("Formato inválido. Intenta de nuevo. Ejemplo: 2005-11-01");
            }
        }

        System.out.print("Dirección: ");
        String direccion = lector.nextLine();
        System.out.print("Teléfono: ");
        String telefono = lector.nextLine();
        System.out.print("Correo: ");
        String email = lector.nextLine();
        System.out.print("Género: ");
        String genero = lector.nextLine();

        // ************ Alergias del paciente *************************/
        List<String> alergias = new ArrayList<>();
        System.out.println("¿Tienes alergías? (si/no)");
        String comprobarAlergias = lector.nextLine().toLowerCase();
        if (comprobarAlergias.equalsIgnoreCase("si")) {
            System.out.println("Ingrese las alergías una por una:");
            System.out.println("Cuando termines, escribe (fin).");
            while (true) {
                System.out.print("Alergia: ");
                String alergia = lector.nextLine();
                if (alergia.equalsIgnoreCase("fin") || alergia.isBlank()) {
                    break; // termina ingreso
                }

                alergias.add(alergia);
            }
        }

        Paciente nuevoPaciente = new Paciente(nombre, apellido1, apellido2, direccion, telefono, email, fechaNacimiento,
                genero, alergias);
        return nuevoPaciente;
    }

    // --------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        Hospital hospital1 = new Hospital(
                "Hospital San Martín",
                "Av. Los Próceres 145, Arequipa",
                "054-789456",
                "contacto@sanmartin.pe",
                250);

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

            try { // por si hay errores al poner el entero
                int opcion = lector.nextInt();
                lector.nextLine();

                switch (opcion) {

                    case 1:
                        System.out.println("=== INICIAR SESIÓN ===");
                        break;

                    case 2:
                        System.out.println("=== REGISTRO DE PACIENTE ===");
                        Paciente nuevopaciente = registrarPaciente(lector);
                        hospital1.agregarPaciente(nuevopaciente);

                        Paciente pacientebuscado = hospital1.buscarPaciente(0);

                        boolean comprobarPacienteAcciones = true;

                        do {
                            System.out.println("=== " + pacientebuscado.getNombre() + " " +
                                    pacientebuscado.getPrimerApellido() + " " +
                                    pacientebuscado.getSegundoApellido() + " ===");

                            System.out.println("=== ACCIONES DISPONIBLES ===");
                            System.out.println("1.- Ver mis datos");
                            System.out.println("2.- Editar mis datos");
                            System.out.println("3.- Registrar cita médica");
                            System.out.println("4.- Ver mis citas");
                            System.out.println("5.- Salir");

                            System.out.print("Ingrese una opción: ");
                            int opcionPacienteAcciones = lector.nextInt();
                            lector.nextLine(); // limpiar buffer

                            switch (opcionPacienteAcciones) {

                                case 1:
                                    System.out.println("Mostrando datos del paciente...");
                                    break;

                                case 2:
                                    System.out.println("Editar datos...");
                                    break;

                                case 3:
                                    System.out.println("Registrar cita...");
                                    break;

                                case 4:
                                    System.out.println("Mostrando citas...");
                                    break;

                                case 5:
                                    System.out.println("Volviendo al menú principal...");
                                    comprobarPacienteAcciones = false;
                                    break;

                                default:
                                    System.out.println("Opción no válida.");
                            }

                        } while (comprobarPacienteAcciones); // para que se pueda salir al menu del inicio sin iniciar sesion

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
