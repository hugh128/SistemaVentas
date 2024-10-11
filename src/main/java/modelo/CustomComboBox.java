package modelo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalComboBoxButton;

public class CustomComboBox<E> extends JComboBox<E> {

    private Color borderColor = Color.BLACK;
    private int radius = 0;
    private int borderThickness = 1; // Grosor del borde
    private boolean borderEnabled = false; // Habilitar o deshabilitar el borde

    public CustomComboBox() {
        // Establecemos un borde vacío para eliminar cualquier borde por defecto
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setOpaque(false); // Para que el fondo personalizado se vea

        // Personalizar el UI del ComboBox para redondear el borde y el ArrowButton
        setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                // Creamos un botón de flecha transparente pero con la flecha visible
                JButton arrowButton = new MetalComboBoxButton(comboBox, null, false, null, null);
                arrowButton.setOpaque(false);
                arrowButton.setContentAreaFilled(false); // Sin fondo
                arrowButton.setBorderPainted(false); // Sin borde
                return arrowButton;
            }

            @Override
            public void installUI(javax.swing.JComponent c) {
                super.installUI(c);
                // Eliminamos el borde del JComboBox
                comboBox.setBorder(new EmptyBorder(0, 0, 0, 0)); 
                comboBox.setOpaque(false); // Aseguramos que el JComboBox sea transparente
            }

            @Override
            protected BasicComboPopup createPopup() {
                return new BasicComboPopup(comboBox) {
                    @Override
                    protected void paintComponent(Graphics g) {
                        g.setColor(new Color(0, 0, 0, 0)); // Color transparente
                        g.fillRect(0, 0, getWidth(), getHeight());
                    }

                    @Override
                    public void show() {
                        super.show();
                        // Removemos el borde y fondo del popup
                        // No se necesita llamar a setBorder ni setOpaque aquí.
                    }
                };
            }
        });

        // Configuración adicional
        setFocusable(false);
    }

    // Getters y setters
    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
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

    public boolean isBorderEnabled() {
        return borderEnabled;
    }

    public void setBorderEnabled(boolean borderEnabled) {
        this.borderEnabled = borderEnabled;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); // Dibuja el componente predeterminado

        // Luego aplicamos nuestras personalizaciones
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int adjustedRadius = radius - (borderThickness / 2);
        int width = getWidth();
        int height = getHeight();

        // Si el borde está habilitado, dibuja el borde externo con el grosor y radio especificado
        if (borderEnabled) {
            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(borderThickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.drawRoundRect(borderThickness / 2, borderThickness / 2,
                             width - borderThickness - 1, height - borderThickness - 1,
                             adjustedRadius, adjustedRadius);
        }

        g2.dispose();
    }
}
