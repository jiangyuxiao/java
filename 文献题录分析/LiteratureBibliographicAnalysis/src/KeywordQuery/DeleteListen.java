package KeywordQuery;
import java.awt.event.*;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DeleteListen implements ActionListener {
	JTextField textInput;
	JTextArea textShow;
	
	public void setJTextField(JTextField text) {
		textInput=text;
	}
	
	public void setJTextArea(JTextArea area) {
		textShow=area;
	}
	
	public void actionPerformed(ActionEvent e) {
		String str = textInput.getText();
		KeywordDelete kd = new KeywordDelete(str);
		try {
			kd.delete();     //����ɾ���ؼ��ʺ���
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textShow.append(kd.getMessage()+"\n");   //����ִ�н��
	}
}
