package vista;

import conexion.ClienteDAO;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class AgregarCliente extends javax.swing.JDialog {
    
    private Cliente cliente;
    private ClienteDAO clienteDAO;

    public AgregarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new modelo.MyTextField();
        txtNombre = new modelo.MyTextField();
        txtDpi = new modelo.MyTextField();
        txtNit = new modelo.MyTextField();
        btnAgregarCliente = new modelo.MyButton();
        jLabel6 = new javax.swing.JLabel();
        txtNumero = new modelo.MyTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Inria Sans", 1, 22)); // NOI18N
        jLabel1.setText("Nuevo Cliente");

        jLabel2.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(92, 92, 92));
        jLabel2.setText("NOMBRE");

        jLabel3.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(92, 92, 92));
        jLabel3.setText("DPI");

        jLabel4.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(92, 92, 92));
        jLabel4.setText("NIT");

        jLabel5.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(92, 92, 92));
        jLabel5.setText("DIRECCION");

        txtDireccion.setBorderColor(new java.awt.Color(153, 153, 153));
        txtDireccion.setBorderColorOnFocus(new java.awt.Color(44, 134, 72));
        txtDireccion.setBorderEnabled(true);
        txtDireccion.setFocusColorEnabled(true);
        txtDireccion.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        txtDireccion.setRadius(20);
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtNombre.setBorderColor(new java.awt.Color(153, 153, 153));
        txtNombre.setBorderColorOnFocus(new java.awt.Color(44, 134, 72));
        txtNombre.setBorderEnabled(true);
        txtNombre.setFocusColorEnabled(true);
        txtNombre.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        txtNombre.setRadius(20);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtDpi.setBorderColor(new java.awt.Color(153, 153, 153));
        txtDpi.setBorderColorOnFocus(new java.awt.Color(44, 134, 72));
        txtDpi.setBorderEnabled(true);
        txtDpi.setFocusColorEnabled(true);
        txtDpi.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        txtDpi.setRadius(20);
        txtDpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDpiActionPerformed(evt);
            }
        });

        txtNit.setBorderColor(new java.awt.Color(153, 153, 153));
        txtNit.setBorderColorOnFocus(new java.awt.Color(44, 134, 72));
        txtNit.setBorderEnabled(true);
        txtNit.setFocusColorEnabled(true);
        txtNit.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        txtNit.setRadius(20);
        txtNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNitActionPerformed(evt);
            }
        });

        btnAgregarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCliente.setText("Agregar");
        btnAgregarCliente.setColor(new java.awt.Color(44, 134, 72));
        btnAgregarCliente.setColorOver(new java.awt.Color(58, 120, 77));
        btnAgregarCliente.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarCliente.setFont(new java.awt.Font("Inria Sans", 1, 18)); // NOI18N
        btnAgregarCliente.setHoverEnabled(true);
        btnAgregarCliente.setRadius(20);
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(92, 92, 92));
        jLabel6.setText("Numero");

        txtNumero.setBorderColor(new java.awt.Color(153, 153, 153));
        txtNumero.setBorderColorOnFocus(new java.awt.Color(44, 134, 72));
        txtNumero.setBorderEnabled(true);
        txtNumero.setFocusColorEnabled(true);
        txtNumero.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        txtNumero.setRadius(20);
        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(167, 167, 167))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel2)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtDpi, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 72, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDpi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDpiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDpiActionPerformed

    private void txtNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNitActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        if(txtNombre.getText().isEmpty() || txtDpi.getText().isEmpty() || txtDireccion.getText().isEmpty()
                || txtNit.getText().isEmpty() || txtNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Completa todos los campos", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String nombre = txtNombre.getText();
        String dpi = txtDpi.getText();
        String direccion = txtDireccion.getText();
        String nit = txtNit.getText();
        String numero = txtNumero.getText();
        
        cliente = new Cliente(0, nombre, dpi, nit, numero, direccion);
        clienteDAO = new ClienteDAO();
        boolean agregado = clienteDAO.agregarCliente(cliente);
        
        if(agregado) {
            JOptionPane.showMessageDialog(rootPane, "Cliente agregado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error al agregar cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        txtNombre.setText("");
        txtDpi.setText("");
        txtDireccion.setText("");
        txtNit.setText("");
        txtNumero.setText("");
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarCliente dialog = new AgregarCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private modelo.MyButton btnAgregarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private modelo.MyTextField txtDireccion;
    private modelo.MyTextField txtDpi;
    private modelo.MyTextField txtNit;
    private modelo.MyTextField txtNombre;
    private modelo.MyTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
