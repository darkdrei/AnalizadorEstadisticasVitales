/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobernacion;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import logica.ArchivoControlPrenatalDefuncion;
import logica.Analisis;

/**
 *
 * @author dark
 */
public class gestionreporte extends javax.swing.JFrame {

    private File control_penatral_defuncion[] = new File[]{};
    private File control_penatral_vivo[] = new File[]{};
    private File deuda_certificado[] = new File[]{};
    private File estadistica_vital_defuncines[] = new File[]{};
    private File estadistica_vital_vivos[] = new File[]{};
    Analisis a = new Analisis();

    /**
     * Creates new form gestionreporte
     */
    public gestionreporte() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ima/list.png"));
        setIconImage(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEstadisticaVitalNacimientos = new javax.swing.JButton();
        btnEstadisticaVitalFallecimientos = new javax.swing.JButton();
        btnEstadisticaControlParental = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnGenerarReporte = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analisis de cumplimiento");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de archivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 24))); // NOI18N

        btnEstadisticaVitalNacimientos.setText("Ruaf Nacimientos");
        btnEstadisticaVitalNacimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadisticaVitalNacimientosActionPerformed(evt);
            }
        });

        btnEstadisticaVitalFallecimientos.setText("Ruaf Defunciones");
        btnEstadisticaVitalFallecimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadisticaVitalFallecimientosActionPerformed(evt);
            }
        });

        btnEstadisticaControlParental.setText("Control de papeleria");
        btnEstadisticaControlParental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadisticaControlParentalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEstadisticaVitalNacimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEstadisticaVitalFallecimientos, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(btnEstadisticaControlParental, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnEstadisticaVitalNacimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstadisticaVitalFallecimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEstadisticaControlParental, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addGap(51, 51, 51))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reporte", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 24))); // NOI18N

        jButton1.setText("Analizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGenerarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Municipio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 24))); // NOI18N

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "ACHÍ", "MAGANGUÉ", "MONTECRISTO", "PINILLOS", "SAN JACINTO DEL CAUCA", "TIQUISIO", "SAN JUAN NEPOMUCENO", "SAN JACINTO", "MARIA LABAJA", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );

        area.setColumns(20);
        area.setRows(5);
        jScrollPane2.setViewportView(area);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println(" vivos: " + estadistica_vital_vivos.length + "  " + estadistica_vital_defuncines.length + "   " + control_penatral_vivo.length + "  " + jList1.getSelectedIndices());
        if (jList1.getSelectedIndices().length > 0) {
            if (estadistica_vital_vivos.length > 0) {
                if (estadistica_vital_defuncines.length > 0) {
                    if (this.control_penatral_vivo.length > 0) {

                        for (int control_penatral_defuncion1 : jList1.getSelectedIndices()) {
                            System.out.println(control_penatral_defuncion1);
                        }
                        a.extraerMultiplesArchivos(jList1.getSelectedIndices(), estadistica_vital_vivos, estadistica_vital_defuncines, control_penatral_vivo);
                        area.setText(a.getInfo());
                    } else {
                        JOptionPane.showMessageDialog(this, "Usted debe cargar los archivos del Control de papeleria.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Usted debe cargar los archivos de la estadistica vital de fallecimientos.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Usted debe cargar los archivos de la estadistica vital de nacimientos.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usted debe seleccionar los municipios de analisis.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        // TODO add your handling code here:
        if (a.getReporte().size() > 0) {
            JFileChooser f = new JFileChooser();
            f.setDialogTitle("Guardar Informe");
            f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int op = f.showOpenDialog(f);
            if (op == JFileChooser.APPROVE_OPTION) {
                System.out.println("entro");
                //f.showSaveDialog(null);
                a.generarWord(f.getSelectedFile().getPath());
                System.out.println(f.getCurrentDirectory());
                System.out.println(f.getSelectedFile());
            } else {
                JOptionPane.showMessageDialog(this, "Guardar Informe", "Debe seleccionar un directorio.", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Guardar Informe", "Debe realizar el analisis.", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
        System.out.println(jList1.getSelectedValuesList());
        System.out.println(Arrays.asList(jList1.getSelectedIndices()));
        for (int col : jList1.getSelectedIndices()) {
            System.out.println(col);
        }
        if (jList1.getSelectedIndices().length > 1) {

        } else {
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void btnEstadisticaVitalNacimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticaVitalNacimientosActionPerformed
        // TODO add your handling code here:
        estadistica_vital_vivos = capturarArchivo("Ruaf Nacimientos");
        btnEstadisticaVitalNacimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/check.png")));
    }//GEN-LAST:event_btnEstadisticaVitalNacimientosActionPerformed

    public File[] capturarArchivo(String men) {
        JFileChooser f = new JFileChooser();
        f.setDialogTitle(men);
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int op = f.showOpenDialog(f);
        if (op == JFileChooser.APPROVE_OPTION) {
            System.out.println("entro");
            System.out.println("Directorio : " + f.getCurrentDirectory());
            System.out.println("esta es la cantidad de archivos  " + f.getSelectedFile().listFiles().length);
            return f.getSelectedFile().listFiles();
        } else {
            System.out.println("fallo");
            JOptionPane.showMessageDialog(this, men, "La extensión debe ser xls.", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }


    private void btnEstadisticaVitalFallecimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticaVitalFallecimientosActionPerformed
        // TODO add your handling code here:
        estadistica_vital_defuncines = capturarArchivo("Ruaf Defunciones");
        btnEstadisticaVitalFallecimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/check.png")));
    }//GEN-LAST:event_btnEstadisticaVitalFallecimientosActionPerformed

    private void btnEstadisticaControlParentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticaControlParentalActionPerformed
        // TODO add your handling code here:
        this.control_penatral_vivo = capturarArchivo("Control de papeleria");
        btnEstadisticaControlParental.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ima/check.png")));
    }//GEN-LAST:event_btnEstadisticaControlParentalActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        area.setText("");
        control_penatral_defuncion = new File[]{};
        control_penatral_vivo = new File[]{};
        deuda_certificado = new File[]{};
        estadistica_vital_defuncines = new File[]{};
        estadistica_vital_vivos = new File[]{};
         btnEstadisticaVitalNacimientos.setIcon(null);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
 /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gestionreporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gestionreporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gestionreporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gestionreporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gestionreporte().setVisible(true);
            }
        });*/
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gestionreporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gestionreporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gestionreporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gestionreporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
                } catch (Exception rt) {
                }
                new gestionreporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JButton btnEstadisticaControlParental;
    private javax.swing.JButton btnEstadisticaVitalFallecimientos;
    private javax.swing.JButton btnEstadisticaVitalNacimientos;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
