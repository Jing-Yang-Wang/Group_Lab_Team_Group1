/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.FacultyRole;

import UserInterface.WorkAreas.AdminRole.ManagePersonnelWorkResp.*;
import University.Business;
import University.CourseCatalog.Course;
import University.CourseSchedule.CourseOffer;
import University.CourseSchedule.CourseSchedule;
import University.CourseSchedule.SeatAssignment;
import University.Department.Department;
import University.Persona.Faculty.FacultyAssignment;
import University.Persona.Faculty.FacultyDirectory;
import University.Persona.Faculty.FacultyProfile;
import University.Persona.Student.StudentDirectory;
import University.Persona.Student.StudentProfile;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

//Git test

/**
 *
 * @author kal bugrara
 * @author Michael Hynes
 * Course Management
    ▪ View and update assigned course details (title, description, schedule, capacity).
    ▪ Upload or modify syllabus.
    ▪ Open or close course enrollment (before semester start)
 * 
 */
public class FacultyManageCoursesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageSuppliersJPanel
     */
    JPanel CardSequencePanel;
    Business business;
    Department department;
    FacultyDirectory facultyDirectory;
    FacultyProfile facultyProfile;    
    String semester = "Fall2020"; //TO DO - Add code to get this
    String selectedCourseNumber;
    //int selectedCourseOfferId;

    public FacultyManageCoursesJPanel(Business bz, FacultyProfile f, JPanel jp) {
        initComponents();   
        CardSequencePanel = jp;
        this.facultyProfile = f;       
        this.business = bz;              
        
        //Get the faculty department
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
        populateTable();
    }

    //TO DO - Make this dynamic
    public void populateCombobox() {        
        //Get semesters
        cbSchedule.addItem("Fall2020");
        cbSchedule.setSelectedIndex(0);                   
    }
    
    public void populateTable() {        
        //Setup our table
        DefaultTableModel model = (DefaultTableModel)tblHeader.getModel();
        model.setRowCount(0);  
        
        //Hide the syllabus & course offer id column
        TableColumnModel tcm = tblHeader.getColumnModel(); 
        TableColumn column3 = tcm.getColumn(3);
        column3.setWidth(0); 
        TableColumn column7 = tcm.getColumn(7);
        column7.setWidth(0);
        
        //String semester = cbSemesterSearch.getSelectedItem().toString().trim();
        //CourseSchedule courseSchedule = department.getCourseCatalog().getCourseList();
        
        //if (courseSchedule == null) {
        //    return;
        //}
        //for (CourseOffer co : courseSchedule.getSchedule()) { 
        
        //filterScheduleByFaculty
        
        ArrayList<FacultyAssignment> assignments = this.facultyProfile.getFacultyAssignments(); // <-- Direct Field Access
        for (FacultyAssignment fa : assignments) {
            CourseOffer co = fa.getCourseOffer();            

                Course c = co.getSubjectCourse();

                Object[] row = new Object[7]; 
                row[0] = co.getCourseNumber();                
                row[1] = c.getName();
                row[2] = semester;
                row[3] = String.valueOf(co.getSeatCount());
                row[4] = co.getSyllabus();
                row[5] = co.getEnrollmentOpen();

                model.addRow(row);                      
            } 
        }    
    
    
    public void resetUpdateSection() {
        // --- Labels ---
        lblCapacity.setVisible(false);
        lblEnrollment.setVisible(false);
        lblName.setVisible(false);
        lblNumber.setVisible(false);
        lblSchedule.setVisible(false);
        lblSyllabus.setVisible(false);
        
        // --- Radio Buttons ---
        rbClosed.setVisible(false);
        rbOpen.setVisible(false);
        
        // --- Text Fields ---
        tbCapacity.setVisible(false);
        tbName.setVisible(false);
        tbNumber.setVisible(false);
        tbSyllabus.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgEnrollment = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        OrderScroll1 = new javax.swing.JScrollPane();
        tblHeader = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblNumber = new javax.swing.JLabel();
        tbNumber = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        tbName = new javax.swing.JTextField();
        lblSchedule = new javax.swing.JLabel();
        lblCapacity = new javax.swing.JLabel();
        tbCapacity = new javax.swing.JTextField();
        lblSyllabus = new javax.swing.JLabel();
        tbSyllabus = new javax.swing.JTextField();
        lblEnrollment = new javax.swing.JLabel();
        rbOpen = new javax.swing.JRadioButton();
        rbClosed = new javax.swing.JRadioButton();
        btnSave = new javax.swing.JButton();
        cbSchedule = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setText("Manage Courses");
        add(lblTitle);
        lblTitle.setBounds(21, 20, 370, 28);

        tblHeader.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Number/Title", "Name/Desc.", "Schedule", "Capacity", "Syllabus", "Enrollment"
            }
        ));
        OrderScroll1.setViewportView(tblHeader);

        add(OrderScroll1);
        OrderScroll1.setBounds(20, 90, 560, 160);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(20, 260, 74, 23);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate);
        btnUpdate.setBounds(460, 260, 120, 23);

        lblNumber.setText("Number/Title");
        add(lblNumber);
        lblNumber.setBounds(30, 300, 80, 16);
        add(tbNumber);
        tbNumber.setBounds(120, 300, 70, 22);

        lblName.setText("Name/Desc.");
        add(lblName);
        lblName.setBounds(30, 340, 80, 16);
        add(tbName);
        tbName.setBounds(120, 340, 70, 22);

        lblSchedule.setText("Schedule");
        add(lblSchedule);
        lblSchedule.setBounds(30, 380, 80, 16);

        lblCapacity.setText("Capacity");
        add(lblCapacity);
        lblCapacity.setBounds(30, 420, 80, 16);
        add(tbCapacity);
        tbCapacity.setBounds(120, 420, 70, 22);

        lblSyllabus.setText("Syllabus");
        add(lblSyllabus);
        lblSyllabus.setBounds(210, 300, 60, 16);
        add(tbSyllabus);
        tbSyllabus.setBounds(280, 300, 300, 110);

        lblEnrollment.setText("Enrollment");
        add(lblEnrollment);
        lblEnrollment.setBounds(210, 430, 60, 16);

        bgEnrollment.add(rbOpen);
        rbOpen.setText("Open");
        rbOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOpenActionPerformed(evt);
            }
        });
        add(rbOpen);
        rbOpen.setBounds(280, 430, 70, 21);

        bgEnrollment.add(rbClosed);
        rbClosed.setText("Closed");
        rbClosed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbClosedActionPerformed(evt);
            }
        });
        add(rbClosed);
        rbClosed.setBounds(350, 430, 70, 21);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave);
        btnSave.setBounds(460, 440, 120, 23);

        cbSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbScheduleActionPerformed(evt);
            }
        });
        add(cbSchedule);
        cbSchedule.setBounds(120, 380, 72, 22);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        CardSequencePanel.removeAll();

        FacultyWorkAreaJPanel aos = new FacultyWorkAreaJPanel(business, facultyProfile, CardSequencePanel);

        CardSequencePanel.add("faculty", aos);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:        
        int selectedRow = tblHeader.getSelectedRow();
        
        if (selectedRow >=0) {
            //AI generated to save me time
            // --- Labels ---
            lblCapacity.setVisible(true);
            lblEnrollment.setVisible(true);
            lblName.setVisible(true);
            lblNumber.setVisible(true);
            lblSchedule.setVisible(true);
            lblSyllabus.setVisible(true);

            // --- Radio Buttons ---
            rbClosed.setVisible(true);
            rbOpen.setVisible(true);

            // --- Text Fields ---
            tbCapacity.setVisible(true);
            tbName.setVisible(true);
            tbNumber.setVisible(true);
            tbSyllabus.setVisible(true);
            
            //Get values from the slected row
            String courseNumber = tblHeader.getValueAt(selectedRow, 0).toString();
            String courseName = tblHeader.getValueAt(selectedRow, 1).toString();
            String capacity = tblHeader.getValueAt(selectedRow, 3).toString();
            String syllabus = tblHeader.getValueAt(selectedRow, 4).toString();
            String enrollmentOpen = tblHeader.getValueAt(selectedRow, 5).toString();
            String courseOfferID = tblHeader.getValueAt(selectedRow, 6).toString();
        
            //Set Fields
            tbNumber.setText(courseNumber);
            tbName.setText(courseName);
            tbCapacity.setText(capacity);
            tbSyllabus.setText(syllabus);
            
            //Save selected Course Number for update code
            selectedCourseNumber = courseNumber;
            //selectedCourseOfferId = Integer.parseInt(courseOfferID);
            
        } else {
            JOptionPane.showMessageDialog(null, "Please select a course offer to update!", "Warning", JOptionPane.WARNING_MESSAGE);           
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (
            tbNumber.getText().isBlank() ||
            tbName.getText().isBlank() ||
            tbCapacity.getText().isBlank() 
        ) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Data Required", JOptionPane.ERROR_MESSAGE);
            return; 
        }        
        
        int capacity;
        Boolean enrollmentOpen;
           
        String number = tbNumber.getText();        
        String name = tbName.getText();    
        String syllabus = tbSyllabus.getText();                
        if (rbOpen.isSelected()) {
            enrollmentOpen = true;
        } else {
            enrollmentOpen = false;
        };
        
        //Check datatypes
        try {
            capacity = Integer.parseInt(tbCapacity.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please check the Capacity.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Course c = department.getCourseCatalog().getCourseByNumber(selectedCourseNumber);      
        CourseOffer co = department.getCourseSchedule(semester).getCourseOfferByNumber(selectedCourseNumber);
        int seats;
        
        //See if they tried to reduce the capacity
        if (capacity < co.getSeatCount()) {
            JOptionPane.showMessageDialog(null, "You can not reduce capacity.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;          
        } else {
            seats = capacity - co.getSeatCount();
        }
        
        //Write data
        c.setNumber(number);
        c.setName(name);      
        co.setEnrollmentOpen(enrollmentOpen);
        co.setSyllabus(syllabus);   
        co.generatSeats(seats);        
        JOptionPane.showMessageDialog(this, "Data has been updated!", "Data Saved", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void rbClosedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbClosedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbClosedActionPerformed

    private void rbOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbOpenActionPerformed

    private void cbScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbScheduleActionPerformed
        // TODO add your handling code here:
        //populateTable();
    }//GEN-LAST:event_cbScheduleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane OrderScroll1;
    private javax.swing.ButtonGroup bgEnrollment;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbSchedule;
    private javax.swing.JLabel lblCapacity;
    private javax.swing.JLabel lblEnrollment;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JLabel lblSchedule;
    private javax.swing.JLabel lblSyllabus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JRadioButton rbClosed;
    private javax.swing.JRadioButton rbOpen;
    private javax.swing.JTextField tbCapacity;
    private javax.swing.JTextField tbName;
    private javax.swing.JTextField tbNumber;
    private javax.swing.JTextField tbSyllabus;
    private javax.swing.JTable tblHeader;
    // End of variables declaration//GEN-END:variables

}
