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
}
