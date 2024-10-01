package modelo;

import conexion.ProveedorDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProveedorTabla extends JPanel {
    private JTable tbProveedores;
    private DefaultTableModel modelo;
    private JScrollPane scrollPane;

    public ProveedorTabla() {
        initComponent();
        cargarProveedores();
    }

    private void initComponent() {
        modelo = new DefaultTableModel();
        modelo.addColumn("idProveedor");
        modelo.addColumn("NIT");
        modelo.addColumn("Nombre");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Email");

        tbProveedores = new JTable(modelo);
        tbProveedores.setDefaultEditor(Object.class, null); // Hacer la tabla no editable
        scrollPane = new JScrollPane(tbProveedores);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    // Método para cargar proveedores desde la base de datos y llenar la tabla
    public void cargarProveedores() {
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        List<Proveedor> proveedores;

        try {
            proveedores = proveedorDAO.obtenerProveedores();
            modelo.setRowCount(0);

            for (Proveedor proveedor : proveedores) {
                Object[] fila = {
                    proveedor.getIdProveedor(),
                    proveedor.getNit(),
                    proveedor.getNombre(),
                    proveedor.getDireccion(),
                    proveedor.getTelefono(),
                    proveedor.getEmail()
                };
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar proveedores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para actualizar los proveedores desde fuera de esta clase
    public void actualizarProveedores() {
        cargarProveedores();
    }
}

