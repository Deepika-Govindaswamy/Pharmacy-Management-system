package Medical_Management_System;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class ViewEmployee extends JFrame implements ActionListener{

	Connection conn;
	JLabel empDeptL = new JLabel("Employee Department: ");
	String[] dept = {"HR", "Store", "Stock"};
	JComboBox empDeptF = new JComboBox(dept); 
	
	JLabel empIdL = new JLabel("Employee Id: ");
	JTextField empIdF = new JTextField(); 
	
	JButton view = new JButton("View");

	JTable table = new JTable();
	JScrollPane sp = new JScrollPane();
	
	ViewEmployee( JPanel jp){
		
		empDeptL.setBounds(25,75,200,30);
		empDeptL.setFont(new Font("Calibri", Font.PLAIN, 18));
		jp.add(empDeptL);
		
		empDeptF.setBounds(230,75,150,30);
		jp.add(empDeptF);
		
		empIdL.setBounds(25,130,200,30);
		empIdL.setFont(new Font("Calibri", Font.PLAIN, 18));
		jp.add(empIdL);
		
		empIdF.setBounds(230,130,150,30);
		jp.add(empIdF);
		
		view.setBounds(420,100,80,30);
		jp.add(view);
		view.addActionListener(this);
		
		jp.setVisible(true);
		jp.setSize(700,490);
		jp.setLayout(null);
		
		sp.setBounds(20,180,490,250);
		
		jp.add(sp);
		sp.setViewportView(table);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			conn = MyConnection.getConnection();
			String name = (String)empDeptF.getSelectedItem(),
			id = empIdF.getText();
						
			if(e.getSource() == view) {
				
				if( name.equalsIgnoreCase("hr")){
					
					if( id.equalsIgnoreCase("all")) {
						PreparedStatement ps = conn.prepareStatement("select * from managingstaff");
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					
					else {
						PreparedStatement ps = conn.prepareStatement("select regid, username, password, mail, designation, phone_number from managingstaff where regid = ?");
						ps.setString(1, id);
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
				}
				
				if( name.equalsIgnoreCase("stock")){
					
					if( id.equalsIgnoreCase("all")) {
						PreparedStatement ps = conn.prepareStatement("select * from stockstaff");
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					
					else {
						PreparedStatement ps = conn.prepareStatement("select regid, username, password, mail, designation, phone_number from stockstaff where regid = ?");
						ps.setString(1, id);
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
				}

				if( name.equalsIgnoreCase("store")){
	
					if( id.equalsIgnoreCase("all")) {
						PreparedStatement ps = conn.prepareStatement("select * from storestaff");
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
	
					else {
						PreparedStatement ps = conn.prepareStatement("select regid, username, password, mail, designation, phone_number from storestaff where regid = ?");
						ps.setString(1, id);
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
				}
			}
		}
		
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
}
