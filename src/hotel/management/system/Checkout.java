/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.*;
import java.awt.event.*;
/**
 *
 * @author This PC
 */
public class Checkout extends JFrame implements ActionListener{
    Choice customer;
    JLabel lblroomNum,lblroomNums,lblcheckIntime,lblcheckIn,lblcheckOuttime,lblcheckOut;
    JButton CheckOut,Back;
    Checkout(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Checkout");
        text.setFont(new Font("Tahoma",Font.PLAIN,24));
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel lbid = new JLabel("Customer Id");
        lbid.setBounds(30,80,100,30);
        add(lbid);
        
        customer = new Choice();
        customer.setBounds(150,84,150,25);
        add(customer);      
  
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images\\tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310,84,20,20);
        add(tick);
        
        lblroomNum = new JLabel("Room Number");
        lblroomNum.setBounds(30,130,100,30);
        add(lblroomNum);
        
        lblroomNums = new JLabel();
        lblroomNums.setBounds(150,130,100,30);
        add(lblroomNums);
        
        lblcheckIntime = new JLabel("CheckIn Time ");
        lblcheckIntime.setBounds(30,180,100,30);
        add(lblcheckIntime);
        
        lblcheckIn = new JLabel();
        lblcheckIn.setBounds(150,180,180,30);
        add(lblcheckIn);
        
        lblcheckOut = new JLabel("CheckOut Time");
        lblcheckOut.setBounds(30,230,100,30);
        add(lblcheckOut);
        
        Date date = new Date();
        lblcheckOuttime = new JLabel(""+date);
        lblcheckOuttime.setBounds(150,230,180,30);
        add(lblcheckOuttime);
        
        CheckOut = new JButton("CheckOut");
        CheckOut.setBackground(Color.BLACK);
        CheckOut.setForeground(Color.WHITE);
        CheckOut.setBounds(30,280,120,30);
        CheckOut.addActionListener(this);
        add(CheckOut);
        
        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(170,280,120,30);
        Back.addActionListener(this);
        add(Back);
        
        try{
            Conn c = new Conn();
            String query = "Select * from customer";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                customer.add(rs.getString("Mobile_Num"));
                lblroomNums.setText(rs.getString("Room"));
                lblcheckIn.setText(rs.getString("CheckInTime"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Images\\sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);
        
        setBounds(300,200,800,400);
        setVisible(true);
    }
    
    @Override 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==CheckOut){
            String query = "delete from customer where Mobile_Num = '"+customer.getSelectedItem()+"'";
            String quer1 = "update room set Availability = 'Available' where Room_No = '"+lblroomNums.getText()+"'";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                c.s.executeUpdate(quer1);
                
                JOptionPane.showMessageDialog(null,"CheckOut Done");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new Checkout();
    }
}
