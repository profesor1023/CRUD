import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {

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
    
    
    
    
    public static void insertarProfesor(String nombre, String apellido, String materia) {
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            // Obtener la conexión
            conexion = obtenerConexion();

            // Definir la consulta SQL para la inserción
            String consulta = "INSERT INTO profesor (ID, Nombre, Materia) VALUES (?, ?, ?)";
            
            // Preparar la declaración
            statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, materia);

            // Ejecutar la inserción
            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Registro insertado correctamente");
            } else {
                System.out.println("No se pudo insertar el registro");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión y la declaración al finalizar
            cerrarConexion(conexion);
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
