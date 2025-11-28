import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("✓ Inicio de sesión exitoso!");
            return paciente;
        } else {
            System.out.println("✗ DNI o contraseña incorrectos.");
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
            System.out.println("✓ Inicio de sesión exitoso!");
            return doctor;
        } else {
            System.out.println("✗ DNI o contraseña incorrectos.");
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
            System.out.println("✓ Inicio de sesión exitoso!");
            return enfermera;
        } else {
            System.out.println("✗ DNI o contraseña incorrectos.");
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
            System.out.println("✓ Inicio de sesión exitoso!");
            return admin;
        } else {
            System.out.println("✗ DNI o contraseña incorrectos.");
            return null;
        }
    }

    // ======================== MENÚS DE USUARIO ========================
    public static void menuPaciente(Paciente paciente, Hospital hospital) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n" + SEPARACION);
            System.out.println("BIENVENIDO: " + paciente.getNombre() + " " +
                    paciente.getPrimerApellido());
                    // ========================================================
                    // ================ paciente ==============================
            System.out.println("=== MENÚ PACIENTE ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Editar mis datos");
            System.out.println("3. Registrar cita médica");
            System.out.println("4. Ver mis citas");
            System.out.println("5. Ver mi historial médico");
            System.out.println("6. Cerrar sesión");
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
                    case 6:
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
                    doctor.getPrimerApellido());
            System.out.println("=== MENÚ DOCTOR ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Ver mis citas");
            System.out.println("3. Ver mis pacientes");
            System.out.println("4. Agregar diagnóstico");
            System.out.println("5. Agregar tratamiento");
            System.out.println("6. Cerrar sesión");
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
                    case 6:
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
            System.out.println("4. Cerrar sesión");
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
                    case 4:
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
                    admin.getPrimerApellido());
            System.out.println("=== MENÚ ADMINISTRADOR ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Registrar doctor");
            System.out.println("3. Registrar enfermera");
            System.out.println("4. Ver estadísticas");
            System.out.println("5. Cerrar sesión");
            System.out.print("Opción: ");

            try {
                int opcion = lector.nextInt();
                lector.nextLine();

                switch (opcion) {
                    case 1:
                        admin.mostrarDatos();
                        break;
                    case 2:
                        registrarDoctor(hospital);
                        break;
                    case 3:
                        registrarEnfermera(hospital);
                        break;
                    case 4:
                        mostrarEstadisticas(hospital);
                        break;
                    case 5:
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

    // ======================== FUNCIONES AUXILIARES ========================
    public static void editarDatosPaciente(Paciente paciente) {
        System.out.println("\n=== EDITAR DATOS ===");
        System.out.println("1. Dirección");
        System.out.println("2. Teléfono");
        System.out.println("3. Email");
        System.out.println("4. Agregar alergia");
        System.out.print("¿Qué deseas editar?: ");

        int opcion = lector.nextInt();
        lector.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Nueva dirección: ");
                paciente.setDireccion(lector.nextLine());
                System.out.println("✓ Dirección actualizada.");
                break;
            case 2:
                System.out.print("Nuevo teléfono: ");
                paciente.setTelefono(lector.nextLine());
                System.out.println("✓ Teléfono actualizado.");
                break;
            case 3:
                System.out.print("Nuevo email: ");
                paciente.setEmail(lector.nextLine());
                System.out.println("✓ Email actualizado.");
                break;
            case 4:
                System.out.print("Nueva alergia: ");
                paciente.agregarAlergia(lector.nextLine());
                System.out.println("✓ Alergia agregada.");
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

        System.out.println("✓ Cita registrada exitosamente!");
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

        System.out.println("✓ Diagnóstico agregado.");
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

        System.out.println("✓ Tratamiento agregado.");
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
        System.out.print("Número de licencia: ");
        String licencia = lector.nextLine();
        System.out.print("Teléfono: ");
        String telefono = lector.nextLine();
        System.out.print("Email: ");
        String email = lector.nextLine();

        Doctor doctor = new Doctor(nombre, apellido1, apellido2, contraseña, dni,
                "", telefono, email, LocalDate.now(), "M",
                especialidad, licencia);
        hospital.agregarDoctor(doctor);
        System.out.println("✓ Doctor registrado exitosamente!");
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
        System.out.println("✓ Enfermera registrada exitosamente!");
    }

    public static void mostrarEstadisticas(Hospital hospital) {
        System.out.println("\n=== ESTADÍSTICAS DEL HOSPITAL ===");
        System.out.println("Total de pacientes: " + hospital.getPacientes().size());
        System.out.println("Total de doctores: " + hospital.getDoctores().size());
        System.out.println("Total de Administradores: " + hospital.getAdministradores().size());
        // Más estadísticas aquí...
    }

    // ======================== MAIN ========================
    public static void main(String[] args) {
        Hospital hospital = new Hospital(
                "Hospital San Martín",
                "Av. Los Próceres 145, Arequipa",
                "054-789456",
                "contacto@sanmartin.pe",
                250);

        // Datos de prueba
        Administrador admin = new Administrador("Paolo Josue", "Coaquira", "Anccori", "pao20505",
                75554491, "", "987654321",
                "admin@hospital.pe", LocalDate.of(1980, 5, 15),
                "M", "Administrador General");
        hospital.agregarAdministrador(admin);

        Administrador admin1 = new Administrador("Jhork Antony", "Espinoza", "Quintana", "kanox123",
                76724541, "", "901699054",
                "admin@hospital.pe", LocalDate.of(1980, 5, 15),
                "M", "Administrador General");
        hospital.agregarAdministrador(admin1);

        Doctor doctor1 = new Doctor("María", "García", "Sánchez", "doc123", 87654321,
                "", "987123456", "mgarcia@hospital.pe",
                LocalDate.of(1985, 8, 20), "F", "Cardiología", "LIC-12345");
        hospital.agregarDoctor(doctor1);

        Doctor doctor2 = new Doctor("Paolo", "Coaquira", "Anccori", "pao20505", 75554491,
                "", "987123456", "coaquiraan@hospital.pe",
                LocalDate.of(1985, 8, 20), "F", "Cardiología", "LIC-12345");
        hospital.agregarDoctor(doctor2);

        Enfermera enfermera1 = new Enfermera("Ana", "Torres", "Ruiz", "enf123",
                45678912, "", "987789456",
                "atorres@hospital.pe",
                LocalDate.of(1990, 3, 10), "F", "Mañana");
        hospital.agregarEnfermera(enfermera1);

        Enfermera enfermera2 = new Enfermera("Paolo", "Coaquira", "Anccori", "pao20505",
                75554491, "Psj Sna Lima", "9377319442",
                "atorres@hospital.pe",
                LocalDate.of(1990, 3, 10), "F", "Mañana");
        hospital.agregarEnfermera(enfermera2);

        // *********************************Pacientes de ejemplo***************** */
        Paciente p1 = new Paciente("Carlos", "Gómez", "Rivas", "pass123", 12345678,
                "Av. Siempre Viva 123", "987654321", "carlos@gmail.com",
                LocalDate.parse("1990-05-12"), "Masculino",
                List.of("Polen", "Penicilina"));
                hospital.agregarPaciente(p1);

        Paciente p2 = new Paciente("Paolo", "Coaquira", "Anccori", "pao20505", 75554481,
                "Calle Lima 450", "912345678", "paocoaquira@gmail.com",
                LocalDate.parse("1985-10-30"), "Femenino",
                List.of());
                hospital.agregarPaciente(p2);

        Paciente p3 = new Paciente("José", "Pérez", "Mamani", "jperez11", 44556677,
                "Jr. Las Flores 234", "956789123", "josep@hotmail.com",
                LocalDate.parse("2000-03-22"), "Masculino",
                List.of("Maní"));
                hospital.agregarPaciente(p3);

        Paciente p4 = new Paciente("Lucía", "Quispe", "Torres", "lucy88", 11223344,
                "Urb. Santa Rosa Mz C", "998877665", "lucia@outlook.com",
                LocalDate.parse("1998-01-10"), "Femenino",
                List.of());
                hospital.agregarPaciente(p4);

        Paciente p5 = new Paciente("Miguel", "Ramos", "Soto", "miguel33", 22334455,
                "Calle Arequipa 789", "945612378", "miguel@gmail.com",
                LocalDate.parse("2002-07-18"), "Masculino",
                List.of("Gluten"));
                hospital.agregarPaciente(p5);

        Paciente p6 = new Paciente("Andrea", "Valdez", "Chavez", "andreaXY", 33445566,
                "Av. Dolores 432", "934567812", "andrea@gmail.com",
                LocalDate.parse("1996-09-14"), "Femenino",
                List.of("Lácteos"));
                hospital.agregarPaciente(p6);

        Paciente p7 = new Paciente("Luis", "Huaraca", "Cruz", "luis321", 55667788,
                "Av. Kennedy 303", "987321654", "lhuaraca@yahoo.com",
                LocalDate.parse("1993-12-01"), "Masculino",
                List.of());
                hospital.agregarPaciente(p7);

        Paciente p8 = new Paciente("Sofía", "Mendoza", "Paredes", "sofipass", 66778899,
                "Jr. Progreso 999", "923456781", "sofia@gmail.com",
                LocalDate.parse("2001-04-25"), "Femenino",
                List.of("Polen", "Mariscos"));
                hospital.agregarPaciente(p8);

        Paciente p9 = new Paciente("Ricardo", "Loayza", "Calle", "ricky22", 77889900,
                "Calle Mercaderes 514", "987555444", "ricardo@hotmail.com",
                LocalDate.parse("1994-06-08"), "Masculino",
                List.of());
                hospital.agregarPaciente(p9);

        Paciente p10 = new Paciente("Valeria", "Suárez", "Nina", "vale007", 88990011,
                "Urb. Los Olivos B12", "912987654", "valeria@gmail.com",
                LocalDate.parse("1999-02-19"), "Femenino",
                List.of("Polvo", "Aspirina"));
                hospital.agregarPaciente(p10);

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
                        System.out.println("4. Administrador");
                        System.out.print("Opción: ");

                        int tipoUsuario = lector.nextInt();
                        lector.nextLine();

                        switch (tipoUsuario) {
                            case 1:
                                Paciente p = loginPaciente(hospital);
                                if (p != null)
                                    menuPaciente(p, hospital);
                                break;
                            case 2:
                                Doctor d = loginDoctor(hospital);
                                if (d != null)
                                    menuDoctor(d, hospital);
                                break;
                            case 3:
                                Enfermera e = loginEnfermera(hospital);
                                if (e != null)
                                    menuEnfermera(e, hospital);
                                break;
                            case 4:
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
                        System.out.println("✓ Registro exitoso! Ahora puedes iniciar sesión.");
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
