/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.sql.*;
/**
 *
 * @author This PC
 */
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","DB_NAME","DB_PASSWORD");
        s = c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

//Register the Driver Class
//Creating the connection
//Creating a statement 
//Executing my sql queries
