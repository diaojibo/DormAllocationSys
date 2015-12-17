package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;  
import org.apache.poi.hssf.usermodel.HSSFCellStyle;  
import org.apache.poi.hssf.usermodel.HSSFFont;  
import org.apache.poi.hssf.usermodel.HSSFRichTextString;  
import org.apache.poi.hssf.usermodel.HSSFRow;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.hssf.util.HSSFColor;

import domain.DormInfoBean;
/**
 * Servlet implementation class ExcelExport
 */

@WebServlet("/ExcelExport")
public class ExcelExport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelExport() {
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
		HttpSession session=request.getSession();
		String filename=session.getAttribute("filename").toString();
		ArrayList<DormInfoBean> student= new ArrayList<DormInfoBean>();
		student=(ArrayList<DormInfoBean>)session.getAttribute("dormresult");
		
		 response.setContentType("octets/stream");  
		 response.addHeader("Content-Disposition", "attachment;filename="+new String( filename.getBytes("gb2312"), "ISO8859-1" )+".xls");
		 String[] headers = new String[]{"身份证号","姓名","性别","学院","专业","班级","qq号","手机号","宿舍号"};  
	        try {  
	            OutputStream out = response.getOutputStream();  
	            exportExcel(filename,headers, student, out,"yyyy-MM-dd");  
	            out.close();  
	            //System.out.println("excel导出成功！");  
	        } catch (FileNotFoundException e) {  
	                e.printStackTrace();  
	        } catch (IOException e) {  
	                e.printStackTrace();  
	        }  
	}
    /** 
     *  
     * @Description: 生成excel并导出到客户端（本地） 

     */  
    protected void exportExcel(String title,String[] headers,ArrayList<DormInfoBean> student,OutputStream out,String pattern){  
        //声明一个工作簿  
        HSSFWorkbook workbook = new HSSFWorkbook();  
        //生成一个表格  
        HSSFSheet sheet = workbook.createSheet(title);  
        //设置表格默认列宽度为15个字符  
        sheet.setDefaultColumnWidth(20);  
        
        //产生表格标题行  
        HSSFRow row = sheet.createRow(0);  
        for(int i = 0; i<headers.length;i++){  
            HSSFCell cell = row.createCell(i);  
            //cell.setCellStyle(style);  
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);  
            cell.setCellValue(text);  
        }  
        //"身份证号","姓名","性别","学院","专业","班级","qq号","手机号","宿舍号"
        for (int i=0;i<student.size();i++) {  
        	DormInfoBean everystudent = student.get(i);
        	row=sheet.createRow(i+1);
        	int j=0;
        	String id=everystudent.getid();
        	String name=everystudent.getname();
        	String sex=everystudent.getsex();
        	String faculty=everystudent.getfaculty();
        	String department=everystudent.getdepartment();
        	String classnumber=everystudent.getclassnumber();
        	String qq=everystudent.getqq();
        	String phone=everystudent.getphone();
        	String dormnumber=everystudent.getdormnumber();
        	row.createCell(j++).setCellValue(id); 
        	row.createCell(j++).setCellValue(name); 
        	row.createCell(j++).setCellValue(sex); 
        	row.createCell(j++).setCellValue(faculty); 
        	row.createCell(j++).setCellValue(department); 
        	row.createCell(j++).setCellValue(classnumber); 
        	row.createCell(j++).setCellValue(qq); 
        	row.createCell(j++).setCellValue(phone); 
        	row.createCell(j++).setCellValue(dormnumber); 
        }  
        try {  
            workbook.write(out);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  

}
