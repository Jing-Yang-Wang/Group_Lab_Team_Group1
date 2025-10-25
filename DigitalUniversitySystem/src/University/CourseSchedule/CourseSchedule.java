package University.CourseSchedule;

import University.CourseCatalog.Course;
import University.CourseCatalog.CourseCatalog;
import java.util.ArrayList;

/**
 * CourseSchedule 代表一个学期的课程安排（包含所有课程的CourseOffer）
 * 一个Department会有多个CourseSchedule，例如“Fall2024”、“Spring2025”等。
 */
public class CourseSchedule {

    private CourseCatalog coursecatalog;     // 对应课程目录
    private ArrayList<CourseOffer> schedule; // 当前学期所有课程Offer
    private String semester;                 // 当前学期名称

    /** 构造方法 */
    public CourseSchedule(String s, CourseCatalog cc) {
        this.semester = s;
        this.coursecatalog = cc;
        this.schedule = new ArrayList<>();
    }

    /** 创建新的课程Offer（从CourseCatalog中找到课程对象） */
    public CourseOffer newCourseOffer(String courseNumber) {
        Course c = coursecatalog.getCourseByNumber(courseNumber);
        if (c == null) return null;

        CourseOffer co = new CourseOffer(c);
        schedule.add(co);
        return co;
    }

    /** 根据课程号查找课程Offer */
    public CourseOffer getCourseOfferByNumber(String n) {
        for (CourseOffer co : schedule) {
            if (co.getCourseNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }

    /** 计算所有课程的总收入 */
    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {
            sum += co.getTotalCourseRevenues();
        }
        return sum;
    }

    /** 返回当前学期所有课程Offer */
    public ArrayList<CourseOffer> getCourseOfferList() {
        return schedule;
    }

    /** 获取当前学期名 */
    public String getSemester() {
        return semester;
    }
}
