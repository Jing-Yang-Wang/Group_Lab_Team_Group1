/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona.Student;

import University.Persona.Student.StudentProfile;
import University.CourseSchedule.CourseLoad;
import University.CourseSchedule.SeatAssignment;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Transcript {

    private StudentProfile student;
    private HashMap<String, CourseLoad> courseLoadMap;
    private CourseLoad currentCourseLoad;

    public Transcript(StudentProfile sp) {
        this.student = sp;
        this.courseLoadMap = new HashMap<String, CourseLoad>(); // key是学期名 value是CourseLoad对象
    }

    public int getStudentSatisfactionIndex() {
        // for each courseload 
        // get seatassigmnets; 
        // for each seatassignment add 1 if like =true;
        return 0;
    }

    public CourseLoad newCourseLoad(String sem) {
        currentCourseLoad = new CourseLoad(sem, this.student);
        courseLoadMap.put(sem, currentCourseLoad);
        return currentCourseLoad;
    }

    public CourseLoad getCurrentCourseLoad() {
        return currentCourseLoad;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {
        return courseLoadMap.get(semester);
    }

    public float getStudentTotalScore() {
        float sum = 0;
        for (CourseLoad cl : courseLoadMap.values()) {
            sum = sum + cl.getSemesterScore();
        }
        return sum;
    }

    // sat index means student rated their courses with likes;
    public int getStudentSatifactionIndex() {
        ArrayList<SeatAssignment> courseRegistrations = getCourseList();
        int sum = 0;
        for (SeatAssignment sa : courseRegistrations) {
            if (sa.getLike()) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    // generate a list of all courses taken so far (seetassignments) 
    // from multiple semesters (course loads)
    // from seat assignments we will be able to access the course offers
    public ArrayList<SeatAssignment> getCourseList() {
        ArrayList<SeatAssignment> allSeatAssignments = new ArrayList<>();
        for (CourseLoad cl : courseLoadMap.values()) {
            allSeatAssignments.addAll(cl.getSeatAssignments());
        }
        return allSeatAssignments;
    }

    // 返回所有学期的CourseLoad列表
    public ArrayList<CourseLoad> getAllCourseLoads() {
        // 创建一个新的ArrayList来存放每个学期的CourseLoad
        return new ArrayList<>(courseLoadMap.values()); // 把HashMap中所有的value取出来
    }

    // MH 10/22 - Was missing
    public StudentProfile getStudent() {
        return student;
    }
}