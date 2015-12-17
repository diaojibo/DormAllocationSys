package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.DatabaseBean;
import domain.PersonalInfoBean;

public class CheckFensuModel {
	public boolean checkfensu(){
		boolean ok=true;
		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl="jdbc:sqlserver://localhost:1433;databaseName=dormitory;integratedSecurity=true;";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url=DatabaseBean.url;
			String dbuser=DatabaseBean.db_user;
			String dbpwd=DatabaseBean.db_pwd;
			con=DriverManager.getConnection(url,dbuser,dbpwd);
			//String sql = "select * from users where id='"+id+"' and name='"+username+"';";
			//String sql="select * from users,dormitoryinfotest where users.id='"+id+"' and users.id=dormitoryinfotest.id;";
			String sql="select * from dormitoryinfotest;";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()){// not empty
				ok=false;
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
		return ok;
	}
}
