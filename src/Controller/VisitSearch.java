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
public class VisitSearch extends HttpServlet {
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
					String fvisitor = (String)req.getParameter("visitor");
					String fvisited = (String)req.getParameter("visited");
					String fdate = (String)req.getParameter("date");
					String sql="select * from visit";
					rs=stmt.executeQuery(sql);
					ArrayList result=new ArrayList();
					while(rs.next()){;
						String stu_id=rs.getString("stu_id");
						String t_visitor=rs.getString("name");
						String t_vid=rs.getString("vid");
					    String t_time = rs.getString("time");
						String sql2="select * from stud_dorm where stu_id='"+stu_id+"'";
						rs2=stmt2.executeQuery(sql2);
						rs2.next();
						String dorm_id=rs2.getString("dorm_id");
						sql2="select * from dorm where dorm_id='"+dorm_id+"'";
						rs2=stmt2.executeQuery(sql2);
						rs2.next();
						String dorm_no=rs2.getString("dorm_no");
						String dorm_building=rs2.getString("dorm_building");
						String t_date=rs.getString("date");
						String dorm=dorm_building+"-"+dorm_no;
						
						sql2="select * from student where id='"+stu_id+"'";
						rs2=stmt2.executeQuery(sql2);
						rs2.next();
						String t_name=rs2.getString("name");
						if(fvisitor!="" && !t_visitor.equals(fvisitor)) continue;
						if(fvisited!="" && !t_name.equals(fvisited)) continue;
						if(fdate!="" && !t_date.equals(fdate)) continue;
						ArrayList t=new ArrayList();
						t.add(dorm);
						t.add(t_visitor);
						t.add(t_vid);
						t.add(t_name);
						t.add(t_date+" "+t_time);
						result.add(t);
					}
					req.setAttribute("result", result);
					con.close();
					//RequestDispatcher rd=req.getRequestDispatcher("maintain.jsp");
					//out.println("<script>location.href='dorm.jsp'</script>");
					//rd.forward(req, resp);
					if(result!=null){
			                for(int i=0;i<result.size();i++){
			                	out.println("<tr>");
			                	ArrayList temp2 = (ArrayList)result.get(i);
			                	out.println("<td>宿舍："+temp2.get(0)+"</td>");
			                	out.println("<td>来访者："+temp2.get(1)+"</td>");
			                	out.println("<td>证件号："+temp2.get(2)+"</td>");
			                	out.println("<td>被访者："+temp2.get(3)+"</td>");
			                	out.println("<td>时间："+temp2.get(4)+"</td>");
			                	out.println("</tr>");
			                }
			            }

					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
