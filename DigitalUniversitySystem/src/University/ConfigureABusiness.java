/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/

//MH 10/18 - Just did some basic cleanup so it'll compile.
package University;

import University.Department.Department;
import University.Persona.Person;
import University.Persona.PersonDirectory;
import University.Persona.UserAccount;
import University.Persona.UserAccountDirectory;
import University.Persona.Employee.EmployeeDirectory;
import University.Persona.Employee.EmployeeProfile;
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

<<<<<<< Updated upstream
=======
        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        courseoffer.generatSeats(10);
        
        int total = department.calculateRevenuesBySemester("Fall2020");
        
        //MH 10/20 - Added because a university is made up of departments
        business.getCollege().addDepartment(department); 
        
>>>>>>> Stashed changes
// Create Persons
        PersonDirectory persondirectory = department.getPersonDirectory();      
        Person person001 = persondirectory.newPerson("John Smith");
        Person person002 = persondirectory.newPerson("Gina Montana");
        Person person003 = persondirectory.newPerson("Adam Rollen");
        Person person004 = persondirectory.newPerson("Gina Elva");
        Person person005 = persondirectory.newPerson("Jim Dellon");
        Person person006 = persondirectory.newPerson("Anna Shnider");
        Person person007 = persondirectory.newPerson("Laura Brown");
        Person person008 = persondirectory.newPerson("Jack While");

// Create Admins to manage the business
        EmployeeDirectory employeedirectory = department.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);

        FacultyDirectory facultydirectory = department.getFacultyDirectory();
        FacultyProfile facultyprofile0 = facultydirectory.newFacultyProfile(person002);

        StudentDirectory studentdirectory = department.getStudentDirectory();
        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);
   
// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "****"); 
        UserAccount ua4 = uadirectory.newUserAccount(studentprofile0, "adam", "****"); 
        UserAccount ua5 = uadirectory.newUserAccount(facultyprofile0, "gina", "****"); 

        return business;
    }
}
