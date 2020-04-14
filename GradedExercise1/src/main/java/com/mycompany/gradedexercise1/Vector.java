package com.mycompany.gradedexercise1;

/**
 *
 * @author katie
 */
public class Vector {

    private double x, y, z, h;

    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.h = 0;
    }

    public Vector(double one, double two, double three) {
        x = one;
        y = two;
        z = three;
        h = 1;
    }

    public double dot(Vector v) {
        return this.x * v.get(0) + this.y * v.get(1) + this.z * v.get(2) + this.h * v.get(3);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z + h * h);
    }

    public Vector normalize() {
        Vector newV = new Vector();
        double mag = this.magnitude();
        newV.set(0, this.x / mag);
        newV.set(1, this.y / mag);
        newV.set(2, this.z / mag);
        newV.set(3, this.h / mag);
        return newV;
    }

    public Vector cross(Vector v) {
        double cx = y * v.get(2) - z * v.get(1);
        double cy = z * v.get(0) - x * v.get(2);
        double cz = x * v.get(1) - y * v.get(0);
        Vector c = new Vector(cx, cy, cz);
        return c;
    }

    public double get(int index) {
        double returnValue = 0;
        if (index == 0) {
            returnValue = this.x;
        }
        if (index == 1) {
            returnValue = this.y;
        }
        if (index == 2) {
            returnValue = this.z;
        }
        if (index == 3) {
            returnValue = this.h;
        }
        return returnValue;
    }

    public void set(int index, double val) {
        if (index == 0) {
            this.x = val;
        }
        if (index == 1) {
            this.y = val;
        }
        if (index == 2) {
            this.z = val;
        }
        if (index == 3) {
            this.h = val;
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + h + ")";
    }

    //from Leon Tabak
    public Vector subtract(Vector v) {
        double x1 = this.get(0) - v.get(0);
        double y1 = this.get(1) - v.get(1);
        double z1 = this.get(2) - v.get(2);
        return new Vector(x1, y1, z1);
    }

    public void set(Vector v) {
        this.x = v.get(0);
        this.y = v.get(1);
        this.z = v.get(2);
        this.h = v.get(3);
    }

    public void transform(Matrix m) {
        Vector newV = new Vector();
        int vectorIndex = 0;
        int indexNewV = 0;
        double newVValue = 0;
        for (int row = 0; row < 4; row++) {
            vectorIndex = 0;
            for (int column = 0; column < 4; column++) {
                double currentM = m.get(row, column);
                double currentV = this.get(vectorIndex);
                double newVal = currentM * currentV;
                newVValue += newVal;
                if (vectorIndex == 3) {
                    newV.set(indexNewV, newVValue);
                    indexNewV += 1;
                    newVValue = 0;
                }
                vectorIndex += 1;
            }
        }
        this.set(newV);
    }

    public static void main(String[] args) {
        Matrix m = new Matrix();
        m.set(1, 1, 2);
        Vector v = new Vector(1, 2, 3);
        System.out.println("v: " + v.toString());
        Vector u = new Vector(1, 2, 3);
        System.out.println("u: " + u.toString());
        v.transform(m);
        System.out.println("v after transform: " + v);
        System.out.println("u after transform: " + m.multiply(u));
    }
}