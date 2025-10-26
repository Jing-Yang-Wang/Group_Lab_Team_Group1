package University.CourseSchedule;

import University.CourseCatalog.Course;
import University.CourseCatalog.CourseCatalog;
import University.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 * CourseSchedule 代表一个学期的课程安排（包含所有课程的 CourseOffer）
 * 一个 Department 会有多个 CourseSchedule，例如 “Fall2024”、“Spring2025” 等。
 * @author kal bugrara
 */
public class CourseSchedule {

    private CourseCatalog coursecatalog;      // 对应课程目录
    private ArrayList<CourseOffer> schedule;  // 当前学期所有课程 Offer
    private String semester;                  // 当前学期名称

    //构造方法
    public CourseSchedule(String s, CourseCatalog cc) {
        this.semester = s;
        this.coursecatalog = cc;
        this.schedule = new ArrayList<>();
    }

    //创建新的课程 Offer（从 CourseCatalog 中找到课程对象）
    public CourseOffer newCourseOffer(String courseNumber) {
        Course c = coursecatalog.getCourseByNumber(courseNumber);
        if (c == null) {
            System.out.println("Course not found: " + courseNumber);
            return null;
        }

        CourseOffer co = new CourseOffer(c);
        co.setCourseSchedule(this); // 保留另一分支中的逻辑
        schedule.add(co);
        return co;
    }

    //删除某个课程 Offer
    public void deleteCourseOffer(CourseOffer co) {
        schedule.remove(co);
    }

    //根据课程号查找课程Offer
    public CourseOffer getCourseOfferByNumber(String n) {
        for (CourseOffer co : schedule) {
            if (co.getCourseNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }

    //计算所有课程的总收入
    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {
            sum += co.getTotalCourseRevenues();
        }
        return sum;
    }

    //返回当前学期所有课程 Offer
    public ArrayList<CourseOffer> getCourseOfferList() {
        return schedule;
    }

    //用于 Faculty 模块的专用访问方法
    public ArrayList<CourseOffer> getSchedule() {
        return schedule;
    }

    //获取当前学期名
    public String getSemester() {
        return semester;
    }

    //设置当前学期名
    public void setSemester(String semester) {
        this.semester = semester;
    }

    //按教师过滤课程Offer（Faculty 专用功能）
    public ArrayList<CourseOffer> filterScheduleByFaculty(FacultyProfile fp) {
        ArrayList<CourseOffer> filteredOffers = new ArrayList<>();
        if (fp == null) return filteredOffers;

        for (CourseOffer co : schedule) {
            if (co.getFacultyProfile() != null && co.getFacultyProfile().equals(fp)) {
                filteredOffers.add(co);
            }
        }
        return filteredOffers;
    }
}
