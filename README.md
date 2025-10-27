# Group_Lab_Team_01

1. Digital University System

2. Team Information
- Hairui Dou
- Jing Yang Wang
- Michael Hynes, 76045378: Faculty Use Case
- Xieming Geng

  TO DO List all team members along with their assigned roles and responsibilities.
  TO DO Include NUIDs for identification.


3. Project Overview

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


4. Installation & Setup Instructions

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


5. Authentication & Access Control

Login: This process is managed by the left actionsidejpanel on ProfileWorkArea.  When valid user name and password is entered and the Login button pushed, the application checks the user's profile role and sends the user to that roll's workarea. Workareas are in place for Admin, Faculty, Student, and Regisrar roles.

Logout: The login jpanel is always visible on the lefthand side.  There is no logout process other then closing the application or logging in as a different user.


6. Features Implemented

Admin

Faculty: Michael Hynes
- Mange Course
- Manage Student Profiles
- Tuition/Enrollment Insight
- My Profile Management: Leverage a jframe created by Sophia-Geng.
- Performance Reporting
  
Student

Registrar

  TO DO Detail the functionalities implemented for each role.
  TO DO Clearly specify which team member was responsible for each feature.


7. Usage Instructions
   
  TO DO Provide a step-by-step guide on how to interact with the system.
  TO DO Include example scenarios for different user roles.


8. Testing Guide

General
- Making sure the application compiles with no issues.
  
Admin

Faculty
- Login as "gina"
- Manage Courses: Select a course and press update.  Update all fields and press Save.  Note that table updates.  Confirm that you get messages when you reduce capactity or enter text in that field.  Press back when testing is complete.
- Manage Student Profiles: Select Semester "Spring2022", note that course updates.  Select course with students "Data Visualization", note that table updates.  On jframe confirm Class GPA "3.35".  In table select student and press Assignments, note table of assignments appears.  Change assignements and or grades and make sure to leave the field after making an edit and press save, note top table updates with new student and class GPAs.  Press back when testing is complete.
  
Student

Regisrar

  TO DO Outline how to test the system, including sample test cases.
  TO DO Explain how to verify that authentication and authorization work correctly.


9. Challenges & Solutions
    
Hairui Dou

Jing Yang Wang

Michael Hynes
  - GitHub: I worked with multiple TAs who here not able to help me with a fully working and documented process for working with branches.  It was not until Thursday that I had something that was provedn to work.  At that point I shared with the team but the divergance of our branches made the project much harder to complete then nessecary.
  - Communication: The team was able to meet on Tuesday to confirm roles and to go over the initial mergerd code that I provided.  We also had a short meeting before out Thursday class.  However, the rest of the team did not involve me in code reviews, answering questions, test planning, or any other planning.  I tried to establish regular communications in the MS Team I established when the group was formed, however I was the only one actively sending messages throughtout the project. For example, between 10/25 2:15 PM and 10/26 7:15 PM I've posted 19 times while no team member making a post or reaction.
  - Language: Being the only native English speaker, there were obvious language barrier issues.  This was a challenge during out meetings, our Teams conversations, and in for our code comments.
  - Group Size: Unlike other groups, have a group of four further compnonded the challenges that I stated above.
  - Instructions: In a few places, the intructions were not clear.  An example, "View and update assigned course details (title, description, schedule, capacity)" is an assignement requirement but several of these terms were used to describe the data in course and course schedule.  It also did not make it clear that we were free to add classes and data points as needed.

Xieming Geng

 TO DO Summarize any difficulties encountered during development.
TO DO Highlight the solutions implemented to overcome these challenges.


10. Future Enhancements

Admin Related

Faculty Related
  - The ability to track attendance.
  - Abiltiy to send emails to all students in a class.
  - Ability to add or delete assignments.
  - Ability to copy assignment structure from previous classes.
  - Notifications when student enrollment changes.

Student Related

Registrar Related


11. Contribution Breakdown

Hairui Dou

Jing Yang Wang

Michael Hynes
  - Built the initial skeleton of the application by taking the "ProfileWorkareaExample 3.zip" and "Info5100-University-Example-2-18-2024.zip" projects and combining them so they work together.  Modified the initial test data to work with the new combined project.  After completion, proved that to login process worked as expected for the admin, faculty, and student profiles.
  - Built out all sections related to the Faculty Use Case.
  - Added new class for Assignments.
  - Reviewed merged code and fixed issues that prevented the project from compiling.
  - Worked with the TAs to document the Git process and shared it with the team.
  - Created inital versions of Readme.txt.

Xieming Geng

  TO DO Clearly state each team member’s contributions to the project.
  TO DO Provide details on coding, documentation, testing, and other tasks.









