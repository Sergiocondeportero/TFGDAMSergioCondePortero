package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    // Cambia la URL de conexión según el puerto y la base de datos
    private static final String URL = "jdbc:mysql://127.0.0.1:3307/inventario";  // Cambiar al puerto 3307
    private static final String USER = "root";  // El nombre de usuario es 'root'
    private static final String PASSWORD = "";  // El password está vacío según tu configuración

    // Método para establecer la conexión
    public Connection conectar() {
        Connection con = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establecer la conexión con la base de datos
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return con;
    }
}
