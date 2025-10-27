/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona.Employee;

import University.Department.Department;
import University.Persona.Person;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
//MH 10/18 - Added because it was not in the sample code.  Also changed business to department.

public class EmployeeDirectory {

    //Business business;
    Department department;
    ArrayList<EmployeeProfile> employeelist;

    //public EmployeeDirectory(Business d) {
    public EmployeeDirectory(Department d) {

        //business = d;
        department = d;
        employeelist = new ArrayList();

    }

    public EmployeeProfile newEmployeeProfile(Person p) {

        EmployeeProfile sp = new EmployeeProfile(p);
        employeelist.add(sp);
        return sp;
    }

    public EmployeeDirectory() {
    this.department = null;
    this.employeelist = new ArrayList<>();
}

    public EmployeeProfile findEmployee(String id) {

        for (EmployeeProfile sp : employeelist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
    
    
}
