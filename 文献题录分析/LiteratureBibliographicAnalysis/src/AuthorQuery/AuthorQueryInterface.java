package AuthorQuery;

import javax.swing.*;

public class AuthorQueryInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	JTextField SingleText,TopNText;
	JButton SingleButton,TopNButton;
	JTextArea Result;
	SingleListen SingleListener;
	TopNListen TopNListener;
	JLabel Label1,Label2; 
	JScrollPane ScrollPane;

	public AuthorQueryInterface() {
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	void init() {
		this.setLayout(null);
		this.add(Label1=new JLabel("查询单个作者："));
		Label1.setBounds(20,30,250,15);
		this.add(SingleText=new JTextField(5));
		SingleText.setBounds(160,22,80,30);
		this.add(SingleButton=new JButton("确定"));
		SingleButton.setBounds(255,22,70,25);
		this.add(Label2=new JLabel("查询TopN个作者："));
		Label2.setBounds(20,60,250,15);
		this.add(TopNText=new JTextField(5));
		TopNText.setBounds(160,52,80,30);
		this.add(TopNButton=new JButton("确定"));
		TopNButton.setBounds(255,52,70,25);
		
		Result=new JTextArea(12,25);
		this.add(ScrollPane=new JScrollPane(Result));
		ScrollPane.setBounds(20,95,350,300);
		
		SingleListener=new SingleListen();
		SingleListener.setJTextField(SingleText);
		SingleListener.setJTextArea(Result);
		SingleButton.addActionListener(SingleListener);
		
		TopNListener=new TopNListen();
		TopNListener.setJTextField(TopNText);
		TopNListener.setJTextArea(Result);
		TopNButton.addActionListener(TopNListener);
	}
}
