<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/frame2.css">
  <Script src="../js/jquery-2.1.4.min.js"></Script>
  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/VisitSearch.js"></script>
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
        <span>Visit</span>
      </a>
      <div class="clearfix"></div>
    </div>
    <div id="visit">
      <h2>探访登记</h2>
      <div id="submitbox">
        <div id="visitsubmit" class="table-box">
          <div class="table-title">
            <span class="glyphicon glyphicon-list-alt"></span>
            <h5>探访登记</h5>
          </div>

        </div>
        <div id="visitform">
          <form method="post" action="VisitUpdate">
          <div class="inputrow">
            <span><b>宿舍： </b></span>
            <input type="text" name="dormnum" class="smalllen" placeholder="xx-xxx">
            <div class="clearfix"></div>
          </div>
          <div class="inputrow">
            <span><b>来访者： </b></span>
            <input type="text" name="visitor" class="midlen">
            <div class="clearfix"></div>
          </div>
          <div class="inputrow">
            <span><b>证件号： </b></span>
            <input type="text" name="visitorid">
            <div class="clearfix"></div>
          </div>
          <div class="inputrow">
            <span><b>被访者： </b></span>
            <input type="text" name="visited" class="midlen">
            <div class="clearfix"></div>
          </div>
          <div class="inputrow">
            <span><b>日期： </b></span>
            <input type="text" name="date" class="midlen" placeholder="xxxx-xx-xx">
            <div class="clearfix"></div>
          </div>
          <div class="clearfix"></div>
          <div id="submitbtn">
            <button  id="submitbtn" role="button" class="btn btn-success">登记</button>
          </div>
          <div class="clearfix"></div>
          </form>
        </div>
      </div>
      <div id="searchbox">
        <div id="visitsearch" class="table-box">
          <div class="table-title">
            <span class="glyphicon glyphicon-list-alt"></span>
            <h5>探访查询</h5>
          </div>
          <form id="searchvisit" method="post" action="VisitSearch">
          <div id="searchsubmit">
            <div class="inputrow">
              <span><b>按来访姓名查询：</b></span>
              <input type="text" name="visitor"class="len">
              <div class="clearfix"></div>
            </div>
            <div class="inputrow">
              <span><b>按被访姓名查询：</b></span>
              <input type="text" name="visited"class="len">
              <div class="clearfix"></div>
            </div>
            <div class="inputrow">
              <span><b>按来访日期查询：</b></span>
              <input type="text" name="date" class="len" placeholder="xxxx-xx-xx">
              <div class="clearfix"></div>
            </div>
            <div id="submitbtn">
              <button id="submitbtn" role="button" class="btn btn-info jqbtn" type="button">查询</button>
            </div>
          </div>
          </form>
        </div>
      </div>
      <div id="resultbox" class="table-box">
        <div class="table-title">
          <span class="glyphicon glyphicon-list-alt"></span>
          <h5>探访记录</h5>
        </div>
        <div id="resulttable">
          <table class="table table-hover table-condensed" id="visitresult">

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