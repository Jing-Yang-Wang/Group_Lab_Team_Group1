/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.CourseSchedule;

import University.CourseCatalog.Course;
import University.Persona.Faculty.FacultyAssignment;
import University.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 * 每个CourseOffer属于一个Course,有若干个Seat(选课名额),可指定一位FacultyProfile(教师)
 * @author kal bugrara
 */
    public class CourseOffer {
    private Course course;
    private ArrayList<Seat> seatlist;//该课程所有座位
    private FacultyAssignment facultyassignment;

    //构造方法:传入Course对象
    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList<>();
    }
     
    //分配任课教师
    public void AssignAsTeacher(FacultyProfile fp) {
        if(fp == null){
            return;
        }
        facultyassignment = new FacultyAssignment(fp, this);//fp→FacultyProfile,this→CourseOffer
    }

    //获取教师信息
    public FacultyProfile getFacultyProfile() {
        if(facultyassignment == null)return null;
        return facultyassignment.getFacultyProfile();
    }

    //获取课程对象
    public Course getCourse(){
        return course;
    }
    
    //获取课程编号
    public String getCourseNumber() {
        return course.getCourseNumber();
    }

    //获取课程名称
    public String getCourseName(){
        return course.getCourseName();
    }
    
    //创建指定数量的座位(用于注册)
    public void generateSeats(int n) {
        for (int i = 0; i < n; i++) {
            seatlist.add(new Seat(this, i));//this→CourseOffer表示当前开设课程对象
        }
    }

    //获取所有座位列表
    public ArrayList<Seat>getSeatList(){
        return seatlist;
    }
    
    //查找一个空座位(未被学生占用)
    public Seat getEmptySeat() {
        for (Seat s : seatlist) {
            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    //分配座位并生成SeatAssignment(学生选课)
    public SeatAssignment assignEmptySeat(CourseLoad cl) {
        Seat seat = getEmptySeat();//查找空位
        if (seat == null) {//如果没有空位→选课失败
            return null;
        }
        //创建一条SeatAssignment选课记录
        SeatAssignment sa = seat.newSeatAssignment(cl); //seat is already linked to course offer
        //把这条选课记录加入学生的课表中
        cl.registerStudent(sa); //coures offer seat is now linked to student
        //返回这条选课记录对象
        return sa;
    }

    //计算这门课程所有注册学生带来的总收入
    public int getTotalCourseRevenues() {
        int sum = 0;
        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }
        }
        return sum;
    }
    
    //获取对应课程对象
    public Course getSubjectCourse(){
        return course;
    }
    
    //获取课程学分
    public int getCreditHours(){
        return (int)course.getCredits();
    }
    
   @Override
   public String toString(){
       return course.getCourseNumber()+ "-" + course.getCourseName() + "|Seats:" +seatlist.size();
   }

}
