package importInterface;

import javax.swing.*;

public class importInterface extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JButton importButton,buildButton;
	JTextArea importText,Result;
	JLabel Label1,Label2; 
	JScrollPane ScrollPane1,ScrollPane2;
	importListen importListener;
	buildListen buildListener;
	
	public importInterface() {
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	void init() {
		this.setLayout(null);
		this.add(Label1=new JLabel("输入URL："));
		Label1.setBounds(20,30,70,15);
		
		importText=new JTextArea(10,20);
		this.add(ScrollPane1=new JScrollPane(importText));
		ScrollPane1.setBounds(20,55,400,250);
		
		this.add(importButton=new JButton("导入"));
		importButton.setBounds(20,315,70,30);
		this.add(buildButton=new JButton("构建相关表"));
		buildButton.setBounds(100,315,120,30);
		
		Result=new JTextArea(4,25);
		this.add(ScrollPane2=new JScrollPane(Result));
		ScrollPane2.setBounds(20,350,400,80);
		
		importListener=new importListen();
		importListener.setInputJTextArea(importText);
		importListener.setOutputJTextArea(Result);
		importButton.addActionListener(importListener);		
		
		buildListener=new buildListen();
		buildListener.setOutputJTextArea(Result);
		buildButton.addActionListener(buildListener);
	
	}
}
