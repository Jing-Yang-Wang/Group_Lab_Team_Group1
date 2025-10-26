/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.FacultyRole;

import University.Business;
import University.CourseCatalog.Course;
import University.CourseSchedule.CourseOffer;
import University.CourseSchedule.CourseSchedule;
import University.Department.Department;
import University.Persona.Faculty.FacultyAssignment;
import University.Persona.Faculty.FacultyProfile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author kal bugrara
 * @author Michael Hynes
 * Performance Reporting:
    ▪ Generate and export course-level performance reports including:
    ▪ Average grade
    ▪ Grade distribution
    ▪ Enrollment count
    ▪ Allow filtering reports by semester (dropdown like transcript)
 * 
 */
public class FacultyPerformanceReportingJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageSuppliersJPanel
     */
    JPanel CardSequencePanel;
    Business business;
    Department department;
    FacultyProfile facultyProfile;
    private boolean isInitialized = false; //Using this to manage when comboboxes refresh the jframe


    public FacultyPerformanceReportingJPanel(Business bz, FacultyProfile f, JPanel jp) {
        initComponents();
        CardSequencePanel = jp;
        this.facultyProfile = f;       
        this.business = bz;
        this.department = bz.getCollege().findDepartmentByFaculty(f);
        
        populateCombobox();
        populateTableHeader();  
        isInitialized = true;
    }
    
    public void populateCombobox() {        
        //Get semesters
        Set<String> semesters = department.getAllSemesters();
        for (String semester : semesters) {
            cbSchedule.addItem(semester);
        }
        cbSchedule.setSelectedIndex(0); 
    }

    public void populateTableHeader() {        
        //Setup our table
        DefaultTableModel model = (DefaultTableModel)tblHeader.getModel();
        model.setRowCount(0);
            
        //Get an arrey of Courses    
        String semester = cbSchedule.getSelectedItem().toString().trim();           
        ArrayList<FacultyAssignment> assignments = this.facultyProfile.getFacultyassignments(); 
        for (FacultyAssignment fa : assignments) {
            CourseOffer co = fa.getCourseOffer();         
            Course c = co.getSubjectCourse();
            CourseSchedule cs = department.findCourseScheduleByCourseOffer(co);
    
            if (cs.getSemester() == semester) {
                //AI - Helped with destribution code
                Map<String, Integer> distributionMap = co.getGradeDistribution();
                StringBuilder sb = new StringBuilder();
                String[] gradeOrder = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"};
                for (String gradeKey : gradeOrder) {
                    // Only append grades that exist to keep the string short
                    Integer count = distributionMap.getOrDefault(gradeKey, 0);
                    if (count > 0) {
                         sb.append(gradeKey).append(":").append(count).append(" | ");
                    }
                }
                String distributionString = sb.length() > 0 ? sb.substring(0, sb.length() - 3) : "No Grades";        
                
                Object[] row = new Object[4];               
               
                row[0] = co.getCourseNumber();  //Course
                row[1] = co.getAverageCourseGrade(); //Average Grade
                row[2] = distributionString; //Grade Destribution
                row[3] = co.getEnrollmentCount(); //Enrollment Count

                model.addRow(row);  
            }
        } 
    }
        
    //AI - Found export to csv code for me.
    public void exportTableToCSV(JTable table, String filePath) {
        TableModel model = table.getModel();
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(new File(filePath)));

            // 1. Write Column Headers
            for (int i = 0; i < model.getColumnCount(); i++) {
                writer.write(model.getColumnName(i));
                if (i < model.getColumnCount() - 1) {
                    writer.write(","); // Use comma as the separator
                }
            }
            writer.newLine(); // Move to the next line

            // 2. Write Table Data Rows
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    // Ensure data is converted to a string before writing
                    Object cellValue = model.getValueAt(i, j);

                    // Handle null values to avoid exceptions
                    String value = (cellValue == null) ? "" : cellValue.toString();

                    writer.write(value);
                    if (j < model.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine(); // Move to the next row
            }

            JOptionPane.showMessageDialog(null, "Data successfully exported to: " + filePath, 
                                          "Export Successful", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error exporting data: " + e.getMessage(), 
                                          "Export Failed", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Ensure the writer is closed even if an error occurs
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
        spHeader = new javax.swing.JScrollPane();
        tblHeader = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setText("Performance Reporting");
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

        tblHeader.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course", "Average Grade", "Grade Distribution", "Enrollment Count"
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

        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        add(btnExport);
        btnExport.setBounds(490, 260, 120, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void cbScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbScheduleActionPerformed
        // TODO add your handling code here:
        if (!isInitialized) {
                return; 
        }    
        populateTableHeader();
    }//GEN-LAST:event_cbScheduleActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");

            // Suggest a default file name
            fileChooser.setSelectedFile(new File("grades_export.csv"));

            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                // The export logic is called here
                exportTableToCSV(tblHeader, fileToSave.getAbsolutePath());
            }
    }//GEN-LAST:event_btnExportActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        CardSequencePanel.removeAll();
        FacultyWorkAreaJPanel aos = new FacultyWorkAreaJPanel(business, facultyProfile, CardSequencePanel);
        CardSequencePanel.add("faculty", aos);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton btnExport;
    private javax.swing.JComboBox<String> cbSchedule;
    private javax.swing.JLabel lblSchedule;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane spHeader;
    private javax.swing.JTable tblHeader;
    // End of variables declaration//GEN-END:variables

}
