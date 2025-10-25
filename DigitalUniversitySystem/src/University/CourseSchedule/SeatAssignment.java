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
    
    private CourseLoad courseload;
    private Seat seat;
    private float grade; //(Letter grade mappings: A=4.0, A-=3.7, B+=3.3, B=3.0, )
    private boolean like; //true means like and false means not like
    private boolean enrolled;
    
    
    public SeatAssignment(CourseLoad cl, Seat s){
        seat = s;
        courseload = cl;
        enrolled = true;
    }
     
    public boolean getLike(){
        return like;
    }
    
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
    }
    
    public void setGrade(float g) {
        grade = g;
    }

    public float getGrade() {
        return grade;
    }
    
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
    
    //check status
    public boolean isEnrolled() {
        return enrolled;
    }
    //drop 
    public void drop() {
    enrolled = false;
    }
}
