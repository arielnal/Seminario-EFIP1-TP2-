/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestionLoteo;

import interfaces.Limpiar;
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
public class LoteoCRUD extends javax.swing.JFrame implements Limpiar {


    public LoteoCRUD() {
        initComponents();
        setTitle("Loteo " + Lotequen.user);
        jLabel1.setText("Loteo");
        jLabel9.setText("Acceso " + Lotequen.user);        
        idLotJT.setEnabled(false);
        idTierJT.setEnabled(false);
        idDenJT.setEnabled(false);
        this.setLocationRelativeTo(null);
        MostrarLotes(jTable1);
    }

    public void SeleccionarDatos(JTable tablaLoteo, JTextField id, JTextField nomen,
            JTextField mz, JTextField cs) {

        try {
            int fila = tablaLoteo.getSelectedRow();

            if (fila >= 0) {
                id.setText(tablaLoteo.getValueAt(fila, 0).toString());
                nomen.setText(tablaLoteo.getValueAt(fila, 1).toString());
                mz.setText(tablaLoteo.getValueAt(fila, 2).toString());
                cs.setText(tablaLoteo.getValueAt(fila, 3).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada: Tabla de Densidad");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección: Tabla de Densidad " + e);

        }
    }

    public void MostrarLotes(JTable tablaLoteo) {

        this.jTable1 = tablaLoteo;

        Conexion cn = new Conexion();
        String consulta = "";
        DefaultTableModel modelo = new DefaultTableModel();
        String[] datosConsulta = new String[6];
        Statement st;

        //ordeno tabla
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        tablaLoteo.setRowSorter(OrdenarTabla);

        //completo la tabla conlos encabezados
        modelo.addColumn("ID");
        modelo.addColumn("Tierra ID");
        modelo.addColumn("Densidad ID");
        modelo.addColumn("Nomenclatura");
        modelo.addColumn("Manzana");
        modelo.addColumn("Lote/Casa");

        //lleno la tabla con el modelo creado
        tablaLoteo.setModel(modelo);

        consulta = "select * from lote;";

        try {
            st = cn.getConection().createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                datosConsulta[0] = rs.getString(1);
                datosConsulta[1] = rs.getString(2);
                datosConsulta[2] = rs.getString(3);
                datosConsulta[3] = rs.getString(4);
                datosConsulta[4] = rs.getString(5);
                datosConsulta[5] = rs.getString(6);

                modelo.addRow(datosConsulta);
            }
            tablaLoteo.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pueden mostrar registros: Tabla de Lote");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        csJT = new javax.swing.JTextField();
        mzJT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nomenJT = new javax.swing.JTextField();
        idLotJT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        idTierJT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        idDenJT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        densidadJT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Cant. Manzanas:");

        jButton4.setText("Eliminar TODO  el Loteo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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

        jLabel4.setText("Cant. Lotes x Mz:");

        jLabel5.setText("IDLoteo");

        jLabel2.setText("Nomenclatura:");

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

        jLabel6.setText("IDTierra");

        jLabel7.setText("IDDensidad");

        jLabel8.setText("Densidad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(idTierJT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(idLotJT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idDenJT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nomenJT, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(csJT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(mzJT, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(densidadJT)))))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomenJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mzJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(csJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(densidadJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jButton2)
                                .addGap(90, 90, 90))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idLotJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idTierJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idDenJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //es necesario convertir el textfield a string, para guardarlo como int.
        String nomenS, mzS, csS, parcelaS, tierraS, densidadS;
        int mzI, csI, parcelaI, tierraI, densidadI;
        int validacion = 0;

        nomenS = nomenJT.getText().trim();
        mzS = mzJT.getText().trim();
        csS = csJT.getText().trim();
        densidadS = densidadJT.getText().trim();

        // valida que los casilleros no estén vacíos
        if (nomenS.equals("")) {
            nomenJT.setBackground(Color.red);
            validacion++;
        }
        if (densidadS.equals("")) {
            densidadJT.setBackground(Color.red);
            validacion++;
        }
        if (mzS.equals("")) {
            mzJT.setBackground(Color.red);
            validacion++;
        }
        if (csS.equals("")) {
            csJT.setBackground(Color.red);
            validacion++;
        }
        //valida si ya fue registrada la tierra, nuevamente si escribo esto para cada clase, no llegaría con los tiempos.
        try {
            Conexion con = new Conexion();
            Statement st = con.getConection().createStatement();
            String consulta = "select nomenclatura from lote where nomenclatura = '"
                    + nomenS + "';";
            ResultSet rs = st.executeQuery(consulta);

            if (rs.next()) {
                String nombre = rs.getString("nomenclatura");
                if (nombre.equalsIgnoreCase(nomenS)) {
                    nomenJT.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "La denominación no se encuantra disponible");
                }
            } else {
                //st.close();
                if (validacion == 0) {
                    //evita errores al validar datos
                    mzI = Integer.parseInt(mzS);
                    csI = Integer.parseInt(csS);

                    Statement st1 = con.getConection().createStatement();
                    String selectTierra1 = "select parcela from tierra  where nombre"
                            + " = '" + nomenS + "';";
                    ResultSet rs1 = st1.executeQuery(selectTierra1);
                    rs1.next();
                    parcelaS = rs1.getString("parcela");
                    parcelaI = Integer.parseInt(parcelaS);
                    st1.close();
                    Statement st3 = con.getConection().createStatement();
                    String selectTierra2 = "select id_tierra from tierra  where nombre"
                            + " = '" + nomenS + "';";
                    ResultSet rs3 = st3.executeQuery(selectTierra2);
                    rs3.next();
                    tierraS = rs3.getString("id_tierra");
                    tierraI = Integer.parseInt(tierraS);
                    st3.close();
                    // voy a buscar los indices faltantes
                    Statement st2 = con.getConection().createStatement();
                    String selectDensidad = "select id_densidad from densidad where denominación"
                            + " = '" + densidadS + "';";
                    ResultSet rs2 = st2.executeQuery(selectDensidad);
                    rs2.next();
                    densidadS = rs2.getString("id_densidad");
                    densidadI = Integer.parseInt(densidadS);
                    st2.close();

                    /* para los fines prácticos, voy a simplificar la zonificación de manzanas, suponiendo que todas van a ser iguales, excepto la última.
                        más adelante, cuando vea el tema de beneficiarios, va a se necesario saber que mz y cs se le asigna.. específicamente a él!*/
                    int k = (parcelaI - ((mzI - 1) * csI));

                    //en indice respecto porcentaje de inicial y del tiempo
                    try {
                        Conexion cx = new Conexion();
                        String insert = "insert into lote (tierra_id, densidad_id, "
                                + "nomenclatura, manzana, lote) values "
                                + "(?,?,?,?,?);";
                        CallableStatement cs = cx.getConection().prepareCall(insert);

                        for (int i = 1; i < mzI; i++) {//no va a haber mz o cs número "cero".
                            for (int j = 1; j < (1 + csI); j++) {
                                cs.setInt(1, tierraI);
                                cs.setInt(2, densidadI);
                                cs.setString(3, nomenS);
                                cs.setInt(4, i);
                                cs.setInt(5, j);
                                cs.execute();
                            }
                        }
                        for (int h = 1; h < (k+1); h++) {
                            cs.setInt(1, tierraI);
                            cs.setInt(2, densidadI);
                            cs.setString(3, nomenS);
                            cs.setInt(4, mzI);
                            cs.setInt(5, h);
                            cs.execute();
                        }

                        LimpiarCasilleros();
                        MostrarLotes(jTable1);
                        cs.close();
                        JOptionPane.showMessageDialog(null, "Registro exitoso!");
                    } catch (SQLException e) {
                        System.err.println("Error en el registro de loteo." + e);
                        JOptionPane.showMessageDialog(null, "Error, contacte al administrador (loteo) !");
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
        nomenJT.setText(jTable1.getValueAt(seleccion, 3).toString());
        mzJT.setText(jTable1.getValueAt(seleccion, 4).toString());
        csJT.setText(jTable1.getValueAt(seleccion, 5).toString());
        idLotJT.setText(jTable1.getValueAt(seleccion, 0).toString());
        idTierJT.setText(jTable1.getValueAt(seleccion, 1).toString());
        idDenJT.setText(jTable1.getValueAt(seleccion, 2).toString());
        filas = seleccion;

        try {
            String densidadS;
            int densidadI = Integer.parseInt(idDenJT.getText().trim());
            Conexion con = new Conexion();
            Statement st = con.getConection().createStatement();
            String consulta = "select denominación from densidad where id_densidad = '"
                    + densidadI + "';";
            ResultSet rs = st.executeQuery(consulta);
            rs.next();
            densidadS = rs.getString("denominación");
            densidadJT.setText( densidadS);
        } catch (SQLException e) {
            System.err.println("Error en validar click " + e);
            JOptionPane.showMessageDialog(null, "Error al seleccionar, comuniquese con su administrador");
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String nomenS;

        nomenS = nomenJT.getText().trim();

        try {
            Conexion cx = new Conexion();

            String delete = "delete from lote where nomenclatura = ?;";
            CallableStatement cs = cx.getConection().prepareCall(delete);

            cs.setString(1, nomenS);
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
            java.util.logging.Logger.getLogger(LoteoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoteoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoteoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoteoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoteoCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField csJT;
    private javax.swing.JTextField densidadJT;
    private javax.swing.JTextField idDenJT;
    private javax.swing.JTextField idLotJT;
    private javax.swing.JTextField idTierJT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField mzJT;
    private javax.swing.JTextField nomenJT;
    // End of variables declaration//GEN-END:variables

    @Override
    public void LimpiarCasilleros() {
        mzJT.setText(VACIAR);
        csJT.setText(VACIAR);
        idLotJT.setText(VACIAR);
        idTierJT.setText(VACIAR);
        idDenJT.setText(VACIAR);
        nomenJT.setText(VACIAR);
        densidadJT.setText(VACIAR);
    }
    
}
