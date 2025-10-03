🏨 Hotel Management System
A comprehensive, desktop-based Hotel Management System built with Java Swing and MySQL. This application provides a complete graphical user interface for managing all key hotel operations, from customer check-in and room allocation to employee management and checkout processes.

📋 Project Overview
Welcome to the Hotel Management System – a robust and user-friendly desktop application designed to streamline the complex operations of a modern hotel. Developed entirely in Java using the Swing framework for the GUI, this project demonstrates a practical application of object-oriented programming and database management.

The system is designed with a clear separation of roles, providing distinct functionalities for general reception tasks and administrative duties. From a centralized dashboard, users can navigate through various modules to manage customers, rooms, employees, and more. The intuitive interface ensures that staff can perform their daily tasks efficiently, reducing manual errors and improving overall service quality.

Key highlights of the project include:

Intuitive GUI: A clean and easy-to-navigate graphical user interface built with Java Swing.

Database Integration: All data is persistently stored and managed in a MySQL database.

Modular Design: The application is broken down into logical modules for different hotel operations (Reception, Admin, etc.).

Real-world Functionality: Simulates the core processes of a real hotel, making it a great portfolio piece.

Whether you're a student learning Java, a developer looking for a comprehensive project example, or a hotel looking for a foundational management system, this project offers valuable insights and practical solutions.

✨ Features
👤 Customer Management:

New Customer Check-in: A dedicated form to add new customer details, including ID, name, gender, country, and contact information. [cite: Hotel Management System/src/hotel/management/system/AddCustomer.java]

Room Allocation: Assign available rooms to customers during the check-in process.

Customer Information: View a detailed, searchable table of all current customers, their room number, and check-in time. [cite: Hotel Management System/src/hotel/management/system/CustomerInfo.java]

Update Status: Easily update customer details and pending amounts after they have checked in. [cite: Hotel Management System/src/hotel/management/system/UpdateCheck.java]

🚪 Room Management:

Add Rooms: Add new rooms with details like room number, availability, cleaning status, price, and bed type. [cite: Hotel Management System/src/hotel/management/system/AddRooms.java]

Room Status: View a real-time list of all rooms with their current availability and cleaning status. [cite: Hotel Management System/src/hotel/management/system/Room.java]

Update Room Status: Change the availability and cleaning status of any room as needed. [cite: Hotel Management System/src/hotel/management/system/UpdateRoom.java]

Search Rooms: A powerful search feature to filter rooms by bed type and availability status. [cite: Hotel Management System/src/hotel/management/system/SearchRoom.java]

👥 Staff & Department Management:

Add Employees & Drivers: Forms to add new employees and drivers with their personal details, job role, and contact information. [cite: Hotel Management System/src/hotel/management/system/AddEmployee.java, Hotel Management System/src/hotel/management/system/AddDriver.java]

View Staff Information: Display comprehensive tables with details for all employees, or filter to show only managers. [cite: Hotel Management System/src/hotel/management/system/EmployeeInfo.java, Hotel Management System/src/hotel/management/system/ManagerInfo.java]

Department Budgets: View and manage different hotel departments and their allocated budgets. [cite: Hotel Management System/src/hotel/management/system/Department.java]

✔️ Checkout & Services:

Customer Checkout: A smooth checkout process that updates the customer's record and immediately marks the room as "Available". [cite: Hotel Management System/src/hotel/management/system/Checkout.java]

Pickup Service: Search for available drivers based on the type of car requested by the customer, and view their details. [cite: Hotel Management System/src/hotel/management/system/PickupServices.java]

🛠️ Tech Stack
Frontend: Java Swing (for the graphical user interface)

Backend: Core Java

Database: MySQL

Database Connectivity: JDBC (Java Database Connectivity)

🚀 Getting Started
To get this project up and running on your local machine, follow these steps.

Prerequisites
Java Development Kit (JDK) 8 or higher

An IDE that supports Java Swing projects (e.g., NetBeans, IntelliJ IDEA, Eclipse)

MySQL Server installed and running

Installation
Clone the Repository

git clone [https://github.com/your-username/Hotel-Management-System.git](https://github.com/your-username/Hotel-Management-System.git)

Set Up the Database

Start your MySQL server.

Create a new database with the name hotelmanagementsystem.

Create the required tables: login, employee, customer, room, driver, and department. The table structures can be inferred from the SQL queries within the Java source files.

Configure the Database Connection

Open the Conn.java file located in src/hotel/management/system/.

IMPORTANT: Update the database connection string with your MySQL username and password.

// Inside the Conn() constructor
c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "your-username", "your-password");

Run the Application

Open the project in your IDE.

Locate and run the HotelManagementSystem.java file to start the application.

⚙️ How To Use
Login: Launch the application. You'll be greeted by the login screen. Use the credentials from your login table in the database to log in. [cite: Hotel Management System/src/hotel/management/system/Login.java]

Dashboard: After a successful login, the main dashboard appears, giving you access to the "Hotel Management" and "Admin" sections. [cite: Hotel Management System/src/hotel/management/system/Dashboad.java]

Admin Panel: Use the "Admin" menu to add new employees, rooms, and drivers. This is for managing the hotel's resources.

Reception Desk: Access the "Reception" from the "Hotel Management" menu. This is the main hub for daily operations, including customer check-ins, viewing room status, managing checkouts, and more. [cite: Hotel Management System/src/hotel/management/system/Reception.java]

📝 License
This project is licensed under the MIT License - see the LICENSE file for details.

Built with ❤️ by Piyush Kumar.
