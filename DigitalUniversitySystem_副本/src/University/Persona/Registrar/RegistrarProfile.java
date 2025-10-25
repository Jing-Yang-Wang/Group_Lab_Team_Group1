/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package University.Persona.Registrar;

import University.Department.Department;
import University.Persona.Person;
import University.Persona.Profile;

/**
 *
 * @author jingyangwang
 */


    //inheritance from Profile class 
public class RegistrarProfile extends Profile{ 

    //RegistrarProfile own attributes 
    private String officeHours; 
    private String email; 
    private String phone; 

    private Department department;
    //constructor 
   public RegistrarProfile(Person p){ 

    super(p); 
    } 

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

 @Override 
 public String getRole(){
     return "Registrar"; }
    
    
}



