package KeywordQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class KeywordCorrection {
	String before;
	String after;
	int u,d;
	KeywordCorrection(String a,String b) {
		before = a;  //构造函数，before是需要修正的关键词
		after = b;  //after是修正后的关键词
	}
	public void correction()throws Exception {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement();	
		u=stmt.executeUpdate("update frequencyKeywords set frequency=frequency+"
				+ "(select frequency from frequencyKeywords where Keywords='"+before+"') "
				+ "where Keywords='"+after+"'");   //更新语句
		d=stmt.executeUpdate("delete from frequencyKeywords where Keywords='"+before+"'"); 
		//删除语句
		stmt.close();
		con.close();
	}
	public String getMessage(){    //反馈执行结果
		if(u>0&&d>0){
			return("关键词\""+before+"\"成功修正为关键词\""+after+"\"");
			//更新语句和删除语句皆成功执行则修正成功
		}else{
			return("请输入正确的关键词！");
		}
	}
}
