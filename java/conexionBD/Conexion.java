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

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USUARIO = "root";
    private static String PASSWORD = "";
    private static String SCHEMA = "lotequen";
    private static String URL = "jdbc:mysql://localhost:3306/" + SCHEMA;

    // Conexion local
//    public static Connection conectar() {
    static {
        try {
            Class.forName(DRIVER);
//            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
//                    return cn;
        } catch (ClassNotFoundException e) {
//        } catch (SQLException e){
            System.out.println("Error en conexión local " + e);
//            System.out.println("Error en conexión local " + e);
        }
//        return (null);
//    }

    }
//}

    public Connection getConection() {

        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            /*JOptionPane.showMessageDialog(null, "Conexión exitosa");
            lo utilicé para entender visulamente el estado de la conexión.*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en conexión " + e);
        }
        return con;
    }
}
