package com.sixtybees.bsb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "shop_user")
@XmlRootElement
public class ShopUser {

	@Column(name = "role")
	private String role;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shop_user_pk")
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shop_id")
	@JsonManagedReference
	private Shop shop;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonManagedReference
	private User user;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}


}
