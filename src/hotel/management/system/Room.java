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
public class Room extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Room(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images\\eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image .setBounds(500,0,600,600);
        add(image);
        
        JLabel td1 = new JLabel("Room Number");
        td1.setBounds(10,10,100,20);
        add(td1);
        
        JLabel td2 = new JLabel("Availability");
        td2.setBounds(120,10,100,20);
        add(td2);
        
        JLabel td3 = new JLabel("Status");
        td3.setBounds(230,10,100,20);
        add(td3);
        
        JLabel td4 = new JLabel("Price");
        td4.setBounds(330,10,100,20);
        add(td4);
        
        JLabel td5 = new JLabel("Type");
        td5.setBounds(410,10,100,20);
        add(td5);
        
        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        DefaultTableModel model = new DefaultTableModel(new String[] {"Room Number", "Availability", "Status", "Price", "Type"},0);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            
            while(rs.next()){
                String roomNumber = rs.getString("Room_No");
                String availability = rs.getString("Availability");
                String status = rs.getString("Room_status");
                String price = rs.getString("Price");
                String type = rs.getString("Room_Type");
                
                model.addRow(new Object[]{roomNumber, availability, status, price, type});
            }
            
            table.setModel(model);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        back.addActionListener(this);
        add(back);
        
        
        setBounds(300,200,1050,600);
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
        new Room();
    }
}
