package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back, submit;
    JComboBox bedType;
    JCheckBox available;
    
    SearchRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Search Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);
        
        JLabel lbbed = new JLabel("Bed Type");
        lbbed.setBounds(60, 100, 150, 20);
        add(lbbed);
        
        bedType = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedType.setBounds(150, 100, 150, 20);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(650, 100, 150, 25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel td1 = new JLabel("Room No.");
        td1.setBounds(50, 160, 100, 20);
        add(td1);
        
        JLabel td2 = new JLabel("Availability");
        td2.setBounds(270, 160, 100, 20);
        add(td2);
        
        JLabel td3 = new JLabel("Room Status");
        td3.setBounds(450, 160, 100, 20);
        add(td3);
        
        JLabel td4 = new JLabel("Price");
        td4.setBounds(670, 160, 100, 20);
        add(td4);
        
        JLabel td5 = new JLabel("Room Type");
        td5.setBounds(870, 160, 100, 20);
        add(td5);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        updateTable("select * from room");
        
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
            new String[] {"Room No.", "Availability", "Room Status", "Price", "Room Type"}, 0
        );
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                model.addRow(new Object[] {
                    rs.getString("Room_No"),
                    rs.getString("Availability"),
                    rs.getString("Room_Status"),
                    rs.getString("Price"),
                    rs.getString("Room_Type")
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
                    query = "select * from room where availability = 'Available' AND Room_Type = '" + bedType.getSelectedItem() + "'";
                } else {
                    query = "select * from room where Room_Type = '" + bedType.getSelectedItem() + "'";
                }
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
        new SearchRoom();
    }
}