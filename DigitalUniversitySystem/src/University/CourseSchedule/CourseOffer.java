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
//a course instance for a specific course
public class CourseOffer {

    private Course course;                          //which course
    private ArrayList<Seat> seatlist;               //all seats for a course
    private FacultyAssignment facultyassignment;    //faculty 
    private CourseSchedule courseschedule;

    //Constructor
    public CourseOffer(Course c) {
        this.course = c;
        seatlist = new ArrayList<>();
    }
    //Micheal use 
    public void AssignAsTeacher(FacultyProfile fp) {

        facultyassignment = new FacultyAssignment(fp, this);
    }
    //Jing/Micheal-get FacultyProfile(show teacher)
    public FacultyProfile getFacultyProfile() {
        if (facultyassignment == null) {
        return null; // 没有分配老师时避免报错
        }
        return facultyassignment.getFacultyProfile();
    }
    //Jing-get course number method
    public String getCourseNumber() {
        return course.getCourseNumber();
    }
    //Jing-Generate seat method
    public void generateSeats(int numberOfSeat) {

        for (int i = 0; i < numberOfSeat; i++) {

            seatlist.add(new Seat(this, i));

        }

    }
    //Jing-get Empty seat method
    public Seat getEmptySeat() {

        for (Seat s : seatlist) {

            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }
    //Jing-get Enrolled students
    public ArrayList<SeatAssignment> getEnrolledStudents() {
        
    ArrayList<SeatAssignment> enrolled = new ArrayList<>();
    
        for (Seat s : seatlist) {
            if (s.isOccupied()) {
                enrolled.add(s.getSeatAssignment());
            }
        }
        return enrolled;
    }
    
    //Jing-assign empty seat method
    public SeatAssignment assignEmptySeat(CourseLoad cl) {

        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl); //seat is already linked to course offer
        cl.registerStudent(sa); //coures offer seat is now linked to student
        return sa;
    }
    //Jing-financial report
    public int getTotalCourseRevenues() {
        //initial sum = 0
        int sum = 0;
        //for seats which is occupied, sum += course*price
        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getTotalOneCoursePrice();
            }

        }
        return sum;
    }
    //Jing-get SubjectCourse
    public Course getSubjectCourse(){
        return course;
    }
    //Jing-get Credit hour
    public int getCreditHours(){
        return course.getCredits();
    }

    public CourseSchedule getCourseSchedule() {
        return courseschedule;
    }

    public void setCourseSchedule(CourseSchedule cs) {
        this.courseschedule = cs;
    }
    
    public float getAverageGrade() {
        
    ArrayList<SeatAssignment> enrolledStudents = getEnrolledStudents();
        
    float total = 0.0f;
    int count = 0;

        for (SeatAssignment sa : enrolledStudents) {
                float grade = sa.getGrade();
                //only calculate when grades are positive numbers
                if (grade > 0) {
                    total += grade;
                    count++;
            }                
        }
        return total / count;
    }
    
    public String getAverageGradeAsLetter() {
        float avgGPA = getAverageGrade();
        
        //set the numeric grade conversion standard
        if (avgGPA >= 4.0f) {
            return "A";
        } else if (avgGPA >= 3.7f) {
            return "A-";
        } else if (avgGPA >= 3.3f) {
            return "B+";
        } else if (avgGPA >= 3.0f) {
            return "B";
        } else if (avgGPA >= 2.7f) {
            return "B-";
        } else if (avgGPA >= 2.3f) {
            return "C+";
        } else if (avgGPA >= 2.0f) {
            return "C";
        } else if (avgGPA >= 1.7f) {
            return "C-";
        } else {
            return "F";
        }
    }
    
      
    //MH 10/20 - Added so I can display capacity.
    public int getSeatCount() {
        return seatlist.size();
    }
    
    @Override
    public String toString() {
        return this.getSubjectCourse().getCourseNumber();
    }

}
