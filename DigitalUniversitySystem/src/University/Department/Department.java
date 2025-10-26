
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
 * Department 管理学院下的所有课程、人员、课表等。
 * 一个 Department 维护一个 CourseCatalog（课程目录）和多个 CourseSchedule（学期课表）。
 * @author kal bugrara
 */
public class Department {

    private String name;
    private CourseCatalog coursecatalog;
    private PersonDirectory persondirectory;
    private StudentDirectory studentdirectory;
    private FacultyDirectory facultydirectory;
    private EmployeeDirectory employeedirectory;
    private RegistrarDirectory registrardirectory;
    private EmployerDirectory employerdirectory;
    private Degree degree;

    // 每个学期的课表映射表，例如 "Fall2024" → CourseSchedule
    private HashMap<String, CourseSchedule> mastercoursecatalog;

    // 构造方法
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

    // 创建新的学期课表（例如 “Fall2024”）
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

    // 获取学院名称
    public String getName() {
        return name;
    }

    // 获取某学期课表（兼容老逻辑）
    public CourseSchedule getCourseSchedule() {
        return mastercoursecatalog.values().stream().findFirst().orElse(null);
    }

    // 获取所有学期开设的课程 Offer（整合 Student & Faculty 逻辑）
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

    // Faculty 模块辅助函数：判断教师属于哪个学院
    public Department getDepartmentIfContainsFaculty(FacultyProfile facultyProfile) {
        String id = facultyProfile.getPerson().getUniversityID();
        FacultyProfile foundProfile = facultydirectory.findTeachingFaculty(id);
        if (foundProfile != null && foundProfile.equals(facultyProfile)) {
            return this;
        } else {
            return null;
        }
    }

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
