package com.mycompany.gradedexercise1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MenuListener implements ActionListener {

    public static final int SPINNER_MODE = 0;
    public static final int SPINNER_MODE_X = 1;
    public static final int SPINNER_MODE_Y = 2;
    public static final int SPINNER_MODE_Z = 3;
    public static final int BG_MODE = 4;
    public static final int FG_MODE = 5;
    public static final int SHAPE = 6;
    public static final int TIMER = 7;
    private final int mode;
    private final SwingPanel panel;
    private final Hashtable<String, Color> myDict;
    private final Hashtable<String, Integer> myDictSpeeds;
    private final Hashtable<String, Integer> shapesDict;

    public MenuListener(int mode, SwingPanel panel, Hashtable myDict, Prism prism) {
        
        this.mode = mode;
        this.panel = panel;
        this.myDict = myDict;
        this.myDictSpeeds = myDict;
        this.shapesDict = myDict;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        String actionCommand = event.getActionCommand();

        if (this.mode == MenuListener.BG_MODE) {
            this.panel.setBackground(myDict.get(actionCommand));

        } else if (this.mode == MenuListener.FG_MODE) {
            this.panel.setColor(myDict.get(actionCommand));
        }
        
        
        
        
        else if (this.mode == MenuListener.SHAPE){
            SwingPanel.prism = new Prism(0.8, 0.8, shapesDict.get(actionCommand));
        }
        
        
        
       
        if (this.mode == MenuListener.SPINNER_MODE) {
            Matrix a = new Matrix();
            a.rotateX(Math.PI / 400);
            Matrix b = new Matrix();
            b.rotateY(Math.PI / 400);
            Matrix c = new Matrix();
            c.rotationZ(Math.PI / 400);
            Matrix r = a.multiply(b).multiply(c);
            SwingPanel.spinner = r;
            SwingPanel.prism = new Prism(0.8, 0.8, SwingPanel.prism.getSides());
        } else if (this.mode == MenuListener.SPINNER_MODE_X) {
            Matrix rx = new Matrix();
            rx.rotateX(Math.PI / 400);
            SwingPanel.spinner = rx;
            SwingPanel.prism = new Prism(0.8, 0.8, SwingPanel.prism.getSides());
        } else if (this.mode == MenuListener.SPINNER_MODE_Y) {
            Matrix ry = new Matrix();
            ry.rotateY(Math.PI / 400);
            SwingPanel.spinner = ry;
            SwingPanel.prism = new Prism(0.8, 0.8, SwingPanel.prism.getSides());
        } else if (this.mode == MenuListener.SPINNER_MODE_Z) {
            Matrix rz = new Matrix();
            rz.rotationZ(Math.PI / 400);
            SwingPanel.spinner = rz;
            SwingPanel.prism = new Prism(0.8, 0.8, SwingPanel.prism.getSides());
        } else if (this.mode == MenuListener.TIMER){
            System.out.println("To set: "+myDictSpeeds.get(actionCommand));
            this.panel.setTimer(myDictSpeeds.get(actionCommand));
            System.out.println(this.panel.getTimer());           
        }
    }
}