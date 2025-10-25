/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.CourseSchedule;

import University.CourseCatalog.Course;
import University.Persona.Student.StudentProfile;
import java.util.ArrayList;

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
    private ArrayList<Assignment> assignmentlist;
    

    
    public SeatAssignment(CourseLoad cl, Seat s){
        seat = s;
        courseload = cl;
        //MH 10/23 - Added so we can track student assignments
        assignmentlist = new ArrayList<>(); 
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
    
    public float getCourseStudentScore(){
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

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
    
    //MH 10/24 - Calc grade based on assignments
    public float calculateGrade() {
        if (assignmentlist == null || assignmentlist.isEmpty()) {
            this.grade = 0.0f; // Default to 0 if there are no assignments
            return 0.0f;
        }

        float totalGrade = 0;
        int assignmentCount = 0;

        for (Assignment a : assignmentlist) {
            totalGrade += a.getGrade(); 
            assignmentCount++;
        }

        // Calc average
        //AI - Helped with the float code
        float studentAverage = totalGrade / (float)assignmentCount;

        // Round to two decimal places
        float finalGrade = Math.round(studentAverage * 100.0f) / 100.0f;

        // Update grade
        this.grade = finalGrade; 

        return finalGrade;
    }
    
    //MH 10/24 - Added so I can relate back to the student
    public StudentProfile getStudentProfile() {
        if (this.courseload != null) {
            return this.courseload.getStudentProfile(); 
        }
        return null; // Should not happen if objects are linked correctly

    //check status
    public boolean isEnrolled() {
        return enrolled;
    }
    //drop 
    public void drop() {
    enrolled = false;

    }
}
