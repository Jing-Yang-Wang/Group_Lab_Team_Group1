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

    private String number; //课程号
    private String name;
    private int credits;
    private int price = 1500; //每学分价格

    //构造方法:初始化对象
    public Course(String number, String name, int credits) {
        this.name = name;
        this.number = number;
        this.credits = credits;

    }

    public String getCourseNumber() {
        return number;
    }

    public String getCourseName() {
        return name;
    }

    
    public int getCoursePrice() {//计算课程总价
        return (int)(price * credits);

    }

    public double getCredits() {
        return credits;
    
}
    @Override
    public String toString(){
        return number + "-" + name + "(" + credits + "cr)";
    }
    
}