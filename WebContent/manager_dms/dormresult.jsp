<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.DormInfoBean" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta charset="UTF-8">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/frame2.css">
  <script src="../js/distribution.js"></script>
  <script src="../js/jquery-2.1.4.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <title>Distribution</title>

<style type="text/css">
  #dormresultbox{
    float: left;
    width: 900px;
    margin-left: 40px;
  }
  #content{
    background: white;
  }
  #dormtable{
    float: left;
    display: block;
  }

</style>
</head>
<body>
  <%
//response.sendRedirect("adminlogin.jsp");
HttpSession hs = request.getSession();
//String id="";
//try{
//id=hs.getAttribute("id").toString();
//System.out.println(id);
//}catch(Exception ex){
//  response.sendRedirect("adminlogin.jsp");
//}

ArrayList<DormInfoBean> student= new ArrayList<DormInfoBean>();
//student=(ArrayList<DormInfoBean>)session.getAttribute("dormresult");
int pageNow = 1;
int pageCount = 0;
try{
  student=(ArrayList<DormInfoBean>)session.getAttribute("dormresult");
String pageNowNum = request.getParameter("pageNow");
if (pageNowNum != null) {
  pageNow = Integer.parseInt(pageNowNum);
}
int yushu=0;
yushu=student.size()%12;
if(yushu!=0){
pageCount=student.size()/12+1;}
else{
  pageCount=student.size()/12;
}
}catch(Exception e){
  response.sendRedirect("../login.jsp");
}
%>
  <%@ include file="../header.jsp" %>
  <%@ include file="../sidebar2.html" %>
  <div id="content">
    <div id="content-header">
      <a>
        <span class="glyphicon glyphicon-home"></span>
        <span>Home ></span>
      </a>
      <a>
        <span class="glyphicon glyphicon-sunglasses"></span>
        <span>Distribution</span>
      </a>
      <div class="clearfix"></div>
    </div>

    <div id="dormresultbox">
      <div id="dormtable">
        <table class="table table-bordered" >
<thead>
  <tr>
    <th>宿舍楼号</th>
    <th>新生名字</th>
  </tr> 
</thead>
<%  
  //System.out.println(pageNow);
  //System.out.println(student.size());
  String dormnumber="";
  for(int i=(pageNow-1)*12;i<pageNow*12;i++){
    try{
    DormInfoBean everystudent=student.get(i);
    if(!dormnumber.equals(everystudent.getdormnumber())){
      dormnumber=everystudent.getdormnumber();
      %>
      <tr>
        <td><%=dormnumber %></td>
        <td><%=everystudent.getname() %></td>
      </tr>
      <%
    }else{
      %>
      <tr>
        <td></td>
        <td><%=everystudent.getname() %></td>
      </tr>
      
      <% 
    }
    }catch(Exception ex){
      break;
    }
  } %>
</table>
<table style="color: #ffffff; float: center" width="750px"
              border="0px" cellpadding="0" align="center">
              <tr>
                
                <td class="col-md-5 column" style="text-align: center;">
                  </div> <%
                          if (pageNow != 1) {
                            //first page
                            out.println("<a href=dormresult.jsp?pageNow=1 class='btn btn-primary'>首页</a>&nbsp;");
                          }
                          //prev
                          if (pageNow != 1) {
                            out.println("<a href=dormresult.jsp?pageNow="
                                + (pageNow - 1) + " class='btn btn-primary'>上一页</a>");
                          }
                          for (int i = pageNow; i < pageNow + 3; i++) {
                            if (i > pageCount) {
                              break;
                            }
                            out.println("<a href=dormresult.jsp?pageNow=" + i + ">["
                                + i + "] </a>");
                          }
                          if (pageNow != pageCount) {
                            out.println("<a href=dormresult.jsp?pageNow="
                                + (pageNow + 1) + " class='btn btn-primary'>下一页</a>");
                          }
                          if (pageNow != pageCount) {
                            out.println("&nbsp;<a href=dormresult.jsp?pageNow="
                                + pageCount + " class='btn btn-primary'>尾页</a>");
                          }
                     %>


                  </div>
                </td>
                <td class="col-md-2 column" style="text-align: center;"></td>
              </tr>
            </table>

            <form action="ExcelExport" method="POST" >
<div>
<button type="submit" class="btn btn-primary">导出至excel</button>
</div>
</form>


      </div>
    </div>

  </div>
  
  <%@ include file="../footer.html" %>
</body>
</html>