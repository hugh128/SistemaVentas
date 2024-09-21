package sistemaventas;

import java.sql.Connection;
import modelo.BaseDatos;

public class SistemaVentas {

    public static void main(String[] args) {
        BaseDatos db = new BaseDatos();
        Connection cnx = db.getConexion();
    }
}
