package OrganizationQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class FrequencyQuery {
	String singlenum = new String();
	public void queryone(String str) throws Exception{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select frequency from frequencyAuthorAddress where AuthorAddress='"+str+"'");
		if(rs.next()) {
			singlenum = rs.getString("frequency");
		}else {
				singlenum = "0";
		}
		stmt.close();
		con.close();
	}
	public StringBuffer querytopn(int n) throws Exception{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement();
		StringBuffer topn = new StringBuffer();
		ResultSet rs=stmt.executeQuery("select top "+n+" * from frequencyAuthorAddress order by frequency DESC");
		int a=0,i,j=-1;
		while(rs.next()) {
			i=j;
			j=rs.getInt("frequency");
			if(i!=j) {
				a++;
			}
			topn.append(a+" "+rs.getString("AuthorAddress")+"  "+rs.getString("frequency")+"\n");
		}
		stmt.close();
		con.close();
		return topn;
	}
}

