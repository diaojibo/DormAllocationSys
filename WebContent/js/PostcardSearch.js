$(document).ready(function(){
  function showresult(data){
    $("#postcardresult").html(data);
  }

  $(".jqbtn").click(function(){
    $.post("PostcardSearch",$("#searchpostcard").serialize(),showresult);
  });

});