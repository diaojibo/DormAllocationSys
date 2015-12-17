package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;

import java.sql.*;

import Model.StudentBean;

public class LoginCheck extends HttpServlet {

	
	public void wrong(String msg){
		int type=JOptionPane.YES_NO_CANCEL_OPTION;
		JOptionPane.showMessageDialog(null, msg,"发生错误",type);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		String userID=new String(req.getParameter("userID"));
		String pwd=new String(req.getParameter("pwd"));
		if(userID.equals("") || pwd.equals("")){
			wrong("信息不能为空！");
			resp.sendRedirect("login.jsp");
			return;
			
		}
        try {
    		Connection con=null;
    		Statement stmt=null;
            ResultSet rs=null;
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/dms";
			con=DriverManager.getConnection(url,"root","");
			stmt=con.createStatement();
			String identity=req.getParameter("identity");
			if(identity.equals("manager")){
				String msql="select * from adm where adm_id='"+userID+"'";
				rs=stmt.executeQuery(msql);
				if(rs.next()){
					String password=rs.getString("pwd");
					String loginname=rs.getString("name");
					if(password.equals(pwd)){
						HttpSession msession=req.getSession();
						msession.setAttribute("loginname", loginname);
						msession.setAttribute("user", userID);
						con.close();
						out.println("<script>location.href='manager_dms/index.jsp'</script>");
						return;
					}
				}
				wrong("无此用户或者密码不正确！");
				out.println("<script>location.href='login.jsp'</script>");
				return;
			}
			String sql="select * from student where id='"+userID+"'";
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				String id=rs.getString("id");
				String password=rs.getString("pwd");
				String sex=rs.getString("sex");
				String dept=rs.getString("dept");
				String s_tel=rs.getString("s_tel");
				String l_tel=rs.getString("l_tel");
				String name=rs.getString("name");
				
				
				if(pwd.equals(password)){
					StudentBean me=new StudentBean();
					me.setUsername(name);
					me.setDept(dept);
					me.setId(id);
					me.setL_tel(l_tel);
					me.setS_tel(s_tel);
					me.setPwd(pwd);
					me.setSex(sex);
					
					sql="select * from stud_dorm where stu_id='"+id+"'";
					rs=stmt.executeQuery(sql);
					rs.next();
					String dorm_id=rs.getString("dorm_id");
					sql="select * from dorm where dorm_id='"+dorm_id+"'";
					rs=stmt.executeQuery(sql);
					rs.next();
					String dormnum=rs.getString("dorm_no");
					String dormbuilding=rs.getString("dorm_building");
					
					HttpSession session=req.getSession();
					session.setAttribute("login", me);
					session.setAttribute("user", id);
					session.setAttribute("building", dormbuilding);
					session.setAttribute("dromnum", dormnum);
					session.setAttribute("loginname", name);
					con.close();
					out.println("<script>location.href='stu_dms/index.jsp'</script>");
					return;
				}
			}
			wrong("无此用户或者密码不正确！");
			out.println("<script>location.href='login.jsp'</script>");
			
		} catch (Exception e) {
			wrong("数据库连接失败");
			out.println("<script>location.href='login.jsp'</script>");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
