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
public class Department extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel td1 = new JLabel("Department");
        td1.setBounds(150,10,100,20);
        add(td1);
        
        JLabel td2 = new JLabel("Budget");
        td2.setBounds(480,10,100,20);
        add(td2);
        
        table = new JTable();
        table.setBounds(0,50,700,350);
        add(table);
        
        DefaultTableModel model = new DefaultTableModel(new String[] {"Department", "Budget"},0);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Department");
            
            while(rs.next()){
                String Dep = rs.getString("Department");
                String Bud = rs.getString("Budget");
                
                model.addRow(new Object[]{Dep, Bud});
            }
            
            table.setModel(model);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(280,400,120,30);
        back.addActionListener(this);
        add(back);
        
        
        setBounds(400,200,700,480);
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
        new Department();
    }
}
