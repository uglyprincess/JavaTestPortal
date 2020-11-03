package admin;

import login.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class adminHome extends JFrame {

	private JPanel contentPane;
	String isTime;
	String line;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public adminHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Home");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(166, 10, 124, 26);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 439, 2);
		contentPane.add(separator);
		
		
		try
		{
			FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/testTime.txt");
			BufferedReader br = new BufferedReader(fr);
			
			isTime = br.readLine(); 
			fr.close(); 
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		if(isTime!=null)
		{
			JLabel time = new JLabel("time: "+ isTime+" minutes");
			time.setBounds(350, 58, 100, 13);
			contentPane.add(time);
		}
		JButton btnNewButton = new JButton("Set Questions");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					PrintWriter writer = new PrintWriter("C:/Users/Anirudh/Desktop/OOM-project/testQuestions.txt");
					writer.print("");
					writer.close();
				}
				catch(Exception q)
				{
					q.printStackTrace();
				}
				
				try
				{
					PrintWriter writer = new PrintWriter("C:/Users/Anirudh/Desktop/OOM-project/resultSheet.txt");
					writer.print("");
					writer.close();
				}
				catch(Exception q)
				{
					q.printStackTrace();
				}
				try
				{
					PrintWriter writer = new PrintWriter("C:/Users/Anirudh/Desktop/OOM-project/responses.txt");
					writer.print("");
					writer.close();
				}
				catch(Exception q)
				{
					q.printStackTrace();
				}
				try
				{
					PrintWriter writer = new PrintWriter("C:/Users/Anirudh/Desktop/OOM-project/resultSheet.txt");
					writer.print("");
					writer.close();
				}
				catch(Exception q)
				{
					q.printStackTrace();
				}
				String time;
				time = JOptionPane.showInputDialog("Enter the total time for test(In Minutes)");
				try
				{
					PrintWriter writer = new PrintWriter("C:/Users/Anirudh/Desktop/OOM-project/testTime.txt");
					writer.print(time);
					writer.close();
				}
				catch(Exception q)
				{
					q.printStackTrace();
				}
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setQuestions frame = new setQuestions();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setBounds(166, 109, 124, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Results");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new showResult();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1.setBounds(166, 158, 124, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sign Out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							loginWindow window = new loginWindow();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				dispose();
			}
		});
		btnNewButton_2.setBounds(364, 277, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Paper Preview");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File newfile = new File("C:/Users/Anirudh/Desktop/OOM-project/testQuestions.txt");
				if(newfile.length()==0)
				{
					JOptionPane.showMessageDialog(null, "No Questions to display");
				}
				else
				{
					String time;
					time = JOptionPane.showInputDialog("Updated Time(In Minutes) [Type 'N' if you do not want to update]");
					if(time.equals("N"))
					{
						
					}
					else
					{
						try
						{
							PrintWriter writer = new PrintWriter("C:/Users/Anirudh/Desktop/OOM-project/testTime.txt");
							writer.print(time);
							writer.close();
						}
						catch(Exception q)
						{
							q.printStackTrace();
						}
					}
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								testPreview frame = new testPreview(0);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}	
						}
					});
					dispose();
				}
				
			}
		});
		btnNewButton_3.setBounds(166, 205, 124, 21);
		contentPane.add(btnNewButton_3);
		
		
	}
}
