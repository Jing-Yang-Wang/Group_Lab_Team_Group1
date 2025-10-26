/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {
    
    ArrayList<Person> personlist;

    public PersonDirectory() {
        personlist = new ArrayList();
    }

    // Getter / Setter 方法
    public ArrayList<Person> getPersonlist() {
        return personlist;
    }

    public void setPersonlist(ArrayList<Person> personlist) {
        this.personlist = personlist;
    }

    // 完整信息的创建方法
    public Person newPerson(String id, String name, String email) {
        Person p = new Person(id, name, email);
        personlist.add(p);
        return p;
    }

 //   Xieming 10/25
    
    public Person newPerson(String email) {
        Person p = new Person( email);
        personlist.add(p);
        return p;
    }

//    // 只有姓名的创建方法（自动生成ID）
//    public Person newPerson(String name) {
//        Person p = new Person(name);
//        personlist.add(p);
//        return p;
//    }

    public Person findPerson(String id) {
        for (Person p : personlist) {
            if (p.isMatch(id)) {
                return p;
            }
        }
        return null; // not found after going through the whole list
    }

    // 添加现有Person对象
    public void addPerson(Person p) {
        personlist.add(p);
    }

    // 检查邮箱是否已存在
    public boolean emailExists(String email) {
        for (Person person : personlist) {
            if (person.getEmail().equals(email)) { 
                return true;
            }
        }
        return false;
    }

    // 检查学号/工号是否已存在
    public boolean universityIDExists(String universityID) {
        for (Person person : personlist) {
            if (person.getUniversityID().equals(universityID)) {
                return true;
            }
        }
        return false;
    }
}