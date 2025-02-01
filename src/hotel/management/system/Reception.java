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
public class Reception extends JFrame implements ActionListener{
    JButton newC,rooms,department,allEmployee,Cinfo,Minfo,cout,update,roomstatus,pickup,searchRoom,logout;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newC = new JButton("New Customer Form");
        newC.setBounds(10,30,200,30);
        newC.setBackground(Color.BLACK);
        newC.setForeground(Color.WHITE);
        newC.addActionListener(this);
        add(newC);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
        
        allEmployee = new JButton("All Employee");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        Cinfo = new JButton("Customer Information");
        Cinfo.setBounds(10,190,200,30);
        Cinfo.setBackground(Color.BLACK);
        Cinfo.setForeground(Color.WHITE);
        Cinfo.addActionListener(this);
        add(Cinfo);
        
        Minfo = new JButton("Manager Information");
        Minfo.setBounds(10,230,200,30);
        Minfo.setBackground(Color.BLACK);
        Minfo.setForeground(Color.WHITE);
        Minfo.addActionListener(this);
        add(Minfo);
        
        cout = new JButton("Check Out");
        cout.setBounds(10,270,200,30);
        cout.setBackground(Color.BLACK);
        cout.setForeground(Color.WHITE);
        cout.addActionListener(this);
        add(cout);
        
        update = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        roomstatus = new JButton("Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.WHITE);
        roomstatus.addActionListener(this);
        add(roomstatus);
        
        pickup = new JButton("Pickup Services");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);
        
        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        add(logout);
        ;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images\\fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        setBounds(350,200,800,570);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newC){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()==department){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource()==allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }
        else if(ae.getSource()==Cinfo){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource()==Minfo){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource()==searchRoom){
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource()==roomstatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource()==pickup){
            setVisible(false);
            new PickupServices();
        }
        else if(ae.getSource()==cout){
            setVisible(false);
            new Checkout();
        }
        else if(ae.getSource()==logout){
            System.exit(0);
        }
    }
    public static void main(String[] args){
        new Reception();
    }
}
