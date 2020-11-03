package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Stream;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class testPreview extends JFrame {

	private JPanel contentPane;
	public int skip;
	private JTextField A;
	private JTextField B;
	private JTextField C;
	private JTextField D;
	private JTextField answer;
	Vector<String> data;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public testPreview(int n) {
		skip=n;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Test Preview");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(210, 10, 129, 27);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 47, 547, 2);
		contentPane.add(separator);
		
		JTextField question = new JTextField("ques");
		question.setBounds(10, 83, 547, 54);
		contentPane.add(question);
		
		JLabel questionNo = new JLabel("question");
		questionNo.setBounds(10, 59, 74, 13);
		contentPane.add(questionNo);
		
		JLabel optionA = new JLabel("A");
		optionA.setBounds(10, 147, 45, 13);
		contentPane.add(optionA);
		
		JLabel optionB = new JLabel("B");
		optionB.setBounds(10, 170, 45, 13);
		contentPane.add(optionB);
		
		JLabel optionC = new JLabel("C");
		optionC.setBounds(10, 193, 45, 13);
		contentPane.add(optionC);
		
		JLabel optionD = new JLabel("D");
		optionD.setBounds(10, 216, 45, 13);
		contentPane.add(optionD);
		
		JLabel answerLabel = new JLabel("answer");
		answerLabel.setBounds(10, 268, 85, 13);
		contentPane.add(answerLabel);
		
		A = new JTextField();
		A.setBounds(88, 144, 96, 19);
		contentPane.add(A);
		A.setColumns(10);
		
		B = new JTextField();
		B.setBounds(88, 167, 96, 19);
		contentPane.add(B);
		B.setColumns(10);
		
		C = new JTextField();
		C.setBounds(88, 190, 96, 19);
		contentPane.add(C);
		C.setColumns(10);
		
		D = new JTextField();
		D.setBounds(88, 213, 96, 19);
		contentPane.add(D);
		D.setColumns(10);
		
		answer = new JTextField();
		answer.setBounds(106, 265, 96, 19);
		contentPane.add(answer);
		answer.setColumns(10);
		
		JButton next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skip++;
				try
				{
					FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/testQuestions.txt");
					BufferedReader br = new BufferedReader(fr);
					String line;
					for(int i=0;i<skip;i++)
					{
						br.readLine();
					}
					line = br.readLine();
					if(line==null)
					{
						skip--;
						JOptionPane.showMessageDialog(null, "This is the last Question!");
					}
					else
					{
						String[] quest = line.split("_");
						
						questionNo.setText("Question "+quest[1]);
						question.setText(quest[2]);
						A.setText(quest[3]);
						B.setText(quest[4]);
						C.setText(quest[5]);
						D.setText(quest[6]);
						answer.setText(quest[0]); 
						
						fr.close(); 
					}
					
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		});
		next.setBounds(472, 313, 85, 21);
		contentPane.add(next);
		try
		{
			FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/testQuestions.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			for(int i=0;i<skip;i++)
			{
				br.readLine();
			}
			line = br.readLine();
			String[] quest = line.split("_");
			if(quest[0].equals("null"))
			{
				JOptionPane.showMessageDialog(null, "No Questions to display");
				dispose();
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
			}
			
			questionNo.setText("Question "+quest[1]);
			question.setText(quest[2]);
			A.setText(quest[3]);
			B.setText(quest[4]);
			C.setText(quest[5]);
			D.setText(quest[6]);
			answer.setText(quest[0]); 
			
			fr.close(); 
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		
		
		JButton previous = new JButton("Previous");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(skip==0)
				{
					JOptionPane.showMessageDialog(null, "This is the First Question!");
				}
				else
				{
					skip--;
					try
					{
						FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/testQuestions.txt");
						BufferedReader br = new BufferedReader(fr);
						String line;
						for(int i=0;i<skip;i++)
						{
							br.readLine();
						}
						line = br.readLine();
						if(line==null)
						{
							JOptionPane.showMessageDialog(null, "This was the last Question!");
						}
						else
						{
							String[] quest = line.split("_");
							
							questionNo.setText("Question "+quest[1]);
							question.setText(quest[2]);
							A.setText(quest[3]);
							B.setText(quest[4]);
							C.setText(quest[5]);
							D.setText(quest[6]);
							answer.setText(quest[0]); 
							
							fr.close(); 
						}
						
					}
					catch (IOException ex)
					{
						ex.printStackTrace();
					}
				}
				
			}
		});
		previous.setBounds(366, 313, 85, 21);
		contentPane.add(previous);
		
		JButton btnNewButton = new JButton("exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
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
			}
		});
		btnNewButton.setBounds(10, 313, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton save = new JButton("Save Changes");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					data = new Vector<String>();
					FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/testQuestions.txt");
					BufferedReader br = new BufferedReader(fr);
					String line;
					while((line=br.readLine())!=null)  
					{  
					data.add(line); 
					}
					String[] quer  = data.get(skip).split("_");
					data.set(Integer.parseInt(quer[1])-1, answer.getText()+"_"+quer[1]+"_"+question.getText()+"_"+A.getText()+"_"+B.getText()+"_"+C.getText()+"_"+D.getText());
					fr.close(); 
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
				FileWriter fw;
				try
				{
					fw = new FileWriter("C:/Users/Anirudh/Desktop/OOM-project/testQuestions.txt");
					for(int i=0;i<data.size();i++)
					{
						fw.write(data.get(i)+"\n");
					}
					
					fw.close();
					JOptionPane.showMessageDialog(null,"Updated Succesfully!");
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex+"");
				}
			}
		});
		save.setBounds(366, 189, 123, 21);
		contentPane.add(save);
		
		
		
		
	}

}
