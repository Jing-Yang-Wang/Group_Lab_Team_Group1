/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona;

/**
 *
 * @author kal bugrara
 */
public class Person {

    private String universityID; 
    private String name;
    private String email;  

    //MH 10/24 - Fixed to populate all fields.
    public Person(String id, String name, String email) {
        this.universityID = id;
        this.name = name;
        this.email = email;
    }

    // Getter / Setter
    public String getUniversityID() {
        return universityID;
    }

    public void setUniversityID(String universityID) {
        this.universityID = universityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public boolean isMatch(String id) {
        return this.universityID.equals(id);
    }

    
}