/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.CourseSchedule;

import University.CourseCatalog.Course;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class SeatAssignment {
    float grade; //(Letter grade mappings: A=4.0, A-=3.7, B+=3.3, B=3.0, )
    Seat seat;
    boolean like; //true means like and false means not like
    CourseLoad courseload;
    //MH 10/23 - Added so we can track student assignments
    ArrayList<Assignment> assignmentlist;
    
    public SeatAssignment(CourseLoad cl, Seat s){
        seat = s;
        courseload = cl;
        //MH 10/23 - Added so we can track student assignments
        assignmentlist = new ArrayList<>(); 
    }
     
    public boolean getLike(){
        return like;
    }
    
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
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

    //MH 10/22 - Was missing
    public CourseLoad getCourseLoad() {
        return courseload;
    } 

    public ArrayList<Assignment> getAssignmentlist() {
        return assignmentlist;
    }
    
    
    //MH 10/23 - Added so we can track student assignments
    public Assignment newAssignment(String assignmentName) {
        Assignment newAssignment = new Assignment(this, assignmentName);
        assignmentlist.add(newAssignment);
        return newAssignment;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }   
}
