/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona.Faculty;

import University.Persona.Person;
import University.CourseSchedule.CourseOffer;
import University.Persona.Profile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
//MH 10/18 - Updated so it extend the profile.
//MH 10/24 - Fixed issue with how person was stored
public class FacultyProfile extends Profile {
    //Person person;
    ArrayList <FacultyAssignment> facultyassignments; 
    String department;
    //MH 10/26 - Removed since faculty can teach multiple courses.
    //String course;
    String telephone;
    //MH 10/26 - Added to match other profiles
    String email;
    String officehours;
    //MH 10/26 - Added for the admin use case
    String facultystatus;
    
    public ArrayList<FacultyAssignment> getFacultyassignments() {
        return facultyassignments;
    }

    public void setFacultyassignments(ArrayList<FacultyAssignment> facultyassignments) {
        this.facultyassignments = facultyassignments;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //public String getCourse() {
    //    return course;
    //}

    //public void setCourse(String course) {
    //    this.course = course;
    //}

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public FacultyProfile(Person p) {

        super(p);
        //this.person = p;
        facultyassignments = new ArrayList();
    }
    public  double getProfAverageOverallRating(){
        
        double sum = 0.0;
        //for each facultyassignment extract class rating
        //add them up and divide by the number of teaching assignmnet;
        for(FacultyAssignment fa: facultyassignments){
            
            sum = sum + fa.getRating();
            
        }
        //divide by the total number of faculty assignments
        
        return sum/(facultyassignments.size()*1.0); //this ensure we have double/double
        
    }

    public FacultyAssignment AssignAsTeacher(CourseOffer co){
        
        FacultyAssignment fa = new FacultyAssignment(this, co);
        facultyassignments.add(fa);        
        return fa;
    }
    
    public FacultyProfile getCourseOffer(String courseid){
        return null; //complete it later
    }

    public boolean isMatch(String id) {
        if (super.getPerson().getUniversityID().equals(id)) {
            return true;
        }
        return false;
    }
    
    //MH 10/18 - Added so we have a defined role.
    @Override
    public String getRole() {
        return "Faculty";
    }

    //MH 10/20 - Added because they were missing.
    public Person getPerson() {
        return super.getPerson();
    }

    //MH 10/26 - Removed because it was a dup
    //public ArrayList<FacultyAssignment> getFacultyAssignments() {
    //    return facultyassignments;
    //}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 

    public String getOfficehours() {
        return officehours;
    }

    public void setOfficehours(String officehours) {
        this.officehours = officehours;
    }  

    public String getFacultystatus() {
        return facultystatus;
    }

    public void setFacultystatus(String facultystatus) {
        this.facultystatus = facultystatus;
    }
}
