package Medical_Management_System;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class DeleteSupplier extends JFrame implements ActionListener{
	
	Connection conn;
	JLabel supCompany = new JLabel("Supplier Id: ");
	JTextField supCompanyF = new JTextField(); 
	JButton delete = new JButton("Delete");
	
	
	DeleteSupplier( JPanel frameDelSupplier ) {
		
		supCompany.setBounds(100,100,200,35);
		supCompany.setFont(new Font("Calibri", Font.PLAIN, 20));
		frameDelSupplier.add(supCompany);
		
		supCompanyF.setBounds(260,100,150,35);
		frameDelSupplier.add(supCompanyF);
		
		delete.setBounds(200,180,100,40);
		frameDelSupplier.add(delete);
		delete.addActionListener(this);
		
		frameDelSupplier.setVisible(true);
		frameDelSupplier.setSize(600,600);
		frameDelSupplier.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			conn = MyConnection.getConnection();
			String id = supCompanyF.getText();
			
			if(e.getSource() == delete) {
				
				PreparedStatement ps = conn.prepareStatement("delete from medical_supplier where Supplier_id=?");
				ps.setString(1, id);
				ps.executeQuery();
				JOptionPane.showMessageDialog(null, "Successfully Deleted Supplier");
				supCompanyF.setText(" ");
			}
			
		}
		
		catch(Exception exc) {
			exc.printStackTrace();
		}	
	}
}
