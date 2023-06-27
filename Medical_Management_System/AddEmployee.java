
package Medical_Management_System;

import java.sql.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

	Connection conn;
 
	JButton addB = new JButton("Add");

	JLabel empId = new JLabel("Employee id ");
	JTextField empIdF = new JTextField();
	
	JLabel empName = new JLabel("Employee name ");
	JTextField empNameF = new JTextField();
	
	JLabel empPwd = new JLabel("Password ");
	JPasswordField empPwdF = new JPasswordField();
	
	JLabel empMail = new JLabel("Mail ");
	JTextField empMailF = new JTextField();
	
	JLabel empDes = new JLabel("Designation ");
	JTextField empDesF = new JTextField();
	
	JLabel empPh = new JLabel("Phone Number ");
	JTextField empPhF = new JTextField();
	
	JPanel panel = new JPanel();
	Container c = getContentPane();
	
	
	AddEmployee(JPanel addEmployee){
		
		addEmployee.setSize(600,600);
		addEmployee.setVisible(true);
		addEmployee.setLayout(null);
		
		empId.setBounds(80,90,150,25);
		empId.setFont(new Font("Calibri", Font.PLAIN, 17));
		empIdF.setBounds(240,90,200,25);
		addEmployee.add(empId);
		addEmployee.add(empIdF);
		
		empName.setBounds(80,130,150,25);
		empName.setFont(new Font("Calibri", Font.PLAIN, 17));
		empNameF.setBounds(240,130,200,25);
		addEmployee.add(empName);
		addEmployee.add(empNameF);
		
		empPwd.setBounds(80,170,150,25);
		empPwd.setFont(new Font("Calibri", Font.PLAIN, 17));
		empPwdF.setBounds(240,170,200,25);
		addEmployee.add(empPwd);
		addEmployee.add(empPwdF);
		
		empMail.setBounds(80,210,150,25);
		empMail.setFont(new Font("Calibri", Font.PLAIN, 17));
		empMailF.setBounds(240,210,200,25);
		addEmployee.add(empMail);
		addEmployee.add(empMailF);
		
		empDes.setBounds(80,250,150,25);
		empDes.setFont(new Font("Calibri", Font.PLAIN, 17));
		empDesF.setBounds(240,250,200,25);
		addEmployee.add(empDes);
		addEmployee.add(empDesF);
		
		empPh.setBounds(80,290,150,25);
		empPh.setFont(new Font("Calibri", Font.PLAIN, 17));
		empPhF.setBounds(240,290,200,25);
		addEmployee.add(empPh);
		addEmployee.add(empPhF);
		
		addB.setBounds(200,360,100,40);
		addEmployee.add(addB);
		addB.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			if(e.getSource()== addB) {
				
				String name = empNameF.getText(),
						   id = empIdF.getText(), 
						   pwd = new String(empPwdF.getPassword()),
						   mail = empMailF.getText(),
						   des = empDesF.getText(),
						   ph = empPhF.getText();
			
				conn = MyConnection.getConnection();
				
				if( id.substring(0,3).equals("STR")) {
					
					PreparedStatement ps = conn.prepareStatement("Insert into storestaff values(?,?,?,?,?,?)");
					ps.setString(1,id);
					ps.setString(2,name);
					ps.setString(3,pwd);
					ps.setString(4,mail);
					ps.setString(5,des);
					ps.setString(6,ph);
					ps.executeUpdate();
				
					JOptionPane.showMessageDialog(null, "Successfully Added Stock");
					
				}
				
				else if( id.substring(0,3).equals("STK") ) {
					
					PreparedStatement ps = conn.prepareStatement("Insert into stockstaff values(?,?,?,?,?,?)");
					ps.setString(1,id);
					ps.setString(2,name);
					ps.setString(3,pwd);
					ps.setString(4,mail);
					ps.setString(5,des);
					ps.setString(6,ph);
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Successfully Added Stock");
					
//					System.out.println("hello");
				}
				
				else if( id.substring(0,2).equals("HR") ) {
					
					System.out.println( id + " " + name + " " + pwd + " " + mail + " " + des + " " + ph);
					
					PreparedStatement ps = conn.prepareStatement("Insert into managingstaff values(?,?,?,?,?,?)");
					ps.setString(1,id);
					ps.setString(2,name);
					ps.setString(3,pwd);
					ps.setString(4,mail);
					ps.setString(5,des);
					ps.setString(6,ph);
					
					ps.executeUpdate();
				
					System.out.println("hello");
					JOptionPane.showMessageDialog(null, "Successfully Added Stock");
					System.out.println("hello");
				}
					
				
			}
		}
		
		catch(Exception exe) {
			exe.printStackTrace();
		}
		
	}
}
