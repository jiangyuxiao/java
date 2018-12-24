package KeywordQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class FrequencyQuery {
	String singlenum = new String();  //输入查询关键词
	public void queryone(String str) throws Exception{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		//使用ucanaccess连接Access数据库
		Statement stmt=con.createStatement(); //创建Statement对象
		ResultSet rs=stmt.executeQuery("select frequency from frequencyKeywords where Keywords='"+str+"'");
		//使用ResultSet接收数据库查询结果
		if(rs.next()) {
			singlenum = rs.getString("frequency");  //数据库中存在该关键词则输出频次
		}else {
				singlenum = "0";  //若数据库中不存在该关键词，则频次为0
		}
		stmt.close();  //在每一个对于数据库的操作完成之后都要关闭Statement对象
		con.close();  //在每一个对于数据库的操作完成之后都要关闭Connection对象
	}
	public StringBuffer querytopn(int n) throws Exception{   //输入TOP N
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement();
		StringBuffer topn = new StringBuffer();  //使用StringBuffer存储TOP N个关键词词频查询结果
		ResultSet rs=stmt.executeQuery("select top "+n+" * from frequencyKeywords order by frequency DESC");
		//按词频降序查询
		int a=0,i,j=-1;
		while(rs.next()) {
			i=j;
			j = rs.getInt("frequency");
			if(i!=j) {
				a++;       //序号递增，同频次的关键词序号相同
			}
			topn.append(a+" "+rs.getString("Keywords")+"  "+rs.getString("frequency")+"\n");
			//StringBuffer便于修改和输出，输出序号-关键词-词频
		}
		stmt.close();
		con.close();
		return topn;
	}
}
