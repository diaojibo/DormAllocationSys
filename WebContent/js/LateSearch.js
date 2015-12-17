$(document).ready(function(){
  function showresult(data){
    $("#lateresult").html(data);
  }

  $(".jqbtn").click(function(){
    $.post("LateSearch",$("#searchlate").serialize(),showresult);
  });

});