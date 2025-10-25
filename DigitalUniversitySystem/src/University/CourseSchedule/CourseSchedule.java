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

//all courses offered given a semester
public class CourseSchedule {
    
    private ArrayList<CourseOffer> schedule;      
    private CourseCatalog coursecatalog;                
    private String semester;

    public CourseSchedule(String semester, CourseCatalog cc) {
        
        schedule = new ArrayList<>();
        this.semester = semester;
        coursecatalog = cc;
        

    }

    
    //add courseoffer method
    public CourseOffer newCourseOffer(String courseNumber) {
        
        Course c = coursecatalog.getCourseByNumber(courseNumber);
            if(c == null) {
                System.out.println("Course not found: " + courseNumber);
                return null;
            }
            
            CourseOffer co = new CourseOffer(c);
            co.setCourseSchedule(this);
            schedule.add(co);
            return co;
    }
    
    //delete courseoffer method
    public void deleteCourseOffer(CourseOffer co) {
        schedule.remove(co);
    }
    
    
    public CourseOffer getCourseOfferByNumber(String courseNumber) {
        //在course schedule里遍历course offer
        for (CourseOffer co : schedule) {

            if (co.getCourseNumber().equals(courseNumber)) {
                return co;
            }
        }
        return null;
    }
    
    //calculate total revenue method
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

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    
    //MH 10/20 - Added so we can get data by faculty profile
    public ArrayList<CourseOffer> filterScheduleByFaculty(FacultyProfile fp) {
        ArrayList<CourseOffer> filteredOffers = new ArrayList<>();
        
        if (fp == null) {
            return filteredOffers; 
        }

        //Look for matches
        for (CourseOffer co : schedule) {
            if (co.getFacultyProfile() != null && co.getFacultyProfile().equals(fp)) {
                filteredOffers.add(co);
            }
        }
        return filteredOffers;
    }
}
