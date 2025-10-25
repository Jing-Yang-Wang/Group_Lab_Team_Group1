/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University;

import University.CourseCatalog.Course;
import University.CourseCatalog.CourseCatalog;
import University.CourseSchedule.CourseLoad;
import University.CourseSchedule.CourseOffer;
import University.CourseSchedule.CourseSchedule;
import University.CourseSchedule.SeatAssignment;
import University.Department.Department;
import University.Persona.Person;
import University.Persona.PersonDirectory;
import University.Persona.UserAccount;
import University.Persona.UserAccountDirectory;
import University.Persona.Employee.EmployeeDirectory;
import University.Persona.Employee.EmployeeProfile;
import University.Persona.Faculty.FacultyDirectory;
import University.Persona.Faculty.FacultyProfile;
import University.Persona.Student.PaymentRecord;
import University.Persona.Student.StudentDirectory;
import University.Persona.Student.StudentProfile;
import java.util.Date; // ✅ 必须导入

/**
 */
public class ConfigureABusiness {

    public static Business initialize() {
        Business business = new Business();      
        Department department = new Department("Information Systems");
        
        // 绑定唯一的Department给Business
        business.setDepartment(department);

       
        // 原始8人
        PersonDirectory persondirectory = department.getPersonDirectory(); 
        Person person001 = persondirectory.newPerson("John Smith");
        Person person002 = persondirectory.newPerson("Gina Montana");
        Person person003 = persondirectory.newPerson("Adam Rollen");
        Person person004 = persondirectory.newPerson("Gina Elva");
        Person person005 = persondirectory.newPerson("Jim Dellon");
        Person person006 = persondirectory.newPerson("Anna Shnider");
        Person person007 = persondirectory.newPerson("Laura Brown");
        Person person008 = persondirectory.newPerson("Jack While");

        // 补全ID防止空指针
        person001.setId("P001"); person002.setId("P002"); person003.setId("P003");
        person004.setId("P004"); person005.setId("P005"); person006.setId("P006");
        person007.setId("P007"); person008.setId("P008");

        // 管理员、教师、学生（原始）
        EmployeeDirectory employeedirectory = department.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);
        FacultyDirectory facultydirectory = department.getFacultyDirectory();
        FacultyProfile facultyprofile0 = facultydirectory.newFacultyProfile(person002);
        StudentDirectory studentdirectory = department.getStudentDirectory();
        //StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);

        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        uadirectory.newUserAccount(employeeprofile0, "admin", "****"); 
       //uadirectory.newUserAccount(studentprofile0, "adam", "****"); 
        uadirectory.newUserAccount(facultyprofile0, "gina", "****"); 
        
        // 新增10学生
        Person person009 = persondirectory.newPerson("Evelyn Zhao");
        Person person010 = persondirectory.newPerson("Michael Chen");
        Person person011 = persondirectory.newPerson("Linda Park");
        Person person012 = persondirectory.newPerson("Jason Lee");
        Person person013 = persondirectory.newPerson("Emily Davis");
        Person person014 = persondirectory.newPerson("Kevin Liu");
        Person person015 = persondirectory.newPerson("Sophia Wang");
        Person person016 = persondirectory.newPerson("Daniel Brown");
        Person person017 = persondirectory.newPerson("Olivia Zhang");
        Person person018 = persondirectory.newPerson("William Yang");

        // 给新学生设置ID
        person009.setId("S009"); person010.setId("S010"); person011.setId("S011");
        person012.setId("S012"); person013.setId("S013"); person014.setId("S014");
        person015.setId("S015"); person016.setId("S016"); person017.setId("S017");
        person018.setId("S018");
        
        StudentProfile s1 = studentdirectory.newStudentProfile(person009);
        StudentProfile s2 = studentdirectory.newStudentProfile(person010);
        StudentProfile s3 = studentdirectory.newStudentProfile(person011);
        StudentProfile s4 = studentdirectory.newStudentProfile(person012);
        StudentProfile s5 = studentdirectory.newStudentProfile(person013);
        StudentProfile s6 = studentdirectory.newStudentProfile(person014);
        StudentProfile s7 = studentdirectory.newStudentProfile(person015);
        StudentProfile s8 = studentdirectory.newStudentProfile(person016);
        StudentProfile s9 = studentdirectory.newStudentProfile(person017);
        StudentProfile s10 = studentdirectory.newStudentProfile(person018);
        
        // 学生账号
        uadirectory.newUserAccount(s1, "student1", "student1");
        uadirectory.newUserAccount(s2, "student2", "student2");
        uadirectory.newUserAccount(s3, "student3", "student3");
        uadirectory.newUserAccount(s4, "student4", "student4");
        uadirectory.newUserAccount(s5, "student5", "student5");
        uadirectory.newUserAccount(s6, "student6", "student6");
        uadirectory.newUserAccount(s7, "student7", "student7");
        uadirectory.newUserAccount(s8, "student8", "student8");
        uadirectory.newUserAccount(s9, "student9", "student9");
        uadirectory.newUserAccount(s10, "student10", "student10");
        
        // --- 给学生添加基本个人信息 ---
        person009.setEmail("evelyn.zhao@northeastern.edu");
        s1.setMajor("Information Systems");
        s1.setDegree("Master of Science");

        person010.setEmail("michael.chen@northeastern.edu");
        s2.setMajor("Information Systems");
        s2.setDegree("Master of Science");

        person011.setEmail("linda.park@northeastern.edu");
        s3.setMajor("Information Systems");
        s3.setDegree("Master of Science");

        person012.setEmail("jason.lee@northeastern.edu");
        s4.setMajor("Information Systems");
        s4.setDegree("Master of Science");

        person013.setEmail("emily.davis@northeastern.edu");
        s5.setMajor("Information Systems");
        s5.setDegree("Master of Science");

        person014.setEmail("kevin.liu@northeastern.edu");
        s6.setMajor("Information Systems");
        s6.setDegree("Master of Science");

        person015.setEmail("sophia.wang@northeastern.edu");
        s7.setMajor("Information Systems");
        s7.setDegree("Master of Science");

        person016.setEmail("daniel.brown@northeastern.edu");
        s8.setMajor("Information Systems");
        s8.setDegree("Master of Science");

        person017.setEmail("olivia.zhang@northeastern.edu");
        s9.setMajor("Information Systems");
        s9.setDegree("Master of Science");

        person018.setEmail("william.yang@northeastern.edu");
        s10.setMajor("Information Systems");
        s10.setDegree("Master of Science");

        
        // 创建课程
        CourseCatalog catalog = new CourseCatalog(department);
        catalog.newCourse("INFO5100", "Application Engineering & Development", 4);
        catalog.newCourse("INFO5200", "Web Design", 4);
        catalog.newCourse("INFO5300", "Algorithms", 4);
        catalog.newCourse("INFO5400", "Database Management", 4);
        catalog.newCourse("INFO5500", "Big Data Systems", 4);
        
        department.setCourseCatalog(catalog);
            
        // 创建学期
        CourseSchedule spring2025 = department.newCourseSchedule("Spring2025");
        CourseSchedule fall2025 = department.newCourseSchedule("Fall2025");
        for (String c : new String[]{"INFO5100","INFO5200","INFO5300","INFO5400","INFO5500"}) {

        CourseOffer sOffer = spring2025.newCourseOffer(c);
        if (sOffer != null) { 
            sOffer.generateSeats(20); //为每门课创建座位
        } else {
            System.out.println("Spring offer for " + c + " is null");
        }

        CourseOffer fOffer = fall2025.newCourseOffer(c);
        if (fOffer != null) { 
            fOffer.generateSeats(20); //为每门课创建座位
        } else {
            System.out.println("Fall offer for " + c + " is null");
        }
    }


        // 学生数据
        addStudentData(s1, spring2025, fall2025, "INFO5100", "INFO5200");
        addStudentData(s2, spring2025, fall2025, "INFO5200", "INFO5300");
        addStudentData(s3, spring2025, fall2025, "INFO5300", "INFO5400");
        addStudentData(s4, spring2025, fall2025, "INFO5400", "INFO5500");
        addStudentData(s5, spring2025, fall2025, "INFO5100", "INFO5300");
        addStudentData(s6, spring2025, fall2025, "INFO5200", "INFO5400");
        addStudentData(s7, spring2025, fall2025, "INFO5300", "INFO5500");
        addStudentData(s8, spring2025, fall2025, "INFO5100", "INFO5400");
        addStudentData(s9, spring2025, fall2025, "INFO5200", "INFO5500");
        addStudentData(s10, spring2025, fall2025, "INFO5300", "INFO5400");
        
        business.setDefaultStudent(s1);
        return business;
    }

    // 添加学生成绩&财务
        private static void addStudentData(StudentProfile student, CourseSchedule spring, CourseSchedule fall, String springC1, String springC2) {
        // --- Spring 学期（已完成） ---
        CourseLoad springLoad = student.newCourseLoad("Spring2025");
        CourseOffer c1 = spring.getCourseOfferByNumber(springC1);
        CourseOffer c2 = spring.getCourseOfferByNumber(springC2);

        if (c1 != null) {
            SeatAssignment seat1 = c1.assignEmptySeat(springLoad);
            seat1.setGrade(3.7f);
            seat1.setAssignmentName("Project 1");
            seat1.setAssignmentScore(95);
            seat1.setStatus("Submitted");
        }

        if (c2 != null) {
            SeatAssignment seat2 = c2.assignEmptySeat(springLoad);
            seat2.setGrade(3.8f);
            seat2.setAssignmentName("Homework 2");
            seat2.setAssignmentScore(90);
            seat2.setStatus("Submitted");
        }

        // --- Fall 学期（进行中） ---
        CourseLoad fallLoad = student.newCourseLoad("Fall2025");
        for (String code : new String[]{"INFO5300", "INFO5400", "INFO5500"}) {
            CourseOffer f = fall.getCourseOfferByNumber(code);
            if (f != null) {
                SeatAssignment sa = f.assignEmptySeat(fallLoad);
                sa.setAssignmentName("Fall Coursework");
                sa.setAssignmentScore(85);
                sa.setStatus("In Progress");
                
                //让不同课程设置不同分值
                float grade = switch (code) {
                    case "INFO5300" -> 3.9f;
                    case "INFO5400" -> 3.6f;
                    case "INFO5500" -> 3.3f;
                    default -> 3.5f;
                };
                sa.setGrade(grade);
            }
        }

        // --- 财务信息 ---
        student.setBalance(10000);
        student.setOutstandingTuition(9000);
        student.setPaidAmount(5000);
        student.addPaymentRecord(new PaymentRecord(new Date(), 5000, "Tuition Payment", "Paid"));
}
}
