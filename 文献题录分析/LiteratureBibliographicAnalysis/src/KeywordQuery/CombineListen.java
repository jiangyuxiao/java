package KeywordQuery;

import java.awt.event.*;
import javax.swing.*;

public class CombineListen implements ActionListener {
	JTextField textInput1,textInput2;
	JTextArea textShow;
	
	public void setJTextField(JTextField text1,JTextField text2) {
		textInput1=text1;
		textInput2=text2;
	}
	
	public void setJTextArea(JTextArea area) {
		textShow=area;
	}
	
	public void actionPerformed(ActionEvent e) {
		String str1=textInput1.getText();
		String str2=textInput2.getText();
		KeywordCorrection kc = new KeywordCorrection(str1,str2);
		try {
			kc.correction();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textShow.append(kc.getMessage()+"\n");   //反馈执行结果	
	}
}
