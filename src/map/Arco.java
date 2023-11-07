/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package map;

/**
 *
 * @author seram
 */
public class Arco<E, T> {
    private Vertice<E> origen, destino;
    private T etiqueta;

    public Arco(Vertice<E> origen, Vertice<E> destino, T etiqueta) {
        this.origen = origen;
        this.destino = destino;
        this.etiqueta = etiqueta;
    }

    public Vertice<E> getOrigen() {
        return origen;
    }

    public Vertice<E> getDestino() {
        return destino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }
    
}
