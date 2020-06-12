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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixtybees.bsb.dao.ShopRepository;
import com.sixtybees.bsb.entity.Resource;
import com.sixtybees.bsb.entity.Shop;
import com.sixtybees.bsb.entity.User;

@Service
@Path("/bsb")
public class ShopRestController {

	private static final Logger LOG = LoggerFactory.getLogger(ShopRestController.class);
	
	@Autowired
	private ShopRepository shopRepository;

	@POST
	@Path("/shop")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createShop(ShopApiRequest req) {

		LOG.info("createShop");		
		shopRepository.save(req.getShop());
		return Response.ok(ShopApiResponse.SUCCESS()).build();

	}

	@DELETE
	@Path("/shop/{shopId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteShopById(@PathParam("shopId") Integer shopId) {

		LOG.info("deleteShopById: " + shopId);
		shopRepository.deleteById(shopId);
		return Response.ok(ShopApiResponse.SUCCESS()).build();

	}

	@GET
	@Path("/shops")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveAllShops() {

		LOG.info("retrieveAllShops");
		ArrayList<Shop> shops = (ArrayList<Shop>) shopRepository.findAll();
		return Response.ok(ShopApiResponse.SUCCESS(shops)).build();
	}

	@GET
	@Path("/shops/{shopId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveShopById(@PathParam("shopId") Integer shopId) {

		LOG.info("retrieveShopById: " + shopId);
		Optional<Shop> shop = shopRepository.findById(shopId);
		if(shop.isPresent()) {
			ArrayList<Shop> shops = new ArrayList<Shop>();
			shops.add(shop.get());
			return Response.ok(ShopApiResponse.SUCCESS(shops)).build();			
		}
		return Response.ok(ShopApiResponse.SUCCESS()).build();
	}

	@GET
	@Path("/users/{userId}/shops")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveShopsByUser(@PathParam("userId") Integer userId) {

		LOG.info("retrieveShopsByUser: " + userId);
		ArrayList<Shop> shops = shopRepository.retrieveByUserRole(userId, "O");		
		return Response.ok(ShopApiResponse.SUCCESS(shops)).build();
	}

	@GET
	@Path("/shops/{shopId}/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveShopUsers(@PathParam("shopId") Integer shopId) {

		LOG.info("retrieveShopUsers: " + shopId);
		ArrayList<User> users = shopRepository.retrieveUsersByShop(shopId);
		return Response.ok(UserApiResponse.SUCCESS(users)).build();
	}

	@GET
	@Path("/shops/{shopId}/resources")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveShopResources(@PathParam("shopId") Integer shopId) {

		LOG.info("retrieveShopResources: " + shopId);
		ArrayList<Resource> resources = shopRepository.retrieveResourcesByShop(shopId);
		return Response.ok(ResourceApiResponse.SUCCESS(resources)).build();
	}

	@PUT
	@Path("/shop")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateShop(ShopApiRequest req) {

		shopRepository.save(req.getShop());
		return Response.ok(ShopApiResponse.SUCCESS()).build();

	}

}
