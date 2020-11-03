package login;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class signUp implements ActionListener{

	public JFrame frame;
	public JTextField textField;
	public JPasswordField passwordField;
	Vector <String> data;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					signUp window = new signUp();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public signUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New User");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(165, 10, 92, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(37, 57, 81, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(37, 117, 81, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(161, 57, 244, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(165, 110, 240, 26);
		frame.getContentPane().add(passwordField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.setBounds(164, 142, 123, 21);
		frame.getContentPane().add(chckbxNewCheckBox);
		chckbxNewCheckBox.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() != ItemEvent.SELECTED) {
		        	passwordField.setEchoChar('•');
		        } else {
		        	passwordField.setEchoChar((char) 0);
		        }
		    }
		});
		
		
		JButton signupButton = new JButton("Register");
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					data = new Vector<String>();
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
				int flag =0;
				for(int i=0;i<data.size();i++)
				{
					String[] temp = data.get(i).split("_");
					if(temp[0].equals(textField.getText()))
					{
						JOptionPane.showMessageDialog(null,"Username already taken! Please try another");
						flag++;
						break;
					}
				}
				if(flag==0)
				{
					FileWriter fw;
					try
					{
						fw = new FileWriter("C:/Users/Anirudh/Desktop/OOM-project/loginData.txt",true);
						fw.write(textField.getText()+"_"+passwordField.getText()+"\n");
						fw.close();
						JOptionPane.showMessageDialog(null,"Signup Successfull!");
						frame.dispose();
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,ex+"");
					}
				}
				
				
			}
		});
		signupButton.setBounds(320, 189, 85, 21);
		frame.getContentPane().add(signupButton);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	

}
