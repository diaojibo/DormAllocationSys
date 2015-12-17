<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
      <div class="clearfix"></div>
    </div>
    <div id="main_content">
  <div id="indexcalendar">
  <div id="calendar">
  <script>
  var myDate = new Date();
  var myyear;
  myyear = myDate.getFullYear();    //获取完整的年份(4位,1970-????)
  var mymonth = myDate.getMonth();
  $("#calendar").calendarWidget({
  month: mymonth,
  year: myyear
  });
  </script>
  </div>
  </div>
    </div>

  </div>
  
  <%@ include file="../footer.html" %>
</body>
</html>