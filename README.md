# Group_Lab_Team_01

<B>1. Digital University System</B>

<B>2. Team Information</B> - TO DO List all team members along with their assigned roles and responsibilities. Include NUIDs for identification.
- Hairui Dou, Student Use Case
- Jing Yang Wang
- Michael Hynes, 76045378: Faculty Use Case
- Xieming Geng  

<BR>
<B>3. Project Overview</B>

The Digital University System allows for university staff, faculty, students, and the registar to manage tasks related to the academic college experence.  This systems allows members of each of the stated roles to view data and complete tasks that are important to them.

Key features include:
- Access Control Layer
- User account management
- Course management
- Assignment & grade management
- Course work management
- Registration management
- Transcript reporting
- Registrar task management

<BR>
<B>4. Installation & Setup Instructions</B>

Prerequisites
- Java Version: 19.0.2
- IDE: Apache NetBeans IDE 15
- Libraries: Absolutelayout, CopyLibs
  
Clone Repository 
- git clone https://github.com/Jing-Yang-Wang/Group_Lab_Team_Group1.git 
  
Run Project
- Open NetBeans
- Open Project: Select the local folder where the code was placed
- Select Run Project in NetBeans

<BR>
<B>5. Authentication & Access Control</B>

Login: This process is managed by the left actionsidejpanel on ProfileWorkArea.  When valid user name and password is entered and the Login button pushed, the application checks the user's profile role and sends the user to that roll's workarea. Workareas are in place for Admin, Faculty, Student, and Regisrar roles.

Logout: The login jpanel is always visible on the lefthand side.  There is no logout process other then closing the application or logging in as a different user.

<BR>
<B>6. Features Implemented</B> - TO DO Detail the functionalities implemented for each role.  Clearly specify which team member was responsible for each feature.

Admin

Faculty: Michael Hynes
- Initial "ProfileWorkareaExample 3.zip" & "Info5100-University-Example-2-18-2024.zip": Confirmed that it all ran so we had a good starting place.
- Code Reviews: Fixed code issues introduced during merges.
- Faculty Manage Course
- Faculty Manage Student Profiles
- Faculty Tuition/Enrollment Insight
- Faculty My Profile Management: Leverage a jframe created by Sophia-Geng.
- Faculty Performance Reporting
  
Student: Hairui Dou
- Course Registration Panel: Search, enroll, and drop courses with credit limit validation (max 8 credits).
- Coursework Management Panel: Submit assignments via file upload and view academic progress metrics.
- Financial Management Panel: Tuition payment and refund processing, payment history tracking, transcript access control.
- Graduation Audit Panel: Program requirements display, credit summary tracking, graduation eligibility determination.
- Profile Management Panel: Student information viewing and editing with data persistence.
- Transcript Review Panel: Semester-based grade viewing, term and overall GPA calculations, academic standing determination.
- Student Work Area Dashboard: Main navigation interface with feature buttons.

Registrar: Jing Yang Wang
- Course Offering Management Panel: displays all course offerings by semester (two per term). Registrar can review instructor, capacity, and schedule.
- Add Course Offering Panel: creates new course offerings for specific semesters. Registrar selects an existing course and defines instructor, schedule, and capacity.
- Edit Existing Course Offering Panel: updates existing course details such as instructor, schedule, or capacity.
- Registrar Profile Management Panel: allows updating of registrar information including work hours, email, and phone number.
- Student Registration Management Panel: shows all student registrations with enrollment status; enables manual add/drop of courses.
- Financial Report Panel: contains two tables summarizing total income by course offering and total income by semester.
- Analytics Report Panel: displays analytics across semesters including faculty, capacity, number of registrations, and average grade.

<BR>
<B>7. Usage Instructions</B> - TO DO Provide a step-by-step guide on how to interact with the system.  Include example scenarios for different user roles.

Admin

Faculty: Michael Hynes
- Scenario 1: Before the start of the semester you want to make sure you courses are open for enrollment and add a syllabus.  For this leverage the Manage Courses interface.
- Scenario 2: During the semester you need to enter grades as assignments are completed as well as check GPAs to see who might need extra help.  For this leverage the Manage Students interface.
- Scenario 3: During the semester you want to see how a tstudent is doing in other classes.  For this leverage the Transcript interface via the Manage Students interface.
- Scenario 4: As you prepare for a review, you want to show enrollment information of your courses.  You also want to print out the information to bring it with you.  For this leverage the Performanace Reporting interface.
- Scenario 5: You have a new phone number and want to document it.  For this leverage the Faculty Profile Management interface.
- Scenario 6: You have a new phone number and want to document it.  For this leverage the Faculty Profile Management interface.
- Scenario 7: As you prepare for a review, you want to show how much income you have brought into the university.  For this leverage the Performanace Reporting interface.
  
Student: Hairui Dou
- Scenario 1: Register for Courses
  - Log in as student
  - Click "Course Registration" from the student dashboard
  - Select search type (By CourseNumber, By CourseName, or By CourseType)
  - Enter keyword in search field and click "Search"
  - Select a course from the Available Course Offer table
  - Click "Enroll" to register (system validates credit limits - max 8 credits total)
  - View enrolled courses in the Registered Courses table
  - To drop a course, select it from Registered Courses and click "Drop"

- Scenario 2: Submit Assignments and Track Progress
  - From the dashboard, click "Coursework Management"
  - Select your course from the dropdown menu
  - Click "Choose File" to select an assignment file from your computer
  - Click "Submit" to upload the assignment (status changes to "Submitted")
  - View all submitted assignments in the table showing course, assignment name, status, and grade
  - Review Academic Progress metrics: Term GPA, Credits Completed, Completion Rate, and Academic Standing

- Scenario 3: Manage Finances and Access Transcript
  - Click "Financial Management" from the dashboard
  - Review Account Summary showing Current Balance, Outstanding Tuition, and Paid Amount
  - To pay tuition: Click "Pay Tuition", enter amount, and confirm (validates sufficient balance)
  - To request refund: Click "Refund Tuition", enter amount, and confirm (validates against paid amount)
  - View all transactions in the Payment History table
  - Click "View Transcript" to access grades (only available when tuition is fully paid)

- Scenario 4: Check Graduation Requirements
  - Click "Graduation Audit" from the dashboard
  - Review Program Information showing degree program and required credits
  - Check Credit Summary: Core Course credits, Elective Credits, and Total Credits Completed
  - View detailed Course List with all courses, credits, and completion status
  - Read Graduation Status message indicating eligibility or remaining credits needed

- Scenario 5: Update Profile Information
  - Click "Profile Management" from the dashboard
  - Review current information: Name, Student ID, Email, Major, and Degree
  - Edit any fields that need updating
  - Click "Save" to store changes (confirmation message appears)
  - Click "Back" to return to the dashboard

- Scenario 6: Review Academic Transcript
  - From Financial Management, click "View Transcript" (after paying tuition)
  - Or access directly via "Transcript Review" button on dashboard
  - View student name and ID at the top
  - Select a semester from the dropdown to view courses for that term
  - Table displays: Course Number, Course Name, Grade, Credits, and GPA Points
  - Review Term GPA for selected semester
  - Check Overall GPA across all semesters
  - View Academic Standing status (Excellent, Good, Average, or Probation)

Registrar
- Scenario 1:View and Manage Course Offerings，Log in as Mia (password 109).Select Course Offering Management to view all offerings.Click Add Course Offer to create a new offering.Click Edit Existing Course Offer to update details.Press Save to confirm changes.
- Scenario 2: Manage Student Registrations，Open Student Registration Panel.Select a student to see their registered courses.Click Add Registration to enroll or Drop Course to withdraw.Check that course capacity updates automatically.
- Scenario 3: Generate Financial Reports，Open Financial Report Panel.Review course-level and semester-level income tables.
- Scenario 4: Analyze Course Performance.Go to Analytics Report Panel.View faculty, capacity, registered students, and average grades for each course.
- Scenario 5: Update Registrar ProfileSelect Profile Management Panel.Click Update, edit email, phone, or work hours, then Save.


<BR>
<B>8. Testing Guide</B> - TO DO Outline how to test the system, including sample test cases.  Explain how to verify that authentication and authorization work correctly.

General
- Making sure the application compiles with no issues.
- For each user type confirm that they take you to the correct work area for their role.
  - Admin: User "Admin", Password "****"
  - Faculty: User "Gina", Password "****"
  - Student: User "student1", Password "student1"
  - Registrar: User "Mia", Password "109"
  
Admin

Faculty: For all interfaces you should only see data for courses assigned to the faculty that logged in.
- Login as "gina"
- Manage Courses: Select a course and press update.  Update all fields and press Save.  Note that table updates.  Confirm that you get messages when you reduce capactity or enter text in that field.  Press back when testing is complete.
- Manage Student Profiles: Select Semester "Spring2022", note that course updates.  Select course with students "Data Visualization", note that table updates.  On jframe confirm Class GPA "3.35".  In table select student and press Assignments, note table of assignments appears.  Change assignements and or grades and make sure to leave the field after making an edit and press save, note top table updates with new student and class GPAs.  Press Back when testing is complete.
- My Profile: Note values.  Press Update, note that fields can now be edited.  Update data and press Save, note that data is saved and fields can no longer be edited.  Press Back when testing is complete.
- Performance Reports: Select a semester "Spring2022", note that the table updates.  Confirm that data is correct.  Press Export, note that it'll generate a local csv file with the same data that is in the table.  Press Back when testing is complete.
- Tuition/Enrollment Insight: Review data to confirm the expect courses are displayed and the calculations are correct.  Press Back when testing is complete.
  
Student
- Login as "student1" (Password: "student1")

Course Registration Tests:
- Search by CourseNumber: Enter "INFO5100" → verify course appears
- Search by CourseName: Enter "Application" → verify matching courses display
- Search by CourseType: Enter "Required" → verify only required courses show
- Enroll in 4-credit course → verify it appears in Registered Courses
- Enroll in second 4-credit course → verify total credits = 8
- Try enrolling in third 4-credit course → verify error message: "cannot exceed 8 credits"
- Try enrolling in already-registered course → verify error: "You already have this course!"
- Drop a course → verify it's removed from Registered Courses table
- Verify table columns display correctly: CourseNumber, CourseName, CourseType, Credits

Coursework Management Tests:
- Select course from dropdown → verify course list populates
- Click "Choose File" → select any file → verify file name confirmation
- Click "Submit" without choosing file → verify error: "Please choose a file first"
- Submit assignment → verify it appears in table with "Submitted" status
- Verify Academic Progress calculations:
  - Term GPA displays as decimal (e.g., 3.45)
  - Credits Completed shows total integer
  - Completion Rate shows percentage (e.g., 85.0%)
  - Academic Standing shows correct status based on GPA

Financial Management Tests:
- Verify Account Summary displays all three balance fields
- Pay Tuition with insufficient balance → verify error message
- Pay Tuition with valid amount → verify balance decreases, paid amount increases
- Verify payment appears in Payment History table with date, type, amount, status
- Request Refund greater than paid amount → verify error
- Successful refund → verify balances update correctly
- Try "View Transcript" with outstanding tuition → verify access denied message
- Pay remaining tuition → verify "View Transcript" button now works

Graduation Audit Tests:
- Verify Program Information shows "Information Systems, MS" and "32" required credits
- Verify Credit Summary calculates correctly
- Verify Course List table displays all courses with status
- With < 32 credits → verify status shows remaining credits needed
- With ≥ 32 credits → verify "Eligible for Graduation!" message

Profile Management Tests:
- Verify all fields populate with current student data
- Edit Name field → click Save → verify success message
- Edit multiple fields → Save → logout/login → verify persistence

Transcript Review Tests:
- Verify student name and ID display correctly at top
- Select different semesters from dropdown → verify table updates
- Verify table shows: Term, Course Number, Course Name, Grade, Credits
- Verify Term GPA calculation matches displayed courses
- Take multiple courses across semesters → verify Overall GPA is correct average
- Verify Academic Standing matches GPA thresholds:
  - ≥ 3.7 = "Excellent"
  - ≥ 3.0 = "Good"
  - ≥ 2.0 = "Average"
  - < 2.0 = "Probation"

Navigation Tests:
- From each panel, click "Back" button → verify returns to Student Work Area
- From dashboard, test all six navigation buttons → verify each opens correct panel
- Verify CardLayout properly switches between views without errors

Registrar
Login Validation
 - Username: Mia Password: 109
 - Verify that login directs to the Registrar Work Area.
Course Offering Tests
 - Confirm two courses per semester display properly.
 - Add a new course offer → verify table update.
 - Edit an existing offer → save and refresh.
Student Registration Tests
 - Add a course to a student → capacity reduces by 1.
 - Drop a course → capacity increases again.
 - Check status column updates correctly.
Financial Report Tests
 - Ensure each course income = enrollments × tuition.
 - Confirm semester totals match sum of courses.
Analytics Report Tests
 - Validate faculty, capacity, registration count, and average grade values.
Profile Management Tests
 - Edit contact info, save, log out/in, and verify persistence.
 
<BR>
<B>9. Challenges & Solutions</B> - TO DO Summarize any difficulties encountered during development.  Highlight the solutions implemented to overcome these challenges.
    
Hairui Dou
- Credit Limit Validation: Ensuring students couldn't exceed 8 total credits while allowing enrollment and drops required careful state management.
  Solution: Implemented calculateTotalCredits() method that dynamically sums credits from the Registered Courses table before each enrollment attempt, providing real-time validation.

- Duplicate Course Prevention: Students could accidentally register for the same course multiple times.
  Solution: Added duplicate check in btnEnrollActionPerformed() that compares course numbers before enrollment and displays appropriate error message.

- Financial Access Control: Needed to restrict transcript access until tuition was fully paid.
  Solution: Implemented validation in btnViewTranscriptActionPerformed() that checks studentProfile.getOutstandingTuition() and blocks access with clear error message if balance remains.

- Payment Record Management: Needed to track both payments and refunds with proper history.
  Solution: Created PaymentRecord class with date, amount (negative for refunds), note, and status fields; maintained payment history list in StudentProfile.

Jing Yang Wang
-Complex Data Relationships: managing links between students, courses, and grades was challenging.
Solution: Introduced a StudentCourseDirectory to store and update registrations consistently.
-UI Refresh Issues: tables did not update after changes.
Solution: Added populateTable() calls after each update action.
-Role Access Control: registrar initially had access to Faculty views.
Solution: Implemented strict role-based login routing.
-Git Synchronization: merge conflicts arose during team integration.
Solution: Adopted consistent branching and pull-before-commit workflow.

Michael Hynes
  - GitHub: I worked with multiple TAs who here not able to help me with a fully working and documented process for working with branches.  This process had me trying multiple git tools, rebuilding branches, and rebuilding my local project.  It was not until Thursday that I had something that was provedn to work.  At that point I shared with the team but the divergance of our branches made the project much harder to complete then nessecary.
  - Communication: The team was able to meet on Tuesday to confirm roles and to go over the initial mergerd code that I provided.  We also had a short meeting before out Thursday class.  However, the rest of the team did not involve me in code reviews, answering questions, test planning, or any other planning.  I tried to establish regular communications in the MS Team I established when the group was formed, however I was the only one actively sending messages throughtout the project. For example, between 10/25 2:15 PM and 10/26 7:15 PM I've posted 19 times while no team member making a post or reaction.
  - Language: Being the only native English speaker, there were obvious language barrier issues.  This was a challenge during out meetings, our Teams conversations, and in for our code comments.
  - Group Size: Unlike other groups, have a group of four further compounnded the challenges that I stated above.
  - Instructions: In a few places, the intructions were not clear.  An example, "View and update assigned course details (title, description, schedule, capacity)" is an assignement requirement but several of these terms were NEVER used to describe the data in course and course schedule.  The instructions also did not make it clear that we were free to add classes and data points as needed.
  - Group Time Management: With the team's git issues and slow updated to main there was not enough time for end-to-end testing or group QA. 

Xieming Geng

<BR>
<B>10. Future Enhancements</B>

Admin Related

Faculty Related: Michael Hynes
  - The ability to track attendance.
  - Abiltiy to send emails to all students in a class.
  - Ability to add or delete assignments.
  - Ability to copy assignment structure from previous classes.
  - Notifications when student enrollment changes.
  - Give students a way to see a class syllabus.

Student Related: Hairui Dou
- Add waitlist functionality for full courses.
- Create a course evaluation/rating system for completed courses.
- Add assignment due date reminders and calendar integration.

Registrar Related

<BR>
<B>11. Contribution Breakdown</B> - TO DO Clearly state each team member’s contributions to the project.  Provide details on coding, documentation, testing, and other tasks.

Hairui Dou
- Designed and implemented the complete Student module including:
  - Course Registration Panel with search, enrollment, and drop functionality
  - Coursework Management Panel with assignment submission and academic progress tracking
  - Financial Management Panel with tuition payment, refunds, and transcript access control
  - Graduation Audit Panel with program requirements and eligibility tracking
  - Profile Management Panel for student information editing
  - Transcript Review Panel with GPA calculations and academic standing
  - Student Work Area Dashboard with navigation to all features
- Created PaymentRecord class for transaction tracking
- Implemented validation logic for credit limits, duplicates, and payment processing
- Integrated student module with existing system data structures

Jing Yang Wang
-Designed and implemented the Registrar module including:
  - Course Offering Management
  - Add/Edit Course Offer
  - Student Registration Management
  - Financial and Analytics Reports
  - Registrar Profile Management
-Integrated Registrar data with Admin and Faculty modules to maintain consistency.
-Performed comprehensive testing of Registrar authentication and data flows.
-Wrote documentation for Registrar features, usage instructions, and testing guide.
-Collaborated in team debugging sessions to resolve data and UI issues.

Michael Hynes
  - Built the initial skeleton of the application by taking the "ProfileWorkareaExample 3.zip" and "Info5100-University-Example-2-18-2024.zip" projects and combining them so they work together.  Modified the initial test data to work with the new combined project.  After completion, proved that to login process worked as expected for the admin, faculty, and student profiles.
  - Built out all sections related to the Faculty Use Case other then manage profile.  
  - Added new class and all code needed to mange Assignments.  
  - Reviewed merged code and fixed issues that prevented the project from compiling.  This was performed every time another team member commited code until 10/26 8:00 PM.
  - Worked with the TAs to document the Git process and shared it with the team.  This required multiple TAs, and TAs having me swap git tools twice as well as recreate my branch and manage the project in a new folder.
  - Versions of Readme.txt until 10/26 8:45 PM.
  - Posted updates in Teams and made myself available to assist other team members.

Xieming Geng























