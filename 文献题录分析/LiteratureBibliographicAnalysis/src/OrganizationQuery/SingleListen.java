package OrganizationQuery;

import java.awt.event.*;
import javax.swing.*;

public class SingleListen implements ActionListener {
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
		FrequencyQuery fq = new FrequencyQuery();
		try {
			fq.queryone(str);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textShow.append(str+"µÄÆµ´ÎÊÇ"+fq.singlenum+"\n");
	}

}