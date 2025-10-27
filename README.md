# Group_Lab_Team_01

<B>1. Digital University System</B>

<B>2. Team Information</B> - TO DO List all team members along with their assigned roles and responsibilities. Include NUIDs for identification.
- Hairui Dou
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
  
Student

Registrar

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
  
Student

Registrar


<BR>
<B>8. Testing Guide</B> - TO DO Outline how to test the system, including sample test cases.  Explain how to verify that authentication and authorization work correctly.

General
- Making sure the application compiles with no issues.
- For each user type confirm that they take you to the correct work area for their role.
  - Admin: User "Admin", Password "****"
  - Faculty: User "Gina", Password "****"
  - Student: User "Adam", Password "****"
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

Registrar

<BR>
<B>9. Challenges & Solutions</B> - TO DO Summarize any difficulties encountered during development.  Highlight the solutions implemented to overcome these challenges.
    
Hairui Dou

Jing Yang Wang

Michael Hynes
  - GitHub: I worked with multiple TAs who here not able to help me with a fully working and documented process for working with branches.  This process had me trying multiple git tools, rebuilding branches, and rebuilding my local project.  It was not until Thursday that I had something that was provedn to work.  At that point I shared with the team but the divergance of our branches made the project much harder to complete then nessecary.
  - Communication: The team was able to meet on Tuesday to confirm roles and to go over the initial mergerd code that I provided.  We also had a short meeting before out Thursday class.  However, the rest of the team did not involve me in code reviews, answering questions, test planning, or any other planning.  I tried to establish regular communications in the MS Team I established when the group was formed, however I was the only one actively sending messages throughtout the project. For example, between 10/25 2:15 PM and 10/26 7:15 PM I've posted 19 times while no team member making a post or reaction.
  - Language: Being the only native English speaker, there were obvious language barrier issues.  This was a challenge during out meetings, our Teams conversations, and in for our code comments.
  - Group Size: Unlike other groups, have a group of four further compnonded the challenges that I stated above.
  - Instructions: In a few places, the intructions were not clear.  An example, "View and update assigned course details (title, description, schedule, capacity)" is an assignement requirement but several of these terms were used to describe the data in course and course schedule.  It also did not make it clear that we were free to add classes and data points as needed.
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

Student Related

Registrar Related

<BR>
<B>11. Contribution Breakdown</B> - TO DO Clearly state each team member’s contributions to the project.  Provide details on coding, documentation, testing, and other tasks.

Hairui Dou

Jing Yang Wang

Michael Hynes
  - Built the initial skeleton of the application by taking the "ProfileWorkareaExample 3.zip" and "Info5100-University-Example-2-18-2024.zip" projects and combining them so they work together.  Modified the initial test data to work with the new combined project.  After completion, proved that to login process worked as expected for the admin, faculty, and student profiles.
  - Built out all sections related to the Faculty Use Case other then manage profile.  
  - Added new class and all code needed to mange Assignments.  
  - Reviewed merged code and fixed issues that prevented the project from compiling.  This was performed every time another team member commited code until 10/26 8:00 PM.
  - Worked with the TAs to document the Git process and shared it with the team.  This required multiple TAs, and TAs having me swap git tools twice as well as recreate my branch and manage the project in a new folder.
  - Versions of Readme.txt until 10/26 8:45 PM.
  - Posted updates in Teams and made myself available to assist other team members.

Xieming Geng


















