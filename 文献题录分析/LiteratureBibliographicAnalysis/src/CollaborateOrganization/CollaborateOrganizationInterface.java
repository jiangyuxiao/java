package CollaborateOrganization;
import javax.swing.*;
public class CollaborateOrganizationInterface extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JTextField TopNText,OrganizationText;
	JButton TopNButton,OrganizationButton;
	JTextArea Result,Result1,Result2,Result3;
	TopNListen TopNListener;
	OrganizationListen OrganizationListener;
	JLabel Label1,Label2,Label3,Label4,Label5; 
	JScrollPane ScrollPane1,ScrollPane2,ScrollPane3,ScrollPane4;
	
	public CollaborateOrganizationInterface() {
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	void init() {
		this.setLayout(null);
		this.add(Label1=new JLabel("查询TopN个机构合作信息："));
		Label1.setBounds(20,30,250,15);
		this.add(TopNText=new JTextField(5));
		TopNText.setBounds(185,22,80,30);
		this.add(TopNButton=new JButton("确定"));
		TopNButton.setBounds(275,22,70,25);
		
		Result=new JTextArea(10,25);
		this.add(ScrollPane1=new JScrollPane(Result));
		ScrollPane1.setBounds(20,60,600,220);
		
		this.add(Label2=new JLabel("查询相关分布："));
		Label2.setBounds(20,308,100,15);
		this.add(OrganizationText=new JTextField(10));
		OrganizationText.setBounds(110,300,170,30);
		this.add(OrganizationButton=new JButton("确定"));
		OrganizationButton.setBounds(290,300,70,25);
		
		this.add(Label3=new JLabel("作者分布："));
		Label3.setBounds(20,345,100,15);
		this.add(Label4=new JLabel("期刊分布："));
		Label4.setBounds(250,345,100,15);
		this.add(Label5=new JLabel("关键词分布："));
		Label5.setBounds(480,345,100,15);

		Result1=new JTextArea(10,10);
		this.add(ScrollPane2=new JScrollPane(Result1));
		ScrollPane2.setBounds(20,370,220,220);
		Result2=new JTextArea(10,10);
		this.add(ScrollPane3=new JScrollPane(Result2));
		ScrollPane3.setBounds(250,370,220,220);
		Result3=new JTextArea(10,10);
		this.add(ScrollPane4=new JScrollPane(Result3));
		ScrollPane4.setBounds(480,370,270,220);
		
		TopNListener=new TopNListen();
		TopNListener.setJTextField(TopNText);
		TopNListener.setJTextArea(Result);
		TopNButton.addActionListener(TopNListener);		
		
		OrganizationListener=new OrganizationListen();
		OrganizationListener.setJTextField(OrganizationText);
		OrganizationListener.setJTextArea1(Result1);
		OrganizationListener.setJTextArea2(Result2);
		OrganizationListener.setJTextArea3(Result3);
		OrganizationButton.addActionListener(OrganizationListener);
	
	}
}