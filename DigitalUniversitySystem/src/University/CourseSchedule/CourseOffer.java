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
    //int id; //Added to make sure these are unique, removed this because it looks like there is only one offer per course

    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList();
        this.enrollmentOpen = false; // Default to open
        //this.id = id;
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

    //MH 10/21 - Added so I can get unique Course Offer
    /*
    public int getId() {
        return id;
    }
    
     public boolean isMatchById(int id) {
        if (getId() == id) {
            return true;
        }
        return false;
    }
    */
}
