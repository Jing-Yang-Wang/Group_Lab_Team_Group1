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

    String number;
    String name;
    int credits;
    int price = 1500; //per credit hour



    public Course(String n, String numb, int ch) {
        name = n;
        number = numb;
        credits = ch;

    }

    public String getCourseNumber() {
        return number;
    }

    public int getCoursePrice() {
        return price * credits;

    }

    public int getCredits() {
        return credits;
    
    }
    
    //MH 10/20 - Added because I need to display
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    
    // XM 10/23
    @Override
    public String toString() {
        return name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }
  
}