/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.CourseSchedule;

import University.CourseCatalog.Course;
import University.CourseCatalog.CourseCatalog;
import University.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {

    CourseCatalog coursecatalog;

    ArrayList<CourseOffer> schedule;
    String semester;

    public CourseSchedule(String s, CourseCatalog cc) {
        semester = s;
        coursecatalog = cc;
        schedule = new ArrayList();

    }

    public CourseOffer newCourseOffer(String n) {

        Course c = coursecatalog.getCourseByNumber(n);
        if(c==null) return null;
        CourseOffer co;
        co = new CourseOffer(c);
        schedule.add(co);
        return co;
    }

    public CourseOffer getCourseOfferByNumber(String n) {

        for (CourseOffer co : schedule) {

            if (co.getCourseNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {

            sum = sum + co.getTotalCourseRevenues();

        }
        return sum;
    }

    //MH 10/19 - Added for "Faculty Use Case"
    public ArrayList<CourseOffer> getSchedule() {
        return schedule;
    }

    public String getSemester() {
        return semester;
    }
    
    //MH 10/20 - Added so we can get data by faculty profile
    public ArrayList<CourseOffer> filterScheduleByFaculty(FacultyProfile facultyProfile) {
        ArrayList<CourseOffer> filteredOffers = new ArrayList<>();
        
        if (facultyProfile == null) {
            return filteredOffers; 
        }

        //Look for matches
        for (CourseOffer co : schedule) {
            if (co.getFacultyProfile() != null && co.getFacultyProfile().equals(facultyProfile)) {
                filteredOffers.add(co);
            }
        }
        return filteredOffers;
    }
}
