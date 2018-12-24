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
			String str =textInput.getText();   //������Ҫ��ѯ�Ĺؼ�������
			FrequencyQuery fq = new FrequencyQuery();  //ʵ����һ���ؼ���Ƶ�β�ѯ��
			try {
				fq.queryone(str);    //���ò�ѯ�����ؼ���Ƶ�εĺ���
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			textShow.append(str+"��Ƶ����"+fq.singlenum+"\n");
		
		}

}

