package com.sixtybees.bsb.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sixtybees.bsb.entity.Resource;
import com.sixtybees.bsb.entity.Shop;
import com.sixtybees.bsb.entity.User;

public interface ShopRepository extends CrudRepository<Shop, Integer> {
	
	@Query("select su.shop from ShopUser su where su.user.userId = ?1 and su.role = ?2")
	public ArrayList<Shop> retrieveByUserRole(Integer userId, String role);
	
	@Query("select su.user from ShopUser su where su.shop.shopId = ?1")
	public ArrayList<User> retrieveUsersByShop(Integer shopId);
	
	@Query("select sr.resource from ShopResource sr where sr.shop.shopId = ?1")
	public ArrayList<Resource> retrieveResourcesByShop(Integer shopId);
	
}
