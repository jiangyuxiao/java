package KeywordQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class KeywordCorrection {
	String before;
	String after;
	int u,d;
	KeywordCorrection(String a,String b) {
		before = a;  //���캯����before����Ҫ�����Ĺؼ���
		after = b;  //after��������Ĺؼ���
	}
	public void correction()throws Exception {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement();	
		u=stmt.executeUpdate("update frequencyKeywords set frequency=frequency+"
				+ "(select frequency from frequencyKeywords where Keywords='"+before+"') "
				+ "where Keywords='"+after+"'");   //�������
		d=stmt.executeUpdate("delete from frequencyKeywords where Keywords='"+before+"'"); 
		//ɾ�����
		stmt.close();
		con.close();
	}
	public String getMessage(){    //����ִ�н��
		if(u>0&&d>0){
			return("�ؼ���\""+before+"\"�ɹ�����Ϊ�ؼ���\""+after+"\"");
			//��������ɾ�����Գɹ�ִ���������ɹ�
		}else{
			return("��������ȷ�Ĺؼ��ʣ�");
		}
	}
}
