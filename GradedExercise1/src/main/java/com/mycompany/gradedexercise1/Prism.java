package com.mycompany.gradedexercise1;

import java.util.ArrayList;

/**
 *
 * @author katie
 */
public class Prism {

    ArrayList<Triangles> triangles = new ArrayList<>();
    private int numberOfSides;

    public Prism(double height, double radius, int sides) {
        
        this.numberOfSides = sides;
        Vector topCenter = new Vector(0, 0, height / 2);
        Vector bottomCenter = new Vector(0, 0, -height / 2);
        ArrayList<Vector> topPoints = new ArrayList<>();
        ArrayList<Vector> bottomPoints = new ArrayList<>();

        for (double theta = 0; theta <= 2 * Math.PI; theta += (Math.PI * 2) / (double) sides) {
            topPoints.add(new Vector(radius * (Math.cos(theta)), radius * (Math.sin(theta)), height / 2));
            bottomPoints.add(new Vector(radius * (Math.cos(theta)), radius * (Math.sin(theta)), -height / 2));
        }

        for (int i = 0; i < sides; i++) {
            Vector p1 = new Vector(topCenter.get(0), topCenter.get(1), topCenter.get(2));
            Vector p2 = new Vector(topPoints.get(i).get(0), topPoints.get(i).get(1), topPoints.get(i).get(2));
            Vector p3 = new Vector(topPoints.get((i + 1) % sides).get(0), topPoints.get((i + 1) % sides).get(1), topPoints.get((i + 1) % sides).get(2));
            triangles.add(new Triangles(p1, p2, p3));

            Vector p4 = new Vector(bottomCenter.get(0), bottomCenter.get(1), bottomCenter.get(2));
            Vector p5 = new Vector(bottomPoints.get(i).get(0), bottomPoints.get(i).get(1), bottomPoints.get(i).get(2));
            Vector p6 = new Vector(bottomPoints.get((i + 1) % sides).get(0), bottomPoints.get((i + 1) % sides).get(1), bottomPoints.get((i + 1) % sides).get(2));
            triangles.add(new Triangles(p4, p6, p5));

            Vector p7 = new Vector(topPoints.get(i).get(0), topPoints.get(i).get(1), topPoints.get(i).get(2));
            Vector p8 = new Vector(bottomPoints.get(i).get(0), bottomPoints.get(i).get(1), bottomPoints.get(i).get(2));
            Vector p9 = new Vector(bottomPoints.get((i + 1) % sides).get(0), bottomPoints.get((i + 1) % sides).get(1), bottomPoints.get((i + 1) % sides).get(2));
            triangles.add(new Triangles(p7, p8, p9));

            Vector p10 = new Vector(topPoints.get(i).get(0), topPoints.get(i).get(1), topPoints.get(i).get(2));
            Vector p11 = new Vector(bottomPoints.get((i + 1) % sides).get(0), bottomPoints.get((i + 1) % sides).get(1), bottomPoints.get((i + 1) % sides).get(2));
            Vector p12 = new Vector(topPoints.get((i + 1) % sides).get(0), topPoints.get((i + 1) % sides).get(1), topPoints.get((i + 1) % sides).get(2));
            triangles.add(new Triangles(p10, p11, p12));
        }
    }

    public ArrayList<Triangles> getFaces() {
        return triangles;
    }
    
    public int getSides(){
        return this.numberOfSides;
    }

    public void transform(Matrix m) {
        for (Triangles t : triangles) {
            t.transform(m);
        }
    }
}