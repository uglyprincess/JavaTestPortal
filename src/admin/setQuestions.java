package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class setQuestions extends JFrame {

	private JPanel contentPane;
	private JTextField question;
	private JTextField optionA;
	private JTextField optionB;
	private JTextField optionC;
	private JTextField optionD;
	public int qid = 1;
	public String sel;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public setQuestions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Set Question");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(215, 10, 129, 26);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 547, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Question");
		lblNewLabel_1.setBounds(10, 69, 69, 13);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton A = new JRadioButton("A.");
		A.setBounds(20, 160, 46, 21);
		contentPane.add(A);
		
		JRadioButton B = new JRadioButton("B.");
		B.setBounds(20, 193, 46, 26);
		contentPane.add(B);
		
		JRadioButton C = new JRadioButton("C.");
		C.setBounds(20, 227, 46, 21);
		contentPane.add(C);
		
		JRadioButton D = new JRadioButton("D.");
		D.setBounds(20, 260, 46, 21);
		contentPane.add(D);
		
		ButtonGroup group = new ButtonGroup();
		group.add(A);
		group.add(B);
		group.add(C);
		group.add(D);
		lblNewLabel_1.setText("Question "+qid);
		JButton btnNewButton = new JButton("Finish");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(A.isSelected())
				{
					sel="A";
				}
				if(B.isSelected())
				{
					sel="B";
				}
				if(C.isSelected())
				{
					sel="C";
				}
				if(D.isSelected())
				{
					sel="D";
				}
				FileWriter fw;
				try
				{
					fw = new FileWriter("C:/Users/Anirudh/Desktop/OOM-project/testQuestions.txt",true);
					fw.write(sel+"_"+qid+"_"+question.getText()+"_"+optionA.getText()+"_"+optionB.getText()+"_"+optionC.getText()+"_"+optionD.getText()+"\n");
					fw.close();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex+"");
				}
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
		btnNewButton.setBounds(430, 193, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add new");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(A.isSelected())
				{
					sel="A";
				}
				if(B.isSelected())
				{
					sel="B";
				}
				if(C.isSelected())
				{
					sel="C";
				}
				if(D.isSelected())
				{
					sel="D";
				}
				FileWriter fw;
				try
				{
					fw = new FileWriter("C:/Users/Anirudh/Desktop/OOM-project/testQuestions.txt",true);
					fw.write(sel+"_"+qid+"_"+question.getText()+"_"+optionA.getText()+"_"+optionB.getText()+"_"+optionC.getText()+"_"+optionD.getText()+"\n");
					fw.close();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex+"");
				}
				qid++;
				lblNewLabel_1.setText("Question "+qid);
				question.setText(null);
				optionA.setText(null);
				optionB.setText(null);
				optionC.setText(null);
				optionD.setText(null);
				group.clearSelection();
			}
		});
		btnNewButton_1.setBounds(430, 227, 85, 21);
		contentPane.add(btnNewButton_1);
		
		question = new JTextField();
		question.setBounds(10, 92, 547, 48);
		contentPane.add(question);
		question.setColumns(10);
		
		optionA = new JTextField();
		optionA.setBounds(72, 161, 96, 19);
		contentPane.add(optionA);
		optionA.setColumns(10);
		
		optionB = new JTextField();
		optionB.setBounds(72, 194, 96, 19);
		contentPane.add(optionB);
		optionB.setColumns(10);
		
		optionC = new JTextField();
		optionC.setBounds(72, 228, 96, 19);
		contentPane.add(optionC);
		optionC.setColumns(10);
		
		optionD = new JTextField();
		optionD.setBounds(72, 261, 96, 19);
		contentPane.add(optionD);
		optionD.setColumns(10);
	}
}
