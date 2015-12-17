package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.DormInfoBean;
/**
 * Servlet implementation class FensuInfo
 */
@WebServlet("/FensuInfo")
public class FensuInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FensuInfo() {
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
		request.setCharacterEncoding("utf-8");
		String faculty=request.getParameter("faculty");
		String department=request.getParameter("department");
		String classnumber=request.getParameter("classnumber");
		String dormnumber=request.getParameter("dorm");
		//System.out.print(faculty+" "+department+" "+classnumber);
		ArrayList<DormInfoBean> al=new ArrayList<DormInfoBean>();
		String excelname="";
		if(dormnumber==null){
			al=new FensuInfoModel().getDormInfo(faculty, department, classnumber);
			//excelname=faculty+"-"+department+"-"+classnumber+"班新生分宿情况表";
			if(!faculty.equals(" ")){
				excelname+=faculty;
			}
			if(!department.equals(" ")){
				excelname+="-"+department;
			}
			if(!classnumber.equals("null")){
				excelname+="-"+classnumber+"班";
			}
			excelname+="新生分宿情况表";
		}
		else{
			al=new FensuInfoModel().getDormInfo(dormnumber);
			excelname=dormnumber+"栋新生分宿情况";
		}
		
		HttpSession session=request.getSession(true);
		session.setAttribute("dormresult",al);
		session.setAttribute("filename", excelname);
		response.sendRedirect("dormresult.jsp");
	}

}
