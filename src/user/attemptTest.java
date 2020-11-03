package user;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.*;
import java.util.Timer;
import java.awt.event.*;
import javax.swing.*;

import java.awt.EventQueue;
import java.awt.Font;

public class attemptTest extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	static ArrayList<String> questions = new ArrayList<String>();
	static ArrayList<String> options = new ArrayList<String>();
	static String[] responses;
//	static ArrayList<String> responses = new ArrayList<String>();
	public static int length =0;
	static int num;
	int i;
	String line;
	
	JLabel label, questionLabel;
	JRadioButton choices[] = new JRadioButton[5];
	JButton prev, next, bm;
	ButtonGroup bg;
	int current=0,x=1,y=1,now=0,p=0;
	int rightAns = 0;
	int m[] = new int[400];
	private JLabel userLabel;
	public static String[] name;
	private JLabel question;
	JRadioButton A,B,C,D;
	ButtonGroup group;
	public static JLabel time;
	
	attemptTest(String s)
	{
		super(s);
		label = new JLabel();
		getContentPane().add(label);
		bg = new ButtonGroup();
		
		for(int i=0;i<5;i++)
		{
			choices[i] = new JRadioButton();
			getContentPane().add(choices[i]);
			bg.add(choices[i]);
		}
		
		time = new JLabel("New label");
	    time.setBounds(300, 10, 168, 13);
	    getContentPane().add(time);
	    try
		{
			FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/testTime.txt");
			BufferedReader br = new BufferedReader(fr);
			
			line = br.readLine();
			fr.close(); 
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		i = Integer.parseInt(line)*60;
	    
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			public void run() {
				if(i>=0)
				{
					String p = String.format("%02d:%02d", i / 60, i % 60);
					time.setText("Remaining Time: "+p);
					i--;
				}
				else
				{
					timer.cancel();
					check();
					length=0;
					dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								resultWindow frame = new resultWindow(name[0]);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		};
		timer.scheduleAtFixedRate(task, 0, 1000);
		
		prev = new JButton("Previous"); 
		next=new JButton("Next");  
	    bm=new JButton("Bookmark");
	    
	    prev.addActionListener(this);
	    next.addActionListener(this);  
	    bm.addActionListener(this);  
	    getContentPane().add(prev);getContentPane().add(next);getContentPane().add(bm);  
	    
	    question = new JLabel("New label");
	    question.setBounds(30, 56, 438, 79);
	    getContentPane().add(question);
	    
	    A = new JRadioButton("New radio button");
	    A.setBounds(30, 141, 103, 21);
	    getContentPane().add(A);
	    
	    B = new JRadioButton("New radio button");
	    B.setBounds(30, 164, 103, 21);
	    getContentPane().add(B);
	    
	    C = new JRadioButton("New radio button");
	    C.setBounds(30, 187, 103, 21);
	    getContentPane().add(C);
	    
	    D = new JRadioButton("New radio button");
	    D.setBounds(30, 210, 103, 21);
	    getContentPane().add(D);
	    
	    group = new ButtonGroup();
	    group.add(A);
	    group.add(B);
	    group.add(C);
	    group.add(D);
	    
	    questionLabel = new JLabel("Question");
	    questionLabel.setBounds(30, 33, 103, 13);
	    getContentPane().add(questionLabel);
	    set();  
	    
	    
	    prev.setBounds(50,320,100,30);
	    next.setBounds(200,320,100,30);
	    bm.setBounds(350,320,100,30);  
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    getContentPane().setLayout(null);  
	    
	    JSeparator separator = new JSeparator();
	    separator.setOrientation(SwingConstants.VERTICAL);
	    separator.setBounds(478, 10, 2, 340);
	    getContentPane().add(separator);
	    
	    JLabel lblNewLabel = new JLabel("Bookmarks");
	    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
	    lblNewLabel.setBounds(566, 10, 112, 20);
	    getContentPane().add(lblNewLabel);
	    
	    userLabel = new JLabel("User");
	    userLabel.setBounds(10, 10, 140, 13);
	    getContentPane().add(userLabel);
	    setLocation(250,100);  
	    setVisible(true);  
	    setSize(770,405);  
	    
	    userLabel.setText("User: "+s);
	    
	    JButton btnNewButton = new JButton("Save response");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(A.isSelected())
	    	    {
	    			
	    	    	responses[current]="A";
	    	    }
	    	    else if(B.isSelected())
	    	    {
	    	    	
	    	    	responses[current]="B";
	    	    }
	    	    else if(C.isSelected())
	    	    {
	    	    	
	    	    	responses[current]="C";
	    	    }
	    	    else if(D.isSelected())
	    	    {
	    	    	
	    	    	responses[current]="D";
	    	    }
	    	    else
	    	    {
	    	    	responses[current]=null;
	    	    }
	    	}
	    });
	    btnNewButton.setBounds(30, 261, 140, 21);
	    getContentPane().add(btnNewButton);
	    
	    JButton btnNewButton_1 = new JButton("Clear Selection");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		group.clearSelection();
	    		btnNewButton.doClick();
	    		
	    	}
	    });
	    btnNewButton_1.setBounds(326, 261, 124, 21);
	    getContentPane().add(btnNewButton_1);
	    

	}
	
	public void actionPerformed(ActionEvent e)  
    {  
        if(e.getActionCommand().equals("Next"))  
        {    
            current++;  
			set(); 
             
            prev.setEnabled(true);
        } 
        if(e.getActionCommand().equals("Previous"))
        {
        	current--;
        	set();
        	next.setEnabled(true);
        	
        	
        }
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton side=new JButton("Bookmarked: "+x);  
            side.setBounds(550,20+30*x,150,30);  
            getContentPane().add(side);  
            side.addActionListener(this);  
            m[x]=current;  
            x++;       
            setVisible(false);  
            setVisible(true); 
            
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {
        	
        	
        	if(e.getActionCommand().equals("Bookmarked: "+y))  
        	{      
        		current=m[y];  
        		set();
        		((JButton)e.getSource()).setEnabled(false);    
        	}  
        }  
      
        if(e.getActionCommand().equals("Submit"))  
        {  
            check();  
            length=0;
            EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						resultWindow frame = new resultWindow(name[0]);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
        }  
    }  
	
	void set()  
	{
		questionLabel.setText("Question "+(current+1));
		group.clearSelection();
		p = current*4;
		question.setText(questions.get(current));
		A.setText(options.get(p));
		B.setText(options.get(p+1));
		C.setText(options.get(p+2));
		D.setText(options.get(p+3));
		String op = responses[current];
		if(op=="A")
		{
			A.doClick();
		}
		if(op=="B")
		{
			B.doClick();
		}
		if(op=="C")
		{
			C.doClick();
		}
		if(op=="D")
		{
			D.doClick();
		}
		if(current==length-1)  
        {    
            next.setText("Submit");  
        } 
		if(current!=length-1)  
        {
        	next.setText("Next");
        }
		if(current==0)
    	{
    		prev.setEnabled(false);
    	}
	}  	
	
	void check() 
	{
		String resp = name[0];
		for(int w=0;w<length;w++)
		{
			resp+="_"+responses[w];
		}
		FileWriter fw;
		try
		{
			fw = new FileWriter("C:/Users/Anirudh/Desktop/OOM-project/responses.txt",true);
			fw.write(resp+"\n");
			fw.close();
			JOptionPane.showMessageDialog(null,"Test Submitted!");
			dispose();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex+"");
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		name = args;
		try
		{
			FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/testQuestions.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			while((line=br.readLine())!=null)  
			{  
				length++;
				String[] ques=line.split("_");
				questions.add(ques[2]);
				for(int i=0;i<4;i++)
				{
					options.add(ques[3+i]);
				}
			}
			responses = new String[length];
			
			fr.close(); 
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		
		//System.out.println(name.size());
		new attemptTest(name[0]);
	}
}
