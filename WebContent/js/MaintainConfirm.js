$(document).ready(function(){
  $(".confirm").click(function(){
    var parent_tr=$(this).parent().parent();
    var maintainid=parent_tr.attr("id");
    alert(maintainid);
    $.post("MaintainConfirm",{id:maintainid},function(){
      parent_tr.fadeOut(800);
      parent_tr.next().fadeOut(800);
    });

  });
});