/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//MH 10/18 - Renamed to Business so it works with the other sample code.

package University;

//MH 10/18 - Additional classes added.
import University.CourseCatalog.Course;
import University.CourseCatalog.CourseCatalog;
import University.CourseSchedule.CourseLoad;
import University.CourseSchedule.CourseOffer;
import University.CourseSchedule.CourseSchedule;
import University.Department.Department;
import University.Persona.Employee.EmployeeDirectory;
import University.Persona.Employee.EmployeeProfile;
import University.Persona.Faculty.FacultyDirectory;
import University.Persona.Faculty.FacultyProfile;
import University.Persona.Person;
import University.Persona.PersonDirectory;
import University.Persona.UserAccountDirectory;
import University.Persona.Student.StudentDirectory;
import University.Persona.Student.StudentProfile;
import University.Persona.UserAccount;


/**
 *
 * @author kal bugrara
 */
public class Business {       
    //MH 10/18 - Needed for the login process
    UserAccountDirectory useraccountdirectory;
    private StudentProfile defaultStudent;//用于保存默认测试学生
    private Department department;  //管理所有学院
    
    public Business() {
        this.useraccountdirectory = new UserAccountDirectory();
    }
       
    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }
    
    //MH 10/18 - This should all get cleaned up and moved to ConfigureABusiness
    //MH 10/18 - Moved the user part to ConfigureABusiness for now
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Business business = new Business();
        Department department = new Department("Information Systems");
        CourseCatalog coursecatalog = department.getCourseCatalog();
        
        Course course = coursecatalog.newCourse("app eng", "info 5100", 4);
        
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        if (courseoffer==null)return;
        courseoffer.generateSeats(10);
        PersonDirectory pd = department.getPersonDirectory();
        Person person = pd.newPerson("0112303","Person1","0112303@gmail.com");
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
//        
        courseload.newSeatAssignment(courseoffer); //register student in class
        
        int total = department.calculateRevenuesBySemester("Fall2020");
        //System.out.print("Total: " + total);        

    }    

    public StudentProfile getDefaultStudent() {
        return defaultStudent;
    }

    public void setDefaultStudent(StudentProfile defaultStudent) {
        this.defaultStudent = defaultStudent;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    
}
