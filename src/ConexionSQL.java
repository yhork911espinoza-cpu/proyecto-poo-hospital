import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=HospitalDB;encrypt=false;";
    private static final String USER = "sa";
    private static final String PASS = "paolo2005";

    public static Connection getConexion() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            return conn;
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        getConexion();
    }
}
