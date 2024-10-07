package modelo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class MyButton extends JButton {

    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius = 0;
    private int borderThickness = 1; // Grosor del borde
    private boolean borderEnabled = false;
    private boolean hoverEnabled = false;
    private boolean clickEnabled = false;
    private Cursor cursorType = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
    private Color originalColor;

    // Getters y setters
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

    public int getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
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

    public MyButton() {
        setColor(Color.WHITE);
        colorOver = new Color(200, 200, 200); // Color para hover
        colorClick = new Color(150, 150, 150); // Color para click
        borderColor = new Color(0, 0, 0);

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);

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

        int adjustedRadius = radius - (borderThickness / 2);
        int width = getWidth();
        int height = getHeight();

        if (borderEnabled) {
            g2.setColor(borderColor);
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
    }
}
