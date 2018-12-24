package importInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;

public class Count {
	String list;
	Count(String name){
		list = name;
	}
	public void count() throws Exception{
		  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	   	  Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb");
	   	  Statement sql=con.createStatement();
	      //sql.execute("create table ke(ID int identity,key varchar(160),frequency int)");   //建表
	   	  
	   	  ResultSet rs=sql.executeQuery("select * from CNKI");
	   	 
	   	  ArrayList<String> temp = new ArrayList<String>();
	      ArrayList<String> result = new ArrayList<String>();
	   	  
	      //将CNKI表中的Keywords数据存放在数组temp中；
	   	  while(rs.next()) {
	   		  String temp1 = rs.getString(list);                //改
	   		  
	   		  if(temp1!=null) {	   			
	   			  String [] temp2 = temp1.split(";+");		
	   			  
		   		  for(String j:temp2) {  //j是数组中的每一个值
		   			  temp.add(j);
		   		  } 
	   		  }  	 
	   	  }
	   	  
	   	  result = quChong(temp);  //去重
	   	  list = list.replace(" ", "");

	   	  //将数组中数据导入数据库                                                                                                                    改
	   	  sql.execute("create table frequency"+list+"(ID int identity,"+list+" varchar(200),frequency int)");   //建表
	   	  
	   	  //ID+关键词+词频
	   	  int i = 1;  //j关键词频
	  	  ListIterator<String> it1 = result.listIterator();
	   	  
	  	  while(it1.hasNext()) {
	   		String str = it1.next();
	   		ListIterator<String> it2 = temp.listIterator();
	   		int j = 0;
	   		
	   		while(it2.hasNext()) {
	   			
	   			String str2=it2.next();
	   			if(str.equals(str2)) {
	   				j++;
	   			}	   			
	   		}

	   		sql.executeUpdate("insert into frequency"+list+" values("+i+",'"+str+"',"+j+")");         //改
	   		i++;
	   		
	   	  }
	  	  System.out.println("table "+list+" have finished");
	   	  sql.close();
	   	  con.close();
	}
	//去重
			public static ArrayList<String> quChong(ArrayList<String> list) {
				ArrayList<String> temp1 = new ArrayList<String>();
				ListIterator<String> it = list.listIterator();
				while(it.hasNext()) {
					String temp2 = it.next();
					if(!temp1.contains(temp2)) {
						temp1.add(temp2);
					}
				}
				return temp1;
			}

}
