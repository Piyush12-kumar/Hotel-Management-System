package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class PickupServices extends JFrame implements ActionListener {
    JTable table;
    JButton back, submit;
    Choice typeofCar;
    JCheckBox available;
    
    PickupServices() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);
        
        JLabel lbbed = new JLabel("Type Of Car");
        lbbed.setBounds(60, 100, 90, 20);
        add(lbbed);
        
        typeofCar = new Choice();
        typeofCar.setBounds(150, 100, 150, 20);
        typeofCar.setBackground(Color.WHITE);
        add(typeofCar);
        
        try{
            Conn c = new Conn();
            String query = "Select * from driver";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                typeofCar.add(rs.getString("Brand"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(650, 100, 150, 25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel td1 = new JLabel("Driver_Name");
        td1.setBounds(50, 160, 100, 20);
        add(td1);
        
        JLabel td2 = new JLabel("Age");
        td2.setBounds(240, 160, 100, 20);
        add(td2);
        
        JLabel td3 = new JLabel("Gender");
        td3.setBounds(390, 160, 100, 20);
        add(td3);
        
        JLabel td4 = new JLabel("Brand");
        td4.setBounds(560, 160, 100, 20);
        add(td4);
        
        JLabel td5 = new JLabel("Available");
        td5.setBounds(720, 160, 100, 20);
        add(td5);
        
        JLabel td6 = new JLabel("Location");
        td6.setBounds(890, 160, 100, 20);
        add(td6);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        updateTable("select * from driver");
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300, 520, 120, 30);
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500, 520, 120, 30);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 1050, 600);
        setVisible(true);
    }
    
    private void updateTable(String query) {
        DefaultTableModel model = new DefaultTableModel(
            new String[] {"Driver_Name", "Age", "Gender", "Brand", "Available","Location"}, 0
        );
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                model.addRow(new Object[] {
                    rs.getString("Driver_Name"),
                    rs.getString("Age"),
                    rs.getString("Gender"),
                    rs.getString("Brand"),
                    rs.getString("Available"),
                    rs.getString("Location")
                });
            }
            table.setModel(model);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit) {
            try {
                String query;
                if(available.isSelected()) {
                    query = "select * from driver where Available = 'available' AND Brand = '" + typeofCar.getSelectedItem() + "'";
                } else {
                    query = "select * from driver where Brand = '" + typeofCar.getSelectedItem() + "'";
                }
                System.out.println("Executing query: " + query);
                updateTable(query);
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new PickupServices();
    }
}