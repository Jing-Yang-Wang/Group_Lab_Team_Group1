/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona;

/**
 *
 * @author kal bugrara
 */
public class Person {
    // 扩展,增加姓名&邮箱
    private static int counter = 1; 
    private String universityID; 
    private String name;
    private String email;  

    // 完整参数的构造方法
    public Person(String id, String name, String email) {
        this.universityID = id;
        this.name = name;
        this.email = email;
    }
    //Ximeing 10/25
     public Person(String email) {
        this.email = email;
    }
   
    // Getter / Setter
//    public Person(String name) {
//        this.universityID = "P" + counter++;
//        this.name = name;
//    }
    
    // Getter / Setter 方法

    public String getUniversityID() {
        return universityID;
    }

    public void setUniversityID(String universityID) {
        this.universityID = universityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 为了向后兼容，保留 getPersonId 方法
    public String getPersonId() {
        return universityID;
    }

    public void setId(String id) {
        this.universityID = id;
    }
    
    public boolean isMatch(String id) {
        return this.universityID.equals(id);
    }
}