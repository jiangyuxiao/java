package CollaborateOrganization;

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
		String str=textInput.getText();
		int n = Integer.parseInt(str);
		CoorganizationQuery oq = new CoorganizationQuery();
		try {
			textShow.append(oq.querytopn(n).toString());
			//调用查询函数，传值，并输出查询信息
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}