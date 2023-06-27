
package Medical_Management_System;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class EmployeeHandlingOptions extends JFrame implements ActionListener {

	JFrame frameEmp = new JFrame("EMPLOYEE");
	JButton addB = new JButton("ADD");
	JButton updateB = new JButton("UPDATE");
	JButton deleteB = new JButton("DELETE");
	JButton viewB = new JButton("VIEW");

	JLayeredPane layers = new JLayeredPane();
	JPanel addEmp = new JPanel();
	JPanel updateEmp = new JPanel();
	JPanel deleteEmp = new JPanel();
	JPanel viewEmp = new JPanel();
	
	JLabel addLabel = new JLabel("Add Employee");
	JLabel updateLabel = new JLabel("Update Employee");
	JLabel deleteLabel = new JLabel("Delete Employee");
	JLabel viewLabel = new JLabel("View Employee");
	
	JButton back = new JButton("<-");
	
	
	EmployeeHandlingOptions(){
		
		frameEmp.setSize(650,650);
		frameEmp.setVisible(true);
		frameEmp.setLayout(null);
		layers.setBounds(25,80,600,600);
		layers.setBackground(null);
		frameEmp.add(layers);
		frameEmp.setLocationRelativeTo(null);

		
		addB.setBounds(70,75,100,40);
		frameEmp.add(addB);
		addB.addActionListener(this);
		
		updateB.setBounds(200,75,100,40);
		frameEmp.add(updateB);
		updateB.addActionListener(this);
		
		deleteB.setBounds(330,75,100,40);
		frameEmp.add(deleteB);
		deleteB.addActionListener(this);
		
		viewB.setBounds(460,75,100,40);
		frameEmp.add(viewB);
		viewB.addActionListener(this);
		
		addEmp.setBounds(25,80,600,600);
		updateEmp.setBounds(25,80,600,600);
		deleteEmp.setBounds(25,80,600,600);
		viewEmp.setBounds(25,80,600,600);
		
		back.setFont(new Font("Calibri",Font.BOLD,12));
    	back.setBounds(0,1,45,20);
    	frameEmp.add(back);
    	back.addActionListener(this);
		
		layers.add(addEmp);
		layers.add(updateEmp);
		layers.add(deleteEmp);
		layers.add(viewEmp);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			if(e.getSource() == addB) {
				
				addLabel.setBounds(210,80,300,35);
				addLabel.setFont(new Font("Arial", Font.PLAIN, 25));
				layers.removeAll();
				layers.add(addLabel);
				layers.add(addEmp);
				layers.repaint();
				layers.revalidate();
				AddEmployee ae = new AddEmployee(addEmp);
			}
			
			else if(e.getSource() == updateB) {
				
				updateLabel.setBounds(180,80,300,35);
				updateLabel.setFont(new Font("Arial", Font.PLAIN, 25));
				layers.removeAll();
				layers.add(updateLabel);
				layers.add(updateEmp);
				layers.repaint();
				layers.revalidate();
				UpdateEmployee ue = new UpdateEmployee(updateEmp);
			}
			
			else if(e.getSource() == deleteB) {
				
				deleteLabel.setBounds(180,80,300,35);
				deleteLabel.setFont(new Font("Arial", Font.PLAIN, 25));
				layers.removeAll();
				layers.add(deleteLabel);
				layers.add(deleteEmp);
				layers.repaint();
				layers.revalidate();
				DeleteEmployee de = new DeleteEmployee(deleteEmp);
			}
			
			else if(e.getSource() == viewB){
				
				viewLabel.setBounds(200,80,300,35);
				viewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
				layers.removeAll();
				layers.add(viewLabel);
				layers.add(viewEmp);
				layers.repaint();
				layers.revalidate();
				ViewEmployee ve = new ViewEmployee(viewEmp);
			}
			
			else if(e.getSource() == back) {			
				frameEmp.setVisible(false);
				dispose();
				ManagerLogin w = new ManagerLogin();
			}
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		EmployeeHandlingOptions e = new EmployeeHandlingOptions();
	}
	
}
