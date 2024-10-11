package vista;

import conexion.UsuarioDAO;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class AgregarUsuario extends javax.swing.JDialog {
    
    private Usuario usuario;
    private UsuarioDAO usuarioDAO;

    public AgregarUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new modelo.MyTextField();
        txtNombre = new modelo.MyTextField();
        txtPassword = new modelo.MyPasswordField();
        cbTipoUsuario = new modelo.Combobox();
        btnCrearUsuario = new modelo.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Inria Sans", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(41, 41, 42));
        jLabel1.setText("Nuevo Usuario");

        jLabel2.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(92, 92, 92));
        jLabel2.setText("NOMBRE");

        jLabel4.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(92, 92, 92));
        jLabel4.setText("USUARIO");

        jLabel5.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(92, 92, 92));
        jLabel5.setText("CONTRASEÑA");

        jLabel6.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(92, 92, 92));
        jLabel6.setText("TIPO USUARIO");

        txtUsuario.setBorderColor(new java.awt.Color(153, 153, 153));
        txtUsuario.setBorderColorOnFocus(new java.awt.Color(3, 155, 216));
        txtUsuario.setBorderEnabled(true);
        txtUsuario.setFocusColorEnabled(true);
        txtUsuario.setFont(new java.awt.Font("Inria Sans", 0, 13)); // NOI18N
        txtUsuario.setRadius(20);

        txtNombre.setBorderColor(new java.awt.Color(153, 153, 153));
        txtNombre.setBorderColorOnFocus(new java.awt.Color(3, 155, 216));
        txtNombre.setBorderEnabled(true);
        txtNombre.setFocusColorEnabled(true);
        txtNombre.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        txtNombre.setRadius(20);

        txtPassword.setBorderColor(new java.awt.Color(153, 153, 153));
        txtPassword.setBorderColorOnFocus(new java.awt.Color(3, 155, 216));
        txtPassword.setBorderEnabled(true);
        txtPassword.setFocusColorEnabled(true);
        txtPassword.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        txtPassword.setRadius(20);

        cbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Administrador", "Usuario" }));
        cbTipoUsuario.setSelectedIndex(-1);
        cbTipoUsuario.setFont(new java.awt.Font("Inria Sans", 0, 15)); // NOI18N

        btnCrearUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearUsuario.setText("Crear Usuario");
        btnCrearUsuario.setColor(new java.awt.Color(31, 31, 32));
        btnCrearUsuario.setColorOver(new java.awt.Color(0, 0, 0));
        btnCrearUsuario.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearUsuario.setFont(new java.awt.Font("Inria Sans", 1, 18)); // NOI18N
        btnCrearUsuario.setHoverEnabled(true);
        btnCrearUsuario.setRadius(20);
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(cbTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(cbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
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

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        String itemSeleccionado = (String)cbTipoUsuario.getSelectedItem();
        
        if(txtNombre.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtPassword.getPassword().length == 0
                || itemSeleccionado == null || itemSeleccionado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Completa todos los campos", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(txtPassword.getPassword().length < 8) {
            JOptionPane.showMessageDialog(rootPane, "Ingresa una contraseña que contenga minimo 8 caracteres", "Contraseña corta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String nombre = txtNombre.getText();
        String usuarioNombre = txtUsuario.getText();
        String password = String.valueOf(txtPassword.getPassword());
        
        usuario = new Usuario(0, usuarioNombre, nombre, password, itemSeleccionado, new Date());
        usuarioDAO = new UsuarioDAO();
        boolean agregado = usuarioDAO.agregarUsuario(usuario);
        
        if(agregado) {
            JOptionPane.showMessageDialog(rootPane, "Usuario creado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error al crear usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
        

        txtNombre.setText("");
        txtUsuario.setText("");
        txtPassword.setText("");
        cbTipoUsuario.setSelectedItem("");
        
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarUsuario dialog = new AgregarUsuario(new javax.swing.JFrame(), true);
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
    private modelo.MyButton btnCrearUsuario;
    private modelo.Combobox cbTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private modelo.MyTextField txtNombre;
    private modelo.MyPasswordField txtPassword;
    private modelo.MyTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
