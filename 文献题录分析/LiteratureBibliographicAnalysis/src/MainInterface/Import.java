package MainInterface;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Import {	
	String path;
	
	public Import(String filePath){
		path = filePath;
	}
	
	public void imported() throws Exception {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	   	 Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/Database1.mdb");
	   	 Statement sql=con.createStatement();
	     sql.execute("create table CNKI(ID int identity,[Reference Type] varchar(200),Title varchar(200),Author varchar(200),"
	    		+ "[Author Adress] varchar(200),Journal varchar(200),Keywords varchar(200))");   //����
	   	 
		//excel����
	    String [] pathSet = path.split("\n");
	    int z=0;
	   for(int j=0;j<pathSet.length;j++) {
	    	FileInputStream fis = new FileInputStream(pathSet[j]);
			//FileInputStream fis = new FileInputStream("C:\\Users\\87230\\Desktop\\java\\cnki-1.xlsx");
			//�õ�������
			Workbook wb = new XSSFWorkbook(fis);  
			//�õ�һ��������
	       Sheet sheet = wb.getSheetAt(0);        
	       //��ñ�ͷ
	       //Row rowHead = sheet.getRow(0);        
	       //������ݵ�������
	       int totalRowNum = sheet.getLastRowNum();
	       //Ҫ�������
	       String list0 = "";
	       String list1 = "";
	       String list2 = "";
	       String list3 = "";
	       String list4 = "";
	       String list9 = "";
	                      
	      //�������
	       
	       for(int i = 1 ; i <= totalRowNum ; i++)
	       {
	           //��õ�i�ж���
	           Row row = sheet.getRow(i);
	           
	           //��û�õ�i�е�0�е� String���Ͷ���
	           Cell cell0 = row.getCell((short)0);
	           list0 = cell0.getStringCellValue().toString();
	           
	           Cell cell1 = row.getCell((short)1);
	           list1 = cell1.getStringCellValue().toString();
	           
	           Cell cell2 = row.getCell((short)2);
	           list2 = cell2.getStringCellValue().toString();
	           
	           Cell cell3 = row.getCell((short)3);
	           list3 = cell3.getStringCellValue().toString();
	           
	           Cell cell4 = row.getCell((short)4);
	           list4 = cell4.getStringCellValue().toString();

	           Cell cell9 = row.getCell((short)9);
	           list9 = cell9.getStringCellValue().toString();
	           
	           
	           //System.out.println(list1);
	           z++;
	           sql.executeUpdate("insert into CNKI values("+z+",'"+list0+"','"+list1+"','"+list2+"','"+list3+"','"+list4+"','"+list9+"')");
	           
	       }
	       wb.close();
	    }
	   sql.close();  
       con.close();  

	}
	

}
