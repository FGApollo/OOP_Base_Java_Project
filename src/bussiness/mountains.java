package bussiness;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.mountain;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FGApollo
 */
public class mountains {
    private final String PATHFILE;
    private final List<mountain> DSNUI;
    
    
    public mountains(){
        this.PATHFILE = "D:\\csv\\MountainList.csv";
        this.DSNUI = new ArrayList<>();
    }
    
    public mountain get(String codemountain){
        for(mountain x : DSNUI){
                if(x.getMountainCode().equals(codemountain)){
                    return x; // tra ve nui neu tim thay
                }
        }
        return null; // tra ve null neu ko thay
    }
    
    /*public boolean checkMountainCode(String mountainCode){
        for(mountain x : DSNUI){
            if(x.getMountainCode().matches(mountainCode)){
                return true;
            }
        }
        return false;
    }*/
    public boolean checkMountainCode(String mountainCode){
        return get(mountainCode) != null;
    }
    
    public mountain dataToObject(String line){
        String [] data = line.split(",");
        
        if(data.length <4){
            return null;
        }
        return new mountain(data[0],data[1], data[2], data[3]);
            
    }
    
    //doc file csv va them doi tuong vao danh sach nui
    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.PATHFILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                mountain nui = dataToObject(line);
                if (nui != null) {
                    DSNUI.add(nui);
                }
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
    
}



    

