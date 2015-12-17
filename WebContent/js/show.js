$(document).ready(function(){
  $(".info").click(function(){
    var hiddenmsg=$(this).parent().parent().next();
    hiddenmsg.fadeToggle("slow");
  });
});