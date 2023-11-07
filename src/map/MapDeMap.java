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

    @Override
    public boolean esVacio() {
        return mapaVertices.isEmpty();
    }

    @Override
    public boolean estaVertice(Vertice<E> v) {
        return mapaVertices.containsKey(v);
    }

    @Override
    public boolean estaArco(Arco<E, T> a) {
        return this.mapaVertices.get(a.getOrigen()) != null
                && this.mapaVertices.get(a.getOrigen()).get(a.getDestino()) != null
                && this.mapaVertices.get(a.getDestino()).equals(a.getEtiqueta());
    }

    @Override
    public Iterator<Vertice<E>> vertices() {
        return mapaVertices.keySet().iterator();
    }

    @Override
    public Iterator<Arco<E, T>> arcos() {

    }

    @Override
    public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {
        List<Vertice<E>> ady = new LinkedList<>();
        for (Arco<E, T> arc : arcos()) {
            if (arc.getOrigen().equals(v)) {
                ady.add(arc.getDestino());
            }
        }
        return ady.iterator();
    }

    @Override
    public void insertarVertice(Vertice<E> v);

    @Override
    public void insertarArco(Arco<E, T> a);

    @Override
    public void eliminarVertice(Vertice<E> v);

    @Override
    public void eliminarArco(Arco<E, T> a);
}
