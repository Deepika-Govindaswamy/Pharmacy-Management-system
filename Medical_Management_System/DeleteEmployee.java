
package Medical_Management_System;

import java.sql.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class DeleteEmployee extends JFrame implements ActionListener{
	
	Connection conn;
	
	JLabel empIdL = new JLabel("Employee ID: ");
	JTextField empIdF = new JTextField(); 
	
	JButton delete = new JButton("Delete");
	
	
	DeleteEmployee( JPanel frameDelEmp ) {
		
		frameDelEmp.setVisible(true);
		frameDelEmp.setSize(600,600);
		frameDelEmp.setLayout(null);
		
		empIdL.setBounds(90,100,200,30);
		empIdL.setFont(new Font("Calibri", Font.PLAIN, 18));
		frameDelEmp.add(empIdL);
		
		empIdF.setBounds(250,100,150,30);
		empIdF.setFont(new Font("Calibri", Font.PLAIN, 18));
		frameDelEmp.add(empIdF);
		
		delete.setBounds(190,180,100,40);
		frameDelEmp.add(delete);
		delete.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			conn = MyConnection.getConnection();
			String id = empIdF.getText();
			
			if(e.getSource() == delete) {
				
				if( id.substring(0,3).equals("STR")) {
					PreparedStatement ps = conn.prepareStatement("delete from storestaff where regid=?");
					ps.setString(1, id);
					ps.executeQuery();
					JOptionPane.showMessageDialog(null, "Successfully Deleted Employee");
				}
				
				else if( id.substring(0,3).equals("STK")) {
					PreparedStatement ps = conn.prepareStatement("delete from stockstaff where regid=?");
					ps.setString(1, id);
					ps.executeQuery();
					JOptionPane.showMessageDialog(null, "Successfully Deleted Employee");
				}
				
				else if( id.substring(0,2).equals("HR")) {
					PreparedStatement ps = conn.prepareStatement("delete from managingstaff where regid=?");
					ps.setString(1, id);
					ps.executeQuery();
					JOptionPane.showMessageDialog(null, "Successfully Deleted Employee");
				}
				
				
			}
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
	

}

