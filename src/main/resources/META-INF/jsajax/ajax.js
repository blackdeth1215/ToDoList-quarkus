$(document).ready(function (e){
   $('#ad').click(function (e){
      e.preventDefault();
      let action ='datos guardados:';
      let tit=$("#tit").text();
      let des=$("#des").text();
      let tip=$("#tip").text();
      $.ajax({
         url:"",
         type: "POST",
         async: true,
         data: { action: action,tit:tit,des:des,tip:tip},
         success: function (response) {
            alert(action+tit+"/"+des+"/"+tip);
         }
      })
   });
});