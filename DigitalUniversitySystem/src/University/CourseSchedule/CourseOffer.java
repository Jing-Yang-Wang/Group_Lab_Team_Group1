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
 *
 * @author kal bugrara
 */
public class CourseOffer {

    Course course;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyassignment;
    //MH 10/21 - Added place to hold syllabus & enrollment status.  Putting it here since it can be different for each offer.
    String syllabus;
    Boolean enrollmentOpen; //false = Closed, true = Open

    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList();
        this.syllabus = "";
        this.enrollmentOpen = false; // Default to open
    }
     
    public void AssignAsTeacher(FacultyProfile fp) {

        facultyassignment = new FacultyAssignment(fp, this);
    }

    public FacultyProfile getFacultyProfile() {
        return facultyassignment.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCourseNumber();
    }

    public void generatSeats(int n) {

        for (int i = 0; i < n; i++) {

            seatlist.add(new Seat(this, i));

        }

    }

    public Seat getEmptySeat() {

        for (Seat s : seatlist) {

            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }


    public SeatAssignment assignEmptySeat(CourseLoad cl) {

        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl); //seat is already linked to course offer
        cl.registerStudent(sa); //coures offer seat is now linked to student
        return sa;
    }

    public int getTotalCourseRevenues() {

        int sum = 0;

        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }
    
    public Course getSubjectCourse(){
        return course;
    }
    
    public int getCreditHours(){
        return course.getCredits();
    }
    
    //MH 10/21 - Added this so I can manage the data
    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public Boolean getEnrollmentOpen() {
        return enrollmentOpen;
    }

    public void setEnrollmentOpen(Boolean enrollmentOpen) {
        this.enrollmentOpen= enrollmentOpen;
    }
    
    //MH 10/20 - Added so I can display capacity.
    public int getSeatCount() {
        return seatlist.size();
    }

    //MH 10/21 - Added so I get seats for seat assignments
    public ArrayList<Seat> getSeatlist() {
        return seatlist;
    }

    public ArrayList<SeatAssignment> getSeatAssignments() {
        ArrayList<SeatAssignment> assignments = new ArrayList<>();
        for (Seat seat : seatlist) {

            if (seat.isOccupied() && seat.getSeatAssignment() != null) {
                assignments.add(seat.getSeatAssignment());
            }
        }
        return assignments;
    }
    
    //MH 10/23 - Added to get seat assignments
    public SeatAssignment getSeatAssignmentBySeatNumber(int seatNumber) {
        Seat targetSeat = null;
        for (Seat s : seatlist) {
            if (s.getNumber() == seatNumber) { 
                targetSeat = s;
                break;
            }
        }        
        //If found, return seat assesment
        if (targetSeat != null && targetSeat.isOccupied()) {
            return targetSeat.getSeatAssignment();
        }
        return null;
    }
}
