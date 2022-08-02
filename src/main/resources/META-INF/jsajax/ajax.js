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
   $('#el').click(function (e){
      e.preventDefault();
      let action ='datos Eliminados:';
      let tit=$("#tt").text();
      let des=$("#dt").text();
      let tip=$("#et").text();
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
   $("#tt").blur(function (){
      let tit=$(this).text();
      let action="se modifico el dato:";
      $.ajax({
         url:"",
         type: "POST",
         async: true,
         data: { action: action,tit:tit},
         success: function (response) {
            alert(action+tit);
         }
      })
   });
   $("#dt").blur(function (){
      let dt=$(this).text();
      let action="se modifico el dato:";
      $.ajax({
         url:"",
         type: "POST",
         async: true,
         data: { action: action,dt:dt},
         success: function (response) {
            alert(action+dt);
         }
      })
   });
   $("#et").blur(function (){
      let et=$(this).text();
      let action="se modifico el dato:";
      $.ajax({
         url:"",
         type: "POST",
         async: true,
         data: { action: action,et:et},
         success: function (response) {
            alert(action+et);
         }
      })
   });
   $("#tb").keyup(function (e){
      e.preventDefault();
      let action="Se busco el dato";
      let dat=$(this).val();
      $.ajax({
         url:"",
         type: "POST",
         async: true,
         data: { action: action,dat:dat},
         success: function (response) {
            alert(action+"//"+dat);
         }
      })
   });

});