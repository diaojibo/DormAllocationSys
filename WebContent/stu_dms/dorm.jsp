<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/frame.css">
  <Script src="../js/jquery-2.1.4.min.js"></Script>
  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/jquery.calendar-widget.js"></script>
  <title></title>
</head>
<body>
  <%@ include file="../header.jsp" %>
  <%@ include file="../sidebar.html" %>
  <div id="content">
    <div id="content-header">
      <a href="index.jsp">
        <span class="glyphicon glyphicon-home"></span>
        <span>Index ></span>
      </a>
      <a>
        <span class="glyphicon glyphicon-sunglasses"></span>
        <span>我的宿舍</span>
      </a>
      <div class="clearfix"></div>
    </div>
<div id="dorm">
      <h2>宿舍信息</h2>
      <div id="dormbox" class="table-box">
        <div class="table-title">
          <span class="glyphicon glyphicon-list-alt"></span>
          <h5>我的宿舍</h5>
        </div>
        <div>
          <h4>宿舍号:<%=(String)request.getAttribute("dormno") %></h4>
        </div>
        <div id="dormtable">
          <table class="table table-bordered table-hover">
            <tr>
              <td>姓名</td>
              <td>学号</td>
              <td>班级</td>
              <td>学院</td>
              <td>长号</td>
              <td>短号</td>
            </tr>
            <%
            ArrayList res=(ArrayList)request.getAttribute("result");
            for(int i=0;i<res.size();i++){
            	out.println("<tr>");
            	ArrayList temp = (ArrayList)res.get(i);
            	for(int j=0;j<temp.size();j++){
            		out.println("<td>");
            		out.println((String)temp.get(j));
            		out.println("</td>");
            	}
            	out.println("</tr>");
            }
            %>
          
          </table>
        </div>

      </div>
    </div>
    </div>

  </div>
  
  <%@ include file="../footer.html" %>
</body>
</html>