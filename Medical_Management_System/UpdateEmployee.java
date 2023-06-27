
package Medical_Management_System;

import java.sql.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class UpdateEmployee extends JFrame implements ActionListener{
	
	Connection conn;
	
	JLabel empIdL = new JLabel("Employee ID: ");
	JTextField empIdF = new JTextField(); 
	
	JLabel empupdateL = new JLabel("Update Item: ");
	String column[]={"USERNAME","PASSWORD","MAIL","PHONE_NUMBER"};        
 
	JComboBox cb = new JComboBox(column);    
	
	JLabel val = new JLabel("Value: ");
	JTextField valf = new JTextField();
	JLabel ph = new JLabel("Phone No: ");
	JTextField phf = new JTextField();
	
	JButton update = new JButton("Upadte");
	
	JPanel pan = null;
	
	
	UpdateEmployee( JPanel frameUpdateEmp ) {
		
		frameUpdateEmp.setVisible(true);
		frameUpdateEmp.setSize(600,600);
		frameUpdateEmp.setLayout(null);
		
		empIdL.setBounds(90,90,200,30);
		empIdL.setFont(new Font("Calibri", Font.PLAIN, 17));
		frameUpdateEmp.add(empIdL);
		
		empIdF.setBounds(250,90,150,30);
		empIdL.setFont(new Font("Calibri", Font.PLAIN, 17));
		frameUpdateEmp.add(empIdF);
		
		empupdateL.setBounds(90,150,150,25);
		empupdateL.setFont(new Font("Calibri", Font.PLAIN, 17));
		frameUpdateEmp.add(empupdateL);
		
		cb.setBounds(250,150,150,25);
		frameUpdateEmp.add(cb);
		
		val.setBounds(90,210,100,25);
		valf.setBounds(250,210,150,30);
		val.setFont(new Font("Calibri", Font.PLAIN, 17));
		frameUpdateEmp.add(val);
		frameUpdateEmp.add(valf);
		
		update.setBounds(180,300,100,40);
		frameUpdateEmp.add(update);
		update.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			conn = MyConnection.getConnection();
			String id = empIdF.getText();
			
			if(e.getSource() == update) {
				
				String col = (String)cb.getSelectedItem();
				String value = valf.getText();
				
				if( id.substring(0,3).equals("STR")) {
				
					if( col.equals("USERNAME")) {
						PreparedStatement ps = conn.prepareStatement("Update storestaff set username = ? where regid = ?");
						ps.setString(1,value);
						ps.setString(2,id);
						ps.executeUpdate();
					}
					
					if( col.equals("PASSWORD")) {
						PreparedStatement ps = conn.prepareStatement("Update storestaff set password = ? where regid = ?");
						ps.setString(1,value);
						ps.setString(2,id);
						ps.executeUpdate();
					}
					
					if( col.equals("MAIL")) {
						PreparedStatement ps = conn.prepareStatement("Update storestaff set mail = ? where regid = ?");
						ps.setString(1,value);
						ps.setString(2,id);
						ps.executeUpdate();
					}
					
					if( col.equals("PHONE_NUMBER")) {
						PreparedStatement ps = conn.prepareStatement("Update storestaff set phone_number = ? where regid = ?");
						ps.setString(1,value);
						ps.setString(2,id);
						ps.executeUpdate();
					}
					
					
					JOptionPane.showMessageDialog(null, "Successfully Updated Store Employee details");
				}
				
				else if( id.substring(0,3).equals("STK") ) {
					
					if( col.equals("USERNAME")) {
						PreparedStatement ps = conn.prepareStatement("Update stockstaff set username = ? where regid = ?");
						ps.setString(1,value);
						ps.setString(2,id);
						ps.executeUpdate();
					}
					
					if( col.equals("PASSWORD")) {
						PreparedStatement ps = conn.prepareStatement("Update stockstaff set password = ? where regid = ?");
						ps.setString(1,value);
						ps.setString(2,id);
						ps.executeUpdate();
					}
					
					if( col.equals("MAIL")) {
						PreparedStatement ps = conn.prepareStatement("Update stockstaff set mail = ? where regid = ?");
						ps.setString(1,value);
						ps.setString(2,id);
						ps.executeUpdate();
					}
					
					if( col.equals("PHONE_NUMBER")) {
						PreparedStatement ps = conn.prepareStatement("Update stockstaff set phone_number = ? where regid = ?");
						ps.setString(1,value);
						ps.setString(2,id);
						ps.executeUpdate();
					}
					
	
					JOptionPane.showMessageDialog(null, "Successfully Updated Stock Employee details");
				}
				
				
				else if( id.substring(0,2).equals("HR") ) {
					
					if( col.equals("USERNAME")) {
						PreparedStatement ps = conn.prepareStatement("Update managingstaff set username = ? where regid = ?");
						ps.setString(1,value);
						ps.setString(2,id);
						ps.executeUpdate();
					}
					
					if( col.equals("PASSWORD")) {
						PreparedStatement ps = conn.prepareStatement("Update managingstaff set password = ? where regid = ?");
						ps.setString(1,value);
						ps.setString(2,id);
						ps.executeUpdate();
					}
					
					if( col.equals("MAIL")) {
						PreparedStatement ps = conn.prepareStatement("Update managingstaff set mail = ? where regid = ?");
						ps.setString(1,value);
						ps.setString(2,id);
						ps.executeUpdate();
					}
					
					if( col.equals("PHONE_NUMBER")) {
						PreparedStatement ps = conn.prepareStatement("Update managingstaff set phone_number = ? where regid = ?");
						ps.setString(1,value);
						ps.setString(2,id);
						ps.executeUpdate();
					}
	
					JOptionPane.showMessageDialog(null, "Successfully Updated Mananging Employee details");
				}		
				
			}
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
	

}

