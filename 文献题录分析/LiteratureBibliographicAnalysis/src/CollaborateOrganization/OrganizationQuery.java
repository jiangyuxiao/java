package CollaborateOrganization;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class OrganizationQuery {
	public StringBuffer queryone(String str1,String str2,int n) throws Exception{      
		//��һ������Ϊ�������ڶ���Ϊ�������ƣ�������Ϊ��ѯ�����Ŀ�����ߡ��ڿ��ֲ�ǰ10�����ؼ��ʷֲ�ǰ30��
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		StringBuffer topn = new StringBuffer();  //ʹ��StringBuffer�洢N����ѯ���
		ResultSet rs=stmt.executeQuery("select top "+n+" * from "+str1+" where AuthorAddress='"+str2+"' order by frequency DESC"); 
		//��ѯ���
		int a=0,i,j=-1;
		if(rs.next()) {    //�жϲ�ѯ������Ƿ��м�¼
			rs.previous();     //���ص�һ����¼���������
			while(rs.next()) {
				i=j;
				j=rs.getInt("frequency");
				if(i!=j) {
					a++;
				}
			topn.append(a+" "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString("frequency")+"\n"); 
			//������-����-�ڿ�/����/�ؼ���-Ƶ��
			}
		}else {
			topn.append("��������ȷ�Ļ������ƣ�\n");     //���ݿ��в����ڸû�������
		}
		stmt.close();
		con.close();
		return topn;     //���ز�ѯ���
	}
}
