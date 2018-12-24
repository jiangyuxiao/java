package CollaborateOrganization;

import java.awt.event.*;
import javax.swing.*;

public class OrganizationListen implements ActionListener {
	JTextField textInput;
	JTextArea textShow1,textShow2,textShow3;
	
	public void setJTextField(JTextField text) {
		textInput=text;
	}
	
	public void setJTextArea1(JTextArea area) {
		textShow1=area;
	}
	
	public void setJTextArea2(JTextArea area) {
		textShow2=area;
	}
	
	public void setJTextArea3(JTextArea area) {
		textShow3=area;
	}
	
	public void actionPerformed(ActionEvent e) {
		String str=textInput.getText();
		OrganizationQuery oq = new OrganizationQuery();
		try {   //传入查询列名、机构名称、查询数目
			textShow1.append(oq.queryone("cooccurrenceAuthorAddressAuthor", str, 10).toString());
			textShow2.append(oq.queryone("cooccurrenceAuthorAddressJournal", str, 10).toString());
			textShow3.append(oq.queryone("cooccurrenceKeywordsAuthorAddress", str, 30).toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
}