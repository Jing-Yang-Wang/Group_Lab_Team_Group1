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

import University.Workareas.Workarea;


/**
 *
 * @author kal bugrara
 */
//MH 10/18 - Added profile & login info to user account

public class UserAccount {
    Profile profile;
    String username;
    String password;
    
    Workarea landingworkarea;
    
    public UserAccount (Profile profile, String un, String pw){
        username = un;
        password = pw;
        this.profile = profile;
    }
    
    public String getUserLoginName(){
        return username;
    }

    
    public String getPersonId(){
        return profile.getPerson().getPersonId();
    }
    
    public boolean isMatch(String id){
        if(getPersonId().equals(id)) return true;
        return false;
    }
        
    public boolean IsValidUser(String un, String pw){

        if (username.equalsIgnoreCase(un) && password.equals(pw)) return true;
        else return false;

    }
    public String getRole(){
        return profile.getRole();
    }

    public Profile getAssociatedPersonProfile(){
        return profile;
    }
    
}