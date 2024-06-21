/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel
 */
public class Conexion {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static String USUARIO = "root";
    private static String PASSWORD = "";
    private static final String SCHEMA = "lotequen";
    private static String URL = "jdbc:mysql://localhost:3306/" + SCHEMA;


    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Error en conexión local " + e);
        }
    }
    
    public Connection getConection() {

        Connection con = null;
        
        try {
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            /*JOptionPane.showMessageDialog(null, "Conexión exitosa");
            lo utilicé para entender visulamente el estado de la conexión.*/
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en conexión " + e);
        }
        
        return con;
        
    }
    
}
