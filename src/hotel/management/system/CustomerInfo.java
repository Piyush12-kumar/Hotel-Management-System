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
public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel td1 = new JLabel("Document");
        td1.setBounds(55,10,100,20);
        add(td1);
        
        JLabel td2 = new JLabel("Mobile Number");
        td2.setBounds(210,10,100,20);
        add(td2);
        
        
        JLabel td3 = new JLabel("Name");
        td3.setBounds(400,10,100,20);
        add(td3);
        
        JLabel td4 = new JLabel("Gender");
        td4.setBounds(560,10,100,20);
        add(td4);
        
        JLabel td5 = new JLabel("Country");
        td5.setBounds(730,10,100,20);
        add(td5);
        
        JLabel td6 = new JLabel("Room");
        td6.setBounds(910,10,100,20);
        add(td6);
        
        JLabel td7 = new JLabel("Check In time ");
        td7.setBounds(1050,10,100,20);
        add(td7);
        
        JLabel td8 = new JLabel("deposit");
        td8.setBounds(1235,10,100,20);
        add(td8);
        
        table = new JTable();
        table.setBounds(0,40,1350,450);
        add(table);
        
        DefaultTableModel model = new DefaultTableModel(new String[] {"Document", "Mobile Number", "Name", "Gender", "Country", "Room", "Check In Time", "Deposit"},0);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            
            while(rs.next()){
                String document = rs.getString("document");
                String Mobile_Number = rs.getString("Mobile_Num");
                String Name = rs.getString("Name");
                String Gender = rs.getString("Gender");
                String Country = rs.getString("Country");
                String Room = rs.getString("Room");
                String Check_In_Time = rs.getString("CheckInTime");
                String Deposit = rs.getString("deposit");
                model.addRow(new Object[]{document,Mobile_Number,Name,Gender,Country,Room,Check_In_Time,Deposit});
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
        new CustomerInfo();
    }
}
