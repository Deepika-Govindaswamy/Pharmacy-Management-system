package Medical_Management_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;


public class Cart extends JFrame implements ActionListener{

	Connection con;
	int netPrice = 0, price = 0;
	
	JFrame cartFrame = new JFrame("Cart");
	JButton back = new JButton("<-");
	JButton buy = new JButton("Buy");
	
	JLabel cartTitle = new JLabel("Cart");
	
	String header[] = { "Product Id", "Product Name", "Quantity", "Item Price", "Total Price" };

	DefaultTableModel model = new DefaultTableModel(header,0);
	JTable itemList = new JTable(model);
	JScrollPane sp = new JScrollPane(itemList);
	
	JButton del = new JButton("Delete Product");
	
	
	
	
	public void createFrameCart() {
		
		cartFrame.setSize(650,650);
		cartFrame.setLayout(null);
		cartFrame.setVisible(true);
		cartFrame.setLocationRelativeTo(null);
		
		sp.setBounds(70,150,500,250);
		cartFrame.add(sp);
		
		back.setFont(new Font("Calibri",Font.BOLD,12));
    	back.setBounds(0,1,45,20);
    	cartFrame.add(back);
    	back.addActionListener(this);
    	
    	del.setBounds(220,500,170,30);
    	cartFrame.add(del);
    	del.addActionListener(this);
		


	}
	
	public void addToCart(String id, String name, int qty, int price, int total){
			
		model.addRow( new String[] { id, name, Integer.toString(qty), Integer.toString(price), Integer.toString(total)} );
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			if( e.getSource() == back) {
				cartFrame.setVisible(false);
				dispose();
			}
			
			if( e.getSource() == del) {
				
				if(itemList.getSelectedRow() != -1) {
					model.removeRow(itemList.getSelectedRow());
		            JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
		        }
			}
		}
		
		catch( Exception exp) {
			exp.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Cart c = new Cart();
	
	}

}
