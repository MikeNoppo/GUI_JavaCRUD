package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_connection {

    public static Connection getConnection() {
        Connection conn = null;
        try {
 
            String url = "jdbc:mysql://localhost:3306/javagui"; 
            String user = "root"; 
            String password = ""; 

            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {

            System.err.println("Koneksi ke database gagal: " + e.getMessage());
        }
        return conn; 
    }
}
