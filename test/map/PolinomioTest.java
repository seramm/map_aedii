package map;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PolinomioTest {

    public PolinomioTest() {
    }

    public static boolean iguales(Polinomio p, Polinomio q) {
        if (p.grado() != q.grado()) {
            return false;
        } else {
            for (int i = p.grado(); i >= 0; i--) {
                if (p.getCoeficiente(i) != q.getCoeficiente(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Test of grado method, of class Polinomio.
     */
    @Test
    public void testGrado() {
        System.out.println("test grado");
        Polinomio instance = new Polinomio();
        int expResult = 0;
        int result = instance.grado();
        assertEquals(expResult, result);
    }

    @Test
    public void testGrado2() {
        System.out.println("test 2 grado");
        Polinomio instance = new Polinomio();
        instance.anhadirTermino(2, 6);
        int expResult = 2;
        int result = instance.grado();
        assertEquals(expResult, result);
    }

    @Test
    public void testGrado3() {
        System.out.println("test 3 grado");
        Polinomio instance = new Polinomio();
        instance.anhadirTermino(2, 6);
        instance.anhadirTermino(2, -6);
        int expResult = 0;
        int result = instance.grado();
        assertEquals(expResult, result);
    }

    /**
     * Test of coeficiente method, of class Polinomio.
     */
    @Test
    public void testGetCoeficiente() {
        System.out.println("test getCoeficiente");
        int n = 0;
        Polinomio instance = new Polinomio();
        double expResult = 0.0;
        double result = instance.getCoeficiente(n);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetCoeficiente2() {
        System.out.println("test 2 getCoeficiente");
        int n = 1;
        Polinomio instance = new Polinomio();
        instance.anhadirTermino(2, 6);
        instance.anhadirTermino(1, -7);
        instance.anhadirTermino(0, 5);
        double expResult = -7.0;
        double result = instance.getCoeficiente(n);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetCoeficiente3() {
        System.out.println("test 3 getCoeficiente");
        int n = 3;
        Polinomio instance = new Polinomio();
        instance.anhadirTermino(2, 6);
        instance.anhadirTermino(1, -7);
        instance.anhadirTermino(0, 5);
        double expResult = 0.0;
        double result = instance.getCoeficiente(n);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetCoeficiente4() {
        System.out.println("test 4 getCoeficiente");
        int n = 1;
        Polinomio instance = new Polinomio();
        instance.anhadirTermino(2, 6);
        instance.anhadirTermino(1, -7);
        instance.anhadirTermino(0, 5);
        instance.anhadirTermino(1, 7);
        double expResult = 0.0;
        double result = instance.getCoeficiente(n);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of anhadirTermino method, of class Polinomio.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAñadirTermino() {
        System.out.println("test anhadirTermino: exponente negativo");
        int exponente = -2;
        double coeficiente = 3.0;
        Polinomio instance = new Polinomio();
        instance.anhadirTermino(exponente, coeficiente);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAñadirTermino2() {
        System.out.println("Test anhadirTermino: coeficiente 0");
        int exponente = 4;
        double coeficiente = 0.0;
        Polinomio instance = new Polinomio();
        instance.anhadirTermino(exponente, coeficiente);
    }

    /**
     * Test of eliminarTermino method, of class Polinomio.
     */
    @Test
    public void testEliminarTermino() {
        System.out.println("test eliminarTermino");
        int exponente = 0;
        Polinomio instance = new Polinomio();
        instance.eliminarTermino(exponente);
    }

    @Test
    public void testEliminarTermino2() {
        System.out.println("test 2 eliminarTermino");
        int exponente = 0;
        Polinomio instance = new Polinomio();
        instance.anhadirTermino(2, 6);
        instance.anhadirTermino(1, -7);
        instance.anhadirTermino(0, 5);
        instance.eliminarTermino(1);
        double expResult = 0.0;
        double result = instance.getCoeficiente(1);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of suma method, of class Polinomio.
     */
    @Test
    public void testSuma() {
        System.out.println("Test suma");
        Polinomio p = new Polinomio();
        p.anhadirTermino(2, 6);
        p.anhadirTermino(1, -7);
        p.anhadirTermino(0, 5);
        Polinomio instance = new Polinomio();
        instance.anhadirTermino(2, -6);
        instance.anhadirTermino(1, 7);
        instance.anhadirTermino(0, -5);
        Polinomio result = instance.suma(p);
        Polinomio expResult = new Polinomio();
        iguales(expResult, result);
    }

    @Test
    public void testSuma2() {
        System.out.println("Test 2 suma");
        Polinomio p = new Polinomio();
        p.anhadirTermino(2, 6);
        p.anhadirTermino(1, -7);
        p.anhadirTermino(0, 5);
        Polinomio instance = new Polinomio();
        instance.anhadirTermino(3, 5);
        instance.anhadirTermino(1, 6);
        instance.anhadirTermino(0, -3);
        Polinomio result = instance.suma(p);
        Polinomio expResult = new Polinomio();
        expResult.anhadirTermino(3, 5);
        expResult.anhadirTermino(2, 6);
        expResult.anhadirTermino(1, -1);
        expResult.anhadirTermino(0, 2);
        iguales(expResult, result);
    }

    /**
     * Test of derivada method, of class Polinomio.
     */
    @Test
    public void testDerivada() {
        System.out.println("Test derivada");
        Polinomio instance = new Polinomio();
        instance.anhadirTermino(3, 5);
        instance.anhadirTermino(1, 6);
        instance.anhadirTermino(0, -3);
        Polinomio result = instance.derivada();
        Polinomio expResult = new Polinomio();
        expResult.anhadirTermino(2, 15);
        expResult.anhadirTermino(0, 6);
        iguales(expResult, result);
    }
}
