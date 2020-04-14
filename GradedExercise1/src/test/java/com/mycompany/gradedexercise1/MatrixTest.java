/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gradedexercise1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    private static final double EPSILON = 1E-8;

    public MatrixTest() {
    }

    public void compare(Matrix m1, Matrix m2) {
        for (int m1Row = 0; m1Row < 4; m1Row++) {
            for (int m1Column = 0; m1Column < 4; m1Column++) {
                double m1Val = m1.get(m1Row, m1Column);
                double m2Val = m2.get(m1Row, m1Column);
                assertEquals(m1Val, m2Val, EPSILON);
            }
        }
    }

    public void compare(Vector expected, Vector actual) {
        assertEquals(expected.get(0), actual.get(0), EPSILON);
        assertEquals(expected.get(1), actual.get(1), EPSILON);
        assertEquals(expected.get(2), actual.get(2), EPSILON);
        assertEquals(expected.get(3), actual.get(3), EPSILON);
    }

    public Matrix fill(Matrix m) {
        int i = 0;
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                m.set(row, column, i);
                i += 1;
            }
        }
        return m;
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
    /**
     * Test of get method, of class Matrix.
     */
    @org.junit.jupiter.api.Test
    public void testGet() { //DONE
        Matrix m = new Matrix();
        double actual = m.get(1, 1);
        double expected = 1;
        assertEquals(actual, expected);
    }

    /**
     * Test of set method, of class Matrix.
     */
    @org.junit.jupiter.api.Test
    public void testSet() { //DONE
        Matrix m1 = new Matrix();
        int i = 0;
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                m1.set(row, column, i);
                i += 1;
            }
        }
        String actual = m1.toString();
        String expected = "[ 0.0, 1.0, 2.0, 3.0 ]\n[ 4.0, 5.0, 6.0, 7.0 ]\n[ 8.0, 9.0, 10.0, 11.0 ]\n[ 12.0, 13.0, 14.0, 15.0 ]\n";
        assertEquals(expected, actual);
    }

    /**
     * Test of identity method, of class Matrix.
     */
    @org.junit.jupiter.api.Test
    public void testIdentity() { //DONE
        Matrix expected = new Matrix();
        Matrix actual = new Matrix();
        int i = 0;
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                actual.set(row, column, i);
                i += 1;
            }
        }
        actual.identity();
        compare(expected, actual);
    }

    /**
     * Test of toString method, of class Matrix.
     */
    @org.junit.jupiter.api.Test
    public void testToString() { //DONE
        Matrix actual = new Matrix();
        String actualString = actual.toString();
        String expected = "[ 1.0, 0.0, 0.0, 0.0 ]\n[ 0.0, 1.0, 0.0, 0.0 ]\n[ 0.0, 0.0, 1.0, 0.0 ]\n[ 0.0, 0.0, 0.0, 1.0 ]\n";
        assertEquals(expected, actualString);
    }

    /**
     * Test of multiply method, of class Matrix.
     */
    @org.junit.jupiter.api.Test
    public void testMultiply_Matrix() { //DONE
        Matrix m1 = new Matrix();
        fill(m1);
        Matrix m2 = new Matrix();
        fill(m2);
        Matrix actual = m1.multiply(m2);
        String actualString = actual.toString();
        String expected = "[ 56.0, 62.0, 68.0, 74.0 ]\n[ 152.0, 174.0, 196.0, 218.0 ]\n[ 248.0, 286.0, 324.0, 362.0 ]\n[ 344.0, 398.0, 452.0, 506.0 ]\n";
        assertEquals(expected, actualString);

    }

    /**
     * Test of rotateX method, of class Matrix.
     */
    @org.junit.jupiter.api.Test
    public void testRotateX() { //FIX
        double angle = 10;
        Matrix actual = new Matrix();
        actual.rotateX(angle);
        Matrix expected = new Matrix();
        expected.set(1, 1, Math.cos(angle));
        expected.set(1, 2, -Math.sin(angle));
        expected.set(2, 1, Math.sin(angle));
        expected.set(2, 2, Math.cos(angle));
        compare(expected, actual);
        System.out.println("Hello");
    }

    /**
     * Test of rotateY method, of class Matrix.
     */
    @org.junit.jupiter.api.Test
    public void testRotateY() { //FIX
        double angle = 10;
        Matrix actual = new Matrix();
        actual.rotateY(angle);
        Matrix expected = new Matrix();
        expected.set(0, 0, Math.cos(angle));
        expected.set(0, 2, Math.sin(angle));
        expected.set(2, 0, -Math.sin(angle));
        expected.set(2, 2, Math.cos(angle));
        compare(expected, actual);

    }

    /**
     * Test of rotationZ method, of class Matrix.
     */
    @org.junit.jupiter.api.Test
    public void testRotationZ() { //TO DO
        double angle = 10;
        Matrix actual = new Matrix();
        actual.rotationZ(angle);
        Matrix expected = new Matrix();
        expected.set(0, 0, Math.cos(angle));
        expected.set(0, 1, -Math.sin(angle));
        expected.set(1, 0, Math.sin(angle));
        expected.set(1, 1, Math.cos(angle));
        compare(expected, actual);
    }

    /**
     * Test of scale method, of class Matrix.
     */
    @org.junit.jupiter.api.Test
    public void testScale() { //DONE
        Matrix expected = new Matrix();
        Matrix actual = new Matrix();
        actual.scale(10, 11, 12);
        expected.set(0, 0, 10);
        expected.set(1, 1, 11);
        expected.set(2, 2, 12);
        compare(expected, actual);
    }

    /**
     * Test of translate method, of class Matrix.
     */
    @org.junit.jupiter.api.Test
    public void testTranslate() { //DONE
        Matrix expected = new Matrix();
        Matrix actual = new Matrix();
        actual.translate(1, 2, 3);
        expected.set(3, 0, 1);
        expected.set(3, 1, 2);
        expected.set(3, 2, 3);
        compare(expected, actual);
    }

    /**
     * Test of multiply method, of class Matrix.
     */
    @org.junit.jupiter.api.Test
    public void testMultiply_Vector() {
        Matrix actualEmptyM = new Matrix();
        Matrix actualM = fill(actualEmptyM);
        Vector actualV = new Vector(0, 1, 2);
        Vector actualAns = actualM.multiply(actualV);

        Vector expected = new Vector(8, 24, 40);
        expected.set(3, 56);
        compare(expected, actualAns);

    }
    

}
