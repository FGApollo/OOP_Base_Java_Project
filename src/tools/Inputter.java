package tools;


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
public class Inputter {
    private Scanner ndl; // Sử dụng để nhập liệu

    public Inputter() {
        ndl = new Scanner(System.in);
    }

    // Phương thức nhập chuỗi
    public String getString(String chuoi) {
        System.out.print(chuoi);
        return ndl.nextLine().trim();
    }

    // Phương thức nhập số nguyên
    public int getInt(String chuoi) {
        while (true) {
            try {
                System.out.print(chuoi);
                return Integer.parseInt(ndl.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    // Phương thức nhập số thực
    public double getDouble(String chuoi) {
        while (true) {
            try {
                System.out.print(chuoi);
                return Double.parseDouble(ndl.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a double.");
            }
        }
    }
}


