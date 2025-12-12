import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// 192.168.1.3

public class Main {
    private static final String SEPARACION = "===========================================================================";
    private static Scanner lector = new Scanner(System.in);

    // ======================== MÉTODOS DE REGISTRO ========================
    public static Paciente registrarPaciente() {
        System.out.println("\n=== REGISTRO DE PACIENTE ===");
        System.out.print("Nombres: ");
        String nombre = lector.nextLine();
        System.out.print("Primer apellido: ");
        String apellido1 = lector.nextLine();
        System.out.print("Segundo apellido: ");
        String apellido2 = lector.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = lector.nextLine();

        int dni = 0;
        while (true) {
            try {
                System.out.print("DNI: ");
                dni = lector.nextInt();
                lector.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("DNI inválido. Debe ser un número.");
                lector.nextLine();
            }
        }

        LocalDate fechaNacimiento = null;
        while (true) {
            try {
                System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                String fechaStr = lector.nextLine();
                fechaNacimiento = LocalDate.parse(fechaStr);
                break;
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

        List<String> alergias = new ArrayList<>();
        System.out.print("¿Tienes alergías? (si/no): ");
        String comprobarAlergias = lector.nextLine().toLowerCase();
        if (comprobarAlergias.equalsIgnoreCase("si")) {
            System.out.println("Ingrese las alergías una por una (escribe 'fin' para terminar):");
            while (true) {
                System.out.print("Alergia: ");
                String alergia = lector.nextLine();
                if (alergia.equalsIgnoreCase("fin") || alergia.isBlank()) {
                    break;
                }
                alergias.add(alergia);
            }
        }

        return new Paciente(nombre, apellido1, apellido2, contraseña, dni, direccion,
                telefono, email, fechaNacimiento, genero, alergias);
    }

    // ======================== MÉTODOS DE LOGIN ========================
    public static Paciente loginPaciente(Hospital hospital) {
        System.out.println("\n=== LOGIN PACIENTE ===");
        System.out.print("DNI: ");
        int dni = lector.nextInt();
        lector.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = lector.nextLine();

        Paciente paciente = hospital.buscarPaciente(dni);
        if (paciente != null && paciente.validarCredenciales(dni, contraseña)) {
            System.out.println("Inicio de sesión exitoso!");
            return paciente;
        } else {
            System.out.println(" DNI o contraseña incorrectos.");
            return null;
        }
    }

    public static Administrador loginAdministrador(Hospital hospital) {
        System.out.println("\n=== LOGIN ADMINISTRADOR ===");
        System.out.print("DNI: ");
        int dni = lector.nextInt();
        lector.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = lector.nextLine();

        Administrador admin = hospital.buscarAdministrador(dni);
        if (admin != null && admin.validarCredenciales(dni, contraseña)) {
            System.out.println("Inicio de sesión exitoso!");
            return admin;
        } else {
            System.out.println("DNI o contraseña incorrectos.");
            return null;
        }
    }

    public static Doctor loginDoctor(Hospital hospital) {
        System.out.println("\n=== LOGIN DOCTOR ===");
        System.out.print("DNI: ");
        int dni = lector.nextInt();
        lector.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = lector.nextLine();

        Doctor doctor = hospital.buscarDoctor(dni);
        if (doctor != null && doctor.validarCredenciales(dni, contraseña)) {
            System.out.println("Inicio de sesión exitoso!");
            return doctor;
        } else {
            System.out.println(" DNI o contraseña incorrectos.");
            return null;
        }
    }

    public static Enfermera loginEnfermera(Hospital hospital) {
        System.out.println("\n=== LOGIN ENFERMERA ===");
        System.out.print("DNI: ");
        int dni = lector.nextInt();
        lector.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = lector.nextLine();

        Enfermera enfermera = hospital.buscarEnfermera(dni);
        if (enfermera != null && enfermera.validarCredenciales(dni, contraseña)) {
            System.out.println("Inicio de sesión exitoso!");
            return enfermera;
        } else {
            System.out.println(" DNI o contraseña incorrectos.");
            return null;
        }
    }

    public static PersonalHospital loginPersonalHospital(Hospital hospital) {
        System.out.println("=== ¿Qué tipo de trabajador eres? ===");
        System.out.println("1. Personal de Limpieza\n2. Guardia de Seguridad\n3. Cocinero");
        System.out.print("Opcion: ");
        int opcion = lector.nextInt();
        switch (opcion) {
            case 1: {
                System.out.println("=== LOGIN PERSONAL DE LIMPIEZA ===");
                System.out.print("DNI: ");
                int dni = lector.nextInt();
                lector.nextLine();
                System.out.print("Contraseña: ");
                String contraseña = lector.nextLine();

                PersonalLimpieza trabajadorLimpieza = hospital.buscarPersonalLimpieza(dni);
                if (trabajadorLimpieza != null && trabajadorLimpieza.validarCredenciales(dni, contraseña)) {
                    System.out.println("Inicio de sesión exitoso!");
                    return trabajadorLimpieza;
                } else {
                    System.out.println("DNI o contraseña incorrectos.");
                    return null;
                }
            }
            case 2: {
                System.out.println("=== LOGIN GUARDIA DE SEGURIDAD ===");
                System.out.print("DNI: ");
                int dni = lector.nextInt();
                lector.nextLine();
                System.out.print("Contraseña: ");
                String contraseña = lector.nextLine();

                GuardiaSeguridad guardiaSeguridad = hospital.buscarGuardiaSeguridad(dni);
                if (guardiaSeguridad != null && guardiaSeguridad.validarCredenciales(dni, contraseña)) {
                    System.out.println("Inicio de sesión exitoso!");
                    return guardiaSeguridad;
                } else {
                    System.out.println("DNI o contraseña incorrectos.");
                    return null;
                }
            }
            case 3: {
                System.out.println("=== LOGIN COCINERO ===");
                System.out.print("DNI: ");
                int dni = lector.nextInt();
                lector.nextLine();
                System.out.print("Contraseña: ");
                String contraseña = lector.nextLine();

                Cocinero cocinero = hospital.buscarCocinero(dni);
                if (cocinero != null && cocinero.validarCredenciales(dni, contraseña)) {
                    System.out.println("Inicio de sesión exitoso!");
                    return cocinero;
                } else {
                    System.out.println("DNI o contraseña incorrectos.");
                    return null;
                }
            }
            default:
                System.out.println("Opción no válida.");
        }
        return null;
    }

    // ======================== MENÚS DE USUARIO ========================
    public static void menuPaciente(Paciente paciente, Hospital hospital) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n" + SEPARACION);
            System.out.println("BIENVENIDO: " + paciente.getNombre() + " " +
                    paciente.getPrimerApellido() + " " + paciente.getSegundoApellido());
            // ========================================================
            // ================ paciente ==============================
            System.out.println("=== MENÚ PACIENTE ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Editar mis datos");
            System.out.println("3. Registrar cita médica");
            System.out.println("4. Ver mis citas");
            System.out.println("5. Ver mi historial médico");
            System.out.println("0. Cerrar sesión");
            System.out.print("Opción: ");

            try {
                int opcion = lector.nextInt();
                lector.nextLine();

                switch (opcion) {
                    case 1:
                        paciente.mostrarDatos();
                        break;
                    case 2:
                        editarDatosPaciente(paciente);
                        break;
                    case 3:
                        registrarCita(paciente, hospital);
                        break;
                    case 4:
                        paciente.mostrarCitas();
                        break;
                    case 5:
                        paciente.getHistorialMedico().mostrarHistorial();
                        break;
                    case 0:
                        System.out.println("Cerrando sesión...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                lector.nextLine();
            }
        }
    }

    public static void menuDoctor(Doctor doctor, Hospital hospital) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n" + SEPARACION);
            System.out.println("BIENVENIDO: Dr. " + doctor.getNombre() + " " +
                    doctor.getPrimerApellido() + " " + doctor.getSegundoApellido());
            System.out.println("=== MENÚ DOCTOR ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Editar datos");
            System.out.println("3. Ver mis citas");
            System.out.println("4. Ver mis pacientes");
            System.out.println("5. Agregar diagnóstico");
            System.out.println("6. Agregar tratamiento");
            System.out.println("0. Cerrar sesión");
            System.out.print("Opción: ");

            try {
                int opcion = lector.nextInt();
                lector.nextLine();

                switch (opcion) {
                    case 1:
                        doctor.mostrarDatos();
                        break;
                    case 2:
                        System.out.println("===== EDITAR DATOS=====");
                        System.out.println("1. Nombre");
                        System.out.println("2. Primer apellido");
                        System.out.println("3. Segundo apellido");
                        System.out.println("4. Dirección");
                        System.out.println("5. Teléfono");
                        System.out.println("6. Email");
                        System.out.println("7. Contraseña");
                        System.out.println("8. Especialidad");
                        System.out.println("9. Número de licencia");
                        System.out.println("0. Volver");
                        System.out.print("Seleccione una opción: ");
                        int opcionDatoActualizar = lector.nextInt();
                        lector.nextLine();
                        switch (opcionDatoActualizar) {

                            case 1:
                                // Lógica para actualizar nombre
                                System.out.print("Nuevo nombre: ");
                                String nuevoNombre = lector.nextLine();
                                doctor.actualizarNombre(doctor.getDni(), nuevoNombre);
                                System.out.println("Nombre actualizado exitosamente.");
                                break;

                            case 2:
                                // Lógica para actualizar primer apellido
                                System.out.print("Nuevo primer apellido: ");
                                String nuevoPrimerApellido = lector.nextLine();
                                doctor.actualizarPrimerApellido(doctor.getDni(), nuevoPrimerApellido);
                                System.out.println("Primer apellido actualizado exitosamente.");
                                break;

                            case 3:
                                // Lógica para actualizar segundo apellido
                                System.out.print("Nuevo segundo apellido: ");
                                String nuevoSegundoApellido = lector.nextLine();
                                doctor.actualizarSegundoApellido(doctor.getDni(), nuevoSegundoApellido);
                                System.out.println("Segundo apellido actualizado exitosamente.");
                                break;

                            case 4:
                                // Lógica para actualizar dirección
                                System.out.print("Nueva dirección: ");
                                String nuevaDireccion = lector.nextLine();
                                doctor.actualizarDireccion(doctor.getDni(), nuevaDireccion);
                                System.out.println("Dirección actualizada exitosamente.");
                                break;

                            case 5:
                                // Lógica para actualizar teléfono
                                System.out.print("Nuevo teléfono: ");
                                String nuevoTelefono = lector.nextLine();
                                doctor.actualizarTelefono(doctor.getDni(), nuevoTelefono);
                                System.out.println("Teléfono actualizado exitosamente.");
                                break;

                            case 6:
                                // Lógica para actualizar email
                                System.out.print("Nuevo email: ");
                                String nuevoEmail = lector.nextLine();
                                doctor.actualizarEmail(doctor.getDni(), nuevoEmail);
                                System.out.println("Email actualizado exitosamente.");
                                break;

                            case 7:
                                // Lógica para actualizar contraseña
                                System.out.print("Nueva contraseña: ");
                                String nuevaContrasena = lector.nextLine();
                                doctor.actualizarContrasena(doctor.getDni(), nuevaContrasena);
                                System.out.println("Contraseña actualizada exitosamente.");
                                break;

                            case 8:
                                // Lógica para actualizar especialidad
                                System.out.print("Nueva especialidad: ");
                                String nuevaEspecialidad = lector.nextLine();
                                doctor.actualizarEspecialidad(doctor.getDni(), nuevaEspecialidad);
                                System.out.println("Especialidad actualizada exitosamente.");
                                break;

                            case 9:
                                // Lógica para actualizar número de licencia
                                System.out.print("Nuevo número de licencia: ");
                                String nuevaLicencia = lector.nextLine();
                                doctor.actualizarNumeroLicencia(doctor.getDni(), nuevaLicencia);
                                System.out.println("Número de licencia actualizado exitosamente.");
                                break;

                            case 0:
                                System.out.println("Volviendo...");
                                break;

                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                        System.out.println(SEPARACION);
                        break;
                    case 3:
                        doctor.mostrarCitas();
                        break;
                    case 4:
                        doctor.mostrarPacientes();
                        break;
                    case 5:
                        agregarDiagnostico(doctor, hospital);
                        break;
                    case 6:
                        agregarTratamiento(doctor, hospital);
                        break;
                    case 0:
                        System.out.println("Cerrando sesión...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                lector.nextLine();
            }
        }
    }

    public static void menuEnfermera(Enfermera enfermera, Hospital hospital) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n" + SEPARACION);
            System.out.println("BIENVENIDA: " + enfermera.getNombre() + " " +
                    enfermera.getPrimerApellido());
            System.out.println("=== MENÚ ENFERMERA ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Editar datos");
            System.out.println("3. Ver mis pacientes");
            System.out.println("4. Buscar paciente");
            System.out.println("0. Cerrar sesión");
            System.out.print("Opción: ");

            try {
                int opcion = lector.nextInt();
                lector.nextLine();

                switch (opcion) {
                    case 1:
                        enfermera.mostrarDatos();
                        break;
                    case 2:
                        System.out.println("===== EDITAR DATOS =====");
                        System.out.println("1. Nombre");
                        System.out.println("2. Primer apellido");
                        System.out.println("3. Segundo apellido");
                        System.out.println("4. Dirección");
                        System.out.println("5. Teléfono");
                        System.out.println("6. Email");
                        System.out.println("7. Turno");
                        System.out.println("8. Contraseña");
                        System.out.println("0. Volver");
                        int a = lector.nextInt();
                        lector.nextLine();

                        switch (a) {
                            case 1:
                                System.out.print("Nuevo nombre: ");
                                enfermera.actualizarNombre(enfermera.getDni(), lector.nextLine());
                                break;

                            case 2:
                                System.out.print("Nuevo primer apellido: ");
                                enfermera.actualizarPrimerApellido(enfermera.getDni(), lector.nextLine());
                                break;

                            case 3:
                                System.out.print("Nuevo segundo apellido: ");
                                enfermera.actualizarSegundoApellido(enfermera.getDni(), lector.nextLine());
                                break;

                            case 4:
                                System.out.print("Nueva dirección: ");
                                enfermera.actualizarDireccion(enfermera.getDni(), lector.nextLine());
                                break;

                            case 5:
                                System.out.print("Nuevo teléfono: ");
                                enfermera.actualizarTelefono(enfermera.getDni(), lector.nextLine());
                                break;

                            case 6:
                                System.out.print("Nuevo email: ");
                                enfermera.actualizarEmail(enfermera.getDni(), lector.nextLine());
                                break;

                            case 7:
                                System.out.print("Nuevo turno: ");
                                enfermera.actualizarTurno(enfermera.getDni(), lector.nextLine());
                                break;

                            case 8:
                                System.out.print("Nueva contraseña: ");
                                enfermera.actualizarContrasena(enfermera.getDni(), lector.nextLine());
                                break;

                            case 0:
                                break;

                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                        break;
                    case 3:
                        enfermera.mostrarPacientes();
                        break;
                    case 4:
                        buscarPacienteEnfermera(hospital);
                        break;
                    case 0:
                        System.out.println("Cerrando sesión...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                lector.nextLine();
            }
        }
    }

    public static void menuAdministrador(Administrador admin, Hospital hospital) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n" + SEPARACION);
            System.out.println("BIENVENIDO: " + admin.getNombre() + " " +
                    admin.getPrimerApellido() + " " + admin.getSegundoApellido());
            System.out.println("=== MENÚ ADMINISTRADOR ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Editar Datos");
            System.out.println("3. Ver estadísticas");
            System.out.println("4. Registrar un Usuario");
            System.out.println("5. Buscar un usuario");
            System.out.println("6. Crear departamento");
            System.out.println("7. Ver registros");
            System.out.println("0. Cerrar sesión");
            System.out.print("Opción: ");

            try {
                int opcion = lector.nextInt();
                lector.nextLine();

                switch (opcion) {
                    case 1:
                        admin.mostrarDatos();
                        break;
                    case 2:
                        System.out.println("===== EDITAR DATOS =====");
                        System.out.println("1. Nombre");
                        System.out.println("2. Primer apellido");
                        System.out.println("3. Segundo apellido");
                        System.out.println("4. Contraseña");
                        System.out.println("5. Dirección");
                        System.out.println("6. Teléfono");
                        System.out.println("7. Email");
                        System.out.print("Opción: ");
                        int opcionEditarDatos = lector.nextInt();
                        lector.nextLine();

                        switch (opcionEditarDatos) {
                            case 1:
                                System.out.print("Nuevo nombre: ");
                                String nuevoNombre = lector.nextLine();
                                if (admin.actualizarNombre(admin.getDni(), nuevoNombre)) {
                                    System.out.println("Nombre actualizado correctamente.");
                                } else {
                                    System.out.println("Error al actualizar el nombre.");
                                }
                                break;

                            case 2:
                                System.out.print("Nuevo primer apellido: ");
                                String nuevoPrimerApellido = lector.nextLine();
                                if (admin.actualizarPrimerApellido(admin.getDni(), nuevoPrimerApellido)) {
                                    System.out.println("Primer apellido actualizado correctamente.");
                                } else {
                                    System.out.println("Error al actualizar el primer apellido.");
                                }
                                break;

                            case 3:
                                System.out.print("Nuevo segundo apellido: ");
                                String nuevoSegundoApellido = lector.nextLine();
                                if (admin.actualizarSegundoApellido(admin.getDni(), nuevoSegundoApellido)) {
                                    System.out.println("Segundo apellido actualizado correctamente.");
                                } else {
                                    System.out.println("Error al actualizar el segundo apellido.");
                                }
                                break;

                            case 4:
                                System.out.print("Nueva contraseña: ");
                                String nuevaContrasena = lector.nextLine();
                                if (admin.actualizarContrasena(admin.getDni(), nuevaContrasena)) {
                                    System.out.println("Contraseña actualizada correctamente.");
                                } else {
                                    System.out.println("Error al actualizar la contraseña.");
                                }
                                break;

                            case 5:
                                System.out.print("Nueva dirección: ");
                                String nuevaDireccion = lector.nextLine();
                                if (admin.actualizarDireccion(admin.getDni(), nuevaDireccion)) {
                                    System.out.println("Dirección actualizada correctamente.");
                                } else {
                                    System.out.println("Error al actualizar la dirección.");
                                }
                                break;

                            case 6:
                                System.out.print("Nuevo teléfono: ");
                                String nuevoTelefono = lector.nextLine();
                                if (admin.actualizarTelefono(admin.getDni(), nuevoTelefono)) {
                                    System.out.println("Teléfono actualizado correctamente.");
                                } else {
                                    System.out.println("Error al actualizar el teléfono.");
                                }
                                break;

                            case 7:
                                System.out.print("Nuevo email: ");
                                String nuevoEmail = lector.nextLine();
                                if (admin.actualizarEmail(admin.getDni(), nuevoEmail)) {
                                    System.out.println("Email actualizado correctamente.");
                                } else {
                                    System.out.println("Error al actualizar el email.");
                                }
                                break;

                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                        break; // fin del case 2

                    case 3:
                        mostrarEstadisticas(hospital);
                        break;
                    case 4:
                        registrarUsuario(hospital, admin);
                        break;
                    case 5:
                        buscarUsuario(hospital);
                        break;
                    case 6:
                        crearDepartamento(hospital);
                        break;
                    case 7:
                        verRegistros(hospital);
                        break;
                    case 0:
                        System.out.println("Cerrando sesión...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                lector.nextLine();
            }
        }
    }

    public static void menuLimpieza(PersonalLimpieza L, Hospital hospital) {
        boolean salir = false;
        while (!salir) {
            System.out.println(SEPARACION);
            System.out.println(
                    "BIENVENIDO: " + L.getNombre() + " " + L.getPrimerApellido() + " " + L.getSegundoApellido());
            System.out.println("\n=== MENÚ PERSONAL DE LIMPIEZA ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Editar datos");
            System.out.println("3. Ver área asignada");
            System.out.println("4. Registrar limpieza realizada");
            System.out.println("0. Cerrar sesión");
            System.out.print("Opción: ");

            int opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 1:
                    L.mostrarDatos();
                    break;
                case 2:
                    System.out.println("===== EDITAr DATOS =====");
                    System.out.println("1. Nombre");
                    System.out.println("2. Primer apellido");
                    System.out.println("3. Segundo apellido");
                    System.out.println("4. Dirección");
                    System.out.println("5. Teléfono");
                    System.out.println("6. Email");
                    System.out.println("7. Área asignada");
                    System.out.println("8. Turno");
                    System.out.println("9. Contraseña");
                    System.out.println("0. Volver");
                    int a = lector.nextInt();
                    lector.nextLine();

                    switch (a) {
                        case 1:
                            System.out.print("Nuevo nombre: ");
                            L.actualizarNombre(L.getDni(), lector.nextLine());
                            break;
                        case 2:
                            System.out.print("Nuevo primer apellido: ");
                            L.actualizarPrimerApellido(L.getDni(), lector.nextLine());
                            break;
                        case 3:
                            System.out.print("Nuevo segundo apellido: ");
                            L.actualizarSegundoApellido(L.getDni(), lector.nextLine());
                            break;
                        case 4:
                            System.out.print("Nueva dirección: ");
                            L.actualizarDireccion(L.getDni(), lector.nextLine());
                            break;
                        case 5:
                            System.out.print("Nuevo teléfono: ");
                            L.actualizarTelefono(L.getDni(), lector.nextLine());
                            break;
                        case 6:
                            System.out.print("Nuevo email: ");
                            L.actualizarEmail(L.getDni(), lector.nextLine());
                            break;
                        case 7:
                            System.out.print("Nueva área asignada: ");
                            L.actualizarAreaAsignada(L.getDni(), lector.nextLine());
                            break;
                        case 8:
                            System.out.print("Nuevo turno: ");
                            L.actualizarTurno(L.getDni(), lector.nextLine());
                            break;
                        case 9:
                            System.out.print("Nueva contraseña: ");
                            L.actualizarContrasena(L.getDni(), lector.nextLine());
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                    break;
                case 3:
                    System.out.println("Área asignada: " + L.getAreaAsignada());
                    break;
                case 4:
                    System.out.println("Registro guardado!");
                    break;
                case 0:
                    salir = true;
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static void menuGuardia(GuardiaSeguridad G, Hospital hospital) {
        boolean salir = false;
        while (!salir) {
            System.out.println(SEPARACION);
            System.out.println(
                    "BIENVENIDO: " + G.getNombre() + " " + G.getPrimerApellido() + " " + G.getSegundoApellido());
            System.out.println("\n=== MENÚ GUARDIA DE SEGURIDAD ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Editar datos");
            System.out.println("3. Ver turno");
            System.out.println("4. Registrar incidencia");
            System.out.println("0. Cerrar sesión");
            System.out.print("Opción: ");

            int opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 1:
                    G.mostrarDatos();
                    break;
                case 2:
                    System.out.println("===== EDITAR DATOS =====");
                    System.out.println("1. Nombre");
                    System.out.println("2. Primer apellido");
                    System.out.println("3. Segundo apellido");
                    System.out.println("4. Dirección");
                    System.out.println("5. Teléfono");
                    System.out.println("6. Email");
                    System.out.println("7. Área asignada");
                    System.out.println("8. Armado");
                    System.out.println("9. Turno");
                    System.out.println("10. Contraseña");
                    System.out.println("0. Volver");
                    int a = lector.nextInt();
                    lector.nextLine();

                    switch (a) {
                        case 1:
                            System.out.print("Nuevo nombre: ");
                            G.actualizarNombre(G.getDni(), lector.nextLine());
                            break;
                        case 2:
                            System.out.print("Nuevo primer apellido: ");
                            G.actualizarPrimerApellido(G.getDni(), lector.nextLine());
                            break;
                        case 3:
                            System.out.print("Nuevo segundo apellido: ");
                            G.actualizarSegundoApellido(G.getDni(), lector.nextLine());
                            break;
                        case 4:
                            System.out.print("Nueva dirección: ");
                            G.actualizarDireccion(G.getDni(), lector.nextLine());
                            break;
                        case 5:
                            System.out.print("Nuevo teléfono: ");
                            G.actualizarTelefono(G.getDni(), lector.nextLine());
                            break;
                        case 6:
                            System.out.print("Nuevo email: ");
                            G.actualizarEmail(G.getDni(), lector.nextLine());
                            break;
                        case 7:
                            System.out.print("Nueva área asignada: ");
                            G.actualizarAreaAsignada(G.getDni(), lector.nextLine());
                            break;
                        case 8:
                            System.out.print("Armado (sí/no): ");
                            String armadoStr = lector.nextLine().trim().toLowerCase();

                            boolean armadoBool;
                            if (armadoStr.equals("sí") || armadoStr.equals("si")) {
                                armadoBool = true;
                            } else if (armadoStr.equals("no")) {
                                armadoBool = false;
                            } else {
                                System.out.println("Opción inválida, se mantiene el valor actual.");
                                break;
                            }

                            if (G.actualizarArmado(G.getDni(), armadoBool)) { // DAO
                                G.setArmado(armadoBool); // <- actualizar objeto local
                                System.out.println("Armado actualizado correctamente.");
                            } else {
                                System.out.println("No se pudo actualizar el armado.");
                            }
                            break;
                        case 9:
                            System.out.print("Nuevo turno: ");
                            G.actualizarTurno(G.getDni(), lector.nextLine());
                            break;
                        case 10:
                            System.out.print("Nueva contraseña: ");
                            G.actualizarContrasena(G.getDni(), lector.nextLine());
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                    break;

                case 3:
                    System.out.println("Turno: " + G.getTurno());
                    break;
                case 4:
                    System.out.println("Incidencia registrada.");
                    break;
                case 0:
                    salir = true;
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static void menuCocinero(Cocinero C, Hospital hospital) {
        boolean salir = false;
        while (!salir) {
            System.out.println(SEPARACION);
            System.out.println(
                    "BIENVENIDO: " + C.getNombre() + " " + C.getPrimerApellido() + " " + C.getSegundoApellido());
            System.out.println("\n=== MENÚ COCINERO ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Editar datos");
            System.out.println("3. Ver menú del día");
            System.out.println("4. Registrar comida preparada");
            System.out.println("0. Cerrar sesión");
            System.out.print("Opción: ");

            int opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 1:
                    C.mostrarDatos();
                    break;
                case 2:
                    System.out.println("===== EDITAR DATOS =====");
                    System.out.println("1. Nombre");
                    System.out.println("2. Primer apellido");
                    System.out.println("3. Segundo apellido");
                    System.out.println("4. Dirección");
                    System.out.println("5. Teléfono");
                    System.out.println("6. Email");
                    System.out.println("7. Turno");
                    System.out.println("8. Especialidad");
                    System.out.println("9. Contraseña");
                    System.out.println("0. Volver");
                    int a = lector.nextInt();
                    lector.nextLine();

                    switch (a) {
                        case 1:
                            System.out.print("Nuevo nombre: ");
                            C.actualizarNombre(C.getDni(), lector.nextLine());
                            break;
                        case 2:
                            System.out.print("Nuevo primer apellido: ");
                            C.actualizarPrimerApellido(C.getDni(), lector.nextLine());
                            break;
                        case 3:
                            System.out.print("Nuevo segundo apellido: ");
                            C.actualizarSegundoApellido(C.getDni(), lector.nextLine());
                            break;
                        case 4:
                            System.out.print("Nueva dirección: ");
                            C.actualizarDireccion(C.getDni(), lector.nextLine());
                            break;
                        case 5:
                            System.out.print("Nuevo teléfono: ");
                            C.actualizarTelefono(C.getDni(), lector.nextLine());
                            break;
                        case 6:
                            System.out.print("Nuevo email: ");
                            C.actualizarEmail(C.getDni(), lector.nextLine());
                            break;
                        case 7:
                            System.out.print("Nuevo turno: ");
                            C.actualizarTurno(C.getDni(), lector.nextLine());
                            break;
                        case 8:
                            System.out.print("Nueva especialidad: ");
                            C.actualizarEspecialidad(C.getDni(), lector.nextLine());
                            break;
                        case 9:
                            System.out.print("Nueva contraseña: ");
                            C.actualizarContrasena(C.getDni(), lector.nextLine());
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                    break;

                case 3:
                    System.out.println("Menú del día: Sopa + Segundo");
                    break;
                case 4:
                    System.out.println("Registro guardado!");
                    break;
                case 0:
                    salir = true;
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // ======================== FUNCIONES AUXILIARES ========================
    public static void editarDatosPaciente(Paciente paciente) {
        PacienteDAO pacienteADO = new PacienteDAO(); // para poder llamar los metodos
        System.out.println("\n=== EDITAR DATOS ===");
        System.out.println("1. Dirección");
        System.out.println("2. Teléfono");
        System.out.println("3. Email");
        System.out.println("4. Agregar alergia");
        System.out.println("0. Salir");
        System.out.print("¿Qué deseas editar?: ");

        int opcion = lector.nextInt();
        lector.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Nueva dirección: ");
                String nuevaDireccion = lector.nextLine();
                paciente.setDireccion(nuevaDireccion);
                pacienteADO.actualizarDireccion(paciente.getDni(), nuevaDireccion);
                System.out.println("Dirección actualizada.");
                break;
            case 2:
                System.out.print("Nuevo teléfono: ");
                String nuevoTelefono = lector.nextLine();
                paciente.setTelefono(nuevoTelefono);
                pacienteADO.actualizarTelefono(paciente.getDni(), nuevoTelefono);
                System.out.println("Teléfono actualizado.");
                break;
            case 3:
                System.out.print("Nuevo email: ");
                String nuevoEmail = lector.nextLine();
                paciente.setEmail(nuevoEmail);
                pacienteADO.actualizarEmail(paciente.getDni(), nuevoEmail);
                System.out.println("Email actualizado.");
                break;
            case 4:
                System.out.print("Nueva alergia: ");
                String alergia = lector.nextLine();
                paciente.agregarAlergia(alergia);
                pacienteADO.agregarAlergia(paciente.getDni(), alergia);
                System.out.println("Alergia agregada.");
                break;
            case 0:
                System.out.println("No se edito nada...");
                System.out.println(SEPARACION);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void registrarCita(Paciente paciente, Hospital hospital) {
        System.out.println("\n=== REGISTRAR CITA ===");

        if (hospital.getDoctores().isEmpty()) {
            System.out.println("No hay doctores disponibles.");
            return;
        }

        System.out.println("Doctores disponibles:");
        List<Doctor> doctores = hospital.getDoctores();
        for (int i = 0; i < doctores.size(); i++) {
            Doctor d = doctores.get(i);
            System.out.println((i + 1) + ". Dr. " + d.getNombre() + " " +
                    d.getPrimerApellido() + " - " + d.getEspecialidad());
        }

        System.out.print("Seleccione doctor (número): ");
        int opcionDoctor = lector.nextInt() - 1;
        lector.nextLine();

        if (opcionDoctor < 0 || opcionDoctor >= doctores.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Doctor doctorSeleccionado = doctores.get(opcionDoctor);

        System.out.print("Fecha y hora (YYYY-MM-DD HH:MM): ");
        String fechaHoraStr = lector.nextLine();
        LocalDateTime fechaHora = null;
        try {
            fechaHora = LocalDateTime.parse(fechaHoraStr,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (Exception e) {
            System.out.println("Formato de fecha inválido.");
            return;
        }

        System.out.print("Motivo de la cita: ");
        String motivo = lector.nextLine();

        System.out.print("Consultorio: ");
        String consultorio = lector.nextLine();

        CitaMedica cita = new CitaMedica(fechaHora, motivo, paciente,
                doctorSeleccionado, consultorio);
        paciente.agregarCita(cita);
        doctorSeleccionado.agregarCita(cita);
        doctorSeleccionado.agregarPaciente(paciente);

        System.out.println(" Cita registrada exitosamente!");
    }

    public static void agregarDiagnostico(Doctor doctor, Hospital hospital) {
        System.out.print("\nDNI del paciente: ");
        int dni = lector.nextInt();
        lector.nextLine();

        Paciente paciente = hospital.buscarPaciente(dni);
        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        System.out.print("Descripción del diagnóstico: ");
        String descripcion = lector.nextLine();

        Diagnostico diagnostico = new Diagnostico(descripcion, LocalDate.now(), doctor);
        paciente.getHistorialMedico().agregarDiagnostico(diagnostico);

        System.out.println(" Diagnóstico agregado.");
    }

    public static void agregarTratamiento(Doctor doctor, Hospital hospital) {
        System.out.print("\nDNI del paciente: ");
        int dni = lector.nextInt();
        lector.nextLine();

        Paciente paciente = hospital.buscarPaciente(dni);
        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        System.out.print("Descripción del tratamiento: ");
        String descripcion = lector.nextLine();

        System.out.print("Fecha inicio (YYYY-MM-DD): ");
        LocalDate fechaInicio = LocalDate.parse(lector.nextLine());

        System.out.print("Fecha fin (YYYY-MM-DD): ");
        LocalDate fechaFin = LocalDate.parse(lector.nextLine());

        Tratamiento tratamiento = new Tratamiento(descripcion, fechaInicio,
                fechaFin, doctor);
        paciente.getHistorialMedico().agregarTratamiento(tratamiento);

        System.out.println(" Tratamiento agregado.");
    }

    public static void buscarPacienteEnfermera(Hospital hospital) {
        System.out.print("\nDNI del paciente: ");
        int dni = lector.nextInt();
        lector.nextLine();

        Paciente paciente = hospital.buscarPaciente(dni);
        if (paciente != null) {
            paciente.mostrarDatos();
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    public static void registrarDoctor(Hospital hospital) {
        System.out.println("\n=== REGISTRAR DOCTOR ===");
        System.out.print("Nombres: ");
        String nombre = lector.nextLine();
        System.out.print("Primer apellido: ");
        String apellido1 = lector.nextLine();
        System.out.print("Segundo apellido: ");
        String apellido2 = lector.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = lector.nextLine();
        System.out.print("DNI: ");
        int dni = lector.nextInt();
        lector.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = lector.nextLine();
        System.out.print("Número de licencia (ejemplo: LIC-12345): ");
        String licencia = lector.nextLine();
        System.out.print("Teléfono: ");
        String telefono = lector.nextLine();
        System.out.print("Email: ");
        String email = lector.nextLine();

        Doctor doctor = new Doctor(nombre, apellido1, apellido2, contraseña, dni,
                "", telefono, email, LocalDate.now(), "M",
                especialidad, licencia);
        hospital.agregarDoctor(doctor);
        System.out.println("Doctor registrado exitosamente!");
    }

    public static void registrarEnfermera(Hospital hospital) {
        System.out.println("\n=== REGISTRAR ENFERMERA ===");
        System.out.print("Nombres: ");
        String nombre = lector.nextLine();
        System.out.print("Primer apellido: ");
        String apellido1 = lector.nextLine();
        System.out.print("Segundo apellido: ");
        String apellido2 = lector.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = lector.nextLine();
        System.out.print("DNI: ");
        int dni = lector.nextInt();
        lector.nextLine();
        System.out.print("Turno (Mañana/Tarde/Noche): ");
        String turno = lector.nextLine();
        System.out.print("Teléfono: ");
        String telefono = lector.nextLine();
        System.out.print("Email: ");
        String email = lector.nextLine();

        Enfermera enfermera = new Enfermera(nombre, apellido1, apellido2, contraseña,
                dni, "", telefono, email, LocalDate.now(),
                "F", turno);
        hospital.agregarEnfermera(enfermera);
        System.out.println("Enfermera registrada exitosamente!");
    }

    public static void registrarAdministrador(Hospital hospital) {

        System.out.println("=== REGISTRAR ADMINISTRADOR ===");

        System.out.print("Nombre: ");
        String nombre = lector.nextLine();

        System.out.print("Primer Apellido: ");
        String ap1 = lector.nextLine();

        System.out.print("Segundo Apellido: ");
        String ap2 = lector.nextLine();

        System.out.print("Contraseña: ");
        String contraseña = lector.nextLine();

        System.out.print("DNI: ");
        int dni = lector.nextInt();
        lector.nextLine();

        System.out.print("Dirección: ");
        String direccion = lector.nextLine();

        System.out.print("Teléfono: ");
        String telefono = lector.nextLine();

        System.out.print("Email: ");
        String email = lector.nextLine();

        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNac = LocalDate.parse(lector.nextLine());

        System.out.print("Género: ");
        String genero = lector.nextLine();

        System.out.print("Rol del administrador (Ej: Administrador, Administrador General): ");
        String rol = lector.nextLine();

        // Crear administrador
        Administrador nuevoAdmin = new Administrador(
                nombre,
                ap1,
                ap2,
                contraseña,
                dni,
                direccion,
                telefono,
                email,
                fechaNac,
                genero,
                rol);

        // Agregar al hospital
        hospital.agregarAdministrador(nuevoAdmin);

        System.out.println("Administrador registrado correctamente.");
    }

    public static void registrarPersonalLimpieza(Hospital hospital) {

        System.out.println("=== REGISTRAR PERSONAL DE LIMPIEZA ===");

        System.out.print("Nombre: ");
        String nombre = lector.nextLine();

        System.out.print("Primer Apellido: ");
        String ap1 = lector.nextLine();

        System.out.print("Segundo Apellido: ");
        String ap2 = lector.nextLine();

        System.out.print("Contraseña: ");
        String contraseña = lector.nextLine();

        System.out.print("DNI: ");
        int dni = lector.nextInt();
        lector.nextLine();

        System.out.print("Dirección: ");
        String direccion = lector.nextLine();

        System.out.print("Teléfono: ");
        String telefono = lector.nextLine();

        System.out.print("Email: ");
        String email = lector.nextLine();

        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNac = LocalDate.parse(lector.nextLine());

        System.out.print("Género: ");
        String genero = lector.nextLine();

        System.out.print("Turno (Mañana / Tarde / Noche): ");
        String turno = lector.nextLine();

        System.out.print("Área asignada (Ej: Pasillos, Emergencias, Habitaciones): ");
        String areaAsignada = lector.nextLine();

        // Crear el objeto
        PersonalLimpieza limpieza = new PersonalLimpieza(
                areaAsignada,
                nombre,
                ap1,
                ap2,
                contraseña,
                dni,
                direccion,
                telefono,
                email,
                fechaNac,
                genero,
                turno);

        // Agregar al hospital
        hospital.agregarPersonalLimpieza(limpieza);

        System.out.println("Personal de limpieza registrado correctamente.");
    }

    public static void registrarCocinero(Hospital hospital) {

        System.out.println("\n=== REGISTRAR COCINERO ===");

        System.out.print("Ingrese nombre: ");
        String nombre = lector.nextLine();

        System.out.print("Ingrese primer apellido: ");
        String primerApellido = lector.nextLine();

        System.out.print("Ingrese segundo apellido: ");
        String segundoApellido = lector.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contraseña = lector.nextLine();

        System.out.print("Ingrese DNI: ");
        int dni = Integer.parseInt(lector.nextLine());

        System.out.print("Ingrese dirección: ");
        String direccion = lector.nextLine();

        System.out.print("Ingrese teléfono: ");
        String telefono = lector.nextLine();

        System.out.print("Ingrese email: ");
        String email = lector.nextLine();

        System.out.print("Ingrese fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(lector.nextLine());

        System.out.print("Ingrese género: ");
        String genero = lector.nextLine();

        System.out.print("Ingrese turno (mañana/tarde/noche): ");
        String turno = lector.nextLine();

        System.out.print("Ingrese especialidad del cocinero: ");
        String especialidad = lector.nextLine();

        // Crear objeto Cocinero
        Cocinero cocinero = new Cocinero(
                nombre,
                primerApellido,
                segundoApellido,
                contraseña,
                dni,
                direccion,
                telefono,
                email,
                fechaNacimiento,
                genero,
                turno,
                especialidad);

        // Registrar en el hospital
        hospital.agregarCocinero(cocinero);

        System.out.println("\nCocinero registrado correctamente.");
    }

    public static void registrarGuardiaSeguridad(Hospital hospital) {

        System.out.println("\n=== REGISTRAR GUARDIA DE SEGURIDAD ===");

        System.out.print("Ingrese nombre: ");
        String nombre = lector.nextLine();

        System.out.print("Ingrese primer apellido: ");
        String primerApellido = lector.nextLine();

        System.out.print("Ingrese segundo apellido: ");
        String segundoApellido = lector.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contraseña = lector.nextLine();

        System.out.print("Ingrese DNI: ");
        int dni = Integer.parseInt(lector.nextLine());

        System.out.print("Ingrese dirección: ");
        String direccion = lector.nextLine();

        System.out.print("Ingrese teléfono: ");
        String telefono = lector.nextLine();

        System.out.print("Ingrese email: ");
        String email = lector.nextLine();

        System.out.print("Ingrese fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(lector.nextLine());

        System.out.print("Ingrese género: ");
        String genero = lector.nextLine();

        System.out.print("Ingrese turno (mañana/tarde/noche): ");
        String turno = lector.nextLine();

        System.out.print("Área asignada de vigilancia: ");
        String areaAsignada = lector.nextLine();

        System.out.print("¿Está armado? (si/no): ");
        String armadoInput = lector.nextLine();
        boolean armado = armadoInput.equalsIgnoreCase("si");

        // Crear objeto según tu constructor EXACTO
        GuardiaSeguridad guardia = new GuardiaSeguridad(
                areaAsignada,
                armado,
                nombre,
                primerApellido,
                segundoApellido,
                contraseña,
                dni,
                direccion,
                telefono,
                email,
                fechaNacimiento,
                genero,
                turno);

        // Registrar en el hospital
        hospital.agregarguardiaSeguridad(guardia);

        System.out.println("\nGuardia de Seguridad registrado correctamente.");
    }

    public static void crearDepartamento(Hospital hospital) {
        System.out.print("Nombre del Dpartamento: ");
        String nombreDepa = lector.nextLine();
        System.out.print("Ubicación: ");
        String ubicacionDepa = lector.nextLine();
        Departamento departamento = new Departamento(nombreDepa, ubicacionDepa);
        hospital.agregarDepartamento(departamento);
        System.out.println("Departamento creado exitosamente");
    }

    public static void mostrarEstadisticas(Hospital hospital) {
        System.out.println("\n=== ESTADÍSTICAS DEL HOSPITAL ===");

        PacienteDAO pacienteDAO = new PacienteDAO();
        int totalPacientes = pacienteDAO.contarPacientes();
        System.out.println("Total de pacientes: " + totalPacientes);

        DoctorDAO doctorDAO = new DoctorDAO();
        int totalDoctores = doctorDAO.contarDoctores();
        System.out.println("Total de doctores: " + totalDoctores);

        EnfermeraDAO enfermeraDAO = new EnfermeraDAO();
        int totalEnfermeras = enfermeraDAO.contarEnfermeras();
        System.out.println("Total de enfermeras: " + totalEnfermeras);

        AdministradorDAO adminDAO = new AdministradorDAO(); // para usar su metodo
        int totalAdmins = adminDAO.contarAdministradores();
        System.out.println("Total de Administradores: " + totalAdmins);

        PersonalLimpiezaDAO personalDAO = new PersonalLimpiezaDAO();
        int totalLimpieza = personalDAO.contarPersonalLimpieza();
        System.out.println("Total de trabajadores de Limpieza: " + totalLimpieza);

        GuardiaSeguridadDAO guardiaDAO = new GuardiaSeguridadDAO();
        int totalGuardias = guardiaDAO.contarGuardiaSeguridad();
        System.out.println("Total de Guardias de Seguridad: " + totalGuardias);

        CocineroDAO cocineroDAO = new CocineroDAO();
        int totalCocineros = cocineroDAO.contarCocineros();
        System.out.println("Total de Cocineros: " + totalCocineros);

        DepartamentoDAO depaDAO = new DepartamentoDAO();
        int totalDepartamentos = depaDAO.contarDepartamentos();
        System.out.println("Total de departamentos: " + totalDepartamentos);
        // Más estadísticas aquí...
    }

    public static void registrarUsuario(Hospital hospital, Administrador admin) {
        int opcion;
        boolean validar123 = true;
        do {
            System.out.println(SEPARACION);
            System.out.println("=== REGISTRAR ===");
            System.out.println("1. Doctor");
            System.out.println("2. Enfermera");
            System.out.println("3. Paciente");

            // Solo Administrador General puede ver la opción de registrar a un
            // Administrador
            if (admin.getRolAdministrador().equalsIgnoreCase("Administrador General")) {
                System.out.println("4. Administrador");
            }

            System.out.println("5. Personal de Limpieza");
            System.out.println("6. Cocinero");
            System.out.println("7. Guardia de Seguridad");
            System.out.println("0. Volver");

            System.out.print("Seleccione una opción: ");
            opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {

                case 1:
                    registrarDoctor(hospital);
                    break;

                case 2:
                    registrarEnfermera(hospital);
                    break;

                case 3:
                    registrarPaciente();
                    break;

                case 4:
                    if (admin.getRolAdministrador().equalsIgnoreCase("Administrador General")) {
                        registrarAdministrador(hospital);
                    } else {
                        System.out.println("No tienes permiso para registrar administradores.");
                    }
                    break;

                case 5:
                    registrarPersonalLimpieza(hospital);
                    break;

                case 6:
                    registrarCocinero(hospital);
                    break;

                case 7:
                    registrarGuardiaSeguridad(hospital);
                    break;

                case 0:
                    System.out.println("Volviendo...");
                    validar123 = false;
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (validar123 == true);
    }

    public static void buscarUsuario(Hospital hospital) {
        boolean salir = false;
        while (!salir) {
            System.out.println(SEPARACION);
            System.out.println("=== BUSCAR USUARIO ===");
            System.out.println("1. Doctor");
            System.out.println("2. Enfermera");
            System.out.println("3. Paciente");
            System.out.println("4. Administrador");
            System.out.println("5. Personal de Limpieza");
            System.out.println("6. Cocinero");
            System.out.println("7. Guardia de Seguridad");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            try {
                int opcion = lector.nextInt();
                lector.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el DNI: ");
                        int dni = lector.nextInt();
                        System.out.println("Bucando doctor...");
                        Doctor doctorBuscado = hospital.buscarDoctor(dni);
                        boolean validar = true;
                        do {
                            System.out.println("=== USUARIO ENCONTRADO ===");
                            System.out.println(doctorBuscado.getNombre() + " " + doctorBuscado.getPrimerApellido() + " "
                                    + doctorBuscado.getSegundoApellido());
                            System.out.println("¿Qué desea hacer?");
                            System.out.println("1. Ver información completa");
                            System.out.println("2. Actualizar datos");
                            System.out.println("3. Eliminar usuario");
                            System.out.println("0. Volver");
                            int opcionDesea = lector.nextInt();
                            switch (opcionDesea) {
                                case 1:
                                    doctorBuscado.mostrarDatos();
                                    System.out.println("==============================");
                                    break;
                                case 2:
                                    System.out.println("===== ACTUALIZAR DATOS DEL DOCTOR =====");
                                    System.out.println("1. Nombre");
                                    System.out.println("2. Primer apellido");
                                    System.out.println("3. Segundo apellido");
                                    System.out.println("4. Dirección");
                                    System.out.println("5. Teléfono");
                                    System.out.println("6. Email");
                                    System.out.println("7. Contraseña");
                                    System.out.println("8. Especialidad");
                                    System.out.println("9. Número de licencia");
                                    System.out.println("0. Volver");
                                    System.out.print("Seleccione una opción: ");
                                    int opcionDatoActualizar = lector.nextInt();
                                    lector.nextLine();
                                    switch (opcionDatoActualizar) {

                                        case 1:
                                            // Lógica para actualizar nombre
                                            System.out.print("Nuevo nombre: ");
                                            String nuevoNombre = lector.nextLine();
                                            doctorBuscado.actualizarNombre(dni, nuevoNombre);
                                            System.out.println("Nombre actualizado exitosamente.");
                                            break;

                                        case 2:
                                            // Lógica para actualizar primer apellido
                                            System.out.print("Nuevo primer apellido: ");
                                            String nuevoPrimerApellido = lector.nextLine();
                                            doctorBuscado.actualizarPrimerApellido(dni, nuevoPrimerApellido);
                                            System.out.println("Primer apellido actualizado exitosamente.");
                                            break;

                                        case 3:
                                            // Lógica para actualizar segundo apellido
                                            System.out.print("Nuevo segundo apellido: ");
                                            String nuevoSegundoApellido = lector.nextLine();
                                            doctorBuscado.actualizarSegundoApellido(dni, nuevoSegundoApellido);
                                            System.out.println("Segundo apellido actualizado exitosamente.");
                                            break;

                                        case 4:
                                            // Lógica para actualizar dirección
                                            System.out.print("Nueva dirección: ");
                                            String nuevaDireccion = lector.nextLine();
                                            doctorBuscado.actualizarDireccion(dni, nuevaDireccion);
                                            System.out.println("Dirección actualizada exitosamente.");
                                            break;

                                        case 5:
                                            // Lógica para actualizar teléfono
                                            System.out.print("Nuevo teléfono: ");
                                            String nuevoTelefono = lector.nextLine();
                                            doctorBuscado.actualizarTelefono(dni, nuevoTelefono);
                                            System.out.println("Teléfono actualizado exitosamente.");
                                            break;

                                        case 6:
                                            // Lógica para actualizar email
                                            System.out.print("Nuevo email: ");
                                            String nuevoEmail = lector.nextLine();
                                            doctorBuscado.actualizarEmail(dni, nuevoEmail);
                                            System.out.println("Email actualizado exitosamente.");
                                            break;

                                        case 7:
                                            // Lógica para actualizar contraseña
                                            System.out.print("Nueva contraseña: ");
                                            String nuevaContrasena = lector.nextLine();
                                            doctorBuscado.actualizarContrasena(dni, nuevaContrasena);
                                            System.out.println("Contraseña actualizada exitosamente.");
                                            break;

                                        case 8:
                                            // Lógica para actualizar especialidad
                                            System.out.print("Nueva especialidad: ");
                                            String nuevaEspecialidad = lector.nextLine();
                                            doctorBuscado.actualizarEspecialidad(dni, nuevaEspecialidad);
                                            System.out.println("Especialidad actualizada exitosamente.");
                                            break;

                                        case 9:
                                            // Lógica para actualizar número de licencia
                                            System.out.print("Nuevo número de licencia: ");
                                            String nuevaLicencia = lector.nextLine();
                                            doctorBuscado.actualizarNumeroLicencia(dni, nuevaLicencia);
                                            System.out.println("Número de licencia actualizado exitosamente.");
                                            break;

                                        case 0:
                                            System.out.println("Volviendo...");
                                            break;

                                        default:
                                            System.out.println("Opción inválida.");
                                            break;
                                    }
                                    System.out.println(SEPARACION);
                                    break;
                                case 3:
                                    System.out.println("=== ELIMINAR DOCTOR ===");
                                    doctorBuscado.eliminarPorDni(dni);
                                    break;
                                case 0:
                                    System.out.println("Volviendo...");
                                    validar = false;
                                    break;
                                default:
                                    System.out.println("Opcion inválida.");
                            }
                        } while (validar = true);
                        break;
                    case 2:
                        System.out.print("Ingrese el DNI de la enfermera: ");
                        int dniEnf = lector.nextInt();
                        lector.nextLine();

                        Enfermera enfermeraBuscada = hospital.buscarEnfermera(dniEnf);

                        if (enfermeraBuscada == null) {
                            System.out.println("No se encontró la enfermera.");
                            break;
                        }

                        boolean continuarEnf = true;

                        while (continuarEnf) {
                            System.out.println("=== ENFERMERA ENCONTRADA ===");
                            System.out.println(enfermeraBuscada.getNombre() + " " +
                                    enfermeraBuscada.getPrimerApellido() + " " +
                                    enfermeraBuscada.getSegundoApellido());

                            System.out.println("1. Ver información completa");
                            System.out.println("2. Actualizar datos");
                            System.out.println("3. Eliminar enfermera");
                            System.out.println("0. Volver");
                            int op = lector.nextInt();
                            lector.nextLine();

                            switch (op) {
                                case 1:
                                    enfermeraBuscada.mostrarDatos();
                                    break;

                                case 2:
                                    System.out.println("===== ACTUALIZAR DATOS =====");
                                    System.out.println("1. Nombre");
                                    System.out.println("2. Primer apellido");
                                    System.out.println("3. Segundo apellido");
                                    System.out.println("4. Dirección");
                                    System.out.println("5. Teléfono");
                                    System.out.println("6. Email");
                                    System.out.println("7. Turno");
                                    System.out.println("8. Contraseña");
                                    System.out.println("0. Volver");
                                    int a = lector.nextInt();
                                    lector.nextLine();

                                    switch (a) {
                                        case 1:
                                            System.out.print("Nuevo nombre: ");
                                            enfermeraBuscada.actualizarNombre(dniEnf, lector.nextLine());
                                            break;

                                        case 2:
                                            System.out.print("Nuevo primer apellido: ");
                                            enfermeraBuscada.actualizarPrimerApellido(dniEnf, lector.nextLine());
                                            break;

                                        case 3:
                                            System.out.print("Nuevo segundo apellido: ");
                                            enfermeraBuscada.actualizarSegundoApellido(dniEnf, lector.nextLine());
                                            break;

                                        case 4:
                                            System.out.print("Nueva dirección: ");
                                            enfermeraBuscada.actualizarDireccion(dniEnf, lector.nextLine());
                                            break;

                                        case 5:
                                            System.out.print("Nuevo teléfono: ");
                                            enfermeraBuscada.actualizarTelefono(dniEnf, lector.nextLine());
                                            break;

                                        case 6:
                                            System.out.print("Nuevo email: ");
                                            enfermeraBuscada.actualizarEmail(dniEnf, lector.nextLine());
                                            break;

                                        case 7:
                                            System.out.print("Nuevo turno: ");
                                            enfermeraBuscada.actualizarTurno(dniEnf, lector.nextLine());
                                            break;

                                        case 8:
                                            System.out.print("Nueva contraseña: ");
                                            enfermeraBuscada.actualizarContrasena(dniEnf, lector.nextLine());
                                            break;

                                        case 0:
                                            break;

                                        default:
                                            System.out.println("Opción inválida.");
                                            break;
                                    }
                                    break;

                                case 3:
                                    System.out.println("¿Seguro que deseas eliminar? (s/n)");
                                    if (lector.nextLine().equalsIgnoreCase("s")) {
                                        enfermeraBuscada.eliminarPorDni(dniEnf);
                                        System.out.println("Enfermera eliminada.");
                                        continuarEnf = false;
                                    }
                                    break;

                                case 0:
                                    continuarEnf = false;
                                    break;

                                default:
                                    System.out.println("Opción inválida.");
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el DNI del paciente: ");
                        int dniPac = lector.nextInt();
                        lector.nextLine();

                        Paciente pacienteBuscado = hospital.buscarPaciente(dniPac);

                        if (pacienteBuscado == null) {
                            System.out.println("No se encontró el paciente.");
                            break;
                        }

                        boolean continuarPac = true;

                        while (continuarPac) {
                            System.out.println("=== PACIENTE ENCONTRADO ===");
                            System.out.println(pacienteBuscado.getNombre() + " " +
                                    pacienteBuscado.getPrimerApellido() + " " +
                                    pacienteBuscado.getSegundoApellido());

                            System.out.println("1. Ver información completa");
                            System.out.println("2. Actualizar datos");
                            System.out.println("3. Eliminar paciente");
                            System.out.println("0. Volver");
                            int op = lector.nextInt();
                            lector.nextLine();

                            switch (op) {
                                case 1:
                                    pacienteBuscado.mostrarDatos();
                                    break;

                                case 2:
                                    System.out.println("===== ACTUALIZAR DATOS =====");
                                    System.out.println("1. Nombre");
                                    System.out.println("2. Primer apellido");
                                    System.out.println("3. Segundo apellido");
                                    System.out.println("4. Dirección");
                                    System.out.println("5. Teléfono");
                                    System.out.println("6. Email");
                                    System.out.println("7. Contraseña");
                                    System.out.println("0. Volver");
                                    int a = lector.nextInt();
                                    lector.nextLine();

                                    switch (a) {
                                        case 1:
                                            System.out.print("Nuevo nombre: ");
                                            pacienteBuscado.actualizarNombre(dniPac, lector.nextLine());
                                            break;

                                        case 2:
                                            System.out.print("Nuevo primer apellido: ");
                                            pacienteBuscado.actualizarPrimerApellido(dniPac, lector.nextLine());
                                            break;

                                        case 3:
                                            System.out.print("Nuevo segundo apellido: ");
                                            pacienteBuscado.actualizarSegundoApellido(dniPac, lector.nextLine());
                                            break;

                                        case 4:
                                            System.out.print("Nueva dirección: ");
                                            pacienteBuscado.actualizarDireccion(dniPac, lector.nextLine());
                                            break;

                                        case 5:
                                            System.out.print("Nuevo teléfono: ");
                                            pacienteBuscado.actualizarTelefono(dniPac, lector.nextLine());
                                            break;

                                        case 6:
                                            System.out.print("Nuevo email: ");
                                            pacienteBuscado.actualizarEmail(dniPac, lector.nextLine());
                                            break;

                                        case 7:
                                            System.out.print("Nueva contraseña: ");
                                            pacienteBuscado.actualizarContrasena(dniPac, lector.nextLine());
                                            break;

                                        case 0:
                                            break;

                                        default:
                                            System.out.println("Opción inválida.");
                                    }
                                    break;

                                case 3:
                                    System.out.println("¿Seguro que deseas eliminar? (s/n)");
                                    if (lector.nextLine().equalsIgnoreCase("s")) {
                                        pacienteBuscado.eliminarPorDni(dniPac);
                                        System.out.println("Paciente eliminado.");
                                        continuarPac = false;
                                    }
                                    break;

                                case 0:
                                    continuarPac = false;
                                    break;

                                default:
                                    System.out.println("Opción inválida.");
                            }
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese el DNI del administrador: ");
                        int dniAdmin = lector.nextInt();
                        lector.nextLine();

                        Administrador adminBuscado = hospital.buscarAdministrador(dniAdmin);

                        if (adminBuscado == null) {
                            System.out.println("No se encontró administrador con ese DNI.");
                            break;
                        }

                        boolean continuarAdmin = true;

                        while (continuarAdmin) {
                            System.out.println("=== ADMINISTRADOR ENCONTRADO ===");
                            System.out.println(adminBuscado.getNombre() + " " +
                                    adminBuscado.getPrimerApellido() + " " +
                                    adminBuscado.getSegundoApellido());

                            System.out.println("1. Ver información completa");
                            System.out.println("0. Volver");
                            int op = lector.nextInt();
                            lector.nextLine();

                            switch (op) {
                                case 1:
                                    adminBuscado.mostrarDatos(); // Método que imprime todos los datos del administrador
                                    break;

                                case 0:
                                    continuarAdmin = false;
                                    break;

                                default:
                                    System.out.println("Opción inválida.");
                            }
                        }
                        break;

                    case 5:
                        System.out.print("Ingrese el DNI del personal de limpieza: ");
                        int dniLimp = lector.nextInt();
                        lector.nextLine();

                        PersonalLimpieza limpiezaBuscado = hospital.buscarPersonalLimpieza(dniLimp);

                        if (limpiezaBuscado == null) {
                            System.out.println("No se encontró personal de limpieza con ese DNI.");
                            break;
                        }

                        boolean continuarLimp = true;

                        while (continuarLimp) {
                            System.out.println("=== PERSONAL DE LIMPIEZA ENCONTRADO ===");
                            System.out.println(limpiezaBuscado.getNombre() + " " +
                                    limpiezaBuscado.getPrimerApellido() + " " +
                                    limpiezaBuscado.getSegundoApellido());

                            System.out.println("1. Ver información completa");
                            System.out.println("2. Actualizar datos");
                            System.out.println("3. Eliminar personal de limpieza");
                            System.out.println("0. Volver");
                            int op = lector.nextInt();
                            lector.nextLine();

                            switch (op) {
                                case 1:
                                    limpiezaBuscado.mostrarDatos();
                                    break;

                                case 2:
                                    System.out.println("===== ACTUALIZAR DATOS =====");
                                    System.out.println("1. Nombre");
                                    System.out.println("2. Primer apellido");
                                    System.out.println("3. Segundo apellido");
                                    System.out.println("4. Dirección");
                                    System.out.println("5. Teléfono");
                                    System.out.println("6. Email");
                                    System.out.println("7. Área asignada");
                                    System.out.println("8. Turno");
                                    System.out.println("9. Contraseña");
                                    System.out.println("0. Volver");
                                    int a = lector.nextInt();
                                    lector.nextLine();

                                    switch (a) {
                                        case 1:
                                            System.out.print("Nuevo nombre: ");
                                            limpiezaBuscado.actualizarNombre(dniLimp, lector.nextLine());
                                            break;
                                        case 2:
                                            System.out.print("Nuevo primer apellido: ");
                                            limpiezaBuscado.actualizarPrimerApellido(dniLimp, lector.nextLine());
                                            break;
                                        case 3:
                                            System.out.print("Nuevo segundo apellido: ");
                                            limpiezaBuscado.actualizarSegundoApellido(dniLimp, lector.nextLine());
                                            break;
                                        case 4:
                                            System.out.print("Nueva dirección: ");
                                            limpiezaBuscado.actualizarDireccion(dniLimp, lector.nextLine());
                                            break;
                                        case 5:
                                            System.out.print("Nuevo teléfono: ");
                                            limpiezaBuscado.actualizarTelefono(dniLimp, lector.nextLine());
                                            break;
                                        case 6:
                                            System.out.print("Nuevo email: ");
                                            limpiezaBuscado.actualizarEmail(dniLimp, lector.nextLine());
                                            break;
                                        case 7:
                                            System.out.print("Nueva área asignada: ");
                                            limpiezaBuscado.actualizarAreaAsignada(dniLimp, lector.nextLine());
                                            break;
                                        case 8:
                                            System.out.print("Nuevo turno: ");
                                            limpiezaBuscado.actualizarTurno(dniLimp, lector.nextLine());
                                            break;
                                        case 9:
                                            System.out.print("Nueva contraseña: ");
                                            limpiezaBuscado.actualizarContrasena(dniLimp, lector.nextLine());
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Opción inválida.");
                                    }
                                    break;

                                case 3:
                                    System.out.print("¿Seguro que deseas eliminar? (s/n): ");
                                    if (lector.nextLine().equalsIgnoreCase("s")) {
                                        limpiezaBuscado.eliminarPorDni(dniLimp);
                                        System.out.println("Personal de limpieza eliminado.");
                                        continuarLimp = false;
                                    }
                                    break;

                                case 0:
                                    continuarLimp = false;
                                    break;

                                default:
                                    System.out.println("Opción inválida.");
                            }
                        }
                        break;

                    case 6:
                        System.out.print("Ingrese el DNI del cocinero: ");
                        int dniCocinero = lector.nextInt();
                        lector.nextLine();

                        Cocinero cocineroBuscado = hospital.buscarCocinero(dniCocinero);

                        if (cocineroBuscado == null) {
                            System.out.println("No se encontró cocinero con ese DNI.");
                            break;
                        }

                        boolean continuarCocinero = true;

                        while (continuarCocinero) {
                            System.out.println("=== COCINERO ENCONTRADO ===");
                            System.out.println(cocineroBuscado.getNombre() + " " +
                                    cocineroBuscado.getPrimerApellido() + " " +
                                    cocineroBuscado.getSegundoApellido());

                            System.out.println("1. Ver información completa");
                            System.out.println("2. Actualizar datos");
                            System.out.println("3. Eliminar cocinero");
                            System.out.println("0. Volver");
                            int op = lector.nextInt();
                            lector.nextLine();

                            switch (op) {
                                case 1:
                                    cocineroBuscado.mostrarDatos();
                                    break;

                                case 2:
                                    System.out.println("===== ACTUALIZAR DATOS =====");
                                    System.out.println("1. Nombre");
                                    System.out.println("2. Primer apellido");
                                    System.out.println("3. Segundo apellido");
                                    System.out.println("4. Dirección");
                                    System.out.println("5. Teléfono");
                                    System.out.println("6. Email");
                                    System.out.println("7. Turno");
                                    System.out.println("8. Especialidad");
                                    System.out.println("9. Contraseña");
                                    System.out.println("0. Volver");
                                    int a = lector.nextInt();
                                    lector.nextLine();

                                    switch (a) {
                                        case 1:
                                            System.out.print("Nuevo nombre: ");
                                            cocineroBuscado.actualizarNombre(dniCocinero, lector.nextLine());
                                            break;
                                        case 2:
                                            System.out.print("Nuevo primer apellido: ");
                                            cocineroBuscado.actualizarPrimerApellido(dniCocinero, lector.nextLine());
                                            break;
                                        case 3:
                                            System.out.print("Nuevo segundo apellido: ");
                                            cocineroBuscado.actualizarSegundoApellido(dniCocinero, lector.nextLine());
                                            break;
                                        case 4:
                                            System.out.print("Nueva dirección: ");
                                            cocineroBuscado.actualizarDireccion(dniCocinero, lector.nextLine());
                                            break;
                                        case 5:
                                            System.out.print("Nuevo teléfono: ");
                                            cocineroBuscado.actualizarTelefono(dniCocinero, lector.nextLine());
                                            break;
                                        case 6:
                                            System.out.print("Nuevo email: ");
                                            cocineroBuscado.actualizarEmail(dniCocinero, lector.nextLine());
                                            break;
                                        case 7:
                                            System.out.print("Nuevo turno: ");
                                            cocineroBuscado.actualizarTurno(dniCocinero, lector.nextLine());
                                            break;
                                        case 8:
                                            System.out.print("Nueva especialidad: ");
                                            cocineroBuscado.actualizarEspecialidad(dniCocinero, lector.nextLine());
                                            break;
                                        case 9:
                                            System.out.print("Nueva contraseña: ");
                                            cocineroBuscado.actualizarContrasena(dniCocinero, lector.nextLine());
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Opción inválida.");
                                    }
                                    break;

                                case 3:
                                    System.out.print("¿Seguro que deseas eliminar? (s/n): ");
                                    if (lector.nextLine().equalsIgnoreCase("s")) {
                                        cocineroBuscado.eliminarPorDni(dniCocinero);
                                        System.out.println("Cocinero eliminado.");
                                        continuarCocinero = false;
                                    }
                                    break;

                                case 0:
                                    continuarCocinero = false;
                                    break;

                                default:
                                    System.out.println("Opción inválida.");
                            }
                        }
                        break;

                    case 7:
                        System.out.print("Ingrese el DNI del guardia: ");
                        int dniGuardia = lector.nextInt();
                        lector.nextLine();

                        GuardiaSeguridad guardiaBuscado = hospital.buscarGuardiaSeguridad(dniGuardia);

                        if (guardiaBuscado == null) {
                            System.out.println("No se encontró guardia con ese DNI.");
                            break;
                        }

                        boolean continuarGuardia = true;

                        while (continuarGuardia) {
                            System.out.println("=== GUARDIA DE SEGURIDAD ENCONTRADO ===");
                            System.out.println(guardiaBuscado.getNombre() + " " +
                                    guardiaBuscado.getPrimerApellido() + " " +
                                    guardiaBuscado.getSegundoApellido());

                            System.out.println("1. Ver información completa");
                            System.out.println("2. Actualizar datos");
                            System.out.println("3. Eliminar guardia");
                            System.out.println("0. Volver");
                            System.out.print("Opcion: ");
                            int op = lector.nextInt();
                            lector.nextLine();

                            switch (op) {
                                case 1:
                                    guardiaBuscado.mostrarDatos();
                                    break;

                                case 2:
                                    System.out.println("===== ACTUALIZAR DATOS =====");
                                    System.out.println("1. Nombre");
                                    System.out.println("2. Primer apellido");
                                    System.out.println("3. Segundo apellido");
                                    System.out.println("4. Dirección");
                                    System.out.println("5. Teléfono");
                                    System.out.println("6. Email");
                                    System.out.println("7. Área asignada");
                                    System.out.println("8. Armado");
                                    System.out.println("9. Turno");
                                    System.out.println("10. Contraseña");
                                    System.out.println("0. Volver");
                                    int a = lector.nextInt();
                                    lector.nextLine();

                                    switch (a) {
                                        case 1:
                                            System.out.print("Nuevo nombre: ");
                                            guardiaBuscado.actualizarNombre(dniGuardia, lector.nextLine());
                                            break;
                                        case 2:
                                            System.out.print("Nuevo primer apellido: ");
                                            guardiaBuscado.actualizarPrimerApellido(dniGuardia, lector.nextLine());
                                            break;
                                        case 3:
                                            System.out.print("Nuevo segundo apellido: ");
                                            guardiaBuscado.actualizarSegundoApellido(dniGuardia, lector.nextLine());
                                            break;
                                        case 4:
                                            System.out.print("Nueva dirección: ");
                                            guardiaBuscado.actualizarDireccion(dniGuardia, lector.nextLine());
                                            break;
                                        case 5:
                                            System.out.print("Nuevo teléfono: ");
                                            guardiaBuscado.actualizarTelefono(dniGuardia, lector.nextLine());
                                            break;
                                        case 6:
                                            System.out.print("Nuevo email: ");
                                            guardiaBuscado.actualizarEmail(dniGuardia, lector.nextLine());
                                            break;
                                        case 7:
                                            System.out.print("Nueva área asignada: ");
                                            guardiaBuscado.actualizarAreaAsignada(dniGuardia, lector.nextLine());
                                            break;
                                        case 8:
                                            System.out.print("Armado (sí/no): ");
                                            String armadoStr = lector.nextLine().trim().toLowerCase();

                                            boolean armadoBool;
                                            if (armadoStr.equals("sí") || armadoStr.equals("si")) {
                                                armadoBool = true;
                                            } else if (armadoStr.equals("no")) {
                                                armadoBool = false;
                                            } else {
                                                System.out.println("Opción inválida, se mantiene el valor actual.");
                                                break;
                                            }

                                            if (guardiaBuscado.actualizarArmado(dniGuardia, armadoBool)) { // DAO
                                                guardiaBuscado.setArmado(armadoBool); // <- actualizar objeto local
                                                System.out.println("Armado actualizado correctamente.");
                                            } else {
                                                System.out.println("No se pudo actualizar el armado.");
                                            }
                                            break;
                                        case 9:
                                            System.out.print("Nuevo turno: ");
                                            guardiaBuscado.actualizarTurno(dniGuardia, lector.nextLine());
                                            break;
                                        case 10:
                                            System.out.print("Nueva contraseña: ");
                                            guardiaBuscado.actualizarContrasena(dniGuardia, lector.nextLine());
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Opción inválida.");
                                    }
                                    break;

                                case 3:
                                    System.out.print("¿Seguro que deseas eliminar? (s/n): ");
                                    if (lector.nextLine().equalsIgnoreCase("s")) {
                                        guardiaBuscado.eliminarPorDni(dniGuardia);
                                        System.out.println("Guardia eliminado.");
                                        continuarGuardia = false;
                                    }
                                    break;

                                case 0:
                                    continuarGuardia = false;
                                    break;

                                default:
                                    System.out.println("Opción inválida.");
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Volviendo...");
                        System.out.println("===========================");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                lector.nextLine();
            }
        }
    }

    public static void verRegistros(Hospital hospital) {

        boolean salir = false;
        while (!salir) {
            System.out.println("=== CONSULTAR REGISTROS ===");
            System.out.println("1. Pacientes");
            System.out.println("2. Doctores");
            System.out.println("3. Enfermeras");
            System.out.println("4. Administradores");
            System.out.println("5. Departamentos");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            try {
                int opcion = lector.nextInt();
                lector.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Pacientes:");
                        hospital.mostrarPacientesTotal();
                        System.out.println("===========================");
                        break;
                    case 2:
                        System.out.println("Doctores:");
                        hospital.mostrarDoctoresTotal();
                        System.out.println("===========================");
                        break;
                    case 3:
                        System.out.println("Enfermeras:");
                        hospital.mostrarEnfermerasTotal();
                        System.out.println("===========================");
                        break;
                    case 4:
                        System.out.println("Administradores:");
                        hospital.mostrarAdministradoresTotal();
                        System.out.println("===========================");
                        break;
                    case 5:
                        System.out.println("Departamentos:");
                        hospital.mostrarDepartamentosTotal();
                        System.out.println("===========================");
                        break;
                    case 0:
                        System.out.println("Volviendo...");
                        System.out.println("===========================");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                lector.nextLine();
            }
        }
    }

    // =====================================================================================================================================================================
    // =====================================================================================================================================================================
    // =====================================================================================================================================================================
    // ======================== MAIN ========================
    public static void main(String[] args) {
        Hospital hospital = new Hospital(
                "Hospital San Martín",
                "Av. Los Próceres 145, Arequipa",
                "054-789456",
                "contacto@sanmartin.pe",
                250);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n" + SEPARACION);
            System.out.println(hospital.getNombreHospital());
            System.out.println("=== SISTEMA DE GESTIÓN HOSPITALARIA ===");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse (solo pacientes)");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            try {
                int opcion = lector.nextInt();
                lector.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\n¿Quién eres?");
                        System.out.println("1. Paciente");
                        System.out.println("2. Doctor");
                        System.out.println("3. Enfermera");
                        System.out.println("4. Trabajador");
                        System.out.println("5. Administrador");
                        System.out.print("Opción: ");

                        int tipoUsuario = lector.nextInt();
                        lector.nextLine();

                        switch (tipoUsuario) {
                            case 1:
                                Paciente p = loginPaciente(hospital);
                                if (p != null) {
                                    menuPaciente(p, hospital);
                                }
                                break;
                            case 2:
                                Doctor d = loginDoctor(hospital);
                                if (d != null) {
                                    menuDoctor(d, hospital);
                                }
                                break;
                            case 3:
                                Enfermera e = loginEnfermera(hospital);
                                if (e != null) {
                                    menuEnfermera(e, hospital);
                                }
                                break;
                            case 4:
                                PersonalHospital perH = loginPersonalHospital(hospital);
                                if (perH != null) {

                                    if (perH instanceof PersonalLimpieza)
                                        menuLimpieza((PersonalLimpieza) perH, hospital);

                                    else if (perH instanceof GuardiaSeguridad)
                                        menuGuardia((GuardiaSeguridad) perH, hospital);

                                    else if (perH instanceof Cocinero)
                                        menuCocinero((Cocinero) perH, hospital);
                                }
                                break;
                            case 5:
                                Administrador a = loginAdministrador(hospital);
                                if (a != null)
                                    menuAdministrador(a, hospital);
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }
                        break;

                    case 2:
                        Paciente nuevoPaciente = registrarPaciente();
                        hospital.agregarPaciente(nuevoPaciente);
                        System.out.println("Registro exitoso! Ahora puedes iniciar sesión.");
                        break;

                    case 3:
                        System.out.println("Saliendo del sistema...");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                lector.nextLine();
            }

            System.out.println(SEPARACION);
        }

        lector.close();
        System.out.println("\n¡Hasta luego!");
    }
}
