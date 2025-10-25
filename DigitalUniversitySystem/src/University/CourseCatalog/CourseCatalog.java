/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.CourseCatalog;

import University.Department.Department;
import java.util.ArrayList;

/**
 * 存储所有course对象
 * 新建course→newCourse()
 * 查找course→getCourseByNumber()
 * 提供列表→getCourseList()
 * @author kal bugrara
 */
public class CourseCatalog {
    private Department department;
    private String lastupdated;
    private ArrayList<Course> courselist; 
    
    //构造方法:与院系绑定
    public CourseCatalog(Department d){
        courselist = new ArrayList();
        department = d;
    }
    
    //获取课程列表
    public ArrayList<Course> getCourseList(){
        return courselist;
    }
    
    //创建新课程
    public Course newCourse(String n, String nm, int cr){
        Course c = new Course(n, nm, cr);
        courselist.add(c);
        return c;
    }
    
    //按课程编号查找课程
    public Course getCourseByNumber(String n){    
    if (n == null) return null;
    for (Course c : courselist) {
        if (c.getCourseNumber() != null && 
            c.getCourseNumber().trim().equalsIgnoreCase(n.trim())) {
            return c;
        }
    }
    System.out.println(" Course not found in catalog: " + n);
    return null;
}


    @Override
    public String toString(){
        return "CourseCatalog of" + department.getName() + "| Total Courses:" +courselist.size();
    }
}