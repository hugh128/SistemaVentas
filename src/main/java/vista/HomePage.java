package vista;

import conexion.ProductoDAO;
import java.awt.CardLayout;
import modelo.Usuario;
import conexion.ProveedorDAO;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import modelo.Proveedor;
import modelo.CheckBoxRenderer;
import modelo.CheckBoxEditor;
import modelo.Producto;
import table.EventAction;
import table.ScrollBar;
import table.StatusType;
import table.TableActionCellEditor;
import table.TableActionEvent;


public class HomePage extends javax.swing.JFrame {

    private Usuario usuario;
    private CardLayout card;
    private Login login;
    private ProveedorDAO proveedorDAO = new ProveedorDAO();
    private ProductoDAO productoDAO = new ProductoDAO();
    private DefaultTableModel modelo;
    
    public HomePage(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Home Page");
        verificarLogin(usuario);
        
        lbUsuario.setText(usuario.getNombreUsuario());
        card = (CardLayout)this.panelPrincipal.getLayout();
        
        configurarTablaProveedores();
        tbProveedores.getColumnModel().getColumn(0).setMaxWidth(35);
        tbProveedores.getColumnModel().getColumn(1).setMaxWidth(100);
        tbProveedores.getColumnModel().getColumn(4).setMaxWidth(120);
        tbProveedores.getColumnModel().getColumn(6).setMaxWidth(80);
        
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                Producto producto = obtenerProductoDesdeFila(row);
                EditarProducto editarProducto = new EditarProducto(null, true, producto);
                editarProducto.setVisible(true);
                System.out.println("Producto editado: " + producto.getNombre());
                
                mostrarProductos();
            }

            @Override
            public void onDelete(int row) {
                System.out.println("Delete row : " + row);
                Producto producto = obtenerProductoDesdeFila(row);
                int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar el producto: " + producto.getNombre() + "?", "Eliminar Producto", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    productoDAO.eliminarProducto(producto);
                    System.out.println("Producto eliminado: " + producto.getNombre());

                    mostrarProductos();
                }
                
            }
        };
        
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        tablaInventario.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
        
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
        btnUsuarios = new modelo.GradientButton();
        panelPrincipal = new javax.swing.JPanel();
        cardInicio = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cardClientes = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cardInventario = new javax.swing.JPanel();
        panel3 = new modelo.Panel();
        myTextField1 = new modelo.MyTextField();
        myButton1 = new modelo.MyButton();
        spTable = new javax.swing.JScrollPane();
        tablaInventario = new table.Table();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAgregarProducto = new modelo.Button();
        cardProveedores = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnEditarProveedor = new modelo.Button();
        panel4 = new modelo.Panel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProveedores = new javax.swing.JTable();
        btnAgregarProveedor = new modelo.Button();
        btnEliminarProveedor = new modelo.Button();
        cardVenta = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cardAcercaDe = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cardUsuarios = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbTotalUsuarios = new javax.swing.JLabel();
        spTablaUsuarios = new javax.swing.JScrollPane();
        tbUsuarios = new table.TablaUsuarios();
        btnNuevoUsuario = new modelo.MyButton();

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
        btnInicio.setText("   Inicio              ");
        btnInicio.setColor(new java.awt.Color(5, 12, 30));
        btnInicio.setColorOver(new java.awt.Color(11, 25, 64));
        btnInicio.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
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
        btnClientes.setText("   Clientes          ");
        btnClientes.setColor(new java.awt.Color(5, 12, 30));
        btnClientes.setColorOver(new java.awt.Color(11, 25, 64));
        btnClientes.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
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
        btnInventario.setText("   Inventario       ");
        btnInventario.setColor(new java.awt.Color(5, 12, 30));
        btnInventario.setColorOver(new java.awt.Color(11, 25, 64));
        btnInventario.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventario.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
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
        btnProveedores.setText("   Proveedores   ");
        btnProveedores.setColor(new java.awt.Color(5, 12, 30));
        btnProveedores.setColorOver(new java.awt.Color(11, 25, 64));
        btnProveedores.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedores.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
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
        btnVenta.setText("   Venta             ");
        btnVenta.setColor(new java.awt.Color(5, 12, 30));
        btnVenta.setColorOver(new java.awt.Color(11, 25, 64));
        btnVenta.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVenta.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
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
        btnAcercaDe.setText("   Acerca de      ");
        btnAcercaDe.setColor(new java.awt.Color(5, 12, 30));
        btnAcercaDe.setColorOver(new java.awt.Color(11, 25, 64));
        btnAcercaDe.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAcercaDe.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        btnAcercaDe.setGradientEndColor(new java.awt.Color(12, 0, 153));
        btnAcercaDe.setGradientStartColor(new java.awt.Color(20, 0, 255));
        btnAcercaDe.setHoverEnabled(true);
        btnAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercaDeActionPerformed(evt);
            }
        });

        btnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tdesign--user-setting.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setColor(new java.awt.Color(5, 12, 30));
        btnUsuarios.setColorOver(new java.awt.Color(11, 25, 64));
        btnUsuarios.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setFont(new java.awt.Font("Inria Sans", 0, 20)); // NOI18N
        btnUsuarios.setGradientEndColor(new java.awt.Color(6, 17, 97));
        btnUsuarios.setGradientStartColor(new java.awt.Color(120, 2, 6));
        btnUsuarios.setHoverEnabled(true);
        btnUsuarios.setRadius(20);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAcercaDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(78, 78, 78))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(134, 134, 134)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
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
        panel3.setRoundTopLeft(20);
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myTextField1.setForeground(new java.awt.Color(128, 128, 128));
        myTextField1.setText("Buscar un producto");
        myTextField1.setBorderColor(new java.awt.Color(128, 128, 128));
        myTextField1.setBorderEnabled(true);
        myTextField1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        myTextField1.setRadius(10);
        panel3.add(myTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 22, 300, 35));

        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fe--search (2).png"))); // NOI18N
        myButton1.setBorderColor(new java.awt.Color(128, 128, 128));
        myButton1.setBorderEnabled(true);
        myButton1.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        myButton1.setRadius(10);
        panel3.add(myButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 22, 50, 35));

        spTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Marca", "Precio", "Cantidad", "Categoria", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(tablaInventario);

        panel3.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 910, 480));

        cardInventario.add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 950, 575));

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

        cardProveedores.setBackground(new java.awt.Color(248, 248, 248));
        cardProveedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Inria Sans", 1, 24)); // NOI18N
        jLabel12.setText("Proveedores");
        cardProveedores.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 33, -1, -1));

        jLabel13.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        jLabel13.setText("Dasboard / Proveedores");
        cardProveedores.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 66, -1, -1));

        btnEditarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eva--edit-2-outline.png"))); // NOI18N
        btnEditarProveedor.setText("Editar");
        btnEditarProveedor.setColor(new java.awt.Color(79, 166, 243));
        btnEditarProveedor.setColorOver(new java.awt.Color(39, 144, 249));
        btnEditarProveedor.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditarProveedor.setHoverEnabled(true);
        btnEditarProveedor.setRadius(10);
        btnEditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedorActionPerformed(evt);
            }
        });
        cardProveedores.add(btnEditarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 125, 40));

        panel4.setBackground(new java.awt.Color(255, 255, 255));
        panel4.setRoundBottomLeft(20);
        panel4.setRoundBottomRight(20);
        panel4.setRoundTopLeft(20);
        panel4.setRoundTopRight(20);
        panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(128, 128, 128));
        jLabel14.setText("Mostrando 1 de 10 registros");
        panel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, -1, -1));

        tbProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NIT", "Nombre", "Direccion", "Telefono", "Email", "Acciones"
            }
        ));
        tbProveedores.setFocusable(false);
        tbProveedores.setGridColor(new java.awt.Color(255, 255, 255));
        tbProveedores.setOpaque(false);
        tbProveedores.setRowHeight(25);
        tbProveedores.setSelectionBackground(new java.awt.Color(233, 233, 233));
        tbProveedores.setShowGrid(false);
        tbProveedores.getTableHeader().setResizingAllowed(false);
        tbProveedores.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbProveedores);

        panel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, 850, 480));

        cardProveedores.add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 110, 895, 550));

        btnAgregarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload-outline.png"))); // NOI18N
        btnAgregarProveedor.setText("Agregar Proveedor");
        btnAgregarProveedor.setColor(new java.awt.Color(243, 156, 79));
        btnAgregarProveedor.setColorOver(new java.awt.Color(228, 115, 16));
        btnAgregarProveedor.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregarProveedor.setHoverEnabled(true);
        btnAgregarProveedor.setRadius(10);
        btnAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedorActionPerformed(evt);
            }
        });
        cardProveedores.add(btnAgregarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 175, 40));

        btnEliminarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete-outline.png"))); // NOI18N
        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.setColor(new java.awt.Color(243, 79, 84));
        btnEliminarProveedor.setColorOver(new java.awt.Color(222, 79, 84));
        btnEliminarProveedor.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEliminarProveedor.setHoverEnabled(true);
        btnEliminarProveedor.setRadius(10);
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });
        cardProveedores.add(btnEliminarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 40, 125, 40));

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Inria Sans", 1, 20)); // NOI18N
        jLabel15.setText("Todos los usuarios");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 135, -1, -1));

        jLabel16.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        jLabel16.setText("Administre los miembros de su equipo y los permisos de sus cuentas aqui");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 65, -1, -1));

        jLabel17.setFont(new java.awt.Font("Inria Sans", 1, 24)); // NOI18N
        jLabel17.setText("Gestion de usuarios");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 25, -1, -1));

        lbTotalUsuarios.setFont(new java.awt.Font("Inria Sans", 1, 24)); // NOI18N
        lbTotalUsuarios.setForeground(new java.awt.Color(128, 128, 130));
        lbTotalUsuarios.setText("0");
        jPanel2.add(lbTotalUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 135, -1, -1));

        spTablaUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Usuario", "Tipo", "Fecha Agreado", "Acciones"
            }
        ));
        spTablaUsuarios.setViewportView(tbUsuarios);

        jPanel2.add(spTablaUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 870, 440));

        btnNuevoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic--baseline-add.png"))); // NOI18N
        btnNuevoUsuario.setText("Nuevo Usuario");
        btnNuevoUsuario.setColor(new java.awt.Color(31, 31, 32));
        btnNuevoUsuario.setColorOver(new java.awt.Color(0, 0, 0));
        btnNuevoUsuario.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoUsuario.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnNuevoUsuario.setHoverEnabled(true);
        btnNuevoUsuario.setRadius(20);
        jPanel2.add(btnNuevoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 135, 190, 45));

        javax.swing.GroupLayout cardUsuariosLayout = new javax.swing.GroupLayout(cardUsuarios);
        cardUsuarios.setLayout(cardUsuariosLayout);
        cardUsuariosLayout.setHorizontalGroup(
            cardUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardUsuariosLayout.setVerticalGroup(
            cardUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelPrincipal.add(cardUsuarios, "usuarios");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        mostrarProductos();
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
        limpiarTabla();
        mostrarProveedores();
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        actualizarBotones(btnInicio);
        card.show(panelPrincipal, "inicio");
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        AgregarProducto agregarProducto = new AgregarProducto(this, true);
        agregarProducto.setVisible(true);
        mostrarProductos();
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedorActionPerformed
        
        
        int filaSeleccionada = tbProveedores.getSelectedRow();
    
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un proveedor para editar.");
            return;
        }

        int idProveedor = (int) tbProveedores.getValueAt(filaSeleccionada, 0);
        int nit = (int) tbProveedores.getValueAt(filaSeleccionada, 1);
        String nombre = (String) tbProveedores.getValueAt(filaSeleccionada, 2);
        String direccion = (String) tbProveedores.getValueAt(filaSeleccionada, 3);
        String telefono = (String) tbProveedores.getValueAt(filaSeleccionada, 4);
        String email = (String) tbProveedores.getValueAt(filaSeleccionada, 5);

        Proveedor proveedor = new Proveedor(idProveedor, nit, nombre, direccion, telefono, email);

        EditarProveedor dialog = new EditarProveedor(this, true, proveedor);
        dialog.setVisible(true);
        limpiarTabla();
        mostrarProveedores();
        
        
    }//GEN-LAST:event_btnEditarProveedorActionPerformed

    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        AgregarProveedor agregarProveedor = new AgregarProveedor(this, true);
        agregarProveedor.setVisible(true);
        limpiarTabla();
        mostrarProveedores();
    }//GEN-LAST:event_btnAgregarProveedorActionPerformed

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
        int filaSeleccionada = tbProveedores.getSelectedRow();

        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un proveedor para eliminar.");
            return;
        }

        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este proveedor?", "Confirmar eliminación", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirmacion == javax.swing.JOptionPane.NO_OPTION) {
            return;
        }

        int idProveedor = (int) tbProveedores.getValueAt(filaSeleccionada, 0);
        int nit = (int) tbProveedores.getValueAt(filaSeleccionada, 1);
        String nombre = (String) tbProveedores.getValueAt(filaSeleccionada, 2);
        String direccion = (String) tbProveedores.getValueAt(filaSeleccionada, 3);
        String telefono = (String) tbProveedores.getValueAt(filaSeleccionada, 4);
        String email = (String) tbProveedores.getValueAt(filaSeleccionada, 5);

        Proveedor proveedor = new Proveedor(idProveedor, nit, nombre, direccion, telefono, email);

        boolean eliminado = proveedorDAO.eliminarProveedor(proveedor);

        if (eliminado) {
            javax.swing.JOptionPane.showMessageDialog(this, "Proveedor eliminado con éxito.");
            limpiarTabla();
            mostrarProveedores();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar el proveedor.");
        }
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        actualizarBotones(btnUsuarios);
        card.show(panelPrincipal, "usuarios");
    }//GEN-LAST:event_btnUsuariosActionPerformed

    public static void main(String args[]) {       
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("Nombre Usuario");
        usuario.setTipoUsuario("administrador");
        
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
        
        btnUsuarios.setGradientEnabled(false);
        btnUsuarios.setHoverEnabled(true);

        botonActivado.setGradientEnabled(true);
        botonActivado.setHoverEnabled(false);
    }

    // Productos
    public void mostrarProductos() {
        tablaInventario.clearTable();
        List<Producto> Productos = productoDAO.obtenerProductos();
        for (Producto producto : Productos) {
                String categoria = producto.getCategoria();
                StatusType estado;
                if (esCategoriaValida(categoria)) {
                    estado = StatusType.valueOf(categoria.toUpperCase());
                } else {
                    estado = StatusType.UNKNOWN;
                }
            
            tablaInventario.addRow(new Object[]{
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getMarca(),  
                producto.getPrecio(),          
                producto.getCantidad(),
                estado
            });
        }
    }
    
    private boolean esCategoriaValida(String categoria) {
        for (StatusType status : StatusType.values()) {
            if (status.name().equalsIgnoreCase(categoria)) {
                return true;
            }
        }
        return false;
    }
    
    public Producto obtenerProductoDesdeFila(int row) {
        int idProducto = Integer.parseInt(tablaInventario.getValueAt(row, 0).toString());
        String nombre = tablaInventario.getValueAt(row, 1).toString();
        String marca = tablaInventario.getValueAt(row, 2).toString();
        String categoria = tablaInventario.getValueAt(row, 5).toString();
        float precio = Float.parseFloat(tablaInventario.getValueAt(row, 3).toString());
        int cantidad = Integer.parseInt(tablaInventario.getValueAt(row, 4).toString());

        return new Producto(idProducto, nombre, marca, categoria, precio, cantidad);
    }


    public void mostrarProveedores() {
        List<Proveedor> Proveedores = proveedorDAO.obtenerProveedores();
        modelo = (DefaultTableModel) tbProveedores.getModel();
        Object[] ob = new Object[7];
        for (Proveedor proveedor : Proveedores) {
            ob[0] = proveedor.getIdProveedor();
            ob[1] = proveedor.getNit();
            ob[2] = proveedor.getNombre();
            ob[3] = proveedor.getDireccion();
            ob[4] = proveedor.getTelefono();
            ob[5] = proveedor.getEmail();
            ob[6] = false;
            modelo.addRow(ob);
        }
    }
    
    public void limpiarTabla() {
        modelo.setRowCount(0);
    }
    
    private void configurarTablaProveedores() {
        tbProveedores.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tbProveedores.getTableHeader().setOpaque(false);
        tbProveedores.getTableHeader().setBackground(new Color(32, 136, 203));
        tbProveedores.getTableHeader().setForeground(new Color(255, 255, 255));
        tbProveedores.setRowHeight(25);
        
        modelo = new DefaultTableModel(new Object[]{"ID", "NIT", "Nombre", "Dirección", "Teléfono", "Email", "Seleccion"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 6) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };
        tbProveedores.setModel(modelo);

        tbProveedores.getColumnModel().getColumn(6).setCellRenderer(new CheckBoxRenderer());
        tbProveedores.getColumnModel().getColumn(6).setCellEditor(new CheckBoxEditor(tbProveedores));
        
        // Selecciona checkbox al selecionar una fila
        tbProveedores.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = tbProveedores.getSelectedRow();
                if (selectedRow >= 0) {
                    boolean currentValue = (Boolean) tbProveedores.getValueAt(selectedRow, 6);
                    tbProveedores.setValueAt(!currentValue, selectedRow, 6);

                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        if (i != selectedRow) {
                            modelo.setValueAt(false, i, 6);
                        }
                    }
                    
                    if (tbProveedores.getCellEditor() != null) {
                        tbProveedores.getCellEditor().stopCellEditing();
                    }
                }
            }
        });
        
    }
    
    
    public void verificarLogin(Usuario usuario) {
        String rolUsuario = usuario.getTipoUsuario();
        System.out.println(rolUsuario);

        if (rolUsuario.equals("administrador")) {
            btnUsuarios.setVisible(true);
        } else {
            btnUsuarios.setVisible(false);
        }
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private modelo.GradientButton btnAcercaDe;
    private modelo.Button btnAgregarProducto;
    private modelo.Button btnAgregarProveedor;
    private modelo.GradientButton btnClientes;
    private modelo.Button btnEditarProveedor;
    private modelo.Button btnEliminarProveedor;
    private modelo.GradientButton btnInicio;
    private modelo.GradientButton btnInventario;
    private modelo.MyButton btnNuevoUsuario;
    private modelo.GradientButton btnProveedores;
    private modelo.Button btnSalir;
    private modelo.GradientButton btnUsuarios;
    private modelo.GradientButton btnVenta;
    private javax.swing.JPanel cardAcercaDe;
    private javax.swing.JPanel cardClientes;
    private javax.swing.JPanel cardInicio;
    private javax.swing.JPanel cardInventario;
    private javax.swing.JPanel cardProveedores;
    private javax.swing.JPanel cardUsuarios;
    private javax.swing.JPanel cardVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbTotalUsuarios;
    private javax.swing.JLabel lbUsuario;
    private modelo.MyButton myButton1;
    private modelo.MyTextField myTextField1;
    private modelo.Panel panel1;
    private modelo.Panel panel3;
    private modelo.Panel panel4;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane spTablaUsuarios;
    private javax.swing.JScrollPane spTable;
    private table.Table tablaInventario;
    private javax.swing.JTable tbProveedores;
    private table.TablaUsuarios tbUsuarios;
    // End of variables declaration//GEN-END:variables
}
