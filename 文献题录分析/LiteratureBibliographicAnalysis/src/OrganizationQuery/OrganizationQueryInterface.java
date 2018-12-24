package OrganizationQuery;

import javax.swing.*;
import java.awt.*;

public class OrganizationQueryInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	JTextField SingleText,TopNText,DeleteText,CombineText1,CombineText2;
	JButton SingleButton,TopNButton,DeleteButton,CombineButton;
	JTextArea Result;
	SingleListen SingleListener;
	TopNListen TopNListener;
	DeleteListen DeleteListener;
	CombineListen CombineListener;
	JLabel Label1,Label2,Label3,Label4,Label5,Label6; 
	JScrollPane ScrollPane;

	public OrganizationQueryInterface() {
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	void init() {
		this.setLayout(null);
		this.add(Label1=new JLabel("机构查询"));
		Label1.setFont(new Font("黑体",1,15));
		Label1.setBounds(20,20,380,15);
		this.add(Label2=new JLabel("查询单个机构："));
		Label2.setBounds(20,50,120,15);
		this.add(SingleText=new JTextField(5));
		SingleText.setBounds(140,42,150,30);
		this.add(SingleButton=new JButton("确定"));
		SingleButton.setBounds(300,42,70,25);
		this.add(Label3=new JLabel("查询TopN个机构："));
		Label3.setBounds(20,80,120,15);
		this.add(TopNText=new JTextField(5));
		TopNText.setBounds(140,72,150,30);
		this.add(TopNButton=new JButton("确定"));
		TopNButton.setBounds(300,72,70,25);
		
		Result=new JTextArea(15,25);
		this.add(ScrollPane=new JScrollPane(Result));
		ScrollPane.setBounds(20,110,350,350);
		
		this.add(Label4=new JLabel("机构修正"));
		Label4.setFont(new Font("黑体",1,15));
		Label4.setBounds(20,490,380,15);
		this.add(Label5=new JLabel("删除单个机构："));
		Label5.setBounds(20,520,120,15);
		this.add(DeleteText=new JTextField(5));
		DeleteText.setBounds(120,512,150,30);
		this.add(DeleteButton=new JButton("确定"));
		DeleteButton.setBounds(280,512,70,25);
		this.add(Label6=new JLabel("将前者机构合与后者机构合并："));
		Label6.setBounds(20,550,300,15);
		this.add(CombineText1=new JTextField(5));
		this.add(CombineText2=new JTextField(5));
		CombineText1.setBounds(20,570,150,30);
		CombineText2.setBounds(180,570,150,30);
		this.add(CombineButton=new JButton("确定"));
		CombineButton.setBounds(340,570,70,25);
		
		SingleListener=new SingleListen();
		SingleListener.setJTextField(SingleText);
		SingleListener.setJTextArea(Result);
		SingleButton.addActionListener(SingleListener);
		
		TopNListener=new TopNListen();
		TopNListener.setJTextField(TopNText);
		TopNListener.setJTextArea(Result);
		TopNButton.addActionListener(TopNListener);
		
		DeleteListener=new DeleteListen();
		DeleteListener.setJTextField(DeleteText);
		DeleteListener.setJTextArea(Result);
		DeleteButton.addActionListener(DeleteListener);
		
		CombineListener=new CombineListen();
		CombineListener.setJTextField(CombineText1,CombineText2);
		CombineListener.setJTextArea(Result);
		CombineButton.addActionListener(CombineListener);
	}
}


