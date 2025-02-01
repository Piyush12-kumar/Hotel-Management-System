/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author This PC
 */
public class AddDriver extends JFrame implements ActionListener{
    JButton add,cancel;
    JTextField tfname,tfage,tfloc,tfcar,tfmodel;
    JComboBox avaiBox,genderBox;
    AddDriver(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Driver");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblname.setBounds(60,70,120,30);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblage.setBounds(60,110,120,30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblgender.setBounds(60,150,120,30);
        add(lblgender);
        
        String[] genderOption = {"Male","Female","Other"};
        genderBox = new JComboBox(genderOption);
        genderBox.setBounds(200,150,150,30);
        genderBox.setBackground(Color.WHITE);
        add(genderBox);
        
        JLabel lblcar = new JLabel("Car Company");
        lblcar.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblcar.setBounds(60,190,120,30);
        add(lblcar);
        
        tfcar = new JTextField();
        tfcar.setBounds(200,190,150,30);
        add(tfcar);
        
        JLabel lblmodel = new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblmodel.setBounds(60,230,120,30);
        add(lblmodel);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);
        
        JLabel lblavai = new JLabel("Available");
        lblavai.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblavai.setBounds(60,270,120,30);
        add(lblavai);
        
        String[] avaiOption = {"Available","Busy"};
        avaiBox = new JComboBox(avaiOption);
        avaiBox.setBounds(200,270,150,30);
        avaiBox.setBackground(Color.WHITE);
        add(avaiBox);
        
        JLabel lblloc = new JLabel("Location");
        lblloc.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblloc.setBounds(60,310,120,30);
        add(lblloc);
        
        tfloc = new JTextField();
        tfloc.setBounds(200,310,150,30);
        add(tfloc);
        
        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,370,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);    
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images\\eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        setBounds(300,200,1000,470);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String)genderBox.getSelectedItem();
            String company = tfcar.getText();
            String brand = tfmodel.getText();
            String available = (String)avaiBox.getSelectedItem();
            String location = tfloc.getText();
            try{
                Conn conn = new Conn();
                String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Driver added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String[] args){
        new AddDriver();
    }
}
