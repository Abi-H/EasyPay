package com.easypay.EasyPay;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("login")

public class LoginService {
	@Context
	private ServletContext context;
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	
	public Response process(@QueryParam("username") String username, @QueryParam("password") String password)
			throws ClassNotFoundException, SQLException, MalformedURLException, URISyntaxException {
		Database db = new Database();
		URI uri;
		
		System.out.println("Starting LoginService");
		
		if(db.checkCredentials(username, password)) {
			String urlStr = "http://localhost:8080/easypay/" + "dashboard.jsp" + "?name=" + username;
			URL url= new URL(urlStr);			
			uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
		} else {
			System.out.println("Login failure!");
			uri = UriBuilder.fromPath(context.getContextPath() + "/login.jsp").build();
		}
		
		return Response.seeOther(uri).build();
	}
}
