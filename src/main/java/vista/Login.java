package vista;

import conexion.UsuarioDAO;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class Login extends javax.swing.JFrame {

    private HomePage home;
    
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Iniciar Sesion");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new modelo.TextField();
        txtPassword = new modelo.PasswordField();
        btnIniciarSesion = new modelo.Button();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(13, 24, 30));

        jLabel1.setFont(new java.awt.Font("Inria Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USUARIO");

        jLabel2.setFont(new java.awt.Font("Inria Sans", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CONTRASEÑA");

        txtUsuario.setBackground(new java.awt.Color(217, 217, 217));
        txtUsuario.setBorderColorOnFocus(new java.awt.Color(0, 153, 255));
        txtUsuario.setFocusColorEnabled(true);
        txtUsuario.setFont(new java.awt.Font("Inria Sans", 1, 16)); // NOI18N
        txtUsuario.setRadius(20);

        txtPassword.setBackground(new java.awt.Color(217, 217, 217));
        txtPassword.setBorderColorOnFocus(new java.awt.Color(0, 153, 255));
        txtPassword.setFocusColorEnabled(true);
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPassword.setRadius(20);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        btnIniciarSesion.setBackground(new java.awt.Color(241, 209, 168));
        btnIniciarSesion.setText("INICIAR SESION");
        btnIniciarSesion.setClickEnabled(true);
        btnIniciarSesion.setColor(new java.awt.Color(241, 209, 168));
        btnIniciarSesion.setColorClick(new java.awt.Color(233, 182, 117));
        btnIniciarSesion.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarSesion.setFont(new java.awt.Font("Inria Sans", 1, 24)); // NOI18N
        btnIniciarSesion.setRadius(40);
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Inria Sans", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(213, 193, 163));
        jLabel3.setText("© Todos los derechos reservados 2024");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-sales-system.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 108, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2))
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)))
                .addGap(92, 92, 92))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(131, 131, 131))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        String nombreUsuario = txtUsuario.getText();
        String password = String.valueOf(txtPassword.getPassword());
        
        if(nombreUsuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Completa todos los campos", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
        }
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.obtenerUsuario(nombreUsuario, password);
        
        if (usuario != null) {
            JOptionPane.showMessageDialog(rootPane, "Bienvenido, " + usuario.getNombreUsuario() + "!", "Inicio de sesion exitoso", JOptionPane.INFORMATION_MESSAGE);
            abrirVentanaPrincipal(usuario);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrectos", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        txtPassword.setText("");
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if(evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            btnIniciarSesion.doClick();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    public void abrirVentanaPrincipal(Usuario usuario) {
        this.dispose();
        home = new HomePage(usuario);
        home.setVisible(true);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private modelo.Button btnIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private modelo.PasswordField txtPassword;
    private modelo.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
