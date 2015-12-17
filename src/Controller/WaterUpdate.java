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
import java.util.Date;
import java.text.SimpleDateFormat;

import com.oracle.jrockit.jfr.RequestDelegate;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;

import java.sql.*;

import Model.StudentBean;
import Model.DatabaseBean;
public class WaterUpdate extends HttpServlet {
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
					String dormbuilding=(String)session.getAttribute("building");
					//String newdorm
					String newdormnum = (String)req.getParameter("mydorm");
					String newnum = (String)req.getParameter("wtnum");
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String newdate = formatter.format(new Date());
					String sql2="select * from dorm where dorm_no='"+newdormnum+"'"
							+" and dorm_building='"+dormbuilding+"'";
					rs2=stmt2.executeQuery(sql2);
					rs2.next();
					String dormid=rs2.getString("dorm_id");
					//String sql="select * from stud_post where stu_id='"+userID+"'";
//					String sql="insert into maintain set dorm_id='"+dormid+"',"+
//					"set book_time='"+newbooktime+"',"+"set reason='"+newreason+"',"+
//					"set date='"+newdate+"',"+"set solve=''";
					String sql="insert into water_order(dorm_id,number,date,solve)"
					+" values('"+dormid+"','"+newnum+"','"+newdate+"','否');";
					
					stmt.executeUpdate(sql);
					con.close();
					RequestDispatcher rd=req.getRequestDispatcher("WaterInfo");
					//out.println("<script>location.href='dorm.jsp'</script>");
					rd.forward(req, resp);
				} catch (Exception e) {
					tool.wrong("数据库连接失败亦或输入不合法");
					RequestDispatcher rd=req.getRequestDispatcher("WaterInfo");
					rd.forward(req, resp);
					e.printStackTrace();
				}
		}
	}

}
