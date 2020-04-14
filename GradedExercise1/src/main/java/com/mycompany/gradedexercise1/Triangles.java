package com.mycompany.gradedexercise1;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

/**
 *
 * @author katie
 */
class Triangles {

    private ArrayList<Vector> points = new ArrayList<>();

    public Triangles(Vector a, Vector b, Vector c) {
        this.points.add(a);
        this.points.add(b);
        this.points.add(c);
    }

    public void transform(Matrix m) {
        for (Vector p : points) {
            p.transform(m);
        }
    }

    public Shape getShape() {
        
        GeneralPath path = new GeneralPath();

        Vector v = this.points.get(0);
        double x = v.get(0);
        double y = v.get(1);
        path.moveTo(x, y);

        for (int i = 1; i < this.points.size(); i++) {
            v = this.points.get(i);
            x = v.get(0);
            y = v.get(1);
            path.lineTo(x, y);
        }

        path.closePath();

        return path;
    }

    public Vector getNormal() {
        Vector p0 = this.points.get(0);
        Vector p1 = this.points.get(1);
        Vector p2 = this.points.get(2);

        Vector v0 = p2.subtract(p1);
        Vector v1 = p0.subtract(p1);

        Vector crossProduct = v0.cross(v1);

        return crossProduct.normalize();
    }
}