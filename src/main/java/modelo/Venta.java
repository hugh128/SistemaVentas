package modelo;

import java.util.Date;

public class Venta {
    private int idVenta;
    private int numeroFactura;
    private int idCliente;
    private String nombreCliente;
    private float total;
    private Date fechaVenta;

    public Venta() {
    }

    public Venta(int idVenta, int numeroFactura, int idCliente, String nombreCliente, float total, Date fechaVenta) {
        this.idVenta = idVenta;
        this.numeroFactura = numeroFactura;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.total = total;
        this.fechaVenta = fechaVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    
    
    
}
