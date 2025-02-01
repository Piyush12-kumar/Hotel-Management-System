/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author This PC
 */
public class Dashboad extends JFrame implements ActionListener{
    Dashboad(){
        setBounds(0,0,1920,1080);
        setLayout(null);
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Images\\third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1980,1080,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(0,0,1980,1080);
        add(image);

        JLabel text  = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,46));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1920,30);
        image.add(mb);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.RED);
        mb.add(admin);

        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);

        JMenuItem addroom = new JMenuItem("ADD ROOM");
        addroom.addActionListener(this);
        admin.add(addroom);

        JMenuItem addDriver = new JMenuItem("ADD DRIVER");
        addDriver.addActionListener(this);
        admin.add(addDriver);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE"))
            new AddEmployee();
        else if(ae.getActionCommand().equals("ADD ROOM"))
            new AddRooms();
        else if(ae.getActionCommand().equals("ADD DRIVER"))
            new AddDriver();
        else if(ae.getActionCommand().equals("RECEPTION"))
            new Reception();
    }
    public static void main(String[] args) {
        new Dashboad();
    }
}
