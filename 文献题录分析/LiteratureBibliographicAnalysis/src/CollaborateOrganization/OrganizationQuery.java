package CollaborateOrganization;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class OrganizationQuery {
	public StringBuffer queryone(String str1,String str2,int n) throws Exception{      
		//第一个变量为表名，第二个为机构名称，第三个为查询结果数目，作者、期刊分布前10名，关键词分布前30名
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb","","");
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		StringBuffer topn = new StringBuffer();  //使用StringBuffer存储N个查询结果
		ResultSet rs=stmt.executeQuery("select top "+n+" * from "+str1+" where AuthorAddress='"+str2+"' order by frequency DESC"); 
		//查询语句
		int a=0,i,j=-1;
		if(rs.next()) {    //判断查询结果集是否有记录
			rs.previous();     //返回第一条记录，按序输出
			while(rs.next()) {
				i=j;
				j=rs.getInt("frequency");
				if(i!=j) {
					a++;
				}
			topn.append(a+" "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString("frequency")+"\n"); 
			//输出序号-机构-期刊/作者/关键词-频次
			}
		}else {
			topn.append("请输入正确的机构名称！\n");     //数据库中不存在该机构名称
		}
		stmt.close();
		con.close();
		return topn;     //返回查询结果
	}
}
