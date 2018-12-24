package KeywordQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class FrequencyQuery {
	String singlenum = new String();  //�����ѯ�ؼ���
	public void queryone(String str) throws Exception{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		//ʹ��ucanaccess����Access���ݿ�
		Statement stmt=con.createStatement(); //����Statement����
		ResultSet rs=stmt.executeQuery("select frequency from frequencyKeywords where Keywords='"+str+"'");
		//ʹ��ResultSet�������ݿ��ѯ���
		if(rs.next()) {
			singlenum = rs.getString("frequency");  //���ݿ��д��ڸùؼ��������Ƶ��
		}else {
				singlenum = "0";  //�����ݿ��в����ڸùؼ��ʣ���Ƶ��Ϊ0
		}
		stmt.close();  //��ÿһ���������ݿ�Ĳ������֮��Ҫ�ر�Statement����
		con.close();  //��ÿһ���������ݿ�Ĳ������֮��Ҫ�ر�Connection����
	}
	public StringBuffer querytopn(int n) throws Exception{   //����TOP N
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement();
		StringBuffer topn = new StringBuffer();  //ʹ��StringBuffer�洢TOP N���ؼ��ʴ�Ƶ��ѯ���
		ResultSet rs=stmt.executeQuery("select top "+n+" * from frequencyKeywords order by frequency DESC");
		//����Ƶ�����ѯ
		int a=0,i,j=-1;
		while(rs.next()) {
			i=j;
			j = rs.getInt("frequency");
			if(i!=j) {
				a++;       //��ŵ�����ͬƵ�εĹؼ��������ͬ
			}
			topn.append(a+" "+rs.getString("Keywords")+"  "+rs.getString("frequency")+"\n");
			//StringBuffer�����޸ĺ������������-�ؼ���-��Ƶ
		}
		stmt.close();
		con.close();
		return topn;
	}
}
