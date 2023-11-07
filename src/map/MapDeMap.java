/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package map;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author seram
 */
public class MapDeMap<E, T> implements Grafo<E, T> {

    private Map<Vertice<E>, Map<Vertice<E>, T>> mapaVertices;

    public MapDeMap() {
        mapaVertices = new HashMap<>();
    }

    public boolean esVacio() {
        return mapaVertices.isEmpty();
    }

    public boolean estaVertice(Vertice<E> v) {
        return mapaVertices.containsKey(v);
    }

    public boolean estaArco(Arco<E, T> a) {
        for (Vertice<E> vert1 : mapaVertices.keySet()) {
            for (Vertice<E> vert2 : mapaVertices.get(vert1).keySet()) {
                return vert1 == a.getDestino() && vert2 == a.getOrigen() && mapaVertices.get(vert1).get(vert2) == a.getEtiqueta();
            }
        }
        return false;
    }

    public Iterator<Vertice<E>> vertices();

    public Iterator<Arco<E, T>> arcos();

    public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {
        List<Vertice<E>> ady = new LinkedList<>();
        for (Arco<E, T> arc : listArcos) {
            if (arc.getOrigen().equals(v)) {
                ady.add(arc.getDestino());
            }
        }
        return ady.iterator();
    }

    public void insertarVertice(Vertice<E> v);

    public void insertarArco(Arco<E, T> a);

    public void eliminarVertice(Vertice<E> v);

    public void eliminarArco(Arco<E, T> a);
}
