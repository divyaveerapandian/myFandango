package com.divya.myfandangoo.http;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divya.myfandangoo.entity.User;
import com.divya.myfandangoo.entity.impl.UserImpl;
import com.divya.myfandangoo.http.entity.HttpUser;
import com.divya.myfandangoo.service.LoginService;

@Path("/users")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
public class UserResource {


	@Autowired
	private LoginService loginService;
	
//	@GET
//	public HttpUser getUsers(){
//		UserImpl user = new UserImpl();
//		user.setUserID(1);
//		user.setUserName("xyz");
//		user.setPassword("aaa");
//		HttpUser httpUser = new HttpUser(user);
//		return  httpUser ;
//	}
	@POST
	public Response createUser(HttpUser newUser){
		if(newUser.userName==null || newUser.password==null){
			return Response.status(Status.BAD_REQUEST).build();
		}
		User userToCreate = convert(newUser);
		int addedUser = loginService.createNewUser(userToCreate);
		return Response.status(Status.CREATED).header("Location", "/users/"+addedUser).build();
	}
	
	@POST
	@Path("/verify")
	public Response userAuthentication(HttpUser httpUser) {
		String userName = httpUser.userName;
		String password = httpUser.password;
		String result =loginService.userAuthentication(userName, password);
		if(result.equals("Failure")){
			return Response.status(Status.UNAUTHORIZED).header("Location", "/users/"+ result).build();
		}
		return Response.status(Status.OK).header("Location", "/users/"+ result).build();
	}
	
//	@POST
//	@Path("/verify")
//	public Response userAuthentication(@FormParam("userName") String uName,
//			@FormParam("password") String pwd) {
//		String userName = uName;
//		String password = pwd;
//		String result =loginService.userAuthentication(userName, password);
//		if(result.equals("Failure")){
//			return Response.status(Status.UNAUTHORIZED).header("Location", "/users/"+ result).build();
//		}
//		return Response.status(Status.OK).header("Location", "/users/"+ result).build();
//	}

	@POST
	@Path("/reset")
	public Response resetPassword(HttpUser httpUser) {
		try{
		User user = convert(httpUser);
		loginService.resetPassword(user);
		}catch(Exception e){
			return Response.status(Status.UNAUTHORIZED).header("Location", "/users/Unauthorised").build();
		}
		return Response.status(Status.OK).header("Location", "/users/OK").build();
	}

	private User convert(HttpUser httpUser) {
		UserImpl user = new UserImpl();
		user.setUserName(httpUser.userName);
		user.setPassword(httpUser.password);
		user.setUserID(httpUser.userID);
		return user;
	}
	
}
