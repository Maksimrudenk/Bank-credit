package com.bank.rest;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bank.testdata.TestUser;


@Path("/service")
@Singleton
public class Service {
	private static final String UTF_8 = "utf-8";
	
	@GET
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	@Path("/info")
	public Response ready() {

		return Response.ok().encoding(UTF_8)
				.entity("Project bank-credit v1.0")
				.type(MediaType.TEXT_HTML)
				.build();
	}
	
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user")
	public String equipment() {	
	//public void equipment() {	
	return new TestUser().getTestUsers();
		//new TestUser().getTestUsers();
	}
	

}
