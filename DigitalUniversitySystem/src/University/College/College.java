/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.College;

import University.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class College {
    ArrayList<Department> departments;
    String name; // MH 10/21 - Was missing
    
    public College(String name){
        departments = new ArrayList();
        this.name = name; // MH 10/21 - Was missing     
    }
        
    // MH 10/21 - dded to better manage departments in the college
    public ArrayList<Department> getDepartments() {
        return this.departments;
    }
    
    public void addDepartment(Department d) {
        if (d != null) {
            this.departments.add(d);
        }
    }
}
