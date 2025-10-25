/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.CourseCatalog;

/**
 *
 * @author kal bugrara
 */
public class Course {
    //这里我更换了成员变量名 更清晰具体 增加了private访问修饰符
    private String courseNumber;
    private String courseName;
    private int credits;
    private int price = 1500; //per credit hour



    public Course(String courseName, String courseNumber, int credits) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.credits = credits;

    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public int getTotalOneCoursePrice() {
        return price * credits;

    }

    public int getCredits() {
        return credits;
    
    }
    
    //MH 10/20 - Added because I need to display
    public String getCourseName() {
        return courseName;
    }

    public int getPrice() {
        return price;
    }
 

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return courseName;
    }

}