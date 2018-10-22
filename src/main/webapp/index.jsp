<%-- 
    Document   : index
    Created on : Oct 18, 2018, 9:20:53 PM
    Author     : atomsk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String resultPajaro = "";
    String asd = "";
    if(request.getAttribute("ave1")!=null){
	asd = "asd";
	//resultPajaro = (String)request.getAttribute("ave1");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://fonts.googleapis.com/css?family=Lato|Niramit|Roboto" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<script src="js/ajax.js" type="text/javascript"></script>
        <title>A V E S</title>
    </head>
    <body>
	<section>
	    <h1>AVES</h1>
	    <form action="accesoBD">
		<article>
		    <span>Anilla del ave</span><br><input type="text" name="anilla"><br>
		    <input type="submit" name="opcion" value="Anilla">
		    <input type="submit" name="opcion" value="Todas">
		    <input type="submit" name="opcion" value="Algunas">
		</article>
	    </form>
	</section>
	<%=resultPajaro%>
	<%=asd%>
    </body>
</html>
