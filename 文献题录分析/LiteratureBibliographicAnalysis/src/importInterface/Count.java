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
	      //sql.execute("create table ke(ID int identity,key varchar(160),frequency int)");   //����
	   	  
	   	  ResultSet rs=sql.executeQuery("select * from CNKI");
	   	 
	   	  ArrayList<String> temp = new ArrayList<String>();
	      ArrayList<String> result = new ArrayList<String>();
	   	  
	      //��CNKI���е�Keywords���ݴ��������temp�У�
	   	  while(rs.next()) {
	   		  String temp1 = rs.getString(list);                //��
	   		  
	   		  if(temp1!=null) {	   			
	   			  String [] temp2 = temp1.split(";+");		
	   			  
		   		  for(String j:temp2) {  //j�������е�ÿһ��ֵ
		   			  temp.add(j);
		   		  } 
	   		  }  	 
	   	  }
	   	  
	   	  result = quChong(temp);  //ȥ��
	   	  list = list.replace(" ", "");

	   	  //�����������ݵ������ݿ�                                                                                                                    ��
	   	  sql.execute("create table frequency"+list+"(ID int identity,"+list+" varchar(200),frequency int)");   //����
	   	  
	   	  //ID+�ؼ���+��Ƶ
	   	  int i = 1;  //j�ؼ���Ƶ
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

	   		sql.executeUpdate("insert into frequency"+list+" values("+i+",'"+str+"',"+j+")");         //��
	   		i++;
	   		
	   	  }
	  	  System.out.println("table "+list+" have finished");
	   	  sql.close();
	   	  con.close();
	}
	//ȥ��
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
