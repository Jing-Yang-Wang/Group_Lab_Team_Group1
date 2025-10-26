/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//MH 10/18 - Just did some basic cleanup so it'll compile.
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
import University.Persona.Faculty.FacultyAssignment;
import University.Persona.Faculty.FacultyDirectory;
import University.Persona.Faculty.FacultyProfile;
import University.Persona.Registrar.RegistrarDirectory;
import University.Persona.Registrar.RegistrarProfile;
import University.Persona.Student.PaymentRecord;
import University.Persona.Student.StudentDirectory;
import University.Persona.Student.StudentProfile;
import java.util.Date;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

    public static Business initialize() {
        Business business = new Business();      
        Department department = new Department("Information Systems");

        //Add to department structure
        business.getCollege().addDepartment(department);

        //Create a person directory
        PersonDirectory persondirectory = department.getPersonDirectory(); 

       
        //Original 8 people + new people
        Person person001 = persondirectory.newPerson("U001", "John Smith", "john.smith@university.edu");
        Person person002 = persondirectory.newPerson("U002", "Gina Montana", "gina.montana@university.edu");        //faculty1
        Person person003 = persondirectory.newPerson("U003", "Adam Rollen", "adam.rollen@university.edu");          //student1
        Person person004 = persondirectory.newPerson("U004", "Gina Elva", "gina.elva@university.edu");
        Person person005 = persondirectory.newPerson("U005", "Jim Dellon", "jim.dellon@university.edu");
        Person person006 = persondirectory.newPerson("U006", "Anna Shnider", "anna.shnider@university.edu");
        Person person007 = persondirectory.newPerson("U007", "Laura Brown", "laura.brown@university.edu");
        Person person008 = persondirectory.newPerson("U008", "Jack While", "jack.while@university.edu");
        Person person009 = persondirectory.newPerson("U009", "Mia Yang", "yangwang.j@northeastern.edu");             // registrar1
        Person person010 = persondirectory.newPerson("U010", "David Hannan", "david.hannan@university.edu");         // student2
        Person person011 = persondirectory.newPerson("U011", "Emily Johnson", "emily.johnson@university.edu");       // student3
        Person person012 = persondirectory.newPerson("U012", "Joshua Miller", "joshua.miller@university.edu");       // faculty2
        Person person013 = persondirectory.newPerson("U013", "Megan Anderson", "megan.anderson@university.edu");     // faculty3
        Person person014 = persondirectory.newPerson("U014", "Sarah Wilson", "sarah.wilson@university.edu");         // faculty4
        Person person015 = persondirectory.newPerson("U015", "Michael Brown", "michael.brown@university.edu");       // faculty5
        Person person016 = persondirectory.newPerson("U016", "Jessica Davis", "jessica.davis@university.edu");       // faculty6
        Person person017 = persondirectory.newPerson("U017", "Laura Garcia", "laura.garcia@university.edu");         // faculty7
        Person person018 = persondirectory.newPerson("U018", "Jay Chou", "jay.chou@university.edu");                 // faculty8
        
        //10 new students
        Person person019 = persondirectory.newPerson("S019", "Evelyn Zhao", "evelyn.zhao@northeastern.edu");
        Person person020 = persondirectory.newPerson("S020", "Michael Chen", "michael.chen@northeastern.edu");
        Person person021 = persondirectory.newPerson("S021", "Linda Park", "linda.park@northeastern.edu");
        Person person022 = persondirectory.newPerson("S022", "Jason Lee", "jason.lee@northeastern.edu");
        Person person023 = persondirectory.newPerson("S023", "Emily Davis", "emily.davis@northeastern.edu");
        Person person024 = persondirectory.newPerson("S024", "Kevin Liu", "kevin.liu@northeastern.edu");
        Person person025 = persondirectory.newPerson("S025", "Sophia Wang", "sophia.wang@northeastern.edu");
        Person person026 = persondirectory.newPerson("S026", "Daniel Brown", "daniel.brown@northeastern.edu");
        Person person027 = persondirectory.newPerson("S027", "Olivia Zhang", "olivia.zhang@northeastern.edu");
        Person person028 = persondirectory.newPerson("S028", "William Yang", "william.yang@northeastern.edu");

        
        CourseCatalog catalog = department.getCourseCatalog();
        
        //Original courses
        Course course1 = catalog.newCourse("Applied Engineering", "INFO5100", 4); 
        Course course2 = catalog.newCourse("Program Structure", "INFO6205", 4); 
        Course course3 = catalog.newCourse("Data Science", "INFO6210", 4); 
        Course course4 = catalog.newCourse("Algorithmics", "INFO6215", 4); 
        Course course5 = catalog.newCourse("Web Development Tools and Methods", "INFO6250", 4);
        Course course6 = catalog.newCourse("Data Mining", "INFO7245", 4);
        Course course7 = catalog.newCourse("Data Visualization", "INFO7370", 4); 
        Course course8 = catalog.newCourse("Applied Marketing", "INFO5000", 4);
        Course course9 = catalog.newCourse("Advanced Java", "INFO5001", 4);
        
        //New Courses
        catalog.newCourse("Application Engineering & Development", "INFO5100", 4);
        catalog.newCourse("Web Design", "INFO5200", 4);
        catalog.newCourse("Algorithms", "INFO5300", 4);
        catalog.newCourse("Database Management", "INFO5400", 4);
        catalog.newCourse("Big Data Systems", "INFO5500", 4);

        
        //Original semester
        CourseSchedule fall2020 = department.newCourseSchedule("Fall2020");
        CourseSchedule spring2021 = department.newCourseSchedule("Spring2021");
        CourseSchedule fall2021 = department.newCourseSchedule("Fall2021");
        CourseSchedule spring2022 = department.newCourseSchedule("Spring2022");
        
        //New semester
        CourseSchedule spring2025 = department.newCourseSchedule("Spring2025");
        CourseSchedule fall2025 = department.newCourseSchedule("Fall2025");

        
        //Original course offerings
        CourseOffer co1 = fall2020.newCourseOffer("INFO5100"); co1.generateSeats(15);
        CourseOffer co2 = fall2020.newCourseOffer("INFO6205"); co2.generateSeats(15);
        CourseOffer co3 = spring2021.newCourseOffer("INFO6210"); co3.generateSeats(20);
        CourseOffer co4 = spring2021.newCourseOffer("INFO6215"); co4.generateSeats(10);
        CourseOffer co5 = fall2021.newCourseOffer("INFO6250"); co5.generateSeats(10);
        CourseOffer co6 = fall2021.newCourseOffer("INFO7245"); co6.generateSeats(20);
        CourseOffer co7 = spring2022.newCourseOffer("INFO7370"); co7.generateSeats(10);
        CourseOffer co8 = spring2022.newCourseOffer("INFO5001"); co8.generateSeats(20);
        
        //New courses offered
        for (String c : new String[]{"INFO5100","INFO5200","INFO5300","INFO5400","INFO5500"}) {
            CourseOffer sOffer = spring2025.newCourseOffer(c);
            if (sOffer != null) sOffer.generateSeats(20);
            CourseOffer fOffer = fall2025.newCourseOffer(c);
            if (fOffer != null) fOffer.generateSeats(20);
        }

        //Create a faculty
        EmployeeDirectory employeedirectory = department.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);

        FacultyDirectory fd = department.getFacultyDirectory();
        FacultyProfile fp1 = fd.newFacultyProfile(person002);
        FacultyProfile fp2 = fd.newFacultyProfile(person012);
        FacultyProfile fp3 = fd.newFacultyProfile(person013);
        FacultyProfile fp4 = fd.newFacultyProfile(person014);
        FacultyProfile fp5 = fd.newFacultyProfile(person015);
        FacultyProfile fp6 = fd.newFacultyProfile(person016);
        FacultyProfile fp7 = fd.newFacultyProfile(person017);
        FacultyProfile fp8 = fd.newFacultyProfile(person018);

        //Assigning teachers to courses
        FacultyAssignment fa1 = fp1.assignAsTeacher(co1); co1.AssignAsTeacher(fp1);
        FacultyAssignment fa2 = fp2.assignAsTeacher(co2); co2.AssignAsTeacher(fp2);
        FacultyAssignment fa3 = fp3.assignAsTeacher(co3); co3.AssignAsTeacher(fp3);
        FacultyAssignment fa4 = fp4.assignAsTeacher(co4); co4.AssignAsTeacher(fp4);
        FacultyAssignment fa5 = fp5.assignAsTeacher(co5); co5.AssignAsTeacher(fp5);
        FacultyAssignment fa6 = fp6.assignAsTeacher(co6); co6.AssignAsTeacher(fp6);
        FacultyAssignment fa7 = fp7.assignAsTeacher(co7); co7.AssignAsTeacher(fp7);
        FacultyAssignment fa8 = fp8.assignAsTeacher(co8); co8.AssignAsTeacher(fp8);

        //Create Student
        StudentDirectory sd = department.getStudentDirectory();
        
        //Original students
        StudentProfile sp1 = sd.newStudentProfile(person003);
        StudentProfile sp2 = sd.newStudentProfile(person010);
        StudentProfile sp3 = sd.newStudentProfile(person011);
        
        //Add new students
        StudentProfile s1 = sd.newStudentProfile(person019);
        StudentProfile s2 = sd.newStudentProfile(person020);
        StudentProfile s3 = sd.newStudentProfile(person021);
        StudentProfile s4 = sd.newStudentProfile(person022);
        StudentProfile s5 = sd.newStudentProfile(person023);
        StudentProfile s6 = sd.newStudentProfile(person024);
        StudentProfile s7 = sd.newStudentProfile(person025);
        StudentProfile s8 = sd.newStudentProfile(person026);
        StudentProfile s9 = sd.newStudentProfile(person027);
        StudentProfile s10 = sd.newStudentProfile(person028);

        //Set up student majors and degrees
        s1.setMajor("Information Systems"); s1.setDegree("Master of Science");
        s2.setMajor("Information Systems"); s2.setDegree("Master of Science");
        s3.setMajor("Information Systems"); s3.setDegree("Master of Science");
        s4.setMajor("Information Systems"); s4.setDegree("Master of Science");
        s5.setMajor("Information Systems"); s5.setDegree("Master of Science");
        s6.setMajor("Information Systems"); s6.setDegree("Master of Science");
        s7.setMajor("Information Systems"); s7.setDegree("Master of Science");
        s8.setMajor("Information Systems"); s8.setDegree("Master of Science");
        s9.setMajor("Information Systems"); s9.setDegree("Master of Science");
        s10.setMajor("Information Systems"); s10.setDegree("Master of Science");

        //Registrar
        RegistrarDirectory rd = department.getRegistrarDirectory();
        RegistrarProfile rp1 = rd.newRegistrarProfile(person009);
        rp1.setDepartment(department);
        rp1.setOfficeHours("Monday 10:00 a.m - 16:00 p.m.");
        rp1.setEmail("yangwang.j@northeastern.edu");
        rp1.setPhone("207-712-8888");

        //Student course registration and grades (original data)
        setupOriginalStudentData(sp1, sp2, sp3, fall2020, spring2021, fall2021, co1, co2, co3, co4, co5, co6, co7, co8);

        //Add new student data
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

        //Create a user account
        UserAccountDirectory uad = business.getUserAccountDirectory();
        uad.newUserAccount(employeeprofile0, "admin", "****"); 
        uad.newUserAccount(fp1, "gina", "****"); 
        uad.newUserAccount(sp1, "adam", "****"); 
        uad.newUserAccount(rp1, "mia", "109");
        
        //Add new student accounts
        uad.newUserAccount(s1, "student1", "student1");
        uad.newUserAccount(s2, "student2", "student2");
        uad.newUserAccount(s3, "student3", "student3");
        uad.newUserAccount(s4, "student4", "student4");
        uad.newUserAccount(s5, "student5", "student5");
        uad.newUserAccount(s6, "student6", "student6");
        uad.newUserAccount(s7, "student7", "student7");
        uad.newUserAccount(s8, "student8", "student8");
        uad.newUserAccount(s9, "student9", "student9");
        uad.newUserAccount(s10, "student10", "student10");

        //Set Default Student
        business.setDefaultStudent(s1);

        return business;
    }

    // Original student data setting method
    private static void setupOriginalStudentData(StudentProfile sp1, StudentProfile sp2, StudentProfile sp3, 
                                               CourseSchedule fall2020, CourseSchedule spring2021, CourseSchedule fall2021,
                                               CourseOffer co1, CourseOffer co2, CourseOffer co3, CourseOffer co4, 
                                               CourseOffer co5, CourseOffer co6, CourseOffer co7, CourseOffer co8) {
      
    }

    //New create student data method
    private static void addStudentData(StudentProfile student, CourseSchedule spring, CourseSchedule fall, String springC1, String springC2) {
        //Spring semester (completed)
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

        //Fall semester (in progress)
        CourseLoad fallLoad = student.newCourseLoad("Fall2025");
        for (String code : new String[]{"INFO5300", "INFO5400", "INFO5500"}) {
            CourseOffer f = fall.getCourseOfferByNumber(code);
            if (f != null) {
                SeatAssignment sa = f.assignEmptySeat(fallLoad);
                sa.setAssignmentName("Fall Coursework");
                sa.setAssignmentScore(85);
                sa.setStatus("In Progress");
                
                float grade = switch (code) {
                    case "INFO5300" -> 3.9f;
                    case "INFO5400" -> 3.6f;
                    case "INFO5500" -> 3.3f;
                    default -> 3.5f;
                };
                sa.setGrade(grade);
            }
        }

        //Financial Information
        student.setBalance(10000);
        student.setOutstandingTuition(9000);
        student.setPaidAmount(5000);
        student.addPaymentRecord(new PaymentRecord(new Date(), 5000, "Tuition Payment", "Paid"));
    }
}