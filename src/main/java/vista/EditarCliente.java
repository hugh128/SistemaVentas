package vista;

import conexion.ClienteDAO;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class EditarCliente extends javax.swing.JDialog {
    
    private Cliente cliente;
    private ClienteDAO clienteDAO = new ClienteDAO();

    public EditarCliente(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setCliente(cliente);
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        lbIdCliente.setText(String.valueOf(cliente.getIdCliente()));
        txtNombre.setText(cliente.getNombre());
        txtDpi.setText(cliente.getDpi());
        txtDireccion.setText(cliente.getDireccion());
        txtNit.setText(cliente.getNit());
        txtNumero.setText(cliente.getNumero());
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
        btnGuardarCliente = new modelo.MyButton();
        jLabel6 = new javax.swing.JLabel();
        txtNumero = new modelo.MyTextField();
        jLabel7 = new javax.swing.JLabel();
        lbIdCliente = new javax.swing.JLabel();
        btnCancelar = new modelo.MyButton();

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

        btnGuardarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCliente.setText("Guardar");
        btnGuardarCliente.setColor(new java.awt.Color(44, 134, 72));
        btnGuardarCliente.setColorOver(new java.awt.Color(58, 120, 77));
        btnGuardarCliente.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarCliente.setFont(new java.awt.Font("Inria Sans", 1, 18)); // NOI18N
        btnGuardarCliente.setHoverEnabled(true);
        btnGuardarCliente.setRadius(20);
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
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

        jLabel7.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(92, 92, 92));
        jLabel7.setText("ID");

        lbIdCliente.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        lbIdCliente.setText("ID USUARIO");

        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setColor(new java.awt.Color(175, 3, 35));
        btnCancelar.setColorOver(new java.awt.Color(149, 49, 68));
        btnCancelar.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFont(new java.awt.Font("Inria Sans", 1, 18)); // NOI18N
        btnCancelar.setHoverEnabled(true);
        btnCancelar.setRadius(20);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(txtDpi, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbIdCliente)
                                .addGap(12, 12, 12)))
                        .addGap(63, 63, 63))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbIdCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
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

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
        if(txtNombre.getText().isEmpty() || txtDpi.getText().isEmpty() || txtDireccion.getText().isEmpty()
                || txtNit.getText().isEmpty() || txtNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Completa todos los campos", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        cliente.setNombre(txtNombre.getText());
        cliente.setDpi(txtDpi.getText());
        cliente.setDireccion(txtDireccion.getText());
        cliente.setNit(txtNit.getText());
        cliente.setNumero(txtNumero.getText());

        boolean editado = clienteDAO.editarCliente(cliente);

        if (editado) {
            JOptionPane.showMessageDialog(rootPane, "Cliente actualizado con éxito.");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error al actualizar cliente.");
        } 
        
        
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Cliente clientePrueba = new Cliente();
                clientePrueba.setIdCliente(1);
                clientePrueba.setNombre("Cliente de prueba");
                clientePrueba.setDpi("1");
                clientePrueba.setDireccion("Direccion de prueba");
                clientePrueba.setNit("1");
                clientePrueba.setNumero("1");
                
                EditarCliente dialog = new EditarCliente(new javax.swing.JFrame(), true, clientePrueba);
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
    private modelo.MyButton btnCancelar;
    private modelo.MyButton btnGuardarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbIdCliente;
    private modelo.MyTextField txtDireccion;
    private modelo.MyTextField txtDpi;
    private modelo.MyTextField txtNit;
    private modelo.MyTextField txtNombre;
    private modelo.MyTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
