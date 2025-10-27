
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
        //防止重复创建同一个学生档案 (来自HEAD版本)
        for(StudentProfile existing: studentList){
            if(existing.isMatch(p.getPersonId())){
                return existing;
            }
        }
        StudentProfile sp = new StudentProfile(p);
        studentList.add(sp);
        return sp;
    }

    // 删除学生的方法 (来自另一个版本)
    public void deleteStudent(StudentProfile p) {
        studentList.remove(p);
    }

    public StudentProfile findStudent(String id) {
        if(id == null || id.isEmpty()) return null; // 空值检查 (来自HEAD版本)
        for (StudentProfile sp : studentList) {
            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; //not found after going through the whole list
    }

    // Getter 和 Setter 方法 (合并两个版本的功能)
    public ArrayList<StudentProfile> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<StudentProfile> studentList) {
        this.studentList = studentList;
    }
}