import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {

    private static final String URL =
            "jdbc:sqlserver://192.168.1.3:1433;databaseName=HospitalDB;encrypt=false;";
    private static final String USER = "sa";
    private static final String PASS = "paolo2005";

    public static Connection getConexion() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a SQL Server");
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
