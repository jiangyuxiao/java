package OrganizationQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AuthorAddressCorrection {
	String before;
	String after;
	int u,d;
	AuthorAddressCorrection(String a,String b) {
		before = a;
		after = b;
	}
	public void correction()throws Exception {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement();	
		u=stmt.executeUpdate("update frequencyAuthorAddress set frequency=frequency+(select frequency from frequencyAuthorAddress where AuthorAddress='"+before+"') where AuthorAddress='"+after+"'");
		d=stmt.executeUpdate("delete from frequencyAuthorAddress where AuthorAddress='"+before+"'");
		stmt.close();
		con.close();
	}
	public String getMessage(){
		if(u>0&&d>0){
			return("����\""+before+"\"�ɹ�����Ϊ����\""+after+"\"");
		}else{
			return("��������ȷ�Ļ������ƣ�");
		}
	}

}

