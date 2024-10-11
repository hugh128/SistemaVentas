package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.BaseDatos;
import modelo.Cliente;

public class ClienteDAO {
    private Connection conexion;
    private BaseDatos db = new BaseDatos();

    public ClienteDAO() {
        conexion = db.getConexion();
    }

    // Agregar cliente
    public boolean agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes VALUES(NULL, ?, ?, ?, ?, ?)";
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql)) {
                    st.setString(1, cliente.getNombre());
                    st.setString(2, cliente.getDpi());
                    st.setString(3, cliente.getNit());
                    st.setString(4, cliente.getNumero());
                    st.setString(5, cliente.getDireccion());
                    return st.executeUpdate() > 0;
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar el cliente: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    // Editar cliente
    public boolean editarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre = ?, dpi = ?, nit = ?, numero = ?, direccion = ? WHERE idCliente = ?";
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql)) {
                    st.setString(1, cliente.getNombre());
                    st.setString(2, cliente.getDpi());
                    st.setString(3, cliente.getNit());
                    st.setString(4, cliente.getNumero());
                    st.setString(5, cliente.getDireccion());
                    st.setInt(6, cliente.getIdCliente());
                    return st.executeUpdate() > 0;
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al editar el cliente: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    // Eliminar cliente
    public boolean eliminarCliente(Cliente cliente) {
        String sql = "DELETE FROM clientes WHERE idCliente = ?";
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql)) {
                    st.setInt(1, cliente.getIdCliente());
                    return st.executeUpdate() > 0;
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el cliente: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    // Mostrar clientes
    public List<Cliente> obtenerClientes() {
        String sql = "SELECT * FROM clientes";
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql);
                     ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        Cliente cliente = new Cliente(
                                rs.getInt("idCliente"),
                                rs.getString("nombre"),
                                rs.getString("dpi"),
                                rs.getString("nit"),
                                rs.getString("numero"),
                                rs.getString("direccion")
                        );
                        listaClientes.add(cliente);
                    }
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener los clientes: " + ex.getMessage());
            ex.printStackTrace();
        }
        return listaClientes;
    }

    // Cerrar conexión
    private void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
}
