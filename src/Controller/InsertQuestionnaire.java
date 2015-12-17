package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertQuestionnaire
 */
@WebServlet("/InsertQuestionnaire")
public class InsertQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertQuestionnaire() {
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
//		String zuoxi=request.getParameter("zuoxi");
//		String hzuoxi=request.getParameter("hzuoxi");
//		String dahu=request.getParameter("dahu");
//		String hdahu=request.getParameter("hdahu");
//		String menghua=request.getParameter("menghua");
//		String hmenghua=request.getParameter("hmenghua");
//		String xuexi=request.getParameter("xuexi");
//		String hxuexi=request.getParameter("hxuexi");
//		String youxi=request.getParameter("youxi");
//		String hyouxi=request.getParameter("hyouxi");
//		String yundong=request.getParameter("yundong");
//		String hyundong=request.getParameter("hyundong");
//		String xingge=request.getParameter("xingge");
//		String hxingge=request.getParameter("hxingge");
//		String jiating=request.getParameter("jiating");
//		String hjiating=request.getParameter("hjiating");
//		String waisheng=request.getParameter("waisheng");
//		String hwaisheng=request.getParameter("hwaisheng");
//		String xizao=request.getParameter("xizao");
//		String hxizao=request.getParameter("hxizao");
//		String zhuxiao=request.getParameter("zhuxiao");
//		String hzhuxiao=request.getParameter("hzhuxiao");
//		String paixu=request.getParameter("paixu");
		
		Enumeration rnames =request.getParameterNames();
		Enumeration r=request.getParameterNames();
		int i=0;
		while(r.hasMoreElements()){
		     i++;
		     r.nextElement();
		}
		String[] form=new String[i];
		int j=0;
		for (Enumeration e = rnames ; e.hasMoreElements() ;) {
		         String thisName=e.nextElement().toString();
		        String thisValue=request.getParameter(thisName);
		        //System.out.println(thisName+"-------"+thisValue);
		        form[j]=thisValue;
		        j++;
		}
		HttpSession session = request.getSession(); 
		try{
		String id=session.getAttribute("id").toString();
		boolean res=new InsertQuestionnaireModel().insert(form,id);
		if(res){
			PrintWriter out=response.getWriter();
			out.println("<script>alert('问卷填写成功！')</script>");
			out.println("<script>location.href='welcome.jsp';</script>");
			//request.getRequestDispatcher("questionnaire.jsp").forward(request, response);
			//response.sendRedirect("personalinfo.jsp");
		}else{
			PrintWriter out=response.getWriter();
			out.println("<script>alert('问卷填写失败，请重试')</script>");
			out.println("<script>location.href='questionnaire.jsp';</script>");
			//response.sendRedirect("questionnaire.jsp");
		}
		}catch(Exception ex){
			PrintWriter out=response.getWriter();
			out.println("<script>alert('您未登录！请登录后再提交！')</script>");
			out.println("<script>location.href='login.jsp';</script>");
			//response.sendRedirect("login.jsp");
		}
	}

}
