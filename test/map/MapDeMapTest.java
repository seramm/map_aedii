/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package map;

import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;




public class MapDeMapTest {
    
    
    
    Grafo<String, Integer> g = new MapDeMap<>();
    
    Vertice<String> v1 = new Vertice<>("Coruña");
    Vertice<String> v2 = new Vertice<>("Lugo");
    Vertice<String> v3 = new Vertice<>("Ourense");
    Vertice<String> v4 = new Vertice<>("Pontevedra");
    Vertice<String> v5 = new Vertice<>("Leon");
    
    Arco<String, Integer> a1 = new Arco<>(v2, v1, 10);
    Arco<String, Integer> a2 = new Arco<>(v1, v3, 20); 
    Arco<String, Integer> a3 = new Arco<>(v2, v4, 115);
    Arco<String, Integer> a4 = new Arco<>(v3, v4, 100);
    Arco<String, Integer> a5 = new Arco<>(v4, v3, 120); 
    Arco<String, Integer> a6 = new Arco<>(v2, v5, 2);
    
    List<Vertice<String>> lVer = new LinkedList<>();
    List<Vertice<String>> lAdy = new LinkedList<>();
    List<Arco<String,Integer>> lArc = new LinkedList<>();
    
        
    @Before
    public void setUp() {
       g.insertarArco(a1);
       g.insertarArco(a2);
       g.insertarArco(a3);
       g.insertarArco(a4);
       g.insertarArco(a5);
        
        
       lVer.add(v1); lVer.add(v2); lVer.add(v3); lVer.add(v4);
       lArc.add(a1);lArc.add(a2);lArc.add(a3);lArc.add(a4);lArc.add(a5);
       lAdy.add(v1); lAdy.add(v4);
    }
    
    public static <E> boolean iguales (Iterator<E> it1, Iterator<E> it2){
        while(it1.hasNext() && it2.hasNext()){
            if (!it1.next().equals(it2.next()))
                return false;
        }
        return !it1.hasNext() && !it2.hasNext();
    }

    /**
     * Test of esVacio method, of class MapDeMap.
     */
    @Test
    public void testEsVacioCierto() {
        System.out.println("Test 'esVacio' cierto");
        Grafo<String, Integer> instance = new MapDeMap<>();
        boolean expResult = true;
        boolean result = instance.esVacio();
        assertEquals(expResult, result);
    }
    @Test
    public void testEsVacioFalso() {
        System.out.println("Test 'esVacio' falso");
        boolean expResult = false;
        boolean result = g.esVacio();
        assertEquals(expResult, result);
    }

    /**
     * Test of estaVertice method, of class MapDeMap.
     */
    @Test
    public void testEstaVerticeCierto() {
        System.out.println("Test 'estaVertice' cierto");
        boolean expResult = true;
        boolean result = g.estaVertice(v3);
        assertEquals(expResult, result);
    }
    @Test
    public void testEstaVerticeFalso() {
        System.out.println("Test 'estaVertice' falso");
        boolean expResult = false;
        boolean result = g.estaVertice(v5);
        assertEquals(expResult, result);
    }

    /**
     * Test of estaArco method, of class MapDeMap.
     */
    @Test
    public void testEstaArcoCierto() {
        System.out.println("Test 'estaArco' cierto");
        boolean expResult = true;
        boolean result = g.estaArco(a1);
        assertEquals(expResult, result);
    }
    @Test
    public void testEstaArcoFalso() {
        System.out.println("Test 'estaArco' falso");
        boolean expResult = false;
        boolean result = g.estaArco(a6);
        assertEquals(expResult, result);
    }

    /**
     * Test of vertices method, of class MapDeMap.
     */
    @Test
    public void testVertices() {
        System.out.println("Test 'vertices'");
        Iterator<Vertice<String>> expResult = lVer.iterator();
        Iterator<Vertice<String>> result = g.vertices();
        iguales(expResult, result);
    }

    /**
     * Test of arcos method, of class MapDeMap.
     */
    @Test
    public void testArcos() {
        System.out.println("Test 'arcos'");
        Iterator<Arco<String,Integer>> expResult = lArc.iterator();
        Iterator<Arco<String,Integer>> result = g.arcos();
        iguales(expResult, result);
    }

    /**
     * Test of adyacentes method, of class MapDeMap.
     */
    @Test
    public void testAdyacentes() {
        System.out.println("Test 'adyacentes'");
        Iterator<Vertice<String>> expResult = lAdy.iterator();
        Iterator<Vertice<String>> result = g.adyacentes(v2);
        iguales(expResult, result);
    }

    /**
     * Test of insertarVertice method, of class MapDeMap.
     */
    @Test
    public void testInsertarVertice() {
        System.out.println("Test 'insertarVertice'");
        g.insertarVertice(v5);
        lVer.add(v5);
        iguales(g.vertices(),lVer.iterator());
    }

    /**
     * Test of insertarArco method, of class MapDeMap.
     */
    @Test
    public void testInsertarArco() {
        System.out.println("Test 'insertarArco'");
        g.insertarArco(a6);
        lArc.add(a6);
        iguales(g.arcos(), lArc.iterator());
    }

    /**
     * Test of eliminarVertice method, of class MapDeMap.
     */
    @Test
    public void testEliminarVertice() {
        System.out.println("Test 'eliminarVertice'");
        g.eliminarVertice(v1);
        lVer.remove(v1);
        iguales(g.vertices(), lVer.iterator());
    }

    /**
     * Test of eliminarArco method, of class MapDeMap.
     */
    @Test
    public void testEliminarArco() {
        System.out.println("Test 'eliminarArco'");
        g.eliminarArco(a1);
        lArc.remove(a1);
        iguales(g.arcos(), lArc.iterator());
    }
    
}
