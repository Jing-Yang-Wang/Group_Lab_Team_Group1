/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.AdminRole;

import University.Business;
import University.Persona.UserAccount;
import University.Persona.UserAccountDirectory;
import University.Persona.Student.StudentProfile;
import University.CourseCatalog.Course;
import University.CourseCatalog.CourseCatalog;
import University.CourseSchedule.CourseOffer;
import University.CourseSchedule.CourseSchedule;
import University.Department.Department;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;


public class AnalyticsDashboardJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AnalyticsDashboardJPanel
     */
    JPanel CardSequencePanel;
    Business business;
    Department department;

    public AnalyticsDashboardJPanel(Business b, Department d, JPanel jp) {
        CardSequencePanel = jp;
        this.business = b;
        this.department = d;
        initComponents();
        loadAnalyticsData();
    }

    private void loadAnalyticsData() {
        loadUserRoleSummary();
        loadCourseSummary();
        loadEnrollmentSummary();
        loadRevenueSummary();
    }

    private void loadUserRoleSummary() {
       
        int rc = userRoleTable.getRowCount();
        for (int i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) userRoleTable.getModel()).removeRow(i);
        }

        UserAccountDirectory uad = business.getUserAccountDirectory();
        Map<String, Integer> roleCount = new HashMap<>();
        
     
        for (UserAccount ua : uad.getUserAccountList()) {
            String role = ua.getRole();
            roleCount.put(role, roleCount.getOrDefault(role, 0) + 1);
        }
        

        for (Map.Entry<String, Integer> entry : roleCount.entrySet()) {
            Object[] row = new Object[2];
            row[0] = entry.getKey();
            row[1] = entry.getValue();
            ((DefaultTableModel) userRoleTable.getModel()).addRow(row);
        }
        
      
        userRoleChartPanel.updateData(roleCount);
    }

    private void loadCourseSummary() {
        
        int rc = courseTable.getRowCount();
        for (int i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) courseTable.getModel()).removeRow(i);
        }

       
        if (department == null) {
            System.out.println("Warning: Department is null, cannot load course data");
            return;
        }

        
        CourseCatalog catalog = department.getCourseCatalog();
        if (catalog != null) {
            for (Course course : catalog.getCourseList()) {
                Object[] row = new Object[3];
                row[0] = course.getCourseNumber();
                row[1] = course.getCourseName();
                row[2] = course.getCredits();
                ((DefaultTableModel) courseTable.getModel()).addRow(row);
            }
        }
    }

    private void loadEnrollmentSummary() {
    
        int rc = enrollmentTable.getRowCount();
        for (int i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) enrollmentTable.getModel()).removeRow(i);
        }

        Map<String, Integer> enrollmentData = new HashMap<>();
        

        if (department == null) {
            System.out.println("Warning: Department is null, cannot load enrollment data");
            return;
        }
        
      
        CourseSchedule schedule = department.getCourseSchedule();
        if (schedule != null) {
            for (CourseOffer offer : schedule.getCourseOfferList()) {
                Object[] row = new Object[3];
                String courseNumber = offer.getCourse().getCourseNumber();
                String courseName = offer.getCourse().getCourseName();
                int enrolledStudents = offer.getSeatAssignments().size();
                
                row[0] = courseNumber;
                row[1] = courseName;
                row[2] = enrolledStudents;
                ((DefaultTableModel) enrollmentTable.getModel()).addRow(row);
              
                enrollmentData.put(courseNumber, enrolledStudents);
            }
        }
        
        
        courseChartPanel.updateData(enrollmentData);
    }

    private void loadRevenueSummary() {
     
        int rc = revenueTable.getRowCount();
        for (int i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) revenueTable.getModel()).removeRow(i);
        }

      
        double totalRevenue = 0;
        int totalStudents = 0;
        
        UserAccountDirectory uad = business.getUserAccountDirectory();
        for (UserAccount ua : uad.getUserAccountList()) {
            if (ua.getRole().equals("Student") && ua.getAssociatedPersonProfile() instanceof StudentProfile) {
                StudentProfile student = (StudentProfile) ua.getAssociatedPersonProfile();
                
                totalRevenue += 5000;
                totalStudents++;
            }
        }
        
        Object[] row = new Object[3];
        row[0] = "Total Students";
        row[1] = totalStudents;
        row[2] = String.format("$%.2f", totalRevenue);
        ((DefaultTableModel) revenueTable.getModel()).addRow(row);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBtn = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        
        // 用户角色统计
        userRoleLabel = new javax.swing.JLabel();
        userRoleScrollPane = new javax.swing.JScrollPane();
        userRoleTable = new javax.swing.JTable();
        
        // 课程统计
        courseLabel = new javax.swing.JLabel();
        courseScrollPane = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        
        // 注册统计
        enrollmentLabel = new javax.swing.JLabel();
        enrollmentScrollPane = new javax.swing.JScrollPane();
        enrollmentTable = new javax.swing.JTable();
        
        // 收入统计
        revenueLabel = new javax.swing.JLabel();
        revenueScrollPane = new javax.swing.JScrollPane();
        revenueTable = new javax.swing.JTable();
        
        // 刷新按钮
        refreshBtn = new javax.swing.JButton();
        
        // 图表面板
        userRoleChartPanel = new ChartPanel(null, "pie", "User Role Distribution");
        courseChartPanel = new ChartPanel(null, "bar", "Course Enrollment");

        setBackground(new java.awt.Color(240, 248, 255));
        setLayout(null);

        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn);
        backBtn.setBounds(30, 20, 80, 30);

        titleLabel.setFont(new java.awt.Font("Arial", 1, 24));
        titleLabel.setText("University Analytics Dashboard");
        add(titleLabel);
        titleLabel.setBounds(150, 20, 400, 30);

        // 用户角色统计
        userRoleLabel.setText("Active Users by Role:");
        add(userRoleLabel);
        userRoleLabel.setBounds(30, 70, 200, 20);

        userRoleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Role", "Count"
            }
        ));
        userRoleScrollPane.setViewportView(userRoleTable);
        add(userRoleScrollPane);
        userRoleScrollPane.setBounds(30, 100, 250, 120);

        // 课程统计
        courseLabel.setText("Courses Offered:");
        add(courseLabel);
        courseLabel.setBounds(320, 70, 200, 20);

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course Number", "Course Name", "Credits"
            }
        ));
        courseScrollPane.setViewportView(courseTable);
        add(courseScrollPane);
        courseScrollPane.setBounds(320, 100, 300, 120);

        // 注册统计
        enrollmentLabel.setText("Student Enrollment per Course:");
        add(enrollmentLabel);
        enrollmentLabel.setBounds(30, 240, 250, 20);

        enrollmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course Number", "Course Name", "Enrolled Students"
            }
        ));
        enrollmentScrollPane.setViewportView(enrollmentTable);
        add(enrollmentScrollPane);
        enrollmentScrollPane.setBounds(30, 270, 300, 120);

        // 收入统计
        revenueLabel.setText("Tuition Revenue Summary:");
        add(revenueLabel);
        revenueLabel.setBounds(360, 240, 200, 20);

        revenueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Category", "Count", "Revenue"
            }
        ));
        revenueScrollPane.setViewportView(revenueTable);
        add(revenueScrollPane);
        revenueScrollPane.setBounds(360, 270, 300, 120);

        // 刷新按钮
        refreshBtn.setText("Refresh Data");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });
        add(refreshBtn);
        refreshBtn.setBounds(500, 20, 120, 30);
        
        // 添加图表面板
        add(userRoleChartPanel);
        userRoleChartPanel.setBounds(30, 420, 300, 200);
        
        add(courseChartPanel);
        courseChartPanel.setBounds(360, 420, 300, 200);

    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_backBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        loadAnalyticsData();
    }//GEN-LAST:event_refreshBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel titleLabel;
    
  
    private javax.swing.JLabel userRoleLabel;
    private javax.swing.JScrollPane userRoleScrollPane;
    private javax.swing.JTable userRoleTable;
    
    
    private javax.swing.JLabel courseLabel;
    private javax.swing.JScrollPane courseScrollPane;
    private javax.swing.JTable courseTable;
    
   
    private javax.swing.JLabel enrollmentLabel;
    private javax.swing.JScrollPane enrollmentScrollPane;
    private javax.swing.JTable enrollmentTable;
   
    private javax.swing.JLabel revenueLabel;
    private javax.swing.JScrollPane revenueScrollPane;
    private javax.swing.JTable revenueTable;
  
    private javax.swing.JButton refreshBtn;
    
    private ChartPanel userRoleChartPanel;
    private ChartPanel courseChartPanel;
    // End of variables declaration//GEN-END:variables

}
