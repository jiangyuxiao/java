package CollaborateOrganization;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class CoorganizationQuery {
	public StringBuffer querytopn(int n) throws Exception{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement();
		StringBuffer topn = new StringBuffer();
		ResultSet rs=stmt.executeQuery("select top "+n+" * from cooccurrenceAuthorAddress order by frequency DESC");  //��ѯ���
		int a=0,i,j=-1;
		while(rs.next()) {
			i=j;
			j=rs.getInt("frequency");
			if(i!=j) {
				a++;   //��ŵ�����ͬƵ�εĻ������������ͬ
			}
			topn.append(a+" "+rs.getString("AuthorAddress1")+"  "+rs.getString("AuthorAddress2")+"  "+rs.getString("frequency")+"\n");
			//������-����1-����2-����Ƶ��
		}
		stmt.close();
		con.close();
		return topn;  //���ز�ѯ���
	}
}
