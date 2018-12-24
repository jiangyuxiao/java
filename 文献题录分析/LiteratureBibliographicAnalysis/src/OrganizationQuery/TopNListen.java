package OrganizationQuery;

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
		FrequencyQuery fq = new FrequencyQuery();
		try {
			textShow.append(fq.querytopn(n).toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}