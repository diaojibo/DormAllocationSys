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
public class PostcardUpdate extends HttpServlet {
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
					String newsendname = (String)req.getParameter("sendname");
					String newdormnum=(String)req.getParameter("dormnum");
		            String newdate=(String)req.getParameter("date");
					String dormpattern="(\\d{2})(-)(\\d{3})";
					Pattern r=Pattern.compile(dormpattern);
					Matcher m=r.matcher(newdormnum);
					if(!m.find()){
						tool.wrong("宿舍号码输入有误！请输入: 楼号-宿舍号");
						out.println("<script>location.href='postcard.jsp';</script>");
						return;
					}
					String newdormbuilding=m.group(1);
					String newdormno=m.group(3);
					
					String sql2="select * from dorm where dorm_no='"+newdormno+"'"
							+" and dorm_building='"+newdormbuilding+"'";
					rs2=stmt2.executeQuery(sql2);
					rs2.next();
					String dormid=rs2.getString("dorm_id");
					sql2="select * from stud_dorm where dorm_id='"+dormid+"'";
					rs2=stmt2.executeQuery(sql2);
					String stuid="";
					while(rs2.next()){
						String tid=rs2.getString("stu_id");
						String tsql="select * from student where id='"+tid+"'"
								+" and name='"+newname+"'";
						rs=stmt.executeQuery(tsql);
						if(rs.next()) stuid=tid;
					}
					
					NullPointerException myend=new NullPointerException();
					if(stuid.equals("")) throw myend;
					
					String sql="insert into stud_post(stu_id,date,send_name)"
					+" values('"+stuid+"','"+newdate+"','"+newsendname+"');";
					stmt.executeUpdate(sql);
					con.close();
					tool.right("登记成功!");
					//RequestDispatcher rd=req.getRequestDispatcher("MaintainInfo");
					out.println("<script>location.href='postcard.jsp'</script>");
					//rd.forward(req, resp);
				} catch (Exception e) {
					tool.wrong("登记失败,请检查输入合法性和真实性");
					out.println("<script>location.href='postcard.jsp'</script>");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
