import java.sql.Connection; //es una clase/interfaz que representa una conexión viva entre tu programa Java y la base de datos SQL Server.
import java.sql.PreparedStatement; //es una clase que permite ejecutar consultas SQL seguras, especialmente con parámetros.
import java.sql.SQLException; //es la excepción que Java lanza cuando ocurre un error con la base de datos.
import java.time.LocalDate;
import java.util.Scanner;

public class PacienteInsertar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== REGISTRO DE PACIENTE ===");

        System.out.print("DNI: ");
        int dni = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Primer Apellido: ");
        String apellido1 = sc.nextLine();

        System.out.print("Segundo Apellido: ");
        String apellido2 = sc.nextLine();

        System.out.print("Contraseña: ");
        String contraseña = sc.nextLine();

        System.out.print("Fecha de nacimiento (yyyy-mm-dd): ");
        LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine());

        System.out.print("Género: ");
        String genero = sc.nextLine();

        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();


        String sql = "INSERT INTO Paciente (dni, nombre, apellido1, apellido2, contraseña, fechaNacimiento, genero, direccion, telefono, email) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionSQL.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, dni);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido1);
            stmt.setString(4, apellido2);
            stmt.setString(5, contraseña);
            stmt.setDate(6, java.sql.Date.valueOf(fechaNacimiento));
            stmt.setString(7, genero);
            stmt.setString(8, direccion);
            stmt.setString(9, telefono);
            stmt.setString(10, email);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Paciente registrado correctamente");
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
}
