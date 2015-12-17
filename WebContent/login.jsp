<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery-2.1.4.min.js"></script>
  <Script src="js/bootstrap.min.js"></Script>
  <link rel="stylesheet" href="css/login.css">
  <title></title>
</head>
<body>
  <div id="loginbox">
    <form id="loginform" action="LoginCheck" method="post">
      <div id="logo" class="control_group">
        <img src="image/logo.png" alt="logo">
      </div>
      <div class="control_group">
        <div class="inputbox input-group">
          <span class="input-group-addon bg_lg">
            <i class="glyphicon glyphicon-user icons"></i>
          </span>
          <input id="user_input" name="userID" type="text" placeholder="UserID" class="form-control">
        </div>
      </div>
      <div class="control_group">
        <div class="inputbox input-group">
          <span class="input-group-addon bg_ly">
            <i class="glyphicon glyphicon-lock icons"></i>
          </span>
          <input id="user_pwd" name="pwd" type="password" placeholder="Password" class="form-control">
        </div>
      </div>
      <div class="clearfix"></div>
      <div class="control_group">
        <div class="clearfix"></div>
        <div id="radiobox" class="myleft">
          <div class="clearfix"></div>
          <input type="radio" name="identity" value="student" checked="checked"><span>学生&nbsp&nbsp&nbsp&nbsp</span>
          <input type="radio" name="identity" value="manager"><span>宿管</span>
        </div>

        <button id="loginbutton" role="button" class="btn btn-success myleft">Login</button>
        <div class="clearfix"></div>
      </div>
    </form>

  </div>
</body>
</html>