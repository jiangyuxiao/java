package Coauthor;

import javax.swing.*;

public class CoauthorInterface extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JTextField TopNText;
	JButton TopNButton;
	JTextArea Result;
	TopNListen TopNListener;
	JLabel Label1,Label2; 
	JScrollPane ScrollPane;
	
	public CoauthorInterface() {
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	void init() {
		this.setLayout(null);
		this.add(Label1=new JLabel("查询TopN个合著信息："));
		Label1.setBounds(20,30,250,15);
		this.add(TopNText=new JTextField(5));
		TopNText.setBounds(170,22,80,30);
		this.add(TopNButton=new JButton("确定"));
		TopNButton.setBounds(260,22,70,25);
		
		Result=new JTextArea(15,25);
		this.add(ScrollPane=new JScrollPane(Result));
		ScrollPane.setBounds(20,60,350,350);
		
		TopNListener=new TopNListen();
		TopNListener.setJTextField(TopNText);
		TopNListener.setJTextArea(Result);
		TopNButton.addActionListener(TopNListener);		
	
	}
}
