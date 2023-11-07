/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package map;

import java.util.Iterator;

/**
 *
 * @author seram
 */
public interface Grafo<E, T> {

    public boolean esVacio();

    public boolean estaVertice(Vertice<E> v);

    public boolean estaArco(Arco<E, T> a);

    public Iterator<Vertice<E>> vertices();

    public Iterator<Arco<E, T>> arcos();

    public Iterator<Vertice<E>> adyacentes(Vertice<E> v);

    public void insertarVertice(Vertice<E> v);

    public void insertarArco(Arco<E, T> a);

    public void eliminarVertice(Vertice<E> v);

    public void eliminarArco(Arco<E, T> a);
}
