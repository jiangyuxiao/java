package WordCooccurrence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class KeywordQuery {
	public StringBuffer queryone(String str1,String str2) throws Exception{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		StringBuffer topn = new StringBuffer();
		ResultSet rs=stmt.executeQuery("select top 10 * from "+str1+" where Keywords='"+str2+"' order by frequency DESC");
		int a=0,i,j=-1;
		if(rs.next()) {
			rs.previous();
			while(rs.next()) {
				i=j;
				j=rs.getInt("frequency");
				if(i!=j) {
					a++;
				}
				topn.append(a+" "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString("frequency")+"\n");
				}
		}else {
			topn.append("请输入正确的关键词名称！\n");
		}
		stmt.close();
		con.close();
		return topn;
	}
}
