package importInterface;
import java.awt.event.*;
import javax.swing.JTextArea;


public class buildListen implements ActionListener {
	
	JTextArea textShow;
	String txt;

	public void setOutputJTextArea(JTextArea area) {
		textShow=area;
	}
	
	public void actionPerformed(ActionEvent e) {

		try {
			//Ƶ�ʱ�frequency...
			Count keyWords = new Count("Keywords");
			Count author = new Count("Author");
			Count authorAddress = new Count("Author Address");
			keyWords.count();
			author.count();
			authorAddress.count();
			
			//���ֱ�...(�ؼ��ʸ��ؼ���..)
			Cooccurrence KeyWords = new Cooccurrence("Keywords");
			Cooccurrence Author = new Cooccurrence("Author");
			Cooccurrence AuthorAddress = new Cooccurrence("Author Address");
			KeyWords.cooccurrence();
			Author.cooccurrence();
			AuthorAddress.cooccurrence();
			
			//���ֱ�...(�ؼ��ʸ�����...[�������ڿ�journal])
			Cooccurrence2 keyWords_author = new Cooccurrence2("Keywords","Author");
			keyWords_author.cooccurrence2();  //over		
			Cooccurrence2 keyWords_authorAddress = new Cooccurrence2("Keywords","Author Address");
			keyWords_authorAddress.cooccurrence2();//over		
			Cooccurrence2 authorAdress_author = new Cooccurrence2("Author Address","Author");
			authorAdress_author.cooccurrence2();  
			
			//���ֱ�...(�ؼ��ʸ��ڿ����������ڿ����������õĺ����ǲ�ͬ��)
			Cooccurrence2 authorAdress_journal = new Cooccurrence2("Author Address","Journal");
			authorAdress_journal.cooccurrence3();//over
			Cooccurrence2 keyWords_journal = new Cooccurrence2("Keywords","Journal");
			keyWords_journal.cooccurrence3();//over
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textShow.append("����ɹ���");
		
	}

}
