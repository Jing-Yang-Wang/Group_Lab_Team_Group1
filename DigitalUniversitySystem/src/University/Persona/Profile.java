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
//MH 10/18 - Brought this in so we have profiles.

public abstract class Profile {
    Person person;
    
    public Profile(Person p){
        person = p;
    }
    
    public abstract String getRole();
    
    public Person getPerson(){
        return person;
    }

    public boolean isMatch(String id) {
        if (person.getUniversityID().equals(id)) {
            return true;
        }
        return false;
    }
}