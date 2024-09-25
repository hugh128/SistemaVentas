package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.BaseDatos;
import modelo.Usuario;

public class UsuarioDAO {
    Connection conexion;
    BaseDatos db = new BaseDatos();
    Usuario usuario;
    
    public Usuario obtenerUsuario(String nombreUsuario, String password) {
        try {
            conexion = db.getConexion();
            String query = "SELECT * FROM usuarios WHERE nombreUsuario = ? AND password = ?";
            PreparedStatement st = conexion.prepareStatement(query);
            st.setString(1, nombreUsuario);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()) {
                usuario = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombreUsuario"),
                        rs.getString("password"),
                        rs.getString("tipoUsuario")
                );
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return usuario;
    }
}
