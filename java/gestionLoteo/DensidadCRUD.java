/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestionLoteo;

import conexionBD.Conexion;
import inicioMain.seminarioEFIP1.MenuJF;
import inicioMain.seminarioEFIP1.Lotequen;
import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ariel
 */
public class DensidadCRUD extends javax.swing.JFrame {

    static String acceso;
    
    public DensidadCRUD() {
        initComponents();
        setTitle("Densidad " + Lotequen.user);
        jLabel1.setText("Densidad");
        jLabel6.setText("Acceso " + Lotequen.user);        
        indiceJT.setEnabled(false);
        this.setLocationRelativeTo(null);
        MostrarLotes(jTable1);
     }


    public void SeleccionarDatos(JTable tablaDensidad, JTextField id, JTextField denom,
            JTextField valor, JTextField aAlta) {

        try {
            int fila = tablaDensidad.getSelectedRow();

            if (fila >= 0) {
                id.setText(tablaDensidad.getValueAt(fila, 0).toString());
                denom.setText(tablaDensidad.getValueAt(fila, 1).toString());
                valor.setText(tablaDensidad.getValueAt(fila, 2).toString());
                aAlta.setText(tablaDensidad.getValueAt(fila, 3).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada: Tabla de Densidad");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección: Tabla de Densidad " + e);

        }
    }

    public void MostrarLotes(JTable tablaDensidad) {

        this.jTable1 = tablaDensidad;

        Conexion cn = new Conexion();
        String consulta = "";
        DefaultTableModel modelo = new DefaultTableModel();
        String[] datosConsulta = new String[4];
        Statement st;

        //ordeno tabla
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        tablaDensidad.setRowSorter(OrdenarTabla);

        //completo la tabla conlos encabezados
        modelo.addColumn("ID");
        modelo.addColumn("Denominación");
        modelo.addColumn("Valor");
        modelo.addColumn("Año Alta");

        //lleno la tabla con el modelo creado
        tablaDensidad.setModel(modelo);

        consulta = "select * from densidad;";

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
            tablaDensidad.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pueden mostrar registros: Tabla de Densidad");
        }

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        aAltaJT = new javax.swing.JTextField();
        valIndJT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        denoJT = new javax.swing.JTextField();
        indiceJT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Valor Individual:");

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Crear Registro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel4.setText("Año de Alta:");

        jLabel5.setText("ID");

        jLabel2.setText("Denominación:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(denoJT, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(aAltaJT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(valIndJT, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(indiceJT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(97, 97, 97)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(denoJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valIndJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aAltaJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addGap(11, 11, 11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(indiceJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int indiceInt;

        indiceInt = Integer.parseInt(indiceJT.getText().trim());

        try {
            Conexion cx = new Conexion();

            String delete = "delete from densidad where id_densidad = ?;";
            CallableStatement cs = cx.getConection().prepareCall(delete);

            cs.setInt(1, indiceInt);
            cs.execute();

            LimpiarCasilleros();
            MostrarLotes(jTable1);
            cs.close();
            JOptionPane.showMessageDialog(null, "Fila eliminada!");
        } catch (SQLException e) {
            System.err.println("Error en la eliminación de la densidad." + e);
            JOptionPane.showMessageDialog(null, "Error, contacte al administrador (densidad) !");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String denomS;
        int aAltaI, indiceInt;
        double valorD;

        String csParcela, noTierra, catastro;
        int parcela;

        indiceInt = Integer.parseInt(indiceJT.getText().trim());
        denomS = denoJT.getText().trim();
        valorD = Double.parseDouble(valIndJT.getText().trim());
        aAltaI = Integer.parseInt(aAltaJT.getText().trim());

        try {
            Conexion cx = new Conexion();
            String update = "update densidad set denominación = ?, valor = ?,"
            + " año_alta = ? where id_densidad = ?;";
            CallableStatement cs = cx.getConection().prepareCall(update);

            cs.setString(1, denomS);
            cs.setDouble(2, valorD);
            cs.setInt(3, aAltaI);
            cs.setInt(4, indiceInt);
            cs.execute();

            LimpiarCasilleros();
            MostrarLotes(jTable1);
            cs.close();
            JOptionPane.showMessageDialog(null, "Actualización exitosa!");
        } catch (SQLException e) {
            System.err.println("Error en la modificación del densidad." + e);
            JOptionPane.showMessageDialog(null, "Error, contacte al administrador (densidad) !");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //es necesario convertir el textfield a string, para guardarlo como int.
        String denomS, valorS, aAltaS;
        int aAltaI;
        double valorD;
        int validacion = 0;

        denomS = denoJT.getText().trim();
        valorS = valIndJT.getText().trim();
        aAltaS = aAltaJT.getText().trim();

        // valida que los casilleros no estén vacíos
        if (denomS.equals("")) {
            denoJT.setBackground(Color.red);
            validacion++;
        }
        if (valorS.equals("")) {
            valIndJT.setBackground(Color.red);
            validacion++;
        }
        if (aAltaS.equals("")) {
            aAltaJT.setBackground(Color.red);
            validacion++;
        }
        //valida si ya fue registrada la tierra, nuevamente si escribo esto para cada clase, no llegaría con los tiempos.
        try {
            Conexion con = new Conexion();
            Statement st = con.getConection().createStatement();
            String consulta = "select denominación from densidad where denominación = '"
            + denomS + "';";
            ResultSet rs = st.executeQuery(consulta);

            if (rs.next()) {
                String nombre = rs.getString("denominación");
                if (nombre.equalsIgnoreCase(denomS)) {
                    denoJT.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "La denominación no se encuantra disponible");
                }
            } else {
                st.close();
                if (validacion == 0) {
                    //evita errores al validar datos
                    aAltaI = Integer.parseInt(aAltaS);
                    valorD = Double.parseDouble(valorS);
                    //en indice respecto porcentaje de inicial y del tiempo
                    try {
                        Conexion cx = new Conexion();
                        String insert = "insert into densidad (denominación, valor, año_alta) values "
                        + "(?,?,?);";
                        CallableStatement cs = cx.getConection().prepareCall(insert);

                        cs.setString(1, denomS);
                        cs.setDouble(2, valorD);
                        cs.setInt(3, aAltaI);
                        cs.execute();
                        LimpiarCasilleros();
                        MostrarLotes(jTable1);
                        cs.close();
                        JOptionPane.showMessageDialog(null, "Registro exitoso!");
                    } catch (SQLException e) {/**/
                        System.err.println("Error en el registro de densidad." + e);
                        JOptionPane.showMessageDialog(null, "Error, contacte al administrador (densidad) !");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los cmapos");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error en validar denominación " + e);
            JOptionPane.showMessageDialog(null, "Error al comparar denominaciones, comuniquese con su administrador");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuJF menu = new MenuJF();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int filas;

        int seleccion = jTable1.getSelectedRow();
        denoJT.setText(jTable1.getValueAt(seleccion, 1).toString());
        valIndJT.setText(jTable1.getValueAt(seleccion, 2).toString());
        aAltaJT.setText(jTable1.getValueAt(seleccion, 3).toString());
        indiceJT.setText(jTable1.getValueAt(seleccion, 0).toString());
        filas = seleccion;
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DensidadCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DensidadCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DensidadCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DensidadCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DensidadCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aAltaJT;
    private javax.swing.JTextField denoJT;
    private javax.swing.JTextField indiceJT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField valIndJT;
    // End of variables declaration//GEN-END:variables

    public void LimpiarCasilleros() {
        valIndJT.setText("");
        aAltaJT.setText("");
        indiceJT.setText("");
        denoJT.setText("");
    }    
}
