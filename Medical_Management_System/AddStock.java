package Medical_Management_System;

import java.sql.*;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;

public class AddStock extends JFrame implements ActionListener {

	Connection conn;
 
	JButton addB = new JButton("Add");
	
	JLabel medName = new JLabel("Medicine name ");
	JTextField medNameF = new JTextField();
	
	JLabel medId = new JLabel("Medicine id ");
	JTextField medIdF = new JTextField();
	
	JLabel medCost = new JLabel("Medicine Cost ");
	JTextField medCostF = new JTextField();
	
	JLabel medQty = new JLabel("Quantity ");
	JTextField medQtyF = new JTextField();
	
	JLabel medMake = new JLabel("Manufacturer ");
	JTextField medMakeF = new JTextField();
	
	JLabel medExp = new JLabel("Expiry date ");
	JTextField medExpF = new JTextField();
	
	JLabel medType = new JLabel("Medicine Type ");
	JTextField medTypeF = new JTextField();
	
	
	AddStock (JPanel addStocks){
		
		addStocks.setSize(600,600);
		addStocks.setVisible(true);
		addStocks.setLayout(null);
		
		medName.setBounds(80,70,150,25);
		medName.setFont(new Font("Calibri", Font.PLAIN, 17));
		medNameF.setBounds(240,70,200,25);
		addStocks.add(medName);
		addStocks.add(medNameF);
		
		medId.setBounds(80,110,150,25);
		medId.setFont(new Font("Calibri", Font.PLAIN, 17));
		medIdF.setBounds(240,110,200,25);
		addStocks.add(medId);
		addStocks.add(medIdF);
		
		medCost.setBounds(80,150,150,25);
		medCost.setFont(new Font("Calibri", Font.PLAIN, 17));
		medCostF.setBounds(240,150,200,25);
		addStocks.add(medCost);
		addStocks.add(medCostF);
		
		medQty.setBounds(80,190,150,25);
		medQty.setFont(new Font("Calibri", Font.PLAIN, 17));
		medQtyF.setBounds(240,190,200,25);
		addStocks.add(medQty);
		addStocks.add(medQtyF);
		
		medMake.setBounds(80,230,150,25);
		medMake.setFont(new Font("Calibri", Font.PLAIN, 17));
		medMakeF.setBounds(240,230,200,25);
		addStocks.add(medMake);
		addStocks.add(medMakeF);
		
		medExp.setBounds(80,270,150,25);
		medExp.setFont(new Font("Calibri", Font.PLAIN, 17));
		medExpF.setBounds(240,270,200,25);
		addStocks.add(medExp);
		addStocks.add(medExpF);
		
		medType.setBounds(80,310,150,25);
		medType.setFont(new Font("Calibri", Font.PLAIN, 17));
		medTypeF.setBounds(240,310,200,25);
		addStocks.add(medType);
		addStocks.add(medTypeF);
		
		addB.setBounds(210,370,100,40);
		addStocks.add(addB);
		addB.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			if(e.getSource()== addB) {
				
				String name = medNameF.getText(),
						   id = medIdF.getText(), 
						   make = medMakeF.getText(),
						   exp = medExpF.getText(),
						   type = medTypeF.getText();
				int cost = Integer.parseInt(medCostF.getText()),
						qty = Integer.parseInt(medQtyF.getText());
					
				conn = MyConnection.getConnection();
					
				PreparedStatement ps = conn.prepareStatement("Insert into medical_stocks values(?,?,?,?,?,?,?)");
				ps.setString(1,name);
				ps.setString(2,id);
				ps.setInt(3,cost);
				ps.setInt(4,qty);
				ps.setString(5,make);
				ps.setString(6,exp);
				ps.setString(7,type);
				ps.executeUpdate();
			
				JOptionPane.showMessageDialog(null, "Successfully Added Medicine");
			}
		}
		
		catch(Exception exe) {
			exe.printStackTrace();
		}
		
	}
}
