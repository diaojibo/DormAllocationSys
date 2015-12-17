<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta charset="UTF-8">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/frame2.css">
  <script src="../js/distribution.js"></script>
  <script src="../js/jquery-2.1.4.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <title>Distribution</title>

<style type="text/css">
  #distribution{
    float: left;
    width: 900px;
    margin-left: 20px;
  }
  .selectbar{
    width: 230px;
  }
  #content{
    background: white;
  }
  #distributioninfo{
    float: left;
    margin-left:30px;
  }
  #fensuform{
    float: left;
    display: block;
  }
  #searcht1{
    margin-top: 20px;
  }
  #searcht2{
    margin-top: 20px;
  }
  .tll{
    text-align: left;
  }
  .searchbtn{
    width: 40px;
  }
</style>
</head>
<body onLoad="setup()">
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
        <span>Distribution</span>
      </a>
      <div class="clearfix"></div>
    </div>

    <div id="distribution">
       <form action="Fensu" method="POST" id="fensuform">
          <button id="disbtn" type="submit" class="btn btn-info btn-large" onclick="javascript:if(!confirm('确认要进行划分宿舍吗?'))return false">一键分宿</button>
       </form>
       <div class="clearfix"></div>
       <div id="distributioninfo">
          <form action="FensuInfo" method="POST" onsubmit="return checkthree()" name="three">
<table class="table" id="searcht1">
  <tr>
    <th>学院</th>
    <th>专业</th>
    <th>班级</th>
  </tr> 
<tr>
  <td><select name="faculty" id="s1" class="selectbar"> </select> </td>
  <td><select name="department" id="s2" class="selectbar"> </select> </td>
  <td><select name="classnumber" id="s3" class="selectbar"> <option value="null"></option> <option value="1">1</option> <option value="2">2</option> <option value="3">3</option> 
</select> </td>
</tr> 
<tr>
  <td><button type="submit" class="searchbtn">查询</button></td>
  <td></td>
  <td></td>
</tr>
</table>

</form>

<form action="FensuInfo" method="POST" onsubmit="return checkone()" name="one">
<table class="table " id="searcht2">
  <tr>
    <th>宿舍楼号</th>
  </tr> 
<tr>
<td><select name="dorm"> 
<option value="null"></option> 
<option value="1">南校1</option> 
<option value="2">南校2</option> 
<option value="3">南校3</option>
<option value="4">南校4</option> 
<option value="5">南校5</option> 
<option value="6">南校6</option>
<option value="7">南校7</option> 
<option value="8">南校8</option> 
<option value="9">南校9</option>
<option value="10">南校10</option> 
<option value="11">南校11</option> 
<option value="12">南校12</option> 
<option value="13">南校13</option>
<option value="北校1">北校1</option> 
<option value="北校2">北校2</option> 
<option value="北校3">北校3</option>
<option value="北校4">北校4</option> 
<option value="北校5">北校5</option> 
<option value="北校6">北校6</option>
<option value="北校7">北校7</option> 
<option value="北校8">北校8</option> 
<option value="北校9">北校9</option>
</select></td>
</tr> 
<tr>
  <td><button type="submit" class="searchbtn">查询</button></td>
</tr>
</table>
</form>
       </div>
    </div>

  </div>
  
  <%@ include file="../footer.html" %>
</body>
</html>