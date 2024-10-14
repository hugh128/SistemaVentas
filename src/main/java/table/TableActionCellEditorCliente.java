package table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditorCliente extends DefaultCellEditor {

    private TableActionEventCliente eventCliente;

    public TableActionCellEditorCliente(TableActionEventCliente eventCliente) {
        super(new JCheckBox());
        this.eventCliente = eventCliente;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        ActionCliente action = new ActionCliente();
        action.initEvent(eventCliente, row);
        action.setBackground(Color.WHITE);
        return action;
    }
}
