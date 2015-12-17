$(document).ready(function(){
  function showresult(data){
    $("#visitresult").html(data);
  }

  $(".jqbtn").click(function(){
    $.post("VisitSearch",$("#searchvisit").serialize(),showresult);
  });

});