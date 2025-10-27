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
        rp.setDepartment(department);
        registrarList.add(rp);
        return rp;
    }
    
    //remove Registrar
   
    public void removeRegistrar(Person p) {
        registrarList.remove(p);
    }
  
    public void removeRegistrar(String registrarId) {
    RegistrarProfile toRemove = null;
    for (RegistrarProfile rp : registrarList) {
        if (rp.getPerson().getPersonId().equals(registrarId)) {
            toRemove = rp;
            break;
        }
    }
    if (toRemove != null) {
        registrarList.remove(toRemove);
    }
}

    // 返回注册员列表
    public ArrayList<RegistrarProfile> getRegistrarList() {
        return registrarList;
    }


    //find registrar by ID
    public RegistrarProfile findRegistrarById(String id) {
        for (RegistrarProfile r : registrarList) {
            //MH 10/26 - Fixes because ID was changed to UniversityID
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

    public RegistrarDirectory() {
    this.department = null;
    this.registrarList = new ArrayList<>();
}

}

