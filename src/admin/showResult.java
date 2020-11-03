package admin;

import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Vector;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class showResult extends JFrame {

	private JPanel contentPane;
	Vector<String> data,type;
	int i=0;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public showResult() {
		
		try
		{
			data = new Vector<String>();
			FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/resultSheet.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null)  
			{  
				i++;
				data.add(line); 
			}  
			fr.close(); 
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			type = new Vector<String>();
			FileReader fr = new FileReader("C:/Users/Anirudh/Desktop/OOM-project/typeCorrect.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null)  
			{  
				type.add(line);
			}  
			fr.close(); 
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		String column[]={"STUDENT ID","MARKS SCORED","EASY CORRECT","TOUGH CORRECT","COMPLEX CORRECT"};
		String[][] result = new String[i][5];
		String[] temp,pp;
		for(int j=0;j<i;j++)
		{
			temp = data.get(j).split("_");
			result[j][0]=temp[0];
			result[j][1]=temp[1];
			pp=type.get(j).split("_");
			result[j][2]=pp[1];
			result[j][3]=pp[2];
			result[j][4]=pp[3];
		}
		JFrame f = new JFrame();
		JTable show = new JTable(result, column);
		show.setBounds(10, 54, 514, 270);
		JScrollPane sp = new JScrollPane(show); 
        f.getContentPane().add(sp);
        f.setSize(663, 428);
        f.setVisible(true);
	}
}
