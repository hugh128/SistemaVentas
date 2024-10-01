package modelo;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.DefaultTableModel;

public class CheckBoxEditor extends AbstractCellEditor implements TableCellEditor {

    private final JCheckBox checkBox;
    private JTable table;

    public CheckBoxEditor(JTable table) {
        this.checkBox = new JCheckBox();
        this.checkBox.setHorizontalAlignment(JCheckBox.CENTER);
        this.table = table;

        checkBox.addActionListener(e -> seleccionarUnicoCheckbox());
    }

    @Override
    public Object getCellEditorValue() {
        return checkBox.isSelected();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        checkBox.setSelected((value != null && (Boolean) value));
        return checkBox;
    }

    private void seleccionarUnicoCheckbox() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRow = table.getEditingRow();

        for (int i = 0; i < model.getRowCount(); i++) {
            if (i != selectedRow) {
                model.setValueAt(false, i, 6);
            }
        }
    }
}

