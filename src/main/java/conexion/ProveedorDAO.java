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
            if(conexion != null) {           
                try (PreparedStatement st = conexion.prepareStatement(sql)) {
                    st.setLong(1, proveedor.getNit());
                    st.setString(2, proveedor.getNombre());
                    st.setString(3, proveedor.getDireccion());                   
                    st.setString(4, proveedor.getEmail());
                    st.setString(5, proveedor.getTelefono());
                    return st.executeUpdate() > 0;
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
                return false;
            }
        } catch(SQLException ex) {
            System.out.println("Error al agregar proveedor: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    // Editar proveedor
    public boolean editarProveedor(Proveedor proveedor) {
        String sql = "UPDATE proveedores SET nit = ?, nombre = ?, direccion = ?, email = ?, telefono = ? WHERE idProveedor = ?";
        try {
            if(conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql);) {
                    st.setLong(1, proveedor.getNit());
                    st.setString(2, proveedor.getNombre());
                    st.setString(3, proveedor.getDireccion());
                    st.setString(4, proveedor.getEmail());
                    st.setString(5, proveedor.getTelefono());
                    st.setInt(6, proveedor.getIdProveedor());
                    return st.executeUpdate() > 0;
                }      
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
                return false;
            }
        } catch(SQLException ex) {
            System.out.println("Error al editar proveedor: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    // Eliminar proveedor
    public boolean eliminarProveedor(Proveedor proveedor) {
        String sql = "DELETE FROM proveedores WHERE idProveedor = ?";
        try {
            if(conexion != null) {
                try(PreparedStatement st = conexion.prepareStatement(sql)) {
                    st.setInt(1, proveedor.getIdProveedor());
                    return st.executeUpdate() > 0;
                }    
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
                return false;
            }
        } catch(SQLException ex) {
            System.out.println("Error al eliminar proveedor: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    // Mostrar proveedores
    public List<Proveedor> obtenerProveedores() {
        String sql = "SELECT * FROM proveedores";
        List<Proveedor> listaProveedores = new ArrayList<>();
        try {
            if(conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql);
                        ResultSet rs = st.executeQuery()) {
                    while(rs.next()) {
                    proveedor = new Proveedor (
                            rs.getInt("idProveedor"),
                            rs.getLong("nit"),
                            rs.getString("nombre"),
                            rs.getString("direccion"),
                            rs.getString("email"),
                            rs.getString("telefono")                          
                    );
                    listaProveedores.add(proveedor);
                    }
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
            }
        } catch(SQLException ex) {
            System.out.println("Error al obtener proveedores: " + ex.getMessage());
            ex.printStackTrace();
        }
        return listaProveedores;
    }
    
}
