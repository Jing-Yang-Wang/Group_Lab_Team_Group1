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
    
    //MH 10/20 - Added because a university is made up of departments
    private ArrayList<Department> departmentList;
    //MH 10/21 - Swapped to college to store departments   
    College college;
    
    
    public Business() {
        this.useraccountdirectory = new UserAccountDirectory();
        //MH 10/20 - Added because a university is made up of departments
        //this.departmentList = new ArrayList<>();   
        //MH 10/21 - Swapped to college to store departments  
        this.college = new College("University System");
        
        // Xieming 10/21 add the directories       
        this.persondirectory=new PersonDirectory();
        this.useraccountdirectory = new UserAccountDirectory();
        this.persondirectory = new PersonDirectory();
        
        this.departmentList = new ArrayList<>();
        
        
        
        
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
        /*
        Business business = new Business();
        Department department = new Department("Information Systems");
        
        CourseCatalog coursecatalog = department.getCourseCatalog();        
        Course course = coursecatalog.newCourse("app eng", "info 5100", 4);        
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        if (courseoffer==null)return;
        courseoffer.generatSeats(10);
        
        PersonDirectory pd = department.getPersonDirectory();
        Person person = pd.newPerson("0112303");
        
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        
        CourseLoad courseload = student.newCourseLoad("Fall2020"); //        
        courseload.newSeatAssignment(courseoffer); //register student in class
        
        int total = department.calculateRevenuesBySemester("Fall2020");
        
        //MH 10/20 - Added because a university is made up of departments
        business.addDepartment(department);      
        //System.out.print("Total: " + total);        
*/
    }   
        
    //MH 10/20 - Added because a university is made up of departments
    //MH 10/21 - Swapped to college to store departments
    //public void addDepartment(Department department) {
    //    this.departmentList.add(department);
    //}
    
    
    
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

    // Xieming 10/21  We can put all directories here to store can easily invoke
    //MH 10/21 - Swapped to college to store departments
    //public void setDepartmentList(ArrayList<Department> departmentList) {
    //    this.departmentList = departmentList;
    //}

    public College getCollege() {
        return college;
    }
    public RegistrarDirectory getRegistrardirectory() {
        return registrardirectory;
    }

    public void setRegistrardirectory(RegistrarDirectory registrardirectory) {
        this.registrardirectory = registrardirectory;
    }
    RegistrarDirectory registrardirectory;
    
}
