package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.DatabaseBean;
import domain.DormInfoBean;

public class FensuInfoModel {
	public ArrayList<DormInfoBean> getDormInfo(String faculty,String department,String classnumber){
		ArrayList<DormInfoBean> al=new ArrayList<DormInfoBean>();
		String sql="select * from dormitoryinfotest,users where users.id=dormitoryinfotest.id ";
		if(!faculty.equals(" ")){
			sql+="and faculty='"+faculty+"' ";
		}
		if(!department.equals(" ")){
			sql+="and department='"+department+"' ";
		}
		if(!classnumber.equals("null")){
			sql+="and classnumber='"+classnumber+"' ";
		}
		sql+="order by dormitorynumber;";
		al=dodatabase(sql);
		return al;
	}
	
	public ArrayList<DormInfoBean> getDormInfo(String dormnumber){
		ArrayList<DormInfoBean> al=new ArrayList<DormInfoBean>();
		String sql="select * from dormitoryinfotest,users where dormitorynumber like '"+dormnumber+"-%' and dormitoryinfotest.id=users.id order by dormitorynumber;";
		al=dodatabase(sql);
		return al;
	}
	
	public ArrayList<DormInfoBean> dodatabase(String sql){
		//System.out.println(sql);
		ArrayList<DormInfoBean> al=new ArrayList<DormInfoBean>();
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
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				DormInfoBean student=new DormInfoBean();
				student.setdormnumber(rs.getString("dormitorynumber"));
				student.setname(rs.getString("name"));
				student.setclassnumber(rs.getString("classnumber"));
				student.setdepartment(rs.getString("department"));
				student.setfaculty(rs.getString("faculty"));
				student.setid(rs.getString("id"));
				student.setsex(rs.getString("sex"));
				student.setqq(rs.getString("qq"));
				student.setphone(rs.getString("phone"));
				al.add(student);
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
		return al;
	}
	
}
