package KeywordQuery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

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
			String str =textInput.getText();   //输入需要查询的关键词名称
			FrequencyQuery fq = new FrequencyQuery();  //实例化一个关键词频次查询类
			try {
				fq.queryone(str);    //调用查询单个关键词频次的函数
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			textShow.append(str+"的频次是"+fq.singlenum+"\n");
		
		}

}

