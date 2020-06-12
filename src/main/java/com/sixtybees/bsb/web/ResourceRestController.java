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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixtybees.bsb.dao.ResourceRepository;
import com.sixtybees.bsb.entity.Resource;

@Service
@Path("/bsb")
public class ResourceRestController {

	@Autowired
	private ResourceRepository resorceRepository;

	@POST
	@Path("/resource")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createResource(ResourceApiRequest req) {

		resorceRepository.save(req.getResource());
		return Response.ok(ResourceApiResponse.SUCCESS()).build();

	}

	@DELETE
	@Path("/resource/{resourceId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteResource(@PathParam("resourceId") Integer resourceId) {

		resorceRepository.deleteById(resourceId);
		return Response.ok(ResourceApiResponse.SUCCESS()).build();

	}

	@GET
	@Path("/resources/{resourceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveResourceById(@PathParam("resourceId") Integer resourceId) {

		Optional<Resource> resource = resorceRepository.findById(resourceId);
		if (resource.isPresent()) {
			ArrayList<Resource> resources = new ArrayList<Resource>();
			resources.add(resource.get());
			return Response.ok(ResourceApiResponse.SUCCESS(resources)).build();
		}
		return Response.ok(ResourceApiResponse.ERROR_RESOURCE_NOT_FOUND()).build();
	}

	@PUT
	@Path("/resource")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateResource(ResourceApiRequest req) {

		resorceRepository.save(req.getResource());
		return Response.ok(ResourceApiResponse.SUCCESS()).build();

	}
}
