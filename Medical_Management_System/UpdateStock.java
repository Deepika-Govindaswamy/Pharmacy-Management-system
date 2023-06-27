package Medical_Management_System;

import java.sql.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class UpdateStock extends JFrame implements ActionListener {

	Connection conn;
	
	JLabel medName = new JLabel("Medicine name ");
	JTextField medNameF = new JTextField();
	
	JLabel medId = new JLabel("Medicine id ");
	JTextField medIdF = new JTextField();
	
	JLabel medQty = new JLabel("Medicine Quantity ");
	JTextField medQtyF = new JTextField();
	
	JButton updateB = new JButton("Update");
	
	UpdateStock(JPanel updateStock){
		
		updateStock.setSize(600,600);
		updateStock.setVisible(true);
		updateStock.setLayout(null);
	
		medName.setBounds(80,90,150,25);
		medName.setFont(new Font("Calibri", Font.PLAIN, 17));
		medNameF.setBounds(240,90,200,25);
		updateStock.add(medName);
		updateStock.add(medNameF);
		
		medId.setBounds(80,130,150,25);
		medId.setFont(new Font("Calibri", Font.PLAIN, 17));
		medIdF.setBounds(240,130,200,25);
		updateStock.add(medId);
		updateStock.add(medIdF);
		
		medQty.setBounds(80,170,150,25);
		medQty.setFont(new Font("Calibri", Font.PLAIN, 17));
		medQtyF.setBounds(240,170,200,25);
		updateStock.add(medQty);
		updateStock.add(medQtyF);
		
		updateB.setBounds(210,260,100,40);
		updateStock.add(updateB);
		updateB.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			if(e.getSource()== updateB) {
				
				String name = medNameF.getText(),
						   id = medIdF.getText();
				int qty = Integer.parseInt(medQtyF.getText());
					
				conn = MyConnection.getConnection();
				
				PreparedStatement ps = conn.prepareStatement("select quantity from medical_stocks where medicine_id = ?");
				ps.setString(1,id);
				ResultSet rs = ps.executeQuery();
				
				int updatedQty = 0, currentQty = 0;
				
				while (rs.next()) {
					currentQty = rs.getInt(1);
				}
				
				updatedQty = currentQty + qty;
					
				ps = conn.prepareStatement("Update medical_stocks set quantity=? where medicine_name = ? and medicine_id = ?");
				ps.setInt(1,updatedQty);
				ps.setString(2,name);
				ps.setString(3,id);
	
				ps.executeUpdate();
			
				JOptionPane.showMessageDialog(null, "Successfully Updated Medicine Quantity");
			}
		}
		
		catch(Exception exe) {
			exe.printStackTrace();
		}
		
	}
}
