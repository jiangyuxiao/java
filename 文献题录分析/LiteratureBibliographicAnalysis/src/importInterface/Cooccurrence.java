package importInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;

public class Cooccurrence {
	
	String list;
	Cooccurrence(String name){
		list = name;
	}
	public void cooccurrence() throws Exception{
		  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	   	  Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb");
	   	  Statement sql=con.createStatement();	    
	   	  //建表
	   	  sql.execute("create table cooccurrence"+list.replace(" ", "")+"(ID int identity,"+list.replace(" ", "")+"1 varchar(200),"+list.replace(" ", "")+"2 varchar(200),frequency int)");   
	   	  
	   	  ResultSet rs=sql.executeQuery("select * from CNKI");
	      ResultSet rsKeyWords=sql.executeQuery("select * from frequency"+list.replace(" ", ""));

	      ArrayList<String> keyWords = new ArrayList<String>();
	      ArrayList<String> cnki = new ArrayList<String>(); 
	  	
	      //将CNKI表中的Keywords数据存放在数组cnki中；
	   	  while(rs.next()) {
	   		  String temp1 = ";"+rs.getString(list)+";";                //改
	   		  
	   		  if(temp1!=null) {	   				   			  
		   			 cnki.add(temp1);		   		   
	   		  }  	 
	   	  }
	      //将frequency表中的Keywords数据存放在数组keywords中；
	   	  while(rsKeyWords.next()) {
	   		  String temp2 = rsKeyWords.getString(list.replace(" ", ""));                //改	   		  
	   		  keyWords.add(temp2);	   		 
	   	  }	 	   	  
	   	  //将数组中数据导入数据库                                                                                                                    改
	   	 	   	  
	   	  //ID+关键词1+关键词2+共现次数 
	   	  ListIterator<String> it1 = keyWords.listIterator();
	   	  int i=0,j=1;
	  	  while(it1.hasNext()){	  
	   		String kw1 = it1.next();
	  		int frequency = 0;
	   		ListIterator<String> it2 = keyWords.listIterator(j);  //1,2,3...
	   		while(it2.hasNext()) {
	   			frequency=0;
	   			
	   			String kw2 = it2.next();
	   			ListIterator<String> it3 = cnki.listIterator();
	   			
	   			while(it3.hasNext()) {
	   				String kw3 = it3.next();
	   				if(kw3!=null && kw3.contains(";"+kw1+";") && kw3.contains(";"+kw2+";")) {	
			   			//System.out.println(kw1+" "+kw2);
			   			frequency++;		   					   					   		 
				   	}  
	   			}
	   			//System.out.println(kw1+"; "+kw2+";"+keyWords.indexOf(kw2)+"; "+frequency);
	   			if(frequency>0) {
	   				i++;
	   				sql.executeUpdate("insert into cooccurrence"+list.replace(" ", "")+" values("+i+",'"+kw1+"','"+kw2+"',"+frequency+")");         //改（字符串型加单引号）	   		
	   			}
	   		}
	   		j++;			   		
	   	  }
	  	  
	   	  sql.close();
	   	  con.close();
	}
	
}
