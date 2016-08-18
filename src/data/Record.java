/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author Agustinus Agri
 */
public class Record {
    
    private int identifier;
    private double[] data;
    private int clusterAssigned;

    public Record() {
    }

    public Record(double[] data) {
        this.data = data;
    }

    public Record(int identifier, double[] data) {
        this.identifier = identifier;
        this.data = data;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }

    public int getClusterAssigned() {
        return clusterAssigned;
    }

    public void setClusterAssigned(int clusterAssigned) {
        this.clusterAssigned = clusterAssigned;
    }

    public void view() {
        for (int i = 0; i < this.data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("    ==> " + clusterAssigned);
    }
    
    
    
}
