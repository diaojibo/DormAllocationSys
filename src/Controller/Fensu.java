package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Fensu
 */
@WebServlet("/Fensu")
public class Fensu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int i=0;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fensu() {
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
	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		boolean ok=new CheckFensuModel().checkfensu();
		if(!ok){
			out.println("<script>alert('您已经完成过分宿')</script>");
			out.println("<script>location.href='distribution.jsp';</script>");
		}else{
			//out.println("<script>alert('为空')</script>");
		  
			Date begin = new Date();
			String facultiessouth[] = {"国际经济贸易学院","国际工商管理学院",
				"财经学院","法学院",
				"英语教育学院","思科信息学院","政治与公共管理学院","新闻与传播学院","艺术学院"};
				String facultiesnorth[] = {"英语语言文化学院","国际商务英语学院",
						"西方语言文化学院","东方语言文化学院","中国语言文化学院",
						"高级翻译学院"};
				FensuModel dm=new FensuModel();
				dm.calsushe(facultiessouth,"south");
				dm.calsushe(facultiesnorth,"north");
				dm.calothers(facultiessouth,"south");
				dm.calothers(facultiesnorth,"north");
				Date finish = new Date();
				long time=finish.getTime()-begin.getTime();
				System.out.println(time);
				out.println("<script>alert('分宿已完成')</script>");	
				out.println("<script>location.href='distribution.jsp';</script>");
				
		}
	}
	

}
