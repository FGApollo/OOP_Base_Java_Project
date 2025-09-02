package model;

import java.io.Serializable;


public class Student implements Serializable {
    private static final long serialVersionUID = 1L; // dam bao tinh tuong thich cua cac doi tuong khi thuc hien tuan tu hoa
    
    private double fee ;
    private String code;
    private String name;
    private String campus;
    private String phone;
    private String email;
    private String mountain;

    public Student() {
    }
    
    public Student(double fee, String code, String name, String campus, String phone, String email, String mountain) {
        this.fee = 600000;
        this.code = code;
        this.name = name;
        this.campus = campus;
        this.phone = phone;
        this.email = email;
        this.mountain = mountain;
    }

    public Student(String code, String name, String phone, String email,double fee,String mountain) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.fee = fee;
        this.mountain = mountain;
    }

    
    
    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMountain() {
        return mountain;
    }

    public void setMountain(String mountain) {
        this.mountain = mountain;
    }

    @Override
    public String toString() {
        return String.format("Id: %s\n"
                + "Name: %s\n"
                + "Phone: %s\n"
                + "Email: %s\n"
                + "Fee: %.0f\n", code,name,phone,email,fee);
    }
    
    
    
}
