package KeywordQuery;
import java.awt.*;
import javax.swing.*;
public class WordFrequencyQueryInterface extends JFrame {
	/**
	 * 
	 */
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

	public WordFrequencyQueryInterface() {
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	void init() {
		this.setLayout(null);
		this.add(Label1=new JLabel("关键词频统计"));
		Label1.setFont(new Font("黑体",1,15));
		Label1.setBounds(20,20,380,15);
		this.add(Label2=new JLabel("查询单个词语词频："));
		Label2.setBounds(20,50,250,15);
		this.add(SingleText=new JTextField(5));
		SingleText.setBounds(160,42,80,30);
		this.add(SingleButton=new JButton("确定"));
		SingleButton.setBounds(255,42,70,25);
		this.add(Label3=new JLabel("查询TopN个词语词频："));
		Label3.setBounds(20,80,250,15);
		this.add(TopNText=new JTextField(5));
		TopNText.setBounds(160,72,80,30);
		this.add(TopNButton=new JButton("确定"));
		TopNButton.setBounds(255,72,70,25);
		
		Result=new JTextArea(15,25);
		this.add(ScrollPane=new JScrollPane(Result));
		ScrollPane.setBounds(20,110,350,350);
		
		this.add(Label4=new JLabel("关键词修正"));
		Label4.setFont(new Font("黑体",1,15));
		Label4.setBounds(20,490,380,15);
		this.add(Label5=new JLabel("删除单个词语："));
		Label5.setBounds(20,520,250,15);
		this.add(DeleteText=new JTextField(5));
		DeleteText.setBounds(120,512,80,30);
		this.add(DeleteButton=new JButton("确定"));
		DeleteButton.setBounds(215,512,70,25);
		this.add(Label6=new JLabel("将前者词语频次合并到后者词语中："));
		Label6.setBounds(20,550,300,15);
		this.add(CombineText1=new JTextField(5));
		this.add(CombineText2=new JTextField(5));
		CombineText1.setBounds(20,570,80,30);
		CombineText2.setBounds(110,570,80,30);
		this.add(CombineButton=new JButton("确定"));
		CombineButton.setBounds(205,570,70,25);
		
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