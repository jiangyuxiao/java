package MainInterface;

import java.awt.*;
import javax.swing.*;

public class MainInterface extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JButton KeyWordButton,AuthorButton,OrganizationButton,WordCooccurrenceButton,CoauthorButton,CollaborateOrganizationButton;
	JLabel title,Label1,Label2,bgLabel,label11,label12,label13,label14,label15,label16; 
	AuthorListen AuthorListener;
	CoauthorListen CoauthorListener;
	CollaborateOrganizationListen CollaborateOrganizationListener;
	KeyWordListen KeyWordListener;
	OrganizationListen OrganizationListener;
	WordCooccurrenceListen WordCooccurrenceListener;
	ImportListen ImportListener;
	JMenuBar mb;
	JMenu m;
	JMenuItem mt;
	ImageIcon background,img1,img2,img3,img4,img5,img6;
	JPanel jp,panel;
	
	public MainInterface() {
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void init() {
		this.setLayout(null);
		
		background=new ImageIcon("background.jpg");
		bgLabel=new JLabel(background);
		bgLabel.setBounds(0,0,700,700);
		this.getLayeredPane().add(bgLabel,new Integer(Integer.MIN_VALUE));
		jp=(JPanel)this.getContentPane();
		jp.setOpaque(false);
		
		mb=new JMenuBar();
		mb.add(m=new JMenu("开始"));
		m.add(mt=new JMenuItem("导入"));
		this.setJMenuBar(mb);
		
		this.add(title=new JLabel("文献题录分析软件"));
		title.setFont(new Font("黑体",1,30));
		title.setForeground(Color.white);
		title.setBounds(230,40,300,30);
		
		//图标
		img1=new ImageIcon("word.png");
		Image img21=img1.getImage();
		img21=img21.getScaledInstance(60,50,Image.SCALE_DEFAULT);
		img1.setImage(img21);
		label11=new JLabel(img1);
		label11.setBounds(100,140,70,50);
		this.add(label11);
		
		img2=new ImageIcon("author.png");
		Image img22=img2.getImage();
		img22=img22.getScaledInstance(60,50,Image.SCALE_DEFAULT);
		img2.setImage(img22);
		label12=new JLabel(img2);
		label12.setBounds(300,140,70,50);
		this.add(label12);
		
		img3=new ImageIcon("organization.png");
		Image img23=img3.getImage();
		img23=img23.getScaledInstance(60,50,Image.SCALE_DEFAULT);
		img3.setImage(img23);
		label13=new JLabel(img3);
		label13.setBounds(500,140,70,50);
		this.add(label13);
		
		img4=new ImageIcon("coword.png");
		Image img24=img4.getImage();
		img24=img24.getScaledInstance(60,50,Image.SCALE_DEFAULT);
		img4.setImage(img24);
		label14=new JLabel(img4);
		this.add(label14);
		label14.setBounds(100,340,70,50);
		
		img5=new ImageIcon("coauthor.png");
		Image img25=img5.getImage();
		img25=img25.getScaledInstance(60,50,Image.SCALE_DEFAULT);
		img5.setImage(img25);
		label15=new JLabel(img5);
		this.add(label15);
		label15.setBounds(300,340,70,50);
		
		img6=new ImageIcon("coorganization.png");
		Image img26=img6.getImage();
		img26=img26.getScaledInstance(60,50,Image.SCALE_DEFAULT);
		img6.setImage(img26);
		label16=new JLabel(img6);
		this.add(label16);
		label16.setBounds(500,340,70,50);
		
		
		//this.add(Label1=new JLabel("统计功能"));
		//Label1.setBounds(20,120,350,20);
		//Label1.setFont(new Font("宋体",1,20));
		this.add(KeyWordButton=new JButton("关键词词频查询"));
		KeyWordButton.setBounds(60,200,150,40);
		this.add(AuthorButton=new JButton("作者频次查询"));
		AuthorButton.setBounds(260,200,150,40);
		this.add(OrganizationButton=new JButton("机构频次查询"));
		OrganizationButton.setBounds(460,200,150,40);
		
		//this.add(Label2=new JLabel("分析功能"));
		//Label2.setBounds(20,280,350,20);
		//Label2.setFont(new Font("宋体",1,20));
		this.add(WordCooccurrenceButton=new JButton("关键词分析"));
		WordCooccurrenceButton.setBounds(60,400,150,40);
		this.add(CoauthorButton=new JButton("作者合著分析"));
		CoauthorButton.setBounds(260,400,150,40);
		this.add(CollaborateOrganizationButton=new JButton("机构分析"));
		CollaborateOrganizationButton.setBounds(460,400,150,40);

		AuthorListener=new AuthorListen();
	    AuthorButton.addActionListener(AuthorListener);
	    
	    KeyWordListener=new KeyWordListen();
	    KeyWordButton.addActionListener(KeyWordListener);
	    
	    CoauthorListener=new CoauthorListen();
	    CoauthorButton.addActionListener(CoauthorListener);
	    
	    CollaborateOrganizationListener=new CollaborateOrganizationListen();
	    CollaborateOrganizationButton.addActionListener(CollaborateOrganizationListener);
	    
	    OrganizationListener=new OrganizationListen();
	    OrganizationButton.addActionListener(OrganizationListener);
	    
	    WordCooccurrenceListener=new WordCooccurrenceListen();
	    WordCooccurrenceButton.addActionListener(WordCooccurrenceListener);
	    
	    ImportListener=new ImportListen();
	    mt.addActionListener(ImportListener);
	    
	}
}
