package modelo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyTextField extends JTextField {

    private Color borderColor = Color.BLACK;
    private Color borderColorOnFocus = Color.BLUE;
    private int radius = 0;
    private int borderThickness = 1; // Grosor del borde
    private boolean borderEnabled = false;
    private boolean focusColorEnabled = false;

    public MyTextField() {
        setBorder(new EmptyBorder(6, 6, 6, 6));
        setOpaque(false);

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                repaint();
            }
        });
    }

    // Getters y setters
    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public Color getBorderColorOnFocus() {
        return borderColorOnFocus;
    }

    public void setBorderColorOnFocus(Color borderColorOnFocus) {
        this.borderColorOnFocus = borderColorOnFocus;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public int getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
        repaint();
    }

    public void setBorderEnabled(boolean enabled) {
        this.borderEnabled = enabled;
        repaint();
    }

    public boolean isBorderEnabled() {
        return borderEnabled;
    }

    public void setFocusColorEnabled(boolean enabled) {
        this.focusColorEnabled = enabled;
        repaint();
    }

    public boolean isFocusColorEnabled() {
        return focusColorEnabled;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int adjustedRadius = radius - (borderThickness / 2);
        int width = getWidth();
        int height = getHeight();

        // Dibuja el borde externo con el grosor especificado
        if (borderEnabled || (focusColorEnabled && hasFocus())) {
            g2.setColor(hasFocus() && focusColorEnabled ? borderColorOnFocus : borderColor);
            g2.setStroke(new BasicStroke(borderThickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));  // Grosor suave
            g2.drawRoundRect(borderThickness / 2, borderThickness / 2, 
                             width - borderThickness, height - borderThickness, 
                             adjustedRadius, adjustedRadius);
        }

        g2.setColor(getBackground());
        g2.fillRoundRect(borderThickness, borderThickness, 
                         width - 2 * borderThickness, height - 2 * borderThickness, 
                         adjustedRadius, adjustedRadius);

        super.paintComponent(grphcs);
        g2.dispose();
    }
}
