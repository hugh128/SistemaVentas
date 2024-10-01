package vista;

import conexion.ProveedorDAO;
import javax.swing.JOptionPane;
import modelo.Proveedor;

public class EditarProveedor extends javax.swing.JDialog {
    
    private Proveedor proveedor;
    private ProveedorDAO proveedorDAO = new ProveedorDAO();

    public EditarProveedor(java.awt.Frame parent, boolean modal, Proveedor proveedor) {
        super(parent, modal);
        this.proveedor = proveedor;
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        llenarCampos();
    }
    
    private void llenarCampos() {
        lbIdProveedor.setText(String.valueOf(proveedor.getIdProveedor()));
        txtNit.setText(String.valueOf(proveedor.getNit()));
        txtNombre.setText(proveedor.getNombre());
        txtDireccion.setText(proveedor.getDireccion());
        txtTelefono.setText(proveedor.getTelefono());
        txtEmail.setText(proveedor.getEmail());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new modelo.TextField();
        txtNit = new modelo.TextField();
        lbIdProveedor = new javax.swing.JLabel();
        txtNombre = new modelo.TextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new modelo.TextField();
        txtEmail = new modelo.TextField();
        btnGuardarProveedor = new modelo.Button();
        btnSalirEdicion = new modelo.Button();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(630, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Inria Sans", 1, 22)); // NOI18N
        jLabel1.setText("Editar Proveedor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel5.setText("Nombre");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel3.setText("Direccion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        txtDireccion.setBorderColor(new java.awt.Color(204, 204, 204));
        txtDireccion.setBorderColorOnFocus(new java.awt.Color(79, 84, 243));
        txtDireccion.setBorderEnabled(true);
        txtDireccion.setFocusColorEnabled(true);
        txtDireccion.setRadius(10);
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 500, 35));

        txtNit.setBorderColor(new java.awt.Color(204, 204, 204));
        txtNit.setBorderColorOnFocus(new java.awt.Color(79, 84, 243));
        txtNit.setBorderEnabled(true);
        txtNit.setFocusColorEnabled(true);
        txtNit.setRadius(10);
        txtNit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNitKeyTyped(evt);
            }
        });
        jPanel1.add(txtNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 130, 35));

        lbIdProveedor.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        lbIdProveedor.setText("ID");
        jPanel1.add(lbIdProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        txtNombre.setBorderColor(new java.awt.Color(204, 204, 204));
        txtNombre.setBorderColorOnFocus(new java.awt.Color(79, 84, 243));
        txtNombre.setBorderEnabled(true);
        txtNombre.setFocusColorEnabled(true);
        txtNombre.setRadius(10);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 300, 35));

        jLabel6.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel6.setText("Telefono");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        jLabel7.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel7.setText("Email");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, -1, -1));

        txtTelefono.setBorderColor(new java.awt.Color(204, 204, 204));
        txtTelefono.setBorderColorOnFocus(new java.awt.Color(79, 84, 243));
        txtTelefono.setBorderEnabled(true);
        txtTelefono.setFocusColorEnabled(true);
        txtTelefono.setRadius(10);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 175, 35));

        txtEmail.setBorderColor(new java.awt.Color(204, 204, 204));
        txtEmail.setBorderColorOnFocus(new java.awt.Color(79, 84, 243));
        txtEmail.setBorderEnabled(true);
        txtEmail.setFocusColorEnabled(true);
        txtEmail.setRadius(10);
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 275, 35));

        btnGuardarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarProveedor.setText("Guardar");
        btnGuardarProveedor.setColor(new java.awt.Color(79, 84, 243));
        btnGuardarProveedor.setColorOver(new java.awt.Color(79, 57, 236));
        btnGuardarProveedor.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarProveedor.setFont(new java.awt.Font("Inria Sans", 1, 18)); // NOI18N
        btnGuardarProveedor.setHoverEnabled(true);
        btnGuardarProveedor.setRadius(20);
        btnGuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 175, 45));

        btnSalirEdicion.setForeground(new java.awt.Color(255, 255, 255));
        btnSalirEdicion.setText("Salir");
        btnSalirEdicion.setColor(new java.awt.Color(243, 79, 84));
        btnSalirEdicion.setColorOver(new java.awt.Color(239, 24, 30));
        btnSalirEdicion.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalirEdicion.setFont(new java.awt.Font("Inria Sans", 1, 18)); // NOI18N
        btnSalirEdicion.setHoverEnabled(true);
        btnSalirEdicion.setRadius(20);
        btnSalirEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirEdicionActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalirEdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 175, 45));

        jLabel8.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel8.setText("NIT");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel9.setText("ID Proveedor");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveedorActionPerformed
        if(txtNit.getText().isEmpty() || txtNombre.getText().isEmpty() || txtDireccion.getText().isEmpty() ||
                txtTelefono.getText().isEmpty() || txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Completa todos los campos", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        proveedor.setNit(Integer.parseInt(txtNit.getText()));
        proveedor.setNombre(txtNombre.getText());
        proveedor.setDireccion(txtDireccion.getText());
        proveedor.setTelefono(txtTelefono.getText());
        proveedor.setEmail(txtEmail.getText());

        boolean editado = proveedorDAO.editarProveedor(proveedor);

        if (editado) {
            JOptionPane.showMessageDialog(rootPane, "Proveedor actualizado con éxito.");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error al actualizar el proveedor.");
        }       
        
    }//GEN-LAST:event_btnGuardarProveedorActionPerformed

    private void btnSalirEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirEdicionActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirEdicionActionPerformed

    private void txtNitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitKeyTyped
        char c1 = evt.getKeyChar();
        if(!(Character.isDigit(c1))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNitKeyTyped

    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarProveedor dialog = new EditarProveedor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/
    
        public static void main(String args[]) { 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Proveedor proveedorPrueba = new Proveedor();
                proveedorPrueba.setIdProveedor(1);
                proveedorPrueba.setNit(12345678);
                proveedorPrueba.setNombre("Proveedor de Prueba");
                proveedorPrueba.setDireccion("Dirección de prueba");
                proveedorPrueba.setTelefono("1234-5678");
                proveedorPrueba.setEmail("prueba@proveedor.com");

                EditarProveedor dialog = new EditarProveedor(new javax.swing.JFrame(), true, proveedorPrueba);
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
    private modelo.Button btnGuardarProveedor;
    private modelo.Button btnSalirEdicion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbIdProveedor;
    private modelo.TextField txtDireccion;
    private modelo.TextField txtEmail;
    private modelo.TextField txtNit;
    private modelo.TextField txtNombre;
    private modelo.TextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
