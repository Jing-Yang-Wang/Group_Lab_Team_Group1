package University.CourseSchedule;

import University.CourseCatalog.Course;
import University.Persona.Faculty.FacultyAssignment;
import University.Persona.Faculty.FacultyProfile;
import University.Persona.Student.StudentProfile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 每个 CourseOffer 属于一个 Course，有若干个 Seat（选课名额），可指定一位 FacultyProfile（教师）
 * @author kal bugrara / eve 整理
 */
public class CourseOffer {
    
    private Course course;                     // 对应课程
    private ArrayList<Seat> seatlist;          // 该课程所有座位
    private FacultyAssignment facultyassignment; // 教师分配
    private boolean enrollmentOpen = true;//是否开放注册
    private String syllabus = "No syllabus available"; //课程大纲说明

    // 构造方法：传入 Course 对象
    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList<>();
    }

    // 分配任课教师
    public void AssignAsTeacher(FacultyProfile fp) {
        if (fp == null) return;
        facultyassignment = new FacultyAssignment(fp, this);
    }

    // 获取教师信息
    public FacultyProfile getFacultyProfile() {
        if (facultyassignment == null) return null;
        return facultyassignment.getFacultyProfile();
    }

    // 获取课程对象
    public Course getCourse() {
        return course;
    }

    // 获取课程编号
    public String getCourseNumber() {
        return course.getCourseNumber();
    }

    // 获取课程名称
    public String getCourseName() {
        return course.getCourseName();
    }

    // 创建指定数量的座位（用于注册）
    public void generateSeats(int n) {
        for (int i = 0; i < n; i++) {
            seatlist.add(new Seat(this, i));
        }
    }

    // 获取所有座位列表
    public ArrayList<Seat> getSeatList() {
        return seatlist;
    }

    // 查找一个空座位（未被学生占用）
    public Seat getEmptySeat() {
        for (Seat s : seatlist) {
            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    // 分配座位并生成 SeatAssignment（学生选课）
    public SeatAssignment assignEmptySeat(CourseLoad cl) {
        Seat seat = getEmptySeat(); // 查找空位
        if (seat == null) return null; // 如果没有空位 → 选课失败

        // 创建一条 SeatAssignment 选课记录
        SeatAssignment sa = seat.newSeatAssignment(cl);
        // 把这条选课记录加入学生的课表中
        cl.registerStudent(sa);
        return sa;
    }

    // 计算这门课程所有注册学生带来的总收入
    public int getTotalCourseRevenues() {
        int sum = 0;
        for (Seat s : seatlist) {
            if (s.isOccupied()) {
                sum += course.getTotalCoursePrice(); // ✅ 统一调用标准方法
            }
        }
        return sum;
    }

    // 获取对应课程对象
    public Course getSubjectCourse() {
        return course;
    }

    // 获取课程学分
    public int getCreditHours() {
        return (int) course.getCredits();
    }

    public void setCourseSchedule(CourseSchedule cs) {
        
    }
    

    //MH 10/21 - Added this so I can manage the data
    //MH 10/26 - Uncommented this.  It is needed by Faculty Manage Courses and does not cause any errors in the code.
     public String getSyllabus() {

    // 生成成绩分布（示例：A=3, B=2, C=1 ...）
    public Map<String, Integer> getGradeDistribution() {
    Map<String, Integer> distribution = new HashMap<>();

    // 统计所有已占用座位的成绩（Seat 里应该保存每个学生成绩）
    for (Seat s : seatlist) {
        if (s.isOccupied()) {
            String grade = s.getGrade();
            if (grade != null && !grade.isEmpty()) {
                distribution.put(grade, distribution.getOrDefault(grade, 0) + 1);
            }
        }
    }

    return distribution;
}
     //获取当前课程的总座位数
    public int getSeatCount() {
        //如果 seatlist为空则返回 0，否则返回座位数量
        return seatlist == null ? 0 : seatlist.size();
    }

     // 获取当前课程已注册学生数量
    public int getEnrollmentCount() {
        int count = 0;
        for (Seat s : seatlist) {
            if (s.isOccupied()) { // 如果座位已被学生占用
                count++;
            }
        }
        return count;
    }
    
    public boolean isEnrollmentOpen() {
        return enrollmentOpen;
    }

    public void setEnrollmentOpen(boolean enrollmentOpen) {
        this.enrollmentOpen = enrollmentOpen;
    }

    public String getSyllabus() {

        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }
    
    //获取课程是否开放注册
    public boolean getEnrollmentOpen() {
        return enrollmentOpen;
    }


    public void setEnrollmentOpen(Boolean enrollmentOpen) {
        this.enrollmentOpen= enrollmentOpen;
    }
    

    public float getAverageGrade() {
        
    ArrayList<SeatAssignment> enrolledStudents = getEnrolledStudents();
        
    float total = 0.0f;
    int count = 0;

        for (SeatAssignment sa : enrolledStudents) {
                float grade = sa.getGrade();
                //only calculate when grades are positive numbers
                if (grade > 0) {
                    total += grade;
                    count++;
            }                
        }
        return total / count;
    }

    
        // 获取所有座位对应的选课记录（SeatAssignments）
    public ArrayList<SeatAssignment> getSeatAssignments() {
        ArrayList<SeatAssignment> seatAssignments = new ArrayList<>();

        for (Seat s : seatlist) {
            // 如果座位已被学生选中且有 SeatAssignment 记录
            if (s.isOccupied() && s.getSeatAssignment() != null) {
                seatAssignments.add(s.getSeatAssignment());
            }
        }

        return seatAssignments;
    }

    // 根据座位号获取对应的 SeatAssignment（用于查找学生选课记录）
    public SeatAssignment getSeatAssignmentBySeatNumber(int seatNumber) {
    for (Seat s : seatlist) {
        // 找到 seatNumber 匹配的座位
        if (s.getSeatNumber() == seatNumber) {
            return s.getSeatAssignment();  // 返回这个座位对应的 SeatAssignment
        }
    }
    return null; // 如果找不到对应座位，返回 null
}

    // 计算该课程的平均成绩
    public double getAverageCourseGrade() {
    int total = 0;        // 成绩总和
    int count = 0;        // 学生数量

    for (Seat s : seatlist) {
        if (s.isOccupied() && s.getSeatAssignment() != null) {
            SeatAssignment sa = s.getSeatAssignment();
            total += sa.getGrade();  // 获取 SeatAssignment 中的成绩（数值型）
            count++;
        }
    }

    // 如果没人选课，避免除以0
    if (count == 0) {
        return 0.0;
    }

    // 返回保留两位小数的平均成绩
    return Math.round(((double) total / count) * 100.0) / 100.0;
}

    public ArrayList<StudentProfile> getEnrolledStudents() {
    ArrayList<StudentProfile> students = new ArrayList<>();
    for (Seat s : seatlist) {
        if (s.isOccupied() && s.getSeatAssignment() != null && s.getSeatAssignment().getStudentProfile() != null) {
            students.add(s.getSeatAssignment().getStudentProfile());
        }
    }
    return students;
}

    public String getAverageGradeAsLetter() {
    double avg = getAverageCourseGrade();
    if (avg >= 3.7) return "A";
    else if (avg >= 3.3) return "A-";
    else if (avg >= 3.0) return "B+";
    else if (avg >= 2.7) return "B";
    else if (avg >= 2.3) return "B-";
    else if (avg >= 2.0) return "C+";
    else if (avg >= 1.7) return "C";
    else if (avg >= 1.0) return "D";
    else return "F";
}
    public CourseSchedule getCourseSchedule() {
    return null;
}

    
    @Override
    public String toString() {
        return course.getCourseNumber() + " - " + course.getCourseName() + " | Seats: " + seatlist.size();
    }
}
