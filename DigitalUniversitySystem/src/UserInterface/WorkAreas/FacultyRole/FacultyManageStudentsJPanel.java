/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.FacultyRole;

import UserInterface.WorkAreas.AdminRole.ManagePersonnelWorkResp.*;
import University.Business;
import University.CourseCatalog.Course;
import University.CourseSchedule.CourseLoad;
import University.CourseSchedule.CourseOffer;
import University.CourseSchedule.CourseSchedule;
import University.CourseSchedule.SeatAssignment;
import University.Department.Department;
import University.Persona.Faculty.FacultyAssignment;
import University.Persona.Faculty.FacultyProfile;
import University.Persona.Student.StudentDirectory;
import University.Persona.Student.StudentProfile;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;


import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author kal bugrara
 * @author Michael Hynes
 * Student Management:
    ▪ View list of enrolled students per course.
    ▪ Access each student’s progress report and transcript summary.
    ▪ View and grade each assignment and compute final letter grade automatically.
    ▪ Rank students based on total grade percentage and show class GPA.
 */
public class FacultyManageStudentsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageSuppliersJPanel
     */
    JPanel CardSequencePanel;
    Business business;
    Department department;
    StudentDirectory studentDirectory;
    FacultyProfile facultyProfile;
    SeatAssignment seatAssignment;
    int selectedRow;

    public FacultyManageStudentsJPanel(Business bz, FacultyProfile f, JPanel jp) {
        initComponents();
        CardSequencePanel = jp;
        this.facultyProfile = f;       
        this.business = bz;
        
        //Get the faculty profile's department
        Department targetDepartment = null;
        for (Department dept : business.getCollege().getDepartments()) {
            Department result = dept.getDepartmentIfContainsFaculty(this.facultyProfile);
            if (result != null) {
                targetDepartment = result;
                break; 
            }
        }
        this.department = targetDepartment;
        
        resetUpdateSection();
        populateCombobox();
        populateTableHeader();        
    }
    
    
     public void populateCombobox() {        
        //Get semesters
        Set<String> semesters = department.getAllSemesters();
        for (String semester : semesters) {
            cbSchedule.addItem(semester);
        }
        cbSchedule.setSelectedIndex(0); 
        
        //Get Courses
        ArrayList<FacultyAssignment> assignments = this.facultyProfile.getFacultyAssignments(); 
        for (FacultyAssignment fa : assignments) {
            CourseOffer co = fa.getCourseOffer();   
            cbCourse.addItem(co.getCourseNumber());             
        }
        cbCourse.setSelectedIndex(0); 
    }
     
    public void populateTableHeader() {        
        //Setup our table
        DefaultTableModel model = (DefaultTableModel)tblHeader.getModel();
        model.setRowCount(0);
                      
        //Get an arrey of SeatAssignments    
        String semester = cbSchedule.getSelectedItem().toString().trim();
        String number = cbCourse.getSelectedItem().toString().trim();
        CourseOffer co = department.getCourseSchedule(semester).getCourseOfferByNumber(number);
       
        //Use to calaculate class score
        int rank = 1;
        int studentCount = 0;
        float totalGrade = 0;
               
        //From seat assignments get students
        ArrayList<SeatAssignment> allSeatAssignments = co.getSeatAssignments();
        if (allSeatAssignments == null) {
             return;
        }    
        
        //Sort for ranking
        //AI helped with this, I did not know sort code
        allSeatAssignments.sort((sa1, sa2) -> {
            float score1 = sa1.GetCourseStudentScore();
            float score2 = sa2.GetCourseStudentScore();
            // Use Float.compare(score2, score1) for DESCENDING order (highest score first)
            return Float.compare(score2, score1);
        });  
        
        for (SeatAssignment sa : allSeatAssignments) {        
            Object[] row = new Object[3];
            
            //Transcript.getStudent()
            //sa.getCourseLoad()
            
            row[0] = "";  //Student
            row[1] = rank; //Rank
            row[2] =  String.valueOf(sa.GetCourseStudentScore());  //GPA

            model.addRow(row);    
            rank = rank +1;
            studentCount = studentCount + 1;
            totalGrade = totalGrade + sa.GetCourseStudentScore();            
        } 
        
        float classGrade = totalGrade / studentCount;
        tbClassGPA.setText(String.valueOf(classGrade));
    }
    
    public void populateTableDetail() {        
        //Setup our table
        DefaultTableModel model = (DefaultTableModel)tblDetail.getModel();
        model.setRowCount(0);
        
        /*
        //Get an arrey of SeatAssignments    
        String semester = cbSchedule.getSelectedItem().toString().trim();
        String number = cbCourse.getSelectedItem().toString().trim();
        CourseOffer co = department.getCourseSchedule(semester).getCourseOfferByNumber(number);
       
        
        //From seat assignments get students
        ArrayList<SeatAssignment> allSeatAssignments = co.getSeatAssignments();
        if (allSeatAssignments == null) {
             return;
        }    

        for (SeatAssignment sa : allSeatAssignments) {        
            Object[] row = new Object[3];
            
            row[0] = "Assignment goes here";  //Assignment
            row[1] = "Score"; //Score

            model.addRow(row);            
        } 
        */
    }
  
    public void resetUpdateSection() {
        spDetail.setVisible(false);
        btnSave.setVisible(false);      
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblSchedule = new javax.swing.JLabel();
        cbSchedule = new javax.swing.JComboBox<>();
        lblCourse = new javax.swing.JLabel();
        cbCourse = new javax.swing.JComboBox<>();
        lblClassGPA = new javax.swing.JLabel();
        tbClassGPA = new javax.swing.JTextField();
        spHeader = new javax.swing.JScrollPane();
        tblHeader = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        btnProgressReport = new javax.swing.JButton();
        btnTranscript = new javax.swing.JButton();
        btnAssignments = new javax.swing.JButton();
        spDetail = new javax.swing.JScrollPane();
        tblDetail = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setText("Manage Students");
        add(lblTitle);
        lblTitle.setBounds(21, 20, 370, 28);

        lblSchedule.setText("Semester");
        add(lblSchedule);
        lblSchedule.setBounds(20, 60, 60, 30);

        cbSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbScheduleActionPerformed(evt);
            }
        });
        add(cbSchedule);
        cbSchedule.setBounds(80, 60, 140, 30);

        lblCourse.setText("Course");
        add(lblCourse);
        lblCourse.setBounds(250, 60, 50, 30);

        cbCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCourseActionPerformed(evt);
            }
        });
        add(cbCourse);
        cbCourse.setBounds(300, 60, 140, 30);

        lblClassGPA.setText("Class GPA");
        add(lblClassGPA);
        lblClassGPA.setBounds(470, 60, 70, 30);

        tbClassGPA.setEditable(false);
        tbClassGPA.setOpaque(true);
        add(tbClassGPA);
        tbClassGPA.setBounds(540, 60, 64, 30);

        tblHeader.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student", "Rank", "GPA"
            }
        ));
        spHeader.setViewportView(tblHeader);

        add(spHeader);
        spHeader.setBounds(20, 100, 590, 150);

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        add(Back);
        Back.setBounds(20, 260, 74, 23);

        btnProgressReport.setText("Progress Report");
        btnProgressReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgressReportActionPerformed(evt);
            }
        });
        add(btnProgressReport);
        btnProgressReport.setBounds(230, 260, 120, 23);

        btnTranscript.setText("Transcript");
        btnTranscript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTranscriptActionPerformed(evt);
            }
        });
        add(btnTranscript);
        btnTranscript.setBounds(360, 260, 120, 23);

        btnAssignments.setText("Assignments");
        btnAssignments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignmentsActionPerformed(evt);
            }
        });
        add(btnAssignments);
        btnAssignments.setBounds(490, 260, 120, 23);

        tblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Assignment", "Grade"
            }
        ));
        spDetail.setViewportView(tblDetail);

        add(spDetail);
        spDetail.setBounds(20, 300, 590, 130);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave);
        btnSave.setBounds(490, 440, 120, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        CardSequencePanel.removeAll();

        FacultyWorkAreaJPanel aos = new FacultyWorkAreaJPanel(business, facultyProfile, CardSequencePanel);

        CardSequencePanel.add("faculty", aos);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_BackActionPerformed

    private void btnProgressReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgressReportActionPerformed
        // TODO add your handling code here:
        selectedRow = tblHeader.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a student to view!", "Warning", JOptionPane.WARNING_MESSAGE);           
            return;
        }
    }//GEN-LAST:event_btnProgressReportActionPerformed

    private void cbScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbScheduleActionPerformed
        // TODO add your handling code here:
        //populateTable();
    }//GEN-LAST:event_cbScheduleActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnTranscriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTranscriptActionPerformed
        // TODO add your handling code here:        
        selectedRow = tblHeader.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a student to view!", "Warning", JOptionPane.WARNING_MESSAGE);           
            return;
        }
    }//GEN-LAST:event_btnTranscriptActionPerformed

    private void btnAssignmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignmentsActionPerformed
        // TODO add your handling code here:
        selectedRow = tblHeader.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a student to view!", "Warning", JOptionPane.WARNING_MESSAGE);           
            return;
        }
        
        spDetail.setVisible(true);
        btnSave.setVisible(true);
    }//GEN-LAST:event_btnAssignmentsActionPerformed

    private void cbCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCourseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton btnAssignments;
    private javax.swing.JButton btnProgressReport;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTranscript;
    private javax.swing.JComboBox<String> cbCourse;
    private javax.swing.JComboBox<String> cbSchedule;
    private javax.swing.JLabel lblClassGPA;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblSchedule;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane spDetail;
    private javax.swing.JScrollPane spHeader;
    private javax.swing.JTextField tbClassGPA;
    private javax.swing.JTable tblDetail;
    private javax.swing.JTable tblHeader;
    // End of variables declaration//GEN-END:variables

}
