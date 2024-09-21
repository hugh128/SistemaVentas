package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TextField extends JTextField {

    private Color borderColor = Color.BLACK;
    private Color borderColorOnFocus = Color.BLUE;
    private int radius = 0;
    private boolean borderEnabled = false;
    private boolean focusColorEnabled = false;
    private boolean focused = false;

    public TextField() {
        setBorder(new EmptyBorder(6, 6, 6, 6));
        setOpaque(false);
        
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focused = true;
                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                focused = false;
                repaint();
            }
        });
    }

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

        if (borderEnabled || (focusColorEnabled && focused)) {
            g2.setColor(focused && focusColorEnabled ? borderColorOnFocus : borderColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.setColor(getBackground());
            g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        } else {
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        }

        super.paintComponent(grphcs);
        g2.dispose();
    }
}