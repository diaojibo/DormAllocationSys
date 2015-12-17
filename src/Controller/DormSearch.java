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
public class DormSearch extends HttpServlet {
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
					String fdormbuilding = (String)req.getParameter("dormbuilding");
					String fclassname = (String)req.getParameter("classname");
					String fdeptname = (String)req.getParameter("deptname");
					String sql="select * from student where ";
					if(fdeptname=="") fdeptname="'1'='1'";
					else fdeptname="dept='"+fdeptname+"'";
					if(fclassname=="") fclassname="'1'='1'";
					else fclassname="class='"+fclassname+"'";
					sql=sql+fdeptname+"  and "+fclassname;
					rs=stmt.executeQuery(sql);
					ArrayList result=new ArrayList();
					while(rs.next()){;
						String stu_id=rs.getString("id");
						String t_name=rs.getString("name");
						String t_ltel=rs.getString("l_tel");
						String t_stel=rs.getString("s_tel");
						String t_sex=rs.getString("sex");
						String t_class=rs.getString("class");
						String t_deptname=rs.getString("dept");
						String sql2="select * from stud_dorm where stu_id='"+stu_id+"'";
						rs2=stmt2.executeQuery(sql2);
						rs2.next();
						String dorm_id=rs2.getString("dorm_id");
						sql2="select * from dorm where dorm_id='"+dorm_id+"'";
						rs2=stmt2.executeQuery(sql2);
						rs2.next();
						String dorm_no=rs2.getString("dorm_no");
						String dorm_building=rs2.getString("dorm_building");
						if(fdormnum!="" && !dorm_no.equals(fdormnum)) continue;
						if(fdormbuilding!="" && !dorm_building.equals(fdormbuilding)) continue;
						ArrayList t=new ArrayList();
						t.add(stu_id);
						t.add(t_name);
						t.add(t_sex);
						t.add(t_class);
						t.add(t_deptname);
						t.add(dorm_no);
						t.add(t_ltel);
						t.add(t_stel);
						result.add(t);
					}
					req.setAttribute("result", result);
					con.close();
					RequestDispatcher rd=req.getRequestDispatcher("dorm.jsp");
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
