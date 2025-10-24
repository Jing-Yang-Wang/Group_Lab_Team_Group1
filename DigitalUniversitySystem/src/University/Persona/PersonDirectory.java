/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {
    
      ArrayList<Person> personlist ;

    public ArrayList<Person> getPersonlist() {
        return personlist;
    }

    public void setPersonlist(ArrayList<Person> personlist) {
        this.personlist = personlist;
    }
    
      public PersonDirectory (){
          
       personlist = new ArrayList();

    }

    public Person newPerson(String id) {

        Person p = new Person(id);
        personlist.add(p);
        return p;
    }

    public Person findPerson(String id) {

        for (Person p : personlist) {

            if (p.isMatch(id)) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }


  
    public void addPerson(Person p) {
        personlist.add(p);
    }

    public boolean emailExists(String email) {
        for (Person person : personlist) {
            if (person.getEmail().equals(email)) { 
                return true;
            }
        }
        return false;
    }

    public boolean universityIDExists(String universityID) {
        for (Person person : personlist) {
            if (person.getUniversityID().equals(universityID)) {
                return true;
            }
        }
        return false;
    }
}


