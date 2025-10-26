package University.Persona.Faculty;

import University.Persona.Person;
import University.CourseSchedule.CourseOffer;
import University.Persona.Profile;
import java.util.ArrayList;

public class FacultyProfile extends Profile {

    private ArrayList<FacultyAssignment> facultyassignments;
    private String department;
    private String course;
    private String telephone;

    // 构造方法
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
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public ArrayList<FacultyAssignment> getFacultyassignments() {
        return facultyassignments;
    }

    
    //实现抽象方法
    @Override
    public String getRole() {
        return "Faculty";
    }
}