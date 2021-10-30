/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Estructura.Grafo;
import Estructura.Vertice;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.*;

/**
 *
 * @author guest
 */
public class PSketch extends PApplet {

    PImage close;
    public static JFrame frame;
    public static Grafo g;

    public void settings() {
    }

    public PSketch(Grafo g) {
        this.g = g;
    }

    public void drawGraph() {
        Grafo g = this.g;
        int VerticeBloquesX = 530;
        int VerticeBloquesY = 120;
        int VerticeUsuariosX = 70;
        int VerticeUsuariosY = 120;
        int i = 0;
        for (Vertice v : g.getVertices()) {
            if (i == 0) {
                stroke(10);
                line(300, 60, VerticeUsuariosX, VerticeUsuariosY);
                line(300, 60, VerticeBloquesX, VerticeBloquesY);
                noStroke();
                fill(245, 127, 23);
                ellipse(300, 60, 50, 50);
                fill(255);
                text("S", 300 - 5, 60 + 10);
            }
            if (v.getUsuario() == null && i != 0) {
                if (v.getBloque() != null && i != 0) {
                    if (v.getBloque().id.equals(g.getBloquesAux().get(0).id)) {
                    } else {
                        stroke(10);
                        line(VerticeBloquesX, VerticeBloquesY - 105, VerticeBloquesX, VerticeBloquesY);
                    }
                    noStroke();
                    fill(0);
                    ellipse(VerticeBloquesX, VerticeBloquesY, 30, 30);
                    textSize(20);
                    fill(255);
                    text("B", VerticeBloquesX - 5, VerticeBloquesY + 10);
                    VerticeBloquesY = VerticeBloquesY + 120;
                }
            } else if (v.getUsuario() != null && i != 0) {
                if (!v.getUsuario().getNickname().equals(g.getUsuariosAux().get(0).getNickname())) {
                    stroke(10);
                    line(VerticeUsuariosX, VerticeUsuariosY - 105, VerticeUsuariosX, VerticeUsuariosY);
                }
                noStroke();
                fill(245, 127, 23);
                ellipse(VerticeUsuariosX, VerticeUsuariosY, 30, 30);
                textSize(20);
                fill(255);
                text("U", VerticeUsuariosX - 5, VerticeUsuariosY + 10);
                VerticeUsuariosY = VerticeUsuariosY + 120;
            }
            i++;
        }

    }
    boolean runOnce = true;

    public void draw() {
        background(255);
        noStroke();
        if (((mouseX >= 570 && mouseX <= 600) && (mouseY >= 0 && mouseY <= 40))) {
            cursor(HAND);
        } else {
            cursor(ARROW);
        }
        if (mousePressed == true) {
            if (((mouseX >= 570 && mouseX <= 600) && (mouseY >= 0 && mouseY <= 40))) {
                int salida = JOptionPane.showConfirmDialog(null, "Desea salir del grafo?");
                if (salida == 0) {
                    frame.setVisible(false);
                    mousePressed = false;
                }
            }
        }
        fill(0);
        textSize(24);
        text("x", 570, 30);
        drawGraph();
    }

    public void main() {
        //create your JFrame
        JFrame frame = new JFrame("Grafo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, 600, 600, 30, 30));
        this.frame = frame;
        //create your sketch
        PSketch pt = new PSketch(g);
        //get the PSurface from the sketch
        PSurface ps = pt.initSurface();

        //initialize the PSurface
        ps.setSize(600, 600);

        //get the SmoothCanvas that holds the PSurface
        SmoothCanvas smoothCanvas = (SmoothCanvas) ps.getNative();

        //SmoothCanvas can be used as a Component
        frame.add(smoothCanvas);

        //make your JFrame visible
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        //start your sketch
        ps.startThread();
    }

}
