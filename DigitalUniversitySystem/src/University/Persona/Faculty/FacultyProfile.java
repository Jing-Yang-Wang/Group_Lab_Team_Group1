package University.Persona.Faculty;

import University.Persona.Person;
import University.CourseSchedule.CourseOffer;
import University.Persona.Profile;
import java.util.ArrayList;

public class FacultyProfile extends Profile {
    //Person person;
    ArrayList <FacultyAssignment> facultyassignments; 
    String department;
    String telephone;
    //MH 10/26 - Added to match other profiles
    String email;
    String officehours;
    //MH 10/26 - Added for the admin use case
    String facultystatus;
    
    public ArrayList<FacultyAssignment> getFacultyassignments() {
        return facultyassignments;
    }

    //MH 10/26 - Removed since faculty can teach multiple courses.
    //MH 10/26 - THIS NEEDS TO BE REMOVED
    private String course;


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public FacultyProfile(Person p) {
        super(p);
        this.facultyassignments = new ArrayList<>();
    }

    // 教师平均评分
    public double getProfAverageOverallRating() {
        if (facultyassignments.isEmpty()) return 0.0;
        double sum = 0.0;
        for (FacultyAssignment fa : facultyassignments) {
            sum += fa.getRating();
        }
        return sum / facultyassignments.size();
    }

    // 分配课程
    public FacultyAssignment assignAsTeacher(CourseOffer co) {
        FacultyAssignment fa = new FacultyAssignment(this, co);
        facultyassignments.add(fa);
        return fa;
    }

    // Getter 和 Setter
    //MH 10/26 - These are dups
    //public String getDepartment() { return department; }
    //public void setDepartment(String department) { this.department = department; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

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
    
    @Override
    public String getRole() {
        return "Faculty"; // Or whatever specific role name is needed
    }
}
