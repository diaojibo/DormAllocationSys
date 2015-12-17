$(document).ready(function(){
  function showresult1(data){
    $("#finishresult").html(data);
  }
  function showresult2(data){
    $("#unfinishresult").html(data);
  }
  $("#submitbtn").click(function(){
    $("#mysubmit").val("是");
    $.post("MaintainSearch",$("#searchmaintain").serialize(),showresult1);
  });
  $("#submitbtn2").click(function(){
    $("#mysubmit").val("否");
    $.post("MaintainSearch",$("#searchmaintain").serialize(),showresult2);
  });
  $("body").on("click",".info",function(){
    var hiddenmsg=$(this).parent().parent().next();
    hiddenmsg.fadeToggle("slow");
  });
  $("body").on("click",".confirm",function(){
    var parent_tr=$(this).parent().parent();
    var maintainid=parent_tr.attr("id");
    var arg={};
    arg["id"]=maintainid;
    $.post("MaintainConfirm",arg,function(){
      parent_tr.fadeOut(800);
      parent_tr.next().fadeOut(800);
    });
  });
  });