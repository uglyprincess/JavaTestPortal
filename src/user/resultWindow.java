package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class resultWindow extends JFrame {

	private JPanel contentPane;
	public Vector<String> questions,responses;
	String[] studentResponse,correct;
	int mark=0;
	int current =0;
	JLabel question,A,B,C,D,answer,selected;
	private JButton btnNewButton;
	private Vector<String> data;
	private JLabel verdict;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public resultWindow(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel score = new JLabel("Score:");
		score.setBounds(10, 32, 121, 13);
		contentPane.add(score);
		
		JLabel total = new JLabel("Total:");
		total.setBounds(10, 55, 121, 13);
		contentPane.add(total);
		
		JLabel user = new JLabel("User");
		user.setBounds(10, 10, 162, 13);
		contentPane.add(user);
		
		question = new JLabel("New label");
		question.setBounds(10, 93, 605, 73);
		contentPane.add(question);
		
		A = new JLabel("New label");
		A.setBounds(10, 176, 177, 13);
		contentPane.add(A);
		
		B = new JLabel("New label");
		B.setBounds(10, 199, 198, 13);
		contentPane.add(B);
		
		C = new JLabel("New label");
		C.setBounds(10, 222, 312, 13);
		contentPane.add(C);
		
		D = new JLabel("New label");
		D.setBounds(10, 245, 282, 13);
		contentPane.add(D);
		
		answer = new JLabel("New label");
		answer.setBounds(10, 306, 198, 13);
		contentPane.add(answer);
		
		selected = new JLabel("New label");
		selected.setBounds(10, 329, 198, 13);
		contentPane.add(selected);
		
		JButton next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(current==questions.size()-1)
				{
					JOptionPane.showMessageDialog(null, "This is the Last Question!");
				}
				else
				{
					current++;
					set();
				}
				
			}
		});
		next.setBounds(530, 359, 85, 21);
		contentPane.add(next);
		
		JButton previous = new JButton("Previous");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(current==0)
				{
					JOptionPane.showMessageDialog(null, "This is the First Question!");
				}
				else
				{
					current--;
					set();
				}
				
			}
		});
		previous.setBounds(435, 359, 85, 21);
		contentPane.add(previous);
		
		user.setText("User: "+username);
		try
		{
			questions = new Vector<String>();
			FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/testQuestions.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null)  
			{  
			questions.add(line); 
			}  
			fr.close(); 
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			responses = new Vector<String>();
			FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/responses.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null)  
			{  
			responses.add(line); 
			}  
			fr.close(); 
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		
		for(int i=0;i<responses.size();i++)
		{
			studentResponse = responses.get(i).split("_");
			if(studentResponse[0].equals(username))
			{
				break;
			}
		}
		for(int i=0;i<questions.size();i++)
		{
			correct = questions.get(i).split("_");
			if(correct[0].equals(studentResponse[i+1]))
			{
				mark+=4;
			}
			else if(studentResponse[i+1].equals("null"))
			{
				mark+=0;
			}
			else
			{
				mark-=1;
			}
		}
		score.setText("Score: "+mark);
		total.setText("Total: "+ (questions.size()*4));
		try
		{
			data = new Vector<String>();
			FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/resultSheet.txt");
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
			FileWriter fw;
			try
			{
				fw = new FileWriter("C:/Users/Anirudh/Desktop/OOM-project/resultSheet.txt",true);
				fw.write(username+"_"+mark+"\n");
				fw.close();
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex+"");
			}
		}
		
		btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(530, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		verdict = new JLabel("verdict");
		verdict.setBounds(10, 283, 138, 13);
		contentPane.add(verdict);
		set();
	}
	void set()
	{
		correct = questions.get(current).split("_");
		question.setText("Question "+(current+1)+": "+correct[2]);
		A.setText("A. "+correct[3]);
		B.setText("B. "+correct[4]);
		C.setText("C. "+correct[5]);
		D.setText("D. "+correct[6]);
		answer.setText("Correct Option: "+correct[0]);
		selected.setText("Selected Option: "+studentResponse[current+1]);
		if(correct[0].equals(studentResponse[current+1]))
		{
			verdict.setText("Verdict: Correct(+4)");
		}
		else if (studentResponse[current+1].equals("null"))
		{
			verdict.setText("Verdict: Unattempted(0)");
		}
		else
		{
			verdict.setText("Verdict: Incorrect(-1)");
		}
	}
}
