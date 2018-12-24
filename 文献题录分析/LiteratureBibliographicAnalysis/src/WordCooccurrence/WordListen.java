package WordCooccurrence;

import java.awt.event.*;
import javax.swing.*;

public class WordListen implements ActionListener {
	JTextField textInput;
	JTextArea textShow1,textShow2,textShow3;
	
	public void setJTextField(JTextField text) {
		textInput=text;
	}
	
	public void setJTextArea1(JTextArea area) {
		textShow1=area;
	}
	
	public void setJTextArea2(JTextArea area) {
		textShow2=area;
	}
	
	public void setJTextArea3(JTextArea area) {
		textShow3=area;
	}
	
	public void actionPerformed(ActionEvent e) {
		String str=textInput.getText();
		KeywordQuery kq = new KeywordQuery();
		try {
			textShow1.append(kq.queryone("cooccurrenceKeywordsAuthor", str).toString());
			textShow2.append(kq.queryone("cooccurrenceKeywordsJournal", str).toString());
			textShow3.append(kq.queryone("cooccurrenceKeywordsAuthorAddress", str).toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
}

