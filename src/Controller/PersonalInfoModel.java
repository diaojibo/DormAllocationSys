package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import domain.PersonalInfoBean;

public class PersonalInfoModel {
	
	public ArrayList<PersonalInfoBean> getinfo(String id){
		ArrayList<PersonalInfoBean> personalinfo= new ArrayList<PersonalInfoBean>();
		PersonalInfoBean info = new PersonalInfoBean();
		
		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl="jdbc:sqlserver://localhost:1433;databaseName=dormitory;integratedSecurity=true;";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName(JDriver);
			con = DriverManager.getConnection(connectionUrl);
			//String sql = "select * from users where id='"+id+"' and name='"+username+"';";
			//String sql="select * from users,dormitoryinfotest where users.id='"+id+"' and users.id=dormitoryinfotest.id;";
			String sql="select * from users where id='"+id+"';";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				info.setsex(rs.getString("sex"));
				info.setfaculty(rs.getString("faculty"));
				info.setdepartment(rs.getString("department"));
				info.setclassnumber(rs.getString("classnumber"));
				
			}
			String sql1="select * from dormitoryinfotest where id='"+id+"';";
			rs=stmt.executeQuery(sql1);
			while(rs.next()){
				info.setdormnumber(rs.getString("dormitorynumber"));
			}
			personalinfo.add(info);
			String dormnumber=info.getdormnumber();
			String sql2="select * from dormitoryinfotest,users where dormitorynumber='"+dormnumber+"' and dormitoryinfotest.id=users.id;";
			//System.out.println(sql2);
			rs=stmt.executeQuery(sql2);
			while(rs.next()){
				if(!rs.getString("id").equals(id)){
					PersonalInfoBean roommate = new PersonalInfoBean();
					String name=rs.getString("name");
					roommate.setroommate(name);
					roommate.setfaculty(rs.getString("faculty"));
					roommate.setdepartment(rs.getString("department"));
					roommate.setclassnumber(rs.getString("classnumber"));
					roommate.setqq(rs.getString("qq"));
					roommate.setphone(rs.getString("phone"));
					personalinfo.add(roommate);
				}
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
		return personalinfo;
	}
}
