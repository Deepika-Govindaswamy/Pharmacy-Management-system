package Medical_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BillHandlingOptions extends JFrame implements ActionListener{

	Connection conn;
	
	int netPrice = 0, price = 0;
	String medid;
	
	JFrame billingFrame = new JFrame(" BILL GENERATOR");
	
    JLabel bill = new JLabel("Bill ");
    
    
    JLabel customerNameL = new JLabel("Customer Name ");
    JTextField customerNameF = new JTextField();
    
    JLabel customerPhoneL = new JLabel("Customer phone ");
    JTextField customerPhoneF = new JTextField();
    
    JLabel medNameL = new JLabel("Medicine Name ");
    JTextField medNameF = new JTextField();
    
    JLabel qtyL = new JLabel("Quanitity ");
    
    JLabel priceL = new JLabel("Price ");
    JTextField priceF = new JTextField();
    
    JLabel totalPriceL = new JLabel("Net Price ");
    JTextField totalPriceF = new JTextField();
    
    String qtyOptions[] = {"","1","2","3","4","5","6","7","8","9","10"};
    JComboBox qtylist = new JComboBox(qtyOptions);
    
    JButton addB = new JButton("Add Item");
    JButton checkout = new JButton("Checkout");
    JButton view = new JButton("View Cart");
    JButton back = new JButton("<-");
    
    Cart cart = new Cart();
    
    
    public BillHandlingOptions() throws ClassNotFoundException, SQLException {
    	
    	billingFrame.setSize(650,650);
    	billingFrame.setVisible(true);
    	billingFrame.setLayout(null);
    	billingFrame.setLocationRelativeTo(null);
    	
    	bill.setBounds(270,40,150,50);
    	bill.setFont(new Font("Calibri",Font.PLAIN,40));
    	billingFrame.add(bill);
    	
    	customerNameL.setBounds(90,160,150,25);
    	customerNameL.setFont(new Font("Calibri",Font.PLAIN,17));
    	billingFrame.add(customerNameL);
    	
    	customerNameF.setBounds(250,160,200,25);
    	billingFrame.add(customerNameF);
    	
    	customerPhoneL.setBounds(90,210,150,25);
    	customerPhoneL.setFont(new Font("Calibri",Font.PLAIN,17));
    	billingFrame.add(customerPhoneL);
    	
    	customerPhoneF.setBounds(250,210,200,25);
    	billingFrame.add(customerPhoneF);
    	
    	medNameL.setBounds(90,260,150,25);
    	medNameL.setFont(new Font("Calibri",Font.PLAIN,17));
    	billingFrame.add(medNameL);
    	
    	medNameF.setBounds(250,260,200,25);
    	billingFrame.add(medNameF);
    	
    	qtyL.setBounds(90,310,150,25);
    	qtyL.setFont(new Font("Calibri",Font.PLAIN,17));
    	billingFrame.add(qtyL);
    	
    	qtylist.setBounds(250,310,100,25);
    	billingFrame.add(qtylist);
    	
    	    	
    	priceL.setBounds(90,360,150,25);
    	priceL.setFont(new Font("Calibri",Font.PLAIN,17));
    	billingFrame.add(priceL);
    	
    	priceF.setBounds(250,360,80,25);
    	billingFrame.add(priceF);
    	priceF.setEditable(false);
    	
    	totalPriceL.setBounds(400,420,100,25);
    	totalPriceL.setFont(new Font("Calibri",Font.PLAIN,17));
    	billingFrame.add(totalPriceL);
    	
    	totalPriceF.setBounds(500,420,80,25);
    	billingFrame.add(totalPriceF);
    	
    	addB.setBounds(90,500,120,30);
    	billingFrame.add(addB);
    	addB.addActionListener(this);
    	
    	checkout.setBounds(250,500,120,30);
    	billingFrame.add(checkout);
    	checkout.addActionListener(this);
    	
    	view.setBounds(410,500,120,30);
    	billingFrame.add(view);
    	view.addActionListener(this);
    	
    	back.setFont(new Font("Calibri",Font.BOLD,12));
    	back.setBounds(0,1,45,20);
    	billingFrame.add(back);
    	back.addActionListener(this);
    	
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		try {
			
			if(e.getSource()== addB) {
				
				int qty = Integer.parseInt((String)qtylist.getSelectedItem());
				String medName = medNameF.getText();
				
				conn = MyConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("select cost, medicine_id from medical_stocks where medicine_name = ?");
				ps.setString(1, medName);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					price = rs.getInt(1);
					medid = rs.getString(2);
				}
				
				priceF.setEditable(true);
				priceF.setText(Integer.toString(price));				
				
				ps = conn.prepareStatement("select quantity from medical_stocks where medicine_name = ?");
				ps.setString(1,medName);
				rs = ps.executeQuery();
				int updatedQty = 0, currentQty = 0;
				
				while (rs.next()) {
					currentQty = rs.getInt(1);
				}
				
				if( currentQty < qty) {
					
					JOptionPane.showMessageDialog(null, "Sufficient Quantity not available");
					medNameF.setText("");
					qtylist.setSelectedIndex(-1);
					totalPriceF.setText(Integer.toString(netPrice));
					priceF.setText("");
					priceF.setEditable(false);
					price = 0;
					
				}
				
				else {
					
					netPrice = netPrice + (price * qty);
					int totalUnitCost = price * qty; 
					cart.addToCart(medid, medName, qty, price, totalUnitCost);
					
					JOptionPane.showMessageDialog(null, "Successfully Added Item");
					
					updatedQty = currentQty-qty;
					
					ps = conn.prepareStatement("update medical_stocks set quantity = ? where medicine_name = ?");
					ps.setInt(1,updatedQty);
					ps.setString(2,medName);
					ps.executeUpdate();
					
					medNameF.setText("");
					qtylist.setSelectedIndex(-1);
					totalPriceF.setText(Integer.toString(netPrice));
					priceF.setText("");
					priceF.setEditable(false);
					price = 0;
				}
				
			}
			
			if(e.getSource()== checkout) {
		    	
				String name = customerNameF.getText();
				long phno = Long.parseLong(customerPhoneF.getText());
				
				totalPriceF.setText(Integer.toString(netPrice)); 
				
				
				Date date = new Date();  
			    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");  
			    String strDate = formatter.format(date); 
			    
				
			    PreparedStatement ps = conn.prepareStatement("insert into invoice_details(cust_name,cust_phno,net_price,inv_date) values(?,?,?,?)");
				
			    ps.setString(1,name);
				ps.setLong(2,phno);
				ps.setInt(3,netPrice);
				ps.setString(4,strDate);
				ps.executeUpdate();
				
	
				JOptionPane.showMessageDialog(null, "Successfully Checked Out");
				
				customerPhoneF.setText("");
				customerNameF.setText("");
				totalPriceF.setText("");
			}
			
			
			if(e.getSource()== view) {
				cart.createFrameCart();
			}
			
			if(e.getSource()== view) {
				billingFrame.setVisible(false);
				dispose();
				Welcome w = new Welcome();
			}
			
			
				
		}
		
		catch( Exception exp) {
			System.out.println(exp);
		}
		
	}
	
}
