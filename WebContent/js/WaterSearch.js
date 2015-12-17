$(document).ready(function(){
  function showresult1(data){
    $("#finishresult").html(data);
  }
  function showresult2(data){
    $("#unfinishresult").html(data);
  }
  $("#submitbtn1").click(function(){
    $("#mysubmit").val("是");
    $.post("WaterSearch",$("#searchwt").serialize(),showresult1);
  });
  $("#submitbtn2").click(function(){
    $("#mysubmit").val("否");
    $.post("WaterSearch",$("#searchwt").serialize(),showresult2);
  });
  $("body").on("click",".confirm",function(){
    var parent_tr=$(this).parent().parent();
    var waterid=parent_tr.attr("id");
    var arg={};
    arg["id"]=waterid;
    $.post("WaterConfirm",arg,function(){
      parent_tr.fadeOut(800);
    });
  });
});