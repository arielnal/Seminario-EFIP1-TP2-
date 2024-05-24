/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoyo;

import conexionBD.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ariel
 */
public class Tablas {
    
    //crar las tablas de Tierras
    public static JTable Mostrar() {

        Vector tablaTierra = new Vector();
        tablaTierra.addElement("ID");
        tablaTierra.addElement("Parcela");
        tablaTierra.addElement("Catastro");
        tablaTierra.addElement("Nombre");
        
        //this.jTable1 = tablaTierra;
        JTable mdlTabla = new JTable((TableModel) tablaTierra);

        Conexion cn = new Conexion();
        String consulta = "";
        DefaultTableModel modelo = new DefaultTableModel();
        String[] datosConsulta = new String[4];
        Statement st;

        //ordeno tabla
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
/*        tablaTierra.setRowSorter(OrdenarTabla);

       //completo la tabla con los encabezados
        modelo.addColumn("ID");
        modelo.addColumn("Parcela");
        modelo.addColumn("Catastro");
        modelo.addColumn("Nombre");

        //lleno la tabla con el modelo creado
        tablaTierra.setModel(modelo);
*/
        consulta = "select * from tierra;";

        try {
            st = cn.getConection().createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                datosConsulta[0] = rs.getString(1);
                datosConsulta[1] = rs.getString(2);
                datosConsulta[2] = rs.getString(3);
                datosConsulta[3] = rs.getString(4);

                modelo.addRow(datosConsulta);
            }
           tablaTierra.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pueden mostrar registros: Tabla de Tierras");
        }
        return mdlTabla;

    }    
    
}
