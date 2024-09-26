package vista;

import modelo.Usuario;

public class HomePage extends javax.swing.JFrame {

    private Usuario usuario;
    
    public HomePage(Usuario usuario) {    
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Home Page");
        
        lbUsuario.setText(usuario.getNombreUsuario());
        // Añadir componentes a la ventana principal
        /*javax.swing.JLabel lblUsuario = new javax.swing.JLabel("Bienvenido, " + usuario.getNombreUsuario());
        lblUsuario.setFont(new java.awt.Font("Inria Sans", 1, 24)); // Estilo del texto
        add(lblUsuario); // Agrega el JLabel a la ventana*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new modelo.Button();
        btnInicio = new modelo.GradientButton();
        btnClientes = new modelo.GradientButton();
        btnAlmacen = new modelo.GradientButton();
        btnProveedores = new modelo.GradientButton();
        btnVenta = new modelo.GradientButton();
        btnAcercaDe = new modelo.GradientButton();
        panel1 = new modelo.Panel();
        lbUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 750));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        jPanel1.setBackground(new java.awt.Color(5, 12, 30));

        jLabel1.setFont(new java.awt.Font("Inria Sans", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(228, 235, 245));
        jLabel1.setText("DashBoard");

        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setColor(new java.awt.Color(201, 37, 51));
        btnSalir.setColorOver(new java.awt.Color(243, 36, 43));
        btnSalir.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setFont(new java.awt.Font("Inria Sans", 1, 20)); // NOI18N
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setHoverEnabled(true);
        btnSalir.setRadius(20);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ion--home.png"))); // NOI18N
        btnInicio.setText("    Inicio                  ");
        btnInicio.setColor(new java.awt.Color(5, 12, 30));
        btnInicio.setColorOver(new java.awt.Color(11, 25, 64));
        btnInicio.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.setFont(new java.awt.Font("Inria Sans", 0, 20)); // NOI18N
        btnInicio.setGradientEnabled(true);
        btnInicio.setGradientEndColor(new java.awt.Color(12, 0, 153));
        btnInicio.setGradientStartColor(new java.awt.Color(20, 0, 255));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ion--person.png"))); // NOI18N
        btnClientes.setText("    Clientes            ");
        btnClientes.setColor(new java.awt.Color(5, 12, 30));
        btnClientes.setColorOver(new java.awt.Color(11, 25, 64));
        btnClientes.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setFont(new java.awt.Font("Inria Sans", 0, 20)); // NOI18N
        btnClientes.setGradientEndColor(new java.awt.Color(12, 0, 153));
        btnClientes.setGradientStartColor(new java.awt.Color(20, 0, 255));
        btnClientes.setHoverEnabled(true);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        btnAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tabler--cube.png"))); // NOI18N
        btnAlmacen.setText("    Almacen           ");
        btnAlmacen.setColor(new java.awt.Color(5, 12, 30));
        btnAlmacen.setColorOver(new java.awt.Color(11, 25, 64));
        btnAlmacen.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlmacen.setFont(new java.awt.Font("Inria Sans", 0, 20)); // NOI18N
        btnAlmacen.setGradientEndColor(new java.awt.Color(12, 0, 153));
        btnAlmacen.setGradientStartColor(new java.awt.Color(20, 0, 255));
        btnAlmacen.setHoverEnabled(true);
        btnAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlmacenActionPerformed(evt);
            }
        });

        btnProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/weui--email-filled.png"))); // NOI18N
        btnProveedores.setText("    Proveedores   ");
        btnProveedores.setColor(new java.awt.Color(5, 12, 30));
        btnProveedores.setColorOver(new java.awt.Color(11, 25, 64));
        btnProveedores.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedores.setFont(new java.awt.Font("Inria Sans", 0, 20)); // NOI18N
        btnProveedores.setGradientEndColor(new java.awt.Color(12, 0, 153));
        btnProveedores.setGradientStartColor(new java.awt.Color(20, 0, 255));
        btnProveedores.setHoverEnabled(true);
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mdi--shopping-outline.png"))); // NOI18N
        btnVenta.setText("    Venta                 ");
        btnVenta.setColor(new java.awt.Color(5, 12, 30));
        btnVenta.setColorOver(new java.awt.Color(11, 25, 64));
        btnVenta.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVenta.setFont(new java.awt.Font("Inria Sans", 0, 20)); // NOI18N
        btnVenta.setGradientEndColor(new java.awt.Color(12, 0, 153));
        btnVenta.setGradientStartColor(new java.awt.Color(20, 0, 255));
        btnVenta.setHoverEnabled(true);
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        btnAcercaDe.setForeground(new java.awt.Color(255, 255, 255));
        btnAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bi--exclamation-circle.png"))); // NOI18N
        btnAcercaDe.setText("    Acerca de         ");
        btnAcercaDe.setColor(new java.awt.Color(5, 12, 30));
        btnAcercaDe.setColorOver(new java.awt.Color(11, 25, 64));
        btnAcercaDe.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAcercaDe.setFont(new java.awt.Font("Inria Sans", 0, 20)); // NOI18N
        btnAcercaDe.setGradientEndColor(new java.awt.Color(12, 0, 153));
        btnAcercaDe.setGradientStartColor(new java.awt.Color(20, 0, 255));
        btnAcercaDe.setHoverEnabled(true);
        btnAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercaDeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlmacen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAcercaDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(164, 164, 164)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setRoundBottomLeft(10);
        panel1.setRoundTopLeft(10);

        lbUsuario.setFont(new java.awt.Font("Inria Sans", 0, 20)); // NOI18N
        lbUsuario.setText("Nombre Usuario");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(655, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lbUsuario)
                .addGap(76, 76, 76))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbUsuario))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercaDeActionPerformed
        actualizarBotones(btnAcercaDe);
    }//GEN-LAST:event_btnAcercaDeActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        actualizarBotones(btnVenta);
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlmacenActionPerformed
        actualizarBotones(btnAlmacen);
    }//GEN-LAST:event_btnAlmacenActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        actualizarBotones(btnClientes);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        actualizarBotones(btnProveedores);
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        actualizarBotones(btnInicio);
    }//GEN-LAST:event_btnInicioActionPerformed

    public static void main(String args[]) {
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });*/
        
        // Supongamos que tienes un usuario para pasar al constructor
        Usuario usuario = new Usuario(); // Crear una instancia de Usuario
        usuario.setNombreUsuario("NombreDelUsuario"); // Establece un nombre de usuario para la prueba
        
        java.awt.EventQueue.invokeLater(() -> {
            new HomePage(usuario).setVisible(true);
        });
    
    /*public static void iniciar(Usuario usuario) {
        java.awt.EventQueue.invokeLater(() -> {
            new HomePage(usuario).setVisible(true);
        });*/
    }
    
    private void actualizarBotones(modelo.GradientButton botonActivado) {
        btnInicio.setGradientEnabled(false);
        btnInicio.setHoverEnabled(true);

        btnClientes.setGradientEnabled(false);
        btnClientes.setHoverEnabled(true);

        btnAlmacen.setGradientEnabled(false);
        btnAlmacen.setHoverEnabled(true);

        btnProveedores.setGradientEnabled(false);
        btnProveedores.setHoverEnabled(true);

        btnVenta.setGradientEnabled(false);
        btnVenta.setHoverEnabled(true);

        btnAcercaDe.setGradientEnabled(false);
        btnAcercaDe.setHoverEnabled(true);

        botonActivado.setGradientEnabled(true);
        botonActivado.setHoverEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private modelo.GradientButton btnAcercaDe;
    private modelo.GradientButton btnAlmacen;
    private modelo.GradientButton btnClientes;
    private modelo.GradientButton btnInicio;
    private modelo.GradientButton btnProveedores;
    private modelo.Button btnSalir;
    private modelo.GradientButton btnVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbUsuario;
    private modelo.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
