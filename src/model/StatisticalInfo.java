/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author FGApollo
 */
public class StatisticalInfo {
    private final String MOUNTAINCODE;
    private int numOfStudent;
    private double totalCost;


    public StatisticalInfo(String MOUNTAINCODE) {
        this.MOUNTAINCODE = MOUNTAINCODE;
        this.numOfStudent = 0;
        this.totalCost = 0;
    }

    public void addStudent(double fee) {
        this.numOfStudent++;
        this.totalCost += fee;
    }

    public String getMountainCode() {
        return MOUNTAINCODE;
    }

    public int getNumOfStudent() {
        return numOfStudent;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-22d | %-15.0f", MOUNTAINCODE, numOfStudent, totalCost);
    }
}

