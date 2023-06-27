package Medical_Management_System;

import java.sql.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class DeleteStock extends JFrame implements ActionListener{
	
	Connection conn;
	JLabel medIdL = new JLabel("Medicine code: ");
	JTextField medIdF = new JTextField(); 
	JButton delete = new JButton("Delete");
	
	
	DeleteStock( JPanel frameDelStock ) {
		
		medIdL.setBounds(90,100,200,40);
		medIdL.setFont(new Font("Calibri", Font.PLAIN, 20));
		frameDelStock.add(medIdL);
		
		
		medIdF.setBounds(260,100,200,40);
		frameDelStock.add(medIdF);
		
		delete.setBounds(200,180,100,40);
		frameDelStock.add(delete);
		delete.addActionListener(this);
		
		frameDelStock.setVisible(true);
		frameDelStock.setSize(600,600);
		frameDelStock.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			conn = MyConnection.getConnection();
			String id = medIdF.getText();
			
			if(e.getSource() == delete) {
				
				PreparedStatement ps = conn.prepareStatement("delete from medical_stocks where medicine_id=?");
				ps.setString(1, id);
				ps.executeQuery();
				JOptionPane.showMessageDialog(null, "Successfully Deleted Medicine");
				medIdF.setText(" ");
			}
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
	

}
