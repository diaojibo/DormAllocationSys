<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/frame2.css">
  <Script src="../js/jquery-2.1.4.min.js"></Script>
  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/jquery.calendar-widget.js"></script>
  <title></title>
</head>
<body>
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
        <span>Dorm</span>
      </a>
      <div class="clearfix"></div>
    </div>
    <div id="dorm">
      <h2>宿舍查询</h2>
      <div id="dorm-search" class="table-box">
        <div class="table-title">
          <span class="glyphicon glyphicon-list-alt"></span>
          <h5>宿舍查询</h5>
        </div>
        <div class="clearfix"></div>
        <div id="dormform">
          <form role="form" method="post" action="DormSearch">
            <div class="formcontrol">
              <h5 class="inputlabel">宿舍:</h5>
              <input type="text" name="dormnum" class="inputcontrol" placeholder="xxx 如：748">
            </div>
            <div class="formcontrol">
              <h5 class="inputlabel">楼号:</h5>
              <input type="text" name="dormbuilding" class="inputcontrol" placeholder="xx 如：13">
            </div>
            <div class="formcontrol">
              <h5 class="inputlabel">班级:</h5>
              <input type="text" name="classname" class="inputcontrol" placeholder="如：计算机7班">
            </div>
            <div class="formcontrol">
              <h5 class="inputlabel">学院:</h5>
              <input type="text" name="deptname" class="inputcontrol"placeholder="如：思科信息学院">
            </div>
            <div class="formcontrol">
              <button id="submitbtn" role="button" class="btn btn-primary">查询</button>
            </div>
          </form>
        </div>
      </div>
      <div id="dorm-result" class="table-box">
        <div class="table-title">
          <span class="glyphicon glyphicon-list-alt"></span>
          <h5>查询结果</h5>
        </div>
        <div class="dmtable">
          <table class="table table-hover">
            <tr>
              <td>学号</td>
              <td>姓名</td>
              <td>性别</td>
              <td>班级</td>
              <td>学院</td>
              <td>宿舍</td>
              <td>长号</td>
              <td>短号</td>
            </tr>
            <%
            ArrayList res=(ArrayList)request.getAttribute("result");
            if(res!=null){
                for(int i=0;i<res.size();i++){
                	out.println("<tr>");
                	ArrayList temp = (ArrayList)res.get(i);
                	out.println("<td>"+temp.get(0)+"</td>");
                	out.println("<td>"+temp.get(1)+"</td>");
                	out.println("<td>"+temp.get(2)+"</td>");
                	out.println("<td>"+temp.get(3)+"</td>");
                	out.println("<td>"+temp.get(4)+"</td>");
                	out.println("<td>"+temp.get(5)+"</td>");
                	out.println("<td>"+temp.get(6)+"</td>");
                	out.println("<td>"+temp.get(7)+"</td>");
                	out.println("</tr>");
                }
            }
            %>
          </table>
        </div>
      </div>
    </div>

  </div>
  
  <%@ include file="../footer.html" %>
</body>
</html>