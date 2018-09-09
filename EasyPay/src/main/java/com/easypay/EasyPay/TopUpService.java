package com.easypay.EasyPay;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("topup")

public class TopUpService {
	@Context
	private ServletContext context;

	@Context
	private HttpServletRequest request;

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	public Response handleDetails(@QueryParam("cardID") String cardID, @QueryParam("username") String username,
			@QueryParam("amount") String amount, @QueryParam("cardHolderName") String name,
			@QueryParam("cardNumber") String number, @QueryParam("expiryMonth") String month,
			@QueryParam("expiryYear") String year, @QueryParam("cvv") String cvv)
			throws ClassNotFoundException, SQLException, MalformedURLException, URISyntaxException {

		// Mock up of credit card payment assuming valid transaction

		request.getSession().setAttribute("name", username);

		Database db = new Database();
		String urlStr;

		if (amount != null && amount != "0") {
			db.updateBalance(username, Double.parseDouble(amount));
			// db.updateBalance(Integer.parseInt(cardID), Double.parseDouble(amount));
			urlStr = "http://localhost:8080/EasyPay" + "/dashboard.jsp" + "?name=" + username;
			
		} else {
			urlStr = "http://localhost:8080/EasyPay" + "/topup.jsp";
		}

		// Encode URL
		URL url = new URL(urlStr);
		URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(),
				url.getQuery(), url.getRef());

		return Response.seeOther(uri).build();

	}
}
