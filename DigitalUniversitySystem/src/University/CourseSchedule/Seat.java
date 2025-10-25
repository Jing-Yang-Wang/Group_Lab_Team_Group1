/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.CourseSchedule;

/**
 *
 * @author kal bugrara
 */

//all seats contains in a course offer 
public class Seat {
    
    private CourseOffer courseoffer;
    private int number;
    private boolean occupied; 
    private SeatAssignment seatAssignment; //links back to studentprofile
    
    public Seat (CourseOffer co, int n){
        courseoffer = co;
        number = n;
        occupied = false;
        
    }

    public SeatAssignment getSeatAssignment() {
        return seatAssignment;
    }
    
    
    public Boolean isOccupied(){
        return occupied;

    }
    
    public SeatAssignment newSeatAssignment(CourseLoad cl){
        
        seatAssignment = new SeatAssignment(cl, this);  
        occupied = true;   
        return seatAssignment;
    }
    
    public CourseOffer getCourseOffer(){
        return courseoffer;
    }
    
    public int getCourseCredits(){
        return courseoffer.getCreditHours();
    }
    
    //MH 10/22 - Added because it was missing
    public SeatAssignment getSeatAssignment() {
        return seatassignment;
    }

    //MH 10/23 - Needed to search for seat assignments
    public int getNumber() {
        return number;
    }
    
}
