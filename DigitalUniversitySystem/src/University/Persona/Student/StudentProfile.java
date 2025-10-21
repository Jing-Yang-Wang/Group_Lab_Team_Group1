/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona.Student;

import University.CourseSchedule.CourseLoad;
import University.CourseSchedule.SeatAssignment;
import University.Persona.Student.EmploymentHistory.EmploymentHistroy;
import University.Persona.Profile;
import University.Persona.Person;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */

//MH 10/18 - Updated so it extend the profile.
public class StudentProfile extends Profile {
    Person person;
    private String academicStatus;
    Transcript transcript;
    EmploymentHistroy employmenthistory;
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getAcademicStatus() {
        return academicStatus;
    }

    public void setAcademicStatus(String academicStatus) {
        this.academicStatus = academicStatus;
    }

    public EmploymentHistroy getEmploymenthistory() {
        return employmenthistory;
    }

    public void setEmploymenthistory(EmploymentHistroy employmenthistory) {
        this.employmenthistory = employmenthistory;
    }
   

    public StudentProfile(Person p) {

        super(p);
        //person = p;
        transcript = new Transcript(this);
        employmenthistory = new EmploymentHistroy();
    }

    public boolean isMatch(String id) {
        return person.getUniversityID().equals(id);
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s) {

        return transcript.newCourseLoad(s);
    }

    public ArrayList<SeatAssignment> getCourseList() {

        return transcript.getCourseList();

    }
    
    //MH 10/18 - Added so we get the role
    @Override
    public String getRole() {
        return "Student";
    }
}
