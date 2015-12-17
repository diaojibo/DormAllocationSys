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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

import com.oracle.jrockit.jfr.RequestDelegate;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;

import java.sql.*;

import Model.StudentBean;
import Model.DatabaseBean;
public class LateUpdate extends HttpServlet {
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
			out.println("<script>location.href='../login.jsp';</script>");
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
					//String newdorm
					String newname = (String)req.getParameter("name");
					String stuid = (String)req.getParameter("stuid");
					String newcounsellor = (String)req.getParameter("counsellor");
					String newreason = (String)req.getParameter("reason");
					
					
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
					String newdate = formatter.format(new Date());
					String newtime = formatter2.format(new Date());
					NullPointerException myend=new NullPointerException();
					if(stuid.equals("")) throw myend;
					
					String sql="insert into stay_o_late(stu_id,reason,time,date,counsellor)"
					+" values('"+stuid+"','"+newreason+"','"+newtime+"','"+newdate+"','"+newcounsellor+"');";
					stmt.executeUpdate(sql);
					con.close();
					tool.right("登记成功!");
					//RequestDispatcher rd=req.getRequestDispatcher("MaintainInfo");
					out.println("<script>location.href='late.jsp'</script>");
					//rd.forward(req, resp);
				} catch (Exception e) {
					tool.wrong("登记失败,请检查输入合法性和真实性");
					out.println("<script>location.href='late.jsp'</script>");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
