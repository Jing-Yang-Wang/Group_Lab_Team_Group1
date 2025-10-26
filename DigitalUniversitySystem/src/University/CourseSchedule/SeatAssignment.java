package University.CourseSchedule;

import University.CourseCatalog.Course;
import University.Persona.Student.StudentProfile;
import java.util.ArrayList;

/**
 * 每个 SeatAssignment 表示学生的一门课程注册及成绩情况
 * 包含学分、成绩、作业分数、完成状态等
 * @author kal bugrara
 */
public class SeatAssignment {
    private CourseLoad courseload;
    private Seat seat;
    private float grade; // (Letter grade mappings: A=4.0, A-=3.7, B+=3.3, B=3.0, )
    private boolean like; // true 表示喜欢该课程
    private boolean enrolled; // 是否在读
    private double assignmentScore;
    private String assignmentName;
    private String status;
    private ArrayList<Assignment> assignmentlist; // 作业列表

    /** 构造函数: 建立 seat 与 courseload 的关联 */
    public SeatAssignment(CourseLoad cl, Seat s) {
        this.seat = s;
        this.courseload = cl;
        this.assignmentlist = new ArrayList<>();
        this.enrolled = true;
    }

    /** 是否喜欢该课程 */
    public boolean getLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    /** 设置和获取成绩 */
    public void setGrade(float grade) {
        this.grade = grade;
    }

    public float getGrade() {
        return grade;
    }

    /** 获取课程学分 */
    public int getCreditHours() {
        return seat.getCourseCredits();
    }

    /** 获取当前座位 */
    public Seat getSeat() {
        return seat;
    }

    /** 获取课程 Offer */
    public CourseOffer getCourseOffer() {
        return seat.getCourseOffer();
    }

    /** 获取对应 Course */
    public Course getAssociatedCourse() {
        return getCourseOffer().getSubjectCourse();
    }

    /** 计算学生课程得分 = 学分 * 绩点 */
    public float getCourseStudentScore() {
        return getCreditHours() * grade;
    }

    /** Letter grade 转绩点 */
    public static float gradeToPoint(String letter) {
        switch (letter) {
            case "A": return 4.0f;
            case "A-": return 3.7f;
            case "B+": return 3.3f;
            case "B": return 3.0f;
            case "B-": return 2.7f;
            case "C+": return 2.3f;
            case "C": return 2.0f;
            case "D": return 1.0f;
            default: return 0.0f;
        }
    }

    /** 获取与课程负载（学期）关联的 CourseLoad */
    public CourseLoad getCourseLoad() {
        return courseload;
    }

    public void setCourseload(CourseLoad courseload) {
        this.courseload = courseload;
    }

    /** 建立 seat 与学生的关联 */
    public void assignSeatToStudent(CourseLoad cl) {
        courseload = cl;
    }

    /** 获取或设置座位 */
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    /** 获取作业名称和状态 */
    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /** 获取作业得分 */
    public double getAssignmentScore() {
        return assignmentScore;
    }

    public void setAssignmentScore(double assignmentScore) {
        this.assignmentScore = assignmentScore;
    }

    /** 作业管理（来自另一分支） */
    public ArrayList<Assignment> getAssignmentlist() {
        return assignmentlist;
    }

    public Assignment newAssignment(String assignmentName) {
        Assignment newAssignment = new Assignment(this, assignmentName);
        assignmentlist.add(newAssignment);
        return newAssignment;
    }


    //MH 10/26 - Removed because a team member also added this.
    //public float getGrade() {
    //    return grade;
    //}

    //MH 10/26 - Removed because a team member also added this.
    //public void setGrade(float grade) {
    //    this.grade = grade;
    //}
    
    //MH 10/24 - Calc grade based on assignments

    /** 计算平均成绩（来自另一分支） */

    public float calculateGrade() {
        if (assignmentlist == null || assignmentlist.isEmpty()) {
            this.grade = 0.0f;
            return 0.0f;
        }

        float total = 0;
        for (Assignment a : assignmentlist) {
            total += a.getGrade();
        }

        float avg = total / assignmentlist.size();
        this.grade = Math.round(avg * 100.0f) / 100.0f;
        return this.grade;
    }

    /** 获取对应学生（来自 CourseLoad） */
    public StudentProfile getStudentProfile() {
        if (this.courseload != null) {
            return this.courseload.getStudentProfile();
        }

        return null; // Should not happen if objects are linked correctly
    }
        
    //check status


    /** 判断是否已注册或退课 */

    public boolean isEnrolled() {
        return enrolled;
    }

    public void drop() {
        enrolled = false;
    }

    @Override
    public String toString() {
        return getAssociatedCourse().getCourseName() + " (Grade: " + grade + ")";
    }
}
