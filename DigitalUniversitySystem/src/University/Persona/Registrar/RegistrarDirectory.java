/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package University.Persona.Registrar;

import University.Business;
import java.util.ArrayList;

/**
 *
 * @author jingyangwang
 */
public class RegistrarDirectory {
    
    Business business;
    //collection of registrars
    ArrayList<RegistrarProfile> registrarList;
    
    public RegistrarDirectory(Business b){
        
        //instantiate Arraylist
        business = b;
        registrarList = new ArrayList<>();
    }
    
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

    //find registrar by ID
    public RegistrarProfile findRegistrarById(String id) {
    for (RegistrarProfile r : registrarList) {
        if (r.getPerson().getPersonId().equals(id)) {
            return r;
        }
    }
    return null; // 没找到
    }


}
