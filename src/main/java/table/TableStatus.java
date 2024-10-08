package table;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

public class TableStatus extends JLabel {

    public StatusType getTye() {
        return type;
    }
    
    public TableStatus() {
        setForeground(Color.WHITE);
    }
    
    private StatusType type;
    
    public void setType(StatusType type) {
        this.type = type;
        setText(type.toString());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(type != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint g1;
            if(null == type) {
                g1 = new GradientPaint(0, 0, new Color(241, 208, 62), 0, getHeight(), new Color(211, 184, 61));
            } else switch (type) {
                case NOTEBOOK:
                    g1 = new GradientPaint(0, 0, new Color(186, 123, 247), 0, getHeight(), new Color(167, 94, 236));
                    break;
                case MONITOR:
                    g1 = new GradientPaint(0, 0, new Color(142, 142, 250), 0, getHeight(), new Color(123, 123, 245));
                    break;

                case GAMEPAD:
                    g1 = new GradientPaint(0, 0, new Color(255, 128, 0), 0, getHeight(), new Color(204, 102, 0));
                    break;                    
                case ACCESORIOS:
                    g1 = new GradientPaint(0, 0, new Color(0, 153, 255), 0, getHeight(), new Color(0, 102, 204));
                    break;                     
                case ALMACENAMIENTO:
                    g1 = new GradientPaint(0, 0, new Color(0, 204, 102), 0, getHeight(), new Color(0, 153, 76));
                    break;                     
                case MOVIL:
                    g1 = new GradientPaint(0, 0, new Color(255, 0, 128), 0, getHeight(), new Color(204, 0, 102));
                    break;                     
                case MULTIMEDIA:
                    g1 = new GradientPaint(0, 0, new Color(255, 204, 0), 0, getHeight(), new Color(204, 153, 0));
                    break;                    
                case COMPONENTES:
                    g1 = new GradientPaint(0, 0, new Color(153, 0, 255), 0, getHeight(), new Color(102, 0, 204));
                    break;                     
                case COMPUTADORA:
                    g1 = new GradientPaint(0, 0, new Color(0, 204, 204), 0, getHeight(), new Color(0, 153, 153));
                    break;                     
                case DISPOSITIVOS:
                    g1 = new GradientPaint(0, 0, new Color(255, 204, 204), 0, getHeight(), new Color(204, 153, 153));
                    break;                    
                case IMPRESORAS:
                    g1 = new GradientPaint(0, 0, new Color(255, 51, 51), 0, getHeight(), new Color(204, 0, 0));
                    break;                     
                case PERIFERICOS:
                    g1 = new GradientPaint(0, 0, new Color(51, 204, 255), 0, getHeight(), new Color(0, 153, 204));
                    break;                     
                case SERVIDORES:
                    g1 = new GradientPaint(0, 0, new Color(153, 153, 255), 0, getHeight(), new Color(102, 102, 204));
                    break;                     
                    
                    
                default:
                    g1 = new GradientPaint(0, 0, new Color(241, 208, 62), 0, getHeight(), new Color(211, 184, 61));
                    break;
            }
            g2.setPaint(g1);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 1, 1);
        }
        super.paintComponent(g);
    }
    
}