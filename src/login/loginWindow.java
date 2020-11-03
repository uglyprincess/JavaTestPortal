package login;

import user.*;
import admin.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.io.FileReader;
import java.io.File;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class loginWindow  {

	public JFrame frame;
	public JTextField username;
	public JPasswordField password;
	Set<String> data;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) throws IOException{
		
		
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
	}

	/**
	 * Create the application.
	 */
	public loginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 433, 292);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE TEST PORTAL");
		lblNewLabel.setBounds(117, 10, 214, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(23, 69, 105, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(23, 133, 106, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(138, 69, 264, 26);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		
		password = new JPasswordField();
		password.setBounds(139, 125, 263, 27);
		frame.getContentPane().add(password);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		exitButton.setBounds(23, 221, 85, 21);
		frame.getContentPane().add(exitButton);
		
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.getText().equals("admin") && password.getText().equals("adminpass"))
				{
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								adminHome frame = new adminHome();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					frame.dispose();
				}
				else
				{
					try
					{
						data = new HashSet<String>();
						FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/loginData.txt");
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
					if(username.getText()!=null && password.getText()!=null)
					{
						
						if(data.contains(username.getText()+"_"+password.getText()))
						{
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										userHome frame = new userHome(username.getText());
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
							frame.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Invalid User Credentials!");
						}
					}
				}
				
			}
		});
		loginButton.setBounds(317, 162, 85, 21);
		frame.getContentPane().add(loginButton);
		
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 47, 379, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(23, 192, 379, 2);
		frame.getContentPane().add(separator_1);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText(null);
				password.setText(null);
			}
		});
		resetButton.setBounds(222, 162, 85, 21);
		frame.getContentPane().add(resetButton);
		
		JButton signUp = new JButton("Sign Up");
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							signUp window = new signUp();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		signUp.setBounds(317, 221, 85, 21);
		frame.getContentPane().add(signUp);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.setBounds(23, 162, 121, 21);
		frame.getContentPane().add(chckbxNewCheckBox);
		chckbxNewCheckBox.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() != ItemEvent.SELECTED) {
		        	password.setEchoChar('•');
		        } else {
		        	password.setEchoChar((char) 0);
		        }
		    }
		});
	}
}
