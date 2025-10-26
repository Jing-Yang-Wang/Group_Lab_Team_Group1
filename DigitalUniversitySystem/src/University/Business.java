/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//MH 10/18 - Renamed to Business so it works with the other sample code.

package University;

//MH 10/18 - Additional classes added.
import University.College.College;
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
import University.Persona.Registrar.RegistrarDirectory;
import University.Persona.UserAccountDirectory;
import University.Persona.Student.StudentDirectory;
import University.Persona.Student.StudentProfile;
import University.Persona.UserAccount;
import java.util.ArrayList;


/**
 *
 * @author kal bugrara
 */
public class Business {       
    //MH 10/18 - Needed for the login process
    UserAccountDirectory useraccountdirectory;
    
    // Xieming 10/21  We can put all directories here to store can easily invoke
    PersonDirectory persondirectory;
    EmployeeDirectory employeedirectory;
    StudentDirectory studentdirectory;
    FacultyDirectory facultyDirectory;
    RegistrarDirectory registrardirectory;
    
    //MH 10/20 - Added because a university is made up of departments
    //MH 10/25 - Put this back in because it is being used by others but loaded data from the college
    private ArrayList<Department> departmentList;
    //MH 10/21 - Swapped to college to store departments   
    College college;
    
    private StudentProfile defaultStudent;//用于保存默认测试学生(Used to save the default test student)
    
    public Business() {
        this.useraccountdirectory = new UserAccountDirectory();
        
        // Xieming 10/21 add the directories       
        this.persondirectory = new PersonDirectory();
        this.employeedirectory = new EmployeeDirectory();
        this.studentdirectory = new StudentDirectory(null); 
        this.facultyDirectory = new FacultyDirectory();
        this.registrardirectory = new RegistrarDirectory();
        
        //MH 10/21 - Swapped to college to store departments  
        this.college = new College("University System");
        
        //MH 10/25 - Loading data from the college
        this.departmentList = this.college.getDepartments();        
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
        //MH - Add code to add data was moved to ConfirgureABusiness
    }    

    public StudentProfile getDefaultStudent() {
        return defaultStudent;
    }

    public void setDefaultStudent(StudentProfile defaultStudent) {
        this.defaultStudent = defaultStudent;
    }

    
    public UserAccountDirectory getUseraccountdirectory() {
        return useraccountdirectory;
    }

    public void setUseraccountdirectory(UserAccountDirectory useraccountdirectory) {
        this.useraccountdirectory = useraccountdirectory;
    }

    public PersonDirectory getPersondirectory() {
        return persondirectory;
    }

    public void setPersondirectory(PersonDirectory persondirectory) {
        this.persondirectory = persondirectory;
    }

    public ArrayList<Department> getDepartmentList() {
        return this.college.getDepartments();
    }
    
    public EmployeeDirectory getEmployeedirectory() {
        return employeedirectory;
    }

    public void setEmployeedirectory(EmployeeDirectory employeedirectory) {
        this.employeedirectory = employeedirectory;
    }

    public StudentDirectory getStudentdirectory() {
        return studentdirectory;
    }

    public void setStudentdirectory(StudentDirectory studentdirectory) {
        this.studentdirectory = studentdirectory;
    }

    public FacultyDirectory getFacultyDirectory() {
        return facultyDirectory;
    }

    public void setFacultyDirectory(FacultyDirectory facultyDirectory) {
        this.facultyDirectory = facultyDirectory;
    }
    
    public RegistrarDirectory getRegistrardirectory() {
        return registrardirectory;
    }

    public void setRegistrardirectory(RegistrarDirectory registrardirectory) {
        this.registrardirectory = registrardirectory;
    }
    
    //MH 10/25 - Fixing issues where old version of code was used from before department was moved to college
    // Get StudentDirectory from the first department
    public StudentDirectory getStudentDirectory() {
        if (departmentList != null && !departmentList.isEmpty()) {
            return departmentList.get(0).getStudentDirectory();
        }
        return null;
    }
    
    // Get FacultyDirectory from the first department  
    public FacultyDirectory getFacultyDirectoryFromDepartment() {
        if (departmentList != null && !departmentList.isEmpty()) {
            return departmentList.get(0).getFacultyDirectory();
        }
        return null;
    }

    public College getCollege() {
        return college;
    }
    
    //For easy access, add a method to get the first department
    public Department getFirstDepartment() {
        if (departmentList != null && !departmentList.isEmpty()) {
            return departmentList.get(0);
        }
        return null;
    }
}