
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
import java.util.HashMap;

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

    //public UserAccountDirectory getUserAccountDirectory() {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
    
    public CourseSchedule getCourseSchedule() {
        return courseSchedule;
    }
    
    //MH 10/20 - Getting department from FacultyProfile
    public Department getDepartmentIfContainsFaculty(FacultyProfile facultyProfile) {
        String id = facultyProfile.getPerson().getPersonId();
        // See if the FacultyProfile exists in department
        FacultyProfile foundProfile = this.facultydirectory.findTeachingFaculty(id);
        //Return the department if found
        if (foundProfile != null && foundProfile.equals(facultyProfile)) {
            return this;  
        } else {
            return null; 
        }
    }
    
  

    // 返回所有学期开设的所有课程（供 Registrar 报表使用）
    
    public java.util.ArrayList<University.CourseSchedule.CourseOffer> getAllCourseOffers() {
        java.util.ArrayList<University.CourseSchedule.CourseOffer> allOffers = new java.util.ArrayList<>();
        for (University.CourseSchedule.CourseSchedule cs : mastercoursecatalog.values()) {
            allOffers.addAll(cs.getSchedule());
        }
        return allOffers;
    }

    //返回所有已存在的学期（供 FinancialReport、Analytics 使用）
     
    public java.util.Set<String> getAllSemesters() {
        return mastercoursecatalog.keySet();
    }

    //保证 courseSchedule 字段被初始化，避免 NullPointerException
    public void ensureCourseScheduleInitialized() {
        if (this.courseSchedule == null && !mastercoursecatalog.isEmpty()) {
            this.courseSchedule = mastercoursecatalog.values().iterator().next();
        }
    }
    
   
    public University.CourseSchedule.CourseSchedule findCourseScheduleByCourseOffer(University.CourseSchedule.CourseOffer co) {
        if (co == null) return null;

        for (University.CourseSchedule.CourseSchedule cs : mastercoursecatalog.values()) {
            if (cs.getSchedule().contains(co)) {
                return cs;
            }
        }
        return null;
    }
    
    public java.util.Collection<CourseSchedule> getAllCourseSchedules() {
    return mastercoursecatalog.values();
    }

}
