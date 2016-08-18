/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package math;

/**
 *
 * @author Agustinus Agri
 */
public class DistanceFunction {
    
    /**
     * Fungsi jarak untuk menghitung jarak antara dua vektor
     * @param pointA vektor A - misal data #
     * @param pointB vektor B - misal centroid #
     * @return nilai jarak dari kedua vektor
     */
    public static double euclideanDistance(double[] pointA, double[] pointB) {
        
        if (pointA.length != pointB.length) {
            throw new IllegalArgumentException("Length vektor tidak sama");
        }
        
        double sum = 0;
        for (int i = 0; i < pointA.length; i++) {
            sum += Math.pow(pointB[i] - pointA[i], 2);
        }
        
        return Math.sqrt(sum);
        
    }
    
}
