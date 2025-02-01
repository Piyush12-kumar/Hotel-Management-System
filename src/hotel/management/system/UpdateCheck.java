/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener{
    Choice customer;
    JTextField tfroom,tfname,tfcheckIn,tfpaid,tfpending;
    JButton check,update,back;
    UpdateCheck(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,24));
        text.setBounds(90,20,200,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel lbid = new JLabel("Customer Id");
        lbid.setBounds(30,80,100,20);
        add(lbid);
        
        customer = new Choice();
        customer.setBounds(200,80,170,25);
        add(customer);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while(rs.next()){
                customer.add(rs.getString("Mobile_Num"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lbroom = new JLabel("Room Number");
        lbroom.setBounds(30,120,100,20);
        add(lbroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,120,170,25);
        add(tfroom);
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(30,160,100,20);
        add(lbname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,170,25);
        add(tfname);
        
        JLabel lbcheckin = new JLabel("CheckIn Time");
        lbcheckin.setBounds(30,200,100,20);
        add(lbcheckin);
        
        tfcheckIn  = new JTextField();
        tfcheckIn.setBounds(200,200,170,25);
        add(tfcheckIn);
        
        JLabel lbpaid = new JLabel("Amount Paid");
        lbpaid.setBounds(30,240,100,20);
        add(lbpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(200,240,170,25);
        add(tfpaid);
        
        JLabel lbpending = new JLabel("Pending Amount");
        lbpending.setBounds(30,280,100,20);
        add(lbpending);
        
        tfpending = new JTextField();
        tfpending.setBounds(200,280,170,25);
        add(tfpending);
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images\\nine.jpg"));
        JLabel image =new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(300,200,980,500);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id = customer.getSelectedItem();
            String query = "select * from customer where Mobile_Num ='"+id+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("Room"));
                    tfname.setText(rs.getString("Name"));
                    tfcheckIn.setText(rs.getString("CheckInTime"));
                    tfpaid.setText(rs.getString("deposit")); 
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where Room_No ='"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price = rs2.getString("Price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpending.setText("" + amountPaid);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==update){
            String number = customer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            //String checkin = tfcheckIn.getText(); 
            String deposit = tfpaid.getText();
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room ='"+room+"',name ='"+name+"',deposit='"+deposit+"'");              
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new UpdateCheck();
    }
    
}
