/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/

//MH 10/18 - Just did some basic cleanup so it'll compile.
package University;

import University.CourseCatalog.Course;
import University.CourseCatalog.CourseCatalog;
import University.CourseSchedule.CourseLoad;
import University.CourseSchedule.CourseOffer;
import University.CourseSchedule.CourseSchedule;
import University.Department.Department;
import University.Persona.Person;
import University.Persona.PersonDirectory;
import University.Persona.UserAccount;
import University.Persona.UserAccountDirectory;
import University.Persona.Employee.EmployeeDirectory;
import University.Persona.Employee.EmployeeProfile;
import University.Persona.Faculty.FacultyAssignment;
import University.Persona.Faculty.FacultyDirectory;
import University.Persona.Faculty.FacultyProfile;
import University.Persona.Student.StudentDirectory;
import University.Persona.Student.StudentProfile;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

    public static Business initialize() {
        Business business = new Business();        
        Department department = new Department("Information Systems");
        
  // Populate department   
        //MH 10/20 - Moved this here to make sure it is called
        CourseCatalog coursecatalog = department.getCourseCatalog();        
        Course course = coursecatalog.newCourse("app eng", "info 5100", 4);        
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        courseoffer.generatSeats(10);
        
        int total = department.calculateRevenuesBySemester("Fall2020");
        
        //MH 10/20 - Added because a university is made up of departments
        business.addDepartment(department); 
        
// Create Persons
        //MH 10/20 - Fixed issue with the persondirectory
        PersonDirectory pd = department.getPersonDirectory();
        //Person person = pd.newPerson("0112303");      
        //PersonDirectory persondirectory = department.getPersonDirectory();      
        Person person001 = pd.newPerson("John Smith");
        Person person002 = pd.newPerson("Gina Montana");
        Person person003 = pd.newPerson("Adam Rollen");
        Person person004 = pd.newPerson("Gina Elva");
        Person person005 = pd.newPerson("Jim Dellon");
        Person person006 = pd.newPerson("Anna Shnider");
        Person person007 = pd.newPerson("Laura Brown");
        Person person008 = pd.newPerson("Jack While");

// Create Admins to manage the business
        EmployeeDirectory employeedirectory = department.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);

        FacultyDirectory fd = department.getFacultyDirectory();
        FacultyProfile fp1 = fd.newFacultyProfile(person002);
        FacultyAssignment fa1 = fp1.AssignAsTeacher(courseoffer);

        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile sp1 = sd.newStudentProfile(person003);
        
        CourseLoad courseload = sp1.newCourseLoad("Fall2020"); //        
        courseload.newSeatAssignment(courseoffer); //register student in class                
   
// Create User accounts that link to specific profiles
        UserAccountDirectory uad = business.getUserAccountDirectory();
        UserAccount ua3 = uad.newUserAccount(employeeprofile0, "admin", "****"); 
        UserAccount ua4 = uad.newUserAccount(fp1, "gina", "****");       
        UserAccount ua5 = uad.newUserAccount(sp1, "adam", "****"); 


        return business;
    }
}
