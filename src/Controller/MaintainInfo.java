package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import java.util.ArrayList;

import com.oracle.jrockit.jfr.RequestDelegate;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;

import java.sql.*;

import Model.StudentBean;
import Model.DatabaseBean;
public class MaintainInfo extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Usefulfun tool=new Usefulfun();
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession();
		String user=(String)session.getAttribute("user");
		if (user==null){
			tool.wrong("您尚未登录，请先登录！");
			out.println("<script>location.href='login.jsp';</script>");
		}
		else{
		       
			try {
		    		Connection con=null;
		    		Statement stmt=null,stmt2=null;
		            ResultSet rs=null,rs2=null;
					Class.forName("com.mysql.jdbc.Driver");
					String url=DatabaseBean.url;
					String dbuser=DatabaseBean.db_user;
					String dbpwd=DatabaseBean.db_pwd;
					con=DriverManager.getConnection(url,dbuser,dbpwd);
					stmt=con.createStatement();
					stmt2=con.createStatement();
					String userID=(String)session.getAttribute("user");
					String sql="select * from stud_dorm where stu_id='"+userID+"'";
					rs=stmt.executeQuery(sql);
					rs.next();
					String dorm_id=rs.getString("dorm_id");
					String sql2="select * from dorm where dorm_id='"+dorm_id+"'";
					rs2=stmt2.executeQuery(sql2);
					rs2.next();
					String dormnum=rs2.getString("dorm_no");
					req.setAttribute("dormno", dormnum);
					sql="select * from maintain where dorm_id='"+dorm_id+"'";
					rs=stmt.executeQuery(sql);
					ArrayList result=new ArrayList();
					while(rs.next()){
						ArrayList t=new ArrayList();
						t.add(dormnum);
						t.add(rs.getString("date"));
						t.add(rs.getString("reason"));
						t.add(rs.getString("id"));
						result.add(t);
					}
					req.setAttribute("result", result);
					con.close();
					RequestDispatcher rd=req.getRequestDispatcher("maintain.jsp");
					//out.println("<script>location.href='dorm.jsp'</script>");
					rd.forward(req, resp);
				} catch (Exception e) {
					tool.wrong("qqq");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
