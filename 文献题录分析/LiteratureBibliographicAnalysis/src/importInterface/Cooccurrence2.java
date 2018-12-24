package importInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;

public class Cooccurrence2 {
	String list1,list2;
	Cooccurrence2(String name1,String name2){
		list1 = name1;
		list2 = name2;
	}
	public void cooccurrence2() throws Exception{
		  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	   	  Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb");
	   	  Statement sql=con.createStatement();	    
	   	  //建表
	   	  sql.execute("create table cooccurrence"+list1.replace(" ", "")+list2.replace(" ", "")+"(ID int identity,"+list1.replace(" ", "")+" varchar(100),"+list2.replace(" ", "")+" varchar(100),frequency int)");   
	   	  
	   	  ResultSet rs1=sql.executeQuery("select * from CNKI");
	      ResultSet rs2=sql.executeQuery("select * from frequency"+list1.replace(" ", ""));
	      ResultSet rs3=sql.executeQuery("select * from frequency"+list2.replace(" ", ""));

	      ArrayList<String> al11 = new ArrayList<String>();
	      ArrayList<String> al12 = new ArrayList<String>();
	      ArrayList<String> al2 = new ArrayList<String>(); 
	      ArrayList<String> al3 = new ArrayList<String>(); 
	  	
	      //将CNKI表中的Keywords数据存放在数组cnki中；
	   	  while(rs1.next()) {
	   		  String temp11 = ";"+rs1.getString(list1)+";";                //改	  
	   		  String temp12 = ";"+rs1.getString(list2)+";";
	   		  //String temp3 = rs1.getString(list2);
	   		  if(temp11!=null && temp12!=null) {	   				   			  
		   			 al11.add(temp11);
		   			 al12.add(temp12);
		   			 //al3.add(temp3);
		   			 
	   		  }  	 
	   	  }
	   	 //al3 = quChong(al3);
	   	  
	      //将frequency表中的Keywords数据存放在数组keywords中；
	   	  while(rs2.next()) {
	   		  String temp2 = rs2.getString(list1.replace(" ", ""));                //改	   		  
	   		  al2.add(temp2);	   		 
	   	  }	 	   	  
	   	  
	     while(rs3.next()) {
	   		  String temp3 = rs3.getString(list2.replace(" ", ""));                //改	
	   		  
	   		  al3.add(temp3);	   		 
	   	  }
	   	  //将数组中数据导入数据库                                                                                                                    改
	   	 	   	  
	   	  //ID+关键词1+关键词2+共现次数 
	   	  ListIterator<String> it1 = al2.listIterator(0);
	   	  int i=0;
	  	  while(it1.hasNext()){	  
	  		String kw1 = it1.next();
	  		int frequency = 0;
	   		ListIterator<String> it2 = al3.listIterator(0);  //1,2,3...
	   		while(it2.hasNext()) {
	   			frequency=0;
	   			//System.out.println(2);
	   			String kw2 = it2.next();
	   			ListIterator<String> it31 = al11.listIterator(0);
	   			ListIterator<String> it32 = al12.listIterator(0);
	   			
	   			while(it31.hasNext() && it32.hasNext()) {
	   				String kw31 = it31.next();
	   				String kw32 = it32.next();
	   				if(kw31.contains(";"+kw1+";") && kw32.contains(";"+kw2+";")) {	
			   			//System.out.println(kw1+" "+kw2);
			   			frequency++;		   					   					   		 
				   	}  
	   			}
	   			//System.out.println(kw1+"; "+kw2+";"+keyWords.indexOf(kw2)+"; "+frequency);
	   			if(frequency>0) {
	   				i++;
	   				sql.executeUpdate("insert into cooccurrence"+list1.replace(" ", "")+list2.replace(" ", "")+" values("+i+",'"+kw1+"','"+kw2+"',"+frequency+")");         //改（字符串型加单引号）	   		
	   			}
	   			
	   		}
	   					   		
	   	  }
	  	  System.out.println("table "+list1+"and"+list2+" have finished");
	  	  
	   	  sql.close();
	   	  con.close();
	}
	
	public void cooccurrence3() throws Exception{
		  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	   	  Connection con=DriverManager.getConnection("jdbc:ucanaccess://Database.mdb");
	   	  Statement sql=con.createStatement();	    
	   	  //建表
	   	  sql.execute("create table cooccurrence"+list1.replace(" ", "")+list2.replace(" ", "")+"(ID int identity,"+list1.replace(" ", "")+" varchar(100),"+list2.replace(" ", "")+" varchar(100),frequency int)");   
	   	  
	   	  ResultSet rs1=sql.executeQuery("select * from CNKI");
	      ResultSet rs2=sql.executeQuery("select * from frequency"+list1.replace(" ", ""));
	      //ResultSet rs3=sql.executeQuery("select * from frequency"+list2.replace(" ", ""));

	      ArrayList<String> al11 = new ArrayList<String>();
	      ArrayList<String> al12 = new ArrayList<String>();
	      ArrayList<String> al2 = new ArrayList<String>(); 
	      ArrayList<String> al3 = new ArrayList<String>(); 
	  	
	      //将CNKI表中的Keywords数据存放在数组cnki中；
	   	  while(rs1.next()) {
	   		  String temp11 = ";"+rs1.getString(list1)+";";                //改	  
	   		  String temp12 = ";"+rs1.getString(list2)+";";
	   		  String temp3 = rs1.getString(list2);
	   		  if(temp11!=null && temp12!=null) {	   				   			  
		   			 al11.add(temp11);
		   			 al12.add(temp12);
		   			 al3.add(temp3);
		   			 
	   		  }  	 
	   	  }
	   	 al3 = quChong(al3);
	   	  
	      //将frequency表中的Keywords数据存放在数组keywords中；
	   	  while(rs2.next()) {
	   		  String temp2 = rs2.getString(list1.replace(" ", ""));                //改	   		  
	   		  al2.add(temp2);	   		 
	   	  }	 	   	  
	   	  
	     /*while(rs3.next()) {
	   		  String temp3 = rs3.getString(list2.replace(" ", ""));                //改	
	   		  
	   		  al3.add(temp3);	   		 
	   	  }*/
	   	  //将数组中数据导入数据库                                                                                                                    改
	   	 	   	  
	   	  //ID+关键词1+关键词2+共现次数 
	   	  ListIterator<String> it1 = al2.listIterator(0);
	   	  int i=0;
	  	  while(it1.hasNext()){	  
	  		String kw1 = it1.next();
	  		int frequency = 0;
	   		ListIterator<String> it2 = al3.listIterator(0);  //1,2,3...
	   		while(it2.hasNext()) {
	   			frequency=0;
	   			//System.out.println(2);
	   			String kw2 = it2.next();
	   			ListIterator<String> it31 = al11.listIterator(0);
	   			ListIterator<String> it32 = al12.listIterator(0);
	   			
	   			while(it31.hasNext() && it32.hasNext()) {
	   				String kw31 = it31.next();
	   				String kw32 = it32.next();
	   				if(kw31.contains(";"+kw1+";") && kw32.contains(";"+kw2+";")) {	
			   			//System.out.println(kw1+" "+kw2);
			   			frequency++;		   					   					   		 
				   	}  
	   			}
	   			//System.out.println(kw1+"; "+kw2+";"+keyWords.indexOf(kw2)+"; "+frequency);
	   			if(frequency>0) {
	   				i++;
	   				sql.executeUpdate("insert into cooccurrence"+list1.replace(" ", "")+list2.replace(" ", "")+" values("+i+",'"+kw1+"','"+kw2+"',"+frequency+")");         //改（字符串型加单引号）	   		
	   			}
	   			
	   		}
	   					   		
	   	  }
	  	  System.out.println("table "+list1+"and"+list2+" have finished");
	  	  
	   	  sql.close();
	   	  con.close();
	}
	
	public ArrayList<String> quChong(ArrayList<String> list) {
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
