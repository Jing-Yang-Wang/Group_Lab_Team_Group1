/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package University.Persona.Registrar;

import University.Department.Department;
import University.Persona.Person;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class RegistrarDirectory {
    
    Department department; 
    //collection of registrars
    ArrayList<RegistrarProfile> registrarList;
    
    public RegistrarDirectory(Department d){
        
        //instantiate Arraylist
        department = d;
        registrarList = new ArrayList<>();
    }
    
    
    //add Registrar
    public RegistrarProfile newRegistrarProfile(Person p) {

        RegistrarProfile rp = new RegistrarProfile(p);
        registrarList.add(rp);
        return rp;
    }
    
    //remove Registrar
   
    public void removeRegistrar(Person p) {
        registrarList.remove(p);
    }
  
 
    public ArrayList<RegistrarProfile> getRegistrarList() {
        return registrarList;
    }


    //find registrar by ID
    public RegistrarProfile findRegistrarById(String id) {
        for (RegistrarProfile r : registrarList) {
            if (r.getPerson().getUniversityID().equals(id)) {
                return r;
            }
        }
        return null; 
    }

    //check if registrar existed
    public boolean isRegistrarExist(String id) {
        return findRegistrarById(id) != null;
    }

    //get registrar number
    public int getRegistrarCount() {
        return registrarList.size();
    }

}

