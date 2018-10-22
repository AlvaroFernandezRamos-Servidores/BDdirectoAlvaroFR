<%-- 
    Document   : error
    Created on : Oct 19, 2018, 7:24:29 PM
    Author     : atomsk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://fonts.googleapis.com/css?family=Lato|Niramit|Roboto" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<script src="js/ajax.js" type="text/javascript"></script>
        <title>ERROR</title>
    </head>
    <body>
	<section>
	    <article>
		<H1>ERROR ERROR ERROR ERROR</H1>
		<a href="<%=path%>/index.jsp">Volver</a>
	    </article>
	</section>
    </body>
</html>