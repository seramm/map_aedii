/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package map;

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
}
