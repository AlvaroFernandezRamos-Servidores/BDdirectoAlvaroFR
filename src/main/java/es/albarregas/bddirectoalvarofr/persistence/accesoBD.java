/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.bddirectoalvarofr.persistence;

import es.albarregas.bddirectoalvarofr.models.DBConnector;
import es.albarregas.bddirectoalvarofr.beans.Ave;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "accesoBD", urlPatterns = {"/accesoBD"})
public class accesoBD extends HttpServlet {
    
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Connection con = null;
	PreparedStatement leerAves = null;
	ResultSet resultado = null;
	ArrayList<Ave> aves;
	String targetLocation = "";
	boolean error = false;
	try {
	    con = DBConnector.conectar();
	    String opcion = req.getParameter("opcion");
	    switch(opcion){
		case"Anilla":
		    leerAves = con.prepareStatement("SELECT * FROM aves WHERE anilla = ?;");
		    leerAves.setString(1,req.getParameter("anilla"));
		    targetLocation = "/JSP/unRegistro.jsp";break;
		case"Algunas":
		    try{
			Integer.parseInt(req.getParameter("anilla"));
		    }catch(NumberFormatException e){
			targetLocation = "/JSP/error.jsp";
			error=true;
			break;
		    }
		    leerAves = con.prepareStatement("SELECT * FROM aves ORDER BY RAND() LIMIT ?;");
		    leerAves.setInt(1, Integer.parseInt(req.getParameter("anilla")));
		    targetLocation = "/JSP/variosRegistros.jsp";
		    break;
		case"Todas":
		    leerAves = con.prepareStatement("SELECT * FROM aves;");
		    targetLocation = "/JSP/variosRegistros.jsp";
		    break;
		default:
		    targetLocation = "index.jsp";
		    break;
	    }
	    
	    if(!error){
		aves = new ArrayList();
		resultado = leerAves.executeQuery();
		while(resultado.next()){
		    Ave ave = new Ave();
		    ave.setAnilla(resultado.getString("anilla"));
		    ave.setEspecie(resultado.getString("especie"));
		    ave.setLugar(resultado.getString("lugar"));
		    ave.setFecha(resultado.getString("fecha"));
		    aves.add(ave);
		}
		req.setAttribute("aves",aves);
	    }	    
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(accesoBD.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SQLException ex) {
	    Logger.getLogger(accesoBD.class.getName()).log(Level.SEVERE, null, ex);
	}finally{
	    try {
		if(!error){
		    resultado.close();
		    con.close();
		}
	    } catch (SQLException ex) {
		Logger.getLogger(accesoBD.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	req.getRequestDispatcher(targetLocation).forward(req,resp);
    }

}
