
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


    // Course schedule mapping table for each semester
    private HashMap<String, CourseSchedule> mastercoursecatalog;

   
    public Department(String n) {
        name = n;
        mastercoursecatalog = new HashMap<>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this);
        facultydirectory = new FacultyDirectory(this);
        employeedirectory = new EmployeeDirectory(this);
        registrardirectory = new RegistrarDirectory(this);
        persondirectory = new PersonDirectory();
        degree = new Degree("MSIS");
    }

    // 添加核心课程
    public void addCoreCourse(Course c) {
        degree.addCoreCourse(c);
    }

    // 添加选修课程
    public void addElectiveCourse(Course c) {
        degree.addElectiveCourse(c);
    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public FacultyDirectory getFacultyDirectory() {
        return facultydirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }

    public EmployerDirectory getEmployerDirectory() {
        return employerdirectory;
    }

    public void setEmployerdirectory(EmployerDirectory employerdirectory) {
        this.employerdirectory = employerdirectory;
    }

    public RegistrarDirectory getRegistrarDirectory() {
        return registrardirectory;
    }

    public StudentDirectory getStudentDirectory() {
        return studentdirectory;
    }

    // 创建新的学期课表
    public CourseSchedule newCourseSchedule(String semester) {
        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    // 获取特定学期的课表
    public CourseSchedule getCourseSchedule(String semester) {
        return mastercoursecatalog.get(semester);
    }

    public CourseCatalog getCourseCatalog() {
        return coursecatalog;
    }

    // 新建课程（添加到课程目录）
    public Course newCourse(String number, String name, int credits) {
        Course c = coursecatalog.newCourse(number, name, credits);
        return c;
    }

    // 计算某学期的总收入
    public int calculateRevenuesBySemester(String semester) {
        CourseSchedule cs = mastercoursecatalog.get(semester);
        return cs.calculateTotalRevenues();
    }

    
    //Jing-this method i need to use
    //MH - 10/26, the course schedule is inside mastercoursecatalog.  We'll need to transition code to this.


    // 获取学院名称
    public String getName() {
        return name;
    }

    // 获取某学期课表

    public CourseSchedule getCourseSchedule() {
        return mastercoursecatalog.values().stream().findFirst().orElse(null);
    }

    // 获取所有学期开设的课程 Offer
    public ArrayList<CourseOffer> getAllCourseOffers() {
        ArrayList<CourseOffer> allOffers = new ArrayList<>();
        for (CourseSchedule cs : mastercoursecatalog.values()) {
            if (cs != null && cs.getCourseOfferList() != null) {
                allOffers.addAll(cs.getCourseOfferList());
            }
        }
        return allOffers;
    }

    // 获取所有学期名称
    public Set<String> getAllSemesters() {
        return mastercoursecatalog.keySet();
    }

    // 注册课程：学生注册某门课
    public void RegisterForAClass(String studentid, String cn, String semester) {
        StudentProfile sp = studentdirectory.findStudent(studentid);
        CourseLoad cl = sp.getCurrentCourseLoad();
        CourseSchedule cs = mastercoursecatalog.get(semester);
        CourseOffer co = cs.getCourseOfferByNumber(cn);
        co.assignEmptySeat(cl);
    }

    
    public Department getDepartmentIfContainsFaculty(FacultyProfile facultyProfile) {
        String id = facultyProfile.getPerson().getUniversityID();
        FacultyProfile foundProfile = facultydirectory.findTeachingFaculty(id);
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


    // 根据课程 Offer 查找对应学期课表

    public CourseSchedule findCourseScheduleByCourseOffer(CourseOffer courseOffer) {
        for (CourseSchedule cs : mastercoursecatalog.values()) {
            for (CourseOffer co : cs.getCourseOfferList()) {
                if (co.equals(courseOffer)) {
                    return cs;
                }
            }
        }
        return null;
    }
}
