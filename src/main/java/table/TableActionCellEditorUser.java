package table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditorUser extends DefaultCellEditor {

    private TableActionEventUser eventUser;

    public TableActionCellEditorUser(TableActionEventUser eventUser) {
        super(new JCheckBox());
        this.eventUser = eventUser;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        ActionUser actionUser = new ActionUser();
        actionUser.initEvent(eventUser, row);
        actionUser.setBackground(Color.WHITE);
        return actionUser;
    }
}
