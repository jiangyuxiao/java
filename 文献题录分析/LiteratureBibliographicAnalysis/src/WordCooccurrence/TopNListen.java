package WordCooccurrence;

import java.awt.event.*;
import javax.swing.*;

public class TopNListen implements ActionListener {
	JTextField textInput;
	JTextArea textShow;
	
	public void setJTextField(JTextField text) {
		textInput=text;
	}
	
	public void setJTextArea(JTextArea area) {
		textShow=area;
	}
	
	public void actionPerformed(ActionEvent e) {
		String str =textInput.getText();
		int n=Integer.parseInt(str);
		CokeywordQuery kq = new CokeywordQuery();		
		try {
			textShow.append(kq.querytopn(n).toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
}