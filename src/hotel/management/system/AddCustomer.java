/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
/**
 *
 * @author This PC
 */

public class AddCustomer extends JFrame implements ActionListener{
    JComboBox comboid;
    JTextField tfnum,tfname,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale,rother;
    Choice croom;
    JLabel checkinTime;
    JButton add,back;
    ButtonGroup bg;
    AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        JLabel lbid = new JLabel("ID");
        lbid.setBounds(35,80,100,20);
        lbid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbid);
        
        String[] options = {"Aadhar Card","Passport","Driving License","Voter-id Card","Ration Card"};
        comboid = new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lbnum = new JLabel("Number");
        lbnum.setBounds(35,120,100,20);
        lbnum.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbnum);
        
        tfnum = new JTextField();
        tfnum.setBounds(200,120,150,25);
        add(tfnum);
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(35,160,100,20);
        lbname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel lbgender = new JLabel("Gender");
        lbgender.setBounds(35,200,100,20);
        lbgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbgender);
        
        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,60,25);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,70,25);
        add(rfemale);
        
        rother = new JRadioButton("Other");
        rother.setBackground(Color.WHITE);
        rother.setBounds(345,200,60,25);
        add(rother);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rfemale);
        bg.add(rmale);
        bg.add(rother);
        
        JLabel lbcountry = new JLabel("Country");
        lbcountry.setBounds(35,240,100,23);
        lbcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        JLabel lbroom = new JLabel("Room Number");
        lbroom.setBounds(35,280,150,20);
        lbroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbroom);
        
        croom = new Choice();
        try{
            Conn conn = new Conn();
            String query = "select * from room where Availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("Room_No"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,40);
        add(croom);
        
        JLabel lbtime = new JLabel("Check in time");
        lbtime.setBounds(35,320,150,20);
        lbtime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbtime);
        
        Date date = new Date();
        
        checkinTime = new JLabel("" + date);
        checkinTime.setBounds(200,320,120,25);
        checkinTime.setFont(new Font("Raleway",Font.PLAIN,14));
        add(checkinTime); 
        
        JLabel lbdeposit = new JLabel("Deposit");
        lbdeposit.setBounds(35,355,100,25);
        lbdeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbdeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        
        
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,30);
        add.addActionListener(this);
        add(add); 
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        add(back); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images//fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);

        setBounds(350,200,800,550);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String id = (String)comboid.getSelectedItem();
            String number = tfnum.getText();
            String name = tfname.getText();
            String gen = null;
            
            if(rmale.isSelected())
                gen = "Male";
            if(rfemale.isSelected())
                gen = "Female";
            if(rother.isSelected())
                gen = "Other";
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkinTime.getText();
            String deposit = tfdeposit.getText(); 
            try{
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gen+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set Availability = 'Occupied' where Room_No = '"+room+"'";
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
                setVisible(false); 
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
                setVisible(false); 
                new Reception();
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
}
