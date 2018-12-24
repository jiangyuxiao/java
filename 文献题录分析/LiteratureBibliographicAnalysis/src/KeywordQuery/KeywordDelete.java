package KeywordQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class KeywordDelete {
	String a;
	int d;
	KeywordDelete(String b){
		a = b;    //构造函数，传入需要删除的关键词名称
	}
	public void delete()throws Exception {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement();
		d=stmt.executeUpdate("delete from frequencyKeywords where Keywords='"+a+"'");  
		//返回一个int类型结果，表示受影响行数，如果结果小于或者等于0，则表示失败
		//删除语句，int b 用于判断删除语句是否成功执行
		stmt.close();
		con.close();
	}
	public String getMessage() {   //反馈执行结果信息
		if(d>0){
			return("删除关键词\""+a+"\"成功");
		}else{
			return("请输入正确的关键词！");
		}
	}
}
