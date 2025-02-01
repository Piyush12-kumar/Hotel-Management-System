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
public class AddRooms extends JFrame implements ActionListener{
    JButton add,cancel;
    JTextField tfroom,tfprices;
    JComboBox avaiBox,bedBox,cleanBox;
    AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
        JLabel lblavai = new JLabel("Available");
        lblavai.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblavai.setBounds(60,130,120,30);
        add(lblavai);
        
        String[] avaiOption = {"Available","Occupied"};
        avaiBox = new JComboBox(avaiOption);
        avaiBox.setBounds(200,130,150,30);
        avaiBox.setBackground(Color.WHITE);
        add(avaiBox);
        
        JLabel lblCS = new JLabel("Cleaning Status");
        lblCS.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblCS.setBounds(60,180,120,30);
        add(lblCS);
        
        String[] cleanOption = {"Clean","Dirty"};
        cleanBox = new JComboBox(cleanOption);
        cleanBox.setBounds(200,180,150,30);
        cleanBox.setBackground(Color.WHITE);
        add(cleanBox);
        
        JLabel lblprices = new JLabel("Price");
        lblprices.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblprices.setBounds(60,230,120,30);
        add(lblprices);
        
        tfprices = new JTextField();
        tfprices.setBounds(200,230,150,30);
        add(tfprices);
        
        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);
        
        String[] bedOption = {"Single Bed","Double Bed"};
        bedBox = new JComboBox(bedOption);
        bedBox.setBounds(200,280,150,30);
        bedBox.setBackground(Color.WHITE);
        add(bedBox);
        
        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);    
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images\\twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        setBounds(300,200,940,470);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String roomNum = tfroom.getText();
            String availability = (String)avaiBox.getSelectedItem();
            String status = (String)cleanBox.getSelectedItem();
            String price = tfprices.getText();
            String type = (String)bedBox.getSelectedItem();
            try{
                Conn conn = new Conn();
                String str = "insert into room values('"+roomNum+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room added Successfully");
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
        new AddRooms();
    }
}
