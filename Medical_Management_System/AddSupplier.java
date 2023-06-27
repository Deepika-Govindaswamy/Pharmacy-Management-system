package Medical_Management_System;

import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddSupplier extends JFrame implements ActionListener {

	Connection conn;
 
	JButton addB = new JButton("Add");
	
	JLabel supId = new JLabel("Supplier ID ");
	JTextField supIdF = new JTextField();
	
	JLabel supName = new JLabel("Supplier name ");
	JTextField supNameF = new JTextField();
	
	JLabel supAddr = new JLabel("Address ");
	JTextField supAddrF = new JTextField();
	
	JLabel supPerson = new JLabel("Contact person ");
	JTextField supPersonF = new JTextField();
	
	JLabel supPhone = new JLabel("Contact Number ");
	JTextField supPhoneF = new JTextField();
	
	
	AddSupplier (JPanel addSupplier){
		
		addSupplier.setSize(600,600);
		addSupplier.setVisible(true);
		addSupplier.setLayout(null);
		
		
		supId.setBounds(75,100,150,25);
		supId.setFont(new Font("Calibri", Font.PLAIN, 17));
		supIdF.setBounds(260,100,200,25);
		addSupplier.add(supId);
		addSupplier.add(supIdF);
		
		supName.setBounds(75,140,150,25);
		supName.setFont(new Font("Calibri", Font.PLAIN, 17));
		supNameF.setBounds(260,140,200,25);
		addSupplier.add(supName);
		addSupplier.add(supNameF);
		
		supAddr.setBounds(75,180,150,25);
		supAddr.setFont(new Font("Calibri", Font.PLAIN, 17));
		supAddrF.setBounds(260,180,200,25);
		addSupplier.add(supAddr);
		addSupplier.add(supAddrF);
		
		supPerson.setBounds(75,220,150,25);
		supPerson.setFont(new Font("Calibri", Font.PLAIN, 17));
		supPersonF.setBounds(260,220,200,25);
		addSupplier.add(supPerson);
		addSupplier.add(supPersonF);
		
		supPhone.setBounds(75,260,150,25);
		supPhone.setFont(new Font("Calibri", Font.PLAIN, 17));
		supPhoneF.setBounds(260,260,200,25);
		addSupplier.add(supPhone);
		addSupplier.add(supPhoneF);
		
		addB.setBounds(190,330,100,40);
		addSupplier.add(addB);
		addB.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			if(e.getSource()== addB) {
				
				String name = supNameF.getText(),
					   addr = supAddrF.getText(), 
					   person = supPersonF.getText(),
					   id = supIdF.getText();
				long ph = Long.parseLong(supPhoneF.getText());
					
				conn = MyConnection.getConnection();
				
				PreparedStatement ps = conn.prepareStatement("Insert into medical_supplier values(?,?,?,?,?)");
				ps.setString(1,name);
				ps.setString(2,addr);
				ps.setString(3,person);
				ps.setLong(4,ph);
				ps.setString(5,id);
				
				ps.executeUpdate();
			
				JOptionPane.showMessageDialog(null, "Successfully Added Supplier");
				
				supNameF.setText(" ");
				supAddrF.setText(" "); 
				supPersonF.setText(" ");
				supPhoneF.setText(" ");
				
			}
		}
		
		catch(Exception exe) {
			exe.printStackTrace();
		}
		
	}
}
