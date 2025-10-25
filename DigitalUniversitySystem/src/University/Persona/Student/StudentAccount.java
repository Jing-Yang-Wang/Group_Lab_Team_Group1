/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University.Persona.Student;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kal bugrara
 */
    public class StudentAccount {
    //属性：余额和支付记录
    private double balance;
    private ArrayList<PaymentRecord> paymentHistory;
    
    //构造方法：初始化余额为0
    public StudentAccount(){
        this.balance = 0;
        this.paymentHistory = new ArrayList<>();
    }
    
    //方法1: 增加余额
    public void addFunds(double amount){
        this.balance += amount;
        paymentHistory.add(new PaymentRecord(new Date(), amount, "Funds added","Completed"));
    }
    
    //方法2: 支付学费(减少余额)
    public boolean payTuition(double amount){
        if(amount<=0){
            System.out.println("Invalid amount!");
            return false;
        }
        if(amount>balance){
            System.out.println("Not enough balance!");
            return false;
        }
        this.balance -= amount;
        paymentHistory.add(new PaymentRecord(new Date(), -amount, "Tuition payment","Completed"));
        return true;
    }
    
    //获取当前余额
    public double getBalance() {
        return balance;
    }
    
    //获取支付记录
    public ArrayList<PaymentRecord> getPaymentHistory() {
        return paymentHistory;
    }
    
    //打印账户信息
    @Override
    public String toString(){//返回余额及交易记录总数
        return "Balance: $" + "|" + balance + ", Transactions:" + paymentHistory.size();
    }
    
    
}
