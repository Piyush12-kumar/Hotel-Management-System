/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;

/**
 *
 * @author This PC
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class HotelManagementSystem extends JFrame implements ActionListener {
    JLabel text;
    JButton next;
    Image backImage;
    JPanel image;
    HotelManagementSystem(){
        setTitle("HOTEL MANAGEMENT SYSTEM");
        setSize(1366,565);
        setLocationRelativeTo(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images\\first.jpg"));
        backImage = i1.getImage();

        image = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);

                g.drawImage(backImage,0,0,getWidth(),getHeight(),this);
            }
        };
        //image.setBounds(0,0,1366,565);
        image.setLayout(null);

        text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        //text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,50));
        

        next = new JButton("Next");
        //next.setBounds(1150,450,110,43);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.setFont(new Font("serif",Font.PLAIN,24));
        next.addActionListener(this);
        image.add(text);
        image.add(next);

        //adding a listener to update component positions on resizing
        addComponentListener(new java.awt.event.ComponentAdapter(){
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt){
                updateComponentPositions();
            }
        });
        setContentPane(image);
        updateComponentPositions();
        setVisible(true);

        while (true) { 
            text.setVisible(false);
            try {
                Thread.sleep(600);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
             try {
                Thread.sleep(600);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void updateComponentPositions() {
        int width = getWidth();
        int height = getHeight();
        text.setBounds(20,height-135,width-40,90);
        next.setBounds(width - 216, height - 115, 110, 43);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args){
        new HotelManagementSystem();
    }
    /**
     * @param args the command line arguments
     */
    
    
}
