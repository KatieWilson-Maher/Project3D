package com.mycompany.gradedexercise1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VectorTest {

    private static final double EPSILON = 1E-8;

    public VectorTest() {
    }
    
    public void compare(Vector expected, Vector actual){
        assertEquals(expected.get(0), actual.get(0), EPSILON);
        assertEquals(expected.get(1), actual.get(1), EPSILON);
        assertEquals(expected.get(2), actual.get(2), EPSILON);
        assertEquals(expected.get(3), actual.get(3), EPSILON);
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of dot method, of class Vector.
     */
    @Test
    public void testDot() { //DONE
        Vector v1 = new Vector(0, 1, 2);
        Vector v2 = new Vector(3, 4, 5);
        double expected = 15;
        double actual = v1.dot(v2);
        assertEquals(expected, actual);
    }

    /**
     * Test of magnitude method, of class Vector.
     */
    @Test
    public void testMagnitude() { //DONE
        Vector v = new Vector(3, 4, 5);
        double expected = Math.sqrt(51);
        double actual = v.magnitude();
        assertEquals(expected, actual);
    }

    /**
     * Test of normalize method, of class Vector.
     */
    @Test
    public void testNormalize() { //DONE
        Vector v = new Vector(0,1,2);
        Vector expected = new Vector(0/Math.sqrt(6),1/Math.sqrt(6),2/Math.sqrt(6));
        expected.set(3,1/Math.sqrt(6));
        Vector actual = v.normalize();
        compare(expected,actual);
    }

    /**
     * Test of cross method, of class Vector.
     */
    @Test
    public void testCross() { //DONE
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);
        Vector expected = new Vector(-3, 6, -3);
        Vector actual = v1.cross(v2);
        compare(expected, actual);
    }

    /**
     * Test of get method, of class Vector.
     */
    @Test
    public void testGet() { //DONE
        Vector v = new Vector(1, 2, 3);
        double expected = 2.0d;
        double actual = v.get(1);
        assertEquals(expected, actual);
    }

    /**
     * Test of set method, of class Vector.
     */
    @Test
    public void testSet() { //DONE
        Vector expected = new Vector(0, 0, 0);
        Vector actual = new Vector();
        actual.set(3, 1);
        compare(expected, actual);
    }

    /**
     * Test of toString method, of class Vector.
     */
    @Test
    public void testToString() { //DONE
        System.out.println("toString");
        Vector instance = new Vector(1, 2, 3);
        String expected = "(1.0, 2.0, 3.0, 1.0)";
        String actual = instance.toString();
        assertEquals(expected, actual);
    }
}
