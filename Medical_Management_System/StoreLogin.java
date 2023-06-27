package Medical_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreLogin extends JFrame implements ActionListener{
	
	Connection conn;
	JFrame frame = new JFrame("Login");
	
	JLabel title = new JLabel("Billing  Login");
	
	JLabel userIdL = new JLabel("Register Id: ");
	JTextField userIdF = new JTextField();
	
	JLabel userNameL = new JLabel("Name: ");
	JTextField userNameF = new JTextField();
	
	JLabel pwdL = new JLabel("Password: ");
	JPasswordField pwdF = new JPasswordField(); 
	
	JButton login = new JButton("Login");
	JButton back = new JButton("<-");

	StoreLogin() throws ClassNotFoundException, SQLException{
		
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
		
		login.setBounds(250,385,100,40);
		frame.add(login);
		login.addActionListener(this);
		
		back.setFont(new Font("Calibri",Font.BOLD,12));
    	back.setBounds(0,1,45,20);
    	frame.add(back);
    	back.addActionListener(this);
	
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			if(e.getSource()==login) {
				validate();
				BillHandlingOptions bh = new BillHandlingOptions();
			}
			else if(e.getSource() == back) {			
				frame.setVisible(false);
				dispose();
				Welcome w = new Welcome();				}
		} 
		
		catch (Exception exp) {
			exp.printStackTrace();
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
			
			PreparedStatement ps = conn.prepareStatement("select REGID, PASSWORD from storestaff where PASSWORD = ? and REGID = ?");
			ps.setString(1, pwd);
			ps.setString(2, id);
	
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				
				frame.setVisible(false);
				dispose();
				JOptionPane.showMessageDialog(null, "You have successfully logged in");
			}
			
			
			else{
				frame.setVisible(false);
				dispose();
				JOptionPane.showMessageDialog(null, "User does not exist or Wrong username and password");
			}	
		}
		catch(Exception SQLException) {
			System.exit(0);
		}	
		
	}
}