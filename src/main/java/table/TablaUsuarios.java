package table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TablaUsuarios extends JTable {

    public TablaUsuarios() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setShowVerticalLines(false);
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + "");
                if(column == 2 || column == 3 || column == 4) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }            
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if(value instanceof UserType) {
                    UserType type = (UserType)value;
                    CellTypeUser cell = new CellTypeUser(type);
                    return cell;
                } else if(column == 4) {
                    Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    ActionUser action = new ActionUser();
                    action.setBackground(com.getBackground());
                    return action;
                } else {
                    Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    com.setBackground(Color.WHITE);
                    setBorder(noFocusBorder);
                    if(isSelected) {
                        com.setForeground(new Color(15, 89, 140));
                    } else {
                        com.setForeground(new Color(102, 102, 102));
                    }
                    
                    if (column == 3) {
                        setHorizontalAlignment(JLabel.CENTER);
                    } else {
                        setHorizontalAlignment(JLabel.LEFT);
                    }
                                        
                    return com;
                }
            }
        });
    }
    
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
    
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.setRowCount(0);
    }
    
}
