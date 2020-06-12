package com.sixtybees.bsb.web;

import java.util.ArrayList;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixtybees.bsb.dao.UserRepository;
import com.sixtybees.bsb.entity.User;

@Service
@Path("/bsb")
public class UserRestController {

	private static final Logger LOG = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	private UserRepository userRepository;

	/**
	 * Retrieve all users
	 * @return
	 */
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveAllUsers() {

		LOG.info("retrieveAllUsers");
		ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
		return Response.ok(UserApiResponse.SUCCESS(users)).build();
	}

	/**
	 * Retrieve user
	 * @param userId
	 * @return
	 */	
	@GET
	@Path("/users/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveUserById(@PathParam("userId") Integer userId) {

		LOG.info("retrieveUserById:" + userId);
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			ArrayList<User> users = new ArrayList<User>();
			users.add(user.get());
			return Response.ok(UserApiResponse.SUCCESS(users)).build();
		} else
			return Response.ok(UserApiResponse.ERROR_USER_NOT_FOUND()).build();
	}

	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerNewUser(UserApiRequest req) {

		LOG.info("registerNewUser");
		User user = req.getUser();
		user.setStatus("P"); // Pending for email confirmation
		User newUser = userRepository.save(user);
		if(newUser != null) {
			return Response.ok(UserApiResponse.SUCCESS()).build();
		}else {
			return Response.ok("Error").build();
		}

	}

	/**
	 * Update user: loginAlias, name, email
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(UserApiRequest req) {

		LOG.info("updateUser");
		Optional<User> user = userRepository.findById(req.getUser().getUserId());
		if (user.isPresent()) {
			User reqUser = req.getUser();
			// update loginAlias
			if (!StringUtils.isEmpty(reqUser.getLoginAlias())) {
				user.get().setLoginAlias(reqUser.getLoginAlias());
			}
			// update name
			if (!StringUtils.isEmpty(reqUser.getName())) {
				user.get().setName(reqUser.getName());
			}
			// update email
			if (!StringUtils.isEmpty(reqUser.getEmail())) {
				user.get().setEmail(reqUser.getEmail());
			}
			userRepository.save(user.get());
			return Response.ok(UserApiResponse.SUCCESS()).build();
		} else
			return Response.ok(UserApiResponse.ERROR_USER_NOT_FOUND()).build();

	}

	@DELETE
	@Path("/user/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUserById(@PathParam("userId") Integer userId) {

		LOG.info("deteleUserById");
		userRepository.deleteById(userId);
		return Response.ok(UserApiResponse.SUCCESS()).build();

	}
}
