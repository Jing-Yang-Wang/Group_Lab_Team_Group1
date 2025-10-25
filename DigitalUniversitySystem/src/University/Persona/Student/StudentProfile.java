/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona.Student;

import University.CourseSchedule.CourseLoad;
import University.CourseSchedule.SeatAssignment;
import University.Persona.Student.EmploymentHistory.EmploymentHistory;
import University.Persona.Profile;
import University.Persona.Person;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */

//MH 10/18 - Updated so it extend the profile.
public class StudentProfile extends Profile {
    private Person person;
    private Transcript transcript;
    private EmploymentHistory employmentHistory;
    //扩展:学位&专业
    private String major;
    private String degree;
    //扩展:余额/未付学费/已付金额/缴费历史
    private double balance;
    private double outstandingTuition;
    private double paidAmount;
    private ArrayList<PaymentRecord>paymentHistory;
    private StudentAccount account;

    public StudentProfile(Person p) {
        super(p);
        //person = p;
        this.transcript = new Transcript(this);
        this.employmentHistory = new EmploymentHistory();
    }

    
    public boolean isMatch(String id) {
        return getPerson()!= null && person.getPersonId().equals(id);
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String semester) {

        return transcript.newCourseLoad(semester);
    }

    public ArrayList<SeatAssignment> getCourseList() {

        return transcript.getCourseList();

    }

    public String getMajor() {
        return major;
    }

    public String getDegree() {
        return degree;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public double getBalance() {
        return balance;
    }

    public double getOutstandingTuition() {
        return outstandingTuition;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public ArrayList<PaymentRecord> getPaymentHistory() {
        return paymentHistory;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOutstandingTuition(double outstandingTuition) {
        this.outstandingTuition = outstandingTuition;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }
    
    public void addPaymentRecord(PaymentRecord record){
    //如果paymentHistory还没有初始化先创建一个空列表
    if(paymentHistory == null){
        paymentHistory = new ArrayList<>();
    }
    //把传入的记录添加进去
    paymentHistory.add(record);
    }
    //MH 10/18 - Added so we get the role
    
    
    @Override
    public String getRole() {
        return "Student";
    }
}
