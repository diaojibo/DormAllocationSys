package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertQuestionnaireModel {
	public boolean insert(String[] form,String id){
		boolean ok=true;
		int length=form.length;
		//String[] ans=new String[length-2];
		String sql="insert into information values('"+id+"', '";
		
		for(int i=0;i<length-3;i++){
			sql += form[i]+"', '";
		}
		sql+=form[length-3]+"');";
		System.out.println(sql);
		int info=dodatabase(sql);
		if(info==1){
			int summary=insertimportantpos(form[length-2]);//insert freshman paixu answer
			if(summary==1){
				ok=true;
			}else{
				String sql1="delete from information where id='"+id+"';";
				dodatabase(sql1);
				ok=false;
			}
			
		}else{
			ok=false;
		}
		return ok;
	}
	
	private int insertimportantpos(String paixu){
		int[] ans=new int[paixu.length()];
		//String[] importance=new String[paixu.length()];
		for(int i=0;i<paixu.length();i++){
			//ans[i]=paixu.substring(i, i+1);
			ans[Integer.parseInt(paixu.substring(i, i+1))-1]=8-i;
		}
		
		String sql="insert into qzsummary values('";
		
		for(int i=0;i<ans.length-1;i++){
		sql += ans[i]+"', '";
		}
		sql+=ans[ans.length-1]+"');";
		System.out.println(sql);
		int i=dodatabase(sql);
		return i;
	}
	
	private int dodatabase(String sql){
		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl="jdbc:sqlserver://localhost:1433;databaseName=dormitory;integratedSecurity=true;";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		int i=0;
		try{
			Class.forName(JDriver);
			con = DriverManager.getConnection(connectionUrl);
			stmt=con.createStatement();
			i=stmt.executeUpdate(sql);
//			if(i==1){
//				System.out.println(" "+"插入成功");
//			}else{
//				System.out.print(" "+"插入失败");
//			}
		}catch(Exception ex){
			System.out.println("here has some wrong");
			ex.printStackTrace();
		}finally{
			if (rs != null)    
                try {    
                    rs.close();    
                } catch (Exception e) {    
                }    
            if (stmt != null)    
                try {    
                    stmt.close();    
                } catch (Exception e) {    
                }    
            if (con != null)    
                try {    
                    con.close();    
                } catch (Exception e) {    
                } 
		}
		return i;
	}
}
