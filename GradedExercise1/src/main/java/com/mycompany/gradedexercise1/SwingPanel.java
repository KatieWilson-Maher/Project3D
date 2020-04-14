package com.mycompany.gradedexercise1;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;

import java.util.ArrayList;

/**
 *
 * @author katie
 */
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.List;

public class SwingPanel extends JPanel implements ActionListener {

    private Shape shape;
    private Color color = Color.red;
    public static Prism prism;
    public static Matrix spinner;
    private int timerNum = 25;
    private final Vector illumination;
    private final Timer timer;

    public SwingPanel() {
        
        this.timer = new Timer(25, this);
        timer.start();

        this.prism = new Prism(0.8, 0.8, 8);

        Matrix a = new Matrix();
        a.rotateX(Math.PI / 400);
        Matrix b = new Matrix();
        b.rotateY(Math.PI / 400);
        Matrix c = new Matrix();
        c.rotationZ(Math.PI / 400);
        this.spinner = a.multiply(b).multiply(c);
        
        this.illumination = (new Vector(1.0, 2.0, 3.0)).normalize();
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color c) {
        this.color = c;
    } 

    public void setTimer(int t){
        this.timerNum = t;
    }
    
    public int getTimer(){
        return this.timerNum;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform transform = new AffineTransform();
        AffineTransform scaling = new AffineTransform();
        scaling.setToScale(w / 2, h / 2);

        AffineTransform translation = new AffineTransform();
        double cx = 1.0;
        double cy = 1.0;
        translation.setToTranslation(cx, cy);

        transform.concatenate(scaling);
        transform.concatenate(translation);

        ArrayList<Triangles> faces = this.prism.getFaces();
        for (Triangles p : faces) {
            Shape s = transform.createTransformedShape(p.getShape());

            Vector normal = p.getNormal();
            if (normal.get(2) > 0) {
                double brightness = normal.dot(illumination);

                Color c = this.getColor();

                double ambient = 0.2;
                int red;
                int green;
                int blue;
                if (brightness > 0) {
                    red = (int) (brightness * c.getRed());
                    green = (int) (brightness * c.getGreen());
                    blue = (int) (brightness * c.getBlue());
                }
                else {
                    red = (int) (ambient * c.getRed());
                    green = (int) (ambient * c.getGreen());
                    blue = (int) (ambient * c.getBlue());
                }
                Color shade = new Color(red, green, blue);

                g2D.setColor(shade);
                g2D.fill(s);
            } 
        } 
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        this.timer.setDelay(timerNum);
        
        this.prism.transform(spinner);
        
        this.repaint();
    } 
}