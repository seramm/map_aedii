/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package map;

import java.util.Set;

/**
 *
 * @author seram
 */
public class Polinomio {

    private Map<Integer, Double> polinomio;

    public Polinomio() {
        polinomio = new HashMap<>();
    }

    public int grado() {
        int max = 0;
        for (int i : polinomio.keySet()) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public double getCoeficiente(int exponente) throws IllegalArgumentException {
        if (exponente < 0) {
            throw new IllegalArgumentException("Polinomio: exponente negativo no valido");
        }
        Double coeficiente = polinomio.get(exponente);
        if (coeficiente == null) {
            return 0;
        }
        return coeficiente;
    }

    public void anhadirTermino(int exponente, double coeficiente) throws IllegalArgumentException {
        if (exponente < 0 || coeficiente == 0) {
            throw new IllegalArgumentException("Polinomio: parametros no validos");
        }
        double coefAux = getCoeficiente(exponente);
        double sumaCoef = coefAux + coeficiente;
        if (sumaCoef == 0) {
            polinomio.remove(exponente);
        } else {
            polinomio.put(exponente, sumaCoef);
        }
    }

    public void eliminarTermino(int exponente) throws IllegalArgumentException {
        if (exponente < 0) {
            throw new IllegalArgumentException("Polinomio: exponente no valido");
        }
        polinomio.remove(exponente);
    }

    public Polinomio suma(Polinomio p) throws NullPointerException {
        if (p == null) {
            throw new NullPointerException("Polinomio: p es nul");
        }
        Polinomio polinomioNuevo = this;
        Set<Integer> a = p.polinomio.keySet();
        for (Integer i : p.polinomio.keySet()) {
            polinomioNuevo.anhadirTermino(i, polinomioNuevo.polinomio.get(i));
        }
        return polinomioNuevo;
    }

    public Polinomio derivada() {
        Polinomio polinomioNuevo = new Polinomio();
        Set<Integer> keys = polinomio.keySet();
        for (Integer i : keys) {
            if (i != 0) {
                Double coef = this.getCoeficiente(i);
                polinomioNuevo.anhadirTermino(i - 1, coef * i);
            }
        }
        return polinomioNuevo;
    }
}
