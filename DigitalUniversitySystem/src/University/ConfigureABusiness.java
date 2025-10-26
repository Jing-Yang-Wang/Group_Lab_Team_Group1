/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/

//MH 10/18 - Just did some basic cleanup so it'll compile.
package University;

import University.CourseCatalog.Course;
import University.CourseCatalog.CourseCatalog;
import University.CourseSchedule.Assignment;
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
import University.Persona.Student.StudentDirectory;
import University.Persona.Student.StudentProfile;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

    public static Business initialize() {
        Business business = new Business();        
        Department department = new Department("Information Systems");

// Create Persons 创建人
        //MH 10/20 - Fixed issue with the persondirectory
        PersonDirectory pd = department.getPersonDirectory();  
        Person person001 = pd.newPerson("U001", "John Smith", "john.smith@university.edu");
        Person person002 = pd.newPerson("U002", "Gina Montana", "gina.montana@university.edu");        //faculty1
        Person person003 = pd.newPerson("U003", "Adam Rollen", "adam.rollen@university.edu");          //student1
        Person person004 = pd.newPerson("U004", "Gina Elva", "gina.elva@university.edu");
        Person person005 = pd.newPerson("U005", "Jim Dellon", "jim.dellon@university.edu");
        Person person006 = pd.newPerson("U006", "Anna Shnider", "anna.shnider@university.edu");
        Person person007 = pd.newPerson("U007", "Laura Brown", "laura.brown@university.edu");
        Person person008 = pd.newPerson("U008", "Jack While", "jack.while@university.edu");
        Person person009 = pd.newPerson("U009", "Mia Yang", "yangwang.j@northeastern.edu");             // registrar1
        Person person010 = pd.newPerson("U010", "David Hannan", "david.hannan@university.edu");         // student2
        Person person011 = pd.newPerson("U011", "Emily Johnson", "emily.johnson@university.edu");       // student3
        Person person012 = pd.newPerson("U012", "Joshua Miller", "joshua.miller@university.edu");       // faculty2
        Person person013 = pd.newPerson("U013", "Megan Anderson", "megan.anderson@university.edu");     // faculty3
        Person person014 = pd.newPerson("U014", "Sarah Wilson", "sarah.wilson@university.edu");         // faculty4
        Person person015 = pd.newPerson("U015", "Michael Brown", "michael.brown@university.edu");       // faculty5
        Person person016 = pd.newPerson("U016", "Jessica Davis", "jessica.davis@university.edu");       // faculty6
        Person person017 = pd.newPerson("U017", "Laura Garcia", "laura.garcia@university.edu");         // faculty7
        Person person018 = pd.newPerson("U018", "Jay Chou", "jay.chou@university.edu");                 // faculty8
        Person person019 = pd.newPerson("U019", "Ethan Clark", "ethan.clark@university.edu");           // student4
        Person person020 = pd.newPerson("U020", "Olivia Martinez", "olivia.martinez@university.edu");   // student5
        Person person021 = pd.newPerson("U021", "Liam Thompson", "liam.thompson@university.edu");       // student6
        Person person022 = pd.newPerson("U022", "Sophia Hernandez", "sophia.hernandez@university.edu"); // student7
        Person person023 = pd.newPerson("U023", "Noah Robinson", "noah.robinson@university.edu");       // student8

// Populate department  设置department内容

        //MH 10/20 - Added because a university is made up of departments
        //MH 10/20 - Moved this here to make sure it is called      
        business.getCollege().addDepartment(department);  
        CourseCatalog coursecatalog = department.getCourseCatalog();    
      
//Create new course 创建单门课程

        //student need to complete 4 semester to graduate, total 32 credits   
        Course course1 = coursecatalog.newCourse("Applied  Engineering", "INFO5100", 4); 
        Course course2 = coursecatalog.newCourse("Program Structure", "INFO6205", 4); 
        Course course3 = coursecatalog.newCourse("Data Science", "INFO6210", 4); 
        Course course4 = coursecatalog.newCourse("Algorithmics", "INFO6215", 4); 
        Course course5 = coursecatalog.newCourse("Web Development Tools and Methods", "INFO6250", 4);
        Course course6 = coursecatalog.newCourse("Data Mining", "INFO7245", 4);
        Course course7 = coursecatalog.newCourse("Data Visualization", "INFO7370", 4); 
        //course 8 not in any course schedule
        Course course8 = coursecatalog.newCourse("Applied Marketing", "INFO5000", 4);
        Course course9 = coursecatalog.newCourse("Advanced Java", "INFO5001", 4);

//Create new Course Schedule 创建所有的学期

        //create new courseSchedule per semester， total 4 semesters
        CourseSchedule courseschedule1 = department.newCourseSchedule("Fall2020");
        CourseSchedule courseschedule2 = department.newCourseSchedule("Spring2021");
        CourseSchedule courseschedule3 = department.newCourseSchedule("Fall2021");
        CourseSchedule courseschedule4 = department.newCourseSchedule("Spring2022");

//Create new Course Offer added to corresponding CourseSchedule  给每个学期的course offer添加对应课程和设置capacity

        //we have totally 9 courses in courseCatalog but only 8 of them are offered.
        //create new courseOffer for courseschedule 1
        CourseOffer courseoffer1 = courseschedule1.newCourseOffer("INFO5100");
        courseoffer1.generateSeats(15);
        CourseOffer courseoffer2 = courseschedule1.newCourseOffer("INFO6205");
        courseoffer2.generateSeats(15);
        
        //create new courseOffer for courseschedule 2
        CourseOffer courseoffer3 = courseschedule2.newCourseOffer("INFO6210");
        courseoffer3.generateSeats(20);
        CourseOffer courseoffer4 = courseschedule2.newCourseOffer("INFO6215");
        courseoffer4.generateSeats(10);
        
        //create new courseOffer for courseschedule 3
        CourseOffer courseoffer5 = courseschedule3.newCourseOffer("INFO6250");
        courseoffer5.generateSeats(10);
        CourseOffer courseoffer6 = courseschedule3.newCourseOffer("INFO7245");
        courseoffer6.generateSeats(20);
        
        //create new courseOffer for courseschedule 4
        CourseOffer courseoffer7 = courseschedule4.newCourseOffer("INFO7370");
        courseoffer7.generateSeats(10);
        CourseOffer courseoffer8 = courseschedule4.newCourseOffer("INFO5001");
        courseoffer8.generateSeats(20);


// Create Admins to manage the business
        EmployeeDirectory employeedirectory = department.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);

        //Faculty profile 给person分配老师角色
        FacultyDirectory fd = department.getFacultyDirectory();
        FacultyProfile fp1 = fd.newFacultyProfile(person002);
        FacultyProfile fp2 = fd.newFacultyProfile(person012);
        FacultyProfile fp3 = fd.newFacultyProfile(person013);
        FacultyProfile fp4 = fd.newFacultyProfile(person014);
        FacultyProfile fp5 = fd.newFacultyProfile(person015);
        FacultyProfile fp6 = fd.newFacultyProfile(person016);
        FacultyProfile fp7 = fd.newFacultyProfile(person017);
        FacultyProfile fp8 = fd.newFacultyProfile(person018);
        //Assign faculty to courseoffer 给course offer分配老师
        FacultyAssignment fa1 = fp1.AssignAsTeacher(courseoffer1);
        FacultyAssignment fa2 = fp2.AssignAsTeacher(courseoffer2);
        FacultyAssignment fa3 = fp3.AssignAsTeacher(courseoffer3);
        FacultyAssignment fa4 = fp4.AssignAsTeacher(courseoffer4);
        FacultyAssignment fa5 = fp5.AssignAsTeacher(courseoffer5);
        FacultyAssignment fa6 = fp6.AssignAsTeacher(courseoffer6);
        FacultyAssignment fa7 = fp7.AssignAsTeacher(courseoffer7);
        FacultyAssignment fa8 = fp8.AssignAsTeacher(courseoffer8);
        
        // Registrar ensures faculty info is visible in course offers
        courseoffer1.AssignAsTeacher(fp1);
        courseoffer2.AssignAsTeacher(fp2);
        courseoffer3.AssignAsTeacher(fp3);
        courseoffer4.AssignAsTeacher(fp4);
        courseoffer5.AssignAsTeacher(fp5);
        courseoffer6.AssignAsTeacher(fp6);
        courseoffer7.AssignAsTeacher(fp7);
        courseoffer8.AssignAsTeacher(fp8);

        //Student profile  给person分配学生角色
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile sp1 = sd.newStudentProfile(person003);
        StudentProfile sp2 = sd.newStudentProfile(person010);
        StudentProfile sp3 = sd.newStudentProfile(person011);
        StudentProfile sp4 = sd.newStudentProfile(person019);
        StudentProfile sp5 = sd.newStudentProfile(person020);
        StudentProfile sp6 = sd.newStudentProfile(person021);
        StudentProfile sp7 = sd.newStudentProfile(person022);
        StudentProfile sp8 = sd.newStudentProfile(person023);
        
        //Registrar profile  給person分配registrar角色
        RegistrarDirectory rd = department.getRegistrarDirectory();
        RegistrarProfile rp1 = rd.newRegistrarProfile(person009);



//Create Courseloads and set grades for students 给每个学生添加注册的课程和成绩用于展示

        //CreateCourseloads for student 1(person003)   
        CourseLoad courseloadFirstSemestersp1 = sp1.newCourseLoad("Fall2020", sp1);
        CourseLoad courseloadSecondSemestersp1 = sp1.newCourseLoad("Spring2021", sp1);    
        //add two seatassignment to student1 in his courseload of first semester
        SeatAssignment sa1sp1 = courseloadFirstSemestersp1.newSeatAssignment(courseoffer1);
        sa1sp1.setGrade(4.0f); //float grade
        SeatAssignment sa2sp1 = courseloadFirstSemestersp1.newSeatAssignment(courseoffer2);
        sa2sp1.setGrade(3.5f);      
        //add two seatassignment to student1 in his courseload of seconde semester
        SeatAssignment sa3sp1 = courseloadSecondSemestersp1.newSeatAssignment(courseoffer3);
        sa3sp1.setGrade(3.0f);
        SeatAssignment sa4sp1 = courseloadSecondSemestersp1.newSeatAssignment(courseoffer4);
        sa4sp1.setGrade(3.8f);
     
        //CreateCourseloads for student 2(person010)
        CourseLoad courseloadFirstSemestersp2 = sp2.newCourseLoad("Fall2020", sp2);
        CourseLoad courseloadSecondSemestersp2 = sp2.newCourseLoad("Spring2021", sp2);
        CourseLoad courseloadThirdSemestersp2 = sp2.newCourseLoad("Fall2021", sp2);     
        //add two seatassignment to student2 in his courseload of first semester      
        SeatAssignment sa1sp2 = courseloadFirstSemestersp2.newSeatAssignment(courseoffer1);
        sa1sp2.setGrade(4.0f);            
        SeatAssignment sa2sp2 = courseloadFirstSemestersp2.newSeatAssignment(courseoffer2);
        sa2sp2.setGrade(3.0f);       
        //add two seatassignment to student2 in his courseload of second semester
        SeatAssignment sa3sp2 = courseloadSecondSemestersp2.newSeatAssignment(courseoffer3);
        sa3sp2.setGrade(3.0f);       
        SeatAssignment sa4sp2 = courseloadSecondSemestersp2.newSeatAssignment(courseoffer4);
        sa4sp2.setGrade(3.5f);       
        //add two seatassignment to student2 in his courseload of third semester
        SeatAssignment sa5sp2 = courseloadThirdSemestersp2.newSeatAssignment(courseoffer5);
        sa5sp2.setGrade(4.0f);     
        SeatAssignment sa6sp2 = courseloadThirdSemestersp2.newSeatAssignment(courseoffer6);
        sa6sp2.setGrade(3.5f);
              
        //CreateCourseloads for student 3(person011) 
        CourseLoad courseloadFirstSemestersp3 = sp3.newCourseLoad("Fall2020", sp3);
        CourseLoad courseloadSecondSemestersp3 = sp3.newCourseLoad("Spring2021", sp3);      
        //add two seatassignment to student3 in his courseload of first semester
        SeatAssignment sa1sp3 = courseloadFirstSemestersp3.newSeatAssignment(courseoffer1);
        sa1sp3.setGrade(3.0f);     
        SeatAssignment sa2sp3 = courseloadFirstSemestersp3.newSeatAssignment(courseoffer2);
        sa2sp3.setGrade(3.9f);       
        //add two seatassignment to student3 in his courseload of second semester    
        SeatAssignment sa3sp3 = courseloadSecondSemestersp3.newSeatAssignment(courseoffer3);
        sa3sp3.setGrade(4.0f);      
        SeatAssignment sa4sp3 = courseloadSecondSemestersp3.newSeatAssignment(courseoffer4);
        sa4sp3.setGrade(2.5f);
     
        //CreateCourseloads for student 4(person019)
        CourseLoad courseloadFirstSemestersp4 = sp4.newCourseLoad("Fall2020", sp4);
        CourseLoad courseloadSecondSemestersp4 = sp4.newCourseLoad("Spring2021", sp4);
        CourseLoad courseloadThirdSemestersp4 = sp4.newCourseLoad("Fall2021", sp4);      
        //add two seatassignment to student4 in his courseload of first semester
        SeatAssignment sa1sp4 = courseloadFirstSemestersp4.newSeatAssignment(courseoffer1);
        sa1sp4.setGrade(2.0f);     
        SeatAssignment sa2sp4 = courseloadFirstSemestersp4.newSeatAssignment(courseoffer2);
        sa2sp4.setGrade(3.0f);     
        //add two seatassignment to student4 in his courseload of seconde semester
        SeatAssignment sa3sp4 = courseloadSecondSemestersp4.newSeatAssignment(courseoffer3);
        sa3sp4.setGrade(3.5f);     
        SeatAssignment sa4sp4 = courseloadSecondSemestersp4.newSeatAssignment(courseoffer4);
        sa4sp4.setGrade(2.1f);       
        //add two seatassignment to student4 in his courseload of third semester
        SeatAssignment sa5sp4 = courseloadThirdSemestersp4.newSeatAssignment(courseoffer5);
        sa5sp4.setGrade(3.6f);       
        SeatAssignment sa6sp4 = courseloadThirdSemestersp4.newSeatAssignment(courseoffer6);
        sa6sp4.setGrade(3.2f);
        
        
        //CreateCourseloads for student 5 (person020)
        CourseLoad courseloadFirstSemestersp5 = sp5.newCourseLoad("Fall2020", sp5);
        CourseLoad courseloadSecondSemestersp5 = sp5.newCourseLoad("Spring2021", sp5);  
        //add two seatassignment to student5 in his courseload of first semester    
        SeatAssignment sa1sp5 = courseloadFirstSemestersp5.newSeatAssignment(courseoffer1);
        sa1sp5.setGrade(2.2f);
        SeatAssignment sa2sp5 = courseloadFirstSemestersp5.newSeatAssignment(courseoffer2);
        sa2sp5.setGrade(3.2f);
        //add two seatassignment to student5 in his courseload of second semester
        SeatAssignment sa3sp5 = courseloadSecondSemestersp5.newSeatAssignment(courseoffer3);
        sa3sp5.setGrade(2.7f);      
        SeatAssignment sa4sp5 = courseloadSecondSemestersp5.newSeatAssignment(courseoffer4);
        sa4sp5.setGrade(3.4f);
        
     
        //CreateCourseloads for student 6 (person021)
        CourseLoad courseloadFirstSemestersp6 = sp6.newCourseLoad("Spring2021", sp6);
        CourseLoad courseloadSecondSemestersp6 = sp6.newCourseLoad("Fall2021", sp6);
        //add two seatassignment to student6 in his courseload of first semester
        SeatAssignment sa1sp6 = courseloadFirstSemestersp6.newSeatAssignment(courseoffer3);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa1sp6);
        //sa1sp6.setGrade(2.9f);      
        SeatAssignment sa2sp6 = courseloadFirstSemestersp6.newSeatAssignment(courseoffer4);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa2sp6);
        //sa2sp6.setGrade(1.9f);
        //add two seatassignment to student6 in his courseload of second semester
        SeatAssignment sa3sp6 = courseloadSecondSemestersp6.newSeatAssignment(courseoffer5);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa3sp6);
        //sa3sp6.setGrade(3.6f);       
        SeatAssignment sa4sp6 = courseloadSecondSemestersp6.newSeatAssignment(courseoffer6);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa4sp6);
        //sa4sp6.setGrade(3.9f);
        
        
        //CreateCourseloads for student 7 (person022)
        CourseLoad courseloadFirstSemestersp7 = sp7.newCourseLoad("Fall2021", sp7);
        CourseLoad courseloadSecondSemestersp7 = sp7.newCourseLoad("Spring2022", sp7);
        //add two seatassignment to student7 in his courseload of first semester
        SeatAssignment sa1sp7 = courseloadFirstSemestersp7.newSeatAssignment(courseoffer5);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa1sp7); 
        //sa1sp7.setGrade(3.1f);      
        SeatAssignment sa2sp7 = courseloadFirstSemestersp7.newSeatAssignment(courseoffer6);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa2sp7); 
        //sa2sp7.setGrade(2.8f);
        //add two seatassignment to student7 in his courseload of second semester
        SeatAssignment sa3sp7 = courseloadSecondSemestersp7.newSeatAssignment(courseoffer7);
        //MH 10/26 - Added to add assignments & calc grades.     
         populateAssignment(sa3sp7);    
        //sa3sp7.setGrade(3.7f); 
        SeatAssignment sa4sp7 = courseloadSecondSemestersp7.newSeatAssignment(courseoffer8);
        //MH 10/26 - Added to add assignments & calc grades.
        populateAssignment(sa4sp7);
        //sa4sp7.setGrade(4.0f);
        
        
        //CreateCourseloads for student 8 (person023)
        CourseLoad courseloadFirstSemestersp8 = sp8.newCourseLoad("Spring2022", sp8);
        //add two seatassignment to student8 in his courseload of first semester
        SeatAssignment sa1sp8 = courseloadFirstSemestersp8.newSeatAssignment(courseoffer7);
       //MH 10/26 - Added to add assignments & calc grades.
        populateAssignment(sa1sp8);
        //sa1sp8.setGrade(2.0f);      
        SeatAssignment sa2sp8 = courseloadFirstSemestersp8.newSeatAssignment(courseoffer8);
        //MH 10/26 - Added to add assignments & calc grades.
        populateAssignment(sa2sp8);
        //sa2sp8.setGrade(4.0f);


//Calculate revenue by semester 计算每个学期的总收入
        int totalRevenueOfFirstSemester = department.calculateRevenuesBySemester("Fall2020");
        int totalRevenueOfSecondSemester = department.calculateRevenuesBySemester("Spring2021");
        int totalRevenueOfThirdSemester = department.calculateRevenuesBySemester("Fall2021");
        int totalRevenueOfFourthSemester = department.calculateRevenuesBySemester("Spring2022");

        //MH 10/20 - Added because a university is made up of departments
        //MH 10/26 - I think this is old code that was broght back in after a merge
        //business.addDepartment(department); 
   
// Create User accounts that link to specific profiles 创建用户信息和密码
        UserAccountDirectory uad = business.getUserAccountDirectory();
        UserAccount ua3 = uad.newUserAccount(employeeprofile0, "admin", "****"); 
        UserAccount ua4 = uad.newUserAccount(fp1, "gina", "****");       
        UserAccount ua5 = uad.newUserAccount(sp1, "adam", "****"); 
        UserAccount ua6 = uad.newUserAccount(rp1, "mia", "109");//registrar account

//set the registrar profile demodata  作为registrar需要展示的信息
        rp1.setDepartment(department);
        rp1.setOfficeHours("Monday 10:00 a.m - 16:00 p.m.");
        rp1.setEmail("yangwang.j@northeastern.edu");
        rp1.setPhone("207-712-8888");
     
        return business;
    }
    
    //MH 10/26 - Added so we have a better way to manage adding assignements.
    public static void populateAssignment(SeatAssignment sa) {
        int seatNumber = sa.getSeat().getNumber(); //Used as a fake random number

        float gradeA1 = roundToTwoDecimals(90.0f - seatNumber);
        float gradeA2 = roundToTwoDecimals(85.0f - seatNumber);
        float gradeA3 = roundToTwoDecimals(95.0f - seatNumber);

        // Lab 1
        Assignment a1 = sa.newAssignment("Lab 1");
        a1.setGrade(gradeA1); // Set the 2-decimal float grade

        // Lab 2
        Assignment a2 = sa.newAssignment("Lab 2");
        a2.setGrade(gradeA2); // Set the 2-decimal float grade

        // Assignment 1
        Assignment a3 = sa.newAssignment("Assignment 1");
        a3.setGrade(gradeA3); // Set the 2-decimal float grade

        sa.calculateGrade();
    }

    //MH 10/26 - Added so we have a better way to manage adding assignements.
    private static float roundToTwoDecimals(float value) { 
        return Math.round(value * 100.0f) / 100.0f;
    }
}

