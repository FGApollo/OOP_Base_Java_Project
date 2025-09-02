package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FGApollo
 */
public class mountain {
    private String mountainCode;
    private String mountain;
    private String province;
    private String decription;

    public mountain() {
    }

    public mountain(String mountainCode, String muontain, String province, String decription) {
        this.mountainCode = mountainCode;
        this.mountain = muontain;
        this.province = province;
        this.decription = decription;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public String getMuontain() {
        return mountain;
    }

    public void setMuontain(String muontain) {
        this.mountain = muontain;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    @Override
    public String toString() {
        return String.format("mountain: "
                + "", mountain);
    }
    
    
    
}
