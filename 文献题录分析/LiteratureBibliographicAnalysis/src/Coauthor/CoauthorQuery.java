package Coauthor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class CoauthorQuery {
	public StringBuffer querytopn(int n) throws Exception{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement();
		StringBuffer topn = new StringBuffer();
		ResultSet rs=stmt.executeQuery("select top "+n+" * from cooccurrenceAuthor order by frequency DESC");
		int a=0,i,j=-1;
		while(rs.next()) {
			i=j;
			j=rs.getInt("frequency");
			if(i!=j) {
				a++;
			}
			topn.append(a+" "+rs.getString("Author1")+"  "+rs.getString("Author2")+"  "+rs.getString("frequency")+"\n");
		}
		stmt.close();
		con.close();
		return topn;
	}
}
