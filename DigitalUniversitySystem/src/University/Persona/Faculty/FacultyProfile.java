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
public class FacultyProfile extends Profile {
    Person person;
    ArrayList <FacultyAssignment> facultyassignments; 
    
    public FacultyProfile(Person p) {

        super(p);
        this.person = p;
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
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }
    
    //MH 10/18 - Added so we have a defined role.
    @Override
    public String getRole() {
        return "Faculty";
    }

}
