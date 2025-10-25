/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.CourseSchedule;

import University.Persona.Student.StudentProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseLoad {
    
    String semester;
    ArrayList<SeatAssignment> seatassignments;
    //MH 10/24 - Added so I can relate everything below back to the student
    StudentProfile studentProfile;
    

    public CourseLoad(String s, StudentProfile sp){
        
        seatassignments = new ArrayList();
        semester = s;
        this.studentProfile = sp;
    }
    
    public SeatAssignment newSeatAssignment(CourseOffer co){
        
        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat==null) return null;
        SeatAssignment sa = seat.newSeatAssignment(this);
        seatassignments.add(sa);  //add to students course 
        return sa;
    }
    
    public void registerStudent(SeatAssignment sa){        
        
        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }
    
    public float getSemesterScore(){ //total score for a full semeter
        float sum = 0;
        for (SeatAssignment sa: seatassignments){
            sum = sum + sa.getCourseStudentScore();
        }
        return sum;
    }
    
    public ArrayList<SeatAssignment> getSeatAssignments(){
        return seatassignments;
    }     

    //MH 10/24 - Added so I can relate everything below back to the student
    public StudentProfile getStudentProfile() {
        return studentProfile;
    }
   
    //Jing - find the SeatAssignment for a given CourseOffer
    public SeatAssignment getSeatAssignment(CourseOffer courseOffer) {
    for (SeatAssignment sa : seatassignments) {
        if (sa.getSeat().getCourseOffer().equals(courseOffer)) {
            return sa;
        }
    }
    return null;
    }
            
} 

