package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://127.0.0.1:3307/inventario";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection conectar() {
        Connection con = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return con;
    }
}
