package vista;

import com.itextpdf.text.BaseColor;
import conexion.ProductoDAO;
import java.awt.CardLayout;
import modelo.Usuario;
import conexion.ProveedorDAO;
import conexion.UsuarioDAO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import table.ScrollBar;
import table.StatusType;
import table.UserType;
import table.TableActionCellEditor;
import table.TableActionCellEditorUser;
import table.TableActionEvent;
import table.TableActionEventUser;
import conexion.ClienteDAO;
import conexion.VentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import modelo.Cliente;
import modelo.CardHome;
import modelo.Proveedor;
import modelo.Venta;
import table.TableActionCellEditorCliente;
import table.TableActionCellEditorProveedor;
import table.TableActionEventCliente;
import table.TableActionEventProveedor;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class HomePage extends javax.swing.JFrame {

    private Usuario usuario;
    private CardLayout card;
    private Login login;
    private ProveedorDAO proveedorDAO = new ProveedorDAO();
    private ProductoDAO productoDAO = new ProductoDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private VentaDAO ventaDAO = new VentaDAO();
    private Venta venta;
    private DefaultTableModel modelo;
    
    public HomePage(Usuario usuario) {
        this.usuario = usuario;
        int idUsuarioActual = usuario.getIdUsuario();
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Home Page");
        verificarLogin(usuario);
        lbUsuario.setText(usuario.getNombre());
        JPanel p = new JPanel();

        card1.setData(new CardHome(new ImageIcon(getClass().getResource("/images/coins.png")), "Stock Total", "+300", "Aumentó un 60%"));
        card2.setData(new CardHome(new ImageIcon(getClass().getResource("/images/chart-histogram.png")), "Total de Ganancias", "Q.15000", "Aumentó un 15%"));
        card3.setData(new CardHome(new ImageIcon(getClass().getResource("/images/users-alt.png")), "Nuevos Clientes", "+20", "Aumentó un 70%"));
        
        card = (CardLayout)this.panelPrincipal.getLayout();
        
        // Tabla de proveedores
        TableActionEventProveedor eventProveedor = new TableActionEventProveedor() {
            @Override
            public void onEditProveedor(int row) {
                System.out.println("Edit row : " + row);
                Proveedor proveedor = obtenerProveedorDesdeFila(row);
                EditarProveedor editarProveedor = new EditarProveedor(null, true, proveedor);
                editarProveedor.setVisible(true);
                System.out.println("Producto editado: " + proveedor.getNombre());
                
                mostrarProveedores();
            }

            @Override
            public void onDeleteProveedor(int row) {
                if (row >= 0 && row < tbProveedores.getRowCount()) {
                    System.out.println("Delete row : " + row);

                    if (tbProveedores.isEditing()) {
                        tbProveedores.getCellEditor().stopCellEditing();
                    }
                    
                    Proveedor proveedor = obtenerProveedorDesdeFila(row);
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar al proveedor: " + proveedor.getNombre() + "?", "Eliminar Proveedor", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        proveedorDAO.eliminarProveedor(proveedor);
                        System.out.println("Proveedor eliminado: " + proveedor.getNombre());

                        DefaultTableModel model = (DefaultTableModel) tbProveedores.getModel();
                        model.removeRow(row);
                        int totalRegistros = model.getRowCount();
                        lbTotalProveedores.setText(String.valueOf(totalRegistros));
                        model.fireTableDataChanged();
                    }
                } else {
                    System.out.println("Indice de fila no valido: " + row);
                }
            }
        };
        
        spTablaProveedores.setVerticalScrollBar(new ScrollBar());
        spTablaProveedores.getVerticalScrollBar().setBackground(Color.WHITE);
        spTablaProveedores.getViewport().setBackground(Color.WHITE);
        p.setBackground(Color.WHITE);
        spTablaProveedores.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        tbProveedores.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditorProveedor(eventProveedor));
        
        
        // Tabla de productos
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
                if (row >= 0 && row < tablaInventario.getRowCount()) {
                    System.out.println("Delete row : " + row);

                    if (tablaInventario.isEditing()) {
                        tablaInventario.getCellEditor().stopCellEditing();
                    }
                    
                    Producto producto = obtenerProductoDesdeFila(row);
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar el producto: " + producto.getNombre() + "?", "Eliminar Producto", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        productoDAO.eliminarProducto(producto);
                        System.out.println("Producto eliminado: " + producto.getNombre());

                        DefaultTableModel model = (DefaultTableModel) tablaInventario.getModel();
                        model.removeRow(row);
                        int totalRegistros = model.getRowCount();
                        lbTotalProductos.setText(String.valueOf(totalRegistros));
                        model.fireTableDataChanged();
                    }
                } else {
                    System.out.println("Indice de fila no valido: " + row);
                }
            }
        };
        
               
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        tablaInventario.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
        
        // Tabla de Usuarios
        TableActionEventUser eventUser = new TableActionEventUser() {
            @Override
            public void onEditUser(int row) {
                System.out.println("Edit row : " + row);
                Usuario usuarioAEditar = obtenerUsuarioPorFila(row);
                EditarUsuario editarUsuario = new EditarUsuario(null, true, usuarioAEditar);
                editarUsuario.setVisible(true);
                System.out.println("Usuario editado: " + usuario.getNombre());             
                mostrarUsuarios();
            }
            
            @Override
            public void onDeleteUser(int row) {
                if (row >= 0 && row < tbUsuarios.getRowCount()) {
                    System.out.println("Delete row : " + row);

                    if (tbUsuarios.isEditing()) {
                        tbUsuarios.getCellEditor().stopCellEditing();
                    }
                    
                    Usuario usuarioAEliminar = obtenerUsuarioPorFila(row);
                    if (usuarioAEliminar.getIdUsuario() == idUsuarioActual) {
                        JOptionPane.showMessageDialog(null, "No puedes eliminar tu propio usuario.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    } 
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar el usuario: " + usuarioAEliminar.getUsuario() + "?", "Eliminar usuario", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        usuarioDAO.eliminarUsuario(usuarioAEliminar);
                        System.out.println("Usuario eliminado: " + usuarioAEliminar.getNombre());

                        DefaultTableModel model = (DefaultTableModel) tbUsuarios.getModel();
                        model.removeRow(row);
                        int totalRegistros = model.getRowCount();
                        lbTotalUsuarios.setText(String.valueOf(totalRegistros));
                        model.fireTableDataChanged();
                    }
                } else {
                    System.out.println("Indice de fila no valido: " + row);
                }
            }
        };
        
        spTablaUsuarios.setVerticalScrollBar(new ScrollBar());
        spTablaUsuarios.getVerticalScrollBar().setBackground(Color.WHITE);
        spTablaUsuarios.getViewport().setBackground(Color.WHITE); // Color fondo de tabla
        p.setBackground(Color.WHITE);
        spTablaUsuarios.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        tbUsuarios.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditorUser(eventUser));
        
        // Tabla Ventas
        spTablaVentas.setVerticalScrollBar(new ScrollBar());
        spTablaVentas.getVerticalScrollBar().setBackground(Color.WHITE);
        spTablaVentas.getViewport().setBackground(Color.WHITE);
        p.setBackground(Color.WHITE);
        spTablaVentas.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        // Tabla Usuarios
        TableActionEventCliente eventCliente = new TableActionEventCliente() {
            @Override
            public void onEditCliente(int row) {
                System.out.println("Edit row : " + row);
                Cliente cliente = obtenerClienteDesdeFila(row);
                EditarCliente editarCliente = new EditarCliente(null, true, cliente);
                editarCliente.setVisible(true);
                System.out.println("Cliente editado: " + cliente.getNombre());
                
                mostrarClientes();
            }

            @Override
            public void onDeleteCliente(int row) {
                if (row >= 0 && row < tbClientes.getRowCount()) {
                    System.out.println("Delete row : " + row);

                    if (tbClientes.isEditing()) {
                        tbClientes.getCellEditor().stopCellEditing();
                    }
                    
                    Cliente cliente = obtenerClienteDesdeFila(row);
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar al cliente: " + cliente.getNombre() + "?", "Eliminar Cliente", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        clienteDAO.eliminarCliente(cliente);
                        System.out.println("Cliente eliminado: " + cliente.getNombre());

                        DefaultTableModel model = (DefaultTableModel) tbClientes.getModel();
                        model.removeRow(row);
                        int totalRegistros = model.getRowCount();
                        lbTotalClientes.setText(String.valueOf(totalRegistros));
                        model.fireTableDataChanged();
                    }
                } else {
                    System.out.println("Indice de fila no valido: " + row);
                }
            }
        };   
        
        spTablaClientes.setVerticalScrollBar(new ScrollBar());
        spTablaClientes.getVerticalScrollBar().setBackground(Color.WHITE);
        spTablaClientes.getViewport().setBackground(Color.WHITE);
        p.setBackground(Color.WHITE);
        spTablaClientes.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        tbClientes.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditorCliente(eventCliente));
        
        
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
        panelCard = new javax.swing.JLayeredPane();
        card1 = new component.Card();
        card2 = new component.Card();
        card3 = new component.Card();
        panel7 = new modelo.Panel();
        chart2 = new chartModel.Chart();
        cardClientes = new javax.swing.JPanel();
        panel6 = new modelo.Panel();
        txtFiltroClientes = new modelo.MyTextField();
        myButton2 = new modelo.MyButton();
        spTablaClientes = new javax.swing.JScrollPane();
        tbClientes = new table.TablaClientes();
        lbTotalClientes = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAgregarCliente = new modelo.MyButton();
        cardInventario = new javax.swing.JPanel();
        panel3 = new modelo.Panel();
        myTextField1 = new modelo.MyTextField();
        myButton1 = new modelo.MyButton();
        spTable = new javax.swing.JScrollPane();
        tablaInventario = new table.Table();
        lbTotalProductos = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAgregarProducto = new modelo.Button();
        cardProveedores = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnAgregarProveedor = new modelo.Button();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        lbTotalProveedores = new javax.swing.JLabel();
        spTablaProveedores = new javax.swing.JScrollPane();
        tbProveedores = new table.TablaProveedores();
        cardVenta = new javax.swing.JPanel();
        panel2 = new modelo.Panel();
        spTablaVentas = new javax.swing.JScrollPane();
        tbVentas = new table.TablaVentas();
        panel5 = new modelo.Panel();
        lbNombreEmpresa2 = new javax.swing.JLabel();
        cbClientes = new modelo.Combobox();
        jLabel23 = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        lbNitCliente = new javax.swing.JLabel();
        lbDireccionCliente = new javax.swing.JLabel();
        lbTelCliente = new javax.swing.JLabel();
        lbDpiCliente = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbTelEmpresa = new javax.swing.JLabel();
        lbDireccionEmpresa = new javax.swing.JLabel();
        panel4 = new modelo.Panel();
        btnRealizarVenta = new modelo.MyButton();
        jPanel5 = new javax.swing.JPanel();
        lbTotalVenta = new javax.swing.JLabel();
        lbNombreEmpresa3 = new javax.swing.JLabel();
        lbNombreEmpresa4 = new javax.swing.JLabel();
        lsDescuetos = new javax.swing.JLabel();
        lbNombreEmpresa6 = new javax.swing.JLabel();
        lbNombreEmpresa7 = new javax.swing.JLabel();
        lbSubTotal = new javax.swing.JLabel();
        lbImpuestos = new javax.swing.JLabel();
        lbNombreEmpresa10 = new javax.swing.JLabel();
        lbNombreEmpresa12 = new javax.swing.JLabel();
        lbNombreEmpresa13 = new javax.swing.JLabel();
        lbNombreEmpresa14 = new javax.swing.JLabel();
        lbNombreEmpresa11 = new javax.swing.JLabel();
        lbNitEmpresa2 = new javax.swing.JLabel();
        lbNoFactura = new javax.swing.JLabel();
        panel8 = new modelo.Panel();
        jLabel28 = new javax.swing.JLabel();
        cbProductos = new modelo.Combobox();
        jLabel29 = new javax.swing.JLabel();
        lbStock = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbPrecio = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtCantidadVenta = new modelo.MyTextField();
        btnAgregarVenta = new modelo.MyButton();
        btnBorrarVenta = new modelo.MyButton();
        lbNombreEmpresa = new javax.swing.JLabel();
        lbNitEmpresa = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cardAcercaDe = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        panelPrincipal.setBackground(new java.awt.Color(153, 204, 255));
        panelPrincipal.setLayout(new java.awt.CardLayout());

        cardInicio.setBackground(new java.awt.Color(248, 248, 248));
        cardInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCard.setBackground(new java.awt.Color(255, 255, 255));
        panelCard.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(32, 40, 78));
        card1.setColor2(new java.awt.Color(72, 154, 208));
        panelCard.add(card1);

        card2.setColor1(new java.awt.Color(29, 78, 92));
        card2.setColor2(new java.awt.Color(66, 153, 122));
        panelCard.add(card2);

        card3.setColor1(new java.awt.Color(112, 128, 144));
        card3.setColor2(new java.awt.Color(0, 0, 0));
        panelCard.add(card3);

        cardInicio.add(panelCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 930, 170));

        panel7.setBackground(new java.awt.Color(248, 248, 248));
        panel7.setRoundBottomLeft(30);
        panel7.setRoundBottomRight(30);
        panel7.setRoundTopLeft(30);
        panel7.setRoundTopRight(30);

        chart2.setBackground(new java.awt.Color(248, 248, 248));
        chart2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart2, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );

        cardInicio.add(panel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 950, 490));

        panelPrincipal.add(cardInicio, "inicio");

        cardClientes.setBackground(new java.awt.Color(248, 248, 248));
        cardClientes.setForeground(new java.awt.Color(204, 204, 204));
        cardClientes.setToolTipText("");
        cardClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel6.setBackground(new java.awt.Color(255, 255, 255));
        panel6.setRoundBottomLeft(20);
        panel6.setRoundBottomRight(20);
        panel6.setRoundTopLeft(20);
        panel6.setRoundTopRight(20);
        panel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFiltroClientes.setForeground(new java.awt.Color(128, 128, 128));
        txtFiltroClientes.setText("Buscar un cliente");
        txtFiltroClientes.setBorderColor(new java.awt.Color(128, 128, 128));
        txtFiltroClientes.setBorderEnabled(true);
        txtFiltroClientes.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFiltroClientes.setRadius(10);
        txtFiltroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroClientesActionPerformed(evt);
            }
        });
        panel6.add(txtFiltroClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 300, 35));

        myButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fe--search (2).png"))); // NOI18N
        myButton2.setBorderColor(new java.awt.Color(128, 128, 128));
        myButton2.setBorderEnabled(true);
        myButton2.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        myButton2.setRadius(10);
        panel6.add(myButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, 50, 35));

        spTablaClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "DPI", "Nit", "Numero", "Direccion", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTablaClientes.setViewportView(tbClientes);
        if (tbClientes.getColumnModel().getColumnCount() > 0) {
            tbClientes.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        panel6.add(spTablaClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 920, 480));

        lbTotalClientes.setFont(new java.awt.Font("Inria Sans", 1, 24)); // NOI18N
        lbTotalClientes.setForeground(new java.awt.Color(128, 128, 130));
        lbTotalClientes.setText("0");
        panel6.add(lbTotalClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jLabel33.setFont(new java.awt.Font("Inria Sans", 1, 20)); // NOI18N
        jLabel33.setText("Total de clientes");
        panel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 20, -1, -1));

        cardClientes.add(panel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 950, 580));

        jLabel6.setFont(new java.awt.Font("Inria Sans", 1, 24)); // NOI18N
        jLabel6.setText("Clientes");
        cardClientes.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel11.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        jLabel11.setText("Dasboard / Clientes");
        cardClientes.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btnAgregarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tdesign--user-add.png"))); // NOI18N
        btnAgregarCliente.setText("Agregar Cliente");
        btnAgregarCliente.setColor(new java.awt.Color(44, 134, 72));
        btnAgregarCliente.setColorOver(new java.awt.Color(34, 104, 56));
        btnAgregarCliente.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarCliente.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        btnAgregarCliente.setHoverEnabled(true);
        btnAgregarCliente.setRadius(10);
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        cardClientes.add(btnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 170, 40));

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

        lbTotalProductos.setFont(new java.awt.Font("Inria Sans", 1, 24)); // NOI18N
        lbTotalProductos.setForeground(new java.awt.Color(128, 128, 130));
        lbTotalProductos.setText("0");
        panel3.add(lbTotalProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel31.setFont(new java.awt.Font("Inria Sans", 1, 20)); // NOI18N
        jLabel31.setText("Total de productos");
        panel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 20, -1, -1));

        cardInventario.add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 950, 580));

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
        cardProveedores.add(btnAgregarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 175, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Inria Sans", 1, 20)); // NOI18N
        jLabel22.setText("Total de proveedores");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 25, -1, -1));

        lbTotalProveedores.setFont(new java.awt.Font("Inria Sans", 1, 24)); // NOI18N
        lbTotalProveedores.setForeground(new java.awt.Color(128, 128, 130));
        lbTotalProveedores.setText("0");
        jPanel4.add(lbTotalProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 25, -1, -1));

        spTablaProveedores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tbProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nit", "Nombre", "Direccion", "Correo", "Telefono", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTablaProveedores.setViewportView(tbProveedores);
        if (tbProveedores.getColumnModel().getColumnCount() > 0) {
            tbProveedores.getColumnModel().getColumn(0).setMaxWidth(50);
            tbProveedores.getColumnModel().getColumn(1).setPreferredWidth(10);
            tbProveedores.getColumnModel().getColumn(3).setPreferredWidth(120);
            tbProveedores.getColumnModel().getColumn(5).setPreferredWidth(10);
            tbProveedores.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        jPanel4.add(spTablaProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 910, 480));

        cardProveedores.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 950, 580));

        panelPrincipal.add(cardProveedores, "proveedores");

        cardVenta.setBackground(new java.awt.Color(244, 244, 244));
        cardVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setRoundBottomLeft(10);
        panel2.setRoundBottomRight(10);
        panel2.setRoundTopLeft(10);
        panel2.setRoundTopRight(10);
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spTablaVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tbVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripcion", "Cantidad", "Precio Unitario", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTablaVentas.setViewportView(tbVentas);
        if (tbVentas.getColumnModel().getColumnCount() > 0) {
            tbVentas.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        panel2.add(spTablaVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 570, 370));

        cardVenta.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 581, 410));

        panel5.setBackground(new java.awt.Color(255, 255, 255));
        panel5.setRoundBottomLeft(10);
        panel5.setRoundBottomRight(10);
        panel5.setRoundTopLeft(10);
        panel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNombreEmpresa2.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        lbNombreEmpresa2.setText("Direccion:");
        panel5.add(lbNombreEmpresa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        cbClientes.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        panel5.add(cbClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 280, -1));

        jLabel23.setFont(new java.awt.Font("Inria Sans", 1, 22)); // NOI18N
        jLabel23.setText("Datos del cliente");
        panel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        lbCliente.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        lbCliente.setText("Nombre Cliente");
        panel5.add(lbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        lbNitCliente.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        lbNitCliente.setText("00000001");
        panel5.add(lbNitCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        lbDireccionCliente.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        lbDireccionCliente.setText("-----");
        panel5.add(lbDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        lbTelCliente.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        lbTelCliente.setText("00000001");
        panel5.add(lbTelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        lbDpiCliente.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        lbDpiCliente.setText("000000000001");
        panel5.add(lbDpiCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        jLabel7.setText("DPI:");
        panel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        jLabel14.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        jLabel14.setText("Nit:");
        panel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel25.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        jLabel25.setText("Telefono:");
        panel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        cardVenta.add(panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 250));

        lbTelEmpresa.setFont(new java.awt.Font("Inria Sans", 0, 18)); // NOI18N
        lbTelEmpresa.setText("Tel: 7737-4893");
        cardVenta.add(lbTelEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        lbDireccionEmpresa.setFont(new java.awt.Font("Inria Sans", 0, 18)); // NOI18N
        lbDireccionEmpresa.setText("2 av Zona 1 La Esperanza Quetzaltenango");
        cardVenta.add(lbDireccionEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        panel4.setBackground(new java.awt.Color(244, 244, 244));
        panel4.setRoundBottomLeft(10);
        panel4.setRoundTopLeft(10);
        panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRealizarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizarVenta.setText("Realizar Venta");
        btnRealizarVenta.setColor(new java.awt.Color(45, 113, 248));
        btnRealizarVenta.setColorOver(new java.awt.Color(8, 88, 246));
        btnRealizarVenta.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRealizarVenta.setFont(new java.awt.Font("Inria Sans", 1, 18)); // NOI18N
        btnRealizarVenta.setHoverEnabled(true);
        btnRealizarVenta.setRadius(10);
        btnRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVentaActionPerformed(evt);
            }
        });
        panel4.add(btnRealizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 615, 352, 65));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTotalVenta.setFont(new java.awt.Font("Inria Sans", 0, 18)); // NOI18N
        lbTotalVenta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotalVenta.setText("0.00");
        jPanel5.add(lbTotalVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 100, -1));

        lbNombreEmpresa3.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        lbNombreEmpresa3.setForeground(new java.awt.Color(27, 130, 111));
        lbNombreEmpresa3.setText("Descuentos");
        jPanel5.add(lbNombreEmpresa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        lbNombreEmpresa4.setFont(new java.awt.Font("Inria Sans", 0, 18)); // NOI18N
        lbNombreEmpresa4.setText("TOTAL");
        jPanel5.add(lbNombreEmpresa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        lsDescuetos.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        lsDescuetos.setForeground(new java.awt.Color(27, 130, 111));
        lsDescuetos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lsDescuetos.setText("0.00");
        jPanel5.add(lsDescuetos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 100, -1));

        lbNombreEmpresa6.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        lbNombreEmpresa6.setText("Impuestos");
        jPanel5.add(lbNombreEmpresa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lbNombreEmpresa7.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        lbNombreEmpresa7.setForeground(new java.awt.Color(27, 130, 111));
        lbNombreEmpresa7.setText("-Q.");
        jPanel5.add(lbNombreEmpresa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 130, -1, -1));

        lbSubTotal.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        lbSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSubTotal.setText("0.00");
        lbSubTotal.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel5.add(lbSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 100, -1));

        lbImpuestos.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        lbImpuestos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbImpuestos.setText("0.00");
        jPanel5.add(lbImpuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 100, -1));

        lbNombreEmpresa10.setFont(new java.awt.Font("Inria Sans", 0, 18)); // NOI18N
        lbNombreEmpresa10.setText("Q.");
        jPanel5.add(lbNombreEmpresa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        lbNombreEmpresa12.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        lbNombreEmpresa12.setText("Q.");
        jPanel5.add(lbNombreEmpresa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        lbNombreEmpresa13.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        lbNombreEmpresa13.setText("Q.");
        jPanel5.add(lbNombreEmpresa13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        lbNombreEmpresa14.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        lbNombreEmpresa14.setText("Subtotal");
        jPanel5.add(lbNombreEmpresa14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lbNombreEmpresa11.setFont(new java.awt.Font("Inria Sans", 0, 28)); // NOI18N
        lbNombreEmpresa11.setForeground(new java.awt.Color(204, 204, 204));
        lbNombreEmpresa11.setText("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        jPanel5.add(lbNombreEmpresa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 140, -1, 30));

        lbNitEmpresa2.setFont(new java.awt.Font("Inria Sans", 1, 20)); // NOI18N
        lbNitEmpresa2.setForeground(new java.awt.Color(128, 128, 130));
        lbNitEmpresa2.setText("Factura #");
        jPanel5.add(lbNitEmpresa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        lbNoFactura.setFont(new java.awt.Font("Inria Sans", 1, 20)); // NOI18N
        lbNoFactura.setForeground(new java.awt.Color(128, 128, 130));
        lbNoFactura.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNoFactura.setText("1");
        jPanel5.add(lbNoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 50, -1));

        panel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 350, 250));

        panel8.setBackground(new java.awt.Color(255, 255, 255));
        panel8.setRoundTopLeft(10);
        panel8.setRoundTopRight(10);
        panel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Inria Sans", 1, 22)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(45, 113, 248));
        jLabel28.setText("Elegir Productos");
        panel8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        cbProductos.setFont(new java.awt.Font("Inria Sans", 0, 14)); // NOI18N
        panel8.add(cbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 290, 30));

        jLabel29.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        jLabel29.setText("Stock Disponible:");
        panel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        lbStock.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        lbStock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbStock.setText("0");
        panel8.add(lbStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 50, -1));

        jLabel27.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        jLabel27.setText("Precio Q.");
        panel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        lbPrecio.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        lbPrecio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPrecio.setText("0.00");
        panel8.add(lbPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 70, -1));

        jLabel26.setFont(new java.awt.Font("Inria Sans", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(45, 113, 248));
        jLabel26.setText("Cantidad:");
        panel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        txtCantidadVenta.setBorderColor(new java.awt.Color(102, 102, 102));
        txtCantidadVenta.setBorderEnabled(true);
        txtCantidadVenta.setFont(new java.awt.Font("Inria Sans", 0, 16)); // NOI18N
        txtCantidadVenta.setRadius(10);
        txtCantidadVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyTyped(evt);
            }
        });
        panel8.add(txtCantidadVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 130, 30));

        btnAgregarVenta.setForeground(new java.awt.Color(29, 131, 112));
        btnAgregarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carbon--add-filled.png"))); // NOI18N
        btnAgregarVenta.setText("Agregar    ");
        btnAgregarVenta.setBorderColor(new java.awt.Color(28, 130, 111));
        btnAgregarVenta.setBorderEnabled(true);
        btnAgregarVenta.setColor(new java.awt.Color(242, 252, 250));
        btnAgregarVenta.setColorOver(new java.awt.Color(194, 241, 232));
        btnAgregarVenta.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarVenta.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnAgregarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAgregarVenta.setHoverEnabled(true);
        btnAgregarVenta.setRadius(20);
        btnAgregarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVentaActionPerformed(evt);
            }
        });
        panel8.add(btnAgregarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 150, 35));

        btnBorrarVenta.setForeground(new java.awt.Color(184, 34, 47));
        btnBorrarVenta.setText("Borrar");
        btnBorrarVenta.setBorderColor(new java.awt.Color(184, 34, 47));
        btnBorrarVenta.setBorderEnabled(true);
        btnBorrarVenta.setColor(new java.awt.Color(252, 240, 241));
        btnBorrarVenta.setColorOver(new java.awt.Color(246, 207, 211));
        btnBorrarVenta.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrarVenta.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnBorrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnBorrarVenta.setHoverEnabled(true);
        btnBorrarVenta.setRadius(20);
        btnBorrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarVentaActionPerformed(evt);
            }
        });
        panel8.add(btnBorrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 150, 35));

        panel4.add(panel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 350, 360));

        cardVenta.add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 350, 680));

        lbNombreEmpresa.setFont(new java.awt.Font("Inria Sans", 0, 18)); // NOI18N
        lbNombreEmpresa.setText("PC Global");
        cardVenta.add(lbNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        lbNitEmpresa.setFont(new java.awt.Font("Inria Sans", 0, 18)); // NOI18N
        lbNitEmpresa.setText("Nit: 89034640");
        cardVenta.add(lbNitEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel24.setFont(new java.awt.Font("Inria Sans", 1, 24)); // NOI18N
        jLabel24.setText("Datos de la Empresa");
        cardVenta.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panelPrincipal.add(cardVenta, "venta");

        cardAcercaDe.setBackground(new java.awt.Color(5, 12, 30));
        cardAcercaDe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/title.png"))); // NOI18N
        cardAcercaDe.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DEV1.png"))); // NOI18N
        cardAcercaDe.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, -1));

        jLabel21.setFont(new java.awt.Font("Inria Sans", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Version 1.0");
        cardAcercaDe.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 420, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DEV2.png"))); // NOI18N
        cardAcercaDe.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));

        jLabel19.setFont(new java.awt.Font("Inria Sans", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("insomnio y con demasiada cafeína");
        cardAcercaDe.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 540, -1, -1));

        jLabel4.setFont(new java.awt.Font("Inria Sans", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Este proyecto se creo en varias noches de");
        cardAcercaDe.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, -1, -1));

        jLabel18.setFont(new java.awt.Font("Inria Sans", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("¡Y ve cómo ha crecido!");
        cardAcercaDe.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 570, -1, -1));

        jLabel8.setFont(new java.awt.Font("Inria Sans", 1, 48)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Acerca de 2 (2).png"))); // NOI18N
        cardAcercaDe.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 830, -1));

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
                "Nombre", "Usuario", "Tipo Usuario", "Fecha Agreado", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTablaUsuarios.setViewportView(tbUsuarios);
        if (tbUsuarios.getColumnModel().getColumnCount() > 0) {
            tbUsuarios.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

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
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 135, 190, 45));

        javax.swing.GroupLayout cardUsuariosLayout = new javax.swing.GroupLayout(cardUsuarios);
        cardUsuarios.setLayout(cardUsuariosLayout);
        cardUsuariosLayout.setHorizontalGroup(
            cardUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardUsuariosLayout.setVerticalGroup(
            cardUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
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
        llenarComboBoxClientes();
        llenarComboBoxProductos();
        actualizarNumeroFactura();
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
        mostrarClientes();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        actualizarBotones(btnProveedores);
        card.show(panelPrincipal, "proveedores");
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

    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        AgregarProveedor agregarProveedor = new AgregarProveedor(this, true);
        agregarProveedor.setVisible(true);
        mostrarProveedores();
    }//GEN-LAST:event_btnAgregarProveedorActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        actualizarBotones(btnUsuarios);
        card.show(panelPrincipal, "usuarios");
        mostrarUsuarios();
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed
        AgregarUsuario agregarUsuario = new AgregarUsuario(this, true);
        agregarUsuario.setVisible(true);
        mostrarUsuarios();
    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void btnBorrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarVentaActionPerformed
        tbVentas.clearTable();
        lbTotalVenta.setText("0.00");
        lbSubTotal.setText("0.00");
        lbImpuestos.setText("0.00");
    }//GEN-LAST:event_btnBorrarVentaActionPerformed

    private void txtCantidadVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyTyped
        char c1 = evt.getKeyChar();
        if(!(Character.isDigit(c1))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadVentaKeyTyped

    private void btnAgregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVentaActionPerformed
        Producto productoSeleccionado = (Producto) cbProductos.getSelectedItem();
        if (productoSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Seleeciona un producto", "Producto no seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }else if(txtCantidadVenta.getText().isEmpty() || txtCantidadVenta.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Ingresa una cantidad", "Cantidad no ingresada", JOptionPane.WARNING_MESSAGE);  
            return;
        }else if(Integer.parseInt(txtCantidadVenta.getText()) > productoSeleccionado.getCantidad()){
            JOptionPane.showMessageDialog(null, "No hay stock suficiente de: " + productoSeleccionado.getNombre(), "Stock insuficiente",JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            for(int i = 0; i < tbVentas.getRowCount(); i++) {
                if(tbVentas.getValueAt(i, 1).equals(productoSeleccionado.getNombre())) {
                    System.out.println(tbVentas.getValueAt(i, 0));
                    JOptionPane.showMessageDialog(null, "El Producto ya fue agregado", "Producto agregado", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            int cantidadVenta = Integer.parseInt(txtCantidadVenta.getText());
            float total = productoSeleccionado.getPrecio() * cantidadVenta;
            tbVentas.addRow(new Object[] {
                productoSeleccionado.getIdProducto(),
                productoSeleccionado.getNombre(),
                cantidadVenta,
                productoSeleccionado.getPrecio(),
                total
            });
        }
        
        actualizarTotalesFactura();
        
        txtCantidadVenta.setText("");
    }//GEN-LAST:event_btnAgregarVentaActionPerformed

    private void btnRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVentaActionPerformed
        Cliente clienteSeleccionado = (Cliente) cbClientes.getSelectedItem();
        Producto productoSeleccionado = (Producto) cbProductos.getSelectedItem();
        if(clienteSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Seleeciona un cliente", "Cliente no seleecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(tbVentas.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione al menos un producto para realizar la venta", "Productos no ingresados", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int numeroFactura = Integer.parseInt(lbNoFactura.getText());
        int idCliente = clienteSeleccionado.getIdCliente();
        String nombreCliente = clienteSeleccionado.getNombre();
        float totalVenta = Float.parseFloat(lbTotalVenta.getText().replace(",", ""));
        System.out.println(totalVenta);
        
        venta = new Venta(0, numeroFactura, idCliente, nombreCliente, totalVenta, new Date());
        boolean agregado = ventaDAO.agregarVenta(venta);
        
        int[] filasSeleccionadas = tbVentas.getSelectedRows();
        
        for (int i = 0; i < tbVentas.getRowCount(); i++) {
            int idProducto = (int)tbVentas.getValueAt(i, 0);
            int cantidadVendida = (int)tbVentas.getValueAt(i, 2);
            // Actualizar stock
            productoDAO.actualizarStockProducto(idProducto, cantidadVendida);
        }
        
        if(agregado) {
            JOptionPane.showMessageDialog(rootPane, "Venta realizada correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error al realizar la venta", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        String rutaArchivo = "src" + File.separator + "main" + File.separator + "java" + File.separator + "facturas" + File.separator + "facturaVenta#" + lbNoFactura.getText() + ".pdf";        
        // Llamar al método para generar el PDF
        generarReportePDF(rutaArchivo);
        
        
        actualizarNumeroFactura();
        llenarComboBoxProductos();
        cbClientes.setSelectedItem(null);
        cbProductos.setSelectedItem(null);
        tbVentas.clearTable();
        lbTotalVenta.setText("0.00");
        lbSubTotal.setText("0.00");
        lbImpuestos.setText("0.00");
    }//GEN-LAST:event_btnRealizarVentaActionPerformed

    private void txtFiltroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroClientesActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        AgregarCliente agregar = new AgregarCliente(this, true);
        agregar.setVisible(true);
        mostrarClientes();
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    public static void main(String args[]) {       
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(0);
        usuario.setNombre("Nombre Usuario");
        usuario.setTipoUsuario("Administrador");
        
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
        int totalRegistros = Productos.size();
        lbTotalProductos.setText(String.valueOf(totalRegistros));
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
    
    // Clientes
    public void mostrarClientes() {
        tbClientes.clearTable();
        List<Cliente> Clientes = clienteDAO.obtenerClientes();
        for (Cliente cliente : Clientes) {     
            tbClientes.addRow(new Object[]{
                cliente.getIdCliente(),
                cliente.getNombre(),
                cliente.getDpi(),
                cliente.getNit(),
                cliente.getNumero(),
                cliente.getDireccion()
            });
        }
        int totalRegistros = Clientes.size();
        lbTotalClientes.setText(String.valueOf(totalRegistros));
    }
    
    public Cliente obtenerClienteDesdeFila(int row) {
        int idCliente = Integer.parseInt(tbClientes.getValueAt(row, 0).toString());
        String nombreCliente = tbClientes.getValueAt(row, 1).toString();
        String dpi = tbClientes.getValueAt(row, 2).toString();
        String nit = tbClientes.getValueAt(row, 3).toString();
        String numero = tbClientes.getValueAt(row, 4).toString();
        String direccion = tbClientes.getValueAt(row, 5).toString();
        
        return new Cliente(idCliente, nombreCliente, dpi, nit, numero, direccion);
    }
    
    // Proveedores
    public void mostrarProveedores() {
        tbProveedores.clearTable();
        List<Proveedor> Proveedores = proveedorDAO.obtenerProveedores();
        for (Proveedor proveedor : Proveedores) {     
            tbProveedores.addRow(new Object[]{
                proveedor.getIdProveedor(),
                proveedor.getNit(),
                proveedor.getNombre(),
                proveedor.getDireccion(),
                proveedor.getEmail(),
                proveedor.getTelefono()
            });
        }
        int totalRegistros = Proveedores.size();
        lbTotalProveedores.setText(String.valueOf(totalRegistros));
    }
    
    public Proveedor obtenerProveedorDesdeFila(int row) {
        int idProveedor = Integer.parseInt(tbProveedores.getValueAt(row, 0).toString());
        long nitProveedor = Long.parseLong(tbProveedores.getValueAt(row, 1).toString());
        String nombreProveedor = tbProveedores.getValueAt(row, 2).toString();
        String direccionProveedor = tbProveedores.getValueAt(row, 3).toString();
        String emailProveedor = tbProveedores.getValueAt(row, 4).toString();
        String telefonoProveedor = tbProveedores.getValueAt(row, 5).toString();
        
        return new Proveedor(idProveedor, nitProveedor, nombreProveedor, direccionProveedor, emailProveedor, telefonoProveedor);
    }
    
    // Ventas - Lista de clientes
    private void llenarComboBoxClientes() {       
        List<Cliente> Clientes = clienteDAO.obtenerClientes();
        cbClientes.removeAllItems();
        cbClientes.addItem(null);
        for (Cliente cliente : Clientes) {
            cbClientes.addItem(cliente);
        }
        
        // Agregar ActionListener para cuando se seleccione un cliente
        cbClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el cliente seleccionado
                Cliente clienteSeleccionado = (Cliente) cbClientes.getSelectedItem();
                if (clienteSeleccionado == null) {
                    lbNitCliente.setText("00000001");
                    lbTelCliente.setText("00000001");
                    lbDpiCliente.setText("000000000001");
                    lbDireccionCliente.setText("----");
                } else {
                    lbNitCliente.setText(clienteSeleccionado.getNit());
                    lbTelCliente.setText(clienteSeleccionado.getNumero());
                    lbDpiCliente.setText(clienteSeleccionado.getDpi());
                    lbDireccionCliente.setText(clienteSeleccionado.getDireccion());
                }
            }
        });
    }
    
    // Ventas - Lista de productos
    private void llenarComboBoxProductos() {       
        List<Producto> Productos = productoDAO.obtenerProductos();
        cbProductos.removeAllItems();
        cbProductos.addItem(null);
        for (Producto producto : Productos) {
            cbProductos.addItem(producto);
        }
        
        cbProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto productoSeleccionado = (Producto) cbProductos.getSelectedItem();
                if (productoSeleccionado == null) {
                    lbStock.setText("0");
                    lbPrecio.setText("0.00");
                } else {
                    lbStock.setText(String.valueOf(productoSeleccionado.getCantidad()));
                    lbPrecio.setText(String.valueOf(productoSeleccionado.getPrecio()));
                }
                
            }
        });
    }
    
    // Ventas - Total
    private void actualizarTotalesFactura() {
        float sumaTotal = 0.0f;
        float subTotal = 0.0f;
        float impuesto = 0.0f;

        for (int i = 0; i < tbVentas.getRowCount(); i++) {
            if (tbVentas.getValueAt(i, 4) != null) {
                sumaTotal += Float.parseFloat(tbVentas.getValueAt(i, 4).toString());
                subTotal += Float.parseFloat(tbVentas.getValueAt(i, 4).toString()) / 1.12;
            }
        }
        
        impuesto += subTotal * 0.12;

        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        String totalFormateado = formatter.format(sumaTotal);
        String subTotalFormateado = formatter.format(subTotal);
        String impuestoFormateado = formatter.format(impuesto);

        lbTotalVenta.setText(totalFormateado);
        lbSubTotal.setText(subTotalFormateado);
        lbImpuestos.setText(impuestoFormateado);
    }
    
    // Venta - Actualiza numero de factura
    private void actualizarNumeroFactura() {
        int ultimoNumeroFactura = ventaDAO.obtenerUltimoNumeroFactura();
        lbNoFactura.setText(""+(ultimoNumeroFactura + 1));
    }
    

    // Usuarios
    private List<Usuario> listaUsuarios = new ArrayList<>();
    public void mostrarUsuarios() {
        tbUsuarios.clearTable();
        listaUsuarios.clear();
        List<Usuario> Usuarios = usuarioDAO.obtenerUsuarios();
        for (Usuario usuario : Usuarios) {
            UserType tipo = UserType.valueOf(usuario.getTipoUsuario());
            tbUsuarios.addRow(new Object[]{
                usuario.getNombre(),
                usuario.getUsuario(),
                tipo,
                usuario.getFechaCreacion()
            });
            listaUsuarios.add(usuario);
        }
        int totalRegistros = listaUsuarios.size();
        lbTotalUsuarios.setText(String.valueOf(totalRegistros));
    }
    
    public Usuario obtenerUsuarioPorFila(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < listaUsuarios.size()) {
            return listaUsuarios.get(rowIndex);
        }
        return null;
    }
    
    // Login
    public void verificarLogin(Usuario usuario) {
        String rolUsuario = usuario.getTipoUsuario();
        //System.out.println(rolUsuario);

        if (rolUsuario.equals("Administrador")) {
            btnUsuarios.setVisible(true);
        } else {
            btnUsuarios.setVisible(false);
        }
    }
    
    // Facturas
    public void generarReportePDF(String rutaArchivo) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
            document.open();

            Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.BLACK);
            Font fontSubTitulo = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

            Paragraph titulo = new Paragraph("Factura de Ventas", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(new Paragraph("\n"));
            Font fontDatos = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

            Paragraph datosEmpresa = new Paragraph("PC Global\n2 av Zona 1 La Esperanza Quetzaltenango\nNit: 89034640\nTel: 7737-4893", fontDatos);
            datosEmpresa.setAlignment(Element.ALIGN_CENTER);
            document.add(datosEmpresa);
            
            // Crea subTitulo
            Date fecha = new Date();
            Paragraph subTitulo = new Paragraph(fecha + "\n" + "Factura Numero: " + lbNoFactura.getText(), fontSubTitulo);
            subTitulo.setAlignment(Element.ALIGN_CENTER);
            document.add(subTitulo);
            document.add(new Paragraph("\n\n"));
            
            Font fontDatosCliente = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
            Paragraph tituloClientes = new Paragraph("Datos del Cliente", fontDatosCliente);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(tituloClientes);            
            
            Cliente clienteSeleccionado = (Cliente) cbClientes.getSelectedItem();           
            String nombreCliente = clienteSeleccionado.getNombre();
            String nitCliente = lbNitCliente.getText();
            String telCliente = lbTelCliente.getText();
            String direccionCliente = lbDireccionCliente.getText();
            Paragraph datosCliente = new Paragraph("Nombre: " + nombreCliente + "\n" + "Nit: " + nitCliente + "\n" + "Telefono: " + telCliente + "\n" + "Direccion: " + direccionCliente, fontDatos);
            datosEmpresa.setAlignment(Element.ALIGN_RIGHT);
            document.add(datosCliente);
            document.add(new Paragraph("\n\n"));
            
            // Crear una tabla de productos            
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setSpacingBefore(0f);
            table.setSpacingAfter(0f);
            float[] columnWidths = {1f, 8f, 2f, 2f, 2f};
            table.setWidths(columnWidths);
            table.addCell("ID");
            table.addCell("Descripción");
            table.addCell("Cantidad");
            table.addCell("Precio Unitario");
            table.addCell("Total");
            
            for (int i = 0; i < tbVentas.getRowCount(); i++) {                
                table.addCell(String.valueOf((int)tbVentas.getValueAt(i, 0)));
                table.addCell(String.valueOf(tbVentas.getValueAt(i, 1)));
                table.addCell(String.valueOf((int)tbVentas.getValueAt(i, 2)));
                table.addCell(String.valueOf((float)tbVentas.getValueAt(i, 3)));
                table.addCell(String.valueOf((float)tbVentas.getValueAt(i, 4)));
                
            }            
            document.add(table);
            document.add(new Paragraph("\n"));
            
            String totatVenta = lbTotalVenta.getText();
            Font fontTotal = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
            Paragraph total = new Paragraph("Total a pagar: Q." + totatVenta, fontTotal);
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);
            document.add(new Paragraph("\n\n\n"));
            
            String guiones = "--------------------------------------";
            String msg = "Gracias por su compra";
            Font fontMsg = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
            Paragraph msgFinal = new Paragraph(guiones + "\n" + msg, fontMsg);
            msgFinal.setAlignment(Element.ALIGN_CENTER);
            document.add(msgFinal);
                      
            document.close();
            System.out.println("Factura creada exitosamente!");
            
            // Abrir el archivo PDF automáticamente
            File archivoPDF = new File(rutaArchivo);
            if (archivoPDF.exists()) {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().open(archivoPDF);
                    } catch (IOException e) {
                        System.out.println("Error al intentar abrir el archivo PDF.");
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("El sistema no soporta abrir archivos automáticamente.");
                }
            } else {
                System.out.println("El archivo PDF no se pudo encontrar.");
            }            

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private modelo.GradientButton btnAcercaDe;
    private modelo.MyButton btnAgregarCliente;
    private modelo.Button btnAgregarProducto;
    private modelo.Button btnAgregarProveedor;
    private modelo.MyButton btnAgregarVenta;
    private modelo.MyButton btnBorrarVenta;
    private modelo.GradientButton btnClientes;
    private modelo.GradientButton btnInicio;
    private modelo.GradientButton btnInventario;
    private modelo.MyButton btnNuevoUsuario;
    private modelo.GradientButton btnProveedores;
    private modelo.MyButton btnRealizarVenta;
    private modelo.Button btnSalir;
    private modelo.GradientButton btnUsuarios;
    private modelo.GradientButton btnVenta;
    private component.Card card1;
    private component.Card card2;
    private component.Card card3;
    private javax.swing.JPanel cardAcercaDe;
    private javax.swing.JPanel cardClientes;
    private javax.swing.JPanel cardInicio;
    private javax.swing.JPanel cardInventario;
    private javax.swing.JPanel cardProveedores;
    private javax.swing.JPanel cardUsuarios;
    private javax.swing.JPanel cardVenta;
    private modelo.Combobox cbClientes;
    private modelo.Combobox cbProductos;
    private chartModel.Chart chart2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbDireccionCliente;
    private javax.swing.JLabel lbDireccionEmpresa;
    private javax.swing.JLabel lbDpiCliente;
    private javax.swing.JLabel lbImpuestos;
    private javax.swing.JLabel lbNitCliente;
    private javax.swing.JLabel lbNitEmpresa;
    private javax.swing.JLabel lbNitEmpresa2;
    private javax.swing.JLabel lbNoFactura;
    private javax.swing.JLabel lbNombreEmpresa;
    private javax.swing.JLabel lbNombreEmpresa10;
    private javax.swing.JLabel lbNombreEmpresa11;
    private javax.swing.JLabel lbNombreEmpresa12;
    private javax.swing.JLabel lbNombreEmpresa13;
    private javax.swing.JLabel lbNombreEmpresa14;
    private javax.swing.JLabel lbNombreEmpresa2;
    private javax.swing.JLabel lbNombreEmpresa3;
    private javax.swing.JLabel lbNombreEmpresa4;
    private javax.swing.JLabel lbNombreEmpresa6;
    private javax.swing.JLabel lbNombreEmpresa7;
    private javax.swing.JLabel lbPrecio;
    private javax.swing.JLabel lbStock;
    private javax.swing.JLabel lbSubTotal;
    private javax.swing.JLabel lbTelCliente;
    private javax.swing.JLabel lbTelEmpresa;
    private javax.swing.JLabel lbTotalClientes;
    private javax.swing.JLabel lbTotalProductos;
    private javax.swing.JLabel lbTotalProveedores;
    private javax.swing.JLabel lbTotalUsuarios;
    private javax.swing.JLabel lbTotalVenta;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lsDescuetos;
    private modelo.MyButton myButton1;
    private modelo.MyButton myButton2;
    private modelo.MyTextField myTextField1;
    private modelo.Panel panel1;
    private modelo.Panel panel2;
    private modelo.Panel panel3;
    private modelo.Panel panel4;
    private modelo.Panel panel5;
    private modelo.Panel panel6;
    private modelo.Panel panel7;
    private modelo.Panel panel8;
    private javax.swing.JLayeredPane panelCard;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane spTablaClientes;
    private javax.swing.JScrollPane spTablaProveedores;
    private javax.swing.JScrollPane spTablaUsuarios;
    private javax.swing.JScrollPane spTablaVentas;
    private javax.swing.JScrollPane spTable;
    private table.Table tablaInventario;
    private table.TablaClientes tbClientes;
    private table.TablaProveedores tbProveedores;
    private table.TablaUsuarios tbUsuarios;
    private table.TablaVentas tbVentas;
    private modelo.MyTextField txtCantidadVenta;
    private modelo.MyTextField txtFiltroClientes;
    // End of variables declaration//GEN-END:variables
}
