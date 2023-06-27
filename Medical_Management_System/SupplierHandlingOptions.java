package Medical_Management_System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SupplierHandlingOptions extends JFrame implements ActionListener{

	JFrame frameSupplier = new JFrame("Manage Medical Suppliers");
	JButton addB = new JButton("ADD");
	JButton deleteB = new JButton("DELETE");
	JButton viewB = new JButton("VIEW");

	JLayeredPane layers = new JLayeredPane();
	JPanel addSupplier = new JPanel();
	JPanel deleteSupplier = new JPanel();
	JPanel viewSupplier = new JPanel();
	
	JLabel addLabel = new JLabel("Add Supplier");
	JLabel deleteLabel = new JLabel("Delete Supplier");
	JLabel viewLabel = new JLabel("View Supplier");
	
	JButton back = new JButton("<-");
	
	public SupplierHandlingOptions(){
		
		frameSupplier.setSize(650,650);
		frameSupplier.setVisible(true);
		frameSupplier.setLayout(null);
		layers.setBounds(25,80,600,600);
		layers.setBackground(null);
		frameSupplier.add(layers);
		frameSupplier.setLocationRelativeTo(null);
		
		addB.setBounds(80,75,100,40);
		frameSupplier.add(addB);
		addB.addActionListener(this);
		
		deleteB.setBounds(240,75,100,40);
		frameSupplier.add(deleteB);
		deleteB.addActionListener(this);
		
		viewB.setBounds(400,75,100,40);
		frameSupplier.add(viewB);
		viewB.addActionListener(this);
		
		addSupplier.setBounds(25,80,600,600);
		deleteSupplier.setBounds(25,80,600,600);
		viewSupplier.setBounds(25,80,600,600);
		
		back.setFont(new Font("Calibri",Font.BOLD,12));
    	back.setBounds(0,1,45,20);
    	frameSupplier.add(back);
    	back.addActionListener(this);
		
		layers.add(addSupplier);
		layers.add(deleteSupplier);
		layers.add(viewSupplier);	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			if(e.getSource() == addB) {
				layers.removeAll();
				addLabel.setBounds(180,80,300,35);
				addLabel.setFont(new Font("Arial", Font.PLAIN, 30));
				layers.add(addLabel); 
				layers.add(addSupplier);
				layers.repaint();
				layers.revalidate();
				AddSupplier as = new AddSupplier(addSupplier);
			}
			
			if(e.getSource() == deleteB) {
				layers.removeAll();
				deleteLabel.setBounds(180,80,300,35);
				deleteLabel.setFont(new Font("Arial", Font.PLAIN, 30));
				layers.add(deleteLabel);
				layers.add(deleteSupplier);
				layers.repaint();
				layers.revalidate();
				
				DeleteSupplier ds = new DeleteSupplier(deleteSupplier);
			}
			
			if(e.getSource() == viewB) {
				layers.removeAll();
				viewLabel.setBounds(180,80,300,35);
				viewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
				layers.add(viewLabel);
				layers.add(viewSupplier);
				layers.repaint();
				layers.revalidate();
				
				ViewSupplier vs = new ViewSupplier(viewSupplier);
			}
			
			if(e.getSource() == back) {			
				frameSupplier.setVisible(false);
				dispose();
				StockLogin w = new StockLogin();
			}
		}
		
		catch(Exception exp) {
			exp.printStackTrace();
		}
		
		
	}
}
