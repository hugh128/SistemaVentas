package modelo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Button extends JButton {

    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius = 0;
    private boolean borderEnabled = false;
    private boolean hoverEnabled = false;
    private boolean clickEnabled = false;
    private Cursor cursorType = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);

    // Guardar el color original para restaurarlo después del click
    private Color originalColor;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setBorderEnabled(boolean enabled) {
        this.borderEnabled = enabled;
        repaint();
    }

    public boolean isBorderEnabled() {
        return borderEnabled;
    }

    public void setHoverEnabled(boolean enabled) {
        this.hoverEnabled = enabled;
    }

    public boolean isHoverEnabled() {
        return hoverEnabled;
    }

    public void setClickEnabled(boolean enabled) {
        this.clickEnabled = enabled;
    }

    public boolean isClickEnabled() {
        return clickEnabled;
    }

    public void setCursorType(Cursor cursor) {
        this.cursorType = cursor;
        setCursor(cursorType);
    }

    public Cursor getCursorType() {
        return cursorType;
    }

    public Button() {
        setColor(Color.WHITE);
        colorOver = new Color(200, 200, 200); // Color para hover
        colorClick = new Color(150, 150, 150); // Color para click
        borderColor = new Color(0, 0, 0);

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);

        // Establecer el cursor predeterminado (puede ser cambiado después)
        setCursorType(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                if (hoverEnabled) {
                    if (!clickEnabled) {
                        setBackground(colorOver);
                    }
                }
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                if (hoverEnabled && !clickEnabled) {
                    setBackground(color);
                }
                over = false;
            }

            @Override
            public void mousePressed(MouseEvent me) {
                if (clickEnabled) {
                    // Guardar el color original y cambiar al color de clic
                    originalColor = getBackground();
                    setBackground(colorClick);
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (clickEnabled) {
                    setBackground(originalColor);
                } else {
                    if (hoverEnabled && over) {
                        setBackground(colorOver);
                    } else {
                        setBackground(color);
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (borderEnabled) {
            g2.setColor(borderColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.setColor(getBackground());
            g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        } else {
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        }

        super.paintComponent(grphcs);
    }
}