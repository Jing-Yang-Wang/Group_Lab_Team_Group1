/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona.Student;

import University.CourseSchedule.CourseLoad;
import University.CourseSchedule.CourseOffer;
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
//MH 10/24 - Fixed issue with how person was stored

public class StudentProfile extends Profile {
    private String academicStatus;
    private Transcript transcript;
    private EmploymentHistory employmentHistory;
    
    //扩展:学位&专业
    private String major;
    private String degree;
    //扩展:余额/未付学费/已付金额/缴费历史
    private double balance;
    private double outstandingTuition;
    private double paidAmount;
    private ArrayList<PaymentRecord> paymentHistory;
    private StudentAccount account;
    private ArrayList<CourseOffer> registeredCourseOffers = new ArrayList<>();

    //MH 10/24 - Fixed issue with how person was stored
    public Person getPerson() {
        return super.getPerson();
    }

    public String getAcademicStatus() {
        return academicStatus;
    }

    public void setAcademicStatus(String academicStatus) {
        this.academicStatus = academicStatus;
    }

    public EmploymentHistory getEmploymentHistory() {
        return employmentHistory;
    }

    public void setEmploymentHistory(EmploymentHistory employmentHistory) {
        this.employmentHistory = employmentHistory;
    }

    public StudentProfile(Person p) {
        super(p);
        //MH 10/26 - Commenting this out again, StudentProfile extends person
        //person = p;
        /*transcript = new Transcript(this);
        employmenthistory = new EmploymentHistroy();Fixed typo: 'EmploymentHistroy' → 'EmploymentHistory'*/
        this.transcript = new Transcript(this);
        this.employmentHistory = new EmploymentHistory();

    }

    public boolean isMatch(String id) {
        return super.getPerson().getUniversityID().equals(id);
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

    public CourseLoad newCourseLoad(String semester, StudentProfile sp1) {
        return transcript.newCourseLoad(semester);
    }

    public ArrayList<SeatAssignment> getCourseList() {
        return transcript.getCourseList();
    }

    // 扩展功能：学位和专业相关
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

    // 扩展功能：财务相关
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
    
    public void addPaymentRecord(PaymentRecord record) {
        // 如果paymentHistory还没有初始化先创建一个空列表
        if (paymentHistory == null) {
            paymentHistory = new ArrayList<>();
        }
        // 把传入的记录添加进去
        paymentHistory.add(record);
    }

    // 课程注册相关功能
    public ArrayList<CourseOffer> getRegisteredCourseOffers() {
        ArrayList<CourseOffer> offers = new ArrayList<>();
        for (SeatAssignment sa : getCourseList()) {
            offers.add(sa.getCourseOffer());
        }
        return offers;
    }

    public void setRegisteredCourseOffers(ArrayList<CourseOffer> registeredCourseOffers) {
        this.registeredCourseOffers = registeredCourseOffers;
    }

    public void registerCourseOffer(CourseOffer co) {
        if (!registeredCourseOffers.contains(co)) {
            registeredCourseOffers.add(co);
        }
    }
    
    //MH 10/18 - Added so we get the role
    @Override
    public String getRole() {
        return "Student";
    }
}