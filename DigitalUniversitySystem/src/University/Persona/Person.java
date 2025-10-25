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
    //扩展,增加姓名&邮箱
    String id;
    String name;
    String email;
    
    public Person (String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public Person (String name){
        this.name = name;
    }
    
    public String getPersonId(){
        return id;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public boolean isMatch(String id){
    if(getPersonId().equals(id)) return true;
    return false;
    }
    
}
