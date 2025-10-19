/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona.Employee;

import University.Persona.Person;
import University.Persona.Profile;

/**
 *
 * @author kal bugrara
 */
//MH 10/18 - Added because it was not in the sample code
public class EmployeeProfile extends Profile {



    public EmployeeProfile(Person p) {

        super(p); 

    }
    @Override
    public String getRole(){
        return  "Admin";
    }

}