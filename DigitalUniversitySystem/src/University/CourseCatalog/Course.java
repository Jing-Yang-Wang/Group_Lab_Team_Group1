package University.CourseCatalog;

public class Course {

    //成员变量
    private String courseNumber;   // 课程编号
    private String courseName;     // 课程名称
    private int credits;           // 学分
    private int price = 1500;      // 每学分价格
String name;
    //构造方法
    public Course(String courseNumber, String courseName, int credits) {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.credits = credits;
    }

    //Getter和Setter
    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getPrice() {
        return price;
    }


    
    // XM 10/23
    @Override
    public String toString() {
        return name;
    }

 
    //MH 10/26 - Fixed after the names were changed

    public void setNumber(String number) {
        this.courseNumber = number;
    }

    public void setName(String name) {

        this.name = name;


        this.courseName = name;

    }

    public void setPrice(int price) {
        this.price = price;
    }

    //计算课程总价
    public int getTotalCoursePrice() {
        return price * credits;

    }

    
    //打印信息
//    @Override
//    public String toString() {
//        return courseNumber + " - " + courseName + " (" + credits + "cr)";
//    }
}
