package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class AdminCheckLogin
 */
@WebServlet("/AdminCheckLogin")
public class AdminCheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("userid");
		boolean res=new AdminCheckLoginModel().checklogin(id);
		if(res){
			HttpSession session=request.getSession(true);
			session.setAttribute("id",id);
			response.sendRedirect("adminwelcome.jsp");
			//request.getRequestDispatcher("questionnaire.jsp").forward(request, response);
		}else{
			PrintWriter out=response.getWriter();
			out.println("<script>alert('用户名不正确')</script>");
			out.println("<script>location.href='adminlogin.jsp';</script>");
		}
	}

}
