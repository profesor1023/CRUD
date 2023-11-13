import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    public static Connection obtenerConexion() {
        Connection conexion = null;

        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/clasemiercoles302";
            String usuario = "root";
            String contraseña = "";
            conexion = DriverManager.getConnection(url, usuario, contraseña);

            if (conexion != null) {
                System.out.println("¡Conexión exitosa!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conexion;
    }

    public static void cerrarConexion(Connection conexion) {
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection conexion = obtenerConexion();

        // Realiza las operaciones de base de datos aquí, si es necesario

        cerrarConexion(conexion);
    }
}
