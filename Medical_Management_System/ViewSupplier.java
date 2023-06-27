package Medical_Management_System;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class ViewSupplier extends JFrame implements ActionListener{
	
	Connection conn;
	JLabel supNameL = new JLabel("Supplier Name: ");
	
	JTextField supNameF = new JTextField(); 
	JButton view = new JButton("View");

	JTable table = new JTable();
	JScrollPane sp = new JScrollPane();
	
	ViewSupplier( JPanel jp){
		
		jp.setVisible(true);
		jp.setSize(700,490);
		jp.setLayout(null);
		
		supNameL.setBounds(50,80,200,30);
		supNameL.setFont(new Font("Calibri", Font.PLAIN, 25));
		jp.add(supNameL);
		
		supNameF.setBounds(230,80,150,30);
		supNameF.setFont(new Font("Calibri", Font.PLAIN, 20));
		jp.add(supNameF);
		
		view.setBounds(400,80,80,30);
		jp.add(view);
		view.addActionListener(this);
		
		sp.setBounds(20,150,500,250);
		jp.add(sp);
		sp.setViewportView(table);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			conn = MyConnection.getConnection();
			String name = supNameF.getText();
						
			if(e.getSource() == view) {
				
				if( name.equalsIgnoreCase("all")){
					PreparedStatement ps = conn.prepareStatement("select * from medical_supplier");
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				
				else{
					PreparedStatement ps = conn.prepareStatement("select SUPPLIER_ID, COMPANY_NAME, ADDRESS, CONTACT_PERSON, CONTACT_NUMBER from medical_stocks where medical_supplier where COMPANY_NAME = ? ");
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

