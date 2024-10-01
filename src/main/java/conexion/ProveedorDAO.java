package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.BaseDatos;
import modelo.Proveedor;

public class ProveedorDAO {
    Connection conexion;
    BaseDatos db = new BaseDatos();
    Proveedor proveedor;
    
    public ProveedorDAO() {
        conexion = db.getConexion();
    }
    
    // Agregar proveedor
    public boolean agregarProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedores VALUES(NULL, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, proveedor.getNit());
            st.setString(2, proveedor.getNombre());
            st.setString(3, proveedor.getDireccion());
            st.setString(4, proveedor.getTelefono());
            st.setString(5, proveedor.getEmail());
            return st.executeUpdate() > 0;
        } catch(SQLException e) {
           e.printStackTrace();
           return false;
        }
    }
    
    // Editar proveedor
    public boolean editarProveedor(Proveedor proveedor) {
        String sql = "UPDATE proveedores SET nit = ?, nombre = ?, direccion = ?, telefono = ?, email = ? WHERE idProveedor = ?";
        try {
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, proveedor.getNit());
            st.setString(2, proveedor.getNombre());
            st.setString(3, proveedor.getDireccion());
            st.setString(4, proveedor.getTelefono());
            st.setString(5, proveedor.getEmail());
            st.setInt(6, proveedor.getIdProveedor());
            return st.executeUpdate() > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Eliminar proveedor
    public boolean eliminarProveedor(Proveedor proveedor) {
        String sql = "DELETE FROM proveedores WHERE idProveedor = ?";
        try {
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, proveedor.getIdProveedor());
            return st.executeUpdate() > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Proveedor> obtenerProveedores() {
        String sql = "SELECT * FROM proveedores";
        List<Proveedor> listaProveedores = new ArrayList<>();
        try {
            PreparedStatement st = conexion.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                proveedor = new Proveedor (
                        rs.getInt("idProveedor"),
                        rs.getInt("nit"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                );
                listaProveedores.add(proveedor);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return listaProveedores;
    }
}
