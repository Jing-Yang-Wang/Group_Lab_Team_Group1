/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.CourseSchedule;

import University.CourseCatalog.Course;

/**
 *
 * @author kal bugrara
 */
public class SeatAssignment {
    float grade; //(Letter grade mappings: A=4.0, A-=3.7, B+=3.3, B=3.0, )
    Seat seat;
    boolean like; //true means like and false means not like
    CourseLoad courseload;
    double assignmentScore;
    private String assignmentName;
    private String status;
    
    public String getAssignmentName(){
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getStatus() {
        return status;
    }

    public CourseLoad getCourseload() {
        return courseload;
    }

    public void setCourseload(CourseLoad courseload) {
        this.courseload = courseload;
    }

    
    //传入学生课表和座位→建立双向关系
    public void setStatus(String status) {
        this.status = status;
    }

    public SeatAssignment(CourseLoad cl, Seat s) {
        seat = s;
        courseload = cl;
    }
     
    public boolean getLike(){
        return like;
    }
    
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
    }
    
    //通过Seat→CourseOffer→Course得到学分
    public int getCreditHours(){
        return seat.getCourseCredits();
       
    }
    
    public Seat getSeat(){
        return seat;
    }
    
    public CourseOffer getCourseOffer(){
        
        return seat.getCourseOffer();
    }
    
    public Course getAssociatedCourse(){
        
        return getCourseOffer().getSubjectCourse();
    }
    
    public float GetCourseStudentScore(){
        return getCreditHours()*grade;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
    
    //计算该课程的总分:学分*成绩分
    public float getCourseStudentScore(){
        return getCreditHours()*grade;
    }
    
    //Letter grade转绩点
    public static float gradeToPoint(String letter){
        switch(letter){
            case"A":return 4.0f;
            case"A-":return 3.7f;
            case"B+":return 3.3f;
            case"B":return 3.0f;
            case"B-":return 2.7f;
            case"C+":return 2.3f;
            case"C":return 2.0f;
            case"D":return 1.0f;
            default:return 0.0f;
        }
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public double getAssignmentScore() {
        return assignmentScore;
    }

    public void setAssignmentScore(double assignmentScore) {
        this.assignmentScore = assignmentScore;
    }
    
    
    
    @Override
    public String toString(){
        return getAssociatedCourse().getCourseName()+"(Grade:"+grade+")";
    }
    
    
}
