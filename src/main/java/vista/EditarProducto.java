package vista;

import conexion.ProductoDAO;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modelo.Producto;

public class EditarProducto extends javax.swing.JDialog {
    
    private Producto producto;
    private ProductoDAO productoDAO = new ProductoDAO();

    public EditarProducto(java.awt.Frame parent, boolean modal, Producto producto) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setProducto(producto);
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
        lbIdProducto.setText(String.valueOf(producto.getIdProducto()));
        txtNombre.setText(producto.getNombre());
        txtMarca.setText(producto.getMarca());
        txtCategoria.setText(producto.getCategoria());
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        txtCantidad.setText(String.valueOf(producto.getCantidad()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbIdProducto = new javax.swing.JLabel();
        txtNombre = new modelo.MyTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCategoria = new modelo.MyTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new modelo.MyTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCantidad = new modelo.MyTextField();
        panel1 = new modelo.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMarca = new modelo.MyTextField();
        btnSalir = new modelo.Button();
        btnGuardar = new modelo.Button();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 650));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Inria Sans", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(24, 108, 219));
        jLabel2.setText("Editar Producto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        lbIdProducto.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        lbIdProducto.setForeground(new java.awt.Color(118, 118, 118));
        lbIdProducto.setText("ID");
        jPanel1.add(lbIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 325, -1, -1));

        txtNombre.setBorderColor(new java.awt.Color(128, 128, 128));
        txtNombre.setBorderColorOnFocus(new java.awt.Color(0, 141, 235));
        txtNombre.setBorderEnabled(true);
        txtNombre.setFocusColorEnabled(true);
        txtNombre.setFont(new java.awt.Font("Inria Sans", 0, 15)); // NOI18N
        txtNombre.setRadius(20);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 275, 40));

        jLabel5.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(118, 118, 118));
        jLabel5.setText("CATEGORIA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, -1, -1));

        txtCategoria.setBorderColor(new java.awt.Color(128, 128, 128));
        txtCategoria.setBorderColorOnFocus(new java.awt.Color(0, 141, 235));
        txtCategoria.setBorderEnabled(true);
        txtCategoria.setFocusColorEnabled(true);
        txtCategoria.setFont(new java.awt.Font("Inria Sans", 0, 15)); // NOI18N
        txtCategoria.setRadius(20);
        jPanel1.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 275, 40));

        jLabel7.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(118, 118, 118));
        jLabel7.setText("PRECIO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        txtPrecio.setBorderColor(new java.awt.Color(128, 128, 128));
        txtPrecio.setBorderColorOnFocus(new java.awt.Color(0, 141, 235));
        txtPrecio.setBorderEnabled(true);
        txtPrecio.setFocusColorEnabled(true);
        txtPrecio.setFont(new java.awt.Font("Inria Sans", 0, 15)); // NOI18N
        txtPrecio.setRadius(20);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 125, 40));

        jLabel8.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(118, 118, 118));
        jLabel8.setText("CANTIDAD");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, -1, -1));

        txtCantidad.setBorderColor(new java.awt.Color(128, 128, 128));
        txtCantidad.setBorderColorOnFocus(new java.awt.Color(0, 141, 235));
        txtCantidad.setBorderEnabled(true);
        txtCantidad.setFocusColorEnabled(true);
        txtCantidad.setFont(new java.awt.Font("Inria Sans", 0, 15)); // NOI18N
        txtCantidad.setRadius(20);
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 100, 40));

        panel1.setBackground(new java.awt.Color(206, 224, 247));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bxs--camera.png"))); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 175, 175));

        jLabel6.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(118, 118, 118));
        jLabel6.setText("MARCA");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        txtMarca.setBorderColor(new java.awt.Color(128, 128, 128));
        txtMarca.setBorderColorOnFocus(new java.awt.Color(0, 141, 235));
        txtMarca.setBorderEnabled(true);
        txtMarca.setFocusColorEnabled(true);
        txtMarca.setFont(new java.awt.Font("Inria Sans", 0, 15)); // NOI18N
        txtMarca.setRadius(20);
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 275, 40));

        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("SALIR");
        btnSalir.setColor(new java.awt.Color(219, 135, 24));
        btnSalir.setColorOver(new java.awt.Color(200, 132, 43));
        btnSalir.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setFont(new java.awt.Font("Inria Sans", 1, 16)); // NOI18N
        btnSalir.setHoverEnabled(true);
        btnSalir.setRadius(20);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 200, 45));

        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setColor(new java.awt.Color(24, 108, 219));
        btnGuardar.setColorOver(new java.awt.Color(20, 91, 184));
        btnGuardar.setCursorType(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFont(new java.awt.Font("Inria Sans", 1, 16)); // NOI18N
        btnGuardar.setHoverEnabled(true);
        btnGuardar.setRadius(20);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, 200, 45));

        jLabel9.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(118, 118, 118));
        jLabel9.setText("NOMBRE");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jLabel10.setFont(new java.awt.Font("Inria Sans", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(118, 118, 118));
        jLabel10.setText("ID PRODUCTO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 325, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c1 = evt.getKeyChar();
        if(!(Character.isDigit(c1))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char c1 = evt.getKeyChar();
        if(!(Character.isDigit(c1)) && c1 != KeyEvent.VK_PERIOD){
            evt.consume();
        } else if (c1 == KeyEvent.VK_PERIOD && txtPrecio.getText().contains(".")){
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(txtNombre.getText().isEmpty() || txtMarca.getText().isEmpty() || txtCategoria.getText().isEmpty()
                || txtPrecio.getText().isEmpty() || txtCantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Completa todos los campos", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        producto.setNombre(txtNombre.getText());
        producto.setMarca(txtMarca.getText());
        producto.setCategoria(txtCategoria.getText());
        producto.setPrecio(Float.parseFloat(txtPrecio.getText()));
        producto.setCantidad(Integer.parseInt(txtCantidad.getText()));

        boolean editado = productoDAO.editarProducto(producto);

        if (editado) {
            JOptionPane.showMessageDialog(rootPane, "Producto actualizado con éxito.");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error al actualizar el producto.");
        }  
    }//GEN-LAST:event_btnGuardarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Producto productoPrueba = new Producto();
                productoPrueba.setIdProducto(1);
                productoPrueba.setNombre("Producto de prueba");
                productoPrueba.setMarca("Marca de Prueba");
                productoPrueba.setCategoria("Categoria de prueba");
                productoPrueba.setPrecio(100);
                productoPrueba.setCantidad(10);
                
                
                EditarProducto dialog = new EditarProducto(new javax.swing.JFrame(), true, productoPrueba);
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
    private modelo.Button btnGuardar;
    private modelo.Button btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbIdProducto;
    private modelo.Panel panel1;
    private modelo.MyTextField txtCantidad;
    private modelo.MyTextField txtCategoria;
    private modelo.MyTextField txtMarca;
    private modelo.MyTextField txtNombre;
    private modelo.MyTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
