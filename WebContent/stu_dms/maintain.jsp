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
  <script src="../js/show.js"></script>
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
        <span>维修信息</span>
      </a>
      <div class="clearfix"></div>
    </div>
    <div id="maintain">
      <h2>维修情况</h2>
      <div id="maintain-apply" class="table-box">
        <div class="table-title">
          <span class="glyphicon glyphicon-list-alt"></span>
          <h5>维修申请</h5>
        </div>
        <div class="clearfix"></div>
        <div id="mtform">
          <form role="form" method="post" action="MaintainUpdate">
            <div class="formcontrol">
            <h5 class="inputlabel">&nbsp宿舍号:</h5>
            <input type="text" name="dorm" class="inputcontrol" placeholder="xxx 如：748">
            </div>
            <div class="formcontrol">
              <h5 class="inputlabel">预约时间:</h5>
              <input type="text" name="booktime" class="inputcontrol" placeholder="如：2015-07-05">
            </div>
            <div class="formcontrol">
              <h5 class="inputlabel">维修原因:</h5>
              <textarea class="inputcontrol" cols="20" rows="5" name="reason"></textarea>
            </div>
            <div class="formcontrol">
              <button id="submitbtn" role="button" class="btn btn-success">提交</button>
            </div>
          </form>
        </div>
      </div>
      <div id="maintain-history" class="table-box">
        <div class="table-title">
          <span class="glyphicon glyphicon-list-alt"></span>
          <h5>维修历史</h5>
        </div>
        <div class="mttable>">
          <table class="table table-hover">
            <%
            ArrayList res=(ArrayList)request.getAttribute("result");
            for(int i=0;i<res.size();i++){
            	out.println("<tr>");
            	ArrayList temp = (ArrayList)res.get(i);
            	out.println("<td>宿舍："+temp.get(0)+"</td>");
            	out.println("<td>预约时间："+temp.get(1)+"</td>");
            	out.println("<td><button class='btn btn-info btn-xs info "+temp.get(3)+"'>详情</button></td>");
            	out.println("</tr>");
            	out.println("<tr style='display:none' class='"+temp.get(3)+"'>");
            	out.println("<td colspan='3'><b>维修理由："+temp.get(2)+"</b></td>");
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