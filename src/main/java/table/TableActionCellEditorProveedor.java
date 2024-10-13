package table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditorProveedor extends DefaultCellEditor {

    private TableActionEventProveedor eventProveedor;

    public TableActionCellEditorProveedor(TableActionEventProveedor eventProveedor) {
        super(new JCheckBox());
        this.eventProveedor = eventProveedor;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        ActionProveedor actionProveedor = new ActionProveedor();
        actionProveedor.initEvent(eventProveedor, row);
        actionProveedor.setBackground(Color.WHITE);
        return actionProveedor;
    }
}
