/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package University.CourseSchedule;

/**
 *
 * @author mdhyn
 * Added so I have a place to store student assignments and their grades.
 */
public class Assignment {
    SeatAssignment seatassignment; //links back to studentprofile
    String name;
    float grade;
    String status;//Pending / Submitted / Graded

    
    public Assignment (SeatAssignment sa, String n){
        this.seatassignment = sa;
        this.name = n;
        this.grade = 0;        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }       
    
    public SeatAssignment getSeatAssignment() {
        return seatassignment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
