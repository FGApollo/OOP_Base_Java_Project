package main;



import bussiness.Students;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FGApollo
 */
public class Main {
    public static void main(String[] args) {
        
        Students hs = new Students();
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("1.New Registration:");
            System.out.println("2.Update Registration Information");
            System.out.println("3.Display Registered List");
            System.out.println("4.Delete Registration Information");
            System.out.println("5.Search Participants by Name");
            System.out.println("6.Filter Data by Campus");
            System.out.println("7.Statistics of Registration Numbers by Location");
            System.out.println("8.Save Data to File");
            System.out.println("9.Exit the Program");
            System.out.println("10.Print all students use VNPT phone:");
            System.out.println("Hay lua chon: ");
            int x = sc.nextInt();
            
            switch(x){
                case 1:
                    hs.addStudent();
                    break;
                case 2:
                    hs.updateStudent();
                    break;
                case 3:
                    hs.displayRegisterlist3();
                    break;
                case 4:
                    hs.deleteRegisterInfor();
                    break;
                case 5:
                    hs.searchByName();
                    break;
                case 6:
                    hs.filterByCampusCode();
                    break;
                case 7:
                    hs.statistic();
                    break;
                case 8:
                    hs.saveDataToFile();
                    break;
                case 9:
                    sc.nextLine();
                    if(!hs.isSaved()){
                        System.out.println("Do you want to save the changes before exiting? (Y/N):");
                        String choose = sc.nextLine();
                        if(choose.equalsIgnoreCase("Y")){
                            hs.saveDataToFile();
                        }else if (!choose.equalsIgnoreCase("N")){
                            System.out.println("Invalid Choose");
                        }
                        
                }
                    if(!hs.isSaved()){
                        System.out.println("Are you sure you want to exit without saving? (Y/N)");
                        String choose = sc.nextLine();
                        if(choose.equalsIgnoreCase("N")){
                            System.out.println("Returning menu");
                        }
                        
                    }
                    
                    System.out.println("Exiting the program ");
                    System.exit(0);
                    break;
                case 10:
                    hs.displayRegisterlist2();
                    break;
                default:
                    System.out.println("This function is not available.");
            }
        }
    }
}
