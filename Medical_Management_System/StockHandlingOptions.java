package Medical_Management_System;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class StockHandlingOptions extends JFrame implements ActionListener {

	JFrame frameStock = new JFrame("  Manage Medical Stocks");
	JButton addB = new JButton("ADD");
	JButton updateB = new JButton("UPDATE");
	JButton deleteB = new JButton("DELETE");
	JButton viewB = new JButton("VIEW");

	JLayeredPane layers = new JLayeredPane();
	JPanel addStock = new JPanel();
	JPanel updateStock = new JPanel();
	JPanel deleteStock = new JPanel();
	JPanel viewStock = new JPanel();
	
	JLabel addLabel = new JLabel("Add Medicine");
	JLabel updateLabel = new JLabel("Update Medicine");
	JLabel deleteLabel = new JLabel("Delete Medicine");
	JLabel viewLabel = new JLabel("View Medicine");
	
	JButton back = new JButton("<-");
	
	
	public StockHandlingOptions(){
		
		frameStock.setSize(650,650);
		frameStock.setVisible(true);
		frameStock.setLayout(null);
		layers.setBounds(25,80,600,600);
		layers.setBackground(null);
		frameStock.add(layers);
		frameStock.setLocationRelativeTo(null);
		
		addB.setBounds(70,75,100,40);
		frameStock.add(addB);
		addB.addActionListener(this);
		
		updateB.setBounds(200,75,100,40);
		frameStock.add(updateB);
		updateB.addActionListener(this);
		
		deleteB.setBounds(330,75,100,40);
		frameStock.add(deleteB);
		deleteB.addActionListener(this);
		
		viewB.setBounds(460,75,100,40);
		frameStock.add(viewB);
		viewB.addActionListener(this);
		
		addStock.setBounds(25,80,600,600);
		updateStock.setBounds(25,80,600,600);
		deleteStock.setBounds(25,80,600,600);
		viewStock.setBounds(25,80,600,600);
		
		back.setFont(new Font("Calibri",Font.BOLD,12));
    	back.setBounds(0,1,45,20);
    	frameStock.add(back);
    	back.addActionListener(this);
		
		layers.add(addStock);		
		layers.add(updateStock);		
		layers.add(deleteStock);
		layers.add(viewStock);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			if(e.getSource() == addB) {
				
				addLabel.setBounds(200,80,300,35);
				addLabel.setFont(new Font("Arial", Font.PLAIN, 30));
				layers.removeAll();
				layers.add(addLabel);
				layers.add(addStock);
				layers.repaint();
				layers.revalidate();
				AddStock as = new AddStock(addStock);
			}
			
			else if(e.getSource() == updateB) {
				
				updateLabel.setBounds(180,80,300,35);
				updateLabel.setFont(new Font("Arial", Font.PLAIN, 30));
				layers.removeAll();
				layers.add(updateLabel);
				layers.add(updateStock);
				layers.repaint();
				layers.revalidate();
				UpdateStock us = new UpdateStock(updateStock);
			}
			
			else if(e.getSource() == deleteB) {
			
				deleteLabel.setBounds(180,80,300,35);
				deleteLabel.setFont(new Font("Arial", Font.PLAIN, 30));
				layers.removeAll();
				layers.add(deleteLabel);
				layers.add(deleteStock);
				layers.repaint();
				layers.revalidate();
				DeleteStock ds = new DeleteStock(deleteStock);
			}
			
			else if(e.getSource() == viewB) {
				
				viewLabel.setBounds(150,80,300,35);
				viewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
				layers.removeAll();
				layers.add(viewLabel);
				layers.add(viewStock);
				layers.repaint();
				layers.revalidate();
				ViewStock vs = new ViewStock(viewStock);
			}
			
			else if(e.getSource() == back) {			
				frameStock.setVisible(false);
				dispose();
				StockLogin w = new StockLogin();
			}

		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
				
	}
	
	
}
