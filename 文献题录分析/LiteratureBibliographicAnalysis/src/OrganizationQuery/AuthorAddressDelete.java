package OrganizationQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AuthorAddressDelete {
	String a;
	int d;
	AuthorAddressDelete(String b){
		a = b;
	}
	public void delete()throws Exception {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement();
		d=stmt.executeUpdate("delete from frequencyAuthorAddress where AuthorAddress='"+a+"'");
		stmt.close();
		con.close();
	}
	public String getMessage() {
		if(d>0){
			return("删除机构\""+a+"\"成功");
		}else{
			return("请输入正确的机构名称！");
		}
	}
}
