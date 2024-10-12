package modelo;

import javax.swing.Icon;

public class CardHome {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getValores() {
        return valores;
    }

    public void setValores(String valores) {
        this.valores = valores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CardHome(Icon icon, String titulo, String valores, String descripcion) {
        this.icon = icon;
        this.titulo = titulo;
        this.valores = valores;
        this.descripcion = descripcion;
    }
    
    private Icon icon;
    private String titulo;
    private String valores;
    private String descripcion;
    
    
    
}
