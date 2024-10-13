package vista;

import conexion.ProveedorDAO;
import javax.swing.JOptionPane;
import modelo.Proveedor;

public class AgregarProveedor extends javax.swing.JDialog {
    
    private Proveedor proveedor;

    public AgregarProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNit = new modelo.TextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new modelo.TextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new modelo.TextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new modelo.TextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new modelo.TextField();
        btnAgregar = new modelo.Button();
        btnSalir = new modelo.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(630, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(420, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Inria Sans", 1, 22)); // NOI18N
        jLabel1.setText("Agregar Nuevo Proveedor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel3.setText("NIT");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        txtNit.setBorderColor(new java.awt.Color(204, 204, 204));
        txtNit.setBorderColorOnFocus(new java.awt.Color(248, 197, 152));
        txtNit.setBorderEnabled(true);
        txtNit.setFocusColorEnabled(true);
        txtNit.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        txtNit.setRadius(10);
        txtNit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNitKeyTyped(evt);
            }
        });
        jPanel1.add(txtNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 150, 35));

        jLabel5.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel5.setText("Nombre");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        txtNombre.setBorderColor(new java.awt.Color(204, 204, 204));
        txtNombre.setBorderColorOnFocus(new java.awt.Color(248, 197, 152));
        txtNombre.setBorderEnabled(true);
        txtNombre.setFocusColorEnabled(true);
        txtNombre.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        txtNombre.setRadius(10);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 300, 35));

        jLabel6.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel6.setText("Direccion");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        txtDireccion.setBorderColor(new java.awt.Color(204, 204, 204));
        txtDireccion.setBorderColorOnFocus(new java.awt.Color(248, 197, 152));
        txtDireccion.setBorderEnabled(true);
        txtDireccion.setFocusColorEnabled(true);
        txtDireccion.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        txtDireccion.setRadius(10);
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 500, 35));

        jLabel7.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel7.setText("Telefono");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        txtTelefono.setBorderColor(new java.awt.Color(204, 204, 204));
        txtTelefono.setBorderColorOnFocus(new java.awt.Color(248, 197, 152));
        txtTelefono.setBorderEnabled(true);
        txtTelefono.setFocusColorEnabled(true);
        txtTelefono.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        txtTelefono.setRadius(10);
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 175, 35));

        jLabel8.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel8.setText("Email");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 310, -1, -1));

        txtEmail.setBorderColor(new java.awt.Color(204, 204, 204));
        txtEmail.setBorderColorOnFocus(new java.awt.Color(248, 197, 152));
        txtEmail.setBorderEnabled(true);
        txtEmail.setFocusColorEnabled(true);
        txtEmail.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        txtEmail.setRadius(10);
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 330, 275, 35));

        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setColor(new java.awt.Color(243, 156, 79));
        btnAgregar.setColorOver(new java.awt.Color(239, 125, 24));
        btnAgregar.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setFont(new java.awt.Font("Inria Sans", 1, 18)); // NOI18N
        btnAgregar.setHoverEnabled(true);
        btnAgregar.setRadius(20);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 175, 45));

        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setColor(new java.awt.Color(243, 79, 84));
        btnSalir.setColorOver(new java.awt.Color(239, 24, 30));
        btnSalir.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setFont(new java.awt.Font("Inria Sans", 1, 18)); // NOI18N
        btnSalir.setHoverEnabled(true);
        btnSalir.setRadius(20);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 175, 45));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(txtNit.getText().isEmpty() || txtNombre.getText().isEmpty() || txtDireccion.getText().isEmpty() ||
                txtTelefono.getText().isEmpty() || txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Completa todos los campos", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        long nit = Long.parseLong(txtNit.getText());
        String nombre = txtNombre.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        
        proveedor = new Proveedor(0, nit, nombre, direccion, telefono, email);
        
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        boolean agregado = proveedorDAO.agregarProveedor(proveedor);
        
        if(agregado) {
            JOptionPane.showMessageDialog(rootPane, "Proveedor agregado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error al agregar proveedor", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        txtNit.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitKeyTyped
        char c1 = evt.getKeyChar();
        if(!(Character.isDigit(c1))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNitKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarProveedor dialog = new AgregarProveedor(new javax.swing.JFrame(), true);
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
    private modelo.Button btnAgregar;
    private modelo.Button btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private modelo.TextField txtDireccion;
    private modelo.TextField txtEmail;
    private modelo.TextField txtNit;
    private modelo.TextField txtNombre;
    private modelo.TextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
