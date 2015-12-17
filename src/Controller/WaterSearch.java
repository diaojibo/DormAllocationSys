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
public class WaterSearch extends HttpServlet {
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
					String userID=(String)session.getAttribute("user");
					String fdormnum = (String)req.getParameter("dormnum");
					String fordertime = (String)req.getParameter("ordertime");
					String if_finish=(String)req.getParameter("bt");
					String sql="select * from water_order where solve='"+if_finish+"'";
					rs=stmt.executeQuery(sql);
					ArrayList result=new ArrayList();
					while(rs.next()){;
						String dorm_id=rs.getString("dorm_id");
						String waterid=rs.getString("water_id");
					    String t_number = rs.getString("number");
						String sql2="select * from dorm where dorm_id='"+dorm_id+"'";
						rs2=stmt2.executeQuery(sql2);
						rs2.next();
						String dorm_no=rs2.getString("dorm_no");
						String dorm_building=rs2.getString("dorm_building");
						String ordertime=rs.getString("date");
						String dorm=dorm_building+"-"+dorm_no;
						if(fdormnum!="" && !dorm.equals(fdormnum)) continue;
						if(fordertime!="" && !ordertime.equals(fordertime)) continue;
						ArrayList t=new ArrayList();
						t.add(dorm);
						t.add(t_number);
						t.add(ordertime);
						t.add(waterid);
						result.add(t);
					}
					req.setAttribute("result", result);
				    if(if_finish.equals("否")) req.setAttribute("unfinishr", result);
					else {req.setAttribute("finishr", result);}
					con.close();
					//RequestDispatcher rd=req.getRequestDispatcher("maintain.jsp");
					//out.println("<script>location.href='dorm.jsp'</script>");
					//rd.forward(req, resp);
					if(if_finish.equals("是")){
			            if(result!=null){
			                for(int i=0;i<result.size();i++){
			                	out.println("<tr>");
			                	ArrayList temp = (ArrayList)result.get(i);
			                	out.println("<td>宿舍："+temp.get(0)+"</td>");
			                	out.println("<td>数目："+temp.get(1)+"</td>");
			                	out.println("<td>日期："+temp.get(2)+"</td>");
			                	out.println("</tr>");
			                }
			            }
					}
					else{
			            if(result!=null){
			                for(int i=0;i<result.size();i++){
			        
			                	ArrayList temp = (ArrayList)result.get(i);
			                	out.println("<tr id='"+temp.get(3)+"'>");
			                	out.println("<td>宿舍："+temp.get(0)+"</td>");
			                	out.println("<td>数目："+temp.get(1)+"</td>");
			                	out.println("<td>日期："+temp.get(2)+"</td>");
			                	out.println("<td><button role='button' class='btn btn-success btn-xs confirm'>solve</button></td>");
			                	out.println("</tr>");
			                }
			            }
					}
					
				} catch (Exception e) {
					tool.wrong("qqq");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
