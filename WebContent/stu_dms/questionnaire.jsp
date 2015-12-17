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
  <title></title>
  <style>
    #sidebar{
    height:3700px;
    }
  </style>
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
        <span>问卷填写</span>
      </a>
      <div class="clearfix"></div>
    </div>

    <div id="questionnaire">
      <h2>填写问卷</h2>
      <div class="alert alert-block alert-box">
        <a href="#" class="close" data-dismiss="alert">×</a>
        <h4>提示</h4>
        <p>请认真作答每一道问题，关乎到您的宿舍分配问题！</p>
      </div>
      <form id="questions" method="post" name="questions">
        <div class="question">
          <p><b>1.您的作息时间</b></p>
          <div class="options">
          <input type="radio" name="schedule" value="0" checked>
          <span>12点前</span>
          </div>
          <div class="options">
          <input type="radio" name="schedule" value="0">
          <span>12点后</span>
          </div>
        </div>
        <div class="question">
          <p><b>2.您希望舍友的作息时间</b></p>
          <div class="options">
          <input type="radio" name="hschedule" value="0" checked>
          <span>12点前</span>
          </div>
          <div class="options">
          <input type="radio" name="hschedule" value="0">
          <span>12点后</span>
          </div>
          <div class="options">
          <input type="radio" name="hschedule" value="0">
          <span>无所谓</span>
          </div>
        </div>
        <div class="question">
          <p><b>3.您睡觉是否打呼</b></p>
          <div class="options">
          <input type="radio" name="snore" value="0" checked>
          <span>是</span>
          </div>
          <div class="options">
          <input type="radio" name="snore" value="0">
          <span>否</span>
          </div>
        </div>
        <div class="question">
          <p><b>4.您希望舍友睡觉是否打呼</b></p>
          <div class="options">
          <input type="radio" name="hsnore" value="0" checked>
          <span>是</span>
          </div>
          <div class="options">
          <input type="radio" name="hsnore" value="0">
          <span>否</span>
          </div>
        </div>
        <div class="question">
          <p><b>5.您睡觉是否说梦话</b></p>
          <div class="options">
          <input type="radio" name="drool" value="0" checked>
          <span>是</span>
          </div>
          <div class="options">
          <input type="radio" name="drool" value="0">
          <span>否</span>
          </div>
        </div>
        <div class="question">
          <p><b>6.您希望舍友睡觉是否说梦话</b></p>
          <div class="options">
          <input type="radio" name="hdrool" value="0" checked>
          <span>是</span>
          </div>
          <div class="options">
          <input type="radio" name="hdrool" value="0">
          <span>否</span>
          </div>
          <div class="options">
          <input type="radio" name="hdrool" value="0">
          <span>无所谓</span>
          </div> 
        </div>
        <div class="question">
          <p><b>7.您在学习上更像学霸还是学渣</b></p>
          <div class="options">
          <input type="radio" name="study" value="0" checked>
          <span>学霸</span>
          </div>
          <div class="options">
          <input type="radio" name="study" value="0">
          <span>学渣</span>
          </div>
        </div>
        <div class="question">
          <p><b>8.您希望舍友是学霸还是学渣</b></p>
          <div class="options">
          <input type="radio" name="hstudy" value="0">
          <span>学霸</span>
          </div>
          <div class="options">
          <input type="radio" name="hstudy" value="0" checked>
          <span>学渣</span>
          </div>
          <div class="options">
          <input type="radio" name="hstudy" value="0">
          <span>无所谓</span>
          </div>
        </div>
        <div class="question">
          <p><b>9.您是否打游戏</b></p>
          <div class="options">
          <input type="radio" name="game" value="0" checked>
          <span>是</span>
          </div>
          <div class="options">
          <input type="radio" name="game" value="0">
          <span>否</span>
          </div>
        </div>
        <div class="question">
          <p><b>10.您希望舍友是否打游戏</b></p>
          <div class="options">
          <input type="radio" name="hgame" value="0" checked>
          <span>是</span>
          </div>
          <div class="options">
          <input type="radio" name="hgame" value="0">
          <span>否</span>
          </div>
          <div class="options">
          <input type="radio" name="hgame" value="0">
          <span>无所谓</span>
          </div>
        </div>
        <div class="question">
          <p><b>11.您经常运动吗</b></p>
          <div class="options">
          <input type="radio" name="sports" value="0" checked>
          <span>是</span>
          </div>
          <div class="options">
          <input type="radio" name="sports" value="0">
          <span>否</span>
          </div>
        </div>
        <div class="question">
          <p><b>12.您希望舍友经常运动吗</b></p>
          <div class="options">
          <input type="radio" name="hsports" value="0" checked>
          <span>是</span>
          </div>
          <div class="options">
          <input type="radio" name="hsports" value="0">
          <span>否</span>
          </div>
          <div class="options">
          <input type="radio" name="hsports" value="0">
          <span>无所谓</span>
          </div>
        </div>
        <div class="question">
          <p><b>13.您的性格</b></p>
          <div class="options">
          <input type="radio" name="character" value="0" checked>
          <span>内向</span>
          </div>
          <div class="options">
          <input type="radio" name="character" value="0">
          <span>外向</span>
          </div>
        </div>
        <div class="question">
          <p><b>14.您希望舍友的性格</b></p>
          <div class="options">
          <input type="radio" name="hcharacter" value="0" checked>
          <span>内向</span>
          </div>
          <div class="options">
          <input type="radio" name="hcharacter" value="0">
          <span>外向</span>
          </div>
          <div class="options">
          <input type="radio" name="hcharacter" value="0">
          <span>无所谓</span>
          </div>
        </div>
        <div class="question">
          <p><b>15.您的生活费</b></p>
          <div class="options">
          <input type="radio" name="expense" value="0" checked>
          <span>1000以下</span>
          </div>
          <div class="options">
          <input type="radio" name="expense" value="0">
          <span>1000~1500(1500请选此项)</span>
          </div>
          <div class="options">
          <input type="radio" name="expense" value="0">
          <span>1500~2000</span>
          </div>
          <div class="options">
          <input type="radio" name="expense" value="0">
          <span>2000以上</span>
          </div>
        </div>
        <div class="question">
          <p><b>16.您希望舍友的生活费</b></p>
          <div class="options">
          <input type="radio" name="hexpense" value="0" checked>
          <span>1000以下</span>
          </div>
          <div class="options">
          <input type="radio" name="hexpense" value="0">
          <span>1000~1500(1500请选此项)</span>
          </div>
          <div class="options">
          <input type="radio" name="hexpense" value="0">
          <span>1500~2000</span>
          </div>
          <div class="options">
          <input type="radio" name="hexpense" value="0">
          <span>2000以上</span>
          </div>
          <div class="options">
          <input type="radio" name="hexpense" value="0">
          <span>无所谓</span>
          </div>
        </div>
        <div class="question">
          <p><b>17.您是否来自广东省外</b></p>
          <div class="options">
          <input type="radio" name="province" value="0" checked>
          <span>是</span>
          </div>
          <div class="options">
          <input type="radio" name="province" value="0">
          <span>否</span>
          </div>
        </div>
        <div class="question">
          <p><b>18.您希望舍友是否为外省</b></p>
          <div class="options">
          <input type="radio" name="hprovince" value="0" checked>
          <span>是</span>
          </div>
          <div class="options">
          <input type="radio" name="hprovince" value="0">
          <span>否</span>
          </div>
          <div class="options">
          <input type="radio" name="hprovince" value="0">
          <span>无所谓</span>
          </div>
        </div>
        <div class="question">
          <p><b>19.您的洗澡频率</b></p>
          <div class="options">
          <input type="radio" name="shower" value="0" checked>
          <span>每天一次</span>
          </div>
          <div class="options">
          <input type="radio" name="shower" value="0">
          <span>并非每天</span>
          </div>
        </div>
        <div class="question">
          <p><b>20.您希望舍友的洗澡频率</b></p>
          <div class="options">
          <input type="radio" name="hshower" value="0" checked>
          <span>每天一次</span>
          </div>
          <div class="options">
          <input type="radio" name="hshower" value="0">
          <span>并非每天</span>
          </div>
          <div class="options">
          <input type="radio" name="hshower" value="0">
          <span>无所谓</span>
          </div>
        </div>
        <div class="question">
          <p><b>21.您曾经住过校吗</b></p>
          <div class="options">
          <input type="radio" name="board" value="0" checked>
          <span>住过</span>
          </div>
          <div class="options">
          <input type="radio" name="board" value="0">
          <span>没住过</span>
          </div>
        </div>
        <div class="question">
          <p><b>22.您希望舍友曾经住过校吗</b></p>
          <div class="options">
          <input type="radio" name="hboard" value="0" checked>
          <span>住过</span>
          </div>
          <div class="options">
          <input type="radio" name="hboard" value="0">
          <span>没住过</span>
          </div>
          <div class="options">
          <input type="radio" name="hboard" value="0">
          <span>无所谓</span>
          </div>
        </div>
        <div class="question">
          <p><b>23.请对以下选项进行您心目中选择舍友的重要性从大到小排序(eg:26354178,不可少填或重复填同一个数字)</b></p>
          <div class="options">
          <span>1.作息</span>
          </div>
          <div class="options">
          <span>2.学习习惯</span>
          </div>
          <div class="options">
          <span>3.课外生活</span>
          </div>
          <div class="options">
          <span>4.性格</span>
          </div>
          <div class="options">
          <span>5.家庭条件</span>
          </div>
          <div class="options">
          <span>6.是否外省</span>
          </div>
          <div class="options">
          <span>7.生活习惯</span>
          </div>
          <div class="options">
          <span>8.住校经历</span>
          </div>
          <div class="options">
          <input type="text">
          </div>
        </div>
        <div>
          <button type="button" id="submit_question" value="提交" onclick="alert('提交成功!!')">提交</button>
        </div>
      </form>
    </div>

    </div>

    </div>

  </div>
  
  <%@ include file="../footer.html" %>
</body>
</html>