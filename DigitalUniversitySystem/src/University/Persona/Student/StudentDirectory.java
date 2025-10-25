/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona.Student;

import University.Department.Department;
import University.Persona.Person;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class StudentDirectory {

    private Department department;
    private ArrayList<StudentProfile> studentList;

    public StudentDirectory(Department d) {

        this.department = d;
        this.studentList = new ArrayList<StudentProfile>();

    }

    public StudentProfile newStudentProfile(Person p) {
        //防止重复创建同一个学生档案
        for(StudentProfile existing: studentList){
            if(existing.isMatch(p.getPersonId())){
                return existing;
            }
        }
        StudentProfile sp = new StudentProfile(p);
        studentList.add(sp);
        return sp;
    }

    public StudentProfile findStudent(String id) {
        if(id == null || id.isEmpty())return null;     
        for (StudentProfile sp : studentList) {
            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
    
    public ArrayList<StudentProfile> getStudentList(){
        return studentList;
    }
    
}
