<%--
  Created by IntelliJ IDEA.
  User: 10192
  Date: 2021-07-31
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
	<script type="text/javascript">
		
		window.onload = function (){
            var imgch = document.getElementById("imgch");
            var change = document.getElementById("change");
            change.onclick =function (){
                var date = new Date().getTime();
                img.src = '/demo05/check'+date;
            }
		}
	</script>
  <body>
	  <img id="imgch" src="check" alt="">
	  <a href="" id="change">看不清换一张？</a>
  </body>
</html>
