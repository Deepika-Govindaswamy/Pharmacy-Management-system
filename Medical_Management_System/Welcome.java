package Medical_Management_System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Welcome extends JFrame implements ActionListener{
	
	JFrame frameW = new JFrame("Welcome!!!!");
	JLabel options = new JLabel("Login into ");
	JRadioButton stk = new JRadioButton("Stocks");
	JRadioButton hr = new JRadioButton("Management");
	JRadioButton bill = new JRadioButton("Billing");
	ButtonGroup bg = new ButtonGroup();
	
	JButton log = new JButton("Go");
	
	JLabel background = null;
	ImageIcon img = new ImageIcon("C:\\Users\\Shriharideepika\\OneDrive\\Desktop\\Anime\\Anime pics\\PharmacyImg.jpg");
	
	Welcome(){
		
		frameW.setVisible(true);
		frameW.setLayout(null);
		frameW.setSize(650,650);
		frameW.setLocationRelativeTo(null);
		
		background = new JLabel("",img,JLabel.CENTER);
		background.setBounds(20,20,600,470);
		frameW.add(background);
		
//		JLabel msg = new JLabel("Welcome to Online Pharamcy");
//		msg.setBounds(130, 100, 410, 100);
//		msg.setFont(new Font("Calibri", Font.PLAIN, 30));
//		frameW.add(msg);
		
		options.setBounds(90,500,150,33);
		options.setFont(new Font("Calibri", Font.BOLD, 20));
		frameW.add(options);
		
		stk.setBounds(205,500,100,30);
		stk.setFont(new Font("Calibri", Font.PLAIN, 20));
		frameW.add(stk);
		bg.add(stk);
		
		bill.setBounds(310,500,100,30);
		bill.setFont(new Font("Calibri", Font.PLAIN, 20));
		frameW.add(bill);
		bg.add(bill);
		
		hr.setBounds(410,500,150,30);
		hr.setFont(new Font("Calibri", Font.PLAIN, 20));
		frameW.add(hr);
		bg.add(hr);
		
		log.setBounds(250,550,100,40);
		log.setFont(new Font("Calibri", Font.PLAIN, 20));
		log.addActionListener(this);
		frameW.add(log);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			if( e.getSource() == log) {
				
				if( stk.isSelected()) {
					dispose();
					frameW.setVisible(false);
					StockLogin s = new StockLogin();
				}
				
				else if( bill.isSelected()) {
					dispose();
					frameW.setVisible(false);
					StoreLogin s = new StoreLogin();
				}
				
				else if( hr.isSelected()) {
					dispose();
					frameW.setVisible(false);
					ManagerLogin s = new ManagerLogin();
				}
			}
		}
		
		catch( Exception exp) {
			exp.printStackTrace();
		}
	}
	
	public static void main( String[] args) {
		Welcome w = new Welcome();		      
	}

}
