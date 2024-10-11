package vista;

import conexion.UsuarioDAO;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class EditarUsuario extends javax.swing.JDialog {
    
    private Usuario usuario;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public EditarUsuario(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        setUsuario(usuario);
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lbIdUsuario.setText(String.valueOf(usuario.getIdUsuario()));
        txtNombre.setText(usuario.getNombre());
        txtUsuario.setText(usuario.getUsuario());
        txtPassword.setText(usuario.getPassword());
        cbTipoUsuario.setSelectedItem(usuario.getTipoUsuario());
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
        btnCancelar = new modelo.MyButton();
        btnGuadarUsuario = new modelo.MyButton();
        jLabel7 = new javax.swing.JLabel();
        lbIdUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Inria Sans", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(41, 41, 42));
        jLabel1.setText("Editar Usuario");

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

        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setColor(new java.awt.Color(158, 2, 113));
        btnCancelar.setColorOver(new java.awt.Color(119, 2, 86));
        btnCancelar.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFont(new java.awt.Font("Inria Sans", 1, 18)); // NOI18N
        btnCancelar.setHoverEnabled(true);
        btnCancelar.setRadius(20);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuadarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnGuadarUsuario.setText("Guardar");
        btnGuadarUsuario.setColor(new java.awt.Color(3, 155, 216));
        btnGuadarUsuario.setColorOver(new java.awt.Color(2, 127, 177));
        btnGuadarUsuario.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuadarUsuario.setFont(new java.awt.Font("Inria Sans", 1, 18)); // NOI18N
        btnGuadarUsuario.setHoverEnabled(true);
        btnGuadarUsuario.setRadius(20);
        btnGuadarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuadarUsuarioActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(92, 92, 92));
        jLabel7.setText("ID");

        lbIdUsuario.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        lbIdUsuario.setText("ID USUARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbIdUsuario))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbTipoUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnGuadarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdUsuario)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuadarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuadarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuadarUsuarioActionPerformed
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
        
        usuario.setNombre(txtNombre.getText());
        usuario.setUsuario(txtUsuario.getText());
        usuario.setPassword(String.valueOf(txtPassword.getPassword()));
        usuario.setTipoUsuario(itemSeleccionado);

        boolean editado = usuarioDAO.editarUsuario(usuario);

        if (editado) {
            JOptionPane.showMessageDialog(rootPane, "Usuario actualizado con éxito.");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error al actualizar usuario.");
        } 
        

    }//GEN-LAST:event_btnGuadarUsuarioActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Usuario usuarioPrueba = new Usuario();
                usuarioPrueba.setIdUsuario(1);
                usuarioPrueba.setNombre("Usuario de prueba");
                usuarioPrueba.setUsuario("usuarioprueba");
                usuarioPrueba.setPassword("passwordprueba");
                usuarioPrueba.setTipoUsuario("Usuario");
                usuarioPrueba.setFechaCreacion(new Date());
                
                EditarUsuario dialog = new EditarUsuario(new javax.swing.JFrame(), true, usuarioPrueba);
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
    private modelo.MyButton btnGuadarUsuario;
    private modelo.Combobox cbTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbIdUsuario;
    private modelo.MyTextField txtNombre;
    private modelo.MyPasswordField txtPassword;
    private modelo.MyTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
