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
  <script src="../js/MaintainSearch.js"></script>
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
    <div id="maintain">
      <h2>维修查询</h2>
      <div id="searchbox">
        <div id="mtsearch" class="table-box">
          <div class="table-title">
            <span class="glyphicon glyphicon-list-alt"></span>
            <h5>维修订单查询</h5>
          </div>

        </div>
        <div id="mtform">
          <form id="searchmaintain" method="post" action="MaintainSearch">
          <div class="inputrow">
            <span><b>按宿舍号查询： </b></span>
            <input type="text" name="dormnum" class="smalllen" placeholder="xx-xxx 如：13-748">
            <div class="clearfix"></div>
          </div>
          <div class="inputrow">
            <span><b>按下单时间查询： </b></span>
            <input type="text" name="ordertime" placeholder="如：2015-07-05">
            <div class="clearfix"></div>
          </div>
          <div class="inputrow">
            <span><b>按预约时间查询： </b></span>
            <input type="text" name="booktime" placeholder="如：2015-07-05">
            <div class="clearfix"></div>
          </div>
          <input name="bt" vlaue="是" id="mysubmit" type="hidden">
          <div id="mtbutton">
            <button id="submitbtn" role="button" class="btn btn-info" value="是" type="button">查询已完成订单</button>
            <button id="submitbtn2" role="button" class="btn btn-warning" value="否" type="button">查询未完成订单</button>
            <div class="clearfix"></div>
          </div>
          <div class="clearfix"></div>
        </div>
        </form>
      </div>
      <div id="mtfinish">
        <div id="finsishbox" class="table-box">
          <div class="table-title">
            <span class="glyphicon glyphicon-list-alt"></span>
            <h5>已完成订单</h5>
          </div>
          <div id="finishtable">
            <table class="table table-hover" id="finishresult">
            </table>
          </div>
        </div>
      </div>
      <div id="mtunfinish">
        <div id="unfinsishbox" class="table-box">
          <div class="table-title">
            <span class="glyphicon glyphicon-list-alt"></span>
            <h5>未完成订单</h5>
          </div>
          <div id="unfinishtable">
            <table class="table table-hover" id="unfinishresult">

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