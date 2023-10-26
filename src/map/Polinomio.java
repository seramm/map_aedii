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
        double coeficiente = polinomio.get(exponente);
        if (polinomio.get(exponente) == null) {
            return 0;
        }
        return coeficiente;
    }
}
