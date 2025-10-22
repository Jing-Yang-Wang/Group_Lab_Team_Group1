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
    String name;
    
    public College(String name){
        departments = new ArrayList();
        this.name = name;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }
    
    // Xieming 10/21  We can put all directories here to store can easily invoke
    //MH - I moved this here because departments are in college.  NOTE: This is a dup of above setDepartments!
    public void setDepartmentList(ArrayList<Department> departmentList) {
        this.departments = departmentList;
    }
    
    public void addDepartment(Department department) {
        this.departments.add(department);
    }    
}
