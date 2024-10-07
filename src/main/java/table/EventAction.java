package table;

import modelo.Producto;

public interface EventAction {

    public void delete(Producto producto);

    public void update(Producto producto);
}
