$(document).ready(function(){
  function showresult(data){
    $("#thingsresult").html(data);
  }

  $(".jqbtn").click(function(){
    $.post("ThingsSearch",$("#searchthings").serialize(),showresult);
  });

});