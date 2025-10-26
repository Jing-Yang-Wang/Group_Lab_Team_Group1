
package University.Persona.Faculty;

import University.CourseSchedule.CourseOffer;

/**
 *
 * @author kal bugrara
 */
public class FacultyAssignment {

    private double tracerating;
    private CourseOffer courseoffer;
    private FacultyProfile facultyprofile;

    // 构造方法：绑定教师与课程
    public FacultyAssignment(FacultyProfile fp, CourseOffer co) {
        this.courseoffer = co;
        this.facultyprofile = fp;
    }

    // 获取教师评分
    public double getRating() {
        return tracerating;
    }

    // 设置教师评分
    public void seProfRating(double r) {
        tracerating = r;
    }

    // 获取教师信息
    public FacultyProfile getFacultyProfile() {
        return facultyprofile;
    }

    // 获取对应的课程Offer（另一分支新增，保留兼容）
    public CourseOffer getCourseOffer() {
        return courseoffer;
    }
}
