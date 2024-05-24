/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoyo;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ariel
 */
public class ClickSelect {

    
    
    //Click sobre la tabla de tierras
    public void SeleccionarDatos() {
        
        JTable tablaTierra, id, desCatastro, nombre, cantParcela;

        try {
            int fila = tablaTierra.getSelectedRow();

            if (fila >= 0) {
                id.setText(tablaTierra.getValueAt(fila, 0).toString());
                desCatastro.setText(tablaTierra.getValueAt(fila, 1).toString());
                nombre.setText(tablaTierra.getValueAt(fila, 2).toString());
                cantParcela.setText(tablaTierra.getValueAt(fila, 3).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada: Tabla de Tierras");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección: Tabla de Tierras " + e);

        }
    }

}
