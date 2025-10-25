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
import University.Persona.PersonDirectory;
import University.Persona.Student.StudentDirectory;
import University.Persona.Student.StudentProfile;
import University.Persona.UserAccountDirectory;
import java.util.ArrayList;
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
    //UserAccountDirectory useraccountdirectory;
    //MH 10/18 - For getting all Course Scedules
    CourseSchedule courseSchedule;
    
    EmployerDirectory employerdirectory;
    Degree degree;

    HashMap<String, CourseSchedule> mastercoursecatalog;

    public Department(String n) {
        name = n;
        mastercoursecatalog = new HashMap<>();
        degree = new Degree("MSIS");
        
        this.coursecatalog = new CourseCatalog(this);
        this.persondirectory = new PersonDirectory();
        this.studentdirectory = new StudentDirectory(this);
        this.facultydirectory = new FacultyDirectory(this);
        this.employeedirectory = new EmployeeDirectory(this);
    }
    public void addCoreCourse(Course c){
        degree.addCoreCourse(c);
        
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
     CourseSchedule cs = new CourseSchedule(semester, this.coursecatalog);
     mastercoursecatalog.put(semester, cs);
        return cs;
    }

   public CourseCatalog getCourseCatalog() {
    return this.coursecatalog;
}


    public CourseSchedule getCourseSchedule(String semester) {

        return mastercoursecatalog.get(semester);

    }


    public Course newCourse(String n, String nm, int cr) {

        Course c = coursecatalog.newCourse(n, nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = mastercoursecatalog.get(semester);

        return css.calculateTotalRevenues();

    }

    public String getName() {
        return name;
    }

    public void setCourseCatalog(CourseCatalog coursecatalog) {
    this.coursecatalog = coursecatalog;
}


    
    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);

        CourseLoad cl = sp.getCurrentCourseLoad();

        CourseSchedule cs = mastercoursecatalog.get(semester);

        CourseOffer co = cs.getCourseOfferByNumber(cn);

        co.assignEmptySeat(cl);

    }

        //获取所有学期开设的课程
        public ArrayList<CourseOffer>getAllCourseOffers(){
        ArrayList<CourseOffer>allOffers = new ArrayList<>();
        
        //遍历所有学期课程表 将每个课程加入列表
        for (CourseSchedule cs : mastercoursecatalog.values()) {
        if (cs != null && cs.getCourseOfferList() != null) {
            allOffers.addAll(cs.getCourseOfferList());
        }
        }
        return allOffers;
    }
    
    //public UserAccountDirectory getUserAccountDirectory() {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
    
    public CourseSchedule getCourseSchedule() {
        return courseSchedule;
    }
}
