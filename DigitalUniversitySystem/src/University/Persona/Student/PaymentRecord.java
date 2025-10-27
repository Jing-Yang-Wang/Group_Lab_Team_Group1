/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package University.Persona.Student;

import java.util.Date;

/**
 *
 * @author Eve Dou
 */
    public class PaymentRecord {
    private Date date; 
    private double amount; 
    private String note; 
    private String status;
    
    public PaymentRecord(Date date, double amount, String note,String status){
        //构造方法：用于创建一条付款记录
        this.date = date;
        this.amount = amount;
        this.note = note;
        this.status = status;
    }
    
     //新增简易构造方法（只输入说明和金额）
    public PaymentRecord(String note, double amount){
        this.date = new Date();// 自动填入当前时间
        this.amount = amount;
        this.note = note;
        this.status = status;// 默认状态
    }
    
    //Getter方法（供外部读取信息）

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getNote() {
        return note;
    }

    public String getStatus() {
        return status;
    }
    
    
    //toString()：让记录打印时更好看
    @Override
    public String toString(){
        return date + "|" + note +"|$"+amount;
    }
}
