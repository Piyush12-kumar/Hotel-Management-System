/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author This PC
 */
public class EmployeeInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    EmployeeInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel td1 = new JLabel("Name");
        td1.setBounds(65,10,100,20);
        add(td1);
        
        JLabel td2 = new JLabel("Age");
        td2.setBounds(250,10,100,20);
        add(td2);
        
        
        JLabel td3 = new JLabel("Gender");
        td3.setBounds(400,10,100,20);
        add(td3);
        
        JLabel td4 = new JLabel("Job");
        td4.setBounds(580,10,100,20);
        add(td4);
        
        JLabel td5 = new JLabel("Salary");
        td5.setBounds(750,10,100,20);
        add(td5);
        
        JLabel td6 = new JLabel("Phone");
        td6.setBounds(910,10,100,20);
        add(td6);
        
        JLabel td7 = new JLabel("Email");
        td7.setBounds(1070,10,100,20);
        add(td7);
        
        JLabel td8 = new JLabel("Aadhar");
        td8.setBounds(1225,10,100,20);
        add(td8);
        
        table = new JTable();
        table.setBounds(0,40,1350,450);
        add(table);
        
        DefaultTableModel model = new DefaultTableModel(new String[] {"Name", "Age", "Gender", "Job", "Salary", "Phone", "Email", "Aadhar"},0);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            
            while(rs.next()){
                String name = rs.getString("Name");
                String age = rs.getString("Age");
                String gen = rs.getString("Gender");
                String job = rs.getString("Job");
                String sal = rs.getString("Salary");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                String aadhar = rs.getString("Aadhar");
                model.addRow(new Object[]{name,age,gen,job,sal,phone,email,aadhar});
            }
            
            table.setModel(model);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(625,500,120,30);
        back.addActionListener(this);
        add(back);
        
        
        setBounds(100,150,1350,600);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new EmployeeInfo();
    }
}
