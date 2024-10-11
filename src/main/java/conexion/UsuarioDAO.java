package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.BaseDatos;
import modelo.Usuario;

public class UsuarioDAO {
    Connection conexion;
    BaseDatos db = new BaseDatos();
    Usuario usuario;

    public UsuarioDAO() {
        conexion = db.getConexion();
    }
    
    // Agregar usuario
    public boolean agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios VALUES(NULL, ?, ?, ?, ?, ?)";
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql)) {
                    st.setString(1, usuario.getUsuario());
                    st.setString(2, usuario.getNombre());
                    st.setString(3, usuario.getPassword());
                    st.setString(4, usuario.getTipoUsuario());
                    st.setDate(5, new java.sql.Date(usuario.getFechaCreacion().getTime()));
                    return st.executeUpdate() > 0;
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al agregar usuario: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    // Editar usuario
    public boolean editarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET usuario = ?, nombre = ?, password = ?, tipoUsuario = ? WHERE idUsuario = ?";
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql)) {
                    st.setString(1, usuario.getUsuario());                    
                    st.setString(2, usuario.getNombre());
                    st.setString(3, usuario.getPassword());                    
                    st.setString(4, usuario.getTipoUsuario());
                    st.setInt(5, usuario.getIdUsuario());
                    return st.executeUpdate() > 0;
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al editar usuario: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    // Eliminar usuario
    public boolean eliminarUsuario(Usuario usuario) {
        String sql = "DELETE FROM usuarios WHERE idUsuario = ?";
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql)) {
                    st.setInt(1, usuario.getIdUsuario());
                    return st.executeUpdate() > 0;
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar usuario: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    // Mostrar usuarios
    public List<Usuario> obtenerUsuarios() {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            if (conexion != null) {
                try (PreparedStatement st = conexion.prepareStatement(sql);
                     ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        usuario = new Usuario(
                                rs.getInt("idUsuario"),
                                rs.getString("usuario"),
                                rs.getString("nombre"),
                                rs.getString("password"),
                                rs.getString("tipoUsuario"),
                                rs.getDate("fechaCreacion")
                        );
                        listaUsuarios.add(usuario);
                    }
                }
            } else {
                System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener los usuarios: " + ex.getMessage());
            ex.printStackTrace();
        }
        return listaUsuarios;
    }    
    
    // Obtener usuario por usuario y contrasena
    public Usuario obtenerUsuario(String usuarioInput, String passwordInput) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
        try (PreparedStatement st = conexion.prepareStatement(sql)) {
            st.setString(1, usuarioInput);
            st.setString(2, passwordInput);
            if(conexion != null) {
            
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        usuario = new Usuario(
                                rs.getInt("idUsuario"),
                                rs.getString("usuario"),
                                rs.getString("nombre"),
                                rs.getString("password"),
                                rs.getString("tipoUsuario"),
                                rs.getDate("fechaCreacion")
                        );
                    } else {
                        System.out.println("Error: No se pudo establecer la conexion a la base de datos.");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener usuario: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        return usuario;
    }
    
    
}
