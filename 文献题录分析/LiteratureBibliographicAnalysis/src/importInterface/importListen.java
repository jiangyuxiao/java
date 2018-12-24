package importInterface;

import java.awt.event.*;
import javax.swing.*;
import MainInterface.Import;

public class importListen implements ActionListener {
	JTextArea textInput;
	JTextArea textShow;
	
	public void setInputJTextArea(JTextArea text) {
		textInput=text;
	}
	
	public void setOutputJTextArea(JTextArea area) {
		textShow=area;
	}
	
	public void actionPerformed(ActionEvent e) {
		String str = textInput.getText();
		Import file = new Import(str);
		try {
			file.imported();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textShow.append("导入成功！");//修改
		
	}
}

