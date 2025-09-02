/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

/**
 *
 * @author FGApollo
 */

import java.util.HashMap;
import java.util.List;
import model.StatisticalInfo;
import model.Student;

public final class Statistics extends HashMap<String, StatisticalInfo> {
    public Statistics() {
        super();
    }

    public Statistics(List<Student> list) {
        this.statisticalize(list);
    }

    public void statisticalize(List<Student> list) {
        

        for (Student stu : list) {
            String mountainCode = stu.getMountain();
            double fee = stu.getFee();

            // neu nui chua co trong danh sach thong ke thi them moi
            this.putIfAbsent(mountainCode, new StatisticalInfo(mountainCode));
            this.get(mountainCode).addStudent(fee);
        }
    }

    public void show() {
        System.out.println("Statistics of Registration by Mountain Peak:");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-15s\n", "Peak Code", "Number of Participants", "Total Cost");
        System.out.println("-----------------------------------------------------------------");

        for (StatisticalInfo x : this.values()) {
            System.out.println(x);
        }

        System.out.println("-----------------------------------------------------------------");
    }
    
    public void highestfeemountain(){
        if(this.isEmpty()){
            System.out.println("empty");
        }
        
        StatisticalInfo highestmountain = null;
        for(StatisticalInfo x : this.values()){
            if(highestmountain == null || x.getTotalCost()< highestmountain.getTotalCost()){
                highestmountain = x;
            }
        }
        
        if(highestmountain != null){
            System.out.println("highest revenue mountain");
            System.out.printf("%-10s | %-15s\n","PeakCode","Fee");
            
            System.out.printf("%-10s | %-15s\n",highestmountain.getMountainCode(),highestmountain.getTotalCost());
        }
    }
    
    public void highestNumberPartiMountain(){
        if(this.isEmpty()){
            System.out.println("empty");
        }
        
        StatisticalInfo highestmountain = null;
        for(StatisticalInfo x : this.values()){
            if(highestmountain == null || x.getNumOfStudent()< highestmountain.getNumOfStudent()){
                highestmountain = x;
            }
        }
        
        if(highestmountain != null){
            System.out.println("highest revenue mountain");
            System.out.printf("%-10s | %-15s\n","PeakCode","Fee");
            
            System.out.printf("%-10s | %-15s\n",highestmountain.getMountainCode(),highestmountain.getTotalCost());
        }
    }
    
    
}



