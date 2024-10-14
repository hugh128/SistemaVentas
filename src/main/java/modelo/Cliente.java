package modelo;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String dpi;
    private String nit;
    private String numero;
    private String direccion;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(int idCliente, String nombre, String dpi, String nit, String numero, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dpi = dpi;
        this.nit = nit;
        this.numero = numero;
        this.direccion = direccion;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
