/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author FGApollo
 */
public interface Accepable {
    public final String STUDENT_ID = "^[S|H|D|Q|C]E\\d{6}$";
    public final String NAME_VALID = "^[A-Za-z ]{2,20}$";
    public final String DOUBLE_VALID = "^$";
    public final String INTEGER_VALID = "^\\d+$"; 
    public final String PHONE_VALID = "^\\d{10}$"; 
    public final String VIETTEL_VALID = "(^09[78]\\d{7}$|^03[2-9]\\d{7}$|^08[1-5]\\d{7}$)";
    public final String VNPT_VALID = "^(088\\d{7}|091\\d{7}|094\\d{7})$"; 
    public final String EMAIL_VALID = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}$"; 

    static boolean isValid(String data, String pattern) {
        return data != null && data.matches(pattern);
    }
    
}

