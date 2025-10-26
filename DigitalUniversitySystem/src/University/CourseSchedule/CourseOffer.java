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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kal bugrara
 */
//a course instance for a specific course

public class CourseOffer {

    //MH 10/21 - Added place to hold syllabus & enrollment status.  Putting it here since it can be different for each offer.
    String syllabus;
    Boolean enrollmentOpen; //false = Closed, true = Open
    private Course course;                          //which course
    private ArrayList<Seat> seatlist;               //all seats for a course
    private FacultyAssignment facultyassignment;    //faculty 
    private CourseSchedule courseschedule;

    //Constructor
    public CourseOffer(Course c) {

        course = c;
        seatlist = new ArrayList();
        this.syllabus = "";
        this.enrollmentOpen = false; // Default to open

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
    
    //MH 10/21 - Added this so I can manage the data
    //MH 10/26 - Uncommented this.  It is needed by Faculty Manage Courses and does not cause any errors in the code.
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
    
    //MH 10/24 - Added to get seat counts
    public int getEnrollmentCount() {
        int enrolled = 0;

        for (Seat s : seatlist) {
            if (s.isOccupied()) {
                enrolled++;
            }
        }    
        return enrolled;
    }
    
    //MH 10/24 - Added to get avg grade
    public float getAverageCourseGrade() {
        ArrayList<SeatAssignment> assignments = getSeatAssignments();

        if (assignments.isEmpty()) {
            return 0.0f;
        }

        float totalGradeSum = 0.0f;
        for (SeatAssignment sa : assignments) {
            totalGradeSum += sa.getGrade(); 
        }

        int enrollmentCount = assignments.size();
        float averageGrade = totalGradeSum / (float)enrollmentCount;
        //AI - Helped with rounding code
        float roundedAverage = Math.round(averageGrade * 100.0f) / 100.0f;
        return roundedAverage;
    }
      
    //AI - Helped with this since it was a lot of detail
    public Map<String, Integer> getGradeDistribution() {
        // Initialize the distribution map with zero counts for common grades
        Map<String, Integer> distribution = new HashMap<>();
        distribution.put("A", 0);
        distribution.put("A-", 0);
        distribution.put("B+", 0);
        distribution.put("B", 0);
        distribution.put("B-", 0);
        distribution.put("C+", 0);
        distribution.put("C", 0);
        distribution.put("C-", 0);
        distribution.put("D", 0);
        distribution.put("F", 0);

        // Reuse existing logic to get all final grades
        ArrayList<SeatAssignment> assignments = getSeatAssignments();

        for (SeatAssignment sa : assignments) {
            float grade = sa.getGrade(); // This is the final numeric grade (e.g., 4.0, 3.3, 2.0)
            String letterGrade;

            // Define the numeric to letter grade mapping (adjust these cutoffs as needed)
            if (grade >= 4.0f) {
                letterGrade = "A";
            } else if (grade >= 3.7f) {
                letterGrade = "A-";
            } else if (grade >= 3.3f) {
                letterGrade = "B+";
            } else if (grade >= 3.0f) {
                letterGrade = "B";
            } else if (grade >= 2.7f) {
                letterGrade = "B-";
            } else if (grade >= 2.3f) {
                letterGrade = "C+";
            } else if (grade >= 2.0f) {
                letterGrade = "C";
            } else if (grade >= 1.7f) {
                letterGrade = "C-";
            } else if (grade >= 1.0f) {
                letterGrade = "D";
            } else {
                letterGrade = "F";
            }

            // Increment the count for the determined letter grade
            distribution.put(letterGrade, distribution.get(letterGrade) + 1);
        }

        return distribution;
    }
}
