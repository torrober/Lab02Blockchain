/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author guest
 */
public class TRButton extends JButton {

    int borderRadius = 0;

    public TRButton() {
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(this.getColor());
        setBorderPainted(false);
        colorOnHover = new Color(179, 250, 160);
        colorOnClicked = new Color(152, 184, 144);
        setContentAreaFilled(false);
        System.out.println(this.getText());
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(colorOnHover);
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(color);
                over = false;

            }

            @Override
            public void mousePressed(MouseEvent me) {
                setBackground(colorOnClicked);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (over) {
                    setBackground(colorOnHover);
                } else {
                    setBackground(color);
                }
            }
        });
    }
    private boolean over;
    private Color color;
    private Color colorOnHover;
    private Color colorOnClicked;
    private Color foregroundOnHover;
    private Color foregroundOnClicked;

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, this.borderRadius, this.borderRadius);
        super.paintComponent(g);
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public void setColorOnHover(Color colorOnHover) {
        this.colorOnHover = colorOnHover;
    }

    public void setColorOnClicked(Color colorOnClicked) {
        this.colorOnClicked = colorOnClicked;
    }

    public boolean isOver() {
        return over;
    }

    public Color getColor() {
        return color;
    }

    public Color getColorOnHover() {
        return colorOnHover;
    }

    public Color getColorOnClicked() {
        return colorOnClicked;
    }

    public Color getForegroundOnHover() {
        return foregroundOnHover;
    }

    public Color getForegroundOnClicked() {
        return foregroundOnClicked;
    }

}
