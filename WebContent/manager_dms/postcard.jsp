<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/frame2.css">
  <Script src="../js/jquery-2.1.4.min.js"></Script>
  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/PostcardSearch.js"></script>
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
        <span>Maintain</span>
      </a>
      <div class="clearfix"></div>
    </div>
    <div id="postcard">
      <h2>明信片登记</h2>
      <div id="submitbox">
        <div id="postcardsubmit" class="table-box">
          <div class="table-title">
            <span class="glyphicon glyphicon-list-alt"></span>
            <h5>明信片登记</h5>
          </div>

        </div>
        <div id="postcardform">
        <form method="post" action="PostcardUpdate">
          <div class="inputrow">
            <span><b>宿舍： </b></span>
            <input type="text" name="dormnum" class="midlen" placeholder="xx-xxx">
            <div class="clearfix"></div>
          </div>
          <div class="inputrow">
            <span><b>收件人： </b></span>
            <input type="text" name="name" class="midlen">
            <div class="clearfix"></div>
          </div>
          <div class="inputrow">
            <span><b>寄信人： </b></span>
            <input type="text" name="sendname" class="midlen">
            <div class="clearfix"></div>
          </div>
          <div class="inputrow">
            <span><b>日期： </b></span>
            <input type="text" name="date" placeholder="xxxx-xx-xx">
            <div class="clearfix"></div>
          </div>
          <div class="clearfix"></div>
          <div id="submitbtn">
            <button id="submitbtn" role="button" class="btn btn-success">登记</button>
          </div>
          <div class="clearfix"></div>
        </form>
        </div>
      </div>
      <div id="searchbox">
        <div id="postcardsearch" class="table-box">
          <div class="table-title">
            <span class="glyphicon glyphicon-list-alt"></span>
            <h5>记录查询</h5>
          </div>
          <div id="searchsubmit">
          <form id="searchpostcard">
            <div class="inputrow">
              <span><b>按宿舍号查询：</b></span>
              <input type="text" name="dormnum"class="len" placeholder="xx-xxx 如：13-748">
              <div class="clearfix"></div>
            </div>
            <div class="inputrow">
              <span><b>按收件人查询：</b></span>
              <input type="text" name="name"class="len">
              <div class="clearfix"></div>
            </div>
            <div class="inputrow">
              <span><b>按日期查询：</b></span>
              <input type="text" name="date" class="len" placeholder="xxxx-xx-xx">
              <div class="clearfix"></div>
            </div>
            <div id="submitbtn">
              <button id="submitbtn" role="button" class="btn btn-info jqbtn" type="button">查询</button>
            </div>
           </form>
          </div>
        </div>
      </div>
      <div id="resultbox" class="table-box">
        <div class="table-title">
          <span class="glyphicon glyphicon-list-alt"></span>
          <h5>明信片记录</h5>
        </div>
        <div id="resulttable">
          <table class="table table-hover" id="postcardresult">


          </table>
          <div class="clearfix"></div>
        </div>
      </div>
    </div>
    </div>
    </div>
    </div>

  </div>
  
  <%@ include file="../footer.html" %>
</body>
</html>