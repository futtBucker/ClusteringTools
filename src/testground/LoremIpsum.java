/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testground;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Agustinus Agri
 */
public class LoremIpsum {
    
    /**
     * Testing Ground
     */
    public static void test() {
        double[][] x = new double[][]{{1,2,3},{4,5,6}};
        
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println("");
        }
        
        System.out.println("===");
        
        double[] a = new double[]{1,2,3,4,5};
        
        for (int i = 0; i < a.length; i++) {
            a[i] /= 5;
            System.out.println(a[i]);
        }
        System.out.println("===");
        
        List<Integer> li = new ArrayList<>();
        
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(4);
        li.add(5);
        
        Iterator<Integer> iterator = li.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
        }
        System.out.println("===");
        Iterator<Integer> itr = li.iterator();
        while (itr.hasNext()) {
            Integer integer = itr.next();
            System.out.println(integer);
        }
        
    }
    
}
