/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import tools.Accepable;
import tools.Inputter;

/**
 *
 * @author victo
 */
public final class Students {
    private final String PATHFILE = "src\\registrations.csv";
    private final List<Student> DSSV;
    private final mountains NUI = new mountains();
    private boolean isSaved = true;
    
    public Students(){
        DSSV = new ArrayList<>();
        
        NUI.readFromFile();
        loadDataFromFile();
    }
    
    public boolean isSaved() {
        return isSaved;
    }
    
    
    public double FeeCalcultion(String phone){
        double fee = 6000000;
        
        if(Accepable.isValid(phone, Accepable.VIETTEL_VALID) || Accepable.isValid(phone, Accepable.VNPT_VALID)){
            fee = 6000000 * 0.65;
        }
        return fee;
    }
    
    public void addStudent(){
        Inputter input = new Inputter();
        
        String id;
        while(true){
            id = input.getString("Enter Id: ");
            if(!Accepable.isValid(id, Accepable.STUDENT_ID)){
                System.out.println("Invalid Input");
                continue;
        }
            
        boolean exits = false;
        for(Student x : DSSV){
            if(x.getCode().equals(id)){
                exits = true;
            }
        }
        if(exits){
            System.out.println("This Id has been registered");
        }else{
            break;
        }
    }    
        
        String name = input.getString("Enter name: ");
        if(!Accepable.isValid(name, Accepable.NAME_VALID)){
            System.out.println("Invalid Input");
            return;
        }
        
        String sdt = input.getString("Enter phone: ");
        if(!Accepable.isValid(sdt, Accepable.PHONE_VALID)){
            System.out.println("Invalid Input");
            return;
        }
        
        String email = input.getString("Enter email: ");
        if(!Accepable.isValid(email, Accepable.EMAIL_VALID)){
            System.out.println("Invalid Input");
            return;
        }
        
        
        String mountaincode = input.getString("Enter mountaincode: ");
        if(!NUI.checkMountainCode(mountaincode)){
            System.out.println("Invalid Input");
            return;
        }
        
        
        double tfee = FeeCalcultion(sdt);
        Student stu = new Student(id,name,sdt,email,tfee,mountaincode);
        DSSV.add(stu);
        isSaved = false;
        
    }
    
    
    public void updateStudent(){
        Inputter input = new Inputter();
        String id = input.getString("Enter Id: ");
        
        Student updatestu = null;
        for(Student x : DSSV ){
            if(x.getCode().equals(id)){
                updatestu = x;
                break;
            }
        }
        
        if(updatestu == null){
            System.out.println("This Student has not resistered yet");
            return;
        }
        
        String newname = input.getString("Enter new name: ");
        if(!newname.isEmpty()){
            if(Accepable.isValid(newname, Accepable.NAME_VALID)){
                updatestu.setName(newname);
            }else{
                System.out.println("Invalid");
            }
        }
        
        
        String newsdt = input.getString("Enter new phone: ");
        if(!newsdt.isEmpty()){
            if(Accepable.isValid(newsdt, Accepable.PHONE_VALID)){
                updatestu.setPhone(newsdt);
                updatestu.setFee(FeeCalcultion(newsdt));
            }else{
                System.out.println("Invalid");
            }
        }
        
        String newemail = input.getString("Enter new email: ");
        if(!newemail.isEmpty()){
            if(Accepable.isValid(newemail, Accepable.EMAIL_VALID)){ 
                updatestu.setEmail(newemail);
            }else{
                System.out.println("Invalid");
            }
        }
        
        System.out.println("Update Successfully");
        System.out.println(updatestu);
        
        isSaved = false;
    }
    
    public void displayRegisterlist() {
        if (DSSV.isEmpty()) {
            System.out.println("No Student have registered yet");
            return;
        }

        System.out.println("Registered Students:");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-15s | %-10s | %-10s\n", "StudentID", "Name", "Phone", "Peakcode", "Fee");
        System.out.println("-----------------------------------------------------------------------------------");
        for (Student x : DSSV) {
            System.out.printf("%-10s | %-20s | %-15s | %-10s | %-10s\n",
                    x.getCode(),
                    x.getName(),
                    x.getPhone(),
                    x.getMountain(),
                    x.getFee());
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }
    
    public void deleteRegisterInfor(){
        Inputter input = new Inputter();
        String id = input.getString("Enter ID student want to remove: ");
        
        Student stu = null;
        for(Student x : DSSV ){
            if(x.getCode().equals(id)){
                stu = x;
                break;
             }
        }
        
        if(stu != null){
            System.out.println("Student Details: ");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Student ID: " + stu.getCode());
            System.out.println("Name      : " + stu.getName());
            System.out.println("Phone     : " + stu.getPhone());
            System.out.println("Mountain  : " + stu.getMountain());
            System.out.println("Fee       : " + stu.getFee());
            System.out.println("--------------------------------------------------------------");
            
            String str = input.getString("Are you sure you want to delete this registration? (Y/N):");
            
            if(str.equalsIgnoreCase("Y")){
                DSSV.remove(stu);
                System.out.println("The registration has been successfully deleted ");
            } 
        
        }else{
            System.out.println("This Student has not registered yet");
        }
        isSaved = false;
    }
    public void searchByName(){
        Inputter input = new Inputter();
        String str = input.getString("Enter name: ");
        
        List<Student> matchStudent = new ArrayList<>();
        for(Student x : DSSV){
            if(x.getName().contains(str)){
               matchStudent.add(x);
            }
        }
        
        if(!matchStudent.isEmpty()){
            System.out.println("Matching Students:");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s\n",
                    "StudentID",
                    "Name",
                    "Phone",
                    "Peek Code",
                    "Fee");
            System.out.println("------------------------------------------------------------------------");
            for(Student x : matchStudent){
                System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s\n",
                        x.getCode(),
                        x.getName(),
                        x.getPhone(),
                        x.getMountain(),
                        x.getFee());
            }
        }else{
            System.out.println("No one matches the search criteria!");
        }
        
    }
    
    private String getCampusname(String campus){
        switch(campus){
            case "HE":
                return "Ha Noi";
            case "SE":
                return "Ho Chi Minh";
            case "QE":
                return "Quy Nhon";
            case "CE":
                return "Can Tho";
            case "DE":
                return "Da Nang";
            default:
                return "unknow";
        }
        
    } 
    
    public void filterByCampusCode(){
        Inputter input = new Inputter();
        String str = input.getString("Enter campus code (CE, DE, HE, SE, QE): ").toUpperCase();
        
        List<Student> filterStudent = new ArrayList<>();
        for(Student x : DSSV){
            if(x.getCode().startsWith(str)){
                filterStudent.add(x);
            }
        }
        
        if(!filterStudent.isEmpty()){
            System.out.println("Registered Students Under: " + getCampusname(str) + "Campus(" + str +")");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s\n",
                    "StudentID",
                    "Name",
                    "Phone",
                    "Mountain",
                    "Fee");
            System.out.println("------------------------------------------------------------------------");
            
            for(Student x : filterStudent){
                System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s\n",
                        x.getCode(),
                        x.getName(),
                        x.getPhone(),
                        x.getMountain(),
                        x.getFee());
            }
        System.out.println("------------------------------------------------------------------------");
        }else{
            System.out.println("No Students have registered under this campus.");
        }
        
    }
    
    public void statistic(){
        Statistics sta = new Statistics(DSSV);
        sta.highestfeemountain();
        
    }
   
    
    public void saveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.PATHFILE))) {
            // Ghi tiêu đề cột
            writer.println("ID,Name,Phone,Email,Fee,Mountain");

            // Ghi từng dòng dữ liệu
            for (Student stu : DSSV) {
                writer.printf("%s,%s,%s,%s,%.0f,%s%n",
                    stu.getCode(), stu.getName(), stu.getPhone(),
                    stu.getEmail(), stu.getFee(), stu.getMountain());
            }

            System.out.println("Successfully saved data to '" + this.PATHFILE + "'");

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
        isSaved = true;
}


    public void loadDataFromFile() {
        
        try (BufferedReader temp = new BufferedReader(new FileReader(this.PATHFILE))) {
            String line;
            temp.readLine(); // Bỏ qua dòng tiêu đề

            while ((line = temp.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 6) { // dam bao du 6 cot du lieu
                    String code = data[0].trim();
                    String name = data[1].trim();
                    String phone = data[2].trim();
                    String email = data[3].trim();
                    double fee = Double.parseDouble(data[4].trim());
                    String mountain = data[5].trim();

                    DSSV.add(new Student(code, name, phone, email, fee, mountain));
                }
            }

            System.out.println("Data has been successfully loaded from:" + this.PATHFILE );
        } catch (IOException e) {
            System.out.println("Error when read file " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Number format error: " + e.getMessage());
        }
    }
    
    //////cach khac su dung outputstream
    /*public void saveDataToFile() {
        try (ObjectOutputStream temp = new ObjectOutputStream(new FileOutputStream(this.PATHFILE))) {
        // luu danh sach sinh vien da dang ky vao file
        temp.writeObject(DSSV);
        System.out.println("Registration data has been successfully saved to 'registrations.dat'");
        } catch (IOException e) {
        System.out.println("Error saving data: " + e.getMessage());
        }
        isSaved = true;
    }*/
    
    /*public void loadDataFromFile() {
    try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(this.PATHFILE))) {
        // Đọc danh sách sinh viên từ file
        Object obj = input.readObject();
        
        if (obj instanceof List) {
            DSSV = (List<Student>) obj;
            System.out.println("Registration data has been successfully loaded from 'registrations.dat'.");
        } else {
            System.out.println("Error: Data format is incorrect.");
        }
        
    } catch (FileNotFoundException e) {
        System.out.println("File 'registrations.dat' not found.");
        DSSV = new ArrayList<>();  // Khởi tạo danh sách rỗng nếu file không tồn tại
    } catch (EOFException e) {
        System.out.println("File 'registrations.dat' is empty.");
        DSSV = new ArrayList<>();
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error loading data: " + e.getMessage());
        }
    }*/
    
    public void StudentUseVnptphone(){
        if(DSSV == null && DSSV.isEmpty()){
            System.out.println("list Student empty");
        }
        
        boolean temp = false;
        for(Student x : DSSV){
            if(Accepable.isValid(x.getPhone(), Accepable.VNPT_VALID)){
                System.out.println(x); 
                temp = true;
            }
        }
        
        if(!temp){
            System.out.println("No Students use Vnpt phone");
        }
    }
    
    public void displayRegisterlist2() {
        if (DSSV.isEmpty()) {
            System.out.println("No Student have registered yet");
            return;
        }

        System.out.println("Registered Students:");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-15s | %-10s | %-10s |%-10s\n", "StudentID", "Name", "Phone", "Peakcode", "Fee","Note");
        System.out.println("-----------------------------------------------------------------------------------");
        for (Student x : DSSV) {
            String note = " ";
            if(Accepable.isValid(x.getPhone(), Accepable.VNPT_VALID) || (Accepable.isValid(x.getPhone(), Accepable.VIETTEL_VALID)) ){
                note = "discount";
            }
            System.out.printf("%-10s | %-20s | %-15s | %-10s | %-10s |%-10s\n",
                    x.getCode(),
                    x.getName(),
                    x.getPhone(),
                    x.getMountain(),
                    x.getFee(),
                    note);
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }
    
    public void displayRegisterlist3() {
        if (DSSV.isEmpty()) {
            System.out.println("No Student have registered yet");
            return;
        }

        System.out.println("Registered Students:");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-15s | %-10s | %-10s | %-10s\n", "StudentID", "Name", "Phone", "Peakcode", "Fee","Status");
        System.out.println("-----------------------------------------------------------------------------------");
        for (Student x : DSSV) {
            String note = " ";
            if(Accepable.isValid(x.getPhone(), Accepable.VIETTEL_VALID) || (Accepable.isValid(x.getPhone(), Accepable.VNPT_VALID))){
                note = "true";
            }else if(!Accepable.isValid(x.getPhone(), Accepable.VIETTEL_VALID) || (!Accepable.isValid(x.getPhone(), Accepable.VNPT_VALID))){
                note = "false";
            }
                
            
            
            System.out.printf("%-10s | %-20s | %-15s | %-10s | %-10s | %-10s\n",
                    x.getCode(),
                    x.getName(),
                    x.getPhone(),
                    x.getMountain(),
                    x.getFee(),
                    note);
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }
}
    


