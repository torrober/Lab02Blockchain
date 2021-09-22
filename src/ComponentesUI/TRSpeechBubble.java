/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentesUI;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author guest
 */
public class TRSpeechBubble extends JPanel {

    private int shadowSize = 6;
    private float shadowOpacity = 0.2f;
    private int strokeThickness = 5;
    private int padding = strokeThickness / 2;
    private int arrowSize = 4;
    private SpeechBubbleDirection direction = SpeechBubbleDirection.LEFT;

    public void setDirection(SpeechBubbleDirection direction) {
        this.direction = direction;
    }

    public int getShadowSize() {
        return shadowSize;
    }

    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
    }

    public float getShadowOpacity() {
        return shadowOpacity;
    }

    public void setShadowOpacity(float shadowOpacity) {
        this.shadowOpacity = shadowOpacity;
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }
    private Color shadowColor = Color.BLACK;
    private int borderRadius;

    public TRSpeechBubble() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        createShadow(grphcs);
        super.paintComponent(grphcs);
    }

    private void createShadow(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        int size = shadowSize * 2;
        int x = 0;
        int y = 0;
        int width = getWidth() - size;
        int height = getHeight() - size;
        int widthArrow = getWidth() - arrowSize - (strokeThickness * 2);
        //  Center
        x = padding + strokeThickness + shadowSize;
        y = shadowSize - 4;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setColor(getBackground());
        g.setStroke(new BasicStroke(strokeThickness));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (direction == SpeechBubbleDirection.LEFT) {
            g.fillRoundRect(20, padding, width - padding - 20, height - 2, borderRadius, borderRadius);
            Polygon arrow = new Polygon();
            arrow.addPoint(20, height / 2);
            arrow.addPoint(0, ((height - 20) / 2));
            arrow.addPoint(20, ((height - 20) / 2));
            g.fill(arrow);
        } else if (direction == SpeechBubbleDirection.RIGHT) {
            g.fillRoundRect(0, padding, width - padding - 20, height - 2, borderRadius, borderRadius);
            Polygon arrow = new Polygon();
            arrow.addPoint(widthArrow-20, height / 2);
            arrow.addPoint(widthArrow + arrowSize, ((height - 20) / 2));
            arrow.addPoint(widthArrow-20, ((height - 20) / 2));
            g.fill(arrow);
        }
        //  Create Shadow
        ShadowRenderer render = new ShadowRenderer(shadowSize, shadowOpacity, shadowColor);
        g2.drawImage(render.createShadow(img), 0, 0, null);
        g2.drawImage(img, x, y, null);
    }

}
