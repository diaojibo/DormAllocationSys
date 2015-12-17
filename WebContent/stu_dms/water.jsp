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
        <span>订水信息</span>
      </a>
      <div class="clearfix"></div>
    </div>
    <div id="water">
      <h2>订水情况</h2>
      <div id="water-apply" class="table-box">
        <div class="table-title">
          <span class="glyphicon glyphicon-list-alt"></span>
          <h5>订水申请</h5>
        </div>
        <div class="clearfix"></div>
        <div id="wtform">
          <form role="form" method="post" action="WaterUpdate">
            <div class="formcontrol">
              <h5 class="inputlabel">宿舍号:</h5>
              <input type="text" name="mydorm" class="inputcontrol" placeholder="xx-xxx 如：13-748">
            </div>
            <div class="formcontrol">
              <h5 class="inputlabel">订水数:</h5>
              <input type="text" name="wtnum" class="inputcontrol shortlen">
            </div>
            <div class="formcontrol">
              <button id="submitbtn" role="button" class="btn btn-success">确认</button>
            </div>
          </form>
        </div>
      </div>
      <div id="water-history" class="table-box">
        <div class="table-title">
          <span class="glyphicon glyphicon-list-alt"></span>
          <h5>订水历史</h5>
        </div>
        <div class="wttable>">
          <table class="table table-hover">
            <%
            ArrayList res=(ArrayList)request.getAttribute("result");
            for(int i=0;i<res.size();i++){
            	out.println("<tr>");
            	ArrayList temp = (ArrayList)res.get(i);
            	out.println("<td>宿舍："+temp.get(0)+"</td>");
            	out.println("<td>订水数目："+temp.get(1)+"</td>");
            	out.println("<td>日期："+temp.get(2)+"</td>");
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