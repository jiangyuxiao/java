package KeywordQuery;

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
		//转换为int型，作为函数的传入值
		FrequencyQuery fq = new FrequencyQuery();
		try {
			textShow.append(fq.querytopn(n).toString());   
			//调用查询TOP N个关键词词频函数，并转化为String类用于输出
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
