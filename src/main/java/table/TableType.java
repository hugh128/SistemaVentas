package table;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

public class TableType extends JLabel {
    
    private UserType type;
    
    public TableType() {
        setForeground(Color.WHITE);
    }
    
    public void setType(UserType type) {
        this.type = type;
        setText(type.toString());
        repaint();
    }
    
    public UserType getType() {
        return type;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(type != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            Color borderColor;
            Color backgroundColor;
            Color textColor;
            
            switch (type) {
                case Administrador:
                    borderColor = new Color(155,237,186);
                    backgroundColor = new Color(231, 253, 242);
                    textColor = new Color(46,124,87);
                    break;  
                case Usuario:
                    borderColor = new Color(149,206,249);
                    backgroundColor = new Color(238, 248, 254);
                    textColor = new Color(0, 102, 204);
                    break;
              
                default:
                    borderColor = new Color(241, 208, 62);
                    backgroundColor = new Color(255, 239, 160);
                    textColor = new Color(184, 134, 11);
                    break;
            }
            g2.setColor(backgroundColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            g2.setColor(borderColor);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

            setForeground(textColor);
        }
        super.paintComponent(g);
    }
    
}