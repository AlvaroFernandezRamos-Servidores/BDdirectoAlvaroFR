<%-- 
    Document   : variosRegistros
    Created on : Oct 19, 2018, 7:24:19 PM
    Author     : atomsk
--%>

<%@page import="java.util.Iterator"%>
<%@page import="es.albarregas.bddirectoalvarofr.beans.Ave"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Ave> aves = (ArrayList) request.getAttribute("aves");
    Iterator<Ave> iterador = aves.iterator();
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://fonts.googleapis.com/css?family=Lato|Niramit|Roboto" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<script src="js/ajax.js" type="text/javascript"></script>
        <title>VISUALIZACION DE VARIOS ELEMENTOS</title>
    </head>
    <body>
	<section>
	    <%
		if(!iterador.hasNext()){
	    %>
	    <span>No existen resultados con esa anilla</span>    
	    <%
		}else{
		    while (iterador.hasNext()) {
			Ave ave = iterador.next();
	    %>
	    <article>
	    <span>Anilla :<%=ave.getAnilla()%></span><br>
	    <span>Especie :<%=ave.getEspecie()%></span><br>
	    <span>Lugar :<%=ave.getLugar()%></span><br>
	    <span>Fecha :<%=ave.getFecha()%></span><br>
	    </article>
	    <%
		    }
		}
	    %>
	    <a href="<%=path%>/index.jsp">Volver</a>
	</section>
    </body>
</html>
