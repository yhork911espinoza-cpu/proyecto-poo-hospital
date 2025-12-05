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
            System.out.println("2. Ver mis citas");
            System.out.println("3. Ver mis pacientes");
            System.out.println("4. Agregar diagnóstico");
            System.out.println("5. Agregar tratamiento");
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
                        doctor.mostrarCitas();
                        break;
                    case 3:
                        doctor.mostrarPacientes();
                        break;
                    case 4:
                        agregarDiagnostico(doctor, hospital);
                        break;
                    case 5:
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
            System.out.println("2. Ver mis pacientes");
            System.out.println("3. Buscar paciente");
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
                        enfermera.mostrarPacientes();
                        break;
                    case 3:
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
            System.out.println("2. Ver estadísticas");
            System.out.println("3. Registrar doctor");
            System.out.println("4. Registrar enfermera");
            System.out.println("5. Crear departamento");
            System.out.println("6. Ver registros");
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
                        mostrarEstadisticas(hospital);
                        break;
                    case 3:
                        registrarDoctor(hospital);
                        break;
                    case 4:
                        registrarEnfermera(hospital);
                        break;
                    case 5:
                        crearDepartamento(hospital);
                        break;
                    case 6:
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
            System.out.println("2. Ver área asignada");
            System.out.println("3. Registrar limpieza realizada");
            System.out.println("0. Cerrar sesión");
            System.out.print("Opción: ");

            int opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 1:
                    L.mostrarDatos();
                    break;
                case 2:
                    System.out.println("Área asignada: " + L.getAreaAsignada());
                    break;
                case 3:
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
            System.out.println("2. Ver turno");
            System.out.println("3. Registrar incidencia");
            System.out.println("0. Cerrar sesión");
            System.out.print("Opción: ");

            int opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 1:
                    G.mostrarDatos();
                    break;
                case 2:
                    System.out.println("Turno: " + G.getTurno());
                    break;
                case 3:
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
            System.out.println("2. Ver menú del día");
            System.out.println("3. Registrar comida preparada");
            System.out.println("0. Cerrar sesión");
            System.out.print("Opción: ");

            int opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 1:
                    C.mostrarDatos();
                    break;
                case 2:
                    System.out.println("Menú del día: Sopa + Segundo");
                    break;
                case 3:
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
        PacienteADO pacienteADO = new PacienteADO(); // para poder llamar los metodos
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

        PacienteADO pacienteADO = new PacienteADO();
        int totalPacientes = pacienteADO.contarPacientes();
        System.out.println("Total de pacientes: " + totalPacientes);

        DoctorADO doctorADO = new DoctorADO();
        int totalDoctores = doctorADO.contarDoctores();
        System.out.println("Total de doctores: " + totalDoctores);

        EnfermeraADO enfermeraADO = new EnfermeraADO();
        int totalEnfermeras = enfermeraADO.contarEnfermeras();
        System.out.println("Total de enfermeras: " + totalEnfermeras);

        AdministradorADO adminDAO = new AdministradorADO(); // para usar su metodo
        int totalAdmins = adminDAO.contarAdministradores();
        System.out.println("Total de Administradores: " + totalAdmins);

        System.out.println("Total de departamentos: " + hospital.getDepartamentos().size());
        // Más estadísticas aquí...
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
        // =========================================================================================================================================

        Cocinero cocinero1 = new Cocinero(
                "Paolo", // nombre
                "Coaquira", // primerApellido
                "Anccori", // segundoApellido
                "pao20505", // contraseña
                75554491, // DNI
                "Av. Lima 123", // dirección
                "987654321", // teléfono
                "cocinero@hospital.com", // email
                LocalDate.of(1990, 5, 20), // fecha nacimiento
                "Masculino", // género
                "Mañana", // turno
                "Comida Criolla" // especialidad
        );
        hospital.agregarCocinero(cocinero1);

        GuardiaSeguridad guardia1 = new GuardiaSeguridad(
                "Puerta Principal", // areaAsignada
                true, // armado
                "Paolo", // nombre
                "Coaquira", // primerApellido
                "Anccori", // segundoApellido
                "pao20505", // contraseña
                75554491, // DNI
                "Av. Cusco 456", // dirección
                "912345678", // teléfono
                "guardia@hospital.com", // email
                LocalDate.of(1985, 3, 14), // fecha nacimiento
                "Masculino", // género
                "Noche" // turno
        );
        hospital.agregarguardiaSeguridad(guardia1);

        PersonalLimpieza limpieza1 = new PersonalLimpieza(
                "Piso 2", // areaAsignada
                "Paolo", // nombre
                "Coaquira", // primerApellido
                "Anccori", // segundoApellido
                "pao20505", // contraseña
                75554491, // DNI
                "Av. Arequipa 789", // dirección
                "999222111", // teléfono
                "limpieza@hospital.com", // email
                LocalDate.of(1995, 11, 2), // fecha nacimiento
                "Femenino", // genero
                "Tarde" // turno
        );
        hospital.agregarPersonalLimpieza(limpieza1);

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
