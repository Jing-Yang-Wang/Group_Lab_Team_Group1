/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Department;

import University.CourseCatalog.Course;
import University.CourseCatalog.CourseCatalog;
import University.CourseSchedule.CourseLoad;
import University.CourseSchedule.CourseOffer;
import University.CourseSchedule.CourseSchedule;
import University.Degree.Degree;
import University.Employer.EmployerDirectory;
import University.Persona.Employee.EmployeeDirectory;
import University.Persona.Faculty.FacultyDirectory;
import University.Persona.Faculty.FacultyProfile;
import University.Persona.PersonDirectory;
import University.Persona.Registrar.RegistrarDirectory;
import University.Persona.Student.StudentDirectory;
import University.Persona.Student.StudentProfile;
import University.Persona.UserAccountDirectory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author kal bugrara
 */
public class Department {

    String name;
    CourseCatalog coursecatalog;
    PersonDirectory persondirectory;
    StudentDirectory studentdirectory;
    //MH 10/18 - Added for login process
    FacultyDirectory facultydirectory;
    EmployeeDirectory employeedirectory;
    RegistrarDirectory registrardirectory;
    //UserAccountDirectory useraccountdirectory;
    //MH 10/18 - For getting all Course Scedules
    //MH - 10/22 Removed because it is using the Hashmap
    //MH - 10/26 - But this back for now so team members can fix code issues
    CourseSchedule courseSchedule;
    
    EmployerDirectory employerdirectory;
    Degree degree;

    HashMap<String, CourseSchedule> mastercoursecatalog;

    public Department(String n) {
        name = n;
        mastercoursecatalog = new HashMap<>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this); //pass the department object so it stays linked to it
        //MH 10/18 - Added for login process
        facultydirectory = new FacultyDirectory(this);
        employeedirectory = new EmployeeDirectory(this);
        registrardirectory = new RegistrarDirectory(this);
        //useraccountdirectory = new UserAccountDirectory(this);
        
        persondirectory = new PersonDirectory();
        degree = new Degree("MSIS");
        
    }
    public void addCoreCourse(Course c){
        degree.addCoreCourse(c);
        
    }

    public RegistrarDirectory getRegistrarDirectory() {
        return registrardirectory;
    }
      
    //MH 10/18 - Seems like this should live with the Business but leaving it here for now.
    public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }
    
    public EmployerDirectory getEmployerDirectory() {
        return employerdirectory;
    }
    
    public void setEmployerdirectory(EmployerDirectory employerdirectory) {
        this.employerdirectory = employerdirectory;
    }
    
    public void addElectiveCourse(Course c){
        degree.addElectiveCourse(c);
        
    }
    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }
    
    //MH 10/18 - I assume this should live here so I added it.  
    public FacultyDirectory getFacultyDirectory() {
        return facultydirectory;
    }

    
    public StudentDirectory getStudentDirectory() {
        return studentdirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {

        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {

        return mastercoursecatalog.get(semester);

    }

    public CourseCatalog getCourseCatalog() {

        return coursecatalog;

    }

    public Course newCourse(String n, String nm, int cr) {

        Course c = coursecatalog.newCourse(n, nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = mastercoursecatalog.get(semester);

        return css.calculateTotalRevenues();

    }

    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);

        CourseLoad cl = sp.getCurrentCourseLoad();

        CourseSchedule cs = mastercoursecatalog.get(semester);

        CourseOffer co = cs.getCourseOfferByNumber(cn);

        co.assignEmptySeat(cl);

    }
    
    //Jing-this method i need to use
    //MH - 10/26, the course schedule is inside mastercoursecatalog.  We'll need to transition code to this.
    public CourseSchedule getCourseSchedule() {
        return courseSchedule;
    }
   
    
    public ArrayList<CourseOffer> getAllCourseOffers() {
    ArrayList<CourseOffer> allOffers = new ArrayList<>();
        for (CourseSchedule cs : mastercoursecatalog.values()) {
            allOffers.addAll(cs.getSchedule());
        }
    return allOffers;
    }
    
    public Set<String> getAllSemesters() {
        return mastercoursecatalog.keySet();
    }
    
    
    //MH 10/20 - Getting department from FacultyProfile
    public Department getDepartmentIfContainsFaculty(FacultyProfile facultyProfile) {
        String id = facultyProfile.getPerson().getUniversityID();
        // See if the FacultyProfile exists in department
        FacultyProfile foundProfile = this.facultydirectory.findTeachingFaculty(id);
        //Return the department if found
        if (foundProfile != null && foundProfile.equals(facultyProfile)) {
            return this;  
        } else {
            return null; 
        }
    }
    
    //MH 10/22 - Added so we can have a semester list
    //AI helped me build this.  Was not sure how to get the key
    //MH 10/26 - Removed because a team member also added this.
    //public Set<String> getAllSemesters() {
    //    return mastercoursecatalog.keySet();
    //}
   
    //MH 10/22 - Added so course offer can be used to update the schedule
    public CourseSchedule findCourseScheduleByCourseOffer(CourseOffer courseOffer) {
        for (CourseSchedule cs : mastercoursecatalog.values()) {
                        
            for (CourseOffer co : cs.getSchedule()) {

                if (co.equals(courseOffer)) {
                    return cs; 
                }
            }
        }
        return null; 
    }
}
