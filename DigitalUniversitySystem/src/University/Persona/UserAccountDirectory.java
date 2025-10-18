/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona;

import University.Persona.UserAccount;
import University.Persona.Person;
import University.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
//MH 10/18 - Swapped this from student to all profiles so it can handle the login process
//MH 10/18 - Removed department so it is business level
public class UserAccountDirectory {
    //Department department;
    //ArrayList<UserAccount> studentlist;
    ArrayList<UserAccount> useraccountlist;

    //public UserAccountDirectory(Department d) {
    public UserAccountDirectory() {
        //department = d;
        //studentlist = new ArrayList();
        useraccountlist = new ArrayList();

    }

    //MH 10/18 - Rebuilt to work with profile
    public UserAccount newUserAccount(Profile p, String un, String pw) {

        UserAccount ua = new UserAccount (p,  un,  pw);
        useraccountlist.add(ua);
        return ua;
    }
    
    /*
    public UserAccount newUserAccount(Person p) {

        UserAccount sp = new UserAccount(p);
        studentlist.add(sp);
        return sp;
    }
    */

    //MH 10/18 - This should be updated to look for only student profiles?
    public UserAccount findStudent(String id) {

        //for (UserAccount sp : studentlist) {
        for (UserAccount sp : useraccountlist) {    

         //   if (sp.isMatch(id)) {
         //       return sp;
         //   }
        }
            return null; //not found after going through the whole list
    }
    
    //MH 10/18 - Needed for login process
    public UserAccount AuthenticateUser(String un, String pw) {

        for (UserAccount ua : useraccountlist) {

            if (ua.IsValidUser(un, pw)) {
                return ua;
            }
        }
            return null; //not found after going through the whole list
         }  
    
    public ArrayList<UserAccount> getUserAccountList()
    {
        return useraccountlist;
    }
}
