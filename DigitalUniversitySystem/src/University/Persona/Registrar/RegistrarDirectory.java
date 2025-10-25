/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package University.Persona.Registrar;


import University.Business;
import java.util.ArrayList;
import University.Department.Department;
import University.Persona.Person;
import java.util.ArrayList;


/**
 *
 * @author jingyangwang
 */
public class RegistrarDirectory {
    

    
    //add Registrar
    public void addRegistrar(RegistrarProfile rp) {
        registrarList.add(rp);
    }
    
    //remove Registrar
    public boolean removeRegistrar(String id) {
    RegistrarProfile r = findRegistrarById(id);
    if (r != null) {
        registrarList.remove(r);
        return true;
    }
    return false;
    }


}
    
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
        rp.setDepartment(department);//
        registrarList.add(rp);
        return rp;
    }
   
  
    // 返回注册员列表
    public ArrayList<RegistrarProfile> getRegistrarList() {
        return registrarList;
    }


    //find registrar by ID
    public RegistrarProfile findRegistrarById(String id) {
        for (RegistrarProfile r : registrarList) {
            if (r.getPerson().getPersonId().equals(id)) {
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




