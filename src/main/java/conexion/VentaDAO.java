package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.BaseDatos;
import modelo.Venta;

public class VentaDAO {
    Connection conexion;
    BaseDatos db = new BaseDatos();
    Venta venta;
    
    public VentaDAO() {
        conexion = db.getConexion();
    }
    
    // Agregar venta
    public boolean agregarVenta(Venta venta) {
        String sql = "INSERT INTO ventas VALUES(NULL, ?, ?, ?, ?, ?)";
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql)) {
                    st.setInt(1, venta.getNumeroFactura());
                    st.setInt(2, venta.getIdCliente());
                    st.setString(3, venta.getNombreCliente());
                    st.setFloat(4, venta.getTotal());
                    st.setDate(5, new java.sql.Date(venta.getFechaVenta().getTime()));
                    return st.executeUpdate() > 0;
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar la venta: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    // Mostrar Ventas
    public List<Venta> obtenerVentas() {
        String sql = "SELECT * FROM ventas";
        List<Venta> listaVentas = new ArrayList<>();
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql);
                     ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        Venta venta = new Venta(
                                rs.getInt("idVenta"),
                                rs.getInt("numeroFactura"),
                                rs.getInt("idCliente"),
                                rs.getString("nombreCliente"),
                                rs.getFloat("total"),
                                rs.getDate("fechaVenta")
                        );
                        listaVentas.add(venta);
                    }
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener las ventas: " + ex.getMessage());
            ex.printStackTrace();
        }
        return listaVentas;
    }
    
    // Obtener el último número de factura
    public int obtenerUltimoNumeroFactura() {
        String sql = "SELECT MAX(numeroFactura) FROM ventas";
        int ultimoNumeroFactura = 0;
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql);
                     ResultSet rs = st.executeQuery()) {
                    if (rs.next() && rs.getObject(1) != null) {
                        ultimoNumeroFactura = rs.getInt(1);
                    }
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el ultimo numero de factura: " + ex.getMessage());
            ex.printStackTrace();
        }
        return ultimoNumeroFactura;
    }
    
}
