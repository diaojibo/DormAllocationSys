<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Model.StudentBean" %>
<%
  
  //StudentBean st=(StudentBean)session.getAttribute("login");
  String myname=(String)session.getAttribute("loginname");
%>
<div id="header">
  <div id="headerbox">
    <div id="logo">
      <a href="index.jsp"><img src="../image/logo.png"></a>
    </div>
    <div id="welcome">
      <i class="glyphicon glyphicon-user"></i>
      <span><%=myname %>,欢迎您</span>
    </div>
  </div>
</div>
<div class="clearfix"></div>