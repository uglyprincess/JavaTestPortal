package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.loginWindow;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;

public class userHome extends JFrame {

	private JPanel contentPane;
	protected Vector<String> data;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public userHome(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton signout = new JButton("Sign Out");
		signout.addActionListener(new ActionListener() {
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
		signout.setBounds(10, 241, 85, 21);
		contentPane.add(signout);
		
		JLabel lblNewLabel = new JLabel("Student Home");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(162, 10, 140, 21);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 41, 450, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Attempt Test");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					data = new Vector<String>();
					FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/responses.txt");
					BufferedReader br = new BufferedReader(fr);
					String line;
					while((line=br.readLine())!=null)  
					{  
					data.add(line); 
					}  
					fr.close(); 
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
				int flag=0;
				for(int i=0;i<data.size();i++)
				{
					String[] temp = data.get(i).split("_");
					if(temp[0].equals(username))
					{
						flag++;
						break;
					}
				}
				if(flag==0)
				{
					String[] args = new String[1];
					args[0]=username;
						try {
							attemptTest.main(args);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You've already attempted the test!");
				}
				}
		});
		btnNewButton.setBounds(162, 85, 140, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Result");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					data = new Vector<String>();
					FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/responses.txt");
					BufferedReader br = new BufferedReader(fr);
					String line;
					while((line=br.readLine())!=null)  
					{  
					data.add(line); 
					}  
					fr.close(); 
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
				int flag=0;
				for(int i=0;i<data.size();i++)
				{
					String[] temp = data.get(i).split("_");
					if(temp[0].equals(username))
					{
						flag++;
						break;
					}
				}
				if(flag==0)
				{
					JOptionPane.showMessageDialog(null, "Attempt the Test First!");
				}
				else
				{
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								resultWindow frame = new resultWindow(username);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				
			}
		});
		btnNewButton_1.setBounds(162, 138, 140, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel userLabel = new JLabel("user");
		userLabel.setBounds(10, 53, 100, 13);
		contentPane.add(userLabel);
		
		userLabel.setText("User: "+username);
	}
}
