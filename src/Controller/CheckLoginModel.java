package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckLoginModel {
	
	public boolean checklogin(String id,String username){
		boolean res=true;
		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl="jdbc:sqlserver://localhost:1433;databaseName=dormitory;integratedSecurity=true;";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName(JDriver);
			con = DriverManager.getConnection(connectionUrl);
			//String sql="SELECT TOP  500 [id] FROM users WHERE users.id NOT IN(SELECT id FROM dormitoryinfo);";
			String sql = "select * from users where id='"+id+"' and name='"+username+"';";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				res= true;
			}
			else{ 
				res= false;
			}
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

        return res;
	}
}
