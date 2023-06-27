package Medical_Management_System;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ManagerLogin extends JFrame implements ActionListener{
	
	Connection conn;
	JFrame frame = new JFrame("Manager Login");
	
	JLabel title = new JLabel("Billing  Login");
	
	JLabel userIdL = new JLabel("Register Id: ");
	JTextField userIdF = new JTextField();
	
	JLabel userNameL = new JLabel("Name: ");
	JTextField userNameF = new JTextField();
	
	JLabel pwdL = new JLabel("Password: ");
	JPasswordField pwdF = new JPasswordField(); 
	
	JLabel pageToLoginL = new JLabel("Login into: ");
	JRadioButton stk = new JRadioButton("Stock");
	JRadioButton sup = new JRadioButton("Supplies");
	JRadioButton bill = new JRadioButton("Billing");
	JRadioButton emp = new JRadioButton("Employee ");
	
	JButton login = new JButton("Login");
	JButton back = new JButton("<-");
	
	public ManagerLogin() throws ClassNotFoundException, SQLException{
		
		conn = MyConnection.getConnection();

		frame.setSize(650,650);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		title.setBounds(210,50,250,50);
		title.setFont(new Font("Calibri",Font.PLAIN,40));
		frame.add(title);
		
		userIdL.setBounds(140,180,150,20);
		userIdL.setFont(new Font("Calibri",Font.PLAIN,20));
		frame.add(userIdL);
		
		userIdF.setBounds(280,180,190,30);
		frame.add(userIdF);
		
		userNameL.setBounds(140,240,70,20);
		userNameL.setFont(new Font("Calibri",Font.PLAIN,20));
		frame.add(userNameL);
		
		userNameF.setBounds(280,240,190,30);
		frame.add(userNameF);
		
		pwdL.setBounds(140,300,100,20);
		pwdL.setFont(new Font("Calibri",Font.PLAIN,20));
		frame.add(pwdL);
		
		pwdF.setBounds(280,300,190,30);
		frame.add(pwdF);
		
		pageToLoginL.setBounds(140,370,150,20);
		pageToLoginL.setFont(new Font("Calibri",Font.PLAIN,20));
		frame.add(pageToLoginL);
		
		stk.setBounds(280,370,100,20);
		stk.setFont(new Font("Calibri",Font.PLAIN,18));
		frame.add(stk);
		
		sup.setBounds(390,370,100,20);
		sup.setFont(new Font("Calibri",Font.PLAIN,18));
		frame.add(sup);
		
		bill.setBounds(280,410,100,20);
		bill.setFont(new Font("Calibri",Font.PLAIN,18));
		frame.add(bill);
		
		emp.setBounds(390,410,100,20);
		emp.setFont(new Font("Calibri",Font.PLAIN,18));
		frame.add(emp);
		
		login.setBounds(260,490,100,40);
		frame.add(login);
		login.addActionListener(this);
		
		back.setFont(new Font("Calibri",Font.BOLD,12));
    	back.setBounds(0,1,45,20);
    	frame.add(back);
    	back.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==login) {
			validate();
		}
		
		else if(e.getSource() == back) {			
			frame.setVisible(false);
			dispose();
			Welcome w = new Welcome();
		}
	}
	
	
	public void validate(){
		
		try {
			
			String name = userNameF.getText();
			String id = userIdF.getText();
			String pwd = String.valueOf(pwdF.getPassword());
			
			if(name.equals("") || pwd.equals("") || id.equals("")) {
				JOptionPane.showMessageDialog(null, "Fields cannot be empty");
				System.exit(0);
			}
			
			PreparedStatement ps = conn.prepareStatement("select REGID, PASSWORD from managingstaff where PASSWORD = ? and REGID = ?");
			ps.setString(1, pwd);
			ps.setString(2, id);
	
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				
				frame.setVisible(false);
				dispose();
				JOptionPane.showMessageDialog(null, "You have successfully logged in");
				
				if (stk.isSelected()) {
					StockHandlingOptions sh = new StockHandlingOptions();
                }
  
                else if (sup.isSelected()) {
                	SupplierHandlingOptions sh = new SupplierHandlingOptions();
                }
				
                else if (bill.isSelected()) {
					BillHandlingOptions sh = new BillHandlingOptions();
                }
  
                else if (emp.isSelected()) {
                	EmployeeHandlingOptions sh = new EmployeeHandlingOptions();
                }
			}
			
			else{
				JOptionPane.showMessageDialog(null, "User does not exist or Wrong username and password");
				System.exit(0);
			}	
		}
		
		catch(Exception exp) {
			exp.printStackTrace();
		}	
		
	}
}