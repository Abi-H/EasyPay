package com.easypay.EasyPay;

import java.net.URI;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("register")
public class RegisterService {
	@Context
	private ServletContext context;

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	public Response process(@QueryParam("email") String email, @QueryParam("cardID") int cardID,
			@QueryParam("password") String password) {

		try {
			Database db = new Database();
			db.addUser(cardID, email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		URI uri = UriBuilder.fromPath(context.getContextPath() + "/login.jsp").build();
		return Response.seeOther(uri).build();		
	}
}
