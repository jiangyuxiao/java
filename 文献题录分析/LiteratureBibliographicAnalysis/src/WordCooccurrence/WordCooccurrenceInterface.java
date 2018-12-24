package WordCooccurrence;

import javax.swing.*;
public class WordCooccurrenceInterface extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JTextField TopNText,WordText;
	JButton TopNButton,WordButton;
	JTextArea Result,Result1,Result2,Result3;
	TopNListen TopNListener;
	WordListen WordListener;
	JLabel Label1,Label2,Label3,Label4,Label5; 
	JScrollPane ScrollPane1,ScrollPane2,ScrollPane3,ScrollPane4;
	
	public WordCooccurrenceInterface() {
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	void init() {
		this.setLayout(null);
		this.add(Label1=new JLabel("查询TopN个词共现信息："));
		Label1.setBounds(20,30,250,15);
		this.add(TopNText=new JTextField(5));
		TopNText.setBounds(170,22,80,30);
		this.add(TopNButton=new JButton("确定"));
		TopNButton.setBounds(260,22,70,25);
		
		Result=new JTextArea(10,25);
		this.add(ScrollPane1=new JScrollPane(Result));
		ScrollPane1.setBounds(20,60,400,220);
		
		this.add(Label2=new JLabel("查询相关分布："));
		Label2.setBounds(20,308,100,15);
		this.add(WordText=new JTextField(5));
		WordText.setBounds(110,300,80,30);
		this.add(WordButton=new JButton("确定"));
		WordButton.setBounds(200,300,70,25);
		
		this.add(Label3=new JLabel("作者分布："));
		Label3.setBounds(20,345,100,15);
		this.add(Label4=new JLabel("期刊分布："));
		Label4.setBounds(250,345,100,15);
		this.add(Label5=new JLabel("机构分布："));
		Label5.setBounds(480,345,100,15);

		Result1=new JTextArea(10,10);
		this.add(ScrollPane2=new JScrollPane(Result1));
		ScrollPane2.setBounds(20,370,220,220);
		Result2=new JTextArea(10,10);
		this.add(ScrollPane3=new JScrollPane(Result2));
		ScrollPane3.setBounds(250,370,220,220);
		Result3=new JTextArea(10,10);
		this.add(ScrollPane4=new JScrollPane(Result3));
		ScrollPane4.setBounds(480,370,250,220);
		
		TopNListener=new TopNListen();
		TopNListener.setJTextField(TopNText);
		TopNListener.setJTextArea(Result);
		TopNButton.addActionListener(TopNListener);
		
		WordListener=new WordListen();
		WordListener.setJTextField(WordText);
		WordListener.setJTextArea1(Result1);
		WordListener.setJTextArea2(Result2);
		WordListener.setJTextArea3(Result3);
		WordButton.addActionListener(WordListener);
		
	}
}
