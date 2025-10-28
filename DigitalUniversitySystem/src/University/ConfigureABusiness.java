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
        department.ensureCourseScheduleInitialized();


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
        Person person019 = persondirectory.newPerson("S019", "Evelyn Zhao", "evelyn.zhao@northeastern.edu");         //student4
        Person person020 = persondirectory.newPerson("S020", "Michael Chen", "michael.chen@northeastern.edu");       //student5
        Person person021 = persondirectory.newPerson("S021", "Linda Park", "linda.park@northeastern.edu");           //student6
        Person person022 = persondirectory.newPerson("S022", "Jason Lee", "jason.lee@northeastern.edu");             //student7
        Person person023 = persondirectory.newPerson("S023", "Emily Davis", "emily.davis@northeastern.edu");         //student8
        Person person024 = persondirectory.newPerson("S024", "Kevin Liu", "kevin.liu@northeastern.edu");             //student9
        Person person025 = persondirectory.newPerson("S025", "Sophia Wang", "sophia.wang@northeastern.edu");         //student10
        Person person026 = persondirectory.newPerson("S026", "Daniel Brown", "daniel.brown@northeastern.edu");       //student11
        Person person027 = persondirectory.newPerson("S027", "Olivia Zhang", "olivia.zhang@northeastern.edu");       //student12
        Person person028 = persondirectory.newPerson("S028", "William Yang", "william.yang@northeastern.edu");       //student13

        
        CourseCatalog catalog = department.getCourseCatalog();
        
        //Original course
        //there are total 9 courses in course catalog but only 8 of them are available 
        //course 9 is not on available for any semester.
        Course course1 = catalog.newCourse("INFO5100", "Applied Engineering", 4); 
        Course course2 = catalog.newCourse("INFO6205", "Program Structure", 4); 
        Course course3 = catalog.newCourse("INFO6210", "Data Science", 4); 
        Course course4 = catalog.newCourse("INFO6215", "Algorithmics", 4); 
        Course course5 = catalog.newCourse("INFO6250", "Web Development Tools and Methods", 4);
        Course course6 = catalog.newCourse("INFO7245", "Data Mining", 4);
        Course course7 = catalog.newCourse("INFO7370", "Data Visualization", 4); 
        Course course8 = catalog.newCourse("INFO5000", "Applied Marketing", 4);
        Course course9 = catalog.newCourse("INFO5001", "Advanced Java", 4);
              
        //Original semester
        CourseSchedule fall2020 = department.newCourseSchedule("Fall2020");
        CourseSchedule spring2021 = department.newCourseSchedule("Spring2021");
        CourseSchedule fall2021 = department.newCourseSchedule("Fall2021");
        CourseSchedule spring2022 = department.newCourseSchedule("Spring2022");
        
        //New semester
        CourseSchedule spring2025 = department.newCourseSchedule("Spring2025");
        CourseSchedule fall2025 = department.newCourseSchedule("Fall2025");

        
        //Original course offerings
        CourseOffer co1 = fall2020.newCourseOfferByCourse(course1); co1.generateSeats(15);
        CourseOffer co2 = fall2020.newCourseOfferByCourse(course2); co2.generateSeats(15);
        CourseOffer co3 = spring2021.newCourseOfferByCourse(course3); co3.generateSeats(20);
        CourseOffer co4 = spring2021.newCourseOfferByCourse(course4); co4.generateSeats(10);
        CourseOffer co5 = fall2021.newCourseOfferByCourse(course5); co5.generateSeats(10);
        CourseOffer co6 = fall2021.newCourseOfferByCourse(course6); co6.generateSeats(20);
        CourseOffer co7 = spring2022.newCourseOfferByCourse(course7); co7.generateSeats(10);
        CourseOffer co8 = spring2022.newCourseOfferByCourse(course8); co8.generateSeats(20);     
        
        //New courses offered
        /*MH - Removed because we the code above works.
        for (String c : new String[]{"INFO5100","INFO5200","INFO5300","INFO5400","INFO5500"}) {
            CourseOffer sOffer = spring2025.newCourseOffer(c);
            if (sOffer != null) sOffer.generateSeats(20);
            CourseOffer fOffer = fall2025.newCourseOffer(c);
            if (fOffer != null) fOffer.generateSeats(20);
        }*/
        
        //Create emplyee
        EmployeeDirectory employeedirectory = department.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);

        //Create faculty
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
        //this part is one side binding, telling us which professor teaches which course
        //need to add the side telling us which course is teaching by which professor
        //so I added the coxx.AssignAsTeacher(fpxx);
        FacultyAssignment fa1 = fp1.assignAsTeacher(co1); co1.AssignAsTeacher(fp1);
        FacultyAssignment fa2 = fp2.assignAsTeacher(co2); co2.AssignAsTeacher(fp2);
        FacultyAssignment fa3 = fp3.assignAsTeacher(co3); co3.AssignAsTeacher(fp3);
        FacultyAssignment fa4 = fp4.assignAsTeacher(co4); co4.AssignAsTeacher(fp4);
        FacultyAssignment fa5 = fp5.assignAsTeacher(co5); co5.AssignAsTeacher(fp5);
        FacultyAssignment fa6 = fp6.assignAsTeacher(co6); co6.AssignAsTeacher(fp6);
        FacultyAssignment fa7 = fp1.assignAsTeacher(co7); co7.AssignAsTeacher(fp7);
        FacultyAssignment fa8 = fp1.assignAsTeacher(co8); co8.AssignAsTeacher(fp8);
        
        

        
        //MH - Added so the faculty profile has the right class
        /*
        co1.setFacultyassignment(fa1);
        co2.setFacultyassignment(fa2);
        co3.setFacultyassignment(fa3);
        co4.setFacultyassignment(fa4);
        co5.setFacultyassignment(fa5);
        co6.setFacultyassignment(fa6);
        co7.setFacultyassignment(fa7);
        co8.setFacultyassignment(fa8);
        */


        //Student profile  给person分配学生角色
        StudentDirectory sd = department.getStudentDirectory();
        
        //Original students
        StudentProfile s1 = sd.newStudentProfile(person003);
        StudentProfile s2 = sd.newStudentProfile(person010);
        StudentProfile s3 = sd.newStudentProfile(person011);
        
        //Add new students
        StudentProfile s4 = sd.newStudentProfile(person019);
        StudentProfile s5 = sd.newStudentProfile(person020);
        StudentProfile s6 = sd.newStudentProfile(person021);
        StudentProfile s7 = sd.newStudentProfile(person022);
        StudentProfile s8 = sd.newStudentProfile(person023);
        StudentProfile s9 = sd.newStudentProfile(person024);
        StudentProfile s10 = sd.newStudentProfile(person025);
        StudentProfile s11 = sd.newStudentProfile(person026);
        StudentProfile s12 = sd.newStudentProfile(person027);
        StudentProfile s13 = sd.newStudentProfile(person028);

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




//Create Courseloads and set grades for students 给每个学生添加注册的课程和成绩用于展示

        //CreateCourseloads for student 1(person003)   
        CourseLoad courseloadFirstSemestersp1 = s1.newCourseLoad("Fall2020", s1);
        CourseLoad courseloadSecondSemestersp1 = s1.newCourseLoad("Spring2021", s1);    
        //add two seatassignment to student1 in his courseload of first semester
        SeatAssignment sa1sp1 = courseloadFirstSemestersp1.newSeatAssignment(co1);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa1sp1);
        //sa1sp1.setGrade(4.0f); //float grade
        SeatAssignment sa2sp1 = courseloadFirstSemestersp1.newSeatAssignment(co2);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa2sp1);
        //sa2sp1.setGrade(3.5f);      
        //add two seatassignment to student1 in his courseload of seconde semester
        SeatAssignment sa3sp1 = courseloadSecondSemestersp1.newSeatAssignment(co3);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa3sp1);
        //sa3sp1.setGrade(3.0f);
        SeatAssignment sa4sp1 = courseloadSecondSemestersp1.newSeatAssignment(co4);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa4sp1);
        //sa4sp1.setGrade(3.8f);
     
        //CreateCourseloads for student 2(person010)
        CourseLoad courseloadFirstSemestersp2 = s2.newCourseLoad("Fall2020", s2);
        CourseLoad courseloadSecondSemestersp2 = s2.newCourseLoad("Spring2021", s2);
        CourseLoad courseloadThirdSemestersp2 = s2.newCourseLoad("Fall2021", s2);     
        //add two seatassignment to student2 in his courseload of first semester      
        SeatAssignment sa1sp2 = courseloadFirstSemestersp2.newSeatAssignment(co1);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa1sp2);
        //sa1sp2.setGrade(4.0f);            
        SeatAssignment sa2sp2 = courseloadFirstSemestersp2.newSeatAssignment(co2);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa2sp2);
        //sa2sp2.setGrade(3.0f);       
        //add two seatassignment to student2 in his courseload of second semester
        SeatAssignment sa3sp2 = courseloadSecondSemestersp2.newSeatAssignment(co3);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa3sp2);
        //sa3sp2.setGrade(3.0f);       
        SeatAssignment sa4sp2 = courseloadSecondSemestersp2.newSeatAssignment(co4);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa4sp2);
        //sa4sp2.setGrade(3.5f);       
        //add two seatassignment to student2 in his courseload of third semester
        SeatAssignment sa5sp2 = courseloadThirdSemestersp2.newSeatAssignment(co5);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa5sp2);
        //sa5sp2.setGrade(4.0f);     
        SeatAssignment sa6sp2 = courseloadThirdSemestersp2.newSeatAssignment(co6);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa6sp2);
        //sa6sp2.setGrade(3.5f);
              
        //CreateCourseloads for student 3(person011) 
        CourseLoad courseloadFirstSemestersp3 = s3.newCourseLoad("Fall2020", s3);
        CourseLoad courseloadSecondSemestersp3 = s3.newCourseLoad("Spring2022", s3); //MH - Updated to have better test data
        //add two seatassignment to student3 in his courseload of first semester
        SeatAssignment sa1sp3 = courseloadFirstSemestersp3.newSeatAssignment(co1);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa1sp3);
        //sa1sp3.setGrade(3.0f);     
        SeatAssignment sa2sp3 = courseloadFirstSemestersp3.newSeatAssignment(co2);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa2sp3);
        //sa2sp3.setGrade(3.9f);       
        //add two seatassignment to student3 in his courseload of second semester    
        SeatAssignment sa3sp3 = courseloadSecondSemestersp3.newSeatAssignment(co3);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa3sp3);
        //sa3sp3.setGrade(4.0f);      
        SeatAssignment sa4sp3 = courseloadSecondSemestersp3.newSeatAssignment(co7); //MH - Updated to have better test data
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa4sp3);
        //sa4sp3.setGrade(2.5f);
     
        //CreateCourseloads for student 4(person019)
        CourseLoad courseloadFirstSemestersp4 = s4.newCourseLoad("Fall2020", s4);
        CourseLoad courseloadSecondSemestersp4 = s4.newCourseLoad("Spring2021", s4);
        CourseLoad courseloadThirdSemestersp4 = s4.newCourseLoad("Spring2022", s4); //MH - Updated to have better test data     
        //add two seatassignment to student4 in his courseload of first semester
        SeatAssignment sa1sp4 = courseloadFirstSemestersp4.newSeatAssignment(co1);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa1sp4);
        //sa1sp4.setGrade(2.0f);     
        SeatAssignment sa2sp4 = courseloadFirstSemestersp4.newSeatAssignment(co2);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa2sp4);
        //sa2sp4.setGrade(3.0f);     
        //add two seatassignment to student4 in his courseload of seconde semester
        SeatAssignment sa3sp4 = courseloadSecondSemestersp4.newSeatAssignment(co3);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa3sp4);
        //sa3sp4.setGrade(3.5f);     
        SeatAssignment sa4sp4 = courseloadSecondSemestersp4.newSeatAssignment(co4);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa4sp4);
        //sa4sp4.setGrade(2.1f);       
        //add two seatassignment to student4 in his courseload of third semester
        SeatAssignment sa5sp4 = courseloadThirdSemestersp4.newSeatAssignment(co5);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa5sp4);
        //sa5sp4.setGrade(3.6f);       
        SeatAssignment sa6sp4 = courseloadThirdSemestersp4.newSeatAssignment(co7); //MH - Updated to have better test data
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa6sp4);
        //sa6sp4.setGrade(3.2f);
        
        
        //CreateCourseloads for student 5 (person020)
        CourseLoad courseloadFirstSemestersp5 = s5.newCourseLoad("Fall2020", s5);
        CourseLoad courseloadSecondSemestersp5 = s5.newCourseLoad("Spring2021", s5);  
        //add two seatassignment to student5 in his courseload of first semester    
        SeatAssignment sa1sp5 = courseloadFirstSemestersp5.newSeatAssignment(co1);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa1sp5);
        SeatAssignment sa2sp5 = courseloadFirstSemestersp5.newSeatAssignment(co2);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa2sp5);
        //add two seatassignment to student5 in his courseload of second semester
        SeatAssignment sa3sp5 = courseloadSecondSemestersp5.newSeatAssignment(co3);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa3sp5);     
        SeatAssignment sa4sp5 = courseloadSecondSemestersp5.newSeatAssignment(co4);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa4sp5);
        
     
        //CreateCourseloads for student 6 (person021)
        CourseLoad courseloadFirstSemestersp6 = s6.newCourseLoad("Spring2021", s6);
        CourseLoad courseloadSecondSemestersp6 = s6.newCourseLoad("Fall2021", s6);
        //add two seatassignment to student6 in his courseload of first semester
        SeatAssignment sa1sp6 = courseloadFirstSemestersp6.newSeatAssignment(co3);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa1sp6);     
        SeatAssignment sa2sp6 = courseloadFirstSemestersp6.newSeatAssignment(co4);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa2sp6);
        //add two seatassignment to student6 in his courseload of second semester
        SeatAssignment sa3sp6 = courseloadSecondSemestersp6.newSeatAssignment(co5);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa3sp6);      
        SeatAssignment sa4sp6 = courseloadSecondSemestersp6.newSeatAssignment(co6);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa4sp6);
        
        
        //CreateCourseloads for student 7 (person022)
        CourseLoad courseloadFirstSemestersp7 = s7.newCourseLoad("Fall2021", s7);
        CourseLoad courseloadSecondSemestersp7 = s7.newCourseLoad("Spring2022", s7);
        //add two seatassignment to student7 in his courseload of first semester
        SeatAssignment sa1sp7 = courseloadFirstSemestersp7.newSeatAssignment(co5);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa1sp7);      
        SeatAssignment sa2sp7 = courseloadFirstSemestersp7.newSeatAssignment(co6);
        //MH 10/26 - Added to add assignments & calc grades.     
        populateAssignment(sa2sp7); 
        //add two seatassignment to student7 in his courseload of second semester
        SeatAssignment sa3sp7 = courseloadSecondSemestersp7.newSeatAssignment(co7);
        //MH 10/26 - Added to add assignments & calc grades.     
         populateAssignment(sa3sp7);    
        SeatAssignment sa4sp7 = courseloadSecondSemestersp7.newSeatAssignment(co8);
        //MH 10/26 - Added to add assignments & calc grades.
        populateAssignment(sa4sp7);
        
        
        //CreateCourseloads for student 8 (person023)
        CourseLoad courseloadFirstSemestersp8 = s8.newCourseLoad("Spring2022", s8);
        //add two seatassignment to student8 in his courseload of first semester
        SeatAssignment sa1sp8 = courseloadFirstSemestersp8.newSeatAssignment(co7);
       //MH 10/26 - Added to add assignments & calc grades.
        populateAssignment(sa1sp8);
        //sa1sp8.setGrade(2.0f);      
        SeatAssignment sa2sp8 = courseloadFirstSemestersp8.newSeatAssignment(co8);
        //MH 10/26 - Added to add assignments & calc grades.
        populateAssignment(sa2sp8);
        //sa2sp8.setGrade(4.0f);
        
        //CreateCourseloads for student 9 (person024)
        CourseLoad courseloadFirstSemestersp9 = s9.newCourseLoad("Fall2020", s9);
        CourseLoad courseloadSecondSemestersp9 = s9.newCourseLoad("Spring2021", s9);
        //first semester
        SeatAssignment sa1sp9 = courseloadFirstSemestersp9.newSeatAssignment(co1);
        populateAssignment(sa1sp9);
        SeatAssignment sa2sp9 = courseloadFirstSemestersp9.newSeatAssignment(co2);
        populateAssignment(sa2sp9);
        //second semester
        SeatAssignment sa3sp9 = courseloadSecondSemestersp9.newSeatAssignment(co3);
        populateAssignment(sa3sp9);
        SeatAssignment sa4sp9 = courseloadSecondSemestersp9.newSeatAssignment(co4);
        populateAssignment(sa4sp9);



        //CreateCourseloads for student 10 (person025)
        CourseLoad courseloadFirstSemestersp10 = s10.newCourseLoad("Fall2021", s10);
        CourseLoad courseloadSecondSemestersp10 = s10.newCourseLoad("Spring2022", s10);
        //first semester
        SeatAssignment sa1sp10 = courseloadFirstSemestersp10.newSeatAssignment(co5);
        populateAssignment(sa1sp10);
        SeatAssignment sa2sp10 = courseloadFirstSemestersp10.newSeatAssignment(co6);
        populateAssignment(sa2sp10);
        //second semester
        SeatAssignment sa3sp10 = courseloadSecondSemestersp10.newSeatAssignment(co7);
        populateAssignment(sa3sp10);
        SeatAssignment sa4sp10 = courseloadSecondSemestersp10.newSeatAssignment(co8);
        populateAssignment(sa4sp10);



        //CreateCourseloads for student 11 (person026)
        CourseLoad courseloadFirstSemestersp11 = s11.newCourseLoad("Spring2021", s11);
        CourseLoad courseloadSecondSemestersp11 = s11.newCourseLoad("Fall2021", s11);
        //first semester
        SeatAssignment sa1sp11 = courseloadFirstSemestersp11.newSeatAssignment(co3);
        populateAssignment(sa1sp11);
        SeatAssignment sa2sp11 = courseloadFirstSemestersp11.newSeatAssignment(co4);
        populateAssignment(sa2sp11);
        //second semester
        SeatAssignment sa3sp11 = courseloadSecondSemestersp11.newSeatAssignment(co5);
        populateAssignment(sa3sp11);
        SeatAssignment sa4sp11 = courseloadSecondSemestersp11.newSeatAssignment(co6);
        populateAssignment(sa4sp11);



        //CreateCourseloads for student 12 (person027)
        CourseLoad courseloadFirstSemestersp12 = s12.newCourseLoad("Fall2021", s12);
        CourseLoad courseloadSecondSemestersp12 = s12.newCourseLoad("Spring2022", s12);
        //first semester
        SeatAssignment sa1sp12 = courseloadFirstSemestersp12.newSeatAssignment(co5);
        populateAssignment(sa1sp12);
        SeatAssignment sa2sp12 = courseloadFirstSemestersp12.newSeatAssignment(co6);
        populateAssignment(sa2sp12);
        //second semester
        SeatAssignment sa3sp12 = courseloadSecondSemestersp12.newSeatAssignment(co7);
        populateAssignment(sa3sp12);
        SeatAssignment sa4sp12 = courseloadSecondSemestersp12.newSeatAssignment(co8);
        populateAssignment(sa4sp12);



        //CreateCourseloads for student 13 (person028)
        CourseLoad courseloadFirstSemestersp13 = s13.newCourseLoad("Spring2021", s13);
        CourseLoad courseloadSecondSemestersp13 = s13.newCourseLoad("Fall2021", s13);
        //first semester
        SeatAssignment sa1sp13 = courseloadFirstSemestersp13.newSeatAssignment(co3);
        populateAssignment(sa1sp13);
        SeatAssignment sa2sp13 = courseloadFirstSemestersp13.newSeatAssignment(co4);
        populateAssignment(sa2sp13);
        //second semester
        SeatAssignment sa3sp13 = courseloadSecondSemestersp13.newSeatAssignment(co5);
        populateAssignment(sa3sp13);
        SeatAssignment sa4sp13 = courseloadSecondSemestersp13.newSeatAssignment(co6);
        populateAssignment(sa4sp13);


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
        UserAccount ua5 = uad.newUserAccount(s1, "adam", "****"); 
        UserAccount ua6 = uad.newUserAccount(rp1, "mia", "109");//registrar account

//set the registrar profile demodata  作为registrar需要展示的信息

        rp1.setDepartment(department);
        rp1.setOfficeHours("Monday 10:00 a.m - 16:00 p.m.");
        rp1.setEmail("yangwang.j@northeastern.edu");
        rp1.setPhone("207-712-8888");

        //Student course registration and grades (original data)
        setupOriginalStudentData(s1, s2, s3, fall2020, spring2021, fall2021, co1, co2, co3, co4, co5, co6, co7, co8);

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
        uad.newUserAccount(employeeprofile0, "admin", "****"); 
        uad.newUserAccount(fp1, "gina", "****"); 
        uad.newUserAccount(s1, "adam", "****"); 
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

    
    //MH 10/26 - Added so we have a better way to manage adding assignements.
    public static void populateAssignment(SeatAssignment sa) {
        int seatNumber = sa.getSeat().getNumber(); //Used as a fake random number

        float gradeA1 = roundToTwoDecimals(4.0f - seatNumber / 10.0f);
        float gradeA2 = roundToTwoDecimals(3.5f - seatNumber / 10.0f);
        float gradeA3 = roundToTwoDecimals(3.0f - seatNumber / 10.0f);

        // Lab 1
        Assignment a1 = sa.newAssignment("Lab 1");
        a1.setGrade(gradeA1); // Set the 2-decimal float grade
        a1.setStatus("Graded"); 

        // Lab 2
        Assignment a2 = sa.newAssignment("Lab 2");
        a2.setGrade(gradeA2); // Set the 2-decimal float grade
        a2.setStatus("Pending"); 

        // Assignment 1
        Assignment a3 = sa.newAssignment("Assignment 1");
        a3.setGrade(gradeA3); // Set the 2-decimal float grade
        a3.setStatus("Submitted"); 

        sa.calculateGrade();
    }

    //MH 10/26 - Added so we have a better way to manage adding assignements.
    private static float roundToTwoDecimals(float value) { 
        return Math.round(value * 100.0f) / 100.0f;
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
        CourseLoad springLoad = student.newCourseLoad("Spring2025", student);
        CourseOffer c1 = spring.getCourseOfferByNumber(springC1);
        CourseOffer c2 = spring.getCourseOfferByNumber(springC2);

        if (c1 != null) {
            SeatAssignment seat1 = c1.assignEmptySeat(springLoad);
            //MH - Use this to handle grades on setup
            populateAssignment(seat1);
            //seat1.setGrade(3.7f);
            seat1.setAssignmentName("Project 1");
            seat1.setAssignmentScore(95);
            seat1.setStatus("Submitted");
        }

        if (c2 != null) {
            SeatAssignment seat2 = c2.assignEmptySeat(springLoad);
            //MH - Use this to handle grades on setup
            populateAssignment(seat2);
            //seat2.setGrade(3.8f);
            seat2.setAssignmentName("Homework 2");
            seat2.setAssignmentScore(90);
            seat2.setStatus("Submitted");
        }

        //Fall semester (in progress)
        CourseLoad fallLoad = student.newCourseLoad("Fall2025", student);
        for (String code : new String[]{"INFO5300", "INFO5400", "INFO5500"}) {
            CourseOffer f = fall.getCourseOfferByNumber(code);
            if (f != null) {
                SeatAssignment sa = f.assignEmptySeat(fallLoad);
                sa.setAssignmentName("Fall Coursework");
                sa.setAssignmentScore(85);
                sa.setStatus("In Progress");
                //MH - Use this to handle grades on setup
                populateAssignment(sa);
                /*
                float grade = switch (code) {
                    case "INFO5300" -> 3.9f;
                    case "INFO5400" -> 3.6f;
                    case "INFO5500" -> 3.3f;
                    default -> 3.5f;
                };
                sa.setGrade(grade);
                */
            }
        }

        //Financial Information
        student.setBalance(10000);
        student.setOutstandingTuition(9000);
        student.setPaidAmount(5000);
        student.addPaymentRecord(new PaymentRecord(new Date(), 5000, "Tuition Payment", "Paid"));
    }
}