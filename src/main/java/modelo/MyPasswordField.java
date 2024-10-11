package modelo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class MyPasswordField extends JPasswordField {

    private Color borderColor = Color.BLACK;
    private Color borderColorOnFocus = Color.BLUE;
    private int radius = 0;
    private int borderThickness = 1; // Grosor del borde
    private boolean borderEnabled = false;
    private boolean focusColorEnabled = false;
    private boolean focused = false;
    private boolean passwordMode;

    public MyPasswordField() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
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

        // Dibuja el borde externo solo si está habilitado o si está enfocado y el color de foco está habilitado
        if (borderEnabled || (focusColorEnabled && focused)) {
            g2.setColor(focused && focusColorEnabled ? borderColorOnFocus : borderColor);
            g2.setStroke(new BasicStroke(borderThickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.drawRoundRect(borderThickness / 2, borderThickness / 2, 
                             width - borderThickness, height - borderThickness, 
                             adjustedRadius, adjustedRadius);
        }

        // Dibujar el área interna
        g2.setColor(getBackground());
        g2.fillRoundRect(borderThickness, borderThickness, 
                         width - 2 * borderThickness, height - 2 * borderThickness, 
                         adjustedRadius, adjustedRadius);

        if (passwordMode) {
            char[] password = getPassword();
            StringBuilder maskedPassword = new StringBuilder();
            for (char ignored : password) {
                maskedPassword.append('*');
            }
            g2.setColor(getForeground());
            g2.drawString(maskedPassword.toString(), 5, getHeight() / 2 + g2.getFontMetrics().getAscent() / 2);

            int caretPosition = getCaretPosition();
            if (caretPosition <= password.length) {
                String textBeforeCaret = maskedPassword.substring(0, caretPosition);
                int caretX = g2.getFontMetrics().stringWidth(textBeforeCaret) + 5;
                int caretY = getHeight() / 2 - g2.getFontMetrics().getAscent() / 2;
                g2.setColor(Color.BLACK);
                g2.drawLine(caretX, caretY, caretX, caretY + g2.getFontMetrics().getAscent());
            }
        } else {
            super.paintComponent(grphcs);
        }

        g2.dispose();
    }
}

