/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestionFinanciacion;

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
public class FinanciacionCRUD extends javax.swing.JFrame {
    
    public FinanciacionCRUD() {
        initComponents();
        setTitle("Financiación " + Lotequen.user);
        jLabel1.setText("Finanaciación");
        jLabel7.setText("Acceso " + Lotequen.user);
        indiceJT.setEnabled(false);
        cuotaJT.setEnabled(false);
        this.setLocationRelativeTo(null);
        MostrarFinan(jTable1);
    }

    public void SeleccionarDatos(JTable tablaFinanciacion, JTextField id, JTextField grupo,
            JTextField años, JTextField valorInicial, JTextField valorCuota) {

        try {
            int fila = tablaFinanciacion.getSelectedRow();

            if (fila >= 0) {
                id.setText(tablaFinanciacion.getValueAt(fila, 0).toString());
                grupo.setText(tablaFinanciacion.getValueAt(fila, 1).toString());
                años.setText(tablaFinanciacion.getValueAt(fila, 2).toString());
                valorInicial.setText(tablaFinanciacion.getValueAt(fila, 3).toString());
                valorCuota.setText(tablaFinanciacion.getValueAt(fila, 4).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada: Tabla de Financiación");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección: Tabla de Financiación " + e);

        }
    }

    public void MostrarFinan(JTable tablaFinan) {

        this.jTable1 = tablaFinan;

        Conexion cn = new Conexion();
        String consulta = "";
        DefaultTableModel modelo = new DefaultTableModel();
        String[] datosConsulta = new String[5];
        Statement st;

        //ordeno tabla
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        tablaFinan.setRowSorter(OrdenarTabla);

        //completo la tabla conlos encabezados
        modelo.addColumn("ID");
        modelo.addColumn("Gupo");
        modelo.addColumn("Años");
        modelo.addColumn("Valor Inicial");
        modelo.addColumn("Valor Cuota");

        //lleno la tabla con el modelo creado
        tablaFinan.setModel(modelo);

        consulta = "select * from financiacion;";

        try {
            st = cn.getConection().createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                datosConsulta[0] = rs.getString(1);
                datosConsulta[1] = rs.getString(2);
                datosConsulta[2] = rs.getString(3);
                datosConsulta[3] = rs.getString(4);
                datosConsulta[4] = rs.getString(5);

                modelo.addRow(datosConsulta);
            }
            tablaFinan.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pueden mostrar registros: Tabla de Financiación");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        grupo = new javax.swing.JTextField();
        año = new javax.swing.JTextField();
        apInicial = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        indiceJT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cuotaJT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Grupo:");

        jLabel3.setText("Duración (años):");

        jLabel4.setText("Aporte Inicial (%):");

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Crear Registro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("ID");

        jLabel6.setText("Cuota");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(apInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(indiceJT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cuotaJT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addGap(1, 1, 1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(cuotaJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuJF menu = new MenuJF();
        menu.setVisible(true);
        this.dispose();  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //es necesario convertir el textfield a string, para guardarlo como int.
        String grupoS, añoS, apInicialS;
        int añoI;
        double apInicialD, valCuotaD;
        int validacion = 0;

        grupoS = grupo.getText().trim();
        añoS = año.getText().trim();
        apInicialS = apInicial.getText().trim();

        // valida que los casilleros no estén vacíos
        if (grupoS.equals("")) {
            grupo.setBackground(Color.red);
            validacion++;
        }
        if (añoS.equals("")) {
            año.setBackground(Color.red);
            validacion++;
        }
        if (apInicialS.equals("")) {
            apInicial.setBackground(Color.red);
            validacion++;
        }
        //valida si ya fue registrada la tierra, nuevamente si escribo esto para cada clase, no llegaría con los tiempos.      
        try {
            Conexion con = new Conexion();
            Statement st = con.getConection().createStatement();
            String consulta = "select grupo from financiacion where grupo = '"
                    + grupoS + "';";
            ResultSet rs = st.executeQuery(consulta);

            if (rs.next()) {
                String nombre = rs.getString("grupo");
                if (nombre.equalsIgnoreCase(grupoS)) {
                    grupo.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "El nombre del grupo no se encuantra disponible");
                }
            } else {
                st.close();
                if (validacion == 0) {
                    //evita errores al validar datos
                    añoI = Integer.parseInt(añoS);
                    apInicialD = Double.parseDouble(apInicialS);
                    //en indice respecto porcentaje de inicial y del tiempo 
                    valCuotaD = (((100 - apInicialD) / 100) / (añoI * 12));
                    try {
                        Conexion cx = new Conexion();
                        String insert = "insert into financiacion (grupo, años, aporte_inicial, valor_cuota) values "
                                + "(?,?,?,?);";
                        CallableStatement cs = cx.getConection().prepareCall(insert);

                        cs.setString(1, grupoS);
                        cs.setInt(2, añoI);
                        cs.setDouble(3, apInicialD);
                        cs.setDouble(4, valCuotaD);
                        cs.execute();
                        LimpiarCasilleros();
                        MostrarFinan(jTable1);
                        cs.close();
                        JOptionPane.showMessageDialog(null, "Registro exitoso!");
                    } catch (SQLException e) {/**/
                        System.err.println("Error en el registro de financiación." + e);
                        JOptionPane.showMessageDialog(null, "Error, contacte al administrador (finanaciación) !");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los cmapos");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error en validar grupo " + e);
            JOptionPane.showMessageDialog(null, "Error al comparar grupos, comuniquese con su administrador");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String grupoS, añoS, apInicialS;
        int añoI, indiceInt, valCuotInt;
        double apInicialD, valCuotaD;

        String csParcela, noTierra, catastro;
        int parcela;

        indiceInt = Integer.parseInt(indiceJT.getText().trim());
        valCuotaD = Double.parseDouble(cuotaJT.getText().trim());

        grupoS = grupo.getText().trim();
        añoS = año.getText().trim();
        apInicialS = apInicial.getText().trim();

        añoI = Integer.parseInt(añoS);
        apInicialD = Double.parseDouble(apInicialS);

        valCuotaD = (((100 - apInicialD) / 100) / (añoI * 12));

        try {
            Conexion cx = new Conexion();
            String update = "update financiacion set grupo = ?, años = ?,"
                    + " aporte_inicial = ?, valor_cuota = ? where id_financiacion = ?;";
            CallableStatement cs = cx.getConection().prepareCall(update);

            cs.setString(1, grupoS);
            cs.setInt(2, añoI);
            cs.setDouble(3, apInicialD);
            cs.setDouble(4, valCuotaD);
            cs.setInt(5, indiceInt);
            cs.execute();

            LimpiarCasilleros();
            MostrarFinan(jTable1);
            cs.close();
            JOptionPane.showMessageDialog(null, "Actualización exitosa!");
        } catch (SQLException e) {
            System.err.println("Error en la modificación del financiación." + e);
            JOptionPane.showMessageDialog(null, "Error, contacte al administrador (financiacion) !");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        int indiceInt;

        indiceInt = Integer.parseInt(indiceJT.getText().trim());
        
        try {
            Conexion cx = new Conexion();

            String delete = "delete from financiacion where id_financiacion = ?;";
            CallableStatement cs = cx.getConection().prepareCall(delete);

            cs.setInt(1, indiceInt);
            cs.execute();

            LimpiarCasilleros();
            MostrarFinan(jTable1);
            cs.close();
            JOptionPane.showMessageDialog(null, "Fila eliminada!");
        } catch (SQLException e) {
            System.err.println("Error en la eliminación del financiación." + e);
            JOptionPane.showMessageDialog(null, "Error, contacte al administrador (financiación) !");
        }        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int filas;

        int seleccion = jTable1.getSelectedRow();
        grupo.setText(jTable1.getValueAt(seleccion, 1).toString());
        año.setText(jTable1.getValueAt(seleccion, 2).toString());
        apInicial.setText(jTable1.getValueAt(seleccion, 3).toString());
        indiceJT.setText(jTable1.getValueAt(seleccion, 0).toString());
        cuotaJT.setText(jTable1.getValueAt(seleccion, 4).toString());
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
            java.util.logging.Logger.getLogger(FinanciacionCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinanciacionCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinanciacionCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinanciacionCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinanciacionCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apInicial;
    private javax.swing.JTextField año;
    private javax.swing.JTextField cuotaJT;
    private javax.swing.JTextField grupo;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void LimpiarCasilleros() {
        grupo.setText("");
        año.setText("");
        apInicial.setText("");
        indiceJT.setText("");
        cuotaJT.setText("");
    }

}