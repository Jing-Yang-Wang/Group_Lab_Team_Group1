package University.CourseSchedule;

// all seats contained in a course offer
public class Seat {
    // 表示此座位是否已被占用
    private boolean occupied;
    private int number; // 座位编号
    private SeatAssignment seatAssignment; // 对应学生的选课记录 links back to studentprofile
    private CourseOffer courseOffer; // 所属的课程
    private String grade;

    // 构造函数: 一个Seat属于某个CourseOffer并且有编号
    public Seat(CourseOffer co, int n) {
        courseOffer = co;
        number = n;
        occupied = false;
    }

    // 返回座位是否已被占用
    public Boolean isOccupied() {
        return occupied;
    }

    // 创建一个新的选课记录（SeatAssignment）
    public SeatAssignment newSeatAssignment(CourseLoad cl) {
        seatAssignment = new SeatAssignment(cl, this); // links seatassignment to seat
        occupied = true;
        return seatAssignment;
    }

    // 获取此座位对应的课程
    public CourseOffer getCourseOffer() {
        return courseOffer;
    }

    // 获取课程学分
    public int getCourseCredits() {
        return courseOffer.getCreditHours();
    }

    // MH 10/22 - Added because it was missing
    public SeatAssignment getSeatAssignment() {
        return seatAssignment;
    }

    // MH 10/23 - Needed to search for seat assignments
    public int getNumber() {
        return number;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public int getSeatNumber() {
    return number;
}

    
}
