/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package University.Persona.Registrar;

import University.Persona.Person;
import University.Persona.Profile;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
    
public class RegistrarProfile extends Profile{ 

    //RegistrarProfile own attributes 
    private String officeHours; 
    private String email; 
    private String phone; 
    Person person;
    //constructor 
   public RegistrarProfile(Person p){ 

    super(p); 
    this.person = p;
    
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
   

    @Override 
    public String getRole(){
        return "Registrar"; }
    
    
}


