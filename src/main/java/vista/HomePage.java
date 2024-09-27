package vista;

import java.awt.CardLayout;
import modelo.Usuario;

public class HomePage extends javax.swing.JFrame {

    private Usuario usuario;
    private CardLayout card;
    private Login login;
    
    public HomePage(Usuario usuario) {  
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Home Page");
        
        lbUsuario.setText(usuario.getNombreUsuario());
        card = (CardLayout)this.panelPrincipal.getLayout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        panel1 = new modelo.Panel();
        lbUsuario = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new modelo.Button();
        btnInicio = new modelo.GradientButton();
        btnClientes = new modelo.GradientButton();
        btnInventario = new modelo.GradientButton();
        btnProveedores = new modelo.GradientButton();
        btnVenta = new modelo.GradientButton();
        btnAcercaDe = new modelo.GradientButton();
        panelPrincipal = new javax.swing.JPanel();
        cardInicio = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cardClientes = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cardInventario = new javax.swing.JPanel();
        panel3 = new modelo.Panel();
        btnBuscarProducto = new modelo.Button();
        btnFiltroProducto = new modelo.Button();
        txtBuscarProducto = new modelo.TextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAgregarProducto = new modelo.Button();
        cardProveedores = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cardVenta = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cardAcercaDe = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 750));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setRoundBottomLeft(10);
        panel1.setRoundTopLeft(10);
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbUsuario.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        lbUsuario.setText("Nombre Usuario");
        panel1.add(lbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(743, 17, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        panel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 6, -1, -1));

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

        btnInventario.setForeground(new java.awt.Color(255, 255, 255));
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tabler--cube.png"))); // NOI18N
        btnInventario.setText("    Inventario       ");
        btnInventario.setColor(new java.awt.Color(5, 12, 30));
        btnInventario.setColorOver(new java.awt.Color(11, 25, 64));
        btnInventario.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventario.setFont(new java.awt.Font("Inria Sans", 0, 20)); // NOI18N
        btnInventario.setGradientEndColor(new java.awt.Color(12, 0, 153));
        btnInventario.setGradientStartColor(new java.awt.Color(20, 0, 255));
        btnInventario.setHoverEnabled(true);
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
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
                    .addComponent(btnInventario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        panelPrincipal.setBackground(new java.awt.Color(153, 204, 255));
        panelPrincipal.setLayout(new java.awt.CardLayout());

        cardInicio.setBackground(new java.awt.Color(153, 204, 255));
        cardInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Inria Sans", 1, 48)); // NOI18N
        jLabel3.setText("Inicio");
        cardInicio.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 273, -1, -1));

        panelPrincipal.add(cardInicio, "inicio");

        cardClientes.setBackground(new java.awt.Color(204, 255, 204));
        cardClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Inria Sans", 1, 48)); // NOI18N
        jLabel4.setText("Clientes");
        cardClientes.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 269, -1, -1));

        panelPrincipal.add(cardClientes, "clientes");

        cardInventario.setBackground(new java.awt.Color(248, 248, 248));
        cardInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel3.setBackground(new java.awt.Color(255, 255, 255));
        panel3.setRoundBottomLeft(20);
        panel3.setRoundBottomRight(20);
        panel3.setRoundTopLeft(20);
        panel3.setRoundTopRight(20);
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconamoon--search-fill.png"))); // NOI18N
        btnBuscarProducto.setBorderColor(new java.awt.Color(225, 227, 229));
        btnBuscarProducto.setBorderEnabled(true);
        btnBuscarProducto.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProducto.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        btnBuscarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarProducto.setRadius(10);
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        panel3.add(btnBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 50, 35));

        btnFiltroProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rivet-icons--filter-solid.png"))); // NOI18N
        btnFiltroProducto.setText(" filtro");
        btnFiltroProducto.setBorderColor(new java.awt.Color(225, 227, 229));
        btnFiltroProducto.setBorderEnabled(true);
        btnFiltroProducto.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiltroProducto.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        btnFiltroProducto.setRadius(10);
        panel3.add(btnFiltroProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 20, 100, 35));

        txtBuscarProducto.setForeground(new java.awt.Color(144, 147, 149));
        txtBuscarProducto.setText("Busca un producto aqui");
        txtBuscarProducto.setBorderColor(new java.awt.Color(225, 227, 229));
        txtBuscarProducto.setBorderColorOnFocus(new java.awt.Color(0, 153, 255));
        txtBuscarProducto.setBorderEnabled(true);
        txtBuscarProducto.setFocusColorEnabled(true);
        txtBuscarProducto.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        txtBuscarProducto.setRadius(10);
        panel3.add(txtBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 20, 250, 35));

        jLabel11.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(128, 128, 128));
        jLabel11.setText("Mostrando 1 de 10 registros");
        panel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        panel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 80, 850, 430));

        cardInventario.add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 110, 895, 550));

        jLabel5.setFont(new java.awt.Font("Inria Sans", 1, 24)); // NOI18N
        jLabel5.setText("Inventario");
        cardInventario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 33, -1, -1));

        jLabel10.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        jLabel10.setText("Dasboard / Inventario");
        cardInventario.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 66, -1, -1));

        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload-outline.png"))); // NOI18N
        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.setColor(new java.awt.Color(9, 152, 233));
        btnAgregarProducto.setColorOver(new java.awt.Color(8, 127, 195));
        btnAgregarProducto.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregarProducto.setHoverEnabled(true);
        btnAgregarProducto.setRadius(10);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        cardInventario.add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 170, 40));

        panelPrincipal.add(cardInventario, "inventario");

        cardProveedores.setBackground(new java.awt.Color(204, 255, 255));
        cardProveedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Inria Sans", 1, 48)); // NOI18N
        jLabel6.setText("Proveedores");
        cardProveedores.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 270, -1, -1));

        panelPrincipal.add(cardProveedores, "proveedores");

        cardVenta.setBackground(new java.awt.Color(153, 255, 204));
        cardVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Inria Sans", 1, 48)); // NOI18N
        jLabel7.setText("Venta");
        cardVenta.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 270, -1, -1));

        panelPrincipal.add(cardVenta, "venta");

        cardAcercaDe.setBackground(new java.awt.Color(255, 204, 255));
        cardAcercaDe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Inria Sans", 1, 48)); // NOI18N
        jLabel8.setText("Acerca de");
        cardAcercaDe.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 269, -1, -1));

        panelPrincipal.add(cardAcercaDe, "acercaDe");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(262, 262, 262))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercaDeActionPerformed
        actualizarBotones(btnAcercaDe);
        card.show(panelPrincipal, "acercaDe");
    }//GEN-LAST:event_btnAcercaDeActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        actualizarBotones(btnVenta);
        card.show(panelPrincipal, "venta");
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        actualizarBotones(btnInventario);
        card.show(panelPrincipal, "inventario");
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        actualizarBotones(btnClientes);
        card.show(panelPrincipal, "clientes");
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        actualizarBotones(btnProveedores);
        card.show(panelPrincipal, "proveedores");
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        actualizarBotones(btnInicio);
        card.show(panelPrincipal, "inicio");
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    public static void main(String args[]) {       
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("Nombre Usuario");
        
        java.awt.EventQueue.invokeLater(() -> {
            new HomePage(usuario).setVisible(true);
        });
    }
    
    private void actualizarBotones(modelo.GradientButton botonActivado) {
        btnInicio.setGradientEnabled(false);
        btnInicio.setHoverEnabled(true);

        btnClientes.setGradientEnabled(false);
        btnClientes.setHoverEnabled(true);

        btnInventario.setGradientEnabled(false);
        btnInventario.setHoverEnabled(true);

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
    private modelo.Button btnAgregarProducto;
    private modelo.Button btnBuscarProducto;
    private modelo.GradientButton btnClientes;
    private modelo.Button btnFiltroProducto;
    private modelo.GradientButton btnInicio;
    private modelo.GradientButton btnInventario;
    private modelo.GradientButton btnProveedores;
    private modelo.Button btnSalir;
    private modelo.GradientButton btnVenta;
    private javax.swing.JPanel cardAcercaDe;
    private javax.swing.JPanel cardClientes;
    private javax.swing.JPanel cardInicio;
    private javax.swing.JPanel cardInventario;
    private javax.swing.JPanel cardProveedores;
    private javax.swing.JPanel cardVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbUsuario;
    private modelo.Panel panel1;
    private modelo.Panel panel3;
    private javax.swing.JPanel panelPrincipal;
    private modelo.TextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables
}
