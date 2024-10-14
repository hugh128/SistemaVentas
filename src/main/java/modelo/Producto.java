package modelo;

public class Producto {
    private int idProducto;
    private String nombre;
    private String marca;
    private String categoria;    
    private float precio;
    private int cantidad;
    
    public Producto() {
    }

    public Producto(int idProducto, String nombre, String marca, String categoria, float precio, int cantidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString() {
        return nombre;
    }

    
}
