package Medical_Management_System;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class ViewStock extends JFrame implements ActionListener{

	Connection conn;
	JLabel medNameL = new JLabel("Medicine Name: ");
	
	JTextField medNameF = new JTextField(); 
	JButton view = new JButton("View");

	JTable table = new JTable();
	JScrollPane sp = new JScrollPane();
	
	ViewStock( JPanel jp){
		
		medNameL.setBounds(25,75,200,30);
		medNameL.setFont(new Font("Calibri", Font.PLAIN, 25));
		jp.add(medNameL);
		
		medNameF.setBounds(210,75,150,30);
		medNameF.setFont(new Font("Calibri", Font.PLAIN, 20));
		jp.add(medNameF);
		
		view.setBounds(390,75,80,30);
		jp.add(view);
		view.addActionListener(this);
		
		jp.setVisible(true);
		jp.setSize(700,490);
		jp.setLayout(null);
		
		sp.setBounds(0,150,500,250);
		
		jp.add(sp);
		sp.setViewportView(table);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			conn = MyConnection.getConnection();
			String name = medNameF.getText();
						
			if(e.getSource() == view) {
				
				if( name.equalsIgnoreCase("all")){
					PreparedStatement ps = conn.prepareStatement("select * from medical_stocks");
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				
				else{
					PreparedStatement ps = conn.prepareStatement("select MEDICINE_NAME, MEDICINE_ID, COST, QUANTITY, MANUFACTURER, EXPIRY_DATE, MEDICINE_TYPE from medical_stocks where MEDICINE_NAME = ? ");
					ps.setString(1,name);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				}
			}
		}
		
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
}
