/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.CourseCatalog;

import University.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseCatalog {
    
    private Department department;
    private String lastupdated;
    private ArrayList<Course> courselist; 
    
    public CourseCatalog(Department d){
        //instantiate ArrayList
        courselist = new ArrayList();
        department = d;
    }
    
    public ArrayList<Course> getCourseList(){
        return courselist;
    }
    //add course
    public Course newCourse(String courseName, String courseNumber, int credits){
        Course c = new Course(courseName, courseNumber, credits);
        courselist.add(c);
        return c;
    }
    //search course method
    public Course getCourseByNumber(String courseNumber){
        //look for course from the courselist
        for( Course c: courselist){
            
            if(c.getCourseNumber().equalsIgnoreCase(courseNumber)) 
                return c;
        }
        return null;
    }
    //delete course method
    public void deleteCourse(Course c) {
        courselist.remove(c);
    }
}