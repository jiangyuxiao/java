package KeywordQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class KeywordDelete {
	String a;
	int d;
	KeywordDelete(String b){
		a = b;    //���캯����������Ҫɾ���Ĺؼ�������
	}
	public void delete()throws Exception {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement();
		d=stmt.executeUpdate("delete from frequencyKeywords where Keywords='"+a+"'");  
		//����һ��int���ͽ������ʾ��Ӱ��������������С�ڻ��ߵ���0�����ʾʧ��
		//ɾ����䣬int b �����ж�ɾ������Ƿ�ɹ�ִ��
		stmt.close();
		con.close();
	}
	public String getMessage() {   //����ִ�н����Ϣ
		if(d>0){
			return("ɾ���ؼ���\""+a+"\"�ɹ�");
		}else{
			return("��������ȷ�Ĺؼ��ʣ�");
		}
	}
}
