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
        <span>信件信息</span>
      </a>
      <div class="clearfix"></div>
    </div>
    <div id="postcard">
      <h2>信件信息</h2>
      <div id="postcardbox" class="table-box">
        <div class="table-title">
          <span class="glyphicon glyphicon-list-alt"></span>
          <h5>我的明信片</h5>
        </div>
        <div>
          <h4>已到达明信片</h4>
        </div>
        <div id="postcardtable">
          <table class="table table-bordered table-hover table-striped">
            <tr>
              <td>到达时间</td>
              <td>寄信人</td>
            </tr>
            <%
            ArrayList res=(ArrayList)request.getAttribute("result");
            for(int i=0;i<res.size();i++){
            	out.println("<tr>");
            	ArrayList temp = (ArrayList)res.get(i);
            	out.println("<td>"+temp.get(0)+"</td>");
            	out.println("<td>"+temp.get(1)+"</td>");
            	out.println("</tr>");
            }
            %>
          </table>
        </div>

      </div>
    </div>

    </div>

    </div>

  </div>
  
  <%@ include file="../footer.html" %>
</body>
</html>