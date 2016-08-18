/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans;

import data.Record;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import math.DistanceFunction;

/**
 *
 * @author Agustinus Agri
 */
public class KMeans {

    private List<List<Record>> clusteredRecordList;
    private List<Record> recordList;
    private int k;
    private List<double[]> centroid;

    private int maxIteration = 1000;
    private boolean converge = false;

    /**
     * Konstruktor kelas K-Means
     * @param recordList List berisi record (data) yang akan diolah
     * @param k jumlah cluster yang akan dibentuk
     * @param centroid centroid awal
     * @param maxIteration batas iterasi maksimum, default 1000
     */
    public KMeans(List<Record> recordList, int k, List<double[]> centroid, int maxIteration) {

        if (centroid.size() != k) {
            throw new IllegalArgumentException("Jumlah centroid tidak sama dengan jumlah cluster");
        }

        this.recordList = recordList;
        this.k = k;
        this.maxIteration = maxIteration;
        this.centroid = centroid;
    }

    /**
     * Melakukan k-Means untuk data yang telah dimasukkan via constructor. Disini k-Means berhenti apabila konvergen atau melebihi batas iterasi yang ditentukan
     */
    public void performKMeans() {
        
        int iter = 0;

        while (!this.converge && iter <= this.maxIteration) {
            resetClusteredRecordList();
            Iterator<Record> iterRec = this.recordList.iterator();
            while (iterRec.hasNext()) {
                Record record = iterRec.next();
                assignToNearestCluster(record);
            }
            calculateNewCentroid();
            iter++;
        }
    }

    /**
     * Menaruh data ke cluster yang terdekat
     * @param record data yang akan ditaruh
     */
    private void assignToNearestCluster(Record record) {
        Iterator<double[]> iterCentroid = this.centroid.iterator();
        double nearest = Double.MAX_VALUE;
        int iter = 0;
        while (iterCentroid.hasNext()) {
            double[] centroid = iterCentroid.next();
            double distance = DistanceFunction.euclideanDistance(record.getData(), centroid);
            if (distance <= nearest) {
                nearest = distance;
            } else {
                iter++;
            }
        }
        record.setClusterAssigned(iter);        
        
        this.clusteredRecordList.get(iter).add(record);
    }
    
    /**
     * Menghapus isi List clusteredRecordList agar saat digunakan lagi tidak bertumpuk. 
     * Method ini sekaligus menginisialisasi jumlah node dalam list sesuai dengan jumlah k
     */
    private void resetClusteredRecordList() {
        this.clusteredRecordList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            this.clusteredRecordList.add(new ArrayList<Record>());
        }
    }
    
    /**
     * Menghitung centroid baru dari hasil assignment data ke cluster terdekat. Penghitungan dengan mean dari data.
     * Apabila tidak terjadi perubahan dengan centroid lama (konvergen), maka variabel global "converge" akan diubah menjadi true.
     */
    private void calculateNewCentroid() {
        int sameness = 0;
        for (int i = 0; i < k; i++) {
            List<Record> recordList = this.clusteredRecordList.get(i);
            int numberOfData = recordList.size();
            double[] sum = new double[recordList.get(0).getData().length];
            Iterator<Record> iterRecord = recordList.iterator();
            while (iterRecord.hasNext()) {
                Record record = iterRecord.next();
                double[] data = record.getData();
                for (int j = 0; j < data.length; j++) {
                    sum[j] += data[j];
                }
            }
            
            for (int j = 0; j < sum.length; j++) {
                sum[j] /= numberOfData;
            }
            
            if (DistanceFunction.euclideanDistance(sum, this.centroid.get(i)) == 0) {
                sameness++;
            } else {
                this.centroid.set(i, sum);
            }       
        }
        
        if (sameness == k) {
            this.converge = true;
        }
    }

    public List<double[]> getCentroid() {
        return centroid;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public List<List<Record>> getClusteredRecordList() {
        return clusteredRecordList;
    }

}
