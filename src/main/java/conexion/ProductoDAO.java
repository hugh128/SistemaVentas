package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.BaseDatos;
import modelo.Producto;

public class ProductoDAO {
    Connection conexion;
    BaseDatos db = new BaseDatos();
    Producto producto;
    
    public ProductoDAO() {
        conexion = db.getConexion();
    }
    
    // Agregar producto
    public boolean agregarProducto(Producto producto) {
        String sql = "INSERT INTO productos VALUES(NULL, ?, ?, ?, ?, ?)";
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql)) {
                    st.setString(1, producto.getNombre());                    
                    st.setString(2, producto.getMarca());
                    st.setString(3, producto.getCategoria());                
                    st.setFloat(4, producto.getPrecio());
                    st.setInt(5, producto.getCantidad());
                    return st.executeUpdate() > 0;
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar el producto: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } /*finally {
            cerrarConexion();
        }*/
    }
    
    // Editar producto
    public boolean editarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, marca = ?, categoria = ?, precio = ?, cantidad = ? WHERE idProducto = ?";
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql)) {
                    st.setString(1, producto.getNombre());                    
                    st.setString(2, producto.getMarca());
                    st.setString(3, producto.getCategoria());                    
                    st.setFloat(4, producto.getPrecio());
                    st.setInt(5, producto.getCantidad());
                    st.setInt(6, producto.getIdProducto());
                    return st.executeUpdate() > 0;
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al editar el producto: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } /*finally {
            cerrarConexion();
        }*/
    }
    
    // Eliminar producto
    public boolean eliminarProducto(Producto producto) {
        String sql = "DELETE FROM productos WHERE idProducto = ?";
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql)) {
                    st.setInt(1, producto.getIdProducto());
                    return st.executeUpdate() > 0;
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el producto: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } /*finally {
            cerrarConexion();
        }*/
    }
    
    // Mostrar productos
   public List<Producto> obtenerProductos() {
        String sql = "SELECT * FROM productos";
        List<Producto> listaProductos = new ArrayList<>();
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql);
                     ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        Producto producto = new Producto(
                                rs.getInt("idProducto"),
                                rs.getString("nombre"),
                                rs.getString("marca"),
                                rs.getString("categoria"),
                                rs.getFloat("precio"),
                                rs.getInt("cantidad")
                        );
                        listaProductos.add(producto);
                    }
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener los productos: " + ex.getMessage());
            ex.printStackTrace();
        } /*finally {
            cerrarConexion();
        }*/
        return listaProductos;
    }
   
    // Actualiza Stock inventario
    public boolean actualizarStockProducto(int idProducto, int cantidadVendida) {
        String sql = "UPDATE productos SET cantidad = cantidad - ? WHERE idProducto = ? AND cantidad >= ?";
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql)) {
                    st.setInt(1, cantidadVendida);
                    st.setInt(2, idProducto);
                    st.setInt(3, cantidadVendida);
                    return st.executeUpdate() > 0;
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el stock del producto: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    // Cerrar conexion
    private void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion: " + ex.getMessage());
            }
        }
    }
    
}
