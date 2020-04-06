/*package com.web.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@Path ("/test")
public class TestController {

	@Autowired
	private UserService userservice;

	@Autowired
	private ImageUploadService imageService;

	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	@POST
	@Path("/loginTest")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<NewUser> loginTest(UserDetail userdetail) {
		ModelAndView model = new ModelAndView();
		List<NewUser> loginUser = userservice.getUserDetail(userdetail);
		return loginUser;
	}
	
	
	public ResponseBuilder getUserDetail(UserDetail userdetail){
		List<NewUser> loginUser = userservice.getUserDetail(userdetail);
		return Response.ok(loginUser);
	}
	

	@GET
	@Path("/testing")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String testing() {
		return "home";
	}

}
*/